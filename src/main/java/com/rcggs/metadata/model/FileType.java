package com.rcggs.metadata.model;

import java.sql.Date;

public class FileType {
	
	private int fileTypeKey;
	
	private int fileTypeId;
	
	private int fileTypeVer;
	
	private String fileContent;
	
	private String srcSystem;
	
	private String fileSrc;
	
	private String fileDesc;
	
	private String fileNamingConvention;
	
	private String fixedDelim;
	
	private String defDelim;
	
	private String fileFreq;
	
	private Date effStartDt;
	
	private Date effEndDt;
	
	private int status;
	
	private int reqrOptnl;
	
	private int clientId;
	
	
	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getFileTypeKey() {
		return fileTypeKey;
	}

	public void setFileTypeKey(int fileTypeKey) {
		this.fileTypeKey = fileTypeKey;
	}

	public int getFileTypeId() {
		return fileTypeId;
	}

	public void setFileTypeId(int fileTypeId) {
		this.fileTypeId = fileTypeId;
	}

	public int getFileTypeVer() {
		return fileTypeVer;
	}

	public void setFileTypeVer(int fileTypeVer) {
		this.fileTypeVer = fileTypeVer;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public String getSrcSystem() {
		return srcSystem;
	}

	public void setSrcSystem(String srcSystem) {
		this.srcSystem = srcSystem;
	}

	public String getFileSrc() {
		return fileSrc;
	}

	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}

	public String getFileDesc() {
		return fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	public String getFileNamingConvention() {
		return fileNamingConvention;
	}

	public void setFileNamingConvention(String fileNamingConvention) {
		this.fileNamingConvention = fileNamingConvention;
	}

	public String getFixedDelim() {
		return fixedDelim;
	}

	public void setFixedDelim(String fixedDelim) {
		this.fixedDelim = fixedDelim;
	}

	public String getDefDelim() {
		return defDelim;
	}

	public void setDefDelim(String defDelim) {
		this.defDelim = defDelim;
	}

	public String getFileFreq() {
		return fileFreq;
	}

	public void setFileFreq(String fileFreq) {
		this.fileFreq = fileFreq;
	}

	public Date getEffStartDt() {
		return effStartDt;
	}

	public void setEffStartDt(Date effStartDt) {
		this.effStartDt = effStartDt;
	}

	public Date getEffEndDt() {
		return effEndDt;
	}

	public void setEffEndDt(Date effEndDt) {
		this.effEndDt = effEndDt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getReqrOptnl() {
		return reqrOptnl;
	}

	public void setReqrOptnl(int reqrOptnl) {
		this.reqrOptnl = reqrOptnl;
	}
	

}
