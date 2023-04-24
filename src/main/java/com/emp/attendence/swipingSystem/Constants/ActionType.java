package com.emp.attendence.swipingSystem.Constants;

public enum ActionType {
	SWIPE_IN("IN"), SWIPE_OUT("OUT");
	
	private String actionType;

	ActionType(String actionType) {
		this.actionType = actionType;
	}
	
	public String getActionType() {
		return actionType;
	}
}
