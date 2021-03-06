package com.sd.app.bean.sfa;

// Generated Nov 22, 2014 1:19:44 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * FollowUpsId generated by hbm2java
 */
public class FollowUpsId implements java.io.Serializable {

	private Integer idNo;
	private String yy;
	private String coCode;
	private Float enquiryNo;
	private Date date;
	private Float pcode;
	private String description;
	private String media;
	private String dealBy;
	private Float fno;
	private String ftime;
	private Date remDate;
	private String remNote;
	private Date remTime;
	private Boolean tag;

	public FollowUpsId() {
	}

	public FollowUpsId(Integer idNo, String yy, String coCode, Float enquiryNo, Date date, Float pcode, String description, String media,
			String dealBy, Float fno, String ftime, Date remDate, String remNote, Date remTime, Boolean tag) {
		this.idNo = idNo;
		this.yy = yy;
		this.coCode = coCode;
		this.enquiryNo = enquiryNo;
		this.date = date;
		this.pcode = pcode;
		this.description = description;
		this.media = media;
		this.dealBy = dealBy;
		this.fno = fno;
		this.ftime = ftime;
		this.remDate = remDate;
		this.remNote = remNote;
		this.remTime = remTime;
		this.tag = tag;
	}

	public Integer getIdNo() {
		return this.idNo;
	}

	public void setIdNo(Integer idNo) {
		this.idNo = idNo;
	}

	public String getYy() {
		return this.yy;
	}

	public void setYy(String yy) {
		this.yy = yy;
	}

	public String getCoCode() {
		return this.coCode;
	}

	public void setCoCode(String coCode) {
		this.coCode = coCode;
	}

	public Float getEnquiryNo() {
		return this.enquiryNo;
	}

	public void setEnquiryNo(Float enquiryNo) {
		this.enquiryNo = enquiryNo;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getPcode() {
		return this.pcode;
	}

	public void setPcode(Float pcode) {
		this.pcode = pcode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMedia() {
		return this.media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getDealBy() {
		return this.dealBy;
	}

	public void setDealBy(String dealBy) {
		this.dealBy = dealBy;
	}

	public Float getFno() {
		return this.fno;
	}

	public void setFno(Float fno) {
		this.fno = fno;
	}

	public String getFtime() {
		return this.ftime;
	}

	public void setFtime(String ftime) {
		this.ftime = ftime;
	}

	public Date getRemDate() {
		return this.remDate;
	}

	public void setRemDate(Date remDate) {
		this.remDate = remDate;
	}

	public String getRemNote() {
		return this.remNote;
	}

	public void setRemNote(String remNote) {
		this.remNote = remNote;
	}

	public Date getRemTime() {
		return this.remTime;
	}

	public void setRemTime(Date remTime) {
		this.remTime = remTime;
	}

	public Boolean getTag() {
		return this.tag;
	}

	public void setTag(Boolean tag) {
		this.tag = tag;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FollowUpsId))
			return false;
		FollowUpsId castOther = (FollowUpsId) other;

		return ((this.getIdNo() == castOther.getIdNo()) || (this.getIdNo() != null && castOther.getIdNo() != null && this.getIdNo().equals(
				castOther.getIdNo())))
				&& ((this.getYy() == castOther.getYy()) || (this.getYy() != null && castOther.getYy() != null && this.getYy().equals(
						castOther.getYy())))
				&& ((this.getCoCode() == castOther.getCoCode()) || (this.getCoCode() != null && castOther.getCoCode() != null && this.getCoCode()
						.equals(castOther.getCoCode())))
				&& ((this.getEnquiryNo() == castOther.getEnquiryNo()) || (this.getEnquiryNo() != null && castOther.getEnquiryNo() != null && this
						.getEnquiryNo().equals(castOther.getEnquiryNo())))
				&& ((this.getDate() == castOther.getDate()) || (this.getDate() != null && castOther.getDate() != null && this.getDate().equals(
						castOther.getDate())))
				&& ((this.getPcode() == castOther.getPcode()) || (this.getPcode() != null && castOther.getPcode() != null && this.getPcode().equals(
						castOther.getPcode())))
				&& ((this.getDescription() == castOther.getDescription()) || (this.getDescription() != null && castOther.getDescription() != null && this
						.getDescription().equals(castOther.getDescription())))
				&& ((this.getMedia() == castOther.getMedia()) || (this.getMedia() != null && castOther.getMedia() != null && this.getMedia().equals(
						castOther.getMedia())))
				&& ((this.getDealBy() == castOther.getDealBy()) || (this.getDealBy() != null && castOther.getDealBy() != null && this.getDealBy()
						.equals(castOther.getDealBy())))
				&& ((this.getFno() == castOther.getFno()) || (this.getFno() != null && castOther.getFno() != null && this.getFno().equals(
						castOther.getFno())))
				&& ((this.getFtime() == castOther.getFtime()) || (this.getFtime() != null && castOther.getFtime() != null && this.getFtime().equals(
						castOther.getFtime())))
				&& ((this.getRemDate() == castOther.getRemDate()) || (this.getRemDate() != null && castOther.getRemDate() != null && this
						.getRemDate().equals(castOther.getRemDate())))
				&& ((this.getRemNote() == castOther.getRemNote()) || (this.getRemNote() != null && castOther.getRemNote() != null && this
						.getRemNote().equals(castOther.getRemNote())))
				&& ((this.getRemTime() == castOther.getRemTime()) || (this.getRemTime() != null && castOther.getRemTime() != null && this
						.getRemTime().equals(castOther.getRemTime())))
				&& ((this.getTag() == castOther.getTag()) || (this.getTag() != null && castOther.getTag() != null && this.getTag().equals(
						castOther.getTag())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdNo() == null ? 0 : this.getIdNo().hashCode());
		result = 37 * result + (getYy() == null ? 0 : this.getYy().hashCode());
		result = 37 * result + (getCoCode() == null ? 0 : this.getCoCode().hashCode());
		result = 37 * result + (getEnquiryNo() == null ? 0 : this.getEnquiryNo().hashCode());
		result = 37 * result + (getDate() == null ? 0 : this.getDate().hashCode());
		result = 37 * result + (getPcode() == null ? 0 : this.getPcode().hashCode());
		result = 37 * result + (getDescription() == null ? 0 : this.getDescription().hashCode());
		result = 37 * result + (getMedia() == null ? 0 : this.getMedia().hashCode());
		result = 37 * result + (getDealBy() == null ? 0 : this.getDealBy().hashCode());
		result = 37 * result + (getFno() == null ? 0 : this.getFno().hashCode());
		result = 37 * result + (getFtime() == null ? 0 : this.getFtime().hashCode());
		result = 37 * result + (getRemDate() == null ? 0 : this.getRemDate().hashCode());
		result = 37 * result + (getRemNote() == null ? 0 : this.getRemNote().hashCode());
		result = 37 * result + (getRemTime() == null ? 0 : this.getRemTime().hashCode());
		result = 37 * result + (getTag() == null ? 0 : this.getTag().hashCode());
		return result;
	}

}
