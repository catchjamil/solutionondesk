package com.sd.app.bean.masters;

// Generated Nov 22, 2014 1:22:06 PM by Hibernate Tools 3.4.0.CR1

/**
 * MastersId generated by hbm2java
 */
public class MastersId implements java.io.Serializable {

	private Integer idNo;
	private String master;
	private Integer code;
	private String strCode;
	private String name;
	private String otherCode;
	private Integer classIdNo;
	private Short srNo;
	private String flat;
	private String tsd;

	public MastersId() {
	}

	public MastersId(Integer idNo, String master, Integer code, String strCode, String name, String otherCode, Integer classIdNo, Short srNo,
			String flat, String tsd) {
		this.idNo = idNo;
		this.master = master;
		this.code = code;
		this.strCode = strCode;
		this.name = name;
		this.otherCode = otherCode;
		this.classIdNo = classIdNo;
		this.srNo = srNo;
		this.flat = flat;
		this.tsd = tsd;
	}

	public Integer getIdNo() {
		return this.idNo;
	}

	public void setIdNo(Integer idNo) {
		this.idNo = idNo;
	}

	public String getMaster() {
		return this.master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getStrCode() {
		return this.strCode;
	}

	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOtherCode() {
		return this.otherCode;
	}

	public void setOtherCode(String otherCode) {
		this.otherCode = otherCode;
	}

	public Integer getClassIdNo() {
		return this.classIdNo;
	}

	public void setClassIdNo(Integer classIdNo) {
		this.classIdNo = classIdNo;
	}

	public Short getSrNo() {
		return this.srNo;
	}

	public void setSrNo(Short srNo) {
		this.srNo = srNo;
	}

	public String getFlat() {
		return this.flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public String getTsd() {
		return this.tsd;
	}

	public void setTsd(String tsd) {
		this.tsd = tsd;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MastersId))
			return false;
		MastersId castOther = (MastersId) other;

		return ((this.getIdNo() == castOther.getIdNo()) || (this.getIdNo() != null && castOther.getIdNo() != null && this.getIdNo().equals(
				castOther.getIdNo())))
				&& ((this.getMaster() == castOther.getMaster()) || (this.getMaster() != null && castOther.getMaster() != null && this.getMaster()
						.equals(castOther.getMaster())))
				&& ((this.getCode() == castOther.getCode()) || (this.getCode() != null && castOther.getCode() != null && this.getCode().equals(
						castOther.getCode())))
				&& ((this.getStrCode() == castOther.getStrCode()) || (this.getStrCode() != null && castOther.getStrCode() != null && this
						.getStrCode().equals(castOther.getStrCode())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null && this.getName().equals(
						castOther.getName())))
				&& ((this.getOtherCode() == castOther.getOtherCode()) || (this.getOtherCode() != null && castOther.getOtherCode() != null && this
						.getOtherCode().equals(castOther.getOtherCode())))
				&& ((this.getClassIdNo() == castOther.getClassIdNo()) || (this.getClassIdNo() != null && castOther.getClassIdNo() != null && this
						.getClassIdNo().equals(castOther.getClassIdNo())))
				&& ((this.getSrNo() == castOther.getSrNo()) || (this.getSrNo() != null && castOther.getSrNo() != null && this.getSrNo().equals(
						castOther.getSrNo())))
				&& ((this.getFlat() == castOther.getFlat()) || (this.getFlat() != null && castOther.getFlat() != null && this.getFlat().equals(
						castOther.getFlat())))
				&& ((this.getTsd() == castOther.getTsd()) || (this.getTsd() != null && castOther.getTsd() != null && this.getTsd().equals(
						castOther.getTsd())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdNo() == null ? 0 : this.getIdNo().hashCode());
		result = 37 * result + (getMaster() == null ? 0 : this.getMaster().hashCode());
		result = 37 * result + (getCode() == null ? 0 : this.getCode().hashCode());
		result = 37 * result + (getStrCode() == null ? 0 : this.getStrCode().hashCode());
		result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result + (getOtherCode() == null ? 0 : this.getOtherCode().hashCode());
		result = 37 * result + (getClassIdNo() == null ? 0 : this.getClassIdNo().hashCode());
		result = 37 * result + (getSrNo() == null ? 0 : this.getSrNo().hashCode());
		result = 37 * result + (getFlat() == null ? 0 : this.getFlat().hashCode());
		result = 37 * result + (getTsd() == null ? 0 : this.getTsd().hashCode());
		return result;
	}

}