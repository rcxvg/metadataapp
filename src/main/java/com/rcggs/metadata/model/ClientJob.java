package com.rcggs.metadata.model;

public class ClientJob {

	private int jobId;
	private int jobActiveFlag;
	private int jobOrder;
	private int	unitTestActiveFlag;
	private int	appId;
	private int	clientId;
	private String endTs;
	
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getJobActiveFlag() {
		return jobActiveFlag;
	}
	public void setJobActiveFlag(int jobActiveFlag) {
		this.jobActiveFlag = jobActiveFlag;
	}
	public int getJobOrder() {
		return jobOrder;
	}
	public void setJobOrder(int jobOrder) {
		this.jobOrder = jobOrder;
	}
	public int getUnitTestActiveFlag() {
		return unitTestActiveFlag;
	}
	public void setUnitTestActiveFlag(int unitTestActiveFlag) {
		this.unitTestActiveFlag = unitTestActiveFlag;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getEndTs() {
		return endTs;
	}
	public void setEndTs(String endTs) {
		this.endTs = endTs;
	}
	
}
