package com.rcggs.metadata.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.ResourceUtils;

import com.rcggs.metadata.dao.IJobDao;
import com.rcggs.metadata.model.BaseBean;
import com.rcggs.metadata.model.ColumnDef;
import com.rcggs.metadata.model.ColumnDetails;
import com.rcggs.metadata.model.ColumnValidation;
import com.rcggs.metadata.model.DropDown;
import com.rcggs.metadata.model.Job;
import com.rcggs.metadata.model.JobDomain;
import com.rcggs.metadata.model.JobUnit;
import com.rcggs.metadata.model.RefDataCorrection;
import com.rcggs.metadata.model.RefValidation;
import com.rcggs.metadata.model.RefXformType;
import com.rcggs.metadata.model.TableList;
import com.rcggs.metadata.util.ApplicationConstants;

public class JobDaoImpl implements IJobDao {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private PlatformTransactionManager transactionManager;

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	@Autowired
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public int createJob(Job job) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			status = jdbcTemplate.update(ApplicationConstants.INSERT_JOB_BY_ID,
					new Object[] { job.getJobId(), job.getJobDesc(), job.getActiveFlag(), job.getJobDetail() });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Job> getJobDetails(int jobId) {
		// TODO Auto-generated method stub
		try {
			String sql = "";
			Object params[] = null;
			if (jobId != 0) {
				sql = ApplicationConstants.GET_JOB_ID;
				params = new Object[] { jobId };
			} else {
				sql = ApplicationConstants.GET_ALL_JOBS;
				params = new Object[] {};
			}

			List<Job> list = jdbcTemplate.query(sql, params, new RowMapper<Job>() {

				@Override
				public Job mapRow(ResultSet rs, int size) throws SQLException {
					Job job = new Job();
					job.setJobId((rs.getInt("Job_Id") != 0) ? rs.getInt("Job_Id") : 0);
					job.setJobDesc((rs.getString("Job_Desc") != null) ? rs.getString("Job_Desc") : "");
					job.setActiveFlag((rs.getInt("Active_Flag") != 0) ? rs.getInt("Active_Flag") : 0);
					job.setJobDetail((rs.getString("Job_Detail") != null) ? rs.getString("Job_Detail") : "");
					return job;
				}
			});
			if (list != null && !list.isEmpty())
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateJob(JobDomain jobDomain) {
		// TODO Auto-generated method stub
		try {
			Job job = jobDomain.getJob();

			JobUnit jobUnit = jobDomain.getJobUnit();
			jdbcTemplate.update(ApplicationConstants.UPDATE_JOB_UNIT,
					new Object[] { jobUnit.getJobId(), jobUnit.getUnitId(), jobUnit.getUnitTypeId(),
							jobUnit.getUnitDesc(), jobUnit.getUnitActiveFlag(), jobUnit.getUnitOrder() });

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteJob(int jobId) {
		// TODO Auto-generated method stub
	    int status = 0;
		try {
			status =jdbcTemplate.update(ApplicationConstants.DELETE_CLIENT_JOB, new Object[] { jobId });
			status =jdbcTemplate.update(ApplicationConstants.DELETE_Meta_Exception, new Object[] { jobId });
			status =jdbcTemplate.update(ApplicationConstants.DELETE_JOB_UNIT_LOG, new Object[] { jobId });
			status =jdbcTemplate.update(ApplicationConstants.DELETE_JOB_LOG, new Object[] { jobId });
			status =jdbcTemplate.update(ApplicationConstants.DELETE_UNIT_STAGE_CHECK, new Object[] { jobId });
			status =jdbcTemplate.update(ApplicationConstants.DELETE_UNIT_STAGE_Map, new Object[] { jobId });
			status =jdbcTemplate.update(ApplicationConstants.DELETE_UNIT_STAGE_TASK, new Object[] { jobId });
			status =jdbcTemplate.update(ApplicationConstants.DELETE_UNIT_LOAD_MAP, new Object[] { jobId });
			status =jdbcTemplate.update(ApplicationConstants.DELETE_UNIT_LOAD_TASK, new Object[] { jobId });
			status =jdbcTemplate.update(ApplicationConstants.DELETE_UNIT_Conversion_MAP, new Object[] { jobId });
			status =jdbcTemplate.update(ApplicationConstants.DELETE_UNIT_Conversion_TASK, new Object[] { jobId });
			status =jdbcTemplate.update(ApplicationConstants.DELETE_JOB_UNIT, new Object[] { jobId });
			status =jdbcTemplate.update(ApplicationConstants.DELETE_JOB, new Object[] { jobId });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TableList> getTableNames(String type) {
		try {
			String sql = ("source".equalsIgnoreCase(type)) ? ApplicationConstants.GET_SOURCE_TABLE_ID
					: ApplicationConstants.GET_TARGET_TABLE_ID;

			List<TableList> list = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<TableList>() {

				@Override
				public TableList mapRow(ResultSet rs, int size) throws SQLException {
					TableList tableList = new TableList();
					tableList.setTableId((rs.getInt("Table_Id") != 0) ? rs.getInt("Table_Id") : 0);
					tableList.setTableName((rs.getString("Table_Name") != null) ? rs.getString("Table_Name") : "");
					tableList.setFileRecTypeKey(
							(rs.getInt("File_Rec_Type_Key") != 0) ? rs.getInt("File_Rec_Type_Key") : 0);
					return tableList;
				}
			});
			if (list != null && !list.isEmpty())
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<DropDown> getValidations() {
		return jdbcTemplate.query(ApplicationConstants.GET_VALIDATION_TYPE, new Object[] {}, new RowMapper<DropDown>() {

			@Override
			public DropDown mapRow(ResultSet rs, int size) throws SQLException {
				DropDown valid = new DropDown();
				valid.setId((rs.getInt("Validation_Id") != 0) ? String.valueOf(rs.getInt("Validation_Id")) : "0");
				valid.setLabel((rs.getString("Validation_Type") != null) ? rs.getString("Validation_Type") : "");
				return valid;
			}
		});

	}

	private DropDown getSelectedValidationType(List<DropDown> lst, String key) {

		for (DropDown obj : lst) {

			if (key != null && key.equalsIgnoreCase(obj.getLabel())) {
				System.out.println("obj:::" + obj.getLabel() + "key:::" + key);
				return obj;
			}

		}

		return new DropDown();

	}

	@Override
	public List<ColumnDef> getColdefinitions(String jobId) {
		try {
			//List<DropDown> validationTypesLst = getValidationTypes();
			List<ColumnDef> list = jdbcTemplate.query(ApplicationConstants.GET_COLUMN_DEFINITIONS,
					new Object[] { jobId }, new RowMapper<ColumnDef>() {

						@Override
						public ColumnDef mapRow(ResultSet rs, int size) throws SQLException {
							ColumnDef def = new ColumnDef();
							def.setJobId(Integer.parseInt(jobId));
							def.setColumnOrder((rs.getInt("Column_Order")!=0) ? rs.getInt("Column_Order"):0);
							def.setSourceTableName((rs.getString("Source_Table_Name") != null)
									? rs.getString("Source_Table_Name") : "");
							def.setSourceColumnName((rs.getString("Source_Column_Name") != null)
									? rs.getString("Source_Column_Name") : "");
							def.setColumnTypeDesc(
									(rs.getString("Column_Type_Desc") != null) ? rs.getString("Column_Type_Desc") : "");
							def.setxFormTypeDesc(
									(rs.getString("Xform_Type_Desc") != null) ? rs.getString("Xform_Type_Desc") : "");
							def.setColumnExpression((rs.getString("Column_Expression") != null)
									? rs.getString("Column_Expression") : "");
							def.setColumnFormat(
									(rs.getString("Column_Format") != null) ? rs.getString("Column_Format") : "");
							/*if (rs.getString("Validation_Type") != null) {
								def.getValidationType().add(
										getSelectedValidationType(validationTypesLst, rs.getString("Validation_Type")));
							}
							def.setValidationTypeMap(validationTypesLst);*/
							def.setTargetTableName((rs.getString("Target_Table_Name") != null)
									? rs.getString("Target_Table_Name") : "");
							def.setTargetColumnName((rs.getString("Target_Column_Name") != null)
									? rs.getString("Target_Column_Name") : "");
							def.setActiveFlag((rs.getInt("Active_Flag") != 0) ? rs.getInt("Active_Flag") : 0);
							def.setMinLength((rs.getString("Min_Length") != null) ? rs.getString("Min_Length") : "");
							def.setMaxLength((rs.getString("Max_Length") != null) ? rs.getString("Max_Length") : "");
							def.setMinValue((rs.getString("Min_Value") != null) ? rs.getString("Min_Value") : "");
							def.setMaxValue((rs.getString("Max_Value") != null) ? rs.getString("Max_Value") : "");
							def.setColumnIdentifier((rs.getString("Column_Identifier") != null) ? rs.getString("Column_Identifier") : "");
							return def;
						}
					});
			if (list != null && !list.isEmpty())
				return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int saveJobDetails(BaseBean bean) {
		int fileRecTypeId = getFileRecTypeId(bean.getSourceTableName());
		System.out.println("fileRecTypeID::::" + fileRecTypeId);
		System.out.println("SourceTableName::::" + bean.getSourceTableName());
		System.out.println("TargetTableName::::" + bean.getTargetTableName());
		System.out.println("JobID::::" + bean.getJobId());
		Scanner scanner = null;

		try {
			List<SqlParameter> params = new LinkedList<SqlParameter>();
			params.add(new SqlParameter(Types.VARCHAR));
			params.add(new SqlParameter(Types.VARCHAR));
			params.add(new SqlParameter(Types.NUMERIC));
			File file = ResourceUtils.getFile("classpath:createjob.txt");
			scanner = new Scanner(file);
			String content = scanner.useDelimiter("\\Z").next();
			Map<String, Object> ret = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement cs = con.prepareCall(content);

					cs.setString(1, bean.getSourceTableName());
					cs.setString(2, bean.getTargetTableName());
					cs.setInt(3, bean.getJobId());

					return cs;
				}
			}, params);

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return 0;
	}

	private int getFileRecTypeId(String sourceTableName) {

		List<Integer> maxRecord = jdbcTemplate.query(
				"select File_Rec_Type_Key FROM Meta_File_Rec_Type where lower(Hive_Tbl)=(lower(?))",
				new Object[] { sourceTableName }, new RowMapper<Integer>() {

					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
						return (rs.getInt("File_Rec_Type_Key") != 0) ? rs.getInt("File_Rec_Type_Key") : 0;
					}
				});
		return (maxRecord != null && maxRecord.size() > 0) ? maxRecord.get(0) : 0;

	}

	private String convertStringToList(List<DropDown> validationLst, List<DropDown> validationTypeLst) {
		String result = "";
		if (!validationLst.isEmpty()) {
			for (DropDown str : validationLst) {
			/*	String value = getValidationType(validationTypeLst, str.getId());
				if (!"".equalsIgnoreCase(value)) {*/
					result += (result.length() > 0) ? "," + str.getId(): str.getId();
				//}
			}
		}

		return result;
	}

	private String getValidationType(List<DropDown> lst, String id) {
		String result = "";
		if (!lst.isEmpty()) {
			for (DropDown str : lst) {
				if (id.equalsIgnoreCase(str.getId())) {
					result = str.getLabel();
					break;
				}
			}
		}

		return result;
	}

	@Override
	public int submitJobTemplateDetails(List<ColumnDef> list) throws FileNotFoundException {
		// TODO Auto-generated method stub
		boolean insert = true;
		Scanner scanner = null;
		int jobId=list.get(0).getJobId();
		String sqlForCheck ="select Job_Id from Meta_Job_Template where Job_Id="+list.get(0).getJobId();
		List<Map<String, Object>> listOfJobId = jdbcTemplate.queryForList(sqlForCheck);
		if(listOfJobId.size()>0){
				insert = false;
			}
		if(!insert){
			jdbcTemplate.execute("delete from Meta_Job_Template where job_id="+list.get(0).getJobId());
		}
		String sql = "insert into Meta_Job_Template (Job_Id,Version,Column_Order,Source_Column_Name,Column_Type_Desc,Xform_Type_Desc,Column_Expression,"
				+ "Column_Format,Target_Column_Name,Active_Flag,Min_Length,Max_Length,Min_Value,Max_Value,Column_Identifier) values"
				+ " (?,1,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ColumnDef col = list.get(i);
				ps.setLong(1, col.getJobId());
				ps.setInt(2,col.getColumnOrder());
				ps.setString(3, col.getSourceColumnName());
				ps.setString(4, col.getColumnTypeDesc());
				ps.setString(5, col.getxFormTypeDesc());
				ps.setString(6, col.getColumnExpression());
				ps.setString(7, col.getColumnFormat());
				ps.setString(8, col.getTargetColumnName());
				ps.setInt(9, col.getActiveFlag());
				ps.setString(10, col.getMinLength());
				ps.setString(11, col.getMaxLength());
				ps.setString(12, col.getMinValue());
				ps.setString(13, col.getMaxValue());
				ps.setString(14, col.getColumnIdentifier());
			}

			@Override
			public int getBatchSize() {
				return list.size();
			}
		});
		List<SqlParameter> params = new LinkedList<SqlParameter>();
		params.add(new SqlParameter(Types.NUMERIC));
		File file = ResourceUtils.getFile("classpath:submitColGrid.txt");
		scanner = new Scanner(file);
		String content = scanner.useDelimiter("\\Z").next();
		Map<String, Object> ret = jdbcTemplate.call(new CallableStatementCreator() {

			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cs = con.prepareCall(content);
				cs.setInt(1, jobId);
				return cs;
			}
		}, params);
		return 0;
	}
	
	public int saveColGrid(BaseBean bean) {
		int jobId = getFileRecTypeId(bean.getSourceTableName());
		System.out.println("JobID::::" + bean.getJobId());
		Scanner scanner = null;

		try {
			List<SqlParameter> params = new LinkedList<SqlParameter>();
			params.add(new SqlParameter(Types.NUMERIC));
			File file = ResourceUtils.getFile("classpath:submitColGrid.txt");
			scanner = new Scanner(file);
			String content = scanner.useDelimiter("\\Z").next();
			Map<String, Object> ret = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement cs = con.prepareCall(content);
					cs.setInt(1, bean.getJobId());
					return cs;
				}
			}, params);

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return 0;
	}
	
