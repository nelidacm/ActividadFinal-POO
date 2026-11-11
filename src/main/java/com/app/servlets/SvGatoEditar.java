
package com.app.servlets;

import com.app.logica.Gato;
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
import java.util.List;

@WebServlet(name = "SvGatoEditar", urlPatterns = {"/SvGatoEditar"})
public class SvGatoEditar extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            Gato gato = control.buscarUnGato(id);

            if (gato == null) {
                response.sendRedirect(request.getContextPath()
                        + "/SvGatoListar?error="
                        + URLEncoder.encode("No existe un gato con ese ID.",
                                StandardCharsets.UTF_8));
                return;
            }

            List<Adoptante> adoptantes = control.listarAdoptantes();

            request.setAttribute("gato", gato);
            request.setAttribute("adoptantes", adoptantes);

            request.getRequestDispatcher(
                    "/WEB-INF/vistas/editarGato.jsp")
                    .forward(request, response);

        } catch (Exception e) {
            response.sendRedirect(request.getContextPath()
                    + "/SvGatoListar?error="
                    + URLEncoder.encode("No se pudo buscar el gato.",
                            StandardCharsets.UTF_8));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String raza = request.getParameter("raza");
            String sexo = request.getParameter("sexo");
            double peso = Double.parseDouble(request.getParameter("peso"));

            String adoptanteId = request.getParameter("adoptanteId");
            Adoptante adoptante = null;

            if (adoptanteId != null && !adoptanteId.isEmpty()) {
                adoptante = control.buscarUnAdoptante(
                        Integer.parseInt(adoptanteId));
            }

            Gato gato = new Gato(nombre, edad, raza, sexo, peso, adoptante);
            gato.setId(id);

            control.editarGato(gato);

            response.sendRedirect(request.getContextPath()
                    + "/SvGatoListar");

        } catch (Exception e) {
            response.sendRedirect(request.getContextPath()
                    + "/SvGatoListar?error="
                    + URLEncoder.encode(e.getMessage(),
                            StandardCharsets.UTF_8));
        }
    }
}
