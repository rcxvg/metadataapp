package com.rcggs.metadata.model;

public class EnvParam {

	private int envId;
	private int envTypeId;
	private int conTypeId;
	private int clientId;
	private String dbServer;
	private String dbName;
    private String dbUser;
	private String dbPass;
	private int port;
	private String sourceFileLoc;
	private String destFileLoc;
	private String dsn;
	
	public int getEnvId() {
		return envId;
	}
	public void setEnvId(int envId) {
		this.envId = envId;
	}
	public int getEnvTypeId() {
		return envTypeId;
	}
	public void setEnvTypeId(int envTypeId) {
		this.envTypeId = envTypeId;
	}
	public int getConTypeId() {
		return conTypeId;
	}
	public void setConTypeId(int conTypeId) {
		this.conTypeId = conTypeId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getDbServer() {
		return dbServer;
	}
	public void setDbServer(String dbServer) {
		this.dbServer = dbServer;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPass() {
		return dbPass;
	}
	public void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getSourceFileLoc() {
		return sourceFileLoc;
	}
	public void setSourceFileLoc(String sourceFileLoc) {
		this.sourceFileLoc = sourceFileLoc;
	}
	public String getDestFileLoc() {
		return destFileLoc;
	}
	public void setDestFileLoc(String destFileLoc) {
		this.destFileLoc = destFileLoc;
	}
	public String getDsn() {
		return dsn;
	}
	public void setDsn(String dsn) {
		this.dsn = dsn;
	}
}
