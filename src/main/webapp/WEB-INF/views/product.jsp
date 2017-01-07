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
					<h1>Product</h1>
				</div>
			</div>
		</section>
		<section class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="thumbnail">
						<img src="<spring:url value="/resources/images/${product.id}.png" />" alt="image" />
						<div class="caption">
							<h3>${product.name}</h3>
							<p>${product.description}</p>
							<p>
								<strong>Product code: </strong>
								<span class="label label-warning">${product.id}</span>
							</p>
							<p>
								<strong>Manufacturer: </strong>
								${product.manufacturer}
							</p>
							<p>
								<strong>Category: </strong>
								${product.category}
							</p>
							<p>
								<strong>Quantity in magazine: </strong>
								${product.inStock}
							</p>
							<p>${product.price} PLN</p>
							<p>
								<a href="<spring:url value="/products" />" class="btn btn-default">
									<span class="glyphicon glyphicon-hand-left"></span>
									Back
								</a>
								<a href="#" class="btn btn-warning btn-large">
									<span class="glyphicon glyphicon-shopping-cart"></span>
									Order now
								</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>