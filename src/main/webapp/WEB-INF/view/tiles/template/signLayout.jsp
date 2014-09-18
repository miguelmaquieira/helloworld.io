<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">

	<head>
	
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="mgmaquieira">
	
	    <title>HelloWorld.io</title>
	    
	    <!-- Bootstrap Core CSS -->
	    <link href=<c:url value="static/css/bootstrap.css"/> rel="stylesheet" type="text/css"/>
		<link href=<c:url value="static/css/bootstrapValidator.css"/> rel="stylesheet" type="text/css"/>
		
	    <!-- MetisMenu CSS -->
	    <link href=<c:url value="static/css/plugins/metisMenu.css"/> rel="stylesheet" type="text/css"/>
	
	     <!-- Custom CSS -->
	    <link href=<c:url value="static/css/helloworld.io.css"/> rel="stylesheet" type="text/css"/>
	
	    <!-- Custom Fonts -->
		<link href=<c:url value="static/css/font-awesome.css"/> rel="stylesheet" type="text/css">
		
		<!-- Librerias JS  -->
		<script src=<c:url value="static/js/jquery.js"/> type="text/javascript"></script>
		<script src=<c:url value="static/js/bootstrap.js"/> type="text/javascript"></script>
		<script src=<c:url value="static/js/bootstrapValidator/bootstrapValidator.js"/> type="text/javascript"></script>
	    <script src=<c:url value="static/js/plugins/metisMenu.js"/> type="text/javascript"></script>
	
		<!-- helloworld.io JS -->
		<script src=<c:url value="static/js/helloworld.io.js"/> type="text/javascript"></script>
	
	</head>
	<body>
		<div id="wrapper">
			<div class="navbar navbar-inverse navbar-static-top">
				<div class="navbar-header">
					<a class="navbar-brand" href="${flowExecutionUrl}&_eventId=goHome"><spring:message code="common.header.title"/></a>
				</div>
			</div>
			<tiles:insertAttribute name="body"/>
		</div>
	</body>
</html>
