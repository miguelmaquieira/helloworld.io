<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> 
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="${flowExecutionUrl}&_eventId=goHome"><spring:message code="dashboard.headerTitle"/></a>
	</div>

	<ul class="nav navbar-top-links navbar-right">
		<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				<img src="blank.gif" class="${lang.icon}" /> ${lang.name}
				<i class="fa fa-language fa-fw"></i>
				<i class="fa fa-caret-down"></i>
			</a>
			<ul class="dropdown-menu dropdown-languages">
				<c:forEach var="language" items="${languages}">
						<li>
							<a href="${flowExecutionUrl}&_eventId=changeLocale&lang=${language.locale}">
								<div>
									<img src="blank.gif" class="${language.icon}"/> ${language.name}
								</div>
							</a>
							
						</li>
					</c:forEach>
			</ul>
		</li>
		<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i class="fa fa-envelope fa-fw"></i><i class="fa fa-caret-down"></i></a>
			<ul class="dropdown-menu dropdown-messages">
				<c:forEach var="message" items="${messages}">
					<li>
						<a href="#">
							<div>
								<strong>${message.from}</strong> <span class="pull-right text-muted"><em>${message.date}</em></span>
							</div>
							<div>${message.messageText}</div>
						</a>
					</li>
				</c:forEach>
				<li class="divider"></li>
				<li>
					<a class="text-center" href="#"><strong><spring:message code="dashboard.messageReadAll"/></strong> <i class="fa fa-angle-right"></i></a>
				</li>
			</ul> <!-- /.dropdown-messages -->
		</li>
		<!-- /.dropdown -->
		<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				<i class="fa fa-tasks fa-fw"></i>
				<i class="fa fa-caret-down"></i>
			</a>
			<ul class="dropdown-menu dropdown-tasks">
				<c:forEach var="task" items="${tasks}">
					<li>
					<a href="#">
						<div>
							<p><strong>${task.name}</strong> <span class="pull-right text-muted">${task.progress}% <spring:message code="dashboard.taskComplete"/></span></p>
							<div class="progress progress-striped active">
								<div class="progress-bar progress-bar-${task.status}" role="progressbar" aria-valuenow="${task.progress}" aria-valuemin="0" aria-valuemax="100" style="width: ${task.progress}%">
									<span class="sr-only">${task.progress}% <spring:message code="dashboard.taskComplete"/> (${task.status})</span>
								</div>
							</div>
						</div>
					</a>
					</li>
					<li class="divider"></li>
				</c:forEach>
				<li>
					<a class="text-center" href="#"><strong><spring:message code="dashboard.seeAllTasks"/></strong> <i class="fa fa-angle-right"></i></a>
				</li>
			</ul>
		<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				<i class="fa fa-bell fa-fw"></i>
				<i class="fa fa-caret-down"></i>
			</a>
			<ul class="dropdown-menu dropdown-alerts">
				<c:forEach var="alert" items="${alerts}">
					<li>
						<a href="#">
							<div>
								<i class="${alert.icon}"></i> ${alert.message} <span class="pull-right text-muted small">${alert.since}</span>
							</div>
						</a>
					</li>
					<li class="divider"></li>
				</c:forEach>
				<li>
					<a class="text-center" href="#"><strong><spring:message code="dashboard.seeAllAlerts"/></strong> <i class="fa fa-angle-right"></i></a>
				</li>
			</ul>
		<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#"> 
				<i class="fa fa-user fa-fw"></i>
				<i class="fa fa-caret-down"></i>
			</a>
			<ul class="dropdown-menu dropdown-user">
				<li>
					<a href="${flowExecutionUrl}&_eventId=doProfile"><i class="fa fa-user fa-fw"></i> <spring:message code="dashboard.userProfile"/></a>
				</li>
				<li>
					<a href="${flowExecutionUrl}&_eventId=doSettings"><i class="fa fa-gear fa-fw"></i> <spring:message code="dashboard.settings"/></a>
				</li>
				<li class="divider"></li>
				<li>
					<a href=<c:url value="/signout"/>><i class="fa fa-sign-out fa-fw"></i><spring:message code="dashboard.logout"/></a>
				</li>
			</ul>
		</li>
	</ul>
</nav>