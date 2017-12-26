package com.rcggs.metadata.model;

public class JobUnit {
	
	private int jobId;
	private int unitId;
	private int unitTypeId;
	private String unitDesc;
	private int unitActiveFlag;
	private int unitOrder;
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getUnitId() {
		return unitId;
	}
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	public int getUnitTypeId() {
		return unitTypeId;
	}
	public void setUnitTypeId(int unitTypeId) {
		this.unitTypeId = unitTypeId;
	}
	public String getUnitDesc() {
		return unitDesc;
	}
	public void setUnitDesc(String unitDesc) {
		this.unitDesc = unitDesc;
	}
	public int getUnitActiveFlag() {
		return unitActiveFlag;
	}
	public void setUnitActiveFlag(int unitActiveFlag) {
		this.unitActiveFlag = unitActiveFlag;
	}
	public int getUnitOrder() {
		return unitOrder;
	}
	public void setUnitOrder(int unitOrder) {
		this.unitOrder = unitOrder;
	}
}
