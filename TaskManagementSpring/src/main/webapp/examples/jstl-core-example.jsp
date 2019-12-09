<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Primeri JSTL Core tagova</title>
</head>

<body>
	<h4>Kreiranje tabele pomocu forEach taga</h4>
	<c:set var="listaKorisnika" value="${{'Ana','Marko','Jovan','Sanja'}}" />
	<table border="1">
		<tr>
			<th>Ime</th>
		</tr>
		<c:forEach items="${listaKorisnika}" var="k">
			<tr>
				<td>${k}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>