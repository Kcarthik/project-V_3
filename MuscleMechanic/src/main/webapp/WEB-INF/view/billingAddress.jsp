<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false"%>
<%@ include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>

<head>
  <meta http-equiv="Content-Type" content="text/html: charset=ISO-8859-1">
 
<title>ADMIN || BILLING ADDRESS</title>
</head>
<body>

<div class="container-wrapper">
		<div class="container">
			<c:url value="/admin/product/addBillingAddress" var="url">
			</c:url>

			<form:form method="POST" action="${url}" commandName="product">
			
				<div class="form-group">
					<label for="id"></label>
					<form:hidden path="id" class="form-control" />
				</div>

				<div class="form-group">
					<form:label path="apartmentNumber">Apartment Number</form:label>
					<form:input path="apartmentNumber" class="form-control" />
				</div>
				
				<div class="form-group">
					<form:label path="streetName">Street Name</form:label>
					<form:input path="streetName" class="form-control" />
				</div>
				
				<div class="form-group">
					<form:label path="city">City</form:label>
					<form:input path="city" class="form-control" />
				</div>
				
				<div class="form-group">
					<form:label path="state">State</form:label>
					<form:input path="state" class="form-control" />
				</div>
				
					<div class="form-group">
					<form:label path="country">Country</form:label>
					<form:input path="country" class="form-control" />
				</div>
				
					<div class="form-group">
					<form:label path="zipcode">Zip Code</form:label>
					<form:input path="zipcode" class="form-control" />
				</div>
				
				
				<input type="submit" value="Add Billing Address"  />
				
			</form:form>
		</div>

	</div>

</body>
</html>