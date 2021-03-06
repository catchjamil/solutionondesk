package com.sd.app.bean.production;

// Generated Nov 22, 2014 1:12:39 PM by Hibernate Tools 3.4.0.CR1

/**
 * OptHeadId generated by hbm2java
 */
public class OptHeadId implements java.io.Serializable {

	private String head;
	private Float nitm;
	private Float nopt;
	private String gtyp;
	private String artnr;
	private String jobid;
	private Float ntext;
	private Float kvalue;
	private String jobDesc;
	private String append;
	private String para;
	private String ftype;
	private Float seqMo;
	private Float rackMo;
	private Float maxRack;
	private String free;
	private String xflag;

	public OptHeadId() {
	}

	public OptHeadId(String head, Float nitm, Float nopt, String gtyp, String artnr, String jobid, Float ntext, Float kvalue, String jobDesc,
			String append, String para, String ftype, Float seqMo, Float rackMo, Float maxRack, String free, String xflag) {
		this.head = head;
		this.nitm = nitm;
		this.nopt = nopt;
		this.gtyp = gtyp;
		this.artnr = artnr;
		this.jobid = jobid;
		this.ntext = ntext;
		this.kvalue = kvalue;
		this.jobDesc = jobDesc;
		this.append = append;
		this.para = para;
		this.ftype = ftype;
		this.seqMo = seqMo;
		this.rackMo = rackMo;
		this.maxRack = maxRack;
		this.free = free;
		this.xflag = xflag;
	}

