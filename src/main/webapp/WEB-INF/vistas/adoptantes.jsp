<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List, com.app.logica.Adoptante" %>

<%
    List<Adoptante> adoptantes =
        (List<Adoptante>) request.getAttribute("adoptantes");

    String error = request.getParameter("error");
%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Adoptantes</title>

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

    <% if (error != null) { %>
        <div class="error"><%= error %></div>
    <% } %>

    <h2>Adoptantes registrados</h2>

    <table>

        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Teléfono</th>
            <th>Correo</th>
            <th>Acciones</th>
        </tr>

        <% if (adoptantes == null || adoptantes.isEmpty()) { %>

            <tr>
                <td colspan="6" class="vacio">
                    Todavía no hay adoptantes registrados.
                </td>
            </tr>

        <% } else {
            for (Adoptante a : adoptantes) { %>

                <tr>
                    <td><%= a.getId() %></td>
                    <td><%= a.getNombre() %></td>
                    <td><%= a.getApellido() %></td>
                    <td><%= a.getTelefono() %></td>
                    <td><%= a.getCorreo() %></td>

                    <td class="acciones">

                        <a class="boton"
                           href="${pageContext.request.contextPath}/SvAdoptanteEditar?id=<%= a.getId() %>">
                            Editar
                        </a>

                        <form action="${pageContext.request.contextPath}/SvAdoptanteEliminar"
                              method="post"
                              onsubmit="return confirm('¿Eliminar este adoptante?');">

                            <input type="hidden" name="id"
                                   value="<%= a.getId() %>">

                            <button type="submit" class="peligro">
                                Eliminar
                            </button>

                        </form>

                    </td>
                </tr>

        <%  }
           } %>

    </table>

    <h2>Registrar nuevo adoptante</h2>

    <form class="formulario"
          action="${pageContext.request.contextPath}/SvAdoptanteCrear"
          method="post">

        <label>
            Nombre
            <input type="text" name="nombre" required>
        </label>

        <label>
            Apellido
            <input type="text" name="apellido" required>
        </label>

        <label>
            Teléfono
            <input type="tel" name="telefono" required>
        </label>

        <label>
            Correo electrónico
            <input type="email" name="correo" required>
        </label>

        <button type="submit">Guardar adoptante</button>

    </form>

</main>

<footer>
    Proyecto Gatitos - Registro y adopción
</footer>

</body>
</html>