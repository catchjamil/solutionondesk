package com.sd.web.model.bo;

import java.io.Serializable;
import java.util.Date;

public class BaseBO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8139546341360852511L;
	private Long id;
	private Long createdBy;
	private Date createdOn;
	private Long modifiedBy;
	private Date modifiedOn;
	private String action;

	public String getAction() {
		return action;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Long getId() {
		return id;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

}
