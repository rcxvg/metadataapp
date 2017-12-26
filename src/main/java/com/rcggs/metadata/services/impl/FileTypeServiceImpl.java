package com.rcggs.metadata.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rcggs.metadata.dao.IFileTypeDao;
import com.rcggs.metadata.model.AddFileRecord;
import com.rcggs.metadata.model.ClientFile;
import com.rcggs.metadata.model.FileRecodDomain;
import com.rcggs.metadata.model.FileType;
import com.rcggs.metadata.model.RecordLayout;
import com.rcggs.metadata.model.RecordType;
import com.rcggs.metadata.model.RefRecordType;
import com.rcggs.metadata.services.FileTypeService;

public class FileTypeServiceImpl implements FileTypeService{
	
	private IFileTypeDao iFileTypeDao;

	public IFileTypeDao getiFileTypeDao() {
		return iFileTypeDao;
	}

	@Autowired
	public void setiFileTypeDao(IFileTypeDao iFileTypeDao) {
		this.iFileTypeDao = iFileTypeDao;
	}

	@Override
	public List<FileType> getClientFileDetails(String clientId) {
		// TODO Auto-generated method stub
		return iFileTypeDao.getClientFileDetails(clientId);
	}
	
	@Override
	public List<RecordType> getRecTypeDetails(int fileTypeKey) {
		// TODO Auto-generated method stub
		return iFileTypeDao.getRecTypeDetails(fileTypeKey);
	}

	@Override
	public List<RecordLayout> getRecLayoutDetails(int fileRecTypeKey) {
		// TODO Auto-generated method stub
		return iFileTypeDao.getRecLayoutDetails(fileRecTypeKey);
	}

	@Override
	public int addFileType(AddFileRecord fileRecodDomain) {
		// TODO Auto-generated method stub
		return iFileTypeDao.addFileType(fileRecodDomain);
	}

	@Override
	public void updateFileType(FileRecodDomain fileTypeDomain) {
		// TODO Auto-generated method stub
		iFileTypeDao.updateFileType(fileTypeDomain);
	}

	@Override
	public void deleteFileType(String fileTypeKey,String clientId) {
		// TODO Auto-generated method stub
		iFileTypeDao.deleteFileType(fileTypeKey,clientId);
	}

	@Override
	public List<RefRecordType> getRecordTypes() {
		// TODO Auto-generated method stub
		return iFileTypeDao.getRecordTypes();
	}

	@Override
	public List<FileType> searchClientFileDetails(String clinetId, String fileName) {
		// TODO Auto-generated method stub
		return iFileTypeDao.searchClientFileDetails(clinetId, fileName);
	}

	@Override
	public List<FileType> searchFileTypeDetails(String fileName) {
		// TODO Auto-generated method stub
		return iFileTypeDao.searchFileTypeDetails(fileName);
	}
	
	@Override
	public List<FileType> getFileTypeDetails() {
		// TODO Auto-generated method stub
		return iFileTypeDao.getFileTypeDetails();
	}

	@Override
	public int addFileToClient(FileType fileType) {
		// TODO Auto-generated method stub
		return iFileTypeDao.addFileToClient(fileType);
	}

	@Override
	public void updateClientFileType(ClientFile clientFile) {
		// TODO Auto-generated method stub
		iFileTypeDao.updateClientFileType(clientFile);
	}

}
