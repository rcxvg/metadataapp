package com.rcggs.metadata.model;

public class JobDomain {
	
	private Job job;
	
	private JobUnit jobUnit;
	
	private TableList tableList;
	
	private EnvParam envParam;
	
	private ClientJob clientJob;
	
	private ClientParam clientParam;
	
	private StageTask stageTask;
	
	private UnitStageMap stageMap;
	
	private LoadTask loadTask;
	
	private LoadMap loadMap;

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public JobUnit getJobUnit() {
		return jobUnit;
	}

	public void setJobUnit(JobUnit jobUnit) {
		this.jobUnit = jobUnit;
	}

	public TableList getTableList() {
		return tableList;
	}

	public void setTableList(TableList tableList) {
		this.tableList = tableList;
	}

	public EnvParam getEnvParam() {
		return envParam;
	}

	public void setEnvParam(EnvParam envParam) {
		this.envParam = envParam;
	}

	public ClientJob getClientJob() {
		return clientJob;
	}

	public void setClientJob(ClientJob clientJob) {
		this.clientJob = clientJob;
	}

	public ClientParam getClientParam() {
		return clientParam;
	}

	public void setClientParam(ClientParam clientParam) {
		this.clientParam = clientParam;
	}

	public StageTask getStageTask() {
		return stageTask;
	}

	public void setStageTask(StageTask stageTask) {
		this.stageTask = stageTask;
	}

	public UnitStageMap getStageMap() {
		return stageMap;
	}

	public void setStageMap(UnitStageMap stageMap) {
		this.stageMap = stageMap;
	}

	public LoadTask getLoadTask() {
		return loadTask;
	}

	public void setLoadTask(LoadTask loadTask) {
		this.loadTask = loadTask;
	}

	public LoadMap getLoadMap() {
		return loadMap;
	}

	public void setLoadMap(LoadMap loadMap) {
		this.loadMap = loadMap;
	}

}
