package com.sd.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

@Entity
@Table(name="ItemMaster")
public class ItemMaster implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	protected Integer id;
	@Column
	protected String createdBy;
	@Column
	protected Date createdOn = new Date();
	@Column
	protected String modifiedBy;
	@Column
	protected Date modifiedOn = new Date();
	@Column
	protected String status;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	
	
	@Column
	private String customerName ;
	@Column
	private String itemAction;
	@Column
	private String address;
	@Column
	private String quationSlipPath;
	@Column
	private String contactNo;
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER )
	private List<Item> items;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQuationSlipPath() {
		return quationSlipPath;
	}
	public void setQuationSlipPath(String quationSlipPath) {
		this.quationSlipPath = quationSlipPath;
	}
	
	public String getItemAction() {
		return itemAction;
	}
	public void setItemAction(String itemAction) {
		this.itemAction = itemAction;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
