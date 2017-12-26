package com.rcggs.metadata.model;

import java.math.BigDecimal;

public class ColumnValidation extends BaseBean{
	
	private int validationOrder;
	private String validationType;
	private BigDecimal warningThreshold;
	private BigDecimal failureThreshold;
	private String dataCorrection;
	private String defaultVal;
	private String jobValidationDescription;
	private String validationCondition;
	
	public int getValidationOrder() {
		return validationOrder;
	}
	public void setValidationOrder(int validationOrder) {
		this.validationOrder = validationOrder;
	}
	public String getValidationType() {
		return validationType;
	}
	public void setValidationType(String validationType) {
		this.validationType = validationType;
	}
	public BigDecimal getWarningThreshold() {
		return warningThreshold;
	}
	public void setWarningThreshold(BigDecimal warningThreshold) {
		this.warningThreshold = warningThreshold;
	}
	public BigDecimal getFailureThreshold() {
		return failureThreshold;
	}
	public void setFailureThreshold(BigDecimal failureThreshold) {
		this.failureThreshold = failureThreshold;
	}
	public String getDataCorrection() {
		return dataCorrection;
	}
	public void setDataCorrection(String dataCorrection) {
		this.dataCorrection = dataCorrection;
	}
	public String getDefaultVal() {
		return defaultVal;
	}
	public void setDefaultVal(String defaultVal) {
		defaultVal = defaultVal;
	}
	public String getJobValidationDescription() {
		return jobValidationDescription;
	}
	public void setJobValidationDescription(String jobValidationDescription) {
		this.jobValidationDescription = jobValidationDescription;
	}
	public String getValidationCondition() {
		return validationCondition;
	}
	public void setValidationCondition(String validationCondition) {
		this.validationCondition = validationCondition;
	}
	
	
}