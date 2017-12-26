<div ng-controller="JobController" ng-init="getDropDownValues()" class="scrollStyle">

<table class="table table-striped table-bordered">
			<thead>
				<tr>
				    <th></th>
				    <!-- <th>Column Order</th> -->
					<th>Column Name</th>
					<th>Validation Order</th>
					<th>Validation Type</th>
					<th>Warning_Threshold</th>
					<th>Failure_Threshold</th>
					<th>Validation_Active_Flag</th>
					<th>Data_Correction</th>
					<th>Default_Val</th>
					<th>Job_Validation_Description</th>
					<th>Validation_Condition</th>
				</tr>
			</thead>
			<tbody>
			<tr ng-repeat="col in colVal">
			        <td><input type="button" ng-if="$index >0" ng-click="deleteValidationRow($index)" value="Delete"> </td>
					<!-- <td>{{columnOrder}}</td> -->
					<td><select 
							style="font-size: 16px; font-weight: bold; border: 3px solid #ddd; font-family: 'Roboto', sans-serif; padding: 10px 10px; font-weight: 300; width: 200px; line-height: 50px; color: #888;"
									ng-model="col.sourceColumnName" 
									ng-options="list.colName as list.colName for list in colDetails" ng-change="changeColOrder(col.sourceColumnName)">
				               <option value="">-None-</option>
									 
						    </select></td>
					<td>{{$index+1}}</td>
					<td><select 
							style="font-size: 16px; font-weight: bold; border: 3px solid #ddd; font-family: 'Roboto', sans-serif; padding: 10px 10px; font-weight: 300; width: 200px; line-height: 50px; color: #888;"
									ng-model="col.validationType"
									ng-options="list.validationType as list.validationType for list in refValidations">
									<option value="">-None-</option>
						    </select></td>
					<td><input type="text" ng-model="col.warningThreshold" class="form-control"></td>
					<td><input type="text" ng-model="col.failureThreshold" class="form-control"></td>
					<td><select 
									style="font-size: 16px; font-weight: bold; border: 3px solid #ddd; font-family: 'Roboto', sans-serif; padding: 10px 10px; font-weight: 300; width: 150px; line-height: 50px; color: #888;"
									ng-model="col.activeFlag"
									ng-options="list.id as list.id for list in activeFlagList">
									<option value="">-None-</option>
						    </select></td>
					<td>
					<select 
									style="font-size: 16px; font-weight: bold; border: 3px solid #ddd; font-family: 'Roboto', sans-serif; padding: 10px 10px; font-weight: 300; width: 200px; line-height: 50px; color: #888;"
									ng-model="col.dataCorrection"
									ng-options="list.dataCrtnDesc as list.dataCrtnDesc for list in col.refData" >
									<option value="" >-None-</option>
						    </select></td>
					<td><input type="text" ng-model="col.defaultVal" class="form-control"></td>
					<td><input type="text" ng-model="col.jobValidationDescription" class="form-control"></td>
					<td><input type="text" ng-model="col.validationCondition" class="form-control"></td>
					
				</tr>
			</tbody>
</table>
    <button type="submit" class="btn" ng-click="submitValidationDetails()">Submit</button>
    <button class="btn" ng-click="addValidationRow()">Add</button>
</div>
<!-- ng-init="col.sourceColumnName = $index" -->
<!-- <select 
									style="font-size: 16px; font-weight: bold; border: 3px solid #ddd; font-family: 'Roboto', sans-serif; padding: 10px 10px; font-weight: 300; width: 200px; line-height: 50px; color: #888;"
									ng-model="col.dataCorrection"
									ng-options="list.dataCrtnDesc as list.dataCrtnDesc for list in refDataLst" >selectedDataCorrection ng-change="displayDataCrct(selectedDataCorrection)
									<option value="" >-None-</option>
						    </select> -->