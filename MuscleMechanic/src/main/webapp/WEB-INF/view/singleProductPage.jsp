<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Single Product </title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
		
		<div class="container-fluid">
		<div class="container">
		<h2> Product  </h2>
		<center>
			<table class="table table-striped">

		
				
					<tr>
					<%--     <td>${productdata.file}</td> --%>
					</tr>
					
		   <tr>
				<td> Name :</td>
				<td>${productdata.name }</td>
			</tr>
			
			<tr>
				<td> Description :</td>
				<td>${productdata.description }</td>
			</tr>
			
			<tr>
				<td> Price :</td>
				<td>${productdata.price }</td>
			</tr>


			<tr>
				<td> Quantity :</td>
				<td>${productdata.quantity }</td>
			</tr>
						
			<tr>
				<td> Category :</td>
				<td>${productdata.category.categoryName }</td>
			</tr>	
<tr>
</tr>
			<td>
			</td>
			
			<td>  <c:url value="/cart/getCartId/" var="cart"> </c:url>
			<a href="${cart }  " ng-click="addToCart(${product.id })"><span class="glyphicon glyphicon-shopping-cart"></span></a>
			<c:url value="/" var="Back"> </c:url>
			<a href="${Back} "   ng-click="Back">   <span class="glyphicon glyphicon-share-alt"></span> </a></td>
		
		
		
			
			</table>
       </center>
		</div>

	</div>

</body>
</html>