<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<h3>Primer upotrebe skripleta</h3>
	<table border=1>
		<tr>
			<td>R.br.</td>
			<td>Ime</td>
		</tr>
		<%
			String names[] = { "Bata", "Pera", "Mika", "Laza", "Sima" };
			for (int i = 0; i < names.length; i++) {
		%>
		<tr>
			<td><%=i%></td>
			<td><%=names[i]%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%@include file="footer.jsp"%>
</body>
</html>
