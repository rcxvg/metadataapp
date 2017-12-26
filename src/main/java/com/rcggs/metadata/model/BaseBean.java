package com.rcggs.metadata.model;

public class BaseBean {
	
	private int jobId;
	private int fileRecTypeKey;
	private int activeFlag;
	private int unitId;
	private int taskId;
	private int columnOrder;
	private String sourceColumnName;
	private int columnTypeId;
	private String sourceTableName;
	private String targetTableName;
	private String stageTableName;
	private String stageColumnName;
	private int validationId;
	private int xformTypeId;
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getFileRecTypeKey() {
		return fileRecTypeKey;
	}
	public void setFileRecTypeKey(int fileRecTypeKey) {
		this.fileRecTypeKey = fileRecTypeKey;
	}
	public int getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
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
	
	public String getSourceTableName() {
		return sourceTableName;
	}
	public void setSourceTableName(String sourceTableName) {
		this.sourceTableName = sourceTableName;
	}
	public String getTargetTableName() {
		return targetTableName;
	}
	public void setTargetTableName(String targetTableName) {
		this.targetTableName = targetTableName;
	}
	public int getColumnOrder() {
		return columnOrder;
	}
	public void setColumnOrder(int columnOrder) {
		this.columnOrder = columnOrder;
	}
	public String getSourceColumnName() {
		return sourceColumnName;
	}
	public void setSourceColumnName(String sourceColumnName) {
		this.sourceColumnName = sourceColumnName;
	}
	public int getColumnTypeId() {
		return columnTypeId;
	}
	public void setColumnTypeId(int columnTypeId) {
		this.columnTypeId = columnTypeId;
	}
	public String getStageTableName() {
		return stageTableName;
	}
	public void setStageTableName(String stageTableName) {
		this.stageTableName = stageTableName;
	}
	public String getStageColumnName() {
		return stageColumnName;
	}
	public void setStageColumnName(String stageColumnName) {
		this.stageColumnName = stageColumnName;
	}
	public int getValidationId() {
		return validationId;
	}
	public void setValidationId(int validationId) {
		this.validationId = validationId;
	}
	public int getXformTypeId() {
		return xformTypeId;
	}
	public void setXformTypeId(int xformTypeId) {
		this.xformTypeId = xformTypeId;
	}

}
