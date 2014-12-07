package com.sd.app.bean.reportdata;

// Generated Nov 22, 2014 1:17:36 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * ExciseReportId generated by hbm2java
 */
public class ExciseReportId implements java.io.Serializable {

	private String icode;
	private Float thick;
	private Float proddeco;
	private Float prodPlain;
	private Float totalprod;
	private Date sdate;
	private Date edate;
	private String unit;
	private Float despdeco;
	private Float despdecoamt;
	private Float despDecoExc;
	private Float despPlain;
	private Float despPlainAmt;
	private Float despPlainExc;
	private String jobWork;
	private String material;
	private Float despEcess;
	private Float despHecess;

	public ExciseReportId() {
	}

	public ExciseReportId(String icode, Float thick, Float proddeco, Float prodPlain, Float totalprod, Date sdate, Date edate, String unit,
			Float despdeco, Float despdecoamt, Float despDecoExc, Float despPlain, Float despPlainAmt, Float despPlainExc, String jobWork,
			String material, Float despEcess, Float despHecess) {
		this.icode = icode;
		this.thick = thick;
		this.proddeco = proddeco;
		this.prodPlain = prodPlain;
		this.totalprod = totalprod;
		this.sdate = sdate;
		this.edate = edate;
		this.unit = unit;
		this.despdeco = despdeco;
		this.despdecoamt = despdecoamt;
		this.despDecoExc = despDecoExc;
		this.despPlain = despPlain;
		this.despPlainAmt = despPlainAmt;
		this.despPlainExc = despPlainExc;
		this.jobWork = jobWork;
		this.material = material;
		this.despEcess = despEcess;
		this.despHecess = despHecess;
	}

	public String getIcode() {
		return this.icode;
	}

	public void setIcode(String icode) {
		this.icode = icode;
	}

	public Float getThick() {
		return this.thick;
	}

	public void setThick(Float thick) {
		this.thick = thick;
	}

	public Float getProddeco() {
		return this.proddeco;
	}

	public void setProddeco(Float proddeco) {
		this.proddeco = proddeco;
	}

	public Float getProdPlain() {
		return this.prodPlain;
	}

	public void setProdPlain(Float prodPlain) {
		this.prodPlain = prodPlain;
	}

	public Float getTotalprod() {
		return this.totalprod;
	}

	public void setTotalprod(Float totalprod) {
		this.totalprod = totalprod;
	}

