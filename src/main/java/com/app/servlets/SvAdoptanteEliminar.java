
package com.app.servlets;

import com.app.logica.ControladoraLogica;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "SvAdoptanteEliminar", urlPatterns = {"/SvAdoptanteEliminar"})
public class SvAdoptanteEliminar extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            control.eliminarAdoptante(id);

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
