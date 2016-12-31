<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<tags:url value="/resources/style/bootstrap.min.css" />" rel="stylesheet" />	<!-- spring tags we can user also for css resources -->
		<title>Insert title here</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>${greeting}</h1>
					<p>${tagline}</p>
				</div>
			</div>
		</section>
	</body>
</html>