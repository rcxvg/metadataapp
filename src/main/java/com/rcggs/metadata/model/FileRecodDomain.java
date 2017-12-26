package com.rcggs.metadata.model;

import java.util.List;

public class FileRecodDomain {
	
	private List<RecordLayoutDet> recLayoutList;
	private FileType fileType;
	private List<RecordType> recType;
	
	
	public List<RecordLayoutDet> getRecLayoutList() {
		return recLayoutList;
	}
	public void setRecLayoutList(List<RecordLayoutDet> recLayoutList) {
		this.recLayoutList = recLayoutList;
	}
	
	
	public FileType getFileType() {
		return fileType;
	}
	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}
	public List<RecordType> getRecType() {
		return recType;
	}
	public void setRecType(List<RecordType> recType) {
		this.recType = recType;
	}
	
	
	

}
