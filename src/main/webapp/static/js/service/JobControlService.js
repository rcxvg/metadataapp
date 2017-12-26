'use strict';

metadaApp.factory('JobControlService', [ '$http', '$q', function($http, $q) {

	var REST_SERVICE_URI = '/MetaDataApp/jobDetails/';

	var factory = {
		fetchJobDetailsById : fetchJobDetailsById,
		deleteJobDetailsById: deleteJobDetailsById,
		addJob:addJob,
		fetchTablenames:fetchTablenames,
		fetchGridDetails:fetchGridDetails,
		saveJobDetails:saveJobDetails,
		submitJobTemplateDetails:submitJobTemplateDetails,
		getDropDownValues:getDropDownValues,
		getXFormTypes:getXFormTypes,
		submitValidation:submitValidation
	};

	return factory;
	
	function submitValidation(data){
		var deferred = $q.defer();
		//data.jobId = jobId;
		$http.post(REST_SERVICE_URI + "submitColValidations/", data)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while get the values');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
	}
	
	function getDropDownValues(jobId) {
		var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "dropDowns/"+jobId)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while get the values');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;

	}
	
	function getXFormTypes() {
		var deferred = $q.defer();
        $http.get(REST_SERVICE_URI + "xformTypes")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while get the xform values');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;

	}

	 function submitJobTemplateDetails(jobTemplateDetails) {
	        var deferred = $q.defer();
	        $http.post(REST_SERVICE_URI + "submitJobTemplateDetails/", jobTemplateDetails)
	            .then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                console.error('Error while save the job template');
	                deferred.reject(errResponse);
	            }
	        );
	        return deferred.promise;
	    }
	
	
	 function saveJobDetails(jobDetails) {
	        var deferred = $q.defer();
	        $http.post(REST_SERVICE_URI +"saveDetaials/", jobDetails)
	            .then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                console.error('Error while creating client');
	                deferred.reject(errResponse);
	            }
	        );
	        return deferred.promise;
	    }
	
	function fetchGridDetails(jobId){
		
		var deferred = $q.defer();
		$http.get("/MetaDataApp/colDefs/" + jobId).then(function(response) {
			deferred.resolve(response.data);
		}, function(errResponse) {
			console.error('Error while fetching job details');
			deferred.reject(errResponse);
		});
		return deferred.promise;
		
	}
	
	function fetchTablenames(type) {
		var deferred = $q.defer();
		$http.get("/MetaDataApp/tableName/" + type).then(function(response) {
			deferred.resolve(response.data);
		}, function(errResponse) {
			console.error('Error while fetching job details');
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}
	
	function fetchJobDetailsById(jobId) {
		var deferred = $q.defer();
		$http.get(REST_SERVICE_URI + jobId).then(function(response) {
			deferred.resolve(response.data);
		}, function(errResponse) {
			console.error('Error while fetching job details');
			deferred.reject(errResponse);
		});
		return deferred.promise;
	}
	
	function deleteJobDetailsById(jobId) {
		var deferred = $q.defer();
		$http
				.get(REST_SERVICE_URI + "delete/"+jobId)
				.then(
						function(response) {
							deferred
									.resolve(response.data);
						},
						function(errResponse) {
							console
									.error('Error while deleting job');
							deferred
									.reject(errResponse);
						});
		return deferred.promise;
	}
	 function addJob(job) {
	        var deferred = $q.defer();
	        $http.post(REST_SERVICE_URI, job)
	            .then(
	            function (response) {
	                deferred.resolve(response.data);
	            },
	            function(errResponse){
	                console.error('Error while creating client');
	                deferred.reject(errResponse);
	            }
	        );
	        return deferred.promise;
	    }

} ]);
