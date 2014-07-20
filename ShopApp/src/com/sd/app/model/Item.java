package com.sd.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Items")
public class Item implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer Id;
	@Column
	private String name ;
	@Column
	private String height;
	@Column
	private String width;
	@Column
	private String thikness;
	@Column
	private String buyFrom;
	@Column
	private String quantity;
	
	@Column
	private Double price;
	
	@Column
	private Double subTotal;
	
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Column
	private String description;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getThikness() {
		return thikness;
	}
	public void setThikness(String thikness) {
		this.thikness = thikness;
	}
	public String getBuyFrom() {
		return buyFrom;
	}
	public void setBuyFrom(String buyFrom) {
		this.buyFrom = buyFrom;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	

}
