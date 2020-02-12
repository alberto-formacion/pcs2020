package com.centrosanluis.proyectoPCSclase.model;

import com.centrosanluis.proyectoPCSclase.bean.Usuario;

public class UsuarioDAO {

	public Usuario login(String user, String pass) {
		if("alberto".equals(user) && "1234".equals(pass)) {
			return new Usuario("Alberto", "Garcia de Cortazar", "alberto", "1234");
		}else {
			return null;
		}
	}

}
