
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div ng-controller="MetadataController" class="row">
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div style="display: block; align:left;" class="col-md-4">
<a ng-href="#/client"><img src="<c:url value="/static/img/client.jpg"/>" width="140" height="140"/><h1>Client</h1></a><span>As a member, add new client and get the file types based on client number.</span>
</div>
<div class="col-md-4">
<a ng-href="#/fileType"><img src="<c:url value="/static/img/file.png"/>"  width="140" height="140" /><h1>File</h1></a><span>List all the file types and add new file, edit and delete file types.</span>
</div>
<div class="col-md-4">
<a ng-href="#/job"><img src="<c:url value="/static/img/briefcase.png"/>" width="140" height="140" /><h1>Job</h1></a><span>Display all jobs and for new jobs add source and target tables and match the columns</span>
</div>
</div>


<!-- align="middle"  width="140" height="140" hspace="40" vspace="100" -->
