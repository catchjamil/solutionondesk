package com.sd.app.bean.rawstock;

// Generated Nov 22, 2014 1:16:28 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * JobWorkReceiptsId generated by hbm2java
 */
public class JobWorkReceiptsId implements java.io.Serializable {

	private String coCode;
	private Short rvNo;
	private Date rvDate;
	private Integer pcode;
	private String vehNo;
	private String grNo;
	private String transport;
	private String billNo;
	private Date billDate;
	private Float thick;
	private String icode;
	private Short width;
	private Short height;
	private Short crates;
	private Short billSheets;
	private Short short_;
	private Short breakage;
	private Short damage;
	private Short sheets;
	private String remarks;
	private Integer rvidNo;

	public JobWorkReceiptsId() {
	}

	public JobWorkReceiptsId(String coCode, Short rvNo, Date rvDate, Integer pcode, String vehNo, String grNo, String transport, String billNo,
			Date billDate, Float thick, String icode, Short width, Short height, Short crates, Short billSheets, Short short_, Short breakage,
			Short damage, Short sheets, String remarks, Integer rvidNo) {
		this.coCode = coCode;
		this.rvNo = rvNo;
		this.rvDate = rvDate;
		this.pcode = pcode;
		this.vehNo = vehNo;
		this.grNo = grNo;
		this.transport = transport;
		this.billNo = billNo;
		this.billDate = billDate;
		this.thick = thick;
		this.icode = icode;
		this.width = width;
		this.height = height;
		this.crates = crates;
		this.billSheets = billSheets;
		this.short_ = short_;
		this.breakage = breakage;
		this.damage = damage;
		this.sheets = sheets;
		this.remarks = remarks;
		this.rvidNo = rvidNo;
	}

	public String getCoCode() {
		return this.coCode;
	}

	public void setCoCode(String coCode) {
		this.coCode = coCode;
	}

	public Short getRvNo() {
		return this.rvNo;
	}

	public void setRvNo(Short rvNo) {
		this.rvNo = rvNo;
	}

	public Date getRvDate() {
		return this.rvDate;
	}

	public void setRvDate(Date rvDate) {
		this.rvDate = rvDate;
	}

	public Integer getPcode() {
		return this.pcode;
	}

	public void setPcode(Integer pcode) {
		this.pcode = pcode;
	}

