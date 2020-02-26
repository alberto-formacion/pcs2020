package com.centrosanluis.servletsAccesoInfo.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "contexto", urlPatterns = { "/contexto" }, loadOnStartup = 1)
public class ServletContexto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String rutaFichero;

	public void init(ServletConfig config) throws ServletException {
		rutaFichero = config.getServletContext().getInitParameter("rutaLog");
		System.out.println(rutaFichero);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
