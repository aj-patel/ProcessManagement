package com.tavant.domain;

public class TaskProgressDetails {
	
	String tName;
	String comment;
	String step;
	
	public TaskProgressDetails(String tName, String comment, String step) {
		super();
		this.tName = tName;
		this.comment = comment;
		this.step = step;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}
	
	
	
}
