package com.tavant.domain;


public class TaskDetails {
	
	private int taskId;
	
	private int processId;
	
	private String taskName;
	
	private String taskDescription;
	
	private int nextStep;
	
	private int startOrend;
	
	public TaskDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public TaskDetails(int taskId, int processId, String taskName,
			String taskDescription, int nextStep, int startOrend) {
		super();
		this.taskId = taskId;
		this.processId = processId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.nextStep = nextStep;
		this.startOrend = startOrend;
	}



	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public int getNextStep() {
		return nextStep;
	}

	public void setNextStep(int nextStep) {
		this.nextStep = nextStep;
	}

	public int getStartOrend() {
		return startOrend;
	}

	public void setStartOrend(int startOrend) {
		this.startOrend = startOrend;
	}
	
	
	
	
}
