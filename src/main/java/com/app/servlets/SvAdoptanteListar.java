package com.app.servlets;

import com.app.logica.ControladoraLogica;
import com.app.logica.Adoptante;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
 
@WebServlet("/SvAdoptanteListar")
public class SvAdoptanteListar extends HttpServlet {

    private ControladoraLogica control = new ControladoraLogica();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtenemos todos los adoptantes.
        List<Adoptante> adoptantes = control.listarAdoptantes();

        // Guardamos la lista con el nombre que espera adoptantes.jsp.
        request.setAttribute("adoptantes", adoptantes);

        // Mostramos el JSP.
        request.getRequestDispatcher("/WEB-INF/vistas/adoptantes.jsp")
               .forward(request, response);
    }
}