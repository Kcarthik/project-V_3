<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="header.jsp"%>

<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script></head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
</head>
<style>
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}
/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}
/* Float cancel and signup buttons and add an equal width */
.cancelbtn,.signupbtn {
    float: left;
    width: 50%;
}
/* Add padding to container elements */
.container {
    padding: 16px;
}
/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}
/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
</style>
<body>

<h2>Signup Form</h2>


  <div class="container">
  	<c:url value="/all/customer/addCustomer" var="url">
			</c:url>

			<form:form method="POST" action="${url}" commandName="customer">
  
  
  					<div class="form-group">
						<form:label path="firstname">Name</form:label>
						<form:input path="firstname" class="form-control" />
						
					</div>
					
					<div class="form-group">
						<form:label path="lastname">Last Name</form:label>
						<form:input path="lastname" class="form-control" />
						
					</div>
					
					<div class="form-group">
						<form:label path="email">Email</form:label>
						<form:input path="email" class="form-control" />
						
					</div>
					
					<div class="form-group">
						<form:label path="phonenumber">Phone Number</form:label>
						<form:input path="phonenumber" class="form-control" />
			
					</div>

					<div class="form-group">
						<form:label path="users.Username">User Name</form:label>
						<form:input path="users.Username" class="form-control" />
			
					</div>		
					
					<div class="form-group">
						<form:label path="users.password">Password</form:label>
						<form:input path="users.password" type="password" class="form-control" />
			
					</div>			
					
					
					
					<h3> Billing Address</h3>
					
					
  					<div class="form-group">
						<form:label path="billingAddress.apartmentNumber">Apartment Number</form:label>
						<form:input path="billingAddress.apartmentNumber" class="form-control" />
						
					</div>
					
					
  					<div class="form-group">
						<form:label path="billingAddress.streetName">Street Name</form:label>
						<form:input path="billingAddress.streetName" class="form-control" />
						
					</div>
					
					
  					<div class="form-group">
						<form:label path="billingAddress.city">City</form:label>
						<form:input path="billingAddress.city" class="form-control" />
						
					</div>
					
					
  					<div class="form-group">
						<form:label path="billingAddress.state">State</form:label>
						<form:input path="billingAddress.state" class="form-control" />
						
					</div>
					
					<div class="form-group">
						<form:label path="billingAddress.country">Country</form:label>
						<form:input path="billingAddress.country" class="form-control" />
						
					</div>
					
					
					<div class="form-group">
						<form:label path="billingAddress.zipcode">Zipcode</form:label>
						<form:input path="billingAddress.zipcode" class="form-control" />
						
					</div>
					

    
    
    <h3> Shipping Address </h3>
    
    
    
    	<div class="form-group">
					<form:label path="shippingAddress.apartmentNumber">Apartment Number</form:label>
					<form:input path="shippingAddress.apartmentNumber" class="form-control" />
				</div>
				
				<div class="form-group">
					<form:label path="shippingAddress.streetName">Street Name</form:label>
					<form:input path="shippingAddress.streetName" class="form-control" />
				</div>
				
				<div class="form-group">
					<form:label path="shippingAddress.city">City</form:label>
					<form:input path="shippingAddress.city" class="form-control" />
				</div>
				
				<div class="form-group">
					<form:label path="shippingAddress.State">State</form:label>
					<form:input path="shippingAddress.State" class="form-control" />
				</div>
				
					<div class="form-group">
					<form:label path="shippingAddress.country">Country</form:label>
					<form:input path="shippingAddress.country" class="form-control" />
				</div>
				
					<div class="form-group">
					<form:label path="shippingAddress.zipcode">Zip Code</form:label>
					<form:input path="shippingAddress.zipcode" class="form-control" />
				</div>
    
   
   
   <input type="submit" value="SignUp" />
    </form:form>
  </div>

<body>

</body>
</html>