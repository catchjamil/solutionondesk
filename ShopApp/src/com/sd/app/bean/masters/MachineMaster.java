package com.sd.app.bean.masters;

// Generated Nov 22, 2014 1:22:06 PM by Hibernate Tools 3.4.0.CR1

/**
 * MachineMaster generated by hbm2java
 */
public class MachineMaster implements java.io.Serializable {

	private Short machineCode;
	private String machineType;
	private String machineName;
	private Short srNo;

	public MachineMaster() {
	}

	public MachineMaster(Short machineCode) {
		this.machineCode = machineCode;
	}

	public MachineMaster(Short machineCode, String machineType, String machineName, Short srNo) {
		this.machineCode = machineCode;
		this.machineType = machineType;
		this.machineName = machineName;
		this.srNo = srNo;
	}

	public Short getMachineCode() {
		return this.machineCode;
	}

	public void setMachineCode(Short machineCode) {
		this.machineCode = machineCode;
	}

	public String getMachineType() {
		return this.machineType;
	}

	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	public String getMachineName() {
		return this.machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public Short getSrNo() {
		return this.srNo;
	}

	public void setSrNo(Short srNo) {
		this.srNo = srNo;
	}

}