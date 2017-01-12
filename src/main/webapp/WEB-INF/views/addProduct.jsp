<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<spring:url value="/resources/style/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet" />	<!-- spring tags we can user also for css resources -->
		<title>
			<spring:message code="addProduct.urlTitle" />
		</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>
						<spring:message code="addProduct.header.title" />
					</h1>
					<p>
						<spring:message code="addProduct.header.subtitle" />
					</p>
				</div>
				<div>
					<div class="col-xs-8 col-sm-6 col-md-4 col-lg-2">
						<a href="?language=pl">
							<spring:message code="addProduct.header.languagePolish" />
						</a>
						|
						<a href="?language=en">
							<spring:message code="addProduct.header.languageEnglish" />
						</a>
					</div>
					<div class="	col-xs-4 col-sm-6 col-md-8 col-lg-10">
						<a href="<c:url value='/logout' />" class="pull-right btn btn-danger btn-mini">
							<spring:message code="addProduct.header.logout" />
						</a>
					</div>
				</div>
			</div>
		</section>
		<section class="container">
			<form:form modelAttribute="product" class="form-horizontal" enctype="multipart/form-data">
				<fieldset>
					<legend>
						<spring:message code="addProduct.form.legend" />
					</legend>
					<form:errors path="*" cssClass="alert alert-danger" element="div" />
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="name">
							<spring:message code="addProduct.form.productName" />
						</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:input id="name" path="name" type="text" class="form input-large" />
							<form:errors path="name" cssClass="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="image">
							<spring:message code="addProduct.form.productImage" />
						</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:input id="image" path="image" type="file" class="form input-large" />
							<form:errors path="image" cssClass="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="manual">
							<spring:message code="addProduct.form.productManual" />
						</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:input id="manual" path="manual" type="file" class="form input-large" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="description">
							<spring:message code="addProduct.form.productDescription" />
						</label>
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
							<form:errors path="id" cssClass="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="manufacturer">
							<spring:message code="addProduct.form.productManufacturer" />
						</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:input id="manufacturer" path="manufacturer" type="text" class="form input-large" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="category">
							<spring:message code="addProduct.form.productCategory" />
						</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:input id="category" path="category" type="text" class="form input-large" />
							<form:errors path="category" cssClass="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="inStock">
							<spring:message code="addProduct.form.productInStock" />
						</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:input id="inStock" path="inStock" type="text" class="form input-large" />
							<form:errors path="inStock" cssClass="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="inOrder">
							<spring:message code="addProduct.form.productInOrder" />
						</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<input id="inOrder" type="text" value="0" disabled="disabled" class="form input-large" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="price">
							<spring:message code="addProduct.form.productPrice" />
						</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:input id="price" path="price" type="text" class="form input-large" />
							<form:errors path="price" cssClass="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="discontinued">
							<spring:message code="addProduct.form.productDiscontinued" />
						</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<input id="discontinued" type="checkbox" disabled="disabled"  class="form checkbox-large" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-2 col-sm-2 col-md-2 col-lg-2" for="condition">
							<spring:message code="addProduct.form.productCondition" />
						</label>
						<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
							<form:radiobutton path="condition" value="new" class="form radiobutton-large" />
							<spring:message code="addProduct.form.productCondition.new" />
							<form:radiobutton path="condition" value="old" class="form radiobutton-large" />
							<spring:message code="addProduct.form.productCondition.used" />
							<form:radiobutton path="condition" value="refurbished" class="form radiobutton-large" />
							<spring:message code="addProduct.form.productCondition.refurbished" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-2 col-xs-offset-10 col-sm-2 col-sm-offset-10 col-md-2 col-md-offset-10 col-lg-2 col-lg-offset-10">
							<input type="submit" id="btn-add" class="btn btn-primary" value="<spring:message code="addProduct.button.add" />" />
						</div>
					</div>
				</fieldset>
			</form:form>
		</section>
	</body>
</html>