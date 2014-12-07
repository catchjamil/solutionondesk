package com.sd.app.bean.masters;

// Generated Nov 22, 2014 1:22:06 PM by Hibernate Tools 3.4.0.CR1

/**
 * CurrencyId generated by hbm2java
 */
public class CurrencyId implements java.io.Serializable {

	private Short srNo;
	private String currency;
	private String sign;
	private Float rupees;
	private Integer idNo;

	public CurrencyId() {
	}

	public CurrencyId(Short srNo, String currency, String sign, Float rupees, Integer idNo) {
		this.srNo = srNo;
		this.currency = currency;
		this.sign = sign;
		this.rupees = rupees;
		this.idNo = idNo;
	}

	public Short getSrNo() {
		return this.srNo;
	}

	public void setSrNo(Short srNo) {
		this.srNo = srNo;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Float getRupees() {
		return this.rupees;
	}

	public void setRupees(Float rupees) {
		this.rupees = rupees;
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
		if (!(other instanceof CurrencyId))
			return false;
		CurrencyId castOther = (CurrencyId) other;

		return ((this.getSrNo() == castOther.getSrNo()) || (this.getSrNo() != null && castOther.getSrNo() != null && this.getSrNo().equals(
				castOther.getSrNo())))
				&& ((this.getCurrency() == castOther.getCurrency()) || (this.getCurrency() != null && castOther.getCurrency() != null && this
						.getCurrency().equals(castOther.getCurrency())))
				&& ((this.getSign() == castOther.getSign()) || (this.getSign() != null && castOther.getSign() != null && this.getSign().equals(
						castOther.getSign())))
				&& ((this.getRupees() == castOther.getRupees()) || (this.getRupees() != null && castOther.getRupees() != null && this.getRupees()
						.equals(castOther.getRupees())))
				&& ((this.getIdNo() == castOther.getIdNo()) || (this.getIdNo() != null && castOther.getIdNo() != null && this.getIdNo().equals(
						castOther.getIdNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getSrNo() == null ? 0 : this.getSrNo().hashCode());
		result = 37 * result + (getCurrency() == null ? 0 : this.getCurrency().hashCode());
		result = 37 * result + (getSign() == null ? 0 : this.getSign().hashCode());
		result = 37 * result + (getRupees() == null ? 0 : this.getRupees().hashCode());
		result = 37 * result + (getIdNo() == null ? 0 : this.getIdNo().hashCode());
		return result;
	}

}