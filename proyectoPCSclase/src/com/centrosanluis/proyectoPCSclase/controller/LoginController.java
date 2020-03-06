package com.centrosanluis.proyectoPCSclase.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centrosanluis.proyectoPCSclase.bean.Usuario;
import com.centrosanluis.proyectoPCSclase.service.UsuarioService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		usuarioService = new UsuarioService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Usuario usuario = usuarioService.login(request.getParameter("user"), request.getParameter("pass"));
		
		String recordar = request.getParameter("recordar");
		
		if(usuario!=null) {
			if(recordar!=null) {
				StringBuilder valorCookie = new StringBuilder();
				valorCookie.append(usuario.getUser())
					.append("-")
					.append(usuario.getPass());
				Cookie c = new Cookie("auth", valorCookie.toString());
				
				response.addCookie(c);
			}
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher("privado/index.jsp").forward(request, response);;
		}else {
			response.sendRedirect("login.jsp?errorLogin=true");
		}
		
	}

}
