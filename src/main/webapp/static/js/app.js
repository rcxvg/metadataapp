'use strict';

var metadaApp = angular.module('metadaApp', [ 'ngRoute', 'ui.bootstrap',
		'angularUtils.directives.dirPagination', 'angularjs-dropdown-multiselect']);

metadaApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'static/pages/MetadataApp.jsp',
		controller : 'MetadataController'
	}).when('/client', {
		templateUrl : 'static/pages/MetaDataDetails.jsp',
		controller : 'MetadataController'
	}).when('/clientFiles', {
		templateUrl : 'static/pages/ClientFileDetails.jsp',
		controller : 'MetadataController'
	}).when('/editClientFile', {
		templateUrl : 'static/pages/editClientFile.html',
		controller : 'MetadataController'
	}).when('/fileType', {
		templateUrl : 'static/pages/FileTypeDetails.jsp',
		controller : 'MetadataController'
	}).when('/addFileType', {
		templateUrl : 'static/pages/addFileType.html',
		controller : 'MetadataController'
	}).when('/editFileType', {
		templateUrl : 'static/pages/editFileType.html',
		controller : 'MetadataController'
	}).when('/job', {
		templateUrl : 'static/pages/JobDetails.jsp',
		controller : 'JobController'
	}).when('/table', {
		templateUrl : 'static/pages/TableName.jsp',
		controller : 'JobController'
	}).when('/colGrid', {
		templateUrl : 'static/pages/ColumnGrid.html',
		controller : 'JobController'
	}).when('/validations', {
		templateUrl : 'static/pages/Validations.jsp',
		controller : 'JobController'
	});

} ]);


metadaApp.directive('loading', ['$http', function ($http) {
  return {
    restrict: 'A',
    link: function (scope, element, attrs) {
      scope.isLoading = function () {
        return $http.pendingRequests.length > 0;
      };
      scope.$watch(scope.isLoading, function (value) {
        if (value) {
          element.removeClass('ng-hide');
        } else {
          element.addClass('ng-hide');
        }
      });
    }
  };
}]);
