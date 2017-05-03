<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN || ADD SUPPLIER</title>
</head>
<body>
	<div class="container-wrapper">
		<div class="container">
			<c:url value="/admin/supplier/addSupplier" var="url">
			</c:url>

			<form:form method="POST" action="${url}" commandName="supplier">
				<div class="form-group">
					
					<form:hidden path="id" class="form-control" />
				</div>
				<div class="form-group">
					<form:label path="supplierName">Name</form:label>

					<form:input path="supplierName" class="form-control" />
				</div>
				<div class="form-group">
					<form:label path="supplierAddress">Address</form:label>
					<form:input path="supplierAddress" class="form-control" />
				</div>
				
				<input type="submit" value="Add Supplier" />
			</form:form>
		</div>

	</div>

</body>
</html>