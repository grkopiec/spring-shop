<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<spring:url value="/resources/style/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet" />	<!-- spring tags we can user also for css resources -->
		<title>Invalid code</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Invalid code</h1>
				</div>
			</div>
		</section>
		<section class="container">
			<p>
				<a href="<spring:url value="/products" />" class="btn btn-primary">
					<span class="glyphicon glyphicon-hand-left"></span>
					Products
				</a>
			</p>
		</section>
	</body>
</html>