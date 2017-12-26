package com.rcggs.metadata.model;

public class TableList extends BaseBean {
	
	private int tableId;
	
	private int envTypeId;

	private String tableName;
	
	

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getEnvTypeId() {
		return envTypeId;
	}

	public void setEnvTypeId(int envTypeId) {
		this.envTypeId = envTypeId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
