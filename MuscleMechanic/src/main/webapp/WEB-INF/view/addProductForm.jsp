<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN || ADD PRODUCT</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-5">
				<c:url value="/admin/product/addProduct" var="url">
				</c:url>

				<form:form method="POST" action="${url}" modelAttribute="product"
					enctype="multipart/form-data">
					<div class="form-group">

						<form:hidden path="id" class="form-control" />
					</div>
					<div class="form-group">
						<form:label path="name">Name</form:label>
						<form:input path="name" class="form-control" />
						 <form:errors path="name" cssClass="error"></form:errors> 
					</div>
					<div class="form-group">
						<form:label path="description">Description</form:label>
						<form:input path="description" class="form-control" />
					 	<form:errors path="description" cssClass="error"></form:errors> 
					</div>
					<div class="form-group">
						<form:label path="price">Price</form:label>
						<form:input path="price" class="form-control" />
						<form:errors path="price" cssClass="error"></form:errors> 
					</div>
					<div class="form-group">
						<form:label path="quantity">Quantity</form:label>
						<form:input path="quantity" class="form-control" />
					 	<form:errors path="quantity" cssClass="error"></form:errors> 
					</div>

			<%--  <div class="form-group">
						<form:label path="file">Picture</form:label>
						<form:input type="file" path="file" class="form-control" />
						<form:errors path="file" cssClass="error"></form:errors>
					</div>   --%>

					<input type="submit" value="Add Product" />
				</form:form>
			</div>
			
			</div>
		<!-- End of col-md-5 -->
		
		<!-- End of row -->
		<%-- <div class="row">
			<div class="col-md-6">

				<table class="table">
					<thead>
						<tr>
							 <th>Product Image</th> 
							<th>Product Id</th>
							<th>Product Name</th>
						</tr>

					</thead>
					<c:forEach items="${productlist}" var="p">
						 <tr><c:url value="${images}/${p.id}.jpg" var="src"></c:url>
						
							<td><img src="${src}"/></td> 
							
							<td>${p.id }</td>
							<td>${p.name }</td>
							<td>
							<td><c:url value="/admin/product/viewProduct/${p.id}"
									var="view"></c:url><a href="${view}"><span
									class="glyphicon glyphicon-eye-open"></span></a> <c:url
									value="/admin/product/deleteProduct/${p.id}" var="delete"></c:url><a
								href="${delete}"><span class="glyphicon glyphicon-trash"></span></a>
								<c:url value="/admin/product/editProduct/${p.id}" var="edit"></c:url>
								<a href="${edit}"><span class="glyphicon glyphicon-pencil"></span></a></td>
							
					</c:forEach>
				</table>


			</div>

		</div>
 --%>

	</div>
	<!-- End of container-fluid -->

</body>
</html>