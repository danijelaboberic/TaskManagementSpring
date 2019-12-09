<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<title>Primeri JSTL Funkcija</title>
</head>

<body>
	<h4>Primer contains funkcije</h4>
	<c:set var="theString" value="I am a test String" />
	<p>Test recenica je: ${ theString}</p>
		<c:if test="${fn:contains(theString, 'test')}">
			<p>Recenica sadrzi rec test</p>

		</c:if>
	<hr>
	<h4>Primer replace funkcije</h4>
	
	<c:set var="string1" value="This is first String." />
	<p>Prvi string je: ${string1}</p>
	<c:set var="string2" value="${fn:replace(string1, 'first', 'second')}" />
	<p>Nakon zamene first->second dobijamo : ${string2}</p>
</body>
</html>