
package com.app.servlets;

import com.app.logica.ControladoraLogica;
import com.app.logica.Gato;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SvGatoBuscar", urlPatterns = { "/SvGatoBuscar" })
public class SvGatoBuscar extends HttpServlet {

	ControladoraLogica control = new ControladoraLogica();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");

		try {
			List<Gato> gatos = control.buscarGatosPorNombre(nombre);

			request.setAttribute("gatos", gatos);
			request.setAttribute("nombreBuscado", nombre);

			request.getRequestDispatcher("/WEB-INF/vistas/buscarGatos.jsp").forward(request, response);

		} catch (Exception e) {

			request.setAttribute("error", e.getMessage());

			request.getRequestDispatcher("/WEB-INF/vistas/buscarGatos.jsp").forward(request, response);
		}
	}
}
