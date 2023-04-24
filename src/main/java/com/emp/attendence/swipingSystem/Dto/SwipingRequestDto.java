package com.emp.attendence.swipingSystem.Dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SwipingRequestDto {
	private String empId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date swipeTime;
	private String actionType;
	
}
