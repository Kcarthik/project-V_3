<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false"%>
<%@ include file="header.jsp"%>

<html>
<head>
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Product</title>
</head>
<body >
<div> 
		<div class="page-header">
		
			<b>PRODUCT DETAILS</b>
		</div>
		<table class="table">
			<tr>
				<td>Product Name :</td>
				<td>${product.name }</td>
			</tr>
			<tr>
				<td>Product Description</td>
				<td>${product.description }</td>
			</tr>
			<tr>
				<td>Product Price</td>
				<td>${product.price }</td>
			</tr>


			<tr>
				<td>Product Quantity</td>
				<td>${product.quantity }</td>
			</tr>

			</table>
			</div>
</body>
</html>