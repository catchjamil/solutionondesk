package com.sd.app.bean.wipfile;

// Generated Nov 22, 2014 1:20:46 PM by Hibernate Tools 3.4.0.CR1

/**
 * MisReportId generated by hbm2java
 */
public class MisReportId implements java.io.Serializable {

	private String orderNo;
	private Float pcode;
	private Float thick;
	private String icode;
	private String material;
	private Float sqMt;
	private Float rate;
	private Float amount;
	private String department;
	private String breakageduring;
	private Float pcs;
	private String shift;
	private Float retSqMt;
	private Float lossSqMt;

	public MisReportId() {
	}

	public MisReportId(String orderNo, Float pcode, Float thick, String icode, String material, Float sqMt, Float rate, Float amount,
			String department, String breakageduring, Float pcs, String shift, Float retSqMt, Float lossSqMt) {
		this.orderNo = orderNo;
		this.pcode = pcode;
		this.thick = thick;
		this.icode = icode;
		this.material = material;
		this.sqMt = sqMt;
		this.rate = rate;
		this.amount = amount;
		this.department = department;
		this.breakageduring = breakageduring;
		this.pcs = pcs;
		this.shift = shift;
		this.retSqMt = retSqMt;
		this.lossSqMt = lossSqMt;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Float getPcode() {
		return this.pcode;
	}

	public void setPcode(Float pcode) {
		this.pcode = pcode;
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

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Float getSqMt() {
		return this.sqMt;
	}

	public void setSqMt(Float sqMt) {
		this.sqMt = sqMt;
	}

	public Float getRate() {
		return this.rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBreakageduring() {
		return this.breakageduring;
	}

	public void setBreakageduring(String breakageduring) {
		this.breakageduring = breakageduring;
	}

	public Float getPcs() {
		return this.pcs;
	}

	public void setPcs(Float pcs) {
		this.pcs = pcs;
	}

	public String getShift() {
		return this.shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public Float getRetSqMt() {
		return this.retSqMt;
	}

	public void setRetSqMt(Float retSqMt) {
		this.retSqMt = retSqMt;
	}

	public Float getLossSqMt() {
		return this.lossSqMt;
	}

	public void setLossSqMt(Float lossSqMt) {
		this.lossSqMt = lossSqMt;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MisReportId))
			return false;
		MisReportId castOther = (MisReportId) other;

		return ((this.getOrderNo() == castOther.getOrderNo()) || (this.getOrderNo() != null && castOther.getOrderNo() != null && this.getOrderNo()
				.equals(castOther.getOrderNo())))
				&& ((this.getPcode() == castOther.getPcode()) || (this.getPcode() != null && castOther.getPcode() != null && this.getPcode().equals(
						castOther.getPcode())))
				&& ((this.getThick() == castOther.getThick()) || (this.getThick() != null && castOther.getThick() != null && this.getThick().equals(
						castOther.getThick())))
				&& ((this.getIcode() == castOther.getIcode()) || (this.getIcode() != null && castOther.getIcode() != null && this.getIcode().equals(
						castOther.getIcode())))
				&& ((this.getMaterial() == castOther.getMaterial()) || (this.getMaterial() != null && castOther.getMaterial() != null && this
						.getMaterial().equals(castOther.getMaterial())))
				&& ((this.getSqMt() == castOther.getSqMt()) || (this.getSqMt() != null && castOther.getSqMt() != null && this.getSqMt().equals(
						castOther.getSqMt())))
				&& ((this.getRate() == castOther.getRate()) || (this.getRate() != null && castOther.getRate() != null && this.getRate().equals(
						castOther.getRate())))
				&& ((this.getAmount() == castOther.getAmount()) || (this.getAmount() != null && castOther.getAmount() != null && this.getAmount()
						.equals(castOther.getAmount())))
				&& ((this.getDepartment() == castOther.getDepartment()) || (this.getDepartment() != null && castOther.getDepartment() != null && this
						.getDepartment().equals(castOther.getDepartment())))
				&& ((this.getBreakageduring() == castOther.getBreakageduring()) || (this.getBreakageduring() != null
						&& castOther.getBreakageduring() != null && this.getBreakageduring().equals(castOther.getBreakageduring())))
				&& ((this.getPcs() == castOther.getPcs()) || (this.getPcs() != null && castOther.getPcs() != null && this.getPcs().equals(
						castOther.getPcs())))
				&& ((this.getShift() == castOther.getShift()) || (this.getShift() != null && castOther.getShift() != null && this.getShift().equals(
						castOther.getShift())))
				&& ((this.getRetSqMt() == castOther.getRetSqMt()) || (this.getRetSqMt() != null && castOther.getRetSqMt() != null && this
						.getRetSqMt().equals(castOther.getRetSqMt())))
				&& ((this.getLossSqMt() == castOther.getLossSqMt()) || (this.getLossSqMt() != null && castOther.getLossSqMt() != null && this
						.getLossSqMt().equals(castOther.getLossSqMt())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getOrderNo() == null ? 0 : this.getOrderNo().hashCode());
		result = 37 * result + (getPcode() == null ? 0 : this.getPcode().hashCode());
		result = 37 * result + (getThick() == null ? 0 : this.getThick().hashCode());
		result = 37 * result + (getIcode() == null ? 0 : this.getIcode().hashCode());
		result = 37 * result + (getMaterial() == null ? 0 : this.getMaterial().hashCode());
		result = 37 * result + (getSqMt() == null ? 0 : this.getSqMt().hashCode());
		result = 37 * result + (getRate() == null ? 0 : this.getRate().hashCode());
		result = 37 * result + (getAmount() == null ? 0 : this.getAmount().hashCode());
		result = 37 * result + (getDepartment() == null ? 0 : this.getDepartment().hashCode());
		result = 37 * result + (getBreakageduring() == null ? 0 : this.getBreakageduring().hashCode());
		result = 37 * result + (getPcs() == null ? 0 : this.getPcs().hashCode());
		result = 37 * result + (getShift() == null ? 0 : this.getShift().hashCode());
		result = 37 * result + (getRetSqMt() == null ? 0 : this.getRetSqMt().hashCode());
		result = 37 * result + (getLossSqMt() == null ? 0 : this.getLossSqMt().hashCode());
		return result;
	}

}
