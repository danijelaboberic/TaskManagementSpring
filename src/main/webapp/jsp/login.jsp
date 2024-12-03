<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
	
<!DOCTYPE html>
<html>
<body>
	<%@include file="/jsp/menu.jsp"%>
	<div class="container my-4">
		<form action="${pageContext.request.contextPath}/login" method="post" class="col-4">
			<div class="mb-3">
				<label class="form-label"><st:message code="login.username"/></label> <input type="email"
					class="form-control" name="username">

			</div>
			<div class="mb-3">
				<label class="form-label"><st:message code="login.password"/></label> <input type="password"
					class="form-control" name="password">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>