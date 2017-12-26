package com.rcggs.metadata.services;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import com.rcggs.metadata.model.BaseBean;
import com.rcggs.metadata.model.ColumnDef;
import com.rcggs.metadata.model.ColumnDetails;
import com.rcggs.metadata.model.ColumnValidation;
import com.rcggs.metadata.model.Job;
import com.rcggs.metadata.model.JobDomain;
import com.rcggs.metadata.model.RefDataCorrection;
import com.rcggs.metadata.model.RefValidation;
import com.rcggs.metadata.model.RefXformType;
import com.rcggs.metadata.model.TableList;

public interface JobService {
	
	    public int createJob(Job jobDomain);
	    
	    public List<Job> getJobDetails(int jobId);
	    
	    void updateJob(JobDomain jobDomain);
	    
	    void deleteJob(int jobId);
	    
	    public List<TableList> getTableNames( String type);
	    
	    public List<ColumnDef> getColdefinitions( String jobId);
	    
	    public int saveJobDetails( BaseBean bean);
	    
	    public int submitJobTemplateDetails(List<ColumnDef> list) throws FileNotFoundException;
	    
	    public List<RefValidation> getValidationTypes();

		public List<ColumnDetails> getValidationColumnFileds(int jobId);

		public List<RefDataCorrection> getDataCorrectionList();
		
		public int submitColValidationDetails(List<ColumnValidation> colValidation) throws FileNotFoundException;
		
		public List<RefXformType> getXformTypeLst();

}
