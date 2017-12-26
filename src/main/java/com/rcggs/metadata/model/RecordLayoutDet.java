package com.rcggs.metadata.model;

import java.util.List;

public class RecordLayoutDet {
	private int recKey;
	
	public int getRecKey() {
		return recKey;
	}

	public void setRecKey(int recKey) {
		this.recKey = recKey;
	}

	private List<RecordLayout> recordLayout;

	public List<RecordLayout> getRecordLayout() {
		return recordLayout;
	}

	public void setRecordLayout(List<RecordLayout> recordLayout) {
		this.recordLayout = recordLayout;
	}
	
	

}
