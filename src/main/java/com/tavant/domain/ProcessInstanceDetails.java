package com.tavant.domain;

import java.util.Date;

public class ProcessInstanceDetails {
	
	  Integer pri_id; 
	  Integer app_id;
	  Integer tsk_id;
	  Integer usr_id;
	  Integer prc_id;
	  Integer next_task_id;
	  Date tsk_start_dt;
	  Date prc_start_dt;
	
	 public ProcessInstanceDetails() {
		// TODO Auto-generated constructor stub
	}

	  
	  public ProcessInstanceDetails(Integer pri_id, Integer app_id,
			Integer tsk_id, Integer usr_id, Integer prc_id,
			Integer next_task_id, Date tsk_start_dt, Date prc_start_dt) {
		super();
		this.pri_id = pri_id;
		this.app_id = app_id;
		this.tsk_id = tsk_id;
		this.usr_id = usr_id;
		this.prc_id = prc_id;
		this.next_task_id = next_task_id;
		this.tsk_start_dt = tsk_start_dt;
		this.prc_start_dt = prc_start_dt;
	}


	public Integer getPri_id() {
		return pri_id;
	}


	public void setPri_id(Integer pri_id) {
		this.pri_id = pri_id;
	}


	public Integer getApp_id() {
		return app_id;
	}


	public void setApp_id(Integer app_id) {
		this.app_id = app_id;
	}


	public Integer getTsk_id() {
		return tsk_id;
	}


	public void setTsk_id(Integer tsk_id) {
		this.tsk_id = tsk_id;
	}


	public Integer getUsr_id() {
		return usr_id;
	}


	public void setUsr_id(Integer usr_id) {
		this.usr_id = usr_id;
	}


	public Integer getPrc_id() {
		return prc_id;
	}


	public void setPrc_id(Integer prc_id) {
		this.prc_id = prc_id;
	}


	public Integer getNext_task_id() {
		return next_task_id;
	}


	public void setNext_task_id(Integer next_task_id) {
		this.next_task_id = next_task_id;
	}


	public Date getTsk_start_dt() {
		return tsk_start_dt;
	}


	public void setTsk_start_dt(Date tsk_start_dt) {
		this.tsk_start_dt = tsk_start_dt;
	}


	public Date getPrc_start_dt() {
		return prc_start_dt;
	}


	public void setPrc_start_dt(Date prc_start_dt) {
		this.prc_start_dt = prc_start_dt;
	}
	  
	  	
}
