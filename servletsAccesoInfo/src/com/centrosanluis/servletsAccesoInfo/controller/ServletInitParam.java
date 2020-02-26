package com.centrosanluis.servletsAccesoInfo.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "init-param", urlPatterns = { "/init-param" },initParams = {
		@WebInitParam(name="rutaLog", value="otra/ruta/txt")
	} , loadOnStartup = 2)
public class ServletInitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String rutaFichero;

	public void init(ServletConfig config) throws ServletException {
		rutaFichero = config.getInitParameter("rutaLog");
		System.out.println(rutaFichero);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
