<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page
	import="java.util.List, com.app.logica.Gato, com.app.logica.Adoptante"%>

<%
List<Gato> gatos = (List<Gato>) request.getAttribute("gatos");
List<Adoptante> adoptantes = (List<Adoptante>) request.getAttribute("adoptantes");
String error = request.getParameter("error");
%>

<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Gatos</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css">
</head>

<body>

	<header>
		<h1>Gatitos - Registro y adopción</h1>

		<nav>
			<a href="${pageContext.request.contextPath}/">Inicio</a> <a
				href="${pageContext.request.contextPath}/SvGatoListar">Gatos</a> <a
				href="${pageContext.request.contextPath}/SvAdoptanteListar">Adoptantes</a>
		</nav>
	</header>

	<main>

		<%
		if (error != null) {
		%>
		<div class="error"><%=error%></div>
		<%
		}
		%>

		<h2>Gatos registrados</h2>

		<table>

			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Raza</th>
				<th>Sexo</th>
				<th>Peso</th>
				<th>Adoptante</th>
				<th>Acciones</th>
			</tr>

			<%
			if (gatos == null || gatos.isEmpty()) {
			%>

			<tr>
				<td colspan="8" class="vacio">Todavía no hay gatos registrados.
				</td>
			</tr>

			<%
			} else {
			for (Gato g : gatos) {
			%>

			<tr>
				<td><%=g.getId()%></td>
				<td><%=g.getNombre()%></td>
				<td><%=g.getEdad()%></td>
				<td><%=g.getRaza()%></td>
				<td><%=g.getSexo()%></td>
				<td><%=g.getPeso()%> kg</td>

				<td>
					<%
					if (g.getAdoptante() != null) {
					%> <%=g.getAdoptante().getNombre()%>
					<%=g.getAdoptante().getApellido()%> <%
 } else {
 %> Sin adoptante <%
 }
 %>
				</td>

				<td class="acciones"><a class="boton"
					href="${pageContext.request.contextPath}/SvGatoEditar?id=<%= g.getId() %>">
						Editar </a>

					<form action="${pageContext.request.contextPath}/SvGatoEliminar"
						method="post" onsubmit="return confirm('¿Eliminar este gato?');">

						<input type="hidden" name="id" value="<%=g.getId()%>">

						<button type="submit" class="peligro">Eliminar</button>

					</form></td>
			</tr>

			<%
			}
			}
			%>

		</table>

		<h2>Registrar nuevo gato</h2>

		<form class="formulario"
			action="${pageContext.request.contextPath}/SvGatoCrear" method="post">

			<label> Nombre <input type="text" name="nombre" required>
			</label> <label> Edad <input type="number" name="edad" min="0"
				required>
			</label> <label> Raza <input type="text" name="raza" required>
			</label> <label> Sexo <select name="sexo" required>
					<option value="">Seleccionar</option>
					<option value="Hembra">Hembra</option>
					<option value="Macho">Macho</option>
			</select>
			</label> <label> Peso (kg) <input type="number" name="peso"
				step="0.1" min="0.1" required>
			</label> <label> Adoptante <select name="adoptanteId">
					<option value="">Sin adoptante</option>

					<%
					if (adoptantes != null) {
						for (Adoptante a : adoptantes) {
					%>

					<option value="<%=a.getId()%>">
						<%=a.getNombre()%>
						<%=a.getApellido()%>
					</option>

					<%
					}
					}
					%>

			</select>
			</label>

			<button type="submit">Guardar gato</button>

		</form>

	</main>

	<footer> Proyecto Gatitos - Registro y adopción </footer>

</body>
</html>