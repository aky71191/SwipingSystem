package com.emp.attendence.swipingSystem.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.attendence.swipingSystem.Dto.SwipingRequestDto;
import com.emp.attendence.swipingSystem.Service.SwipingService;

@RestController
//@RequestMapping("/")
public class SwipingController {
	
	@Autowired
	private SwipingService swipingService;
	
	@PostMapping("/swipe")
	public ResponseEntity<HttpStatus> swipInOut(@RequestBody SwipingRequestDto request) {
		swipingService.processSwipeRequest(request);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("/geting")
	public String getResponse() {
		return "Hi There";
	}
}
