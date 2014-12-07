package com.sd.app.bean.packingplan;

// Generated Nov 22, 2014 1:11:50 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * CrateSizeId generated by hbm2java
 */
public class CrateSizeId implements java.io.Serializable {

	private Integer packNo;
	private Short crNo;
	private long pcs;
	private BigDecimal crthick;
	private int crwidth;
	private int crheight;
	private long weight;
	private int nofitem;

	public CrateSizeId() {
	}

	public CrateSizeId(long pcs, BigDecimal crthick, int crwidth, int crheight, long weight, int nofitem) {
		this.pcs = pcs;
		this.crthick = crthick;
		this.crwidth = crwidth;
		this.crheight = crheight;
		this.weight = weight;
		this.nofitem = nofitem;
	}

	public CrateSizeId(Integer packNo, Short crNo, long pcs, BigDecimal crthick, int crwidth, int crheight, long weight, int nofitem) {
		this.packNo = packNo;
		this.crNo = crNo;
		this.pcs = pcs;
		this.crthick = crthick;
		this.crwidth = crwidth;
		this.crheight = crheight;
		this.weight = weight;
		this.nofitem = nofitem;
	}

	public Integer getPackNo() {
		return this.packNo;
	}

	public void setPackNo(Integer packNo) {
		this.packNo = packNo;
	}

	public Short getCrNo() {
		return this.crNo;
	}

	public void setCrNo(Short crNo) {
		this.crNo = crNo;
	}

	public long getPcs() {
		return this.pcs;
	}

	public void setPcs(long pcs) {
		this.pcs = pcs;
	}

	public BigDecimal getCrthick() {
		return this.crthick;
	}

	public void setCrthick(BigDecimal crthick) {
		this.crthick = crthick;
	}

	public int getCrwidth() {
		return this.crwidth;
	}

	public void setCrwidth(int crwidth) {
		this.crwidth = crwidth;
	}

	public int getCrheight() {
		return this.crheight;
	}

	public void setCrheight(int crheight) {
		this.crheight = crheight;
	}

	public long getWeight() {
		return this.weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public int getNofitem() {
		return this.nofitem;
	}

	public void setNofitem(int nofitem) {
		this.nofitem = nofitem;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CrateSizeId))
			return false;
		CrateSizeId castOther = (CrateSizeId) other;

		return ((this.getPackNo() == castOther.getPackNo()) || (this.getPackNo() != null && castOther.getPackNo() != null && this.getPackNo().equals(
				castOther.getPackNo())))
				&& ((this.getCrNo() == castOther.getCrNo()) || (this.getCrNo() != null && castOther.getCrNo() != null && this.getCrNo().equals(
						castOther.getCrNo())))
				&& (this.getPcs() == castOther.getPcs())
				&& ((this.getCrthick() == castOther.getCrthick()) || (this.getCrthick() != null && castOther.getCrthick() != null && this
						.getCrthick().equals(castOther.getCrthick())))
				&& (this.getCrwidth() == castOther.getCrwidth())
				&& (this.getCrheight() == castOther.getCrheight())
				&& (this.getWeight() == castOther.getWeight())
				&& (this.getNofitem() == castOther.getNofitem());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPackNo() == null ? 0 : this.getPackNo().hashCode());
		result = 37 * result + (getCrNo() == null ? 0 : this.getCrNo().hashCode());
		result = 37 * result + (int) this.getPcs();
		result = 37 * result + (getCrthick() == null ? 0 : this.getCrthick().hashCode());
		result = 37 * result + this.getCrwidth();
		result = 37 * result + this.getCrheight();
		result = 37 * result + (int) this.getWeight();
		result = 37 * result + this.getNofitem();
		return result;
	}

}