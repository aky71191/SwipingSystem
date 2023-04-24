package com.emp.attendence.swipingSystem.db.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.attendence.swipingSystem.Entity.SwipeDto;
import com.emp.attendence.swipingSystem.dao.SwipingRepo;
import com.emp.attendence.swipingSystem.db.service.SwipingDBService;

@Service
public class SwipingDBServiceImpl implements SwipingDBService{

	@Autowired
	private SwipingRepo swipingRepo;
	
	@Override
	public void save(SwipeDto swipeDto) {
		swipingRepo.save(swipeDto);
	}
	
	@Override
	public List<SwipeDto> getEmpInTime() {
		return swipingRepo.getInTime();
	}
	
	@Override
	public List<SwipeDto> getEmpOutTime() {
		return swipingRepo.getOutTime();
	}

}
