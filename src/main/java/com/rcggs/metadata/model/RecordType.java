package com.rcggs.metadata.model;

public class RecordType {
	
	private int fileRecTypeKey;
	
	private int fileTypeKey;
	
	private int recTypeId;
	
	private String recTypeDesc;
	
	private String hiveTable;
	private boolean checkFileType;
	

	public boolean isCheckFileType() {
		return checkFileType;
	}

	public void setCheckFileType(boolean checkFileType) {
		this.checkFileType = checkFileType;
	}

	public int getFileRecTypeKey() {
		return fileRecTypeKey;
	}

	public void setFileRecTypeKey(int fileRecTypeKey) {
		this.fileRecTypeKey = fileRecTypeKey;
	}

	public int getFileTypeKey() {
		return fileTypeKey;
	}

	public void setFileTypeKey(int fileTypeKey) {
		this.fileTypeKey = fileTypeKey;
	}

	public int getRecTypeId() {
		return recTypeId;
	}

	public void setRecTypeId(int recTypeId) {
		this.recTypeId = recTypeId;
	}

	public String getRecTypeDesc() {
		return recTypeDesc;
	}

	public void setRecTypeDesc(String recTypeDesc) {
		this.recTypeDesc = recTypeDesc;
	}

	public String getHiveTable() {
		return hiveTable;
	}

	public void setHiveTable(String hiveTable) {
		this.hiveTable = hiveTable;
	}
	
	

}
