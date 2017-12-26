package com.rcggs.metadata.model;

import java.util.List;

public class DisplayColRecords {
	
private List<RefValidation> refValidations;
private List<ColumnDetails> colDetails;
private List<RefDataCorrection> refData;

public List<RefValidation> getRefValidations() {
	return refValidations;
}
public void setRefValidations(List<RefValidation> refValidations) {
	this.refValidations = refValidations;
}
public List<ColumnDetails> getColDetails() {
	return colDetails;
}
public void setColDetails(List<ColumnDetails> colDetails) {
	this.colDetails = colDetails;
}
public List<RefDataCorrection> getRefData() {
	return refData;
}
public void setRefData(List<RefDataCorrection> refData) {
	this.refData = refData;
}



}
