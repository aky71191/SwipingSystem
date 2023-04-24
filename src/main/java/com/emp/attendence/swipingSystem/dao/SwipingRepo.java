package com.emp.attendence.swipingSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emp.attendence.swipingSystem.Entity.SwipeDto;

@Repository
public interface SwipingRepo extends JpaRepository<SwipeDto, Integer>{
	
	@Query(value="select EMPLOYEE_ID ,min(SWIPE_IN_OUT_TIME), action_type from SWIPE_IN_OUT where ACTION_TYPE=\"IN\" group by EMPLOYEE_ID", nativeQuery = true)
	public List<SwipeDto> getInTime();
	
	@Query(value="select EMPLOYEE_ID ,max(SWIPE_IN_OUT_TIME), action_type from SWIPE_IN_OUT where ACTION_TYPE=\"OUT\" group by EMPLOYEE_ID", nativeQuery = true)
	public List<SwipeDto> getOutTime();
	
}
