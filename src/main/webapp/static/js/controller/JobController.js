'use strict';

metadaApp.controller('JobController', [ '$compile','$rootScope','$scope','$location','$uibModal', 'JobControlService',
	  function($compile,$rootScope,$scope, $location,$modal, JobControlService) {
   var self = this;
   var modalInstance = null;
   $scope.type='';
   $scope.jobId=0;
   $scope.selectedActiveFlag=0;
   $scope.targetTableNameLst = [];
   $scope.sourceTableNameLst  = [];
   $scope.columnDefs  = [];
   $scope.columnValidations =[];
   
   //$scope.col.columnOrder=0;
   /*$scope.colDetails=[];
   $scope.refValidations=[];*/
   
   $scope.job={jobId:"",jobDesc:"", jobDetail:"", activeFlag:""}
   
   $scope.activeFlagList = [{id:0,value:0},{id:1,value:1 }];
   $scope.selectedActiveFlag= $scope.activeFlagList[0].id;
   
   $scope.addJob = function(){
  	 $scope.job={jobId:"",jobDesc:"", jobDetail:"", activeFlag:""} 
	   modalInstance = $modal.open({
		   animation: false,
		   templateUrl: 'static/pages/addJob.html',
		   controller: 'clientController',
		   scope: $scope,
		   size: '',
		   resolve: {
		   }
		   });

   }
   $scope.targetColumnNames = [];
   
   $scope.example1model = []; 
   $scope.testData = [{"id":"1","value":null,"label":null},{"id":"2"},{"id":"4"},{"id":"7"},{"id":"5"}];
   
  
  //$scope.colOrderId = 1;
   $scope.changeColOrder = function(list){
	   $scope.col = {};
	   angular.forEach($scope.colDetails,function(val){
		  if(angular.equals(val.colName,list)){
			 $scope.columnOrder = val.colOrder;
		  } 
	   });
	   
   }
   
   $scope.getXFormTypes = function(){
	   JobControlService.getXFormTypes().then(function(response) {
		   $scope.xFormTypeLst = response;
	   });
   }
   
   
   //getDropDownValues();
   $scope.getDropDownValues = function(){
	   
	   JobControlService.getDropDownValues($rootScope.jobId).then(function(response) {
	
		   $scope.colVal = response;
		   console.log("List Size is:"+$scope.colVal[0].colDetails.length);
		   $scope.colDetails = $scope.colVal[0].colDetails;
		   $scope.refValidations= $scope.colVal[0].refValidations;
		   $scope.refData= $scope.colVal[0].refData;
		  
		  // $scope.activeFlagLst = activeFlagLst;
		   
	   });
	   
   }
 
   /*function getDropDownValues() {
	//   $scope.col={};
	   $rootScope.jobId = $scope.jobId;
	   JobControlService.getDropDownValues($scope.jobId).then(function(response) {
		   $scope.colValidators = response;
		  // console.log("List Size is:"+$scope.colValidators.colDetails.length);
		   $rootScope.colVal = response;
		   $scope.colDetails = $scope.colValidators.colDetails;
		   $scope.refValidations= $scope.colValidators.refValidations;
		   $scope.refData= $scope.colValidators.refData;
		   $rootScope.columDetails = $scope.colDetails;
		   $rootScope.refValidationTypes = $scope.refValidations;
		   $rootScope.refDataLst = $scope.refData;
		  
		   //$scope.col.activeFlagLst = 1;
		   $scope.activeFlagLst = activeFlagLst;
		   $rootScope.selectedValidation = $rootScope.colVal[0].refValidations[0].validationType;
		   $rootScope.selectedDataCorrection= $rootScope.colVal[0].refData[0].dataCrtnDesc;
		   $rootScope.selectedColName = $rootScope.colVal[0].colDetails[0].colName;
		   $rootScope.selectedActiveFlag = activeFlagLst[0].id;
		   $scope.colNames = $rootScope.colVal[0].colDetails[0];
		   $rootScope.col.columnOrder=1;
		   $rootScope.$apply();
	   });
   }*/
   
   $scope.addValidationRow = function(){
	   //validationOrder = $scope.columnValidation.length;
	   var colDetails = $scope.colDetails;
	   var refData = $scope.refData;
	   var refValidations = $scope.refValidations;
	   var obj={
			   colDetails,refData,refValidations
	   }
	   $scope.colVal.push(obj);
   }
   
   $scope.deleteValidationRow = function(index){
	  
	   $scope.colVal.splice(index,1);
   }
   
   
   
   
   $scope.submitValidationDetails = function(){
	   var list =[];
	   var reqSrcName = true;
	   angular.forEach($scope.colVal,function(val){
		   var columnOrder = 0;
		   if(!val.sourceColumnName || !val.validationType){
			   alert("Please select the Mandatory fields");
		   }else{
		   angular.forEach($scope.colDetails,function(val1){
			   if(val.sourceColumnName == val1.colName){
				   columnOrder = val1.colOrder;
			   }
		   });
		   var obj ={"columnOrder":columnOrder,
				   	"sourceColumnName":val.sourceColumnName,
				   	"validationOrder":val.validationOrder,
				   	"validationType":val.validationType,
				   	"warningThreshold":val.warningThreshold,
				   	"failureThreshold":val.failureThreshold,
				   	"activeFlag":val.activeFlag,
				   	"dataCorrection":val.dataCorrection,
				   	"defaultVal":val.defaultVal,
				   	"jobValidationDescription":val.jobValidationDescription,
				   	"validationCondition":val.validationCondition,
				   	"jobId":$rootScope.jobId
		   };
		   list.push(obj);
		   }
		   });
	   JobControlService.submitValidation(list).then(function(response) {
		   $location.path("/job");
	   }, function(errResponse){
		     console.log("Error while submit the validation details");
         });
	   
   }
   
   
   $scope.submitJobTemplateDetails = function(){
	   var reqSrcName = true;

	   angular.forEach($scope.columnDefs,function(val){
		  if(val.sourceColumnName.length==0 || !val.sourceColumnName){
			  reqSrcName = false;
		  } 
	   });
	   
	   if(reqSrcName){
	   
	   JobControlService.submitJobTemplateDetails($scope.columnDefs).then(function(response) {
		   $rootScope.jobId = $scope.columnDefs[0].jobId;
		   $location.path("/validations");
		   
		    
		   }, function(errResponse){
			     console.log("Error while fetching the grid details");
	           }
	       );

	   }else{
		   alert("Please fill the Mandatory Fileds");
		   return false;
	   }
   }
   $scope.isPassthrough = function(value){
	   return (value == 'pass through') ? true : false;
   }
 
   $scope.getColumnDefs = function(){
	    console.log("print grid")
	  	 JobControlService.fetchGridDetails($rootScope.globalSelectedJobId).then(function(response) {
	  		  
	  			  $scope.columnDefs = response
	  			for(var i=0;i<$scope.columnDefs.length;i++){
	  				
	  				if($scope.columnDefs[i].targetColumnName !== ''){
	  					//$scope.selectedValidationType = [$scope.columnDefs[i].validationType];
	  					//$scope.selectedXFormTypes = $scope.columnDefs[i].xFormTypeDesc;
	  					$scope.targetColumnNames.push({'targetColumnName':$scope.columnDefs[i].targetColumnName});
	  					//$scope.selectedXFormTypes.push({'xFormTypeDesc':$scope.columnDefs[i].xFormTypeDesc});
	  					//$scope.columnDefs[i].push($scope.selectedValidationType);
	  				}
	  			}
			    
			   }, function(errResponse){
				     cosole.log("Error while fetching the grid details");
		           }
		       );
		   
	   } 
   
   $scope.getSourceTableNames = function(type){
	   
	  	 JobControlService.fetchTablenames(type).then(function(response) {
	  			  $scope.sourceTableNameLst = response
	  			 $scope.selectedSourceTable =  $scope.sourceTableNameLst[0].tableName
	 
			   }, function(errResponse){
				     
		           }
		       );
		   
	   } 
   
   $scope.getTargetTableNames = function(type){
	  
	  	 JobControlService.fetchTablenames(type).then(function(response) {
	  		 
	  			  $scope.targetTableNameLst = response
	  			 $scope.selectedTargetTable =  $scope.targetTableNameLst[0].tableName
			    
			   }, function(errResponse){
				     
		           }
		       );
		   
	   }
   
   // Adding New Row
   $scope.addNewRow = function(){
	   var colOrder = $scope.columnDefs.length;
	   var jobId = 0;
	   if(colOrder > 0){
		   jobId = $scope.columnDefs[0].jobId;
	   }
	   var activeFlagLst = [{
		   id:0
	   },{
		   id:1
	   }];
	   var obj = {
			   columnOrder : colOrder,
			   sourceColumnName : "",
			   columnTypeDesc : "",
			   xFormTypeDesc:"",
			   columnExpression:"",
			   columnFormat:"",
			   targetColumnNames:"",
			   activeFlagLst:activeFlagLst,
			   minLength:"",
			   maxLength:"",
			   minValue:"",
			   maxValue:"",
			   columnIdentifier:"",
			   newOne : true,
			   jobId : jobId
			   
	   }
	   $scope.columnDefs.push(obj);
	   
	   $rootScope.$apply();
   }
   $scope.getSourceTableNames("source");
   $scope.getTargetTableNames("target");
  
   
   $scope.saveJob = function(){
  	 console.log($scope.job);
  	 JobControlService.addJob($scope.job).then(function(response) {
		     $scope.cancelModal();
			 $scope.jobId = $scope.job.jobId;
			 $scope.fetchJobDetailsById();
			 $scope.message = "Job Added Successfully ";
			 $scope.showSuccessAlert = true;
			 $scope.showErrorAlert = false;
		   }, function(errResponse){
			      $scope.cancelModal();
			      $scope.showSuccessAlert = false;
			      $scope.showErrorAlert = true;
	               console.error('Error while creating Job');
	               $scope.message = "Error while creating job "
	           }
	       );
	   
   } 
	  $scope.fetchJobDetailsById = function() {
		    
		  JobControlService.fetchJobDetailsById($scope.jobId).then(function(response) {
		     $scope.jobDetails = response;
		     $scope.pagination();
		    }, function(errResponse) {
		     console.error('Error while fetching job details');
		    });
		   }
	  $scope.deleteJobRow = function(job){
		   if (confirm('Do you really want to delete the Job?')) {
			   JobControlService.deleteJobDetailsById(job.jobId).then(function(response) {
			   $scope.message = "Job deleted successfully"
				 
			   $scope.showSuccessAlert = true;
			   $scope.showErrorAlert = false;
			   $scope.jobId = "";
			   $scope.fetchJobDetailsById();
			     
			    }, function(errResponse) {
			     console.error('Error while deleting Job');
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
	  
	  $scope.switchBool = function () {
		   $scope.showErrorAlert = false;
		     $scope.showSuccessAlert = false;
	   }
	   $scope.fetchJobDetailsById();
	   
	   $scope.pagination = function(){
			 $scope.$watch('currentPage + numPerPage', function() {
				    var begin = (($scope.currentPage - 1) * $scope.numPerPage)
				    , end = begin + $scope.numPerPage;
				    
				    $scope.filteredJobDetails = $scope.jobDetails.slice(begin, end);
				  });
			   
		}
	   
	   $scope.goToNextPage = function(){
		   var selectedJobId = $("input:radio[name ='selectedJob']:checked").val();
		   $rootScope.globalSelectedJobId = selectedJobId;
		   if(selectedJobId != '' && selectedJobId != undefined){
			   $location.path("/table");
		   }else{
			   alert("Please select at least one job");
		   }
	   }
		
		$scope.numPages = function () {
		    return Math.ceil($scope.jobDetails.length / $scope.numPerPage);
		  };
  
		  $scope.submitJobDetails = function(){
			  var jobDetails = {"jobId":$rootScope.globalSelectedJobId,"sourceTableName":$scope.selectedSourceTable,"targetTableName":$scope.selectedTargetTable};
			  JobControlService.saveJobDetails(jobDetails).then(function(response) {		  		  
				  $location.path("/colGrid");
			   }, function(errResponse){
				     
		           }
		       );		  }
		 /* $scope.getColumnDefs = function(){
			console.log("print values");
		  }*/
    function initAppNameFromJob(){
    	$rootScope.appName ="Job";
    }
    initAppNameFromJob();
    
    $scope.loadAppNameValidation = function(){
  	  $rootScope.appName = "Job Validation";
    }
		  
 
  } ]);