<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header"><spring:message code="dashboard.profile.title"/></h1>
		</div>
	</div>
	<div class="row">
		<div class="panel-group" id="profile">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#profile" href="#accordionOne">
							<spring:message code="dashboard.profile.info.basic" />
						</a>
					</h4>
				</div>
				<div id="accordionOne" class="panel-collapse collapse in">
					<div class="panel-body">
						<tiles:insertAttribute name="basicInfo"/>
					</div>
				</div>
			</div>
			<div class="panel panel-success">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#profile" href="#accordionTwo">
							<spring:message code="dashboard.profile.info.languages" />
						</a>
					</h4>	
				</div>
				<div id="accordionTwo" class="panel-collapse collapse">
					<div class="panel-body">
						<p>Accordion 2 Text</p>
					</div>
				</div>
			</div>
			<div class="panel panel-warning">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#profile" href="#accordionThree">
							<spring:message code="dashboard.profile.info.stadistics" />
						</a>
					</h4>
				</div>
				<div id="accordionThree" class="panel-collapse collapse">
					<div class="panel-body">
						<p>Accordion 3 Text</p>    
					</div>
				</div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#profile" href="#accordionFour">
							<spring:message code="dashboard.profile.info.settings" />
						</a>
					</h4>
				</div>
				<div id="accordionFour" class="panel-collapse collapse">
					<div class="panel-body">
						<p>Accordion 4 Text</p>    
					</div>
				</div>
			</div>
		</div>
	</div>
</div>