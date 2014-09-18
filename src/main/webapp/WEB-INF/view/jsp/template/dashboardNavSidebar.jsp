<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li class="sidebar-search">
				<div class="input-group custom-search-form">
					<input type="text" class="form-control" placeholder="<spring:message code="dashboard.sidebar.searchText"/>">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div> <!-- /input-group -->
			</li>
			<li>
				<a class="active" href="${flowExecutionUrl}&_eventId=doPartner">
					<i class="fa fa-users fa-fw"></i>&nbsp;<spring:message code="dashboard.sidebar.langPartner"/>
				</a>
			</li>
			<li>
				<a href="#"><i class="fa fa-gamepad fa-fw"></i>&nbsp;<spring:message code="dashboard.sidebar.workout"/><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li>
						<a href="${flowExecutionUrl}&_eventId=doTranslations">&nbsp;<spring:message code="dashboard.sidebar.translations"/></a>
					</li>
					<li>
						<a href="${flowExecutionUrl}&_eventId=doAnswers">&nbsp;<spring:message code="dashboard.sidebar.answers"/></a>
					</li>
					<li>
						<a href="${flowExecutionUrl}&_eventId=doVocabulary">&nbsp;<spring:message code="dashboard.sidebar.vocabulary"/></a>
					</li>
				</ul> <!-- /.nav-second-level --></li>
			<li>
				<a href="${flowExecutionUrl}&_eventId=doTeachers"><i class="fa fa-mortar-board fa-fw"></i>&nbsp;<spring:message code="dashboard.sidebar.teachers"/></a>
			</li>
			<li>
				<a href="${flowExecutionUrl}&_eventId=doHeroes"><i class="fa fa-magic fa-fw"></i>&nbsp;<spring:message code="dashboard.sidebar.heroes"/></a>
			</li>
			<li>
				<a href="#"><i class="fa fa-map-marker fa-fw"></i>&nbsp;<spring:message code="dashboard.sidebar.nearby"/><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="panels-wells.html">Panels and Wells</a></li>
					<li><a href="buttons.html">Buttons</a></li>
					<li><a href="notifications.html">Notifications</a></li>
					<li><a href="typography.html">Typography</a></li>
					<li><a href="grid.html">Grid</a></li>
				</ul> <!-- /.nav-second-level --></li>
			<li>
				<a href="#"><i class="fa fa-send fa-fw"></i>&nbsp;<spring:message code="dashboard.sidebar.now"/><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="#">Second Level Item</a></li>
					<li><a href="#">Second Level Item</a></li>
					<li><a href="#">Third Level <span class="fa arrow"></span></a>
						<ul class="nav nav-third-level">
							<li><a href="#">Third Level Item</a></li>
							<li><a href="#">Third Level Item</a></li>
							<li><a href="#">Third Level Item</a></li>
							<li><a href="#">Third Level Item</a></li>
						</ul> <!-- /.nav-third-level --></li>
				</ul> <!-- /.nav-second-level --></li>
			<li>
				<a href="#"><i class="fa fa-wrench fa-fw"></i>&nbsp;<spring:message code="dashboard.sidebar.tools"/><span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="blank.html">Blank Page</a></li>
					<li><a href="login.html">Login Page</a></li>
				</ul> <!-- /.nav-second-level -->
			</li>
		</ul>
	</div>
</nav>