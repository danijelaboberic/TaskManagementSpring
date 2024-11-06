<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registracija korisnika</title>
<!-- Bootstrap CSS -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap JS and dependencies -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container my-4">
		<c:choose>
			<c:when test="${not empty poruka}">
			${poruka} ${korisnik}
			<div class="mt-4">
					<a href="/task/user/register">Nazad</a>
				</div>
			</c:when>
			<c:otherwise>
				<sf:form action="/task/user/save" method="post" modelAttribute="user">
					<h3>Registracija novog korisnika</h3>
					<div class="pt-3 row">
						<label class="pr-3 form-label col-1">Ime </label>
						<sf:input class="form-control col-4" type="text" path="name" />
					</div>
					<div class="pt-3 row">
						<label class="pr-3 form-label col-1">Korisnicko ime </label>
						<sf:input class="form-control col-4" type="text" path="username" />
					</div>
					<div class="pt-3 row">
						<label class="pr-3 form-label col-1">Lozinka </label>
						<sf:input class="form-control col-4" type="password" path="password" />
					</div>
					<div class="pt-3 row">
						<label class="pr-3 form-label col-1">Uloga </label>
						    <sf:select path="role" items="${roleList}" itemValue="idrole" itemLabel="name"/>
					</div> 
					<div class="row pt-5 pl-3">
						<button class=" btn btn-primary" type="submit">Registruj</button>
					</div>

				</sf:form>
			</c:otherwise>

		</c:choose>

	</div>
</body>
</html>