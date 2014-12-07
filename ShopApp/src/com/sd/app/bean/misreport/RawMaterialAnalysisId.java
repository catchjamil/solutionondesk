package com.sd.app.bean.misreport;

// Generated Nov 22, 2014 1:06:28 PM by Hibernate Tools 3.4.0.CR1

/**
 * RawMaterialAnalysisId generated by hbm2java
 */
public class RawMaterialAnalysisId implements java.io.Serializable {

	private Float month;
	private Float year;
	private Float thick;
	private String icode;
	private String material;
	private Double purSqMtr;
	private Double issSqMtr;
	private Double saleSqMtr;
	private Double ordSqMtr;
	private Float opSqMtr;
	private Float clSqMtr;
	private Float srNo;
	private String monthName;
	private String itCode;
	private Float analysis;

	public RawMaterialAnalysisId() {
	}

	public RawMaterialAnalysisId(Float month, Float year, Float thick, String icode, String material, Double purSqMtr, Double issSqMtr,
			Double saleSqMtr, Double ordSqMtr, Float opSqMtr, Float clSqMtr, Float srNo, String monthName, String itCode, Float analysis) {
		this.month = month;
		this.year = year;
		this.thick = thick;
		this.icode = icode;
		this.material = material;
		this.purSqMtr = purSqMtr;
		this.issSqMtr = issSqMtr;
		this.saleSqMtr = saleSqMtr;
		this.ordSqMtr = ordSqMtr;
		this.opSqMtr = opSqMtr;
		this.clSqMtr = clSqMtr;
		this.srNo = srNo;
		this.monthName = monthName;
		this.itCode = itCode;
		this.analysis = analysis;
	}

	public Float getMonth() {
		return this.month;
	}

	public void setMonth(Float month) {
		this.month = month;
	}

	public Float getYear() {
		return this.year;
	}

