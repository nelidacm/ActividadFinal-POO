package com.app.servlets;

import com.app.logica.ControladoraLogica;
import com.app.logica.Gato;
import com.app.logica.Adoptante;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/SvGatoCrear")
public class SvGatoCrear extends HttpServlet {

    private ControladoraLogica control = new ControladoraLogica();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {
            // Leemos los datos del formulario.
            String nombre = request.getParameter("nombre");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String raza = request.getParameter("raza");
            String sexo = request.getParameter("sexo");
            double peso = Double.parseDouble(request.getParameter("peso"));

            // Buscamos el adoptante si se seleccionó uno.
            Adoptante adoptante = null;
            String adoptanteId = request.getParameter("adoptanteId");

            if (adoptanteId != null && !adoptanteId.isEmpty()) {
                adoptante = control.buscarUnAdoptante(
                    Integer.parseInt(adoptanteId)
                );
            }

            // Creamos el objeto Gato.
            Gato gato = new Gato(nombre, edad, raza, sexo, peso, adoptante);

            // Damos de alta el gato.
            control.crearGato(gato);

            // Volvemos al listado.
            response.sendRedirect(request.getContextPath() + "/SvGatoListar");

        } catch (Exception e) {
            String error = URLEncoder.encode(
                e.getMessage(), StandardCharsets.UTF_8
            );

            response.sendRedirect(
                request.getContextPath() + "/SvGatoListar?error=" + error
            );
        }
    }
}