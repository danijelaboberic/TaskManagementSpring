<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Korisnici</title>
</head>
<%@include file="header.jsp"%>
<div class="container">
	<div class="row pt-5">
		<div class="col">
			<c:if test="${not empty users}">
				<h5>Spisak do sada registrovanih korisnika</h5>
				<div class="table-wrapper-scroll-y my-custom-scrollbar">
					<table
						class="table table-hover table-bordered table-sm table-striped">
						<thead class="thead-light">
							<tr>
								<th scope="col">Ime</th>
								<th scope="col">Korisničko ime</th>
								<th scope="col">Uloga</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${users}" var="u">
								<tr>
									<td>${u.name}</td>
									<td>${u.username}</td>
									<td>${u.role.name}</td>
									<td><sec:authorize access="hasRole('MANAGER')"><a
										href="${pageContext.request.contextPath}/admin/delete/${u.idUser}">
										<i class="fas fa-trash-alt red-text"></i>
										</a>
										
									</sec:authorize>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
		</div>
	</div>
	<div class="row pt-5">
	<sec:authorize access="hasRole('MANAGER')">
		<div class="col">
			<form action="${pageContext.request.contextPath}/admin/add" method="post">
				<fieldset>
					<h5>Registracija novog korisnika</h5>
					<div class="form-group row">
						<label for="ime" class="col-sm-2 col-form-label">Ime:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="ime" name="name">
						</div>
					</div>
					<div class="form-group row">
						<label for="username" class="col-sm-2 col-form-label">Korisničko
							ime:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="username"
								name="username">
						</div>
					</div>
					<div class="form-group row">
						<label for="password" class="col-sm-2 col-form-label">Lozinka:</label>
						<div class="col-sm-10">
							<input type="password" name="password" class="form-control">
						</div>
					</div>
					<div class="form-group row">
						<label for="exampleSelect1" class="col-sm-2 col-form-label">Uloga:</label>
						<div class="col-sm-10">
							<select name="role" class="browser-default custom-select"
								id="exampleSelect1">
								<option value="1">MANAGER</option>
								<option value="2">EMPLOYEE</option>
							</select>
						</div>
					</div>
					<button type="submit" class="btn btn-default">Dodaj</button>
				</fieldset>
			</form>
		</div>
		<div class="col"></div>
	</sec:authorize>
	</div>
</div>
</body>
</html>