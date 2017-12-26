package com.rcggs.metadata.model;

public class LoadMap {
	
	private int jobId;
	private int unitId;
	private int taskId;
	private String sourceColumnName;
	private String targetColumnName;
	private int columnOrder;
	private int columnTypeId;
	private int keyInd;
	private int activeFlag;
	private String dqFilter;
	
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
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getSourceColumnName() {
		return sourceColumnName;
	}
	public void setSourceColumnName(String sourceColumnName) {
		this.sourceColumnName = sourceColumnName;
	}
	public String getTargetColumnName() {
		return targetColumnName;
	}
	public void setTargetColumnName(String targetColumnName) {
		this.targetColumnName = targetColumnName;
	}
	public int getColumnOrder() {
		return columnOrder;
	}
	public void setColumnOrder(int columnOrder) {
		this.columnOrder = columnOrder;
	}
	public int getColumnTypeId() {
		return columnTypeId;
	}
	public void setColumnTypeId(int columnTypeId) {
		this.columnTypeId = columnTypeId;
	}
	public int getKeyInd() {
		return keyInd;
	}
	public void setKeyInd(int keyInd) {
		this.keyInd = keyInd;
	}
	public int getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getDqFilter() {
		return dqFilter;
	}
	public void setDqFilter(String dqFilter) {
		this.dqFilter = dqFilter;
	}
}
