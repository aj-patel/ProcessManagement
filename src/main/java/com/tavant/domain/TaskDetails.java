package com.tavant.domain;


public class TaskDetails {
	
	
	  private Integer tsk_id;
	  private Integer prc_id;
	  private String tsk_name;
	  private String tsk_desc;
	  private Integer next_task_id;
	  private Integer srt_and_end;
	
	  
	  
	  
	  public TaskDetails() {
		super();
	}


	public TaskDetails(Integer tsk_id, Integer prc_id, String tsk_name,
			String tsk_desc, Integer next_task_id, Integer srt_and_end) {
		super();
		this.tsk_id = tsk_id;
		this.prc_id = prc_id;
		this.tsk_name = tsk_name;
		this.tsk_desc = tsk_desc;
		this.next_task_id = next_task_id;
		this.srt_and_end = srt_and_end;
	}


	public Integer getTsk_id() {
		return tsk_id;
	}


	public void setTsk_id(Integer tsk_id) {
		this.tsk_id = tsk_id;
	}


	public Integer getPrc_id() {
		return prc_id;
	}


	public void setPrc_id(Integer prc_id) {
		this.prc_id = prc_id;
	}


	public String getTsk_name() {
		return tsk_name;
	}


	public void setTsk_name(String tsk_name) {
		this.tsk_name = tsk_name;
	}


	public String getTsk_desc() {
		return tsk_desc;
	}


	public void setTsk_desc(String tsk_desc) {
		this.tsk_desc = tsk_desc;
	}


	public Integer getNext_task_id() {
		return next_task_id;
	}


	public void setNext_task_id(Integer next_task_id) {
		this.next_task_id = next_task_id;
	}


	public Integer getSrt_and_end() {
		return srt_and_end;
	}


	public void setSrt_and_end(Integer srt_and_end) {
		this.srt_and_end = srt_and_end;
	}
	
}
