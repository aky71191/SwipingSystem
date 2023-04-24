package com.emp.attendence.swipingSystem.db.service;

import java.util.List;

import com.emp.attendence.swipingSystem.Entity.SwipeDto;

public interface SwipingDBService {

	public void save(SwipeDto swipeDto);

	List<SwipeDto> getEmpInTime();

	List<SwipeDto> getEmpOutTime();
}
