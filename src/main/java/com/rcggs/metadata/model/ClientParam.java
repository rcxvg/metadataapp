package com.rcggs.metadata.model;

public class ClientParam {
	
	private int clientId;
	private String transtnRegtrTableName;
	private String emailAlertTo;
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getTranstnRegtrTableName() {
		return transtnRegtrTableName;
	}
	public void setTranstnRegtrTableName(String transtnRegtrTableName) {
		this.transtnRegtrTableName = transtnRegtrTableName;
	}
	public String getEmailAlertTo() {
		return emailAlertTo;
	}
	public void setEmailAlertTo(String emailAlertTo) {
		this.emailAlertTo = emailAlertTo;
	}
		  
}
