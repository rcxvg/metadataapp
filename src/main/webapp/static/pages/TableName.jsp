

<div class="form-group">
							<label style="margin-left: 2em;">Source Table Name<sup class="sup-color">*</sup></label>
							<select
									style="font-size: 16px; font-weight: bold; margin-left: 7.5em; border: 3px solid #ddd; font-family: 'Roboto', sans-serif; padding: 10px 10px; font-weight: 300; width: 300px; line-height: 50px; color: #888;"
									ng-model="selectedSourceTable"
									ng-options="list.tableName as list.tableName for list in sourceTableNameLst">
									<option value="" ng-if="false"></option>
						    </select>
						</div>
		
<div>
							<label style="margin-left: 2em;">Target Table Name<sup class="sup-color">*</sup></label>
							<select
									style="font-size: 16px; font-weight: bold; margin-left: 7.5em; border: 3px solid #ddd; font-family: 'Roboto', sans-serif; padding: 10px 10px; font-weight: 300; width: 300px; line-height: 50px; color: #888;"
									ng-model="selectedTargetTable"
									ng-options="list.tableName as list.tableName for list in targetTableNameLst">
									<option value="" ng-if="false"></option>
						    </select>
						</div>
						
						<button type="submit" class="btn" ng-click="submitJobDetails()">Submit</button>