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
import java.util.List;

@WebServlet("/SvGatoListar")
public class SvGatoListar extends HttpServlet {

    private ControladoraLogica control = new ControladoraLogica();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtenemos las listas desde la ControladoraLogica.
        List<Gato> gatos = control.listarGatos();
        List<Adoptante> adoptantes = control.listarAdoptantes();

        // Guardamos las listas con los nombres que espera gato.jsp.
        request.setAttribute("gatos", gatos);
        request.setAttribute("adoptantes", adoptantes);

        // Mostramos el JSP.
        request.getRequestDispatcher("/WEB-INF/vistas/gato.jsp")
               .forward(request, response);
    }
}