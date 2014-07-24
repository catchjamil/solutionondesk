package com.sd.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ItemMaster")
public class ItemMaster implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer Id;
	@Column
	private String customerName ;
	
	@Column
	private Double totalAmount;
	
	@Column
	private String itemAction;
	
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
	@Column
	private String address;
	
	@Column
	private String quationSlipPath;

	
	public String getItemAction() {
		return itemAction;
	}
	public void setItemAction(String itemAction) {
		this.itemAction = itemAction;
	}
	@Column
	private String contactNo;
	@OneToMany(cascade={CascadeType.ALL})
	private List<Item> items;
	
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
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
