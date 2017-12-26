'use strict';

metadaApp.controller('clientController', [ '$scope', 'MetadataServices', 'JobControlService',
		function($scope, MetadataServices, JobControlService) {
			var self = this;
			
			$scope.cancelModal();

		} ]);