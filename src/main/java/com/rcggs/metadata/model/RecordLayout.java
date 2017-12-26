package com.rcggs.metadata.model;

public class RecordLayout {

	private int fileRecTypeKey;
	
	private int fldSeq;
	
	private String dataFld;
	
	private String fldDesc;
	
	private String dataType;
	
	private int len;
	
	private String reqrOptnl;
	
	private String inPatient;
	
	private String outPatient;
	
	private String sampleData;
	
	private String dfltDelim;
	
	private String startPos;
	
	private String endPos;
	
	private String hdfsDataType;

	public int getFileRecTypeKey() {
		return fileRecTypeKey;
	}

	public void setFileRecTypeKey(int fileRecTypeKey) {
		this.fileRecTypeKey = fileRecTypeKey;
	}

	public int getFldSeq() {
		return fldSeq;
	}

	public void setFldSeq(int fldSeq) {
		this.fldSeq = fldSeq;
	}

	public String getDataFld() {
		return dataFld;
	}

	public void setDataFld(String dataFld) {
		this.dataFld = dataFld;
	}

	public String getFldDesc() {
		return fldDesc;
	}

	public void setFldDesc(String fldDesc) {
		this.fldDesc = fldDesc;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public String getReqrOptnl() {
		return reqrOptnl;
	}

	public void setReqrOptnl(String reqrOptnl) {
		this.reqrOptnl = reqrOptnl;
	}

	public String getInPatient() {
		return inPatient;
	}

	public void setInPatient(String inPatient) {
		this.inPatient = inPatient;
	}

	public String getOutPatient() {
		return outPatient;
	}

	public void setOutPatient(String outPatient) {
		this.outPatient = outPatient;
	}

	public String getSampleData() {
		return sampleData;
	}

	public void setSampleData(String sampleData) {
		this.sampleData = sampleData;
	}

	public String getDfltDelim() {
		return dfltDelim;
	}

	public void setDfltDelim(String dfltDelim) {
		this.dfltDelim = dfltDelim;
	}

	public String getStartPos() {
		return startPos;
	}

	public void setStartPos(String startPos) {
		this.startPos = startPos;
	}

	public String getEndPos() {
		return endPos;
	}

	public void setEndPos(String endPos) {
		this.endPos = endPos;
	}
	
	public String getHdfsDataType() {
		return hdfsDataType;
	}

	public void setHdfsDataType(String hdfsDataType) {
		this.hdfsDataType = hdfsDataType;
	}
	
	
}
