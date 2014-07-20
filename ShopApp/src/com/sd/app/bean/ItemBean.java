package com.sd.app.bean;


public class ItemBean {
	private Integer id;
	private String name ;
	private String height;
	private String width;
	private String thikness;
	private String buyFrom;
	private String quantity;
	private String price;
	private String description;

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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