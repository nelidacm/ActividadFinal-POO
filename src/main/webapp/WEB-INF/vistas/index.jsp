<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gatitos - Inicio</title>

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

    <h2>Bienvenidos</h2>

    <p>
        Este sistema permite registrar gatos y adoptantes,
        consultar sus datos y administrar las adopciones.
    </p>

    <section class="tarjetas">

        <a class="tarjeta"
           href="${pageContext.request.contextPath}/SvGatoListar">

            <h3>🐱 Gatos</h3>

            <p>Registrar nuevos gatos, consultar sus datos y modificarlos.</p>

            <span class="boton">Ver gatos</span>
        </a>

        <a class="tarjeta"
           href="${pageContext.request.contextPath}/SvAdoptanteListar">

            <h3>❤️ Adoptantes</h3>

            <p>Registrar personas interesadas en adoptar y consultar sus datos.</p>

            <span class="boton">Ver adoptantes</span>
        </a>

    </section>

</main>

<footer>
    Proyecto Gatitos - Registro y adopción
</footer>

</body>
</html>