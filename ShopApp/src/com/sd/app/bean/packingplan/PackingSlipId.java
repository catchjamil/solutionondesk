package com.sd.app.bean.packingplan;

// Generated Nov 22, 2014 1:11:50 PM by Hibernate Tools 3.4.0.CR1

/**
 * PackingSlipId generated by hbm2java
 */
public class PackingSlipId implements java.io.Serializable {

	private Integer packNo;
	private String party;
	private String orderNo;
	private String particulars;
	private String size;
	private Short pcs;
	private Short weight;
	private String crSize;
	private Short crNo;

	public PackingSlipId() {
	}

	public PackingSlipId(Integer packNo, String party, String orderNo, String particulars, String size, Short pcs, Short weight, String crSize,
			Short crNo) {
		this.packNo = packNo;
		this.party = party;
		this.orderNo = orderNo;
		this.particulars = particulars;
		this.size = size;
		this.pcs = pcs;
		this.weight = weight;
		this.crSize = crSize;
		this.crNo = crNo;
	}

	public Integer getPackNo() {
		return this.packNo;
	}

	public void setPackNo(Integer packNo) {
		this.packNo = packNo;
	}

	public String getParty() {
		return this.party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getParticulars() {
		return this.particulars;
	}

	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Short getPcs() {
		return this.pcs;
	}

	public void setPcs(Short pcs) {
		this.pcs = pcs;
	}

	public Short getWeight() {
		return this.weight;
	}

	public void setWeight(Short weight) {
		this.weight = weight;
	}

	public String getCrSize() {
		return this.crSize;
	}

	public void setCrSize(String crSize) {
		this.crSize = crSize;
	}

	public Short getCrNo() {
		return this.crNo;
	}

	public void setCrNo(Short crNo) {
		this.crNo = crNo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PackingSlipId))
			return false;
		PackingSlipId castOther = (PackingSlipId) other;

		return ((this.getPackNo() == castOther.getPackNo()) || (this.getPackNo() != null && castOther.getPackNo() != null && this.getPackNo().equals(
				castOther.getPackNo())))
				&& ((this.getParty() == castOther.getParty()) || (this.getParty() != null && castOther.getParty() != null && this.getParty().equals(
						castOther.getParty())))
				&& ((this.getOrderNo() == castOther.getOrderNo()) || (this.getOrderNo() != null && castOther.getOrderNo() != null && this
						.getOrderNo().equals(castOther.getOrderNo())))
				&& ((this.getParticulars() == castOther.getParticulars()) || (this.getParticulars() != null && castOther.getParticulars() != null && this
						.getParticulars().equals(castOther.getParticulars())))
				&& ((this.getSize() == castOther.getSize()) || (this.getSize() != null && castOther.getSize() != null && this.getSize().equals(
						castOther.getSize())))
				&& ((this.getPcs() == castOther.getPcs()) || (this.getPcs() != null && castOther.getPcs() != null && this.getPcs().equals(
						castOther.getPcs())))
				&& ((this.getWeight() == castOther.getWeight()) || (this.getWeight() != null && castOther.getWeight() != null && this.getWeight()
						.equals(castOther.getWeight())))
				&& ((this.getCrSize() == castOther.getCrSize()) || (this.getCrSize() != null && castOther.getCrSize() != null && this.getCrSize()
						.equals(castOther.getCrSize())))
				&& ((this.getCrNo() == castOther.getCrNo()) || (this.getCrNo() != null && castOther.getCrNo() != null && this.getCrNo().equals(
						castOther.getCrNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPackNo() == null ? 0 : this.getPackNo().hashCode());
		result = 37 * result + (getParty() == null ? 0 : this.getParty().hashCode());
		result = 37 * result + (getOrderNo() == null ? 0 : this.getOrderNo().hashCode());
		result = 37 * result + (getParticulars() == null ? 0 : this.getParticulars().hashCode());
		result = 37 * result + (getSize() == null ? 0 : this.getSize().hashCode());
		result = 37 * result + (getPcs() == null ? 0 : this.getPcs().hashCode());
		result = 37 * result + (getWeight() == null ? 0 : this.getWeight().hashCode());
		result = 37 * result + (getCrSize() == null ? 0 : this.getCrSize().hashCode());
		result = 37 * result + (getCrNo() == null ? 0 : this.getCrNo().hashCode());
		return result;
	}

}