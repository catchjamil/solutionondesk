package com.sd.app.bean.orders;

// Generated Nov 22, 2014 1:10:42 PM by Hibernate Tools 3.4.0.CR1

/**
 * OrderMasterId generated by hbm2java
 */
public class OrderMasterId implements java.io.Serializable {

	private String orderNo;
	private Integer pcode;
	private String type;
	private String sizeIn;
	private String staxForm;
	private String rtable;
	private String stable;
	private String exTable;
	private Float discount;
	private Boolean jobWork;
	private String packing;
	private String prodInst;
	private String documInst;
	private Boolean pending;
	private Boolean printed;
	private Short prepBy;
	private Short application;
	private Boolean decorative;
	private String tariff;
	private Boolean tag;
	private String chlNo;
	private String chlType;
	private String logo;
	private Short delMode;
	private Short despEncloser;
	private String approvedBy;
	private String custRefNo;
	private String despatchAddress;
	private String quotno;
	private String preparedBy;

	public OrderMasterId() {
	}

	public OrderMasterId(String orderNo, Integer pcode, String type, String sizeIn, String staxForm, String rtable, String stable, String exTable,
			Float discount, Boolean jobWork, String packing, String prodInst, String documInst, Boolean pending, Boolean printed, Short prepBy,
			Short application, Boolean decorative, String tariff, Boolean tag, String chlNo, String chlType, String logo, Short delMode,
			Short despEncloser, String approvedBy, String custRefNo, String despatchAddress, String quotno, String preparedBy) {
		this.orderNo = orderNo;
		this.pcode = pcode;
		this.type = type;
		this.sizeIn = sizeIn;
		this.staxForm = staxForm;
		this.rtable = rtable;
		this.stable = stable;
		this.exTable = exTable;
		this.discount = discount;
		this.jobWork = jobWork;
		this.packing = packing;
		this.prodInst = prodInst;
		this.documInst = documInst;
		this.pending = pending;
		this.printed = printed;
		this.prepBy = prepBy;
		this.application = application;
		this.decorative = decorative;
		this.tariff = tariff;
		this.tag = tag;
		this.chlNo = chlNo;
		this.chlType = chlType;
		this.logo = logo;
		this.delMode = delMode;
		this.despEncloser = despEncloser;
		this.approvedBy = approvedBy;
		this.custRefNo = custRefNo;
		this.despatchAddress = despatchAddress;
		this.quotno = quotno;
		this.preparedBy = preparedBy;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getPcode() {
		return this.pcode;
	}

	public void setPcode(Integer pcode) {
		this.pcode = pcode;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSizeIn() {
		return this.sizeIn;
	}

	public void setSizeIn(String sizeIn) {
		this.sizeIn = sizeIn;
	}

	public String getStaxForm() {
		return this.staxForm;
	}

	public void setStaxForm(String staxForm) {
		this.staxForm = staxForm;
	}

	public String getRtable() {
		return this.rtable;
	}

	public void setRtable(String rtable) {
		this.rtable = rtable;
	}

	public String getStable() {
		return this.stable;
	}

	public void setStable(String stable) {
		this.stable = stable;
	}

	public String getExTable() {
		return this.exTable;
	}

	public void setExTable(String exTable) {
		this.exTable = exTable;
	}

	public Float getDiscount() {
		return this.discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Boolean getJobWork() {
		return this.jobWork;
	}

	public void setJobWork(Boolean jobWork) {
		this.jobWork = jobWork;
	}

	public String getPacking() {
		return this.packing;
	}

	public void setPacking(String packing) {
		this.packing = packing;
	}

	public String getProdInst() {
		return this.prodInst;
	}

	public void setProdInst(String prodInst) {
		this.prodInst = prodInst;
	}

	public String getDocumInst() {
		return this.documInst;
	}

	public void setDocumInst(String documInst) {
		this.documInst = documInst;
	}

	public Boolean getPending() {
		return this.pending;
	}

	public void setPending(Boolean pending) {
		this.pending = pending;
	}

	public Boolean getPrinted() {
		return this.printed;
	}

	public void setPrinted(Boolean printed) {
		this.printed = printed;
	}

	public Short getPrepBy() {
		return this.prepBy;
	}

	public void setPrepBy(Short prepBy) {
		this.prepBy = prepBy;
	}

	public Short getApplication() {
		return this.application;
	}

	public void setApplication(Short application) {
		this.application = application;
	}

	public Boolean getDecorative() {
		return this.decorative;
	}

	public void setDecorative(Boolean decorative) {
		this.decorative = decorative;
	}

	public String getTariff() {
		return this.tariff;
	}

	public void setTariff(String tariff) {
		this.tariff = tariff;
	}

	public Boolean getTag() {
		return this.tag;
	}

	public void setTag(Boolean tag) {
		this.tag = tag;
	}

	public String getChlNo() {
		return this.chlNo;
	}

	public void setChlNo(String chlNo) {
		this.chlNo = chlNo;
	}

	public String getChlType() {
		return this.chlType;
	}

	public void setChlType(String chlType) {
		this.chlType = chlType;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Short getDelMode() {
		return this.delMode;
	}

	public void setDelMode(Short delMode) {
		this.delMode = delMode;
	}

	public Short getDespEncloser() {
		return this.despEncloser;
	}

	public void setDespEncloser(Short despEncloser) {
		this.despEncloser = despEncloser;
	}

	public String getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getCustRefNo() {
		return this.custRefNo;
	}

	public void setCustRefNo(String custRefNo) {
		this.custRefNo = custRefNo;
	}

	public String getDespatchAddress() {
		return this.despatchAddress;
	}

	public void setDespatchAddress(String despatchAddress) {
		this.despatchAddress = despatchAddress;
	}

	public String getQuotno() {
		return this.quotno;
	}

	public void setQuotno(String quotno) {
		this.quotno = quotno;
	}

	public String getPreparedBy() {
		return this.preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderMasterId))
			return false;
		OrderMasterId castOther = (OrderMasterId) other;

		return ((this.getOrderNo() == castOther.getOrderNo()) || (this.getOrderNo() != null && castOther.getOrderNo() != null && this.getOrderNo()
				.equals(castOther.getOrderNo())))
				&& ((this.getPcode() == castOther.getPcode()) || (this.getPcode() != null && castOther.getPcode() != null && this.getPcode().equals(
						castOther.getPcode())))
				&& ((this.getType() == castOther.getType()) || (this.getType() != null && castOther.getType() != null && this.getType().equals(
						castOther.getType())))
				&& ((this.getSizeIn() == castOther.getSizeIn()) || (this.getSizeIn() != null && castOther.getSizeIn() != null && this.getSizeIn()
						.equals(castOther.getSizeIn())))
				&& ((this.getStaxForm() == castOther.getStaxForm()) || (this.getStaxForm() != null && castOther.getStaxForm() != null && this
						.getStaxForm().equals(castOther.getStaxForm())))
				&& ((this.getRtable() == castOther.getRtable()) || (this.getRtable() != null && castOther.getRtable() != null && this.getRtable()
						.equals(castOther.getRtable())))
				&& ((this.getStable() == castOther.getStable()) || (this.getStable() != null && castOther.getStable() != null && this.getStable()
						.equals(castOther.getStable())))
				&& ((this.getExTable() == castOther.getExTable()) || (this.getExTable() != null && castOther.getExTable() != null && this
						.getExTable().equals(castOther.getExTable())))
				&& ((this.getDiscount() == castOther.getDiscount()) || (this.getDiscount() != null && castOther.getDiscount() != null && this
						.getDiscount().equals(castOther.getDiscount())))
				&& ((this.getJobWork() == castOther.getJobWork()) || (this.getJobWork() != null && castOther.getJobWork() != null && this
						.getJobWork().equals(castOther.getJobWork())))
				&& ((this.getPacking() == castOther.getPacking()) || (this.getPacking() != null && castOther.getPacking() != null && this
						.getPacking().equals(castOther.getPacking())))
				&& ((this.getProdInst() == castOther.getProdInst()) || (this.getProdInst() != null && castOther.getProdInst() != null && this
						.getProdInst().equals(castOther.getProdInst())))
				&& ((this.getDocumInst() == castOther.getDocumInst()) || (this.getDocumInst() != null && castOther.getDocumInst() != null && this
						.getDocumInst().equals(castOther.getDocumInst())))
				&& ((this.getPending() == castOther.getPending()) || (this.getPending() != null && castOther.getPending() != null && this
						.getPending().equals(castOther.getPending())))
				&& ((this.getPrinted() == castOther.getPrinted()) || (this.getPrinted() != null && castOther.getPrinted() != null && this
						.getPrinted().equals(castOther.getPrinted())))
				&& ((this.getPrepBy() == castOther.getPrepBy()) || (this.getPrepBy() != null && castOther.getPrepBy() != null && this.getPrepBy()
						.equals(castOther.getPrepBy())))
				&& ((this.getApplication() == castOther.getApplication()) || (this.getApplication() != null && castOther.getApplication() != null && this
						.getApplication().equals(castOther.getApplication())))
				&& ((this.getDecorative() == castOther.getDecorative()) || (this.getDecorative() != null && castOther.getDecorative() != null && this
						.getDecorative().equals(castOther.getDecorative())))
				&& ((this.getTariff() == castOther.getTariff()) || (this.getTariff() != null && castOther.getTariff() != null && this.getTariff()
						.equals(castOther.getTariff())))
				&& ((this.getTag() == castOther.getTag()) || (this.getTag() != null && castOther.getTag() != null && this.getTag().equals(
						castOther.getTag())))
				&& ((this.getChlNo() == castOther.getChlNo()) || (this.getChlNo() != null && castOther.getChlNo() != null && this.getChlNo().equals(
						castOther.getChlNo())))
				&& ((this.getChlType() == castOther.getChlType()) || (this.getChlType() != null && castOther.getChlType() != null && this
						.getChlType().equals(castOther.getChlType())))
				&& ((this.getLogo() == castOther.getLogo()) || (this.getLogo() != null && castOther.getLogo() != null && this.getLogo().equals(
						castOther.getLogo())))
				&& ((this.getDelMode() == castOther.getDelMode()) || (this.getDelMode() != null && castOther.getDelMode() != null && this
						.getDelMode().equals(castOther.getDelMode())))
				&& ((this.getDespEncloser() == castOther.getDespEncloser()) || (this.getDespEncloser() != null && castOther.getDespEncloser() != null && this
						.getDespEncloser().equals(castOther.getDespEncloser())))
				&& ((this.getApprovedBy() == castOther.getApprovedBy()) || (this.getApprovedBy() != null && castOther.getApprovedBy() != null && this
						.getApprovedBy().equals(castOther.getApprovedBy())))
				&& ((this.getCustRefNo() == castOther.getCustRefNo()) || (this.getCustRefNo() != null && castOther.getCustRefNo() != null && this
						.getCustRefNo().equals(castOther.getCustRefNo())))
				&& ((this.getDespatchAddress() == castOther.getDespatchAddress()) || (this.getDespatchAddress() != null
						&& castOther.getDespatchAddress() != null && this.getDespatchAddress().equals(castOther.getDespatchAddress())))
				&& ((this.getQuotno() == castOther.getQuotno()) || (this.getQuotno() != null && castOther.getQuotno() != null && this.getQuotno()
						.equals(castOther.getQuotno())))
				&& ((this.getPreparedBy() == castOther.getPreparedBy()) || (this.getPreparedBy() != null && castOther.getPreparedBy() != null && this
						.getPreparedBy().equals(castOther.getPreparedBy())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getOrderNo() == null ? 0 : this.getOrderNo().hashCode());
		result = 37 * result + (getPcode() == null ? 0 : this.getPcode().hashCode());
		result = 37 * result + (getType() == null ? 0 : this.getType().hashCode());
		result = 37 * result + (getSizeIn() == null ? 0 : this.getSizeIn().hashCode());
		result = 37 * result + (getStaxForm() == null ? 0 : this.getStaxForm().hashCode());
		result = 37 * result + (getRtable() == null ? 0 : this.getRtable().hashCode());
		result = 37 * result + (getStable() == null ? 0 : this.getStable().hashCode());
		result = 37 * result + (getExTable() == null ? 0 : this.getExTable().hashCode());
		result = 37 * result + (getDiscount() == null ? 0 : this.getDiscount().hashCode());
		result = 37 * result + (getJobWork() == null ? 0 : this.getJobWork().hashCode());
		result = 37 * result + (getPacking() == null ? 0 : this.getPacking().hashCode());
		result = 37 * result + (getProdInst() == null ? 0 : this.getProdInst().hashCode());
		result = 37 * result + (getDocumInst() == null ? 0 : this.getDocumInst().hashCode());
		result = 37 * result + (getPending() == null ? 0 : this.getPending().hashCode());
		result = 37 * result + (getPrinted() == null ? 0 : this.getPrinted().hashCode());
		result = 37 * result + (getPrepBy() == null ? 0 : this.getPrepBy().hashCode());
		result = 37 * result + (getApplication() == null ? 0 : this.getApplication().hashCode());
		result = 37 * result + (getDecorative() == null ? 0 : this.getDecorative().hashCode());
		result = 37 * result + (getTariff() == null ? 0 : this.getTariff().hashCode());
		result = 37 * result + (getTag() == null ? 0 : this.getTag().hashCode());
		result = 37 * result + (getChlNo() == null ? 0 : this.getChlNo().hashCode());
		result = 37 * result + (getChlType() == null ? 0 : this.getChlType().hashCode());
		result = 37 * result + (getLogo() == null ? 0 : this.getLogo().hashCode());
		result = 37 * result + (getDelMode() == null ? 0 : this.getDelMode().hashCode());
		result = 37 * result + (getDespEncloser() == null ? 0 : this.getDespEncloser().hashCode());
		result = 37 * result + (getApprovedBy() == null ? 0 : this.getApprovedBy().hashCode());
		result = 37 * result + (getCustRefNo() == null ? 0 : this.getCustRefNo().hashCode());
		result = 37 * result + (getDespatchAddress() == null ? 0 : this.getDespatchAddress().hashCode());
		result = 37 * result + (getQuotno() == null ? 0 : this.getQuotno().hashCode());
		result = 37 * result + (getPreparedBy() == null ? 0 : this.getPreparedBy().hashCode());
		return result;
	}

}
