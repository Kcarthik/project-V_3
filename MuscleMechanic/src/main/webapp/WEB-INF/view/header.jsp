<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
			<c:url value="/" var="index"/>
				<a class="navbar-brand" href="${index}">MuscleMechanic</a>
			</div>
			<ul class="nav navbar-nav">
			
				
				<c:url value="/all/about" var="about"/>
				<li><a href="${about }">About Us</a></li>
				<c:url value="/all/contact" var="contact"/>
				<li><a href="${contact }">Contact Us</a></li>
				<c:url value="/admin/product" var="product"/>
				<li><a href="${product}">Product</a></li>
			
				<li class="dropdown"><a class="dropdown-toggle"
				
					data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
					<ul class="dropdown-menu">
					
						<li><a href="#"></a></li>
						<li><a href="#">Pre-Workout</a></li>
						<li><a href="#">Intra-Workout</a></li>
						<li><a href="#">Post-Workout</a></li>
					</ul></li>
				
			</ul>
			<ul class="nav navbar-nav navbar-right">
			<c:url value="/all/customer/showCustomer" var="SignUp"/>
				<li><a href="${SignUp}"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</nav>

	
</body>
</html>