package com.example.form;

public class ResultForm {
	Integer staffId;

	public Integer getStaffId() {
		return staffId;
	}

	public ResultForm(Integer staffId) {
		super();
		this.staffId = staffId;
	}

	public void setStaffId(Integer userId) {
		this.staffId = userId;
	}

	@Override
	public String toString() {
		return "ResultCriteria [staffId=" + staffId + "]";
	}	
}
