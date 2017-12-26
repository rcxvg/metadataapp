<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="metadaApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>RCG | MetaData </title>
<c:import url="/WEB-INF/views/index.jsp"></c:import>
</head>
<body ng-controller="MainController">
<div class="w3-container w3-teal">
 <h1>{{appName}}</h1> &nbsp;&nbsp; <a ng-href="#/"><img src="<c:url value="/static/img/home.png"/>" align="right" width="32" height="32"/><!-- <h1  style="margin-top: 0px; margin-bottom: 10px; margin-right: 0em; margin-left: 65em;font-size: 1em;">Home</h1> --></a>
   
    
</div>
<div ng-controller="MetadataController">
<div class="loader" data-loading></div>
<div ng-view></div>
 </div>

</body>
</html>
