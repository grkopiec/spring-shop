<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<spring:url value="/resources/style/bootstrap-3.3.7-dist/css/bootstrap.min.css" />" rel="stylesheet" />	<!-- spring tags we can user also for css resources -->
		<title>Login page</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Login</h1>
					<p>Login to page</p>
				</div>
			</div>
		</section>
		<section class="container">
			<div class="row">
				<div class="col-xs-6 col-xs-offset-6 col-sm-6 col-sm-offset-6 col-md-6 col-md-offset-6 col-lg-6 col-lg-offset-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Login</h3>
						</div>
						<div class="panel-body">
							<c:if test="${not empty error}">
								<div class="alert alert-danger">
									<spring:message code="login.failed" />
									<br />
								</div>
							</c:if>
							<form action="<c:url value='/login' />" method="post">
								<fieldset>
									<div class="form-group">
										<input class="form-control" placeholder="User name" name="username" type="text" />
									</div>
									<div class="form-group">
										<input class="form-control" placeholder="Password" name="password" value="" type="text" />
									</div>
									<input class="btn btn-lg btn-success btn-block" type="submit" value="Login" />
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>