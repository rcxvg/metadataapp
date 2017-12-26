package com.rcggs.metadata.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ColumnDef extends BaseBean{
	
	private String xFormTypeDesc;
	
	private String columnExpression;
	
	private String columnFormat;

	private List<DropDown> activeFlagLst;
	
	private String targetColumnName;
	
	private String columnTypeDesc;
	
	private String minLength;
	
	private String maxLength;
	
	private String minValue;
	
	private String maxValue;
	
	private String columnIdentifier;

	/*public int getColumnOrder() {
		return columnOrder;
	}

	public void setColumnOrder(int columnOrder) {
		this.columnOrder = columnOrder;
	}*/

	public String getxFormTypeDesc() {
		return xFormTypeDesc;
	}

	public void setxFormTypeDesc(String xFormTypeDesc) {
		this.xFormTypeDesc = xFormTypeDesc;
	}

	public String getColumnExpression() {
		return columnExpression;
	}

	public void setColumnExpression(String columnExpression) {
		this.columnExpression = columnExpression;
	}

	public String getColumnFormat() {
		return columnFormat;
	}

	public void setColumnFormat(String columnFormat) {
		this.columnFormat = columnFormat;
	}

	

/*	public List<DropDown> getValidationType() {
		if( validationType == null)
			validationType = new ArrayList<DropDown>();
		return validationType;
	}

	public void setValidationType(List<DropDown> validationType) {
		this.validationType = validationType;
	}*/

	

	public String getTargetColumnName() {
		return targetColumnName;
	}

	public void setTargetColumnName(String targetColumnName) {
		this.targetColumnName = targetColumnName;
	}

	public String getColumnTypeDesc() {
		return columnTypeDesc;
	}

	public void setColumnTypeDesc(String columnTypeDesc) {
		this.columnTypeDesc = columnTypeDesc;
	}

/*	public List<DropDown> getValidationTypeMap() {
		return validationTypeMap;
	}

	public void setValidationTypeMap(List<DropDown> validationTypeMap) {
		this.validationTypeMap = validationTypeMap;
	}*/

	public List<DropDown> getActiveFlagLst() {
		if( activeFlagLst == null){
			activeFlagLst = new ArrayList<DropDown>();
			DropDown obj = new DropDown();	
			obj.setId("0");
			
			activeFlagLst.add(obj);
			obj = new DropDown();	
			obj.setId("1");
			
			activeFlagLst.add(obj);	
			
		}
			
		return activeFlagLst;
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

	public String getColumnIdentifier() {
		return columnIdentifier;
	}

	public void setColumnIdentifier(String columnIdentifier) {
		this.columnIdentifier = columnIdentifier;
	}
	
	
	
	

}
