<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

</head>
<body>


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/task"><st:message code="menu.home" /></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown"
				aria-controls="navbarNavDarkDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="/task/user/register"><st:message code="menu.register" /></a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="/task/projects/all"><st:message code="menu.projects" /></a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDarkDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> <st:message
								code="menu.select.language" />
					</a>
						<ul class="dropdown-menu dropdown-menu-dark"
							aria-labelledby="navbarDarkDropdownMenuLink">
							<li><a class="dropdown-item"
								href="/task/language/set?lang=en"><st:message
								code="menu.language.en" /></a></li>
							<li><a class="dropdown-item"
								href="/task/language/set?lang=sr"><st:message
								code="menu.language.sr" /></a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>