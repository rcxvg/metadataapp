<div ng-init="fetchClientFileDetails()">
	<div>
		<div class="alert alert-success" ng-show="showSuccessAlert">
			<button type="button" class="close" data-ng-click="switchBool()">�</button>
			<strong>Done!</strong> {{message}}
		</div>
		<div class="alert alert-danger" ng-show="showErrorAlert">
			<button type="button" class="close" data-ng-click="switchBool()">�</button>
			<strong>Error!</strong> {{message}}
		</div>
		
		<div class="input-group"
			style="padding-left: 20px; padding-right: 10px; padding-top: 5%; padding-bottom: 10px;">
			<input class="form-control" ng-model="fileName"
				placeholder="Search by File Name"
				ng-change="searchFilesById(fileName)" type="search" /> <span
				class="input-group-addon"> <span
				class="glyphicon glyphicon-search"
				ng-click="searchFilesById(fileName)"></span>
			</span>
		</div>
		
		<div class="row">
			<div class="col-xs-4"></div>
			<div class="col-xs-4"></div>
			<div class="col-xs-4">
				<!-- <input class="btn btn-link pull-right button" type="button"
						style="font: bold; font-size: 20px; padding-bottom: 20px;"
						value="Add More Files" ng-click="addFileType()" /> -->
				 <a href="#/fileType" class="btn btn-link pull-right"
						style="font: bold; font-size: 20px; padding-bottom: 20px;">Add More Files</a>
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
					<th class="Actions">Actions</th>
					<!-- <th class="filrTypeId">Id</th> -->
					<th class="fileTypeVer">File Version</th>
					<th class="srcSys">Source System</th> 
					<th class="clientId">Client Id</th>
					<th class="fileNamingConvention">File Name</th>
					<th class="fileSrc">File Src</th>
					<th class="fileDesc">file Desc</th>
					<th class="defDelim">Def Delim</th>
					<th class="fileFreq">Frequency</th>
					<th class="effStrtDt">Start Date</th>
					<th class="effEndDt">End Date</th>
					<th class="sts">Status</th> 

				</tr>
			</thead>
			<tbody >
				<tr
					dir-paginate="file in clientFileDetails | filter:q | itemsPerPage: pageSize"
					current-page="currentPage">
                   <td><div class="grid-action-cell">
							<a ng-click="$event.stopPropagation(); editFileType(file);"
								>Edit</a>&nbsp;&nbsp;&nbsp; <a
								ng-click="$event.stopPropagation(); deleteThisRow(file)"
								>Delete</a>
					</div></td>
					<!-- <td>{{file.fileTypeId}}</td>  -->
					<td>{{file.fileTypeVer}}</td>
					<td>{{file.srcSystem}}</td>
					<td>{{file.clientId}}</td>
					<td>{{file.fileNamingConvention}}</td>
					<td>{{file.fileSrc}}</td>
					<td>{{file.fileDesc}}</td>
					<td>{{file.defDelim}}</td>
					<td>{{file.fileFreq}}</td>
					<td>{{file.effStartDt}}</td>
					<td>{{file.effEndDt}}</td>
					<td>{{file.status}}</td> 		
				</tr>
			</tbody>
		</table>
		<dir-pagination-controls boundary-links="true"
			on-page-change="pageChangeHandler(newPageNumber)"
			template-url="static/pages/dirPagination.tpl.html"></dir-pagination-controls>
			
		</div>
	</div>
</div>