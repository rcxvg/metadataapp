<div>
	<div ng-controller="MetadataController" ng-init="loadAppName()">
		<div class="loader" data-loading>loading....................</div>
		<div class="alert alert-success" ng-show="showSuccessAlert">
			<button type="button" class="close" data-ng-click="switchBool()">×</button>
			<strong>Done!</strong> {{message}}</div>
		<div class="alert alert-danger" ng-show="showErrorAlert">
			<button type="button" class="close" data-ng-click="switchBool()">×</button>
			<strong>Error!</strong> {{message}}</div>
		<div class="input-group"
			style="padding-left: 20px; padding-right: 10px; padding-top: 5%; padding-bottom: 10px;">
			<input class="form-control" ng-model="clientNumber" placeholder="Search by Client Number"
				ng-change="fetchClientDetailsByNumber()" type="search" />
			<span class="input-group-addon"> 
			<span class="glyphicon glyphicon-search" ng-click="fetchClientDetailsByNumber()"></span>
			</span>
		</div>
		
		<div class="row">
	    	<div class="col-xs-4"></div>
			<div class="col-xs-4"></div>
			<div class="col-xs-4">
				<input class="btn btn-link pull-right button" type="button"
					style="font: bold; font-size: 20px; padding-bottom: 20px;"
					value="Add New Client" ng-click="addClient()" />
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
					<th class="clientId">Client Id</th>
					<th class="number">Client Number</th>
					<th class="name">Client Name</th>
					<th class="desc">Client Desc</th>
					<th class="activeFlag">Active Flag</th>
					<th class="Actions">Actions</th>

				</tr>
			</thead>
			<tbody>
				<tr dir-paginate="client in clientDetails | filter:q | itemsPerPage: pageSize"
					current-page="currentPage">
					<td><input type="radio" ng-click="goToNextPage()" name="selectedClient"  value="{{client.clientId}}"/></td>
					<td>{{client.clientId}}</td>
					<td>{{client.clientNumber}}</td>
					<td>{{client.clientName}}</td>
					<td>{{client.clientDesc}}</td>
					<td>{{client.activeFlag}}</td>
					<td><div class="grid-action-cell">
							<a ng-click="$event.stopPropagation(); editClient(client);"
								href="#">Edit</a>&nbsp;&nbsp;&nbsp; <a
								ng-click="$event.stopPropagation(); deleteClientRow(client)"
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
</div>