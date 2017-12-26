'use strict';

metadaApp
		.factory(
				'MetadataServices',
				[
						'$http',
						'$q',
						function($http, $q) {

							var REST_SERVICE_URI = '/MetaDataApp/clientDetails/';

							var factory = {
								fetchClientDetailsByNumber : fetchClientDetailsByNumber,
								addClient : addClient,
								updateClient : updateClient,
								deleteClientDetailsById : deleteClientDetailsById,
								fetchClientFileDetails : fetchClientFileDetails,
								fetchRecTypeDetails : fetchRecTypeDetails,
								fetchRecLayoutDetails : fetchRecLayoutDetails,
								addFileType : addFileType,
								updateFileType : updateFileType,
								deleteFileDetailsById : deleteFileDetailsById,
								getRecTypes: getRecTypes,
								searchFilesById : searchFilesById,
								fetchFileTypeDetails : fetchFileTypeDetails,
								searchFiles : searchFiles,
								addFileToClient : addFileToClient,
								updateFileClientType : updateFileClientType
								
							};

							return factory;
							
							function fetchClientDetailsByNumber(clientNubmer) {
								var deferred = $q.defer();
								$http
										.get(REST_SERVICE_URI + clientNubmer)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while fetching client');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							
							 function addClient(client) {
							        var deferred = $q.defer();
							        $http.post(REST_SERVICE_URI, client)
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
							 
							 function updateClient(client, clientNumber) {
							        var deferred = $q.defer();
							        $http.post(REST_SERVICE_URI+"update", client)
							            .then(
							            function (response) {
							                deferred.resolve(response.data);
							            },
							            function(errResponse){
							                console.error('Error while updating client');
							                deferred.reject(errResponse);
							            }
							        );
							        return deferred.promise;
							    }
							
							
							
							function deleteClientDetailsById(clientNubmer) {
								var deferred = $q.defer();
								$http
										.get(REST_SERVICE_URI + "delete/"+clientNubmer)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while deleting client');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function fetchClientFileDetails(clientId) {
								var deferred = $q.defer();
								$http
										.get("/MetaDataApp/clientFileDetails/" +clientId)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while fetching ClientFiles');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function fetchRecTypeDetails(fileTypeKey) {
								var deferred = $q.defer();
								$http
										.get("/MetaDataApp/recTypeDetails/" +fileTypeKey)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while fetching recType details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							
							function fetchRecLayoutDetails(recType) {
								var deferred = $q.defer();
								$http
										.post("/MetaDataApp/recLayoutDetails" , recType)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while fetching recLayout details');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}
							
							
							
							function addFileType(fileRecordDomain) {
						        var deferred = $q.defer();
						        $http.post("/MetaDataApp/fileTypeDetails/", fileRecordDomain)
						            .then(
						            function (response) {
						                deferred.resolve(response.data);
						            },
						            function(errResponse){
						                console.error('Error while creating fileType');
						                deferred.reject(errResponse);
						            }
						        );
						        return deferred.promise;
						    }
						 
						 function updateFileType(fileRecordDomain) {
						        var deferred = $q.defer();
						        $http.post("/MetaDataApp/fileTypeDetails/update", fileRecordDomain)
						            .then(
						            function (response) {
						                deferred.resolve(response.data);
						            },
						            function(errResponse){
						                console.error('Error while updating fileType');
						                deferred.reject(errResponse);
						            }
						        );
						        return deferred.promise;
						    }
						
						
						
						function deleteFileDetailsById(fileTypeId,clientId) {
							var deferred = $q.defer();
							$http
									.get("/MetaDataApp/fileTypeDetails/delete/"+fileTypeId+"/"+clientId)
									.then(
											function(response) {
												deferred
														.resolve(response.data);
											},
											function(errResponse) {
												console
														.error('Error while deleting fileType');
												deferred
														.reject(errResponse);
											});
							return deferred.promise;
						}
						
						function getRecTypes() {
							var deferred = $q.defer();
							$http
									.get("/MetaDataApp/fileRecTypes")
									.then(
											function(response) {
												deferred
														.resolve(response.data);
											},
											function(errResponse) {
												console
														.error('Error while fetching RecTypes');
												deferred
														.reject(errResponse);
											});
							return deferred.promise;
						}
						
						function searchFilesById(clientId, fileName) {
							var deferred = $q.defer();
							$http
									.get("/MetaDataApp/searchFilesById/" +clientId+"/" +fileName)
									.then(
											function(response) {
												deferred
														.resolve(response.data);
											},
											function(errResponse) {
												console
														.error('Error while searching ClientFiles');
												deferred
														.reject(errResponse);
											});
							return deferred.promise;
						}
						
						function fetchFileTypeDetails() {
							var deferred = $q.defer();
							$http
									.get("/MetaDataApp/fileTypeDetails")
									.then(
											function(response) {
												deferred
														.resolve(response.data);
											},
											function(errResponse) {
												console
														.error('Error while fetching fileTypes');
												deferred
														.reject(errResponse);
											});
							return deferred.promise;
						}
						
						function searchFiles(fileName) {
							var deferred = $q.defer();
							$http
									.get("/MetaDataApp/searchFiles/" +fileName)
									.then(
											function(response) {
												deferred
														.resolve(response.data);
											},
											function(errResponse) {
												console
														.error('Error while searching fileTypes');
												deferred
														.reject(errResponse);
											});
							return deferred.promise;
						}
						
						function addFileToClient(file){
							var deferred = $q.defer();
							$http
									.post("/MetaDataApp/filesByClientId/",file)
									.then(
											function(response) {
												deferred
														.resolve(response.data);
											},
											function(errResponse) {
												console
														.error('Error while searching fileTypes');
												deferred
														.reject(errResponse);
											});
							return deferred.promise;
						}
						
						function updateFileClientType(clientFile){
						    var deferred = $q.defer();
					        $http.post("/MetaDataApp/clientFileDetails/update", clientFile)
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
