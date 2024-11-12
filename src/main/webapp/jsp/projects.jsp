<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prikaz projekta</title>
</head>
<body>
<jsp:include page="/jsp/menu.jsp" />


<div class="container my-4">

    <h3 class="mb-5">Informacije o projektima</h3>
    <table class="table table-striped table-hover">
        <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Naslov</th>
                <th>Opis</th>
                <th>Rukovodilac</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="project" items="${projects}">
                <tr>
                    <td>${project.idProject}</td>
                    <td>${project.title}</td>
                    <td>${project.description}</td>
                    <td>${project.user.name}</td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <form action="/task/projects/add" method="get">
    <button type="submit" class="mt-5 btn btn-primary">Dodaj projekat</button>
</form>
    
</div>

</body>
</html>