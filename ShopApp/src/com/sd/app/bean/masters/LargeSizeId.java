package com.sd.app.bean.masters;

// Generated Nov 22, 2014 1:22:06 PM by Hibernate Tools 3.4.0.CR1

/**
 * LargeSizeId generated by hbm2java
 */
public class LargeSizeId implements java.io.Serializable {

	private String type;
	private Float area;
	private Float size;

	public LargeSizeId() {
	}

	public LargeSizeId(String type, Float area, Float size) {
		this.type = type;
		this.area = area;
		this.size = size;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getArea() {
		return this.area;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	public Float getSize() {
		return this.size;
	}

	public void setSize(Float size) {
		this.size = size;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LargeSizeId))
			return false;
		LargeSizeId castOther = (LargeSizeId) other;

		return ((this.getType() == castOther.getType()) || (this.getType() != null && castOther.getType() != null && this.getType().equals(
				castOther.getType())))
				&& ((this.getArea() == castOther.getArea()) || (this.getArea() != null && castOther.getArea() != null && this.getArea().equals(
						castOther.getArea())))
				&& ((this.getSize() == castOther.getSize()) || (this.getSize() != null && castOther.getSize() != null && this.getSize().equals(
						castOther.getSize())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getType() == null ? 0 : this.getType().hashCode());
		result = 37 * result + (getArea() == null ? 0 : this.getArea().hashCode());
		result = 37 * result + (getSize() == null ? 0 : this.getSize().hashCode());
		return result;
	}

}
