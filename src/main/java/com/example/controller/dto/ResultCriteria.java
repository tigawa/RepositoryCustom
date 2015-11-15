package com.example.controller.dto;

public class ResultCriteria {
	Integer staffId;

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer userId) {
		this.staffId = userId;
	}

	@Override
	public String toString() {
		return "ResultCriteria [staffId=" + staffId + "]";
	}	
}
