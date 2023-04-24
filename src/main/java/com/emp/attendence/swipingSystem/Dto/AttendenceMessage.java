package com.emp.attendence.swipingSystem.Dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AttendenceMessage implements Serializable{
	
	private static final long serialVersionUID = 862396101705702803L;
	
	private String empId;
	private String attendenceDate;
	private double totalHours;

}
