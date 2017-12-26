package com.rcggs.metadata.model;

public class LoadTask extends BaseBean{
 
	private String targetFilter;
	private int deleteInd;
	private int batchMaxSize;
	private int taskOrder;
	private int targetTableId;
	private int loadMode;
	
	public String getTargetFilter() {
		return targetFilter;
	}
	public void setTargetFilter(String targetFilter) {
		this.targetFilter = targetFilter;
	}
	public int getDeleteInd() {
		return deleteInd;
	}
	public void setDeleteInd(int deleteInd) {
		this.deleteInd = deleteInd;
	}
	public int getBatchMaxSize() {
		return batchMaxSize;
	}
	public void setBatchMaxSize(int batchMaxSize) {
		this.batchMaxSize = batchMaxSize;
	}
	public int getTaskOrder() {
		return taskOrder;
	}
	public void setTaskOrder(int taskOrder) {
		this.taskOrder = taskOrder;
	}
	public int getTargetTableId() {
		return targetTableId;
	}
	public void setTargetTableId(int targetTableId) {
		this.targetTableId = targetTableId;
	}
	public int getLoadMode() {
		return loadMode;
	}
	public void setLoadMode(int loadMode) {
		this.loadMode = loadMode;
	}
	
	
}
