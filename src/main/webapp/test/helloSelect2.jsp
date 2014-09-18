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

    <title>HelloWorld.io test Page Select2</title>
    
    <link href=<c:url value="static/css/bootstrap.css"/> rel="stylesheet" type="text/css"/>
    <link href=<c:url value="static/css/select2/select2.css"/> rel="stylesheet" type="text/css">
    <link href=<c:url value="static/css/select2/select2-bootstrap.css"/> rel="stylesheet" type="text/css">
    <link href=<c:url value="static/css/test/gh-pages.css"/> rel="stylesheet" type="text/css">
    
    <script src=<c:url value="static/js/jquery.js"/> type="text/javascript"></script>
    <script src=<c:url value="static/js/select2/select2.js"/> type="text/javascript"></script>
	

	<script type="text/javascript">

	$(document).ready(function() {
		$('#select2').editable({
			placeholder: "Select value ...",
			maximumSelectionSize: 6
		});
	});
	
</script>	
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<div class="select2-demos">
				<div class="select2-wrapper">
					<select class="form-control input-lg select2">
						<option></option>
						<optgroup label="Alaskan/Hawaiian Time Zone">
							<option value="AK">Alaska</option>
							<option value="HI">Hawaii</option>
						</optgroup>
						<optgroup label="Pacific Time Zone">
							<option value="CA">California</option>
							<option value="NV">Nevada</option>
							<option value="OR">Oregon</option>
							<option value="WA">Washington</option>
						</optgroup>
					</select>
				</div>
				<div class="select2-wrapper">
					<select class="form-control select2" multiple="multiple">
						<option></option>
						<optgroup label="Alaskan/Hawaiian Time Zone">
							<option value="AK">Alaska</option>
							<option value="HI">Hawaii</option>
						</optgroup>
						<optgroup label="Pacific Time Zone">
							<option value="CA">California</option>
							<option value="NV">Nevada</option>
							<option value="OR">Oregon</option>
							<option value="WA">Washington</option>
						</optgroup>
					</select>
				</div>
				<div class="select2-wrapper">
					<div class="form-group">
						<div class="input-group input-group-sm select2-bootstrap-prepend">
							<span class="input-group-addon">
								<input type="checkbox">
							</span>
							<select id="select2-single-input-group-sm" class="form-control select2" disabled>
								<option></option>
								<optgroup label="Alaskan/Hawaiian Time Zone">
									<option value="AK">Alaska</option>
									<option value="HI">Hawaii</option>
								</optgroup>
								<optgroup label="Pacific Time Zone">
									<option value="CA">California</option>
									<option value="NV">Nevada</option>
									<option value="OR">Oregon</option>
									<option value="WA">Washington</option>
								</optgroup>
							</select>
						</div>
					</div>
				</div>
			</div>
			<h1>Select2 Bootstrap 3&nbsp;CSS</h1>
			<p class="lead">CSS to make <a href="http://ivaynberg.github.io/select2/">Select2</a> fit in with <a href="http://getbootstrap.com/">Bootstrap 3</a>  – ready for use in original, LESS, Sass and Compass flavors.</p>
			<a href="https://raw.githubusercontent.com/t0m/select2-bootstrap-css/bootstrap3/select2-bootstrap.css" class="btn btn-outline btn-large">Download CSS from GitHub</a>
			<ul class="jumbotron-links">
				<li><a href="https://github.com/t0m/select2-bootstrap-css/tree/bootstrap3">GitHub project</a></li>
				<li><a href="https://github.com/t0m/select2-bootstrap-css/tree/bootstrap3#readme">Readme</a></li>
				<li><a href="https://github.com/t0m/select2-bootstrap-css">Bootstrap 2 version</a></li>
			</ul>
			<hr>
	
			<h2>Demonstrations</h2>
	
			<ul class="jumbotron-links">
				<li>Bootstrap 3.2.0 and Select2</li>
					<li><a href="3.3.2.html">3.3.2</a></li>
					<li><a href="3.4.1.html">3.4.1</a></li>
					<li><a href="3.4.2.html">3.4.2</a></li>
					<li><a href="3.4.3.html">3.4.3</a></li>
					<li><a href="3.4.4.html">3.4.4</a></li>
					<li><a href="3.4.5.html">3.4.5</a></li>
					<li><a href="3.5.1.html">3.5.1</a></li>
					<li><a href="master.html">master</a></li>
			</ul>
		</div>
	</div>
	<div class="footer">
		<div class="container">
			<p>
				<a href="http://getbootstrap.com">Bootstrap</a> is a front-end framework for fast, sleek, and mobile-first web development.<br>
				<a href="http://select2.com">Select2</a> is a jQuery based replacement for select boxes.
			</p>
			<p>
				&#x2764; <a href="https://twitter.com/fk">@fk</a> &times; <a href="https://github.com/fk/select2-bootstrap-css#credits">contributors</a>
			</p>
		</div>
	</div>
</body>
</html>