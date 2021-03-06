package com.sd.app.bean.samples;

// Generated Nov 22, 2014 1:18:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * ReceiptsId generated by hbm2java
 */
public class ReceiptsId implements java.io.Serializable {

	private String coCode;
	private Integer receiptsNo;
	private Date data;
	private Float thick;
	private String icode;
	private String tough;
	private String flat;
	private Float width;
	private Float height;
	private Integer pcs;
	private Float sqMtr;
	private String remarks;

	public ReceiptsId() {
	}

	public ReceiptsId(String coCode, Integer receiptsNo, Date data, Float thick, String icode, String tough, String flat, Float width, Float height,
			Integer pcs, Float sqMtr, String remarks) {
		this.coCode = coCode;
		this.receiptsNo = receiptsNo;
		this.data = data;
		this.thick = thick;
		this.icode = icode;
		this.tough = tough;
		this.flat = flat;
		this.width = width;
		this.height = height;
		this.pcs = pcs;
		this.sqMtr = sqMtr;
		this.remarks = remarks;
	}

	public String getCoCode() {
		return this.coCode;
	}

	public void setCoCode(String coCode) {
		this.coCode = coCode;
	}

	public Integer getReceiptsNo() {
		return this.receiptsNo;
	}

	public void setReceiptsNo(Integer receiptsNo) {
		this.receiptsNo = receiptsNo;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public String getTough() {
		return this.tough;
	}

	public void setTough(String tough) {
		this.tough = tough;
	}

	public String getFlat() {
		return this.flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public Float getWidth() {
		return this.width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getHeight() {
		return this.height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Integer getPcs() {
		return this.pcs;
	}

	public void setPcs(Integer pcs) {
		this.pcs = pcs;
	}

	public Float getSqMtr() {
		return this.sqMtr;
	}

	public void setSqMtr(Float sqMtr) {
		this.sqMtr = sqMtr;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ReceiptsId))
			return false;
		ReceiptsId castOther = (ReceiptsId) other;

		return ((this.getCoCode() == castOther.getCoCode()) || (this.getCoCode() != null && castOther.getCoCode() != null && this.getCoCode().equals(
				castOther.getCoCode())))
				&& ((this.getReceiptsNo() == castOther.getReceiptsNo()) || (this.getReceiptsNo() != null && castOther.getReceiptsNo() != null && this
						.getReceiptsNo().equals(castOther.getReceiptsNo())))
				&& ((this.getData() == castOther.getData()) || (this.getData() != null && castOther.getData() != null && this.getData().equals(
						castOther.getData())))
				&& ((this.getThick() == castOther.getThick()) || (this.getThick() != null && castOther.getThick() != null && this.getThick().equals(
						castOther.getThick())))
				&& ((this.getIcode() == castOther.getIcode()) || (this.getIcode() != null && castOther.getIcode() != null && this.getIcode().equals(
						castOther.getIcode())))
				&& ((this.getTough() == castOther.getTough()) || (this.getTough() != null && castOther.getTough() != null && this.getTough().equals(
						castOther.getTough())))
				&& ((this.getFlat() == castOther.getFlat()) || (this.getFlat() != null && castOther.getFlat() != null && this.getFlat().equals(
						castOther.getFlat())))
				&& ((this.getWidth() == castOther.getWidth()) || (this.getWidth() != null && castOther.getWidth() != null && this.getWidth().equals(
						castOther.getWidth())))
				&& ((this.getHeight() == castOther.getHeight()) || (this.getHeight() != null && castOther.getHeight() != null && this.getHeight()
						.equals(castOther.getHeight())))
				&& ((this.getPcs() == castOther.getPcs()) || (this.getPcs() != null && castOther.getPcs() != null && this.getPcs().equals(
						castOther.getPcs())))
				&& ((this.getSqMtr() == castOther.getSqMtr()) || (this.getSqMtr() != null && castOther.getSqMtr() != null && this.getSqMtr().equals(
						castOther.getSqMtr())))
				&& ((this.getRemarks() == castOther.getRemarks()) || (this.getRemarks() != null && castOther.getRemarks() != null && this
						.getRemarks().equals(castOther.getRemarks())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCoCode() == null ? 0 : this.getCoCode().hashCode());
		result = 37 * result + (getReceiptsNo() == null ? 0 : this.getReceiptsNo().hashCode());
		result = 37 * result + (getData() == null ? 0 : this.getData().hashCode());
		result = 37 * result + (getThick() == null ? 0 : this.getThick().hashCode());
		result = 37 * result + (getIcode() == null ? 0 : this.getIcode().hashCode());
		result = 37 * result + (getTough() == null ? 0 : this.getTough().hashCode());
		result = 37 * result + (getFlat() == null ? 0 : this.getFlat().hashCode());
		result = 37 * result + (getWidth() == null ? 0 : this.getWidth().hashCode());
		result = 37 * result + (getHeight() == null ? 0 : this.getHeight().hashCode());
		result = 37 * result + (getPcs() == null ? 0 : this.getPcs().hashCode());
		result = 37 * result + (getSqMtr() == null ? 0 : this.getSqMtr().hashCode());
		result = 37 * result + (getRemarks() == null ? 0 : this.getRemarks().hashCode());
		return result;
	}

}
