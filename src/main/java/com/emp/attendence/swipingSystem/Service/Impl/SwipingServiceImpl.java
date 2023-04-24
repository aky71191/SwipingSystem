package com.emp.attendence.swipingSystem.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.attendence.swipingSystem.Dto.SwipingRequestDto;
import com.emp.attendence.swipingSystem.Entity.SwipeDto;
import com.emp.attendence.swipingSystem.Service.SwipingService;
import com.emp.attendence.swipingSystem.db.service.SwipingDBService;

@Service
public class SwipingServiceImpl implements SwipingService{

	@Autowired
	private SwipingDBService swipingDBService;
	
	@Override
	public void processSwipeRequest(SwipingRequestDto request) {
		SwipeDto swipeDto = new SwipeDto();
		swipeDto.setEmpId(request.getEmpId());
		swipeDto.setSwipingTime(request.getSwipeTime());
		swipeDto.setActionType(request.getActionType());
		swipingDBService.save(swipeDto);
	}

}
