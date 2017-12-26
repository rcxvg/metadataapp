package com.rcggs.metadata.util;

public class ApplicationConstants {
	
	public final static String GET_CLIENT_DETAILS_BY_ID = "select client_id, client_number, client_name, client_desc,"
			+ "active_flag from Meta_Client where client_number=?";

	public final static String ADD_CLIENT_DETAILS_BY_ID = "insert into Meta_Client(client_id, client_number, client_name,"
			+ " client_desc, active_flag) values(?,?,?,?,?)";

	public final static String DELETE_CLIENT_DETAILS_BY_ID = "delete from Meta_Client where client_number=?";

	public final static String UPDATE_CLIENT_DETAILS_BY_ID = "update Meta_Client set client_number=?, client_name=?, "
			+ "client_desc=?, active_flag=? WHERE client_id=?";

	public final static String GET_ALL_CLIENT_DETAILS = "select client_id, client_number, client_name, client_desc,"
			+ "active_flag from Meta_Client ";

	public final static String GET_ALL_FILE_TYPES = "select File_Type_Key ,File_Type_ID, File_Type_Ver,"
			+ "File_Cntnt, Src_Sys, File_Src, File_Desc, File_Nm_Convntin, Fxd_Delim, Def_Delim, File_Freq,"
			+ " Eff_Strt_Dt, Eff_End_Dt, Sts, Reqr_Optnl from Meta_File_Type";

	public final static String GET_FILE_TYPE_BY_NM_CONVTN = "select File_Type_Key ,File_Type_ID, File_Type_Ver,"
			+ "File_Cntnt, Src_Sys, File_Src, File_Desc, File_Nm_Convntin, Fxd_Delim, Def_Delim, File_Freq,"
			+ " Eff_Strt_Dt, Eff_End_Dt, Sts, Reqr_Optnl from Meta_File_Type where File_Nm_Convntin like '%?%'";

	public final static String ADD_FILE_BY_NM_CONVTN = "insert into Meta_File_Type(File_Type_Key,File_Type_ID,"
			+ "File_Type_Ver, File_Cntnt, Src_Sys, File_Src, File_Desc, File_Nm_Convntin, Fxd_Delim, Def_Delim,"
			+ "File_Freq, Eff_Strt_Dt, Eff_End_Dt, Sts, Reqr_Optnl) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public final static String UPDATE_FILE_BY_NM_CONVTN = "update Meta_File_Type set File_Type_Ver=?, file_cntnt=?,"
			+ "Src_Sys=?, File_Src=?, File_Desc=?, File_Nm_Convntin=?, Fxd_Delim=?, Def_Delim=?, File_Freq=?, Eff_Strt_Dt=?,"
			+ "Eff_End_Dt=?, Sts=?, Reqr_Optnl=? WHERE File_Type_Id=? and File_Type_Key=?";

	public final static String UPDATE_CLIENT_FILE = "update Meta_Client_File set File_Nm_Convntin=?, Def_Delim=?, "
							+ "File_Freq=?, Eff_Strt_Dt=?, Eff_End_Dt=?, sts=?, Reqr_Optnl=? where Client_ID=? and file_type_key=?";

	public final static String UPDATE_REC_TYPE = "update Meta_File_Rec_Type set Rec_Type_ID=?, File_Rec_Type_Desc=?,"
			+ "Hive_Tbl=? where File_Rec_Type_Key=? and File_Type_Key=?";

	public final static String UPDATE_REC_LAYOUT = "update Meta_Rec_Layout set Data_Field=?, Field_Desc=?, Data_Type=?,"
			+ "Len=?, Reqr_Optnl=?, In_Ptnt=?, Out_Ptnt=?, Sample_Data=?, Dflt_Delim=?, Strt_Pos=?,"
			+ "End_Pos=?, HDFS_Data_Type=? where File_Rec_Type_Key=? and Field_Seq=?";

	public final static String DELETE_FILE_BY_Id = "delete from Meta_File_Type where File_Type_Key=?";

