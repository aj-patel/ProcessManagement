package com.tavant.domain;

import java.sql.Date;

public class TaskDetails {

	private String taskId;
	
	private String taskName;
	
	private String status;
	
	private String step;
	
	private Date startDate;
	
	private Date endDate;
	
	public TaskDetails() {
		// TODO Auto-generated constructor stub
	}
	

	public TaskDetails(String taskId, String taskName, String status,
			String step, Date startDate, Date endDate) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.status = status;
		this.step = step;
		this.startDate = startDate;
		this.endDate = endDate;
	}



	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
}
