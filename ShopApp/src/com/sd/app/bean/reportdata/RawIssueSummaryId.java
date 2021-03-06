package com.sd.app.bean.reportdata;

// Generated Nov 22, 2014 1:17:36 PM by Hibernate Tools 3.4.0.CR1

/**
 * RawIssueSummaryId generated by hbm2java
 */
public class RawIssueSummaryId implements java.io.Serializable {

	private String coCode;
	private Float thick;
	private String icode;
	private Short height;
	private Short width;
	private Short sheets;
	private Short offcuts;
	private Float sqMtr;
	private Float rate;
	private Float amount;

	public RawIssueSummaryId() {
	}

	public RawIssueSummaryId(String coCode, Float thick, String icode, Short height, Short width, Short sheets, Short offcuts, Float sqMtr,
			Float rate, Float amount) {
		this.coCode = coCode;
		this.thick = thick;
		this.icode = icode;
		this.height = height;
		this.width = width;
		this.sheets = sheets;
		this.offcuts = offcuts;
		this.sqMtr = sqMtr;
		this.rate = rate;
		this.amount = amount;
	}

	public String getCoCode() {
		return this.coCode;
	}

	public void setCoCode(String coCode) {
		this.coCode = coCode;
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

	public Short getHeight() {
		return this.height;
	}

	public void setHeight(Short height) {
		this.height = height;
	}

	public Short getWidth() {
		return this.width;
	}

	public void setWidth(Short width) {
		this.width = width;
	}

	public Short getSheets() {
		return this.sheets;
	}

	public void setSheets(Short sheets) {
		this.sheets = sheets;
	}

	public Short getOffcuts() {
		return this.offcuts;
	}

	public void setOffcuts(Short offcuts) {
		this.offcuts = offcuts;
	}

	public Float getSqMtr() {
		return this.sqMtr;
	}

	public void setSqMtr(Float sqMtr) {
		this.sqMtr = sqMtr;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RawIssueSummaryId))
			return false;
		RawIssueSummaryId castOther = (RawIssueSummaryId) other;

		return ((this.getCoCode() == castOther.getCoCode()) || (this.getCoCode() != null && castOther.getCoCode() != null && this.getCoCode().equals(
				castOther.getCoCode())))
				&& ((this.getThick() == castOther.getThick()) || (this.getThick() != null && castOther.getThick() != null && this.getThick().equals(
						castOther.getThick())))
				&& ((this.getIcode() == castOther.getIcode()) || (this.getIcode() != null && castOther.getIcode() != null && this.getIcode().equals(
						castOther.getIcode())))
				&& ((this.getHeight() == castOther.getHeight()) || (this.getHeight() != null && castOther.getHeight() != null && this.getHeight()
						.equals(castOther.getHeight())))
				&& ((this.getWidth() == castOther.getWidth()) || (this.getWidth() != null && castOther.getWidth() != null && this.getWidth().equals(
						castOther.getWidth())))
				&& ((this.getSheets() == castOther.getSheets()) || (this.getSheets() != null && castOther.getSheets() != null && this.getSheets()
						.equals(castOther.getSheets())))
				&& ((this.getOffcuts() == castOther.getOffcuts()) || (this.getOffcuts() != null && castOther.getOffcuts() != null && this
						.getOffcuts().equals(castOther.getOffcuts())))
				&& ((this.getSqMtr() == castOther.getSqMtr()) || (this.getSqMtr() != null && castOther.getSqMtr() != null && this.getSqMtr().equals(
						castOther.getSqMtr())))
				&& ((this.getRate() == castOther.getRate()) || (this.getRate() != null && castOther.getRate() != null && this.getRate().equals(
						castOther.getRate())))
				&& ((this.getAmount() == castOther.getAmount()) || (this.getAmount() != null && castOther.getAmount() != null && this.getAmount()
						.equals(castOther.getAmount())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCoCode() == null ? 0 : this.getCoCode().hashCode());
		result = 37 * result + (getThick() == null ? 0 : this.getThick().hashCode());
		result = 37 * result + (getIcode() == null ? 0 : this.getIcode().hashCode());
		result = 37 * result + (getHeight() == null ? 0 : this.getHeight().hashCode());
		result = 37 * result + (getWidth() == null ? 0 : this.getWidth().hashCode());
		result = 37 * result + (getSheets() == null ? 0 : this.getSheets().hashCode());
		result = 37 * result + (getOffcuts() == null ? 0 : this.getOffcuts().hashCode());
		result = 37 * result + (getSqMtr() == null ? 0 : this.getSqMtr().hashCode());
		result = 37 * result + (getRate() == null ? 0 : this.getRate().hashCode());
		result = 37 * result + (getAmount() == null ? 0 : this.getAmount().hashCode());
		return result;
	}

}
