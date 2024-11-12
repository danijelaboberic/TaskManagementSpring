<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">

    <style>
        .invalid {
            color: red;
        }
    </style>
</head>
<body>
<jsp:include page="/jsp/menu.jsp" />
  <div class="container my-4">
	<h3 class="mb-5">Registracija novog projekta</h3>
	<sf:form action="/task/projects/save" method="post" modelAttribute="project">
	  <div class="pt-3 row mb-3">
	    <label  class="col-2 form-label">Naslov projekta</label>
	    <sf:input type="text" class="col-4 form-control" path="title"/>
	    <sf:errors path="title" class="pl-3 invalid"></sf:errors>
	  </div>
	  <div class="row mb-3">
	    <label  class="col-2 form-label">Opis</label>
	    <sf:textarea class="col-4 form-control" path="description"></sf:textarea>
	    <sf:errors path="description" class="pl-3 invalid"></sf:errors>
	  </div>
	  <div class="row mb-3">
	    <label  class="col-2 form-label">Rukovodilac</label>
		<sf:select class="col-4 form-select" path="user" items="${leaders}" itemValue="idUser" itemLabel="name"/>
	  </div>
  <button type="submit" class="mt-5 btn btn-primary">Sačuvaj</button>
</sf:form>
  </div>
</body>
</html>