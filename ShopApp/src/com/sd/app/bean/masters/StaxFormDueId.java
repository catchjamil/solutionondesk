package com.sd.app.bean.masters;

// Generated Nov 22, 2014 1:22:06 PM by Hibernate Tools 3.4.0.CR1

/**
 * StaxFormDueId generated by hbm2java
 */
public class StaxFormDueId implements java.io.Serializable {

	private String staxForm;
	private String print;

	public StaxFormDueId() {
	}

	public StaxFormDueId(String staxForm, String print) {
		this.staxForm = staxForm;
		this.print = print;
	}

	public String getStaxForm() {
		return this.staxForm;
	}

	public void setStaxForm(String staxForm) {
		this.staxForm = staxForm;
	}

	public String getPrint() {
		return this.print;
	}

	public void setPrint(String print) {
		this.print = print;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StaxFormDueId))
			return false;
		StaxFormDueId castOther = (StaxFormDueId) other;

		return ((this.getStaxForm() == castOther.getStaxForm()) || (this.getStaxForm() != null && castOther.getStaxForm() != null && this
				.getStaxForm().equals(castOther.getStaxForm())))
				&& ((this.getPrint() == castOther.getPrint()) || (this.getPrint() != null && castOther.getPrint() != null && this.getPrint().equals(
						castOther.getPrint())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getStaxForm() == null ? 0 : this.getStaxForm().hashCode());
		result = 37 * result + (getPrint() == null ? 0 : this.getPrint().hashCode());
		return result;
	}

}