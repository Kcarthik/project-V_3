<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="resources/images/productimages/" var="images"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADD||PRODUCT</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<c:url value="/admin/product.do" var="url"></c:url>
				<form:form action="${url}" method="post" commandName="productdata" enctype="multipart/form-data">

					<div class="form-group">

						<form:hidden path="id" class="form-control" />

					</div>

					<div class="form-group">

						<form:input path="name" class="form-control" placeholder="Name" />
						<form:errors path="name" cssClass="error"></form:errors>
					</div>

					<div class="form-group">

						<form:input path="description" class="form-control"
							placeholder="Enter description" />
						<form:errors path="description" cssClass="error"></form:errors>
					</div>


					<div class="form-group">

						<form:input path="price" class="form-control"
							placeholder="Enter Price" />
						<form:errors path="price" cssClass="error"></form:errors>
					</div>


					<div class="form-group">

						<form:input path="quantity" class="form-control"
							placeholder="Enter Quantity" />
						<form:errors path="quantity" cssClass="error"></form:errors>
					</div>
					
					<form:input type="file" path="file" />
					
					
					<div class="form-group">
					
					<label for="category">Category</label>
					<!-- List<Category> c =model.getAttribute("categories");
out.println(c.id)
out.println(c.categoryDetails);
 -->
					<c:forEach var="c" items="${categories}">
						<form:radiobutton path="category.id" value="${c.id}" />${c.categoryName }

				<%-- 	<form:errors path="mfg" cssStyle="color:#ff0000"></form:errors> --%>
					</c:forEach>
				</div>
				
				

					<input type="submit" value="Add Product" />

				</form:form>



			</div>
			<!-- End of outer class -->




		</div>
		<!-- End of row -->

		<div class="row">

			<div class="col-md-6">

				<table class="table">
					<thead>
						<tr>
						<th>Image</th>
							<th>ID</th>
							<th>Name</th>
							<th>Description</th>
							<th>Price</th>
							<th>Quantity</th>
						</tr>
					</thead>
					<c:forEach items="${productlist}" var="p">
						<tr>
						    <c:url value="${images }/${p.id }.jpg" var="src"/>
						    <td><img src="${src}" style="width: 60%" align="middle" ></td>
							<td>${p.id }</td>
							<td>${p.name }</td>
							<td>${p.description }</td>
							<td>${p.price }</td>
							<td>${p.quantity }</td>
							<td><c:url value="/admin/product/viewProduct/${p.id}"
									var="view"></c:url><a href="${view}"><span
									class="glyphicon glyphicon-eye-open"></span></a> <c:url
									value="/admin/product/deleteProduct/${p.id}" var="delete"></c:url><a
								href="${delete}"><span class="glyphicon glyphicon-trash"></span></a>
								<c:url value="/admin/product/editProduct/${p.id}" var="edit"></c:url>
								<a href="${edit}"><span class="glyphicon glyphicon-pencil"></span></a></td>
							
						</tr>
					</c:forEach>

				</table>


			</div>


		</div>


	</div>
	<!-- End of container -->

</body>
</html>