
<%@page import="com.app.logica.Gato"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar gatos</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body>

	<h1>Resultados de búsqueda</h1>

	<%
	String nombre = (String) request.getAttribute("nombreBuscado");
	String error = (String) request.getAttribute("error");
	List<Gato> gatos = (List<Gato>) request.getAttribute("gatos");
	%>

	<%
	if (error != null) {
	%>

	<p><%=error%></p>

	<%
	} else {
	%>

	<h2>
		Buscaste:
		<%=nombre%></h2>

	<%
	if (gatos != null && !gatos.isEmpty()) {
	%>

	<table>
		<tr>
			<th>Nombre</th>
			<th>Edad</th>
			<th>Raza</th>
			<th>Sexo</th>
			<th>Peso</th>
		</tr>

		<%
		for (Gato gato : gatos) {
		%>
		<tr>
			<td><%=gato.getNombre()%></td>
			<td><%=gato.getEdad()%></td>
			<td><%=gato.getRaza()%></td>
			<td><%=gato.getSexo()%></td>
			<td><%=gato.getPeso()%></td>
		</tr>
		<%
		}
		%>

	</table>

	<%
	} else {
	%>

	<p>No se encontraron gatos con ese nombre.</p>

	<%
	}
	%>

	<%
	}
	%>

	<br>

	<a href="${pageContext.request.contextPath}/index.html"> Volver al
		inicio </a>

</body>
</html>
