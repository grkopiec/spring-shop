<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<spring:url value="/resources/style/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet" />	<!-- spring tags we can user also for css resources -->
		<title>Product</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1 class="alert alert-danger">No products found in requested category ${category}</h1>
				</div>
			</div>
		</section>
		<section class="container">
			<p>${url}</p>
			<p>${exception}</p>
			<p>
				<a href="<spring:url value="/products" />" class="btn btn-primary">
					<span class="glyphicon glyphicon-hand-left" ></span>
					Products
				</a>
			</p>
		</section>
	</body>
</html>