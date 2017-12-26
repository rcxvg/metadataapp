package com.rcggs.metadata.model;

import java.util.List;

public class AddFileRecord {
	
	private List<RecordLayout> recLayoutList;
	private FileType fileType;
	private RecordType recType;
	
	
	public List<RecordLayout> getRecLayoutList() {
		return recLayoutList;
	}
	public void setRecLayoutList(List<RecordLayout> recLayoutList) {
		this.recLayoutList = recLayoutList;
	}	
	public FileType getFileType() {
		return fileType;
	}
	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}
	public RecordType getRecType() {
		return recType;
	}
	public void setRecType(RecordType recType) {
		this.recType = recType;
	}
	

}
