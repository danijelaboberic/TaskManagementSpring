<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>



<meta charset="UTF-8">
<title>Razvoj informacionih sistema - predavanja</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
	    <sec:authorize access="isAuthenticated()">
    		<h3> Dobrodošli,	<sec:authentication property="principal.u.name"/></h3>
 		</sec:authorize>
	</div>
</body>
</html>