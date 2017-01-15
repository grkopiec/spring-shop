<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<spring:url value="/resources/style/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet" />	<!-- spring tags we can user also for css resources -->
		<script src="<spring:url value="/resources/javaScript/angular/angular.min.js" />"></script>
		<script src="<spring:url value="/resources/javaScript/controllers.js" />"></script>
		<title>
			<spring:message code="product.urlTitle" />
		</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>
						<spring:message code="product.header.title" />
					</h1>
				</div>
			</div>
		</section>
		<section class="container" ng-app="cartApp">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="thumbnail">
						<img src="<spring:url value="/resources/images/${product.id}.png" />" alt="<spring:message code="product.description.productImageAlternative" />" />
						<div class="caption">
							<h3>${product.name}</h3>
							<p>${product.description}</p>
							<p>
								<strong>
									<spring:message code="product.description.productCode" />
								</strong>
								<span class="label label-warning">${product.id}</span>
							</p>
							<p>
								<strong>
									<spring:message code="product.description.productManufacturer" />
								</strong>
								${product.manufacturer}
							</p>
							<p>
								<strong>
									<spring:message code="product.description.productCategory" />
								</strong>
								${product.category}
							</p>
							<p>
								<strong>
									<spring:message code="product.description.productInStock" />
								</strong>
								${product.inStock}
							</p>
							<p>${product.price} PLN</p>
							<p ng-controller="cartCtrl" ng-init="initCart()">
								<a href="<spring:url value="/products" />" class="btn btn-default">
									<span class="glyphicon glyphicon-hand-left"></span>
									<spring:message code="product.link.back" />
								</a>
								<a class="btn btn-warning btn-large" ng-click="addToCart('${product.id}')">
									<span class="glyphicon glyphicon-shopping-cart"></span>
									<spring:message code="product.link.order" />
								</a>
								<a href="<spring:url value="/cart" />" class="btn btn-default">
									<span class="glyphicon glyphicon-hand-right"></span>
									Basket
								</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>