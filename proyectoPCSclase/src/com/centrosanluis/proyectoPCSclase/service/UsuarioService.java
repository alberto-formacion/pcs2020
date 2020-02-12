package com.centrosanluis.proyectoPCSclase.service;

import com.centrosanluis.proyectoPCSclase.bean.Usuario;
import com.centrosanluis.proyectoPCSclase.model.UsuarioDAO;

public class UsuarioService {

	public Usuario login(String user, String pass) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.login(user, pass);
	}

}
