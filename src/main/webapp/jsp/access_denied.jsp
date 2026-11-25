<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>



<meta charset="UTF-8">
<title><st:message code="app.title"/></title>
</head>
<body>
	<%@include file="/jsp/menu.jsp"%>
	<div class="container">
	<st:message code="access.denied"/>
	</div>
</body>
</html>