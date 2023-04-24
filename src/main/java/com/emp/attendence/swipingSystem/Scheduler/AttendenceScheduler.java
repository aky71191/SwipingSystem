package com.emp.attendence.swipingSystem.Scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.emp.attendence.swipingSystem.Dto.AttendenceMessage;
import com.emp.attendence.swipingSystem.Entity.SwipeDto;
import com.emp.attendence.swipingSystem.Service.Impl.KafkaProducerService;
import com.emp.attendence.swipingSystem.db.service.SwipingDBService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AttendenceScheduler {

	@Autowired
	SwipingDBService swipingDBService;
	
	@Autowired
	KafkaProducerService kafkaProducerService;

	@Scheduled(cron = "0 0 0 ? * MON-FRI *")
	public void runTask() {
		this.process();
	}

	private void process() {
		List<SwipeDto> empInTimeList = swipingDBService.getEmpInTime();
		List<SwipeDto> empOutTimeList = swipingDBService.getEmpOutTime();

		empInTimeList.stream().forEach(swipeInDto -> {
			String empId = swipeInDto.getEmpId();
			Date inTime = swipeInDto.getSwipingTime();
			Optional<SwipeDto> swipeOutDtoOptional = empOutTimeList.stream()
					.filter(swipeOutDto -> empId.equalsIgnoreCase(swipeOutDto.getEmpId())).findFirst();
			if (swipeOutDtoOptional.isPresent()) {
				Date outTime = swipeOutDtoOptional.get().getSwipingTime();
				long timeDiff = outTime.getTime() - inTime.getTime();
				// Convert milliseconds to hours
				double totalHours = (double) timeDiff / (1000 * 60 * 60);
				AttendenceMessage attendenceMsg = new AttendenceMessage();
				attendenceMsg.setEmpId(empId);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String formattedDate = sdf.format(outTime);
				attendenceMsg.setAttendenceDate(formattedDate);
				attendenceMsg.setTotalHours(totalHours);
				ObjectMapper objectMapper = new ObjectMapper();
				try {
					String msg = objectMapper.writeValueAsString(attendenceMsg);
					kafkaProducerService.sendMessage(msg);
				} catch (JsonProcessingException e) {

				}

			}
		});
	}

}