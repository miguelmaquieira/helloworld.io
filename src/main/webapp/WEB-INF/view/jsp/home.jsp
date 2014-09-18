<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <!-- Custom CSS -->
    <link href=<c:url value="static/css/helloworldhome.io.css"/> rel="stylesheet" type="text/css"/>

    <!-- Custom Fonts -->
	<link href=<c:url value="static/css/font-awesome.css"/> rel="stylesheet" type="text/css">
	
	<!-- Icons -->
	<link href=<c:url value="static/css/flags.css"/> rel="stylesheet" type="text/css">
	
	<!-- Librerias JS  -->
	<script src=<c:url value="static/js/jquery.js"/> type="text/javascript"></script>
	<script src=<c:url value="static/js/bootstrap.js"/> type="text/javascript"></script>
</head>

<body>
    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>
    
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#rightHeaderMenu">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${flowExecutionUrl}&_eventId=goHome"><spring:message code="home.headerTitle"/></a>
            </div>
            
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="rightHeaderMenu">
            	<ul class="nav navbar-nav navbar-right">
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
                    <li>
                        <a href=<c:url value="about.htm"/>><spring:message code="home.headerAbout"/></a>
                    </li>
                    <li>
                    	<a href=<c:url value="howitworks.html"/>><spring:message code="home.headerHowItWorks"/></a>
                    </li>
                    <li>
                    	<div style="padding-top: 5px; text-align: center;">
	                    	<div class="btn-group" >
		                    	<a href="${flowExecutionUrl}&_eventId=signin" type="button" class="btn btn-success"><spring:message code="home.headerSignin"/></a>
		                    	<a href="${flowExecutionUrl}&_eventId=signup" type="button" class="btn btn-primary"><spring:message code="home.headerSignup"/></a>
	                    	</div>
                    	</div>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Header Carousel -->
    <header id="homeCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
        	<c:forEach var="item" items="${carousel}">
        		<c:choose>
  					<c:when test="${item.active}">
  						<li data-target="#homeCarousel" data-slide-to="${item.index}" class="active"></li>
  					</c:when>
  					<c:otherwise>
  						<li data-target="#homeCarousel" data-slide-to="${item.index}"></li>
  					</c:otherwise>
  				</c:choose>
            </c:forEach>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
        	<c:forEach var="item" items="${carousel}">
        	<c:set value="" var="activeItem" />
        		<c:if test="${item.active}">
        			<c:set value="active" var="activeItem" />
        		</c:if>
        		<div class="item ${activeItem}">
        			<c:url value="static/img/${item.image}" var="imageUrl"/>
		            <div class="fill" style="background-image:url('${imageUrl}');"></div>
	                <div class="carousel-caption">
	                    <h2>${item.caption}</h2>
	                </div>
                </div>
            </c:forEach>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>

    <!-- Page Content -->
    <div class="container">

        <!-- Marketing Icons Section -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">
                    Welcome to Modern Business
                </h1>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-check"></i> Bootstrap v3.2.0</h4>
                    </div>
                    <div class="panel-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque, optio corporis quae nulla aspernatur in alias at numquam rerum ea excepturi expedita tenetur assumenda voluptatibus eveniet incidunt dicta nostrum quod?</p>
                        <a href="#" class="btn btn-default">Learn More</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-gift"></i> Free &amp; Open Source</h4>
                    </div>
                    <div class="panel-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque, optio corporis quae nulla aspernatur in alias at numquam rerum ea excepturi expedita tenetur assumenda voluptatibus eveniet incidunt dicta nostrum quod?</p>
                        <a href="#" class="btn btn-default">Learn More</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4><i class="fa fa-fw fa-compass"></i> Easy to Use</h4>
                    </div>
                    <div class="panel-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque, optio corporis quae nulla aspernatur in alias at numquam rerum ea excepturi expedita tenetur assumenda voluptatibus eveniet incidunt dicta nostrum quod?</p>
                        <a href="#" class="btn btn-default">Learn More</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.row -->

        <!-- Features Section -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Modern Business Features</h2>
            </div>
            <div class="col-md-6">
                <p>The Modern Business template by Start Bootstrap includes:</p>
                <ul>
                    <li><strong>Bootstrap v3.2.0</strong>
                    </li>
                    <li>jQuery v1.11.0</li>
                    <li>Font Awesome v4.1.0</li>
                    <li>Working PHP contact form with validation</li>
                    <li>Unstyled page elements for easy customization</li>
                    <li>17 HTML pages</li>
                </ul>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, omnis doloremque non cum id reprehenderit, quisquam totam aspernatur tempora minima unde aliquid ea culpa sunt. Reiciendis quia dolorum ducimus unde.</p>
            </div>
            <div class="col-md-6">
                <img class="img-responsive" src="http://placehold.it/700x450" alt="">
            </div>
        </div>
        <!-- /.row -->

        <hr>

        <!-- Call to Action Section -->
        <div class="well">
            <div class="row">
                <div class="col-md-8">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum neque nemo praesentium cum alias asperiores commodi.</p>
                </div>
                <div class="col-md-4">
                    <a class="btn btn-lg btn-default btn-block" href="#">Call to Action</a>
                </div>
            </div>
        </div>

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; helloworld.io 2014</p>
                </div>
            </div>
        </footer>

    </div>
</body>

</html>

