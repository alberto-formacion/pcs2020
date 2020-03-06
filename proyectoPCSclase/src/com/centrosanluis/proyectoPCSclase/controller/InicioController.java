package com.centrosanluis.proyectoPCSclase.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "inicio", urlPatterns = { "/inicio" })
public class InicioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			StringBuilder url = new StringBuilder("login");
			Cookie cookie = null;
			for (Cookie c : cookies) {
				if ("auth".equals(c.getName())) {
					cookie = c;
				}
			}
			
			if(cookie != null) {
				String usuarioPass = cookie.getValue();
	
				String[] usuarioPassArray = usuarioPass.split("-");
	
				url.append("?")
					.append("user=")
					.append(usuarioPassArray[0])
					.append("&pass=")
					.append(usuarioPassArray[1]);
				
				response.sendRedirect(url.toString());
			}else {
				response.sendRedirect("login.jsp");
			}
			
		}else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
