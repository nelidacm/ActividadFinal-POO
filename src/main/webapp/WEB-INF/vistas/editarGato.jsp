<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.app.logica.Gato, com.app.logica.Adoptante, java.util.List" %>

<%
    Gato gato = (Gato) request.getAttribute("gato");
    List<Adoptante> adoptantes = (List<Adoptante>) request.getAttribute("adoptantes");
%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Editar gato</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/estilos.css">
</head>

<body>

<header>
    <h1>Gatitos - Registro y adopción</h1>

    <nav>
        <a href="${pageContext.request.contextPath}/">Inicio</a>
        <a href="${pageContext.request.contextPath}/SvGatoListar">Gatos</a>
        <a href="${pageContext.request.contextPath}/SvAdoptanteListar">Adoptantes</a>
    </nav>
</header>

<main>

    <h2>Editar gato</h2>

    <% if (gato == null) { %>

        <div class="error">
            No se recibió ningún gato para editar.
        </div>

        <a class="boton secundario"
           href="${pageContext.request.contextPath}/SvGatoListar">
            Volver
        </a>

    <% } else { %>

        <form class="formulario"
              action="${pageContext.request.contextPath}/SvGatoEditar"
              method="post">

            <input type="hidden" name="id"
                   value="<%= gato.getId() %>">

            <label>
                Nombre
                <input type="text" name="nombre"
                       value="<%= gato.getNombre() %>" required>
            </label>

            <label>
                Edad
                <input type="number" name="edad"
                       min="0" value="<%= gato.getEdad() %>" required>
            </label>

            <label>
                Raza
                <input type="text" name="raza"
                       value="<%= gato.getRaza() %>" required>
            </label>

            <label>
                Sexo
                <select name="sexo" required>
                    <option value="Hembra"
                        <%= "Hembra".equals(gato.getSexo()) ? "selected" : "" %>>
                        Hembra
                    </option>

                    <option value="Macho"
                        <%= "Macho".equals(gato.getSexo()) ? "selected" : "" %>>
                        Macho
                    </option>
                </select>
            </label>

            <label>
                Peso (kg)
                <input type="number" name="peso"
                       step="0.1" min="0.1"
                       value="<%= gato.getPeso() %>" required>
            </label>

            <label>
                Adoptante
                <select name="adoptanteId">

                    <option value="">Sin adoptante</option>

                    <% if (adoptantes != null) {
                        for (Adoptante a : adoptantes) {
                            boolean seleccionado =
                                gato.getAdoptante() != null &&
                                gato.getAdoptante().getId() == a.getId();
                    %>

                        <option value="<%= a.getId() %>"
                            <%= seleccionado ? "selected" : "" %>>
                            <%= a.getNombre() %> <%= a.getApellido() %>
                        </option>

                    <%  }
                       } %>

                </select>
            </label>

            <div>
                <button type="submit">Guardar cambios</button>

                <a class="boton secundario"
                   href="${pageContext.request.contextPath}/SvGatoListar">
                    Cancelar
                </a>
            </div>

        </form>

    <% } %>

</main>

<footer>
    Proyecto Gatitos - Registro y adopción
</footer>

</body>
</html>