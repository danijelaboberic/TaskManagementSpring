<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
   <script src="/TaskManagementSpring/js/jquery-3.4.1.min.js"></script>
    <script src="/TaskManagementSpring/js/bootstrap.js"></script> 
   <script src="/TaskManagementSpring/js/mdb.js"></script> 
<meta charset="UTF-8">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
  <!-- Bootstrap core CSS -->
  <link href="/TaskManagementSpring/css/bootstrap.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="/TaskManagementSpring/css/mdb.css" rel="stylesheet">
  <title>Projekat iz razvoja informacionih sistema</title>
</head>
<!--Navbar-->
<nav class="navbar navbar-expand-lg navbar-dark default-color">


  <!-- Collapse button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
    aria-controls="basicExampleNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Collapsible content -->
  <div class="collapse navbar-collapse" id="basicExampleNav">

    <!-- Links -->
     
    <ul class="navbar-nav mr-auto">
    <sec:authorize access="isAuthenticated()">
      <li class="nav-item ">
        <a class="nav-link" href="${pageContext.request.contextPath}/pages/home.jsp">Home
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Projekti</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/users/getAll">Radnici</a>
      </li>
         </sec:authorize>
    </ul>

    <!-- Links -->
  <span class="navbar-text white-text">
 <sec:authorize access="!isAuthenticated()">
 
     <a href="${pageContext.request.contextPath}/pages/login.jsp" class="nav-link">Prijava</a>
  </sec:authorize>
    <sec:authorize access="isAuthenticated()">
     <a href="${pageContext.request.contextPath}/logout" class="nav-link" >Odjava</a>
 </sec:authorize>
    </span>
  </div>
  <!-- Collapsible content -->

</nav> 

<!-- MODAL -->

</html>