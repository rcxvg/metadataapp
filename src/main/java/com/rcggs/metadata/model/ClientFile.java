package com.rcggs.metadata.model;

import java.sql.Date;

public class ClientFile {
	
	private int clientId;
	
	private int fileTypeKey;
	
	private String filePath;
	
	private String fileFreq;
	
	private Date effStartDt;
	
	private Date effEndDt;
	
	private int status;
	
	private int reqrOptnl;
	
	private String fileNamingConvention;
	
	private String defDelim;

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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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

	public String getFileNamingConvention() {
		return fileNamingConvention;
	}

	public void setFileNamingConvention(String fileNamingConvention) {
		this.fileNamingConvention = fileNamingConvention;
	}

	public String getDefDelim() {
		return defDelim;
	}

	public void setDefDelim(String defDelim) {
		this.defDelim = defDelim;
	}


}
