'use strict';

metadaApp.controller('MetadataController', [ '$compile','$rootScope','$scope','$location','$uibModal', 'MetadataServices',
  function($compile,$rootScope,$scope, $location,$modal, MetadataServices) {
   var self = this;
   var modalInstance = null;
   $scope.selectedStatusType = 0;
   $scope.clientNumber = '';
   $scope.showSuccessAlert = false;
   $scope.showErrorAlert = false;
   $scope.gap = 5;  
  
   $scope.fileTypeKey = 0;
   $scope.fileRecTypeKey =0;
   $scope.recTypeChecked = false;
   $scope.filteredTodos = [];
   $scope.recLayoutList = [];
   $scope.currentPage = 1;
   $scope.pageSize = 10;
   $scope.numPerPage = 10;
   $scope.maxSize = 5;
   
  // $scope.clientFile = {}
   
   $scope.activeFlagLst = [{id:1,value:1},{id:0,value:0}]
   
   $scope.selectedActiveFlag = $scope.activeFlagLst[0].id;
   
   $scope.fileType = {
		   fileTypeKey : "", fileTypeId : "", fileTypeVer : "", fileContent : "", srcSystem : "", fileSrc : "", fileDesc : "", 
		   fileNamingConvention : "", fixedDelim : "", defDelim : "", fileFreq : "", effStartDt : "", effEndDt : "", status : "", reqrOptnl : ""
   } 
   
   $scope.recLayout={
		   recTypeKey: "",fldSeq :"",dataFld:"",fldDesc:"", dataType:"",len:"",reqrOptnl:"",
		   inPatient:"",outPatient:"",sampleData:"",dfltDelim:"",startPos:"",endPos:"",hdfsDataType:""
   }
   
   $scope.statusList = [{id:1,value:1},{id:0,value:0}]
   $scope.dataTypeList = [{id:'int',value:'int'},{id:'text',value:'text'},{id:'date',value:'date'}, {id:'datetime',value:'datetime'},
	                        {id:'money',value:'money'}]
   
   $scope.selectedStatusType = $scope.statusList[0].id;
 
	$scope.pagination = function(){
		 $scope.$watch('currentPage + numPerPage', function() {
			    var begin = (($scope.currentPage - 1) * $scope.numPerPage)
			    , end = begin + $scope.numPerPage;
			    
			    $scope.filteredClientDetails = $scope.clientDetails.slice(begin, end);
			  });
		   
	}
	
	$scope.numPages = function () {
	    return Math.ceil($scope.clientDetails.length / $scope.numPerPage);
	  };
	 
   $scope.client = {
			clientNumber : "",
			clientName : "",
			clientDesc : "",
			activeFlag : ""
		}
   
	$scope.saveClient = function() {
	   $scope.client.activeFlag=$scope.selectedActiveFlag;
		 MetadataServices.addClient($scope.client).then(function(response){
			 $scope.cancelModal();
			 $scope.clientNumber = $scope.client.clientNumber;
			 $scope.fetchClientDetailsByNumber();
			 $scope.message = "Client Added Successfully ";
			 $scope.showSuccessAlert = true;
			 $scope.showErrorAlert = false;
		   }, function(errResponse){
			      $scope.cancelModal();
			      $scope.showSuccessAlert = false;
			      $scope.showErrorAlert = true;
	               console.error('Error while creating client');
	               $scope.message = "Error while creating client "
	           }
	       );

	},
	$scope.updateClient = function() {
		 $scope.client.activeFlag=$scope.selectedActiveFlag;
		 MetadataServices.updateClient($scope.client).then(function(response){
			 $scope.cancelModal();
			 $scope.clientNumber = $scope.client.clientNumber;
			 $scope.fetchClientDetailsByNumber();
			 $scope.message = "Client Updated  Successfully ";
			 $scope.showSuccessAlert = true;
			 $scope.showErrorAlert = false;
			
		   }, function(errResponse){
			   $scope.cancelModal();
	               console.error('Error while updating client');
	               $scope.message = "Error while updating client "
	            	   $scope.showSuccessAlert = false;
	               $scope.showErrorAlert = true;
	            	   
	           }
	       );

	},
   
   $scope.fetchClientDetailsByNumber = function() {
    
    MetadataServices.fetchClientDetailsByNumber($scope.clientNumber).then(function(response) {
     $scope.clientDetails = response;
     $scope.pagination();
    }, function(errResponse) {
     console.error('Error while fetching Users');
    });
   } 
 		    
   $scope.deleteClientRow = function(client){
	   if (confirm('Do you really want to delete the Client?')) {
	   MetadataServices.deleteClientDetailsById(client.clientNumber).then(function(response) {
		   $scope.message = "Client deleted successfully"
			 
		   $scope.showSuccessAlert = true;
		   $scope.showErrorAlert = false;
		   $scope.clientNumber = "";
		   $scope.fetchClientDetailsByNumber();
		     
		    }, function(errResponse) {
		     console.error('Error while deleting client');
		     $scope.showErrorAlert = true;
		     $scope.showSuccessAlert = false;
		    });
	   }else{
		   console.log("not.......")
	   }
   }
   
   $scope.addClient = function(){
	   $scope.client = {
				clientNumber : "",
				clientName : "",
				clientDesc : "",
				activeFlag : ""
			} 
	   modalInstance = $modal.open({
		   animation: false,
		   templateUrl: 'static/pages/addClient.html',
		   controller: 'clientController',
		   scope: $scope,
		   size: '',
		   resolve: {
		   }
		   });

   }

   $scope.editClient = function(client){
	   $scope.client = client;
	   modalInstance = $modal.open({
		   animation: false,
		   templateUrl: 'static/pages/editClient.html',
		   controller: 'clientController',
		   scope: $scope,
		   size: '',
		   resolve: {
		   }
		   });
   }
   
   
	$scope.fileName="";
	 $scope.fetchClientFileDetails = function() {
		    $rootScope.appName ="Client";
		    MetadataServices.fetchClientFileDetails( $rootScope.globalSelectedClientId).then(function(response) {
		     $scope.clientFileDetails = response;
		    }, function(errResponse) {
		     console.error('Error while fetching ClientFiles');
		    });
		   } 
	 
	 $scope.fetchFileTypeDetails = function() {
		    $rootScope.appName = "File";
		    MetadataServices.fetchFileTypeDetails().then(function(response) {
		     $scope.fileTypeDetails = response;
		    }, function(errResponse) {
		     console.error('Error while fetching fileTypes');
		    });
		   } 
	 
	 $scope.searchFilesById = function(fileName) {
		    
		    MetadataServices.searchFilesById( $rootScope.globalSelectedClientId, fileName).then(function(response) {
		     $scope.clientFileDetails = response;
		    }, function(errResponse) {
		     console.error('Error while searchhing clientFiles');
		    });
		   }
	 
	 $scope.searchFiles = function(fileName) {
		    
		    MetadataServices.searchFiles(fileName).then(function(response) {
		     $scope.fileTypeDetails = response;
		    }, function(errResponse) {
		     console.error('Error while searchhing fileTypes');
		    });
		   }
	 
	 $scope.fetchRecTypeDetails = function(fileType) {
		    
		    MetadataServices.fetchRecTypeDetails( fileType.fileTypeKey).then(function(response) {
		     $scope.recType1 = response;
		    }, function(errResponse) {
		     console.error('Error while fetching recTypes');
		    });
		   } 
	 
	 $scope.fetchRecLayoutDetails = function() {
		    
		    MetadataServices.fetchRecLayoutDetails( $scope.fileRecTypeKey).then(function(response) {
		     $scope.recLayoutDetails = response;
		     $scope.$apply();
		    }, function(errResponse) {
		     console.error('Error while fetching recLayouts');
		    });
		   } 

     $scope.addFileType = function(){
	  $scope.fileType = {
			   fileTypeKey : "", fileTypeId : "", fileTypeVer : "", fileContent : "", srcSystem : "", fileSrc : "", fileDesc : "", 
			   fileNamingConvention : "", fixedDelim : "", defDelim : "", fileFreq : "", effStartDt : "", effEndDt : "", status : "", reqrOptnl : ""
	   } 
	   modalInstance = $modal.open({
		   animation: false,
		   templateUrl: 'static/pages/addFileType.html',
		   controller: 'clientController',
		   scope: $scope,
		   size: '',
		   resolve: {
		   }
		   });
   $location.path("/addFileType");

   }
   
   $scope.saveFileType = function() {
	   $scope.fileType.clientId =  $rootScope.globalSelectedClientId;
		 MetadataServices.addFileType($scope.fileType).then(function(response){
			 $scope.cancelModal();
			 $scope.fileName = "";
			 $scope.fetchFileDetailsByName();
			 $scope.message = "File Type Added Successfully ";
			 $scope.showSuccessAlert = true;
			 $scope.showErrorAlert = false;
		   }, function(errResponse){
			      $scope.cancelModal();
			      $scope.showSuccessAlert = false;
			      $scope.showErrorAlert = true;
	               $scope.message = "Error while creating file type "
	           }
	       );

	},
	
	$scope.updateFileType = function() {
		$scope.fileType.clientId =  $rootScope.globalSelectedClientId;
		 MetadataServices.updateFileType($scope.fileType).then(function(response){
			 $scope.cancelModal();
			 $scope.fileName = "";
			 $scope.fetchFileTypeDetails();
			 $scope.message = "File Type Updated  Successfully ";
			 $scope.showSuccessAlert = true;
			 $scope.showErrorAlert = false;
			
		   }, function(errResponse){
			   $scope.cancelModal();
	               console.error('Error while updating file type');
	               $scope.message = "Error while updating file type "
	            	   $scope.showSuccessAlert = false;
	               $scope.showErrorAlert = true;
	            	   
	           }
	       );

	},
	$scope.editFlag = false;
	/*$scope.initEditFileType = function(){
		$scope.fileType = $rootScope.fileRecordDomain.fileType;
		$scope.recType = $rootScope.fileRecordDomain.recType;
		$scope.recLayoutList = $rootScope.fileRecordDomain.recLayoutList;
		$scope.selectedRecTypes = $scope.recType.recTypeId;
		$scope.selectedStatusType = $scope.fileType.status.toString();
		$scope.editFlag = true;
	}*/
	$scope.initEditFileType = function(){
		$scope.fileType = $rootScope.fileType;
		/*$scope.recType = $rootScope.fileRecordDomain.recType;
		$scope.recLayoutList = $rootScope.fileRecordDomain.recLayoutList;*/
		$scope.selectedStatusType = $scope.fileType.status;
		$scope.editFlag = true;
	}
	
	
	$scope.getFileRecTypes = function(){
		 MetadataServices.getRecTypes().then(function(response) {
			   $scope.fileRecTypes = response;
			   if(!$scope.editFlag)
			   $scope.selectedRecTypes = $scope.fileRecTypes[0].recTypeId; 
			     
			    }, function(errResponse) {
			     console.error('Error while deleting file type');
			    
			    });
	
	}
	$scope.getFileRecTypes();
	
	
	$scope.addingFileToClient = function(file){
		if($rootScope.globalSelectedClientId){
		file.clientId = $rootScope.globalSelectedClientId;
		MetadataServices.addFileToClient(file).then(function(res){
			if(res == 2){
				alert("File Already Exists");
			}
				
			$location.path("/clientFiles");
		});
		}else{
			alert("Client id is null");
			return false;
		}
	};
	
	$scope.editFileType = function(fileType){
		$rootScope.fileType = fileType;
		if($location.url().indexOf("/clientFiles")==0){
			$location.path("/editClientFile");
		}else{
			$location.path("/editFileType");	
		}
	   }
	
	$scope.deleteThisRow = function(fileRecordDomain){
		   if (confirm('Do you really want to delete the file type?')) {
		   MetadataServices.deleteFileDetailsById(fileRecordDomain.fileTypeKey,$rootScope.globalSelectedClientId,fileRecordDomain.fileRecTypeKey ).then(function(response) {
			   $scope.message = "File Type deleted successfully"
			   $scope.showSuccessAlert = true;
			   $scope.showErrorAlert = false;
			   $scope.fileName = "";
			   $scope.fetchClientFileDetails();
			     
			    }, function(errResponse) {
			     console.error('Error while deleting file type');
			     $scope.showErrorAlert = true;
			     $scope.showSuccessAlert = false;
			    });
		   }else{
			   console.log("not.......")
		   }
	   }
   
   $scope.cancelModal = function(){
	   modalInstance.close();
   }
   
   $scope.fetchClientDetailsByNumber();
 
// switch flag
   $scope.switchBool = function () {
	   $scope.showErrorAlert = false;
	     $scope.showSuccessAlert = false;
   }
   
//   getRecLayoutList(recType)
   var recList ="";
   $scope.getRecLayoutList = function(recType){
	 //  angular.forEach(recType, function(rec) {
		//   if(rec.recTypeChecked){
				 MetadataServices.fetchRecLayoutDetails( recType).then(function(response) {
				    $scope.recLayoutDetails = response;
				    $rootScope.$apply();
				   //  recList=response;
				    }, function(errResponse) {
				     console.error('Error while fetching recLayouts');
				    });
			//	 $scope.recLayoutDetails.push(recList); 
		 //  }
		 //});
	   
   };
   
   $scope.goToNextPage = function(){
	   var selectedClientId = $("input:radio[name ='selectedClient']:checked").val();
	   $rootScope.globalSelectedClientId = selectedClientId;
	   if(selectedClientId != '' && selectedClientId != undefined){
		   $location.path("/clientFiles");
	   }else{
		   alert("Please select at least one client");
	   }
   }
   $scope.exitAddFileProcees = function(){
	   if (confirm('Do you really want to exit the file type?')) {
	   $location.path("/");
	   }
   }
   
   $scope.recLayoutDetails = [];
   var recLayout = {
		   recTypeKey: "",fldSeq :"",dataFld:"",fldDesc:"", dataType:"",len:"",reqrOptnl:"",
		   inPatient:"",outPatient:"",sampleData:"",dfltDelim:"",startPos:"",endPos:"",hdfsDataType:""
   }
   
   $scope.recType= { recTypeId:"", recTypeDes:"", hiveTable:""}
   recLayout.dataType = $scope.dataTypeList[0].id;
   recLayout.hdfsDataType = "String";
   recLayout.dfltDelim ="|";
   $scope.recLayoutDetails.push(recLayout);
   var rowCount = 1; 
    $scope.addMoreRows = function(index) {
    	console.log("Adding row.......");
    	if($scope.recLayoutDetails[index].recordLayout[0]){
    	 var recLayout = {
    		fileRecTypeKey: $scope.recLayoutDetails[index].recordLayout[0].fileRecTypeKey,fldSeq :"",dataFld:"",fldDesc:"", dataType:"",len:"",reqrOptnl:"",
		   inPatient:"",outPatient:"",sampleData:"",dfltDelim:"",startPos:"",endPos:"",hdfsDataType:""
   }
    	}else{
    		 var recLayout = {
    		    		fileRecTypeKey: "",fldSeq :"",dataFld:"",fldDesc:"", dataType:"",len:"",reqrOptnl:"",
    				   inPatient:"",outPatient:"",sampleData:"",dfltDelim:"",startPos:"",endPos:"",hdfsDataType:""
    		   }
    	}
    recLayout.dataType = $scope.dataTypeList[0].id;
    	   recLayout.hdfsDataType = "String";
    	   recLayout.dfltDelim ="|";
    	$scope.recLayoutDetails[index].recordLayout.push(recLayout);
    	$rootScope.$apply();
   }
    
    
    $scope.addMoreRowsForNew = function(form) {
    	console.log("Adding row.......")
    	 var recLayout = {
    		fileRecTypeKey: "",fldSeq :"",dataFld:"",fldDesc:"", dataType:"",len:"",reqrOptnl:"",
		   inPatient:"",outPatient:"",sampleData:"",dfltDelim:"",startPos:"",endPos:"",hdfsDataType:""
   }
    	
    recLayout.dataType = $scope.dataTypeList[0].id;
    	   recLayout.hdfsDataType = "String";
    	   recLayout.dfltDelim ="|";
    	$scope.recLayoutDetails.push(recLayout);
    	$rootScope.$apply();
   }
    
    
    $scope.addMoreRowsForRec = function(frm){
    	
    	var recTypes1 ={ recTypeId:"", recTypeDes:"", hiveTable:""}
    	$scope.recType1.push(recTypes1) ;
    }
    
      $scope.removeInputItem = function(key,indexValue) {
    	  //$scope.recLayoutDetails[index].recordLayout.push(recLayout);
        $scope.recLayoutDetails[key].recordLayout.splice(indexValue, 1);
      };
      $scope.saveFileRecord = function(){
    	 // $scope.fileType.clientId =  $rootScope.globalSelectedClientId;
    	  $scope.recType.recTypeId = $scope.selectedRecTypes;
    	  $scope.fileType.status=$scope.selectedStatusType.value;
    	  //$scope.recLayoutList.dataType=$scope.selectedDataType.value;
    	  var fileRecordDomain = {"recLayoutList" : $scope.recLayoutDetails,"fileType":$scope.fileType,"recType": $scope.recType}
    	 console.log(fileRecordDomain);
 		 MetadataServices.addFileType(fileRecordDomain).then(function(response){
 			
 			 $scope.message = "File Record Added Successfully ";
 			 $scope.showSuccessAlert = true;
 			 $scope.showErrorAlert = false;
 			 $location.path("/fileType");
 		   }, function(errResponse){
 			      $scope.cancelModal();
 			      $scope.showSuccessAlert = false;
 			      $scope.showErrorAlert = true;
 	               $scope.message = "Error while creating file record ";
 	           }
 	       );
      }
      
      $scope.updateFileRecord = function(){
    	 // $scope.fileType.clientId = $rootScope.globalSelectedClientId;
    	  $scope.recType.recTypeId = $scope.selectedRecTypes;
    	  $scope.flagUpdate =true;
    	  $scope.fileType.status = $scope.selectedStatusType;
    	  angular.forEach($scope.recLayoutDetails,function(val){
    		 angular.forEach(val.recordLayout,function(val1){
    			 if(!val1.dataFld){
    				 alert("Please fill the DataField");
    				 $scope.flagUpdate = false;
    				 return false;
    			 }
    		 }) 
    	  });
    	  if($scope.flagUpdate){
    	 // $scope.recLayoutList.dataType=$scope.selectedDataType.value;
    	  var fileRecordDomain = {"recLayoutList" : $scope.recLayoutDetails,"fileType":$scope.fileType,"recType": $scope.recType1}
    	 
 		 MetadataServices.updateFileType(fileRecordDomain).then(function(response){
 			
 			 $scope.message = "File Record updated Successfully ";
 			 $scope.showSuccessAlert = true;
 			 $scope.showErrorAlert = false;
 			 if( $scope.fileType.clientId == ""){
 			     $location.path("/fileType");
 			 }else{
 				$location.path("/clientFiles");
 			 }
 		   }, function(errResponse){
 			      $scope.cancelModal();
 			      $scope.showSuccessAlert = false;
 			      $scope.showErrorAlert = true;
 	               $scope.message = "Error while updating file record "
 	           }
 	       );
    	  }
      
      }
      
      $scope.updateFileRecordFromClient = function(fileType){
    	  $scope.fileType.clientId = $rootScope.globalSelectedClientId;
    	  MetadataServices.updateFileClientType(fileType).then(function(response){
    		  $scope.message = "File Record updated Successfully ";
  			 $scope.showSuccessAlert = true;
  			 $scope.showErrorAlert = false;
  			     $location.path("/clientFiles"); 
    	  }, function(errResponse){
 			      $scope.cancelModal();
 			      $scope.showSuccessAlert = false;
 			      $scope.showErrorAlert = true;
 	               $scope.message = "Error while updating file record "
 	           });
      }
      
      $scope.goToNextTab = function(value){
    	  alert(value);
    	  $location.path("/client");
      }
      /*function initFun(){
    	  if($location.url().indexOf("/client")==-1 && $location.url().indexOf("/clientFiles")==-1 && $location.url().indexOf("/fileType")==-1 && $location.url().indexOf("/addFileType")==-1
    			  && $location.url().indexOf("/editFileType")==-1)
    	  $rootScope.globalSelectedClientId ="";
      }*/
      
      //initFun();
      
      function initAppName(){
    	  $rootScope.appName ="MetaData UI";
      }
      initAppName();
      
      $scope.loadAppName = function(){
    	  $rootScope.appName ="Client";
      }
      $scope.loadAppNameFromEdit = function(){
    	  $rootScope.appName = "File";
      }
      
      $scope.initHeaderName = function(){
    	  $rootScope.appName = "Client";
      }
     
   
  } ]);
