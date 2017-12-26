<div ng-controller="JobController">
<div  class="scrollStyle">
		<div class="alert alert-success" ng-show="showSuccessAlert">
			<button type="button" class="close" data-ng-click="switchBool()">×</button>
			<strong>Done!</strong> {{message}}</div>
		<div class="alert alert-danger" ng-show="showErrorAlert">
			<button type="button" class="close" data-ng-click="switchBool()">×</button>
			<strong>Error!</strong> {{message}}</div>
		<div class="input-group"
			style="padding-left: 20px; padding-right: 10px; padding-top: 5%; padding-bottom: 10px;">
			<input class="form-control" ng-model="jobId" placeholder="Search by Job Id"
				ng-change="fetchJobDetailsById()" type="search" />
			<span class="input-group-addon"> 
			<span class="glyphicon glyphicon-search" ng-click="fetchJobDetailsById()"></span>
			</span>
		</div>
		
		<div class="row">
	    	<div class="col-xs-4"></div>
			<div class="col-xs-4"></div>
			<div class="col-xs-4">
				<input class="btn btn-link pull-right button" type="button"
					style="font: bold; font-size: 20px; padding-bottom: 20px;"
					value="Add New Job" ng-click="addJob()" />
			</div>
		</div>

		<div class="row">
		<div class="col-xs-2">
		          &nbsp;
		</div>
		</div>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th></th>
					<th class="jobId">Job Id</th>
					<th>Job Description</th>
					<th>Active Flag</th>
					<th>Job Detail</th>
					<th>Actions</th>

				</tr>
			</thead>
			<tbody>
				<tr dir-paginate="job in jobDetails | filter:q | itemsPerPage: pageSize"
					current-page="currentPage">
					<td><input type="radio" ng-click="goToNextPage()" name="selectedJob"  value="{{job.jobId}}"/></td>
					<td>{{job.jobId}}</td>
					<td>{{job.jobDesc}}</td>
                    <td>{{job.activeFlag}}</td>
					<td>{{job.jobDetail}}</td>
					
					<td><div class="grid-action-cell">
							<!-- <a ng-click="$event.stopPropagation(); editJob(job);"
								href="#">Edit</a>&nbsp;&nbsp;&nbsp; --> <a
								ng-click="$event.stopPropagation(); deleteJobRow(job)"
								href="#">Delete</a>
						</div></td>
				</tr>
			</tbody>
		</table>
		<dir-pagination-controls boundary-links="true"
			on-page-change="pageChangeHandler(newPageNumber)"
			template-url="static/pages/dirPagination.tpl.html"></dir-pagination-controls>
  	</div>
</div>