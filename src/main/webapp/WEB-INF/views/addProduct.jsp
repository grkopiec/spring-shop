<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<spring:url value="/resources/style/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet" />	<!-- spring tags we can user also for css resources -->
		<title>Add product</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Product</h1>
					<p>Add new product</p>
				</div>
				<a href="<c:url value='/logout' />" class="btn btn-danger btn-mini pull-right">Log out</a>
			</div>
		</section>
		<section class="container">
			<form:form modelAttribute="product" class="form-horizontal">
				<fieldset>
					<legend>Add new product</legend>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="name">Product name</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:input id="name" path="name" type="text" class="form input-large" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="description">Product description</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:textarea id="description" path="description" rows="2" class="form textarea-large" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="id">
							<spring:message code="addProduct.form.productCode" />
						</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:input id="id" path="id" type="text" class="form input-large" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="manufacturer">Product manufacturer</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:input id="manufacturer" path="manufacturer" type="text" class="form input-large" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="category">Product category</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:input id="category" path="category" type="text" class="form input-large" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="inStock">Products in magazine</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:input id="inStock" path="inStock" type="text" class="form input-large" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="inOrder">Products in order</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<input id="inOrder" type="text" value="0" disabled="disabled" class="form input-large" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="price">Product price</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:input id="price" path="price" type="text" class="form input-large" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="discontinued">Is product discontinued</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<input id="discontinued" type="checkbox" disabled="disabled"  class="form checkbox-large" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="condition">Product condition</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:radiobutton path="condition" value="new" class="form radiobutton-large" />New
							<form:radiobutton path="condition" value="old" class="form radiobutton-large" />Used
							<form:radiobutton path="condition" value="refurbished" class="form radiobutton-large" />Refurbished
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-2 col-xs-offset-10 col-sm-2 col-sm-offset-10 col-md-2 col-md-offset-10 col-lg-2 col-lg-offset-10">
							<input type="submit" id="btn-add" class="btn btn-primary" value="Add" />
						</div>
					</div>
				</fieldset>
			</form:form>
		</section>
	</body>
</html>