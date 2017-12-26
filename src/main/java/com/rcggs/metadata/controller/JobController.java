package com.rcggs.metadata.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rcggs.metadata.model.BaseBean;
import com.rcggs.metadata.model.ColumnDef;
import com.rcggs.metadata.model.ColumnDetails;
import com.rcggs.metadata.model.ColumnValidation;
import com.rcggs.metadata.model.DisplayColRecords;
import com.rcggs.metadata.model.Job;
import com.rcggs.metadata.model.JobDomain;
import com.rcggs.metadata.model.RefDataCorrection;
import com.rcggs.metadata.model.RefValidation;
import com.rcggs.metadata.model.RefXformType;
import com.rcggs.metadata.model.TableList;
import com.rcggs.metadata.services.JobService;

@RestController
public class JobController {

	private JobService jobService;

	public JobService getJobService() {
		return jobService;
	}

	@Autowired
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}
	
	@RequestMapping(value = "/jobDetails/", method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getJobDetails() {
		return new ResponseEntity<List<Job>>(jobService.getJobDetails(0), HttpStatus.OK);
	}
		
	@RequestMapping(value = "/jobDetails/{jobId}", method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getJobDetail(@PathVariable("jobId") int jobId ) {
		return new ResponseEntity<List<Job>>(jobService.getJobDetails(jobId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/jobDetails/", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Integer> createJob(@RequestBody Job job) {
		List joblist =  jobService.getJobDetails(job.getJobId());
        if (joblist != null && joblist.size() > 0 ) {
	           System.out.println("A Job with ID " + job.getJobId() + " already exist");
	           return new ResponseEntity<Integer>(0,HttpStatus.CONFLICT);
	    }
    	int status = jobService.createJob(job);
	    return new ResponseEntity<Integer>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value="/jobDetails/update", method = RequestMethod.POST )
	public ResponseEntity<JobDomain> updateClient(@RequestBody JobDomain job) {
		jobService.updateJob(job);
		return new ResponseEntity<JobDomain>(job, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/jobDetails/delete/{jobId}", method = RequestMethod.GET )
	public ResponseEntity<Void> deleteJob(@PathVariable("jobId") int jobId) {
		jobService.deleteJob(jobId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tableName/{type}", method = RequestMethod.GET)
	public ResponseEntity<List<TableList>> getSourceTableName(@PathVariable("type") String type ) {
		return new ResponseEntity<List<TableList>>(jobService.getTableNames(type), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/colDefs/{jobId}", method = RequestMethod.GET)
	public ResponseEntity<List<ColumnDef>> getColumnDefs(@PathVariable("jobId") String jobId ) {
		return new ResponseEntity<List<ColumnDef>>(jobService.getColdefinitions(jobId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/jobDetails/saveDetaials", method = RequestMethod.POST )
	public ResponseEntity<Integer> saveJobDetails(@RequestBody BaseBean job) {
		return new ResponseEntity<Integer>( jobService.saveJobDetails(job),HttpStatus.OK);
	}
	
	@RequestMapping(value="/jobDetails/submitJobTemplateDetails", method = RequestMethod.POST )
	public ResponseEntity<Integer> submitJobTemplateDetails(@RequestBody List<ColumnDef> lst) throws FileNotFoundException {
		int result = jobService.submitJobTemplateDetails(lst);
		return new ResponseEntity<Integer>( result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/jobDetails/xformTypes", method = RequestMethod.GET)
	public ResponseEntity<List<RefXformType>> getXformTypes() {
		return new ResponseEntity<List<RefXformType>>(jobService.getXformTypeLst(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/jobDetails/dropDowns/{jobId}", method = RequestMethod.GET )
	public ResponseEntity<List<DisplayColRecords>> displayValidationFields(@PathVariable("jobId") int jobId) {
		 List<ColumnDetails> colDetails=jobService.getValidationColumnFileds(jobId);
		List<RefValidation> refValidations = jobService.getValidationTypes();
		List<RefDataCorrection> refData = jobService.getDataCorrectionList();
		DisplayColRecords displayColRecord = new DisplayColRecords();
		displayColRecord.setColDetails(colDetails);
		displayColRecord.setRefValidations(refValidations);
		displayColRecord.setRefData(refData);
		List<DisplayColRecords> list = new ArrayList<>();
		list.add(displayColRecord);
		return new ResponseEntity<List<DisplayColRecords>>( list,HttpStatus.OK);
	}
	
	@RequestMapping(value="/jobDetails/submitColValidations", method = RequestMethod.POST )
	public ResponseEntity<Integer> submitColValidationDetails(@RequestBody List<ColumnValidation> colValidation) throws FileNotFoundException {
		return new ResponseEntity<Integer>( jobService.submitColValidationDetails(colValidation),HttpStatus.OK);
	}
	
}
