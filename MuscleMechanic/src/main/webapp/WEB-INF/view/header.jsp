<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<%@page session="true" %>
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
			
				
				<c:url value="/all/about" var="about"></c:url>
				<li><a href="${about }">About Us</a></li>
				<c:url value="/all/contact" var="contact"/>
				<li><a href="${contact }">Contact Us</a></li>
				<c:url value="/admin/product" var="product"/>
				
				
				<c:if test="${pageContext.request.userPrincipal.name !=null }">
			<security:authorize access="hasRole('ROLE_ADMIN')">
			<c:url value="/admin/product" var="product"/>
				<li><a href="${product}">Product</a></li>
			</security:authorize>
			
			
				<li class="dropdown"><a class="dropdown-toggle"
				
					data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
					<ul class="dropdown-menu">
					
					
						<li><a href="#">Pre-Workout</a></li>
						<li><a href="#">Intra-Workout</a></li>
						<li><a href="#">Post-Workout</a></li>
					</ul></li>
			
         
			
	

			
				</c:if>
			</ul>
			<ul class="nav navbar-nav navbar-right">
			<li><a href=""> Hi, ${pageContext.request.userPrincipal.name }</a></li>
			
					<security:authorize access="hasRole('ROLE_USER')">
         <li><a href="<c:url value="/cart/getCartId"></c:url>"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
         </security:authorize>	
			
			<c:if test="${pageContext.request.userPrincipal.name !=null }">
			<li><a href="<c:url value="/j_spring_security_logout"></c:url>"> <span class="glyphicon glyphicon-log-in"></span> logout</a></li>
			</c:if>	
			
			<c:if test="${pageContext.request.userPrincipal.name ==null }">
			<c:url value="/signup" var="SignUp"></c:url>
				<li><a href="${SignUp}"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
						<c:url value="/login" var="url"></c:url>
				<li><a href="${url}"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
						
				</c:if>		
						
						
				
			</ul>
		</div>
		
	
	
		
	</nav>
	

	

	
</body>
</html>