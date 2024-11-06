<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap JS and dependencies -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Prikaz projekta</title>
</head>
<body>
<div class="container my-4">
    <h3>Informacije o projektima</h3>
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
</div>

</body>
</html>