	public Date getSdate() {
		return this.sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public Date getEdate() {
		return this.edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Float getDespdeco() {
		return this.despdeco;
	}

	public void setDespdeco(Float despdeco) {
		this.despdeco = despdeco;
	}

	public Float getDespdecoamt() {
		return this.despdecoamt;
	}

	public void setDespdecoamt(Float despdecoamt) {
		this.despdecoamt = despdecoamt;
	}

	public Float getDespDecoExc() {
		return this.despDecoExc;
	}

	public void setDespDecoExc(Float despDecoExc) {
		this.despDecoExc = despDecoExc;
	}

	public Float getDespPlain() {
		return this.despPlain;
	}

	public void setDespPlain(Float despPlain) {
		this.despPlain = despPlain;
	}

	public Float getDespPlainAmt() {
		return this.despPlainAmt;
	}

	public void setDespPlainAmt(Float despPlainAmt) {
		this.despPlainAmt = despPlainAmt;
	}

	public Float getDespPlainExc() {
		return this.despPlainExc;
	}

	public void setDespPlainExc(Float despPlainExc) {
		this.despPlainExc = despPlainExc;
	}

	public String getJobWork() {
		return this.jobWork;
	}

	public void setJobWork(String jobWork) {
		this.jobWork = jobWork;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Float getDespEcess() {
		return this.despEcess;
	}

	public void setDespEcess(Float despEcess) {
		this.despEcess = despEcess;
	}

	public Float getDespHecess() {
		return this.despHecess;
	}

	public void setDespHecess(Float despHecess) {
		this.despHecess = despHecess;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ExciseReportId))
			return false;
		ExciseReportId castOther = (ExciseReportId) other;

		return ((this.getIcode() == castOther.getIcode()) || (this.getIcode() != null && castOther.getIcode() != null && this.getIcode().equals(
				castOther.getIcode())))
				&& ((this.getThick() == castOther.getThick()) || (this.getThick() != null && castOther.getThick() != null && this.getThick().equals(
						castOther.getThick())))
				&& ((this.getProddeco() == castOther.getProddeco()) || (this.getProddeco() != null && castOther.getProddeco() != null && this
						.getProddeco().equals(castOther.getProddeco())))
				&& ((this.getProdPlain() == castOther.getProdPlain()) || (this.getProdPlain() != null && castOther.getProdPlain() != null && this
						.getProdPlain().equals(castOther.getProdPlain())))
				&& ((this.getTotalprod() == castOther.getTotalprod()) || (this.getTotalprod() != null && castOther.getTotalprod() != null && this
						.getTotalprod().equals(castOther.getTotalprod())))
				&& ((this.getSdate() == castOther.getSdate()) || (this.getSdate() != null && castOther.getSdate() != null && this.getSdate().equals(
						castOther.getSdate())))
				&& ((this.getEdate() == castOther.getEdate()) || (this.getEdate() != null && castOther.getEdate() != null && this.getEdate().equals(
						castOther.getEdate())))
				&& ((this.getUnit() == castOther.getUnit()) || (this.getUnit() != null && castOther.getUnit() != null && this.getUnit().equals(
						castOther.getUnit())))
				&& ((this.getDespdeco() == castOther.getDespdeco()) || (this.getDespdeco() != null && castOther.getDespdeco() != null && this
						.getDespdeco().equals(castOther.getDespdeco())))
				&& ((this.getDespdecoamt() == castOther.getDespdecoamt()) || (this.getDespdecoamt() != null && castOther.getDespdecoamt() != null && this
						.getDespdecoamt().equals(castOther.getDespdecoamt())))
				&& ((this.getDespDecoExc() == castOther.getDespDecoExc()) || (this.getDespDecoExc() != null && castOther.getDespDecoExc() != null && this
						.getDespDecoExc().equals(castOther.getDespDecoExc())))
				&& ((this.getDespPlain() == castOther.getDespPlain()) || (this.getDespPlain() != null && castOther.getDespPlain() != null && this
						.getDespPlain().equals(castOther.getDespPlain())))
				&& ((this.getDespPlainAmt() == castOther.getDespPlainAmt()) || (this.getDespPlainAmt() != null && castOther.getDespPlainAmt() != null && this
						.getDespPlainAmt().equals(castOther.getDespPlainAmt())))
				&& ((this.getDespPlainExc() == castOther.getDespPlainExc()) || (this.getDespPlainExc() != null && castOther.getDespPlainExc() != null && this
						.getDespPlainExc().equals(castOther.getDespPlainExc())))
				&& ((this.getJobWork() == castOther.getJobWork()) || (this.getJobWork() != null && castOther.getJobWork() != null && this
						.getJobWork().equals(castOther.getJobWork())))
				&& ((this.getMaterial() == castOther.getMaterial()) || (this.getMaterial() != null && castOther.getMaterial() != null && this
						.getMaterial().equals(castOther.getMaterial())))
				&& ((this.getDespEcess() == castOther.getDespEcess()) || (this.getDespEcess() != null && castOther.getDespEcess() != null && this
						.getDespEcess().equals(castOther.getDespEcess())))
				&& ((this.getDespHecess() == castOther.getDespHecess()) || (this.getDespHecess() != null && castOther.getDespHecess() != null && this
						.getDespHecess().equals(castOther.getDespHecess())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIcode() == null ? 0 : this.getIcode().hashCode());
		result = 37 * result + (getThick() == null ? 0 : this.getThick().hashCode());
		result = 37 * result + (getProddeco() == null ? 0 : this.getProddeco().hashCode());
		result = 37 * result + (getProdPlain() == null ? 0 : this.getProdPlain().hashCode());
		result = 37 * result + (getTotalprod() == null ? 0 : this.getTotalprod().hashCode());
		result = 37 * result + (getSdate() == null ? 0 : this.getSdate().hashCode());
		result = 37 * result + (getEdate() == null ? 0 : this.getEdate().hashCode());
		result = 37 * result + (getUnit() == null ? 0 : this.getUnit().hashCode());
		result = 37 * result + (getDespdeco() == null ? 0 : this.getDespdeco().hashCode());
		result = 37 * result + (getDespdecoamt() == null ? 0 : this.getDespdecoamt().hashCode());
		result = 37 * result + (getDespDecoExc() == null ? 0 : this.getDespDecoExc().hashCode());
		result = 37 * result + (getDespPlain() == null ? 0 : this.getDespPlain().hashCode());
		result = 37 * result + (getDespPlainAmt() == null ? 0 : this.getDespPlainAmt().hashCode());
		result = 37 * result + (getDespPlainExc() == null ? 0 : this.getDespPlainExc().hashCode());
		result = 37 * result + (getJobWork() == null ? 0 : this.getJobWork().hashCode());
		result = 37 * result + (getMaterial() == null ? 0 : this.getMaterial().hashCode());
		result = 37 * result + (getDespEcess() == null ? 0 : this.getDespEcess().hashCode());
		result = 37 * result + (getDespHecess() == null ? 0 : this.getDespHecess().hashCode());
		return result;
	}

}