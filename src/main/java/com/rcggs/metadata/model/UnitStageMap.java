package com.rcggs.metadata.model;

public class UnitStageMap extends BaseBean{
	
	private String stageColumnName;
	private int xformTypeId;
	private String columnExpression;
    private int columnActiveFlag;
    private String columnFormat;
    private String minLength;
    private String maxLength;
    private int keyInd;
    private String minValue;
    private String maxValue;
    
	public String getStageColumnName() {
		return stageColumnName;
	}
	public void setStageColumnName(String stageColumnName) {
		this.stageColumnName = stageColumnName;
	}
	public int getXformTypeId() {
		return xformTypeId;
	}
	public void setXformTypeId(int xformTypeId) {
		this.xformTypeId = xformTypeId;
	}
	public String getColumnExpression() {
		return columnExpression;
	}
	public void setColumnExpression(String columnExpression) {
		this.columnExpression = columnExpression;
	}
	public int getColumnActiveFlag() {
		return columnActiveFlag;
	}
	public void setColumnActiveFlag(int columnActiveFlag) {
		this.columnActiveFlag = columnActiveFlag;
	}
	public String getColumnFormat() {
		return columnFormat;
	}
	public void setColumnFormat(String columnFormat) {
		this.columnFormat = columnFormat;
	}
	public String getMinLength() {
		return minLength;
	}
	public void setMinLength(String minLength) {
		this.minLength = minLength;
	}
	public String getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(String maxLength) {
		this.maxLength = maxLength;
	}
	public int getKeyInd() {
		return keyInd;
	}
	public void setKeyInd(int keyInd) {
		this.keyInd = keyInd;
	}
	public String getMinValue() {
		return minValue;
	}
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	public String getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}
    
}
