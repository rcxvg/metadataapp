package com.rcggs.metadata.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcggs.metadata.model.AddFileRecord;
import com.rcggs.metadata.model.ClientFile;
import com.rcggs.metadata.model.FileRecodDomain;
import com.rcggs.metadata.model.FileType;
import com.rcggs.metadata.model.RecordLayout;
import com.rcggs.metadata.model.RecordLayoutDet;
import com.rcggs.metadata.model.RecordType;
import com.rcggs.metadata.model.RefRecordType;
import com.rcggs.metadata.services.FileTypeService;

@RestController
public class FileTypeController {
	
	private FileTypeService fileTypeService;

	public FileTypeService getFileTypeService() {
		return fileTypeService;
	}

	@Autowired
	public void setFileTypeService(FileTypeService fileTypeService) {
		this.fileTypeService = fileTypeService;
	}
	
	@RequestMapping(value = "/fileRecTypes", method = RequestMethod.GET)
	public ResponseEntity<List<RefRecordType>> getFileRecTypes() {
		return new ResponseEntity<List<RefRecordType>>(fileTypeService.getRecordTypes(), HttpStatus.OK);
	}
		
	@RequestMapping(value = "/fileTypeDetails", method = RequestMethod.GET)
	public ResponseEntity<List<FileType>> getFileTypeDetails() {
		List<FileType> list=fileTypeService.getFileTypeDetails();
		return new ResponseEntity<List<FileType>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/clientFileDetails/{clientId}", method = RequestMethod.GET)
	public ResponseEntity<List<FileType>> getClientFileDetails(@PathVariable("clientId") String clientId ) {
		List<FileType> list=fileTypeService.getClientFileDetails(clientId);
		System.out.println("List" + list);
		return new ResponseEntity<List<FileType>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/recTypeDetails/{fileTypeKey}", method = RequestMethod.GET)
	public ResponseEntity<List<RecordType>> getRecTypeDetails(@PathVariable("fileTypeKey") int fileTypeKey ) {
		List<RecordType> list=fileTypeService.getRecTypeDetails(fileTypeKey);
		System.out.println("List" + list);
		return new ResponseEntity<List<RecordType>>(list, HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/recLayoutDetails/{fileRecTypeKey}", method = RequestMethod.GET)
	public ResponseEntity<List<RecordLayout>> getRecLayoutDetails(@PathVariable("fileRecTypeKey") int fileRecTypeKey ) {
		List<RecordLayout> list=fileTypeService.getRecLayoutDetails(fileRecTypeKey);
		System.out.println("List" + list);
		return new ResponseEntity<List<RecordLayout>>(list, HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/recLayoutDetails", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<List<RecordLayoutDet>> getRecLayoutDetails(@RequestBody List<RecordType> recType ) {
		List<RecordLayout> list = null;
		List<RecordLayoutDet> listDet = new ArrayList<>();
		
		int i=0;
		for(RecordType recType1 : recType){
			if(recType1.isCheckFileType()){
				RecordLayoutDet recordLayoutDet = new RecordLayoutDet();
				list=fileTypeService.getRecLayoutDetails(recType1.getFileRecTypeKey());
				recordLayoutDet.setRecKey(i);
				i++;
				recordLayoutDet.setRecordLayout(list);
				listDet.add(recordLayoutDet);
			}
		}
		return new ResponseEntity<List<RecordLayoutDet>>(listDet, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/fileTypeDetails/", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<Integer> AddFileRecord(@RequestBody AddFileRecord fileRecord)throws Exception {
	    fileTypeService.addFileType(fileRecord);
	    return new ResponseEntity<Integer>(0, HttpStatus.OK);
	}
	
	@RequestMapping(value="/fileTypeDetails/update", method = RequestMethod.POST )
	public ResponseEntity<FileRecodDomain> updateFileRecord(@RequestBody FileRecodDomain fileRecord) {
		fileTypeService.updateFileType(fileRecord);
		return new ResponseEntity<FileRecodDomain>(fileRecord, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/fileTypeDetails/delete/{fileTypeKey}/{clientId}", method = RequestMethod.GET )
	public ResponseEntity<Void> deleteFileType(@PathVariable("fileTypeKey") String fileTypeKey,@PathVariable("clientId") String clientId) {
		fileTypeService.deleteFileType(fileTypeKey,clientId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	} 
	
	@RequestMapping(value = "/searchFilesById/{clientId}/{fileName}", method = RequestMethod.GET)
	public ResponseEntity<List<FileType>> getClientFileDetails(@PathVariable("clientId") String clientId, @PathVariable("fileName") String fileName) {
		List<FileType> list=fileTypeService.searchClientFileDetails(clientId, fileName);
		return new ResponseEntity<List<FileType>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/searchFiles/{fileName}", method = RequestMethod.GET)
	public ResponseEntity<List<FileType>> getFileDetails(@PathVariable("fileName") String fileName) {
		List<FileType> list=fileTypeService.searchFileTypeDetails(fileName);
		return new ResponseEntity<List<FileType>>(list, HttpStatus.OK);
	}
	
	 @RequestMapping(value = "/filesByClientId", method = RequestMethod.POST, headers = "Accept=application/json")
	 public ResponseEntity<Integer> addFileToClient(@RequestBody FileType fileType)throws Exception {
		int status= fileTypeService.addFileToClient(fileType);
			 return new ResponseEntity<Integer>(status, HttpStatus.OK);
	  }
	 
	 @RequestMapping(value="/clientFileDetails/update", method = RequestMethod.POST )
		public ResponseEntity<ClientFile> updateClientFile(@RequestBody ClientFile clientFile) {
			fileTypeService.updateClientFileType(clientFile);;
			return new ResponseEntity<ClientFile>(clientFile, HttpStatus.OK);
		}


}