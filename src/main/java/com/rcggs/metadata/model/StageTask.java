package com.rcggs.metadata.model;

public class StageTask extends BaseBean{

	private String sourceTableName;
	private String sourceFilter;
	private String stageTableName;
	private int taskOrder;
	private String updateTrackFieldName;
	private String updateTrackFieldType;
	private String partitionFieldName;
	private String sourceCdcTableName;
	private int sourceTableId;
	private int stageTableId;
	
	public String getSourceTableName() {
		return sourceTableName;
	}
	public void setSourceTableName(String sourceTableName) {
		this.sourceTableName = sourceTableName;
	}
	public String getSourceFilter() {
		return sourceFilter;
	}
	public void setSourceFilter(String sourceFilter) {
		this.sourceFilter = sourceFilter;
	}
	public String getStageTableName() {
		return stageTableName;
	}
	public void setStageTableName(String stageTableName) {
		this.stageTableName = stageTableName;
	}
	public int getTaskOrder() {
		return taskOrder;
	}
	public void setTaskOrder(int taskOrder) {
		this.taskOrder = taskOrder;
	}
	public String getUpdateTrackFieldName() {
		return updateTrackFieldName;
	}
	public void setUpdateTrackFieldName(String updateTrackFieldName) {
		this.updateTrackFieldName = updateTrackFieldName;
	}
	public String getUpdateTrackFieldType() {
		return updateTrackFieldType;
	}
	public void setUpdateTrackFieldType(String updateTrackFieldType) {
		this.updateTrackFieldType = updateTrackFieldType;
	}
	public String getPartitionFieldName() {
		return partitionFieldName;
	}
	public void setPartitionFieldName(String partitionFieldName) {
		this.partitionFieldName = partitionFieldName;
	}
	public String getSourceCdcTableName() {
		return sourceCdcTableName;
	}
	public void setSourceCdcTableName(String sourceCdcTableName) {
		this.sourceCdcTableName = sourceCdcTableName;
	}
	public int getSourceTableId() {
		return sourceTableId;
	}
	public void setSourceTableId(int sourceTableId) {
		this.sourceTableId = sourceTableId;
	}
	public int getStageTableId() {
		return stageTableId;
	}
	public void setStageTableId(int stageTableId) {
		this.stageTableId = stageTableId;
	}
	
	
}
