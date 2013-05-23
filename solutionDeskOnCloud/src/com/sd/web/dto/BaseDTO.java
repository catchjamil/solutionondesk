package com.sd.web.dto;

import java.util.Date;

public class BaseDTO {

	private Long id;
	private Long createdBy;
	
	private Date createdOn;
	private String modifiedBy;
	private Date modifiedOn;
	private String action;
	public Long getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public String getAction() {
		return action;
	}



	public Date getCreatedOn() {
		return createdOn;
	}

	public Long getId() {
		return id;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setAction(String action) {
		this.action = action;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

}