	public String getHead() {
		return this.head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Float getNitm() {
		return this.nitm;
	}

	public void setNitm(Float nitm) {
		this.nitm = nitm;
	}

	public Float getNopt() {
		return this.nopt;
	}

	public void setNopt(Float nopt) {
		this.nopt = nopt;
	}

	public String getGtyp() {
		return this.gtyp;
	}

	public void setGtyp(String gtyp) {
		this.gtyp = gtyp;
	}

	public String getArtnr() {
		return this.artnr;
	}

	public void setArtnr(String artnr) {
		this.artnr = artnr;
	}

	public String getJobid() {
		return this.jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public Float getNtext() {
		return this.ntext;
	}

	public void setNtext(Float ntext) {
		this.ntext = ntext;
	}

	public Float getKvalue() {
		return this.kvalue;
	}

	public void setKvalue(Float kvalue) {
		this.kvalue = kvalue;
	}

	public String getJobDesc() {
		return this.jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getAppend() {
		return this.append;
	}

	public void setAppend(String append) {
		this.append = append;
	}

	public String getPara() {
		return this.para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getFtype() {
		return this.ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public Float getSeqMo() {
		return this.seqMo;
	}

	public void setSeqMo(Float seqMo) {
		this.seqMo = seqMo;
	}

	public Float getRackMo() {
		return this.rackMo;
	}

	public void setRackMo(Float rackMo) {
		this.rackMo = rackMo;
	}

	public Float getMaxRack() {
		return this.maxRack;
	}

	public void setMaxRack(Float maxRack) {
		this.maxRack = maxRack;
	}

	public String getFree() {
		return this.free;
	}

	public void setFree(String free) {
		this.free = free;
	}

	public String getXflag() {
		return this.xflag;
	}

	public void setXflag(String xflag) {
		this.xflag = xflag;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OptHeadId))
			return false;
		OptHeadId castOther = (OptHeadId) other;

		return ((this.getHead() == castOther.getHead()) || (this.getHead() != null && castOther.getHead() != null && this.getHead().equals(
				castOther.getHead())))
				&& ((this.getNitm() == castOther.getNitm()) || (this.getNitm() != null && castOther.getNitm() != null && this.getNitm().equals(
						castOther.getNitm())))
				&& ((this.getNopt() == castOther.getNopt()) || (this.getNopt() != null && castOther.getNopt() != null && this.getNopt().equals(
						castOther.getNopt())))
				&& ((this.getGtyp() == castOther.getGtyp()) || (this.getGtyp() != null && castOther.getGtyp() != null && this.getGtyp().equals(
						castOther.getGtyp())))
				&& ((this.getArtnr() == castOther.getArtnr()) || (this.getArtnr() != null && castOther.getArtnr() != null && this.getArtnr().equals(
						castOther.getArtnr())))
				&& ((this.getJobid() == castOther.getJobid()) || (this.getJobid() != null && castOther.getJobid() != null && this.getJobid().equals(
						castOther.getJobid())))
				&& ((this.getNtext() == castOther.getNtext()) || (this.getNtext() != null && castOther.getNtext() != null && this.getNtext().equals(
						castOther.getNtext())))
				&& ((this.getKvalue() == castOther.getKvalue()) || (this.getKvalue() != null && castOther.getKvalue() != null && this.getKvalue()
						.equals(castOther.getKvalue())))
				&& ((this.getJobDesc() == castOther.getJobDesc()) || (this.getJobDesc() != null && castOther.getJobDesc() != null && this
						.getJobDesc().equals(castOther.getJobDesc())))
				&& ((this.getAppend() == castOther.getAppend()) || (this.getAppend() != null && castOther.getAppend() != null && this.getAppend()
						.equals(castOther.getAppend())))
				&& ((this.getPara() == castOther.getPara()) || (this.getPara() != null && castOther.getPara() != null && this.getPara().equals(
						castOther.getPara())))
				&& ((this.getFtype() == castOther.getFtype()) || (this.getFtype() != null && castOther.getFtype() != null && this.getFtype().equals(
						castOther.getFtype())))
				&& ((this.getSeqMo() == castOther.getSeqMo()) || (this.getSeqMo() != null && castOther.getSeqMo() != null && this.getSeqMo().equals(
						castOther.getSeqMo())))
				&& ((this.getRackMo() == castOther.getRackMo()) || (this.getRackMo() != null && castOther.getRackMo() != null && this.getRackMo()
						.equals(castOther.getRackMo())))
				&& ((this.getMaxRack() == castOther.getMaxRack()) || (this.getMaxRack() != null && castOther.getMaxRack() != null && this
						.getMaxRack().equals(castOther.getMaxRack())))
				&& ((this.getFree() == castOther.getFree()) || (this.getFree() != null && castOther.getFree() != null && this.getFree().equals(
						castOther.getFree())))
				&& ((this.getXflag() == castOther.getXflag()) || (this.getXflag() != null && castOther.getXflag() != null && this.getXflag().equals(
						castOther.getXflag())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getHead() == null ? 0 : this.getHead().hashCode());
		result = 37 * result + (getNitm() == null ? 0 : this.getNitm().hashCode());
		result = 37 * result + (getNopt() == null ? 0 : this.getNopt().hashCode());
		result = 37 * result + (getGtyp() == null ? 0 : this.getGtyp().hashCode());
		result = 37 * result + (getArtnr() == null ? 0 : this.getArtnr().hashCode());
		result = 37 * result + (getJobid() == null ? 0 : this.getJobid().hashCode());
		result = 37 * result + (getNtext() == null ? 0 : this.getNtext().hashCode());
		result = 37 * result + (getKvalue() == null ? 0 : this.getKvalue().hashCode());
		result = 37 * result + (getJobDesc() == null ? 0 : this.getJobDesc().hashCode());
		result = 37 * result + (getAppend() == null ? 0 : this.getAppend().hashCode());
		result = 37 * result + (getPara() == null ? 0 : this.getPara().hashCode());
		result = 37 * result + (getFtype() == null ? 0 : this.getFtype().hashCode());
		result = 37 * result + (getSeqMo() == null ? 0 : this.getSeqMo().hashCode());
		result = 37 * result + (getRackMo() == null ? 0 : this.getRackMo().hashCode());
		result = 37 * result + (getMaxRack() == null ? 0 : this.getMaxRack().hashCode());
		result = 37 * result + (getFree() == null ? 0 : this.getFree().hashCode());
		result = 37 * result + (getXflag() == null ? 0 : this.getXflag().hashCode());
		return result;
	}

}
