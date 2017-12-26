package com.rcggs.metadata.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.rcggs.metadata.dao.IFileTypeDao;
import com.rcggs.metadata.model.AddFileRecord;
import com.rcggs.metadata.model.ClientFile;
import com.rcggs.metadata.model.FileRecodDomain;
import com.rcggs.metadata.model.FileType;
import com.rcggs.metadata.model.RecordLayout;
import com.rcggs.metadata.model.RecordLayoutDet;
import com.rcggs.metadata.model.RecordType;
import com.rcggs.metadata.model.RefRecordType;
import com.rcggs.metadata.util.ApplicationConstants;

public class FileTypeDaoImpl implements IFileTypeDao {

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

	/*@Override
	public List<FileRecodDomain> getClientFileDetails(String clinetId) {
		// TODO Auto-generated method stub
		try {
			String sql = ""; 
			Object params[] = null;
			if (clinetId != null && !clinetId.equalsIgnoreCase("")) {
				sql = "select * from Meta_File_Type mft  inner join Meta_Client_File mcf on mcf.File_Type_Key = mft.File_Type_Key "
						+ "where mcf.client_id='"
						+ clinetId + "'";

			} else {
				//sql = "select * from Meta_File_Type";
				sql = "select * from Meta_File_Type mft inner join Meta_Client_File mcf on mcf.File_Type_Key = mft.File_Type_Key";

			}
			List<FileRecodDomain> list = jdbcTemplate.query(sql, new RowMapper<FileRecodDomain>() {

				@Override
				public FileRecodDomain mapRow(ResultSet rs, int size) throws SQLException {
					FileRecodDomain fileRecodDomain = new FileRecodDomain();
					FileType fileType = new FileType();
					fileType.setClientId((rs.getInt("Client_ID") != 0) ? rs.getInt("Client_ID") : 0);
					fileType.setFileTypeKey((rs.getInt("File_Type_Key") != 0) ? rs.getInt("File_Type_Key") : 0);
					fileType.setFileTypeId((rs.getInt("File_Type_ID") != 0) ? rs.getInt("File_Type_ID") : 0);
					fileType.setFileTypeVer((rs.getInt("File_Type_Ver") != 0) ? rs.getInt("File_Type_Ver") : 0);
					fileType.setFileContent((rs.getString("File_Cntnt") != null) ? rs.getString("File_Cntnt") : "");
					fileType.setSrcSystem((rs.getString("Src_Sys") != null) ? rs.getString("Src_Sys") : "");
					fileType.setFileSrc((rs.getString("File_Src") != null) ? rs.getString("File_Src") : "");
					fileType.setFileDesc((rs.getString("File_Desc") != null) ? rs.getString("File_Desc") : "");
					fileType.setFileNamingConvention(
							(rs.getString("File_Nm_Convntin") != null) ? rs.getString("File_Nm_Convntin") : "");
					fileType.setFixedDelim((rs.getString("Fxd_Delim") != null) ? rs.getString("Fxd_Delim") : "");
					fileType.setDefDelim((rs.getString("Def_Delim") != null) ? rs.getString("Def_Delim") : "");
					fileType.setFileFreq((rs.getString("File_Freq") != null) ? rs.getString("File_Freq") : "");
					fileType.setEffStartDt(rs.getDate("Eff_Strt_Dt"));
					fileType.setEffEndDt(rs.getDate("Eff_End_Dt"));
					fileType.setStatus((rs.getInt("Sts") != 0) ? rs.getInt("Sts") : 0);
					fileType.setReqrOptnl((rs.getInt("Reqr_Optnl") != 0) ? rs.getInt("Reqr_Optnl") : 0);
					fileRecodDomain.setFileType(fileType);

					RecordType recType = new RecordType();
					recType.setRecTypeDesc(
							(rs.getString("File_Rec_Type_Desc") != null) ? rs.getString("File_Rec_Type_Desc") : "");
					recType.setHiveTable((rs.getString("Hive_Tbl") != null) ? rs.getString("Hive_Tbl") : "");
					recType.setRecTypeId((rs.getInt("Rec_Type_Id") != 0) ? rs.getInt("Rec_Type_Id") : 0);
					recType.setFileTypeKey((rs.getInt("File_Type_Key") != 0) ? rs.getInt("File_Type_Key") : 0);
					recType.setFileRecTypeKey(
							(rs.getInt("File_Rec_Type_Key") != 0) ? rs.getInt("File_Rec_Type_Key") : 0);
					fileRecodDomain.setRecType(recType);
					return fileRecodDomain;
				}
			});
			
			if (list != null && !list.isEmpty()) {
				for (FileRecodDomain fileRecodDomain : list) {
					List<RecordType> recordTypeList = jdbcTemplate.query(
							" select * from Meta_File_Rec_Type where File_Type_Key = ?",
							new Object[] { fileRecodDomain.getFileType().getFileTypeKey() },
							new RowMapper<RecordType>() {

								@Override
								public RecordType mapRow(ResultSet rs, int size) throws SQLException {

									RecordType recType = new RecordType();
									recType.setRecTypeDesc(
											(rs.getString("File_Rec_Type_Desc") != null) ? rs.getString("File_Rec_Type_Desc") : "");
									recType.setHiveTable((rs.getString("Hive_Tbl") != null) ? rs.getString("Hive_Tbl") : "");
									recType.setRecTypeId((rs.getInt("Rec_Type_Id") != 0) ? rs.getInt("Rec_Type_Id") : 0);
									recType.setFileTypeKey((rs.getInt("File_Type_Key") != 0) ? rs.getInt("File_Type_Key") : 0);
									recType.setFileRecTypeKey(
											(rs.getInt("File_Rec_Type_Key") != 0) ? rs.getInt("File_Rec_Type_Key") : 0);
									return recType;
								}
							});
									fileRecodDomain.setRecordTypeList(recordTypeList);
				}
			}
			if (list != null && !list.isEmpty()) {
				for (FileRecodDomain fileRecodDomain : list) {
					List<RecordLayout> recordLayoutList = jdbcTemplate.query(
							" select * from Meta_Rec_Layout where File_Rec_Type_Key = ? ",
							new Object[] { fileRecodDomain.getRecordTypeList().get(0).getFileRecTypeKey() },
							new RowMapper<RecordLayout>() {
								
								@Override
								public RecordLayout mapRow(ResultSet rs, int size) throws SQLException {

									RecordLayout recordLayout = new RecordLayout();
									recordLayout.setFileRecTypeKey(
											(rs.getInt("File_Rec_Type_Key") != 0) ? rs.getInt("File_Rec_Type_Key") : 0);
									recordLayout.setFldSeq((rs.getInt("Field_Seq") != 0) ? rs.getInt("Field_Seq") : 0);
									recordLayout.setDataFld(
											(rs.getString("Data_Field") != null) ? rs.getString("Data_Field") : "");
									recordLayout.setFldDesc(
											(rs.getString("Field_Desc") != null) ? rs.getString("Field_Desc") : "");
									recordLayout.setDataType(
											(rs.getString("Data_Type") != null) ? rs.getString("Data_Type") : "");
									recordLayout.setLen((rs.getInt("Len") != 0) ? rs.getInt("Len") : 0);
									recordLayout.setReqrOptnl(
											(rs.getString("Reqr_Optnl") != null) ? rs.getString("Reqr_Optnl") : "");
									recordLayout.setInPatient(
											(rs.getString("In_Ptnt") != null) ? rs.getString("In_Ptnt") : "");
									recordLayout.setOutPatient(
											(rs.getString("Out_Ptnt") != null) ? rs.getString("Out_Ptnt") : "");
									recordLayout.setSampleData(
											(rs.getString("Sample_Data") != null) ? rs.getString("Sample_Data") : "");
									recordLayout.setDfltDelim(
											(rs.getString("Dflt_Delim") != null) ? rs.getString("Dflt_Delim") : "");
									recordLayout.setStartPos(
											(rs.getString("Strt_Pos") != null) ? rs.getString("Strt_Pos") : "");
									recordLayout.setEndPos(
											(rs.getString("End_Pos") != null) ? rs.getString("End_Pos") : "");
									recordLayout.setHdfsDataType((rs.getString("HDFS_Data_Type") != null)
											? rs.getString("HDFS_Data_Type") : "");
									return recordLayout;
								}
							});
					fileRecodDomain.setRecLayoutList(recordLayoutList);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	@Override
	public List<FileType> getClientFileDetails(String clinetId) {
		// TODO Auto-generated method stub
		try {
			String sql = ""; 
				sql = "select * from Meta_Client_File mcf inner join Meta_File_Type mft on mcf.File_Type_Key = mft.File_Type_Key "
						+ "where mcf.client_id='"
						+ clinetId + "'";
			List<FileType> list = jdbcTemplate.query(sql, new RowMapper<FileType>() {

				@Override
				public FileType mapRow(ResultSet rs, int size) throws SQLException {
					FileType fileType = new FileType();
					fileType.setClientId((rs.getInt("Client_ID") != 0) ? rs.getInt("Client_ID") : 0);
					fileType.setFileTypeKey((rs.getInt("File_Type_Key") != 0) ? rs.getInt("File_Type_Key") : 0);
					fileType.setFileTypeId((rs.getInt("File_Type_ID") != 0) ? rs.getInt("File_Type_ID") : 0);
					fileType.setFileTypeVer((rs.getInt("File_Type_Ver") != 0) ? rs.getInt("File_Type_Ver") : 0);
					fileType.setFileContent((rs.getString("File_Cntnt") != null) ? rs.getString("File_Cntnt") : "");
					fileType.setSrcSystem((rs.getString("Src_Sys") != null) ? rs.getString("Src_Sys") : "");
					fileType.setFileSrc((rs.getString("File_Src") != null) ? rs.getString("File_Src") : "");
					fileType.setFileDesc((rs.getString("File_Desc") != null) ? rs.getString("File_Desc") : "");
					fileType.setFileNamingConvention(
							(rs.getString("File_Nm_Convntin") != null) ? rs.getString("File_Nm_Convntin") : "");
					fileType.setFixedDelim((rs.getString("Fxd_Delim") != null) ? rs.getString("Fxd_Delim") : "");
					fileType.setDefDelim((rs.getString("Def_Delim") != null) ? rs.getString("Def_Delim") : "");
					fileType.setFileFreq((rs.getString("File_Freq") != null) ? rs.getString("File_Freq") : "");
					fileType.setEffStartDt(rs.getDate("Eff_Strt_Dt"));
					fileType.setEffEndDt(rs.getDate("Eff_End_Dt"));
					fileType.setStatus((rs.getInt("Sts") != 0) ? rs.getInt("Sts") : 0);
					fileType.setReqrOptnl((rs.getInt("Reqr_Optnl") != 0) ? rs.getInt("Reqr_Optnl") : 0);
					return fileType;
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
	public List<RecordType> getRecTypeDetails(int fileTypeKey) {
		try{
				List<RecordType> recordTypeList = jdbcTemplate.query(
						" select * from Meta_File_Rec_Type where File_Type_Key =" +fileTypeKey,
						new RowMapper<RecordType>() {

							@Override
							public RecordType mapRow(ResultSet rs, int size) throws SQLException {

								RecordType recType = new RecordType();
								recType.setRecTypeDesc(
										(rs.getString("File_Rec_Type_Desc") != null) ? rs.getString("File_Rec_Type_Desc") : "");
								recType.setHiveTable((rs.getString("Hive_Tbl") != null) ? rs.getString("Hive_Tbl") : "");
								recType.setRecTypeId((rs.getInt("Rec_Type_Id") != 0) ? rs.getInt("Rec_Type_Id") : 0);
								recType.setFileTypeKey((rs.getInt("File_Type_Key") != 0) ? rs.getInt("File_Type_Key") : 0);
								recType.setFileRecTypeKey(
										(rs.getInt("File_Rec_Type_Key") != 0) ? rs.getInt("File_Rec_Type_Key") : 0);
								return recType;
							}
						});

		return recordTypeList;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	}
	
	@Override
	public List<RecordLayout> getRecLayoutDetails(int fileRecTypeKey) {
		try{
			List<RecordLayout> recordLayoutList = jdbcTemplate.query(
					" select * from Meta_Rec_Layout where File_Rec_Type_Key = " +fileRecTypeKey,
					new RowMapper<RecordLayout>() {
						
						@Override
						public RecordLayout mapRow(ResultSet rs, int size) throws SQLException {

							RecordLayout recordLayout = new RecordLayout();
							recordLayout.setFileRecTypeKey(
									(rs.getInt("File_Rec_Type_Key") != 0) ? rs.getInt("File_Rec_Type_Key") : 0);
							recordLayout.setFldSeq((rs.getInt("Field_Seq") != 0) ? rs.getInt("Field_Seq") : 0);
							recordLayout.setDataFld(
									(rs.getString("Data_Field") != null) ? rs.getString("Data_Field") : "");
							recordLayout.setFldDesc(
									(rs.getString("Field_Desc") != null) ? rs.getString("Field_Desc") : "");
							recordLayout.setDataType(
									(rs.getString("Data_Type") != null) ? rs.getString("Data_Type") : "");
							recordLayout.setLen((rs.getInt("Len") != 0) ? rs.getInt("Len") : 0);
							recordLayout.setReqrOptnl(
									(rs.getString("Reqr_Optnl") != null) ? rs.getString("Reqr_Optnl") : "");
							recordLayout.setInPatient(
									(rs.getString("In_Ptnt") != null) ? rs.getString("In_Ptnt") : "");
							recordLayout.setOutPatient(
									(rs.getString("Out_Ptnt") != null) ? rs.getString("Out_Ptnt") : "");
							recordLayout.setSampleData(
									(rs.getString("Sample_Data") != null) ? rs.getString("Sample_Data") : "");
							recordLayout.setDfltDelim(
									(rs.getString("Dflt_Delim") != null) ? rs.getString("Dflt_Delim") : "");
							recordLayout.setStartPos(
									(rs.getString("Strt_Pos") != null) ? rs.getString("Strt_Pos") : "");
							recordLayout.setEndPos(
									(rs.getString("End_Pos") != null) ? rs.getString("End_Pos") : "");
							recordLayout.setHdfsDataType((rs.getString("HDFS_Data_Type") != null)
									? rs.getString("HDFS_Data_Type") : "");
							return recordLayout;
						}
					});

		return recordLayoutList;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	}

	@Override
	public int addFileType(AddFileRecord fileTypeDomain) {
		// TODO Auto-generated method stub
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus trasactionStatus = transactionManager.getTransaction(def);
		int status = 0;
		try {
			FileType fileType = fileTypeDomain.getFileType();
		
				int fileTypekey = getMaxId("select  max(file_type_key) as maxid from Meta_File_Type");
				int fileTypeId = getMaxId("select  max(file_type_id) as maxid from Meta_File_Type");
				fileTypekey = fileTypekey+1;
				fileTypeId = fileTypeId+1;
				status = jdbcTemplate.update(ApplicationConstants.ADD_FILE_BY_NM_CONVTN,
						new Object[] { fileTypekey, fileTypeId, fileType.getFileTypeVer(),
								fileType.getFileContent(), fileType.getSrcSystem(), fileType.getFileSrc(),
								fileType.getFileDesc(), fileType.getFileNamingConvention(), fileType.getFixedDelim(),
								fileType.getDefDelim(), fileType.getFileFreq(), fileType.getEffStartDt(),
								fileType.getEffEndDt(), fileType.getStatus(), fileType.getReqrOptnl() });

				status = jdbcTemplate.update(ApplicationConstants.INSERT_CLIENT_FILE,
						new Object[] { fileType.getClientId(), fileTypekey, null, fileType.getFileNamingConvention(),
								fileType.getDefDelim(), fileType.getFileFreq(), fileType.getEffStartDt(),
								fileType.getEffEndDt(), fileType.getStatus(), fileType.getReqrOptnl() });

				int fileRecTypeKeyValue = getMaxId("select max(file_Rec_type_key) as maxid from Meta_File_Rec_Type");
				fileRecTypeKeyValue =fileRecTypeKeyValue+1;
				
				status = jdbcTemplate.update(ApplicationConstants.INSERT_RECORD_TYPE,
						new Object[] { fileRecTypeKeyValue, fileTypekey, fileTypeDomain.getRecType().getRecTypeId(),
								fileTypeDomain.getRecType().getRecTypeDesc(),
								fileTypeDomain.getRecType().getHiveTable() });
				
				
				/*
				for (RecordType recordType : fileTypeDomain.getRecordTypeList()) {
				fileRecTypeKeyValue =fileRecTypeKeyValue+1;
				status = jdbcTemplate.update(ApplicationConstants.INSERT_RECORD_TYPE,
						new Object[] { fileRecTypeKeyValue, fileTypekey, recordType.getRecTypeId(),
								recordType.getRecTypeDesc(),
								recordType.getHiveTable() });
				}*/
				int fieldSeqValue = getMaxId("select max(Field_Seq) as maxid from Meta_Rec_Layout where File_Rec_Type_Key = "+fileRecTypeKeyValue+" ");
				for (RecordLayout recordLayout : fileTypeDomain.getRecLayoutList()) {
					fieldSeqValue = fieldSeqValue + 1;
					status = jdbcTemplate.update(ApplicationConstants.INSERT_RECORD_LAYOUT,
							new Object[] { fileRecTypeKeyValue, fieldSeqValue, recordLayout.getDataFld(),
									recordLayout.getFldDesc(), recordLayout.getDataType(), recordLayout.getLen(),
									recordLayout.getReqrOptnl(), recordLayout.getInPatient(),
									recordLayout.getOutPatient(), recordLayout.getSampleData(),
									recordLayout.getDfltDelim(), recordLayout.getStartPos(), recordLayout.getEndPos(),
									recordLayout.getHdfsDataType() });
				}
			transactionManager.commit(trasactionStatus);
		} catch (Exception e) {
			transactionManager.rollback(trasactionStatus);
			e.printStackTrace();
		}
		return status;
	}
	
	private int getMaxId(String sql){

		List<Integer> maxRecord = jdbcTemplate.query(sql,
				new RowMapper<Integer>() {

					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
						return (rs.getInt("maxid") != 0) ? rs.getInt("maxid") : 0;
					}
				});
		return maxRecord.get(0);
	}

	@Override
	public void updateFileType(FileRecodDomain fileTypeDomain) {
		// TODO Auto-generated method stub
		int fileRecTypeKeyValue = 0;
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus trasactionStatus = transactionManager.getTransaction(def);
	    
		try {
			FileType fileType = fileTypeDomain.getFileType();
			jdbcTemplate.update(ApplicationConstants.UPDATE_FILE_BY_NM_CONVTN,
					new Object[] { fileType.getFileTypeVer(), fileType.getFileContent(), fileType.getSrcSystem(),
							fileType.getFileSrc(),fileType.getFileDesc(), fileType.getFileNamingConvention(),fileType.getFixedDelim(),
							fileType.getDefDelim(), fileType.getFileFreq(), fileType.getEffStartDt(), fileType.getEffEndDt(),
							fileType.getStatus(), fileType.getReqrOptnl(), fileType.getFileTypeId(), fileType.getFileTypeKey() });

			jdbcTemplate.update(ApplicationConstants.UPDATE_CLIENT_FILE,
					new Object[] { fileType.getFileNamingConvention(), fileType.getDefDelim(), fileType.getFileFreq(),
							fileType.getStatus(), fileType.getReqrOptnl(), fileType.getClientId(), fileType.getFileTypeKey()});
			for(RecordType recordType:fileTypeDomain.getRecType()){
				if(recordType.isCheckFileType()){
					if(recordType.getFileRecTypeKey() !=0 ){
			           jdbcTemplate.update(ApplicationConstants.UPDATE_REC_TYPE,
					         new Object[] { recordType.getRecTypeId(),
							       recordType.getRecTypeDesc(), recordType.getHiveTable(),
							       recordType.getFileRecTypeKey(),  
							       recordType.getFileTypeKey() });
					 }else{
			            fileRecTypeKeyValue = getMaxId("select max(file_Rec_type_key) as maxid from Meta_File_Rec_Type");
				        fileRecTypeKeyValue =fileRecTypeKeyValue+1;
				        jdbcTemplate.update(ApplicationConstants.INSERT_RECORD_TYPE,
						new Object[] { fileRecTypeKeyValue, fileType.getFileTypeKey(), recordType.getRecTypeId(),
								recordType.getRecTypeDesc(), recordType.getHiveTable() });
					}
				
				}
				
			}
			
			for (RecordLayoutDet recordLayoutDet : fileTypeDomain.getRecLayoutList()) {
				for(RecordLayout recordLayout: recordLayoutDet.getRecordLayout()){
				List<Integer> count = jdbcTemplate
						.query("select count(*) as count from Meta_Rec_Layout where File_Rec_Type_Key="
								+ recordLayout.getFileRecTypeKey() + " and Field_Seq = " + recordLayout.getFldSeq()
								+ " ", new RowMapper<Integer>() {

									@Override
									public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
										return (rs.getInt("count") != 0) ? rs.getInt("count") : 0;
									}
								});
				if (count != null && count.get(0) > 0) {
					jdbcTemplate.update(ApplicationConstants.UPDATE_REC_LAYOUT,
							new Object[] { recordLayout.getDataFld(), recordLayout.getFldDesc(),
									recordLayout.getDataType(), recordLayout.getLen(), recordLayout.getReqrOptnl(),
									recordLayout.getInPatient(), recordLayout.getOutPatient(),
									recordLayout.getSampleData(), recordLayout.getDfltDelim(),
									recordLayout.getStartPos(), recordLayout.getEndPos(),
									recordLayout.getHdfsDataType(), recordLayout.getFileRecTypeKey(),
									recordLayout.getFldSeq() });
				} else {	
					String str = "select max(Field_Seq) as maxid from Meta_Rec_Layout where File_Rec_Type_Key = "+ recordLayout.getFileRecTypeKey() + " ";
					if(recordLayout.getFileRecTypeKey()==0){
						str = "select max(Field_Seq) as maxid from Meta_Rec_Layout where File_Rec_Type_Key = "+ fileRecTypeKeyValue + " ";
						recordLayout.setFileRecTypeKey(fileRecTypeKeyValue);
					}
					int fieldSeqValue = getMaxId(str);
					fieldSeqValue = fieldSeqValue+1;
					jdbcTemplate.update(ApplicationConstants.INSERT_RECORD_LAYOUT,
							new Object[] { recordLayout.getFileRecTypeKey(), fieldSeqValue,
									recordLayout.getDataFld(), recordLayout.getFldDesc(), recordLayout.getDataType(),
									recordLayout.getLen(), recordLayout.getReqrOptnl(), recordLayout.getInPatient(),
									recordLayout.getOutPatient(), recordLayout.getSampleData(),
									recordLayout.getDfltDelim(), recordLayout.getStartPos(), recordLayout.getEndPos(),
									recordLayout.getHdfsDataType() });
						}
				}
				}
			transactionManager.commit(trasactionStatus);
		} catch (Exception e) {
			transactionManager.rollback(trasactionStatus);
			e.printStackTrace();
		}
	}

	@Override
	public void deleteFileType(String fileTypeKey, String clientId) {
		// TODO Auto-generated method stub
		try {
			jdbcTemplate.update(ApplicationConstants.DELETE_CLIENT_FILE_BY_ID, new Object[] { fileTypeKey, clientId });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<RefRecordType> getRecordTypes() {
		List<RefRecordType> list = jdbcTemplate.query(ApplicationConstants.GET_RECORD_ID,
				new RowMapper<RefRecordType>() {

					@Override
					public RefRecordType mapRow(ResultSet rs, int rowNum) throws SQLException {
						RefRecordType type = new RefRecordType();
						type.setRecTypeId((rs.getInt("Rec_Type_ID") != 0) ? rs.getInt("Rec_Type_ID") : 0);
						type.setRecTypeDesc(
								(rs.getString("Rec_Type_Desc") != null) ? rs.getString("Rec_Type_Desc") : "");
						return type;
					}
				});

		return list;

	}
	
	@Override
	public List<FileType> searchClientFileDetails(String clinetId, String fileName) {
		// TODO Auto-generated method stub
		try {
			String sql = ""; 
				sql = "select * from Meta_File_Type mft  inner join Meta_Client_File mcf on mcf.File_Type_Key = mft.File_Type_Key "
						+ "where mcf.client_id='"
						+ clinetId + "' and mcf.File_Nm_Convntin like '%" +fileName+ "%'";

			List<FileType> list = jdbcTemplate.query(sql, new RowMapper<FileType>() {

				@Override
				public FileType mapRow(ResultSet rs, int size) throws SQLException {
					FileType fileType = new FileType();
					fileType.setClientId((rs.getInt("Client_ID") != 0) ? rs.getInt("Client_ID") : 0);
					fileType.setFileTypeKey((rs.getInt("File_Type_Key") != 0) ? rs.getInt("File_Type_Key") : 0);
					fileType.setFileTypeId((rs.getInt("File_Type_ID") != 0) ? rs.getInt("File_Type_ID") : 0);
					fileType.setFileTypeVer((rs.getInt("File_Type_Ver") != 0) ? rs.getInt("File_Type_Ver") : 0);
					fileType.setFileContent((rs.getString("File_Cntnt") != null) ? rs.getString("File_Cntnt") : "");
					fileType.setSrcSystem((rs.getString("Src_Sys") != null) ? rs.getString("Src_Sys") : "");
					fileType.setFileSrc((rs.getString("File_Src") != null) ? rs.getString("File_Src") : "");
					fileType.setFileDesc((rs.getString("File_Desc") != null) ? rs.getString("File_Desc") : "");
					fileType.setFileNamingConvention(
							(rs.getString("File_Nm_Convntin") != null) ? rs.getString("File_Nm_Convntin") : "");
					fileType.setFixedDelim((rs.getString("Fxd_Delim") != null) ? rs.getString("Fxd_Delim") : "");
					fileType.setDefDelim((rs.getString("Def_Delim") != null) ? rs.getString("Def_Delim") : "");
					fileType.setFileFreq((rs.getString("File_Freq") != null) ? rs.getString("File_Freq") : "");
					fileType.setEffStartDt(rs.getDate("Eff_Strt_Dt"));
					fileType.setEffEndDt(rs.getDate("Eff_End_Dt"));
					fileType.setStatus((rs.getInt("Sts") != 0) ? rs.getInt("Sts") : 0);
					fileType.setReqrOptnl((rs.getInt("Reqr_Optnl") != 0) ? rs.getInt("Reqr_Optnl") : 0);
					return fileType;
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
	public List<FileType> searchFileTypeDetails(String fileName) {
		// TODO Auto-generated method stub
		try {
			String sql = ""; 
				sql = "select * from Meta_File_Type where File_Nm_Convntin like '%" +fileName+ "%'";

			List<FileType> list = jdbcTemplate.query(sql, new RowMapper<FileType>() {

				@Override
				public FileType mapRow(ResultSet rs, int size) throws SQLException {
					FileType fileType = new FileType();
					fileType.setFileTypeKey((rs.getInt("File_Type_Key") != 0) ? rs.getInt("File_Type_Key") : 0);
					fileType.setFileTypeId((rs.getInt("File_Type_ID") != 0) ? rs.getInt("File_Type_ID") : 0);
					fileType.setFileTypeVer((rs.getInt("File_Type_Ver") != 0) ? rs.getInt("File_Type_Ver") : 0);
					fileType.setFileContent((rs.getString("File_Cntnt") != null) ? rs.getString("File_Cntnt") : "");
					fileType.setSrcSystem((rs.getString("Src_Sys") != null) ? rs.getString("Src_Sys") : "");
					fileType.setFileSrc((rs.getString("File_Src") != null) ? rs.getString("File_Src") : "");
					fileType.setFileDesc((rs.getString("File_Desc") != null) ? rs.getString("File_Desc") : "");
					fileType.setFileNamingConvention(
							(rs.getString("File_Nm_Convntin") != null) ? rs.getString("File_Nm_Convntin") : "");
					fileType.setFixedDelim((rs.getString("Fxd_Delim") != null) ? rs.getString("Fxd_Delim") : "");
					fileType.setDefDelim((rs.getString("Def_Delim") != null) ? rs.getString("Def_Delim") : "");
					fileType.setFileFreq((rs.getString("File_Freq") != null) ? rs.getString("File_Freq") : "");
					fileType.setEffStartDt(rs.getDate("Eff_Strt_Dt"));
					fileType.setEffEndDt(rs.getDate("Eff_End_Dt"));
					fileType.setStatus((rs.getInt("Sts") != 0) ? rs.getInt("Sts") : 0);
					fileType.setReqrOptnl((rs.getInt("Reqr_Optnl") != 0) ? rs.getInt("Reqr_Optnl") : 0);
					return fileType;
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
	public List<FileType> getFileTypeDetails() {
		// TODO Auto-generated method stub
		try {

			List<FileType> list = jdbcTemplate.query("select * from Meta_File_Type", new RowMapper<FileType>() {

				@Override
				public FileType mapRow(ResultSet rs, int size) throws SQLException {
					FileType fileType = new FileType();
					fileType.setFileTypeKey((rs.getInt("File_Type_Key") != 0) ? rs.getInt("File_Type_Key") : 0);
					fileType.setFileTypeId((rs.getInt("File_Type_ID") != 0) ? rs.getInt("File_Type_ID") : 0);
					fileType.setFileTypeVer((rs.getInt("File_Type_Ver") != 0) ? rs.getInt("File_Type_Ver") : 0);
					fileType.setFileContent((rs.getString("File_Cntnt") != null) ? rs.getString("File_Cntnt") : "");
					fileType.setSrcSystem((rs.getString("Src_Sys") != null) ? rs.getString("Src_Sys") : "");
					fileType.setFileSrc((rs.getString("File_Src") != null) ? rs.getString("File_Src") : "");
					fileType.setFileDesc((rs.getString("File_Desc") != null) ? rs.getString("File_Desc") : "");
					fileType.setFileNamingConvention(
							(rs.getString("File_Nm_Convntin") != null) ? rs.getString("File_Nm_Convntin") : "");
					fileType.setFixedDelim((rs.getString("Fxd_Delim") != null) ? rs.getString("Fxd_Delim") : "");
					fileType.setDefDelim((rs.getString("Def_Delim") != null) ? rs.getString("Def_Delim") : "");
					fileType.setFileFreq((rs.getString("File_Freq") != null) ? rs.getString("File_Freq") : "");
					fileType.setEffStartDt(rs.getDate("Eff_Strt_Dt"));
					fileType.setEffEndDt(rs.getDate("Eff_End_Dt"));
					fileType.setStatus((rs.getInt("Sts") != 0) ? rs.getInt("Sts") : 0);
					fileType.setReqrOptnl((rs.getInt("Reqr_Optnl") != 0) ? rs.getInt("Reqr_Optnl") : 0);
					return fileType;
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
	public int addFileToClient(FileType fileType) throws DuplicateKeyException {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			   status = jdbcTemplate.update(ApplicationConstants.INSERT_CLIENT_FILE,
						new Object[] { fileType.getClientId(), fileType.getFileTypeKey(), null, fileType.getFileNamingConvention(),
								fileType.getDefDelim(), fileType.getFileFreq(), fileType.getEffStartDt(),
								fileType.getEffEndDt(), fileType.getStatus(), fileType.getReqrOptnl() });				
		} catch(DuplicateKeyException ex){
			status =2;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	public void updateClientFileType(ClientFile clientFile) {
		// TODO Auto-generated method stub
		try {
			jdbcTemplate.update(ApplicationConstants.UPDATE_CLIENT_FILE,
					new Object[] { clientFile.getFileNamingConvention(), clientFile.getDefDelim(), clientFile.getFileFreq(),
							clientFile.getEffEndDt(), clientFile.getEffStartDt(), clientFile.getStatus(), 
							clientFile.getReqrOptnl(), clientFile.getClientId(), clientFile.getFileTypeKey()});
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