	public final static String DELETE_CLIENT_FILE_BY_ID = "delete from Meta_Client_File where file_type_key=? and Client_ID=? ";

	public final static String DELETE_RECORD_TYPE = "delete from Meta_File_Rec_Type where file_rec_type_key=? and File_Type_Key=?";

	public final static String DELETE_REC_LAYOUT = "delete from Meta_Rec_Layout where File_Rec_Type_Key=?";

	public final static String GET_RECORD_ID = "select Rec_Type_ID, Rec_Type_Desc from Meta_Ref_Rec_Type ";

	public final static String INSERT_CLIENT_FILE = "insert into Meta_Client_File(Client_ID, file_type_key, file_path,"
			+ " File_Nm_Convntin, Def_Delim, File_Freq,Eff_Strt_Dt, Eff_End_Dt, Sts, Reqr_Optnl) values(?,?,?,?,?,?,?,?,?,?) ";

	public final static String INSERT_RECORD_TYPE = "insert into Meta_File_Rec_Type(File_Rec_Type_Key, File_Type_Key, "
			+ "Rec_Type_ID, File_Rec_Type_Desc, Hive_Tbl) values(?,?,?,?,?) ";

	public final static String INSERT_RECORD_LAYOUT = "insert into Meta_Rec_Layout(File_Rec_Type_Key,Field_Seq,Data_Field,"
			+ "Field_Desc,Data_Type,Len,Reqr_Optnl,In_Ptnt,Out_Ptnt,Sample_Data,Dflt_Delim,Strt_Pos,End_Pos,"
			+ "HDFS_Data_Type) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	
	public final static String GET_JOB_ID = "select Job_Id, Job_Desc, Active_Flag, Job_Detail from Meta_Job where Job_Id=?";
	
	public final static String GET_ALL_JOBS = "select Job_Id, Job_Desc, Active_Flag, Job_Detail from Meta_Job ";
	
	public final static String INSERT_JOB_BY_ID = "insert into Meta_Job(Job_Id, Job_Desc, Active_Flag, Job_Detail)"
			+ " values(?,?,?,?)";
	
	public final static String UPDATE_JOB = "update Meta_Job set Job_Desc=?, Active_Flag=?, "
			+ "Job_Detail=? where Job_Id=?";
	
	public final static String DELETE_JOB_BY_ID = "delete from Meta_Job where Job_Id=?";
	
    public final static String GET_JOB_UNIT_ID = "select Job_Id, Unit_Id, Unit_Type_Id, Unit_Desc, Unit_Active_Flag, "
    		+ "Unit_Order from Meta_Job_Unit where Job_Id=?";
	
	public final static String GET_ALL_JOBUNITS = "select Job_Id, Unit_Id, Unit_Type_Id, Unit_Desc, Unit_Active_Flag, "
    		+ "Unit_Order from Meta_Job_Unit ";
	
	public final static String INSERT_JOB_UNIT_BY_ID = "insert into Meta_Job_Unit(Job_Id, Unit_Id, Unit_Type_Id, "
			+ "Unit_Desc, Unit_Active_Flag, Unit_Order) values(?,?,?,?,?,?)";
	
	public final static String UPDATE_JOB_UNIT = "update Meta_Job_Unit set Unit_Type_Id=?, "
			+ "Unit_Desc=?, Unit_Active_Flag=?, Unit_Order=? where Job_Id=? and Unit_Id=?";
	
	public final static String DELETE_JOB_UNIT_BY_ID = "delete from Meta_Job_Unit where Job_Id=? and Unit_Id=?";
	
	public final static String INSERT_TABLE_LIST_BY_ID = "insert into Meta_Table_List(Table_Id,Environment_Type_Id,"
			+ "Table_Name,File_Rec_Type_Key) values(?,?,?,?)";
	
	public final static String UPDATE_TABLE_LIST = "update Meta_Table_List set Environment_Type_Id=?, "
			+ "Table_Name=?, File_Rec_Type_Key=? where Table_Id=?";
	
	public final static String DELETE_TABLE_LIST_BY_ID = "delete from Meta_Table_List where Table_Id=?";
	
	public final static String INSERT_ENV_PARAM_BY_ID = "insert into Meta_Environment_Parm(Environment_Id,Environment_Type_Id"
			+ ",Connection_Type_Id,Client_Id,Db_Server,Db_Name,Db_User,Db_Pass,Port,Source_File_Loc,Dest_File_Loc,Dsn)"
			+ " values(?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public final static String INSERT_CLIENT_JOB_BY_ID = "insert into Meta_Client_Job(Job_Id,Job_Active_Flag,Job_Order,"
			+ "Unit_Test_Active_Flag,App_Id,Client_Id,End_Ts) values(?,?,?,?,?,?,?)";
	
	public final static String INSERT_CLIENT_PARAM_BY_ID = "insert into Meta_Client_Parm(Client_Id,"
			+ "Transtn_Regtr_Table_Name,Email_Alert_To) values(?,?,?)";
	
	public final static String INSERT_STAGE_TASK= "insert into Meta_Unit_Stage_Task(Job_Id,Unit_Id,Task_Id,Source_Table_Name,"
			+ "Source_Filter,Stage_Table_Name,Active_Flag,Task_Order,Update_Track_Field_Name,Update_Track_Field_Type,"
			+ "Partition_Field_Name,Source_Cdc_Table_Name,Source_Table_Id,Stage_Table_Id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public final static String INSERT_STAGE_MAP = "insert into Meta_Unit_Stage_Map(Job_Id,Unit_Id,Task_Id,Source_Column_Name,Column_Order,"
			+ "Stage_Column_Name,Xform_Type_Id,Column_Type_Id,Column_Expression,Column_Active_Flag,Column_Format,Min_Length,Max_Length,"
			+ "Key_Ind,Min_Value,Max_Value) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public final static String INSERT_LOAD_TASK = "insert into Meta_Unit_Load_Task(Job_Id,Unit_Id,Task_Id,Stage_Table_Name,"
			+ "Target_Table_Name,Target_Filter,Delete_Ind,Batch_Max_Size,Active_Flag,Task_Order,Target_Table_Id,load_Mode)"
			+ " values(?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public final static String INSERT_LOAD_MAP = "insert into Meta_Unit_Load_Map(Job_Id,Unit_Id,Task_Id,Source_Column_Name,"
			+ "Target_Column_Name,Column_Order,Column_Type_Id,Key_Ind,Active_Flag,Dq_Filter) values(?,?,?,?,?,?,?,?,?,?)";
	
	public final static String GET_SOURCE_TABLE_ID = "select table_id, table_name,File_Rec_Type_Key from Meta_Table_List where Environment_Type_Id=1";
	
	public final static String GET_TARGET_TABLE_ID = "select table_id, table_name,File_Rec_Type_Key from Meta_Table_List where Environment_Type_Id=3";
	
	public final static String GET_APP_ID = "select App_Id as id, App_Nm as value from Meta_App ";
	
	public final static String GET_CLIENT_ID = "select client_id as id, client_number as value from Meta_Client";
	
	public final static String GET_ENV_Id = "select Environment_Id as id, Environment_Desc as value from Ref_Environment";
	
	public final static String GET_ENV_TYPE_Id = "select Environment_Type_Id as id, Environment_Type_Desc as value from Ref_Environment_Type";
	
	public final static String GET_Connection_TYPE_Id = "select Connection_Type_Id as id, Connection_Type_Desc as value from Ref_Connection_Type";
	
	public final static String GET_UNIT_TYPE_ID = "select Unit_Type_Id as id, Unit_Type_Desc as value from Ref_Unit_Type ";
	
	public final static String GET_FILE_RECTYPES = "select File_Rec_Type_Key as id, File_Rec_Type_Key as value from Meta_File_Rec_Type ";
	
	public final static String GET_REC_LAYOUT = "select Field_Seq as id, Data_Field as value from Meta_Rec_Layout ";
	
	public final static String GET_XFORM_TYPE = "select Xform_Type_Id, Xform_Type_Desc from Ref_Xform_Type ";
	
	public final static String GET_COLUMN_TYPE = "select column_Type_Id as id, column_Type_Desc as value from Ref_Column_Type";
	
	public final static String GET_VALIDATION_TYPE = "select Validation_Id, Validation_Type from Ref_Validation";
	
	public final static String GET_DATA_CORRCTION = "select Data_Correction,Data_Correction_Desc from Ref_Data_Correction";
	
	public final static String GET_COL_NAME = "select Column_Order,Source_Column_Name from Meta_Job_Template where Job_Id=?";
	
	public final static String GET_COLUMN_DEFINITIONS = "select sgmp.Column_Order,sgts.Job_Id,sgts.Source_Table_Name,sgmp.Source_Column_Name,rclt.Column_Type_Desc,"
			+ "rxt.Xform_Type_Desc,sgmp.Column_Expression,sgmp.Column_Format,lts.Target_Table_Name Target_Table_Name,"
			+ "lmp.Target_Column_Name Target_Column_Name,lmp.Active_Flag,sgmp.Min_Length, sgmp.Max_Length, sgmp.Min_Value,"
			+ "sgmp.Max_Value, sgmp.Column_Identifier from Meta_Unit_Stage_Task sgts join Meta_Unit_Stage_Map sgmp "
			+ "on sgts.Job_Id= sgmp.Job_Id and sgts.Unit_Id= sgmp.Unit_Id and sgts.Task_Id= sgmp.Task_Id left join Ref_Column_Type rclt "
			+ "on sgmp.Column_Type_Id=rclt.Column_Type_Id left join Ref_Xform_Type rXt on sgmp.Xform_Type_Id= rxt.Xform_Type_Id "
			+ "left join Meta_Unit_Stage_Check sck on sgmp.Column_Order=sck.Column_Order and sgmp.Job_Id=sck.Job_Id and sgmp.Task_Id=sck.Task_Id "
			+ "left join Ref_Validation rvl on sck.Validation_Id=rvl.Validation_Id left join Meta_Unit_Load_Task lts on sgts.Job_Id=lts.Job_Id "
			+ "and lower(sgts.Stage_Table_Name)=lower(lts.Stage_Table_Name) left join Meta_Unit_Load_Map lmp on sgts.Job_Id=lmp.Job_Id "
			+ "and lower(sgmp.Stage_Column_Name)=lower(lmp.Source_Column_Name) and lts.Task_Id=lmp.Task_Id where sgts.job_id=? and lts.Task_Id=1";
	
	//Delete Job by JobId
	public final static String DELETE_CLIENT_JOB = "delete from Meta_Client_Job where Job_Id=?";
	public final static String DELETE_Meta_Exception = "delete from Meta_Exception where Job_Id=?";
    public final static String DELETE_JOB_UNIT_LOG = "delete from Meta_Job_Unit_Log where Job_Id=?";
	public final static String DELETE_JOB_LOG = "delete from Meta_Job_Log where Job_Id=?";
	public final static String DELETE_UNIT_STAGE_CHECK = "delete from Meta_Unit_Stage_Check where Job_Id=?";
	public final static String DELETE_UNIT_STAGE_Map = "delete from Meta_Unit_Stage_Map where Job_Id=?";
	public final static String DELETE_UNIT_STAGE_TASK = "delete from Meta_Unit_Stage_Task where Job_Id=?";
	public final static String DELETE_UNIT_LOAD_MAP = "delete from Meta_Unit_Load_Map where Job_Id=?";
	public final static String DELETE_UNIT_LOAD_TASK = "delete from Meta_Unit_Load_Task where Job_Id=?";
	public final static String DELETE_UNIT_Conversion_MAP = "delete from Meta_Unit_Conversion_Map where Job_Id=?";
	public final static String DELETE_UNIT_Conversion_TASK = "delete from Meta_Unit_Conversion_Task where Job_Id=?";
	public final static String DELETE_JOB_UNIT = "delete from Meta_Job_Unit where Job_Id=?";
	public final static String DELETE_JOB = "delete from Meta_Job where Job_Id=?";
	
	

}
