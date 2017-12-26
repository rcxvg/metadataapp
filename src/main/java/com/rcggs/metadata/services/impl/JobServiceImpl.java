package com.rcggs.metadata.services.impl;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.rcggs.metadata.dao.IJobDao;
import com.rcggs.metadata.model.BaseBean;
import com.rcggs.metadata.model.ColumnDef;
import com.rcggs.metadata.model.ColumnDetails;
import com.rcggs.metadata.model.ColumnValidation;
import com.rcggs.metadata.model.DropDown;
import com.rcggs.metadata.model.Job;
import com.rcggs.metadata.model.JobDomain;
import com.rcggs.metadata.model.RefDataCorrection;
import com.rcggs.metadata.model.RefValidation;
import com.rcggs.metadata.model.RefXformType;
import com.rcggs.metadata.model.TableList;
import com.rcggs.metadata.services.JobService;

public class JobServiceImpl implements JobService{
	
	private IJobDao iJobDao;
	
	public IJobDao getiJobDao() {
		return iJobDao;
	}
	
	@Autowired
	public void setiJobDao(IJobDao iJobDao) {
		this.iJobDao = iJobDao;
	}
	
	@Override
	public int createJob(Job jobDomain) {
		// TODO Auto-generated method stub
		return iJobDao.createJob(jobDomain);
	}
	@Override
	public void updateJob(JobDomain jobDomain) {
		// TODO Auto-generated method stub
		iJobDao.updateJob(jobDomain);
	}
	@Override
	public void deleteJob(int jobId) {
		// TODO Auto-generated method stub
		iJobDao.deleteJob(jobId);
	}
	@Override
	public List<Job> getJobDetails(int jobId) {
		// TODO Auto-generated method stub
		return iJobDao.getJobDetails(jobId);
	}

	@Override
	public List<TableList> getTableNames(String type) {
		// TODO Auto-generated method stub
		return iJobDao.getTableNames(type);
	}

	@Override
	public List<ColumnDef> getColdefinitions(String jobId) {
		// TODO Auto-generated method stub
		return iJobDao.getColdefinitions(jobId);
	}

	@Override
	public int saveJobDetails(BaseBean bean) {
		// TODO Auto-generated method stub
		return iJobDao.saveJobDetails(bean);
	}

	@Override
	public int submitJobTemplateDetails(List<ColumnDef> list) throws FileNotFoundException{
		// TODO Auto-generated method stub
		return iJobDao.submitJobTemplateDetails(list);
	}

	@Override
	public List<RefValidation> getValidationTypes() {
		// TODO Auto-generated method stub
		return iJobDao.getValidationTypes();
	}

	@Override
	public  List<ColumnDetails> getValidationColumnFileds(int jobId) {
		// TODO Auto-generated method stub
		return iJobDao.getColValidations(jobId);
	}

	@Override
	public List<RefDataCorrection> getDataCorrectionList() {
		// TODO Auto-generated method stub
		return iJobDao.getDataCorrectionList();
	}

	@Override
	public int submitColValidationDetails(List<ColumnValidation> colValidation) throws FileNotFoundException {
		// TODO Auto-generated method stub
		return iJobDao.submitColValidationDetails(colValidation);
	}

	@Override
	public List<RefXformType> getXformTypeLst() {
		// TODO Auto-generated method stub
		return iJobDao.getXformTypeLst();
	}
	
	
}