	public void setYear(Float year) {
		this.year = year;
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

	public Double getPurSqMtr() {
		return this.purSqMtr;
	}

	public void setPurSqMtr(Double purSqMtr) {
		this.purSqMtr = purSqMtr;
	}

	public Double getIssSqMtr() {
		return this.issSqMtr;
	}

	public void setIssSqMtr(Double issSqMtr) {
		this.issSqMtr = issSqMtr;
	}

	public Double getSaleSqMtr() {
		return this.saleSqMtr;
	}

	public void setSaleSqMtr(Double saleSqMtr) {
		this.saleSqMtr = saleSqMtr;
	}

	public Double getOrdSqMtr() {
		return this.ordSqMtr;
	}

	public void setOrdSqMtr(Double ordSqMtr) {
		this.ordSqMtr = ordSqMtr;
	}

	public Float getOpSqMtr() {
		return this.opSqMtr;
	}

	public void setOpSqMtr(Float opSqMtr) {
		this.opSqMtr = opSqMtr;
	}

	public Float getClSqMtr() {
		return this.clSqMtr;
	}

	public void setClSqMtr(Float clSqMtr) {
		this.clSqMtr = clSqMtr;
	}

	public Float getSrNo() {
		return this.srNo;
	}

	public void setSrNo(Float srNo) {
		this.srNo = srNo;
	}

	public String getMonthName() {
		return this.monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public String getItCode() {
		return this.itCode;
	}

	public void setItCode(String itCode) {
		this.itCode = itCode;
	}

	public Float getAnalysis() {
		return this.analysis;
	}

	public void setAnalysis(Float analysis) {
		this.analysis = analysis;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RawMaterialAnalysisId))
			return false;
		RawMaterialAnalysisId castOther = (RawMaterialAnalysisId) other;

		return ((this.getMonth() == castOther.getMonth()) || (this.getMonth() != null && castOther.getMonth() != null && this.getMonth().equals(
				castOther.getMonth())))
				&& ((this.getYear() == castOther.getYear()) || (this.getYear() != null && castOther.getYear() != null && this.getYear().equals(
						castOther.getYear())))
				&& ((this.getThick() == castOther.getThick()) || (this.getThick() != null && castOther.getThick() != null && this.getThick().equals(
						castOther.getThick())))
				&& ((this.getIcode() == castOther.getIcode()) || (this.getIcode() != null && castOther.getIcode() != null && this.getIcode().equals(
						castOther.getIcode())))
				&& ((this.getMaterial() == castOther.getMaterial()) || (this.getMaterial() != null && castOther.getMaterial() != null && this
						.getMaterial().equals(castOther.getMaterial())))
				&& ((this.getPurSqMtr() == castOther.getPurSqMtr()) || (this.getPurSqMtr() != null && castOther.getPurSqMtr() != null && this
						.getPurSqMtr().equals(castOther.getPurSqMtr())))
				&& ((this.getIssSqMtr() == castOther.getIssSqMtr()) || (this.getIssSqMtr() != null && castOther.getIssSqMtr() != null && this
						.getIssSqMtr().equals(castOther.getIssSqMtr())))
				&& ((this.getSaleSqMtr() == castOther.getSaleSqMtr()) || (this.getSaleSqMtr() != null && castOther.getSaleSqMtr() != null && this
						.getSaleSqMtr().equals(castOther.getSaleSqMtr())))
				&& ((this.getOrdSqMtr() == castOther.getOrdSqMtr()) || (this.getOrdSqMtr() != null && castOther.getOrdSqMtr() != null && this
						.getOrdSqMtr().equals(castOther.getOrdSqMtr())))
				&& ((this.getOpSqMtr() == castOther.getOpSqMtr()) || (this.getOpSqMtr() != null && castOther.getOpSqMtr() != null && this
						.getOpSqMtr().equals(castOther.getOpSqMtr())))
				&& ((this.getClSqMtr() == castOther.getClSqMtr()) || (this.getClSqMtr() != null && castOther.getClSqMtr() != null && this
						.getClSqMtr().equals(castOther.getClSqMtr())))
				&& ((this.getSrNo() == castOther.getSrNo()) || (this.getSrNo() != null && castOther.getSrNo() != null && this.getSrNo().equals(
						castOther.getSrNo())))
				&& ((this.getMonthName() == castOther.getMonthName()) || (this.getMonthName() != null && castOther.getMonthName() != null && this
						.getMonthName().equals(castOther.getMonthName())))
				&& ((this.getItCode() == castOther.getItCode()) || (this.getItCode() != null && castOther.getItCode() != null && this.getItCode()
						.equals(castOther.getItCode())))
				&& ((this.getAnalysis() == castOther.getAnalysis()) || (this.getAnalysis() != null && castOther.getAnalysis() != null && this
						.getAnalysis().equals(castOther.getAnalysis())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMonth() == null ? 0 : this.getMonth().hashCode());
		result = 37 * result + (getYear() == null ? 0 : this.getYear().hashCode());
		result = 37 * result + (getThick() == null ? 0 : this.getThick().hashCode());
		result = 37 * result + (getIcode() == null ? 0 : this.getIcode().hashCode());
		result = 37 * result + (getMaterial() == null ? 0 : this.getMaterial().hashCode());
		result = 37 * result + (getPurSqMtr() == null ? 0 : this.getPurSqMtr().hashCode());
		result = 37 * result + (getIssSqMtr() == null ? 0 : this.getIssSqMtr().hashCode());
		result = 37 * result + (getSaleSqMtr() == null ? 0 : this.getSaleSqMtr().hashCode());
		result = 37 * result + (getOrdSqMtr() == null ? 0 : this.getOrdSqMtr().hashCode());
		result = 37 * result + (getOpSqMtr() == null ? 0 : this.getOpSqMtr().hashCode());
		result = 37 * result + (getClSqMtr() == null ? 0 : this.getClSqMtr().hashCode());
		result = 37 * result + (getSrNo() == null ? 0 : this.getSrNo().hashCode());
		result = 37 * result + (getMonthName() == null ? 0 : this.getMonthName().hashCode());
		result = 37 * result + (getItCode() == null ? 0 : this.getItCode().hashCode());
		result = 37 * result + (getAnalysis() == null ? 0 : this.getAnalysis().hashCode());
		return result;
	}

}
