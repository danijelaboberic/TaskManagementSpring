<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><st:message code="project.list.title"/></title>
</head>
<body>
<jsp:include page="/jsp/menu.jsp" />


<div class="container my-4">

    <h3 class="mb-5"><st:message code="project.list.heading"/></h3>
    <table class="table table-striped table-hover">
        <thead class="thead-dark">
            <tr>
                <th><st:message code="project.id"/></th>
                <th><st:message code="project.title"/></th>
                <th><st:message code="project.description"/></th>
                 <th><st:message code="project.picture"/></th>
                <th><st:message code="project.leader"/></th>
                <th></th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach var="project" items="${projects}">
                <tr>
                    <td>${project.idProject}</td>
                    <td>${project.title}</td>
                    <td>${project.description}</td>
                    <td>
                    <a href="/task/projects/show/${project.idProject}" target="blank">
                    <img alt="" class="img-thumbnail" src="/task/projects/show/${project.idProject}">
                    </a>
                    </td>
                    <td>${project.user.name}</td>
                    <td><a href="/task/projects/manager/contactLeader?email=${project.user.username}"><st:message code="project.contactLeader"/></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <sec:authorize access="hasRole('ADMIN')">
	    <form action="/task/projects/admin/add" method="get">
	    	<button type="submit" class="mt-5 btn btn-primary col-2"><st:message code="project.add"/></button>
		</form>
	</sec:authorize>
    
</div>

</body>
</html>