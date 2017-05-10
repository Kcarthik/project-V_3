<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false"%>
<%@ include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Category </title>
</head>
<body>
<div class="container-wrapper">
		<div class="container">
			<table class="table table-striped">

				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>					
						<th>Details</th>	
						<th>Edit</th>
					</tr>

				</thead>
				<c:forEach items="${categorylist}" var="c">
					<tr>
						<td>${c.id}</td>
						<td>${c.categoryName}</td>
						<td>${c.categoryDetails}</td>
			
						<td><c:url value="/admin/category/viewCategory/${c.id}" var="view"></c:url><a href="${view}"><span class="glyphicon glyphicon-info-sign"></span></a>
						<c:url value="/admin/category/deleteCategory/${c.id}" var="delete"></c:url><a href="${delete}"><span class="glyphicon glyphicon-remove"></span></a>
						<a href=""><span class="glyphicon glyphicon-pencil"></span></a></td>

					</tr>


				</c:forEach>

			</table>


		</div>

	</div>

</body>
</html>