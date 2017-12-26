package com.rcggs.metadata.model;

public class UnitStageCheck extends BaseBean{

	private int validationId;
	private int validationWeight;
	private int accessCriteria;
	private int validationOrder;
	private int validationActiveFlag;
	
	public int getValidationId() {
		return validationId;
	}
	public void setValidationId(int validationId) {
		this.validationId = validationId;
	}
	public int getValidationWeight() {
		return validationWeight;
	}
	public void setValidationWeight(int validationWeight) {
		this.validationWeight = validationWeight;
	}
	public int getAccessCriteria() {
		return accessCriteria;
	}
	public void setAccessCriteria(int accessCriteria) {
		this.accessCriteria = accessCriteria;
	}
	public int getValidationOrder() {
		return validationOrder;
	}
	public void setValidationOrder(int validationOrder) {
		this.validationOrder = validationOrder;
	}
	public int getValidationActiveFlag() {
		return validationActiveFlag;
	}
	public void setValidationActiveFlag(int validationActiveFlag) {
		this.validationActiveFlag = validationActiveFlag;
	}
	
}
