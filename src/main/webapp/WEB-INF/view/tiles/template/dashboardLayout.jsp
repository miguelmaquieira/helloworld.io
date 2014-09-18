<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html lang="en">

	<head>
	
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="mgmaquieira">
	
	    <title>HelloWorld.io</title>
	    
	    <%@ include file="staticLinks.jsp" %>
	    
	</head>
	<body>
		<div id="wrapper">
			<jsp:include page="/WEB-INF/view/jsp/template/dashboardNavHeader.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/view/jsp/template/dashboardNavSidebar.jsp"></jsp:include>
			
			<tiles:insertAttribute name="body"/>
		</div>
		
	</body>
</html>
