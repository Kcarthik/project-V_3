<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN || ADD CATEGORY</title>
</head>
<body>
	<div class="container-wrapper">
		<div class="container">
			<c:url value="/admin/category/addCategory" var="url">
			</c:url>

			<form:form method="POST" action="${url}" commandName="category">
				<div class="form-group">
					<form:hidden path="id" class="form-control" />
				</div>
				
				<div class="form-group">
					<form:label path="categoryName">Name</form:label>
					<form:input path="categoryName" class="form-control" />
				</div>
				
				<div class="form-group">
					<form:label path="categoryDetails">Category Details</form:label>
					<form:input path="categoryDetails" class="form-control" />
				</div>
	
				<input type="submit" value="Add Category" />


			</form:form>
		</div>

	</div>

</body>
</html>