	@Override
	public List<RefXformType> getXformTypeLst() {
		try{
		List<RefXformType> list = jdbcTemplate.query(ApplicationConstants.GET_XFORM_TYPE, new Object[] {}, new RowMapper<RefXformType>() {

			@Override
			public RefXformType mapRow(ResultSet rs, int size) throws SQLException {
				RefXformType valid = new RefXformType();
				valid.setXformTypeId((rs.getInt("Xform_Type_Id") != 0) ? rs.getInt("Xform_Type_Id") : 0);
				valid.setXformTypeDesc((rs.getString("Xform_Type_Desc") != null) ? rs.getString("Xform_Type_Desc") : "");
				return valid;
			}
		});
		if (list != null && !list.isEmpty())
			return list;
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<RefValidation> getValidationTypes() {
		try{
		List<RefValidation> list = jdbcTemplate.query(ApplicationConstants.GET_VALIDATION_TYPE, new Object[] {}, new RowMapper<RefValidation>() {

			@Override
			public RefValidation mapRow(ResultSet rs, int size) throws SQLException {
				RefValidation valid = new RefValidation();
				valid.setValidationId((rs.getInt("Validation_Id") != 0) ? rs.getInt("Validation_Id") : 0);
				valid.setValidationType((rs.getString("Validation_Type") != null) ? rs.getString("Validation_Type") : "");
				return valid;
			}
		});
		if (list != null && !list.isEmpty())
			return list;
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<RefDataCorrection> getDataCorrectionList() {
		try{
		List<RefDataCorrection> list = jdbcTemplate.query(ApplicationConstants.GET_DATA_CORRCTION, new Object[] {}, new RowMapper<RefDataCorrection>() {

			@Override
			public RefDataCorrection mapRow(ResultSet rs, int size) throws SQLException {
				RefDataCorrection valid = new RefDataCorrection();
				valid.setDataCorrection((rs.getInt("Data_Correction") != 0) ? rs.getInt("Data_Correction") : 0);
				valid.setDataCrtnDesc((rs.getString("Data_Correction_Desc") != null) ? rs.getString("Data_Correction_Desc") : "");
				return valid;
			}
		});
		if (list != null && !list.isEmpty())
			return list;
		}catch (Exception ex) {
			ex.printStackTrace();

		}
		return null;
		
	}

	@Override
	public  List<ColumnDetails> getColValidations(int jobId) {
		// TODO Auto-generated method stub
		try{
		List<ColumnDetails> list = jdbcTemplate.query(ApplicationConstants.GET_COL_NAME, new Object[] {jobId}, new RowMapper<ColumnDetails>() {
			
			@Override
			public ColumnDetails mapRow(ResultSet rs, int size) throws SQLException {
				ColumnDetails valid = new ColumnDetails();
				valid.setColOrder((rs.getInt("Column_Order") != 0) ? rs.getInt("Column_Order") : 0);
				valid.setColName((rs.getString("Source_Column_Name") != null) ? rs.getString("Source_Column_Name") : "");
				return valid;
			}
		});
		if (list != null && !list.isEmpty())
			return list;
		}catch (Exception ex) {
			ex.printStackTrace();

		}
		return null;
	}

	@Override
	public int submitColValidationDetails(List<ColumnValidation> list) throws FileNotFoundException {
		// TODO Auto-generated method stub
		boolean insert = true;
		Scanner scanner = null;
		int jobId=list.get(0).getJobId();
		String sqlForCheck ="select Job_Id from Meta_Validation_Template where Job_Id="+list.get(0).getJobId();
		List<Map<String, Object>> listOfJobId = jdbcTemplate.queryForList(sqlForCheck);
		if(listOfJobId.size()>0){
				insert = false;
			}
		if(!insert){
			jdbcTemplate.execute("delete from Meta_Validation_Template where job_id="+list.get(0).getJobId());
		}
		String sql = "insert into Meta_Validation_Template (Job_Id,Version,Column_Order,Column_Name,Validation_Order,Validation_Type,"
				+ "Warning_Threshold,Failure_Threshold,Validation_Active_Flag,Data_Correction,Default_Val,Job_Validation_Description,"
				+ "Validation_Condition) values(?,1,?,?,?,?,?,?,?,?,?,?,?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ColumnValidation col = list.get(i);
				ps.setLong(1, col.getJobId());
				ps.setInt(2,col.getColumnOrder());
				ps.setString(3, col.getSourceColumnName());
				ps.setInt(4, col.getValidationOrder());
				ps.setString(5, col.getValidationType());
				ps.setBigDecimal(6, col.getWarningThreshold());
				ps.setBigDecimal(7, col.getFailureThreshold());
				ps.setInt(8, col.getActiveFlag());
				ps.setString(9, col.getDataCorrection());
				ps.setString(10, col.getDefaultVal());
				ps.setString(11, col.getJobValidationDescription());
				ps.setString(12, col.getValidationCondition());
			}

			@Override
			public int getBatchSize() {
				return list.size();
			}
		});
		List<SqlParameter> params = new LinkedList<SqlParameter>();
		params.add(new SqlParameter(Types.NUMERIC));
		File file = ResourceUtils.getFile("classpath:submitValidation.txt");
		scanner = new Scanner(file);
		String content = scanner.useDelimiter("\\Z").next();
		Map<String, Object> ret = jdbcTemplate.call(new CallableStatementCreator() {

			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cs = con.prepareCall(content);
				cs.setInt(1, jobId);
				return cs;
			}
		}, params);
		return 0;
	}
}
