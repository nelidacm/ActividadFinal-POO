<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.app.logica.Adoptante" %>

<%
    Adoptante adoptante =
        (Adoptante) request.getAttribute("adoptante");
%>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Editar adoptante</title>

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

    <h2>Editar adoptante</h2>

    <% if (adoptante == null) { %>

        <div class="error">
            No se recibió ningún adoptante para editar.
        </div>

        <a class="boton secundario"
           href="${pageContext.request.contextPath}/SvAdoptanteListar">
            Volver
        </a>

    <% } else { %>

        <form class="formulario"
              action="${pageContext.request.contextPath}/SvAdoptanteEditar"
              method="post">

            <input type="hidden" name="id"
                   value="<%= adoptante.getId() %>">

            <label>
                Nombre
                <input type="text" name="nombre"
                       value="<%= adoptante.getNombre() %>" required>
            </label>

            <label>
                Apellido
                <input type="text" name="apellido"
                       value="<%= adoptante.getApellido() %>" required>
            </label>

            <label>
                Teléfono
                <input type="tel" name="telefono"
                       value="<%= adoptante.getTelefono() %>" required>
            </label>

            <label>
                Correo electrónico
                <input type="email" name="correo"
                       value="<%= adoptante.getCorreo() %>" required>
            </label>

            <div>
                <button type="submit">Guardar cambios</button>

                <a class="boton secundario"
                   href="${pageContext.request.contextPath}/SvAdoptanteListar">
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