package com.rcggs.metadata.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rcggs.metadata.model.AddFileRecord;
import com.rcggs.metadata.model.ClientFile;
import com.rcggs.metadata.model.FileRecodDomain;
import com.rcggs.metadata.model.FileType;
import com.rcggs.metadata.model.RecordLayout;
import com.rcggs.metadata.model.RecordType;
import com.rcggs.metadata.model.RefRecordType;

@Component
public interface FileTypeService {
 
	 public List<FileType> getClientFileDetails(String clinetId);
	    
	    public List<RecordType> getRecTypeDetails(int fileTypeKey);
	    
	    public List<RecordLayout> getRecLayoutDetails(int fileRecTypeKey);
	    
	    public int addFileType(AddFileRecord fileRecordDomain);
	    
	    void updateFileType(FileRecodDomain fileTypeDomain);
	    
	    public void deleteFileType(String fileTypeKey,String clientId);
	    
	    public  List<RefRecordType> getRecordTypes();
	    
	    public List<FileType> searchClientFileDetails(String clinetId, String fileName);
	    
	    public List<FileType> searchFileTypeDetails(String fileName);
	    
	    public List<FileType> getFileTypeDetails();
	    
	    public int addFileToClient(FileType fileType);
	    
	    public void updateClientFileType(ClientFile clientFile);

}