	public String getVehNo() {
		return this.vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public String getGrNo() {
		return this.grNo;
	}

	public void setGrNo(String grNo) {
		this.grNo = grNo;
	}

	public String getTransport() {
		return this.transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Date getBillDate() {
		return this.billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Float getThick() {
		return this.thick;
	}

	public void setThick(Float thick) {
		this.thick = thick;
	}

	public String getIcode() {
		return this.icode;
	}

	public void setIcode(String icode) {
		this.icode = icode;
	}

	public Short getWidth() {
		return this.width;
	}

	public void setWidth(Short width) {
		this.width = width;
	}

	public Short getHeight() {
		return this.height;
	}

	public void setHeight(Short height) {
		this.height = height;
	}

	public Short getCrates() {
		return this.crates;
	}

	public void setCrates(Short crates) {
		this.crates = crates;
	}

	public Short getBillSheets() {
		return this.billSheets;
	}

	public void setBillSheets(Short billSheets) {
		this.billSheets = billSheets;
	}

	public Short getShort_() {
		return this.short_;
	}

	public void setShort_(Short short_) {
		this.short_ = short_;
	}

	public Short getBreakage() {
		return this.breakage;
	}

	public void setBreakage(Short breakage) {
		this.breakage = breakage;
	}

	public Short getDamage() {
		return this.damage;
	}

	public void setDamage(Short damage) {
		this.damage = damage;
	}

	public Short getSheets() {
		return this.sheets;
	}

	public void setSheets(Short sheets) {
		this.sheets = sheets;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getRvidNo() {
		return this.rvidNo;
	}

	public void setRvidNo(Integer rvidNo) {
		this.rvidNo = rvidNo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof JobWorkReceiptsId))
			return false;
		JobWorkReceiptsId castOther = (JobWorkReceiptsId) other;

		return ((this.getCoCode() == castOther.getCoCode()) || (this.getCoCode() != null && castOther.getCoCode() != null && this.getCoCode().equals(
				castOther.getCoCode())))
				&& ((this.getRvNo() == castOther.getRvNo()) || (this.getRvNo() != null && castOther.getRvNo() != null && this.getRvNo().equals(
						castOther.getRvNo())))
				&& ((this.getRvDate() == castOther.getRvDate()) || (this.getRvDate() != null && castOther.getRvDate() != null && this.getRvDate()
						.equals(castOther.getRvDate())))
				&& ((this.getPcode() == castOther.getPcode()) || (this.getPcode() != null && castOther.getPcode() != null && this.getPcode().equals(
						castOther.getPcode())))
				&& ((this.getVehNo() == castOther.getVehNo()) || (this.getVehNo() != null && castOther.getVehNo() != null && this.getVehNo().equals(
						castOther.getVehNo())))
				&& ((this.getGrNo() == castOther.getGrNo()) || (this.getGrNo() != null && castOther.getGrNo() != null && this.getGrNo().equals(
						castOther.getGrNo())))
				&& ((this.getTransport() == castOther.getTransport()) || (this.getTransport() != null && castOther.getTransport() != null && this
						.getTransport().equals(castOther.getTransport())))
				&& ((this.getBillNo() == castOther.getBillNo()) || (this.getBillNo() != null && castOther.getBillNo() != null && this.getBillNo()
						.equals(castOther.getBillNo())))
				&& ((this.getBillDate() == castOther.getBillDate()) || (this.getBillDate() != null && castOther.getBillDate() != null && this
						.getBillDate().equals(castOther.getBillDate())))
				&& ((this.getThick() == castOther.getThick()) || (this.getThick() != null && castOther.getThick() != null && this.getThick().equals(
						castOther.getThick())))
				&& ((this.getIcode() == castOther.getIcode()) || (this.getIcode() != null && castOther.getIcode() != null && this.getIcode().equals(
						castOther.getIcode())))
				&& ((this.getWidth() == castOther.getWidth()) || (this.getWidth() != null && castOther.getWidth() != null && this.getWidth().equals(
						castOther.getWidth())))
				&& ((this.getHeight() == castOther.getHeight()) || (this.getHeight() != null && castOther.getHeight() != null && this.getHeight()
						.equals(castOther.getHeight())))
				&& ((this.getCrates() == castOther.getCrates()) || (this.getCrates() != null && castOther.getCrates() != null && this.getCrates()
						.equals(castOther.getCrates())))
				&& ((this.getBillSheets() == castOther.getBillSheets()) || (this.getBillSheets() != null && castOther.getBillSheets() != null && this
						.getBillSheets().equals(castOther.getBillSheets())))
				&& ((this.getShort_() == castOther.getShort_()) || (this.getShort_() != null && castOther.getShort_() != null && this.getShort_()
						.equals(castOther.getShort_())))
				&& ((this.getBreakage() == castOther.getBreakage()) || (this.getBreakage() != null && castOther.getBreakage() != null && this
						.getBreakage().equals(castOther.getBreakage())))
				&& ((this.getDamage() == castOther.getDamage()) || (this.getDamage() != null && castOther.getDamage() != null && this.getDamage()
						.equals(castOther.getDamage())))
				&& ((this.getSheets() == castOther.getSheets()) || (this.getSheets() != null && castOther.getSheets() != null && this.getSheets()
						.equals(castOther.getSheets())))
				&& ((this.getRemarks() == castOther.getRemarks()) || (this.getRemarks() != null && castOther.getRemarks() != null && this
						.getRemarks().equals(castOther.getRemarks())))
				&& ((this.getRvidNo() == castOther.getRvidNo()) || (this.getRvidNo() != null && castOther.getRvidNo() != null && this.getRvidNo()
						.equals(castOther.getRvidNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCoCode() == null ? 0 : this.getCoCode().hashCode());
		result = 37 * result + (getRvNo() == null ? 0 : this.getRvNo().hashCode());
		result = 37 * result + (getRvDate() == null ? 0 : this.getRvDate().hashCode());
		result = 37 * result + (getPcode() == null ? 0 : this.getPcode().hashCode());
		result = 37 * result + (getVehNo() == null ? 0 : this.getVehNo().hashCode());
		result = 37 * result + (getGrNo() == null ? 0 : this.getGrNo().hashCode());
		result = 37 * result + (getTransport() == null ? 0 : this.getTransport().hashCode());
		result = 37 * result + (getBillNo() == null ? 0 : this.getBillNo().hashCode());
		result = 37 * result + (getBillDate() == null ? 0 : this.getBillDate().hashCode());
		result = 37 * result + (getThick() == null ? 0 : this.getThick().hashCode());
		result = 37 * result + (getIcode() == null ? 0 : this.getIcode().hashCode());
		result = 37 * result + (getWidth() == null ? 0 : this.getWidth().hashCode());
		result = 37 * result + (getHeight() == null ? 0 : this.getHeight().hashCode());
		result = 37 * result + (getCrates() == null ? 0 : this.getCrates().hashCode());
		result = 37 * result + (getBillSheets() == null ? 0 : this.getBillSheets().hashCode());
		result = 37 * result + (getShort_() == null ? 0 : this.getShort_().hashCode());
		result = 37 * result + (getBreakage() == null ? 0 : this.getBreakage().hashCode());
		result = 37 * result + (getDamage() == null ? 0 : this.getDamage().hashCode());
		result = 37 * result + (getSheets() == null ? 0 : this.getSheets().hashCode());
		result = 37 * result + (getRemarks() == null ? 0 : this.getRemarks().hashCode());
		result = 37 * result + (getRvidNo() == null ? 0 : this.getRvidNo().hashCode());
		return result;
	}

}
