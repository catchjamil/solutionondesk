package com.sd.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee  implements Serializable{

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
	@Column
	private Long contactNo;
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	
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


	
	
	@Column(name="empname")
	private String empName;
	
	@Column(name="empaddress")
	private String empAddress;
	
	@Column(name="salary")
	private Long salary;
	
	@Column(name="empAge")
	private Integer empAge;


	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Integer getEmpAge() {
		return empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}

}
