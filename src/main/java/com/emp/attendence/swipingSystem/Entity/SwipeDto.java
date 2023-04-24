package com.emp.attendence.swipingSystem.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="SWIPE_IN_OUT")
@Data
public class SwipeDto {
	
	@Id
	@GeneratedValue
	int id;
	@Column(name = "EMPLOYEE_ID")
	String empId;
	@Column(name = "SWIPE_IN_OUT_TIME")
	Date swipingTime;
	@Column(name = "ACTION_TYPE")
	String actionType;
}
