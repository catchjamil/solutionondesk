package com.sd.app.bean.masters;

// Generated Nov 22, 2014 1:22:06 PM by Hibernate Tools 3.4.0.CR1

/**
 * UomId generated by hbm2java
 */
public class UomId implements java.io.Serializable {

	private String name;
	private Short srNo;
	private Integer idNo;

	public UomId() {
	}

	public UomId(String name, Short srNo, Integer idNo) {
		this.name = name;
		this.srNo = srNo;
		this.idNo = idNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getSrNo() {
		return this.srNo;
	}

	public void setSrNo(Short srNo) {
		this.srNo = srNo;
	}

	public Integer getIdNo() {
		return this.idNo;
	}

	public void setIdNo(Integer idNo) {
		this.idNo = idNo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UomId))
			return false;
		UomId castOther = (UomId) other;

		return ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null && this.getName().equals(
				castOther.getName())))
				&& ((this.getSrNo() == castOther.getSrNo()) || (this.getSrNo() != null && castOther.getSrNo() != null && this.getSrNo().equals(
						castOther.getSrNo())))
				&& ((this.getIdNo() == castOther.getIdNo()) || (this.getIdNo() != null && castOther.getIdNo() != null && this.getIdNo().equals(
						castOther.getIdNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result + (getSrNo() == null ? 0 : this.getSrNo().hashCode());
		result = 37 * result + (getIdNo() == null ? 0 : this.getIdNo().hashCode());
		return result;
	}

}