<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<spring:url value="/resources/style/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet" />	<!-- spring tags we can user also for css resources -->
		<script src="<spring:url value="/resources/javaScript/angular/angular.min.js" />"></script>
		<script src="<spring:url value="/resources/javaScript/controllers.js" />"></script>
		<title>Basket</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Basket</h1>
					<p>Products in your basket</p>
				</div>
			</div>
		</section>
		<section class="container" ng-app="cartApp">
			<div ng-controller="cartCtrl" ng-init="initCart()">
				<div>
					<a class="btn btn-danger pull-left" ng-click="clearCart()">
						<span class="glyphicon glyphicon-remove-sign"></span>
						Clean basket
					</a>
					<a href="#" class="btn btn-success pull-right">
						<span class="glyphicon glyphicon-shopping-cart"></span>
						Buy
					</a>
				</div>
				<table class="table table-hover">
					<tr>
						<th>Product</th>
						<th>Number of units</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
					<tr ng-repeat="item in cart.cartItems">
						<td>{{item.product.id}}-{{item.product.name}}</td>
						<td>{{item.product.inStock}}</td>
						<td>{{item.product.price}}</td>
						<td>
							<a href="#" class="label label-danger" ng-click="removeFromCart(item.product.id)">
								<span class="glyphicon glyphicon-remove"></span>
								Remove
							</a>
						</td>
					</tr>
					<tr>
						<th></th>
						<th>Total price</th>
						<th>{{cart.total}}</th>
						<th></th>
					</tr>
				</table>
				<a href="<spring:url value="/products" />" class="btn btn-default">
					<span class="glyphicon glyphicon-hand-left"></span>
					Back to shopping
				</a>
			</div>
		</section>
	</body>
</html>