<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<spring:url value="/resources/style/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet" />	<!-- spring tags we can user also for css resources -->
		<title>Products</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Products</h1>
					<p>Products available in our shop</p>
				</div>
			</div>
		</section>
		<section class="container">
			<div class="row">
				<c:forEach items="${productList}" var="product">
					<div class="col-xs-12 col-sm-12 col-md-6 col-lg-3">
						<div class="thumbnail">
							<img src="<spring:url value="/resources/images/${product.id}.png" />" alt="image" />
							<div class="caption">
								<h3>${product.name}</h3>
								<p>${product.description}</p>
								<p>${product.price} PLN</p>
								<p>Quantity in magazine: ${product.inStock}</p>
								<p>
									<a href="<spring:url value="/products/product?id=${product.id}" />" class="btn btn-primary">
										<span class="glyphicon glyphicon-info-sign"></span>
										Details
									</a>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
	</body>
</html>