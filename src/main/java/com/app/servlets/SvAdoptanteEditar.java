
package com.app.servlets;

import com.app.logica.Adoptante;
import com.app.logica.ControladoraLogica;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "SvAdoptanteEditar", urlPatterns = {"/SvAdoptanteEditar"})
public class SvAdoptanteEditar extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            Adoptante adoptante = control.buscarUnAdoptante(id);

            if (adoptante == null) {
                response.sendRedirect(request.getContextPath()
                        + "/SvAdoptanteListar?error="
                        + URLEncoder.encode("No existe un adoptante con ese ID.",
                                StandardCharsets.UTF_8));
                return;
            }

            request.setAttribute("adoptante", adoptante);

            request.getRequestDispatcher(
                    "/WEB-INF/vistas/editarAdoptantes.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            response.sendRedirect(request.getContextPath()
                    + "/SvAdoptanteListar?error="
                    + URLEncoder.encode("No se pudo buscar el adoptante.",
                            StandardCharsets.UTF_8));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");

            Adoptante adoptante = new Adoptante(
                    nombre, apellido, telefono, correo);

            adoptante.setId(id);

            control.editarAdoptante(adoptante);

            response.sendRedirect(request.getContextPath()
                    + "/SvAdoptanteListar");

        } catch (Exception e) {
            response.sendRedirect(request.getContextPath()
                    + "/SvAdoptanteListar?error="
                    + URLEncoder.encode(e.getMessage(),
                            StandardCharsets.UTF_8));
        }
    }
}
