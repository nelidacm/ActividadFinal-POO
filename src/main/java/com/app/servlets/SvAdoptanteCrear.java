package com.app.servlets;

import com.app.logica.ControladoraLogica;
import com.app.logica.Adoptante;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/SvAdoptanteCrear")
public class SvAdoptanteCrear extends HttpServlet {

    private ControladoraLogica control = new ControladoraLogica();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {
            // Leemos los datos del formulario.
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");

            // Creamos el objeto Adoptante.
            Adoptante adoptante = new Adoptante(
                nombre, apellido, telefono, correo
            );

            // Damos de alta el adoptante.
            control.crearAdoptante(adoptante);

            // Volvemos al listado.
            response.sendRedirect(
                request.getContextPath() + "/SvAdoptanteListar"
            );

        } catch (Exception e) {
            String error = URLEncoder.encode(
                e.getMessage(), StandardCharsets.UTF_8
            );

            response.sendRedirect(
                request.getContextPath() + "/SvAdoptanteListar?error=" + error
            );
        }
    }
}
