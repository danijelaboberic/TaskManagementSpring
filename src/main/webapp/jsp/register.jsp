<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registracija korisnika</title>
<!-- Bootstrap CSS -->
</head>
<body>
<jsp:include page="/jsp/menu.jsp" />

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
					<h3 class="mb-5"><st:message code="user.register.title"/></h3>
					<div class="pt-3 row">
						<label class="pr-3 form-label col-1"><st:message code="user.name"/> </label>
						<sf:input class="form-control col-4" type="text" path="name" />
					</div>
					<div class="pt-3 row">
						<label class="pr-3 form-label col-1"><st:message code="user.username"/></label>
						<sf:input class="form-control col-4" type="text" path="username" />
					</div>
					<div class="pt-3 row">
						<label class="pr-3 form-label col-1"><st:message code="user.password"/></label>
						<sf:input class="form-control col-4" type="password" path="password" />
					</div>
					<div class="pt-3 row">
						<label class="pr-3 form-label col-1"><st:message code="user.role"/></label>
						    <sf:select class="form-select" path="role" items="${roleList}" itemValue="idrole" itemLabel="name"/>
					</div> 
					<div class="row pt-5 pl-3">
						<button class=" btn btn-primary" type="submit"><st:message code="user.save"/></button>
					</div>

				</sf:form>
			</c:otherwise>

		</c:choose>

	</div>
</body>
</html>