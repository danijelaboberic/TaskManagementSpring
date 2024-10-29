<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

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
	<div class="container-fluid">
		<c:choose>
			<c:when test="${not empty poruka}">
			${poruka} ${korisnik}
			<div class="mt-4">
					<a href="/task/user/register">Nazad</a>
				</div>
			</c:when>
			<c:otherwise>
				<form action="/task/user/save" method="post">
					<h3>Registracija novog korisnika</h3>
					<div class="pt-3 row">
						<label class="pr-3 form-label col-1">Ime </label>
						<input class="form-control col-4" type="text" name="ime" />
					</div>
					<div class="row pt-5 pl-3">
						<button class=" btn btn-primary" type="submit">Registruj</button>
					</div>

				</form>
			</c:otherwise>

		</c:choose>

	</div>
</body>
</html>