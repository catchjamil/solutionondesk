package com.sd.app.bean.masters;

// Generated Nov 22, 2014 1:22:06 PM by Hibernate Tools 3.4.0.CR1

/**
 * UsersId generated by hbm2java
 */
public class UsersId implements java.io.Serializable {

	private Integer userIdNo;
	private String shortName;
	private String password;
	private Integer groupId;
	private Boolean login;
	private Boolean authBy;
	private Boolean dealby;
	private Boolean controller;
	private Boolean preparedBy;
	private Boolean supervisor;
	private String name;
	private Boolean dbsupervisor;
	private Boolean prodSupervisor;
	private Boolean showSales;

	public UsersId() {
	}

	public UsersId(Integer userIdNo, String shortName, String password, Integer groupId, Boolean login, Boolean authBy, Boolean dealby,
			Boolean controller, Boolean preparedBy, Boolean supervisor, String name, Boolean dbsupervisor, Boolean prodSupervisor, Boolean showSales) {
		this.userIdNo = userIdNo;
		this.shortName = shortName;
		this.password = password;
		this.groupId = groupId;
		this.login = login;
		this.authBy = authBy;
		this.dealby = dealby;
		this.controller = controller;
		this.preparedBy = preparedBy;
		this.supervisor = supervisor;
		this.name = name;
		this.dbsupervisor = dbsupervisor;
		this.prodSupervisor = prodSupervisor;
		this.showSales = showSales;
	}

	public Integer getUserIdNo() {
		return this.userIdNo;
	}

	public void setUserIdNo(Integer userIdNo) {
		this.userIdNo = userIdNo;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Boolean getLogin() {
		return this.login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}

	public Boolean getAuthBy() {
		return this.authBy;
	}

	public void setAuthBy(Boolean authBy) {
		this.authBy = authBy;
	}

	public Boolean getDealby() {
		return this.dealby;
	}

	public void setDealby(Boolean dealby) {
		this.dealby = dealby;
	}

	public Boolean getController() {
		return this.controller;
	}

	public void setController(Boolean controller) {
		this.controller = controller;
	}

	public Boolean getPreparedBy() {
		return this.preparedBy;
	}

	public void setPreparedBy(Boolean preparedBy) {
		this.preparedBy = preparedBy;
	}

	public Boolean getSupervisor() {
		return this.supervisor;
	}

	public void setSupervisor(Boolean supervisor) {
		this.supervisor = supervisor;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDbsupervisor() {
		return this.dbsupervisor;
	}

	public void setDbsupervisor(Boolean dbsupervisor) {
		this.dbsupervisor = dbsupervisor;
	}

	public Boolean getProdSupervisor() {
		return this.prodSupervisor;
	}

	public void setProdSupervisor(Boolean prodSupervisor) {
		this.prodSupervisor = prodSupervisor;
	}

	public Boolean getShowSales() {
		return this.showSales;
	}

	public void setShowSales(Boolean showSales) {
		this.showSales = showSales;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UsersId))
			return false;
		UsersId castOther = (UsersId) other;

		return ((this.getUserIdNo() == castOther.getUserIdNo()) || (this.getUserIdNo() != null && castOther.getUserIdNo() != null && this
				.getUserIdNo().equals(castOther.getUserIdNo())))
				&& ((this.getShortName() == castOther.getShortName()) || (this.getShortName() != null && castOther.getShortName() != null && this
						.getShortName().equals(castOther.getShortName())))
				&& ((this.getPassword() == castOther.getPassword()) || (this.getPassword() != null && castOther.getPassword() != null && this
						.getPassword().equals(castOther.getPassword())))
				&& ((this.getGroupId() == castOther.getGroupId()) || (this.getGroupId() != null && castOther.getGroupId() != null && this
						.getGroupId().equals(castOther.getGroupId())))
				&& ((this.getLogin() == castOther.getLogin()) || (this.getLogin() != null && castOther.getLogin() != null && this.getLogin().equals(
						castOther.getLogin())))
				&& ((this.getAuthBy() == castOther.getAuthBy()) || (this.getAuthBy() != null && castOther.getAuthBy() != null && this.getAuthBy()
						.equals(castOther.getAuthBy())))
				&& ((this.getDealby() == castOther.getDealby()) || (this.getDealby() != null && castOther.getDealby() != null && this.getDealby()
						.equals(castOther.getDealby())))
				&& ((this.getController() == castOther.getController()) || (this.getController() != null && castOther.getController() != null && this
						.getController().equals(castOther.getController())))
				&& ((this.getPreparedBy() == castOther.getPreparedBy()) || (this.getPreparedBy() != null && castOther.getPreparedBy() != null && this
						.getPreparedBy().equals(castOther.getPreparedBy())))
				&& ((this.getSupervisor() == castOther.getSupervisor()) || (this.getSupervisor() != null && castOther.getSupervisor() != null && this
						.getSupervisor().equals(castOther.getSupervisor())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null && this.getName().equals(
						castOther.getName())))
				&& ((this.getDbsupervisor() == castOther.getDbsupervisor()) || (this.getDbsupervisor() != null && castOther.getDbsupervisor() != null && this
						.getDbsupervisor().equals(castOther.getDbsupervisor())))
				&& ((this.getProdSupervisor() == castOther.getProdSupervisor()) || (this.getProdSupervisor() != null
						&& castOther.getProdSupervisor() != null && this.getProdSupervisor().equals(castOther.getProdSupervisor())))
				&& ((this.getShowSales() == castOther.getShowSales()) || (this.getShowSales() != null && castOther.getShowSales() != null && this
						.getShowSales().equals(castOther.getShowSales())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUserIdNo() == null ? 0 : this.getUserIdNo().hashCode());
		result = 37 * result + (getShortName() == null ? 0 : this.getShortName().hashCode());
		result = 37 * result + (getPassword() == null ? 0 : this.getPassword().hashCode());
		result = 37 * result + (getGroupId() == null ? 0 : this.getGroupId().hashCode());
		result = 37 * result + (getLogin() == null ? 0 : this.getLogin().hashCode());
		result = 37 * result + (getAuthBy() == null ? 0 : this.getAuthBy().hashCode());
		result = 37 * result + (getDealby() == null ? 0 : this.getDealby().hashCode());
		result = 37 * result + (getController() == null ? 0 : this.getController().hashCode());
		result = 37 * result + (getPreparedBy() == null ? 0 : this.getPreparedBy().hashCode());
		result = 37 * result + (getSupervisor() == null ? 0 : this.getSupervisor().hashCode());
		result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result + (getDbsupervisor() == null ? 0 : this.getDbsupervisor().hashCode());
		result = 37 * result + (getProdSupervisor() == null ? 0 : this.getProdSupervisor().hashCode());
		result = 37 * result + (getShowSales() == null ? 0 : this.getShowSales().hashCode());
		return result;
	}

}