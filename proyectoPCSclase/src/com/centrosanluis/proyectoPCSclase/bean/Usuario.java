package com.centrosanluis.proyectoPCSclase.bean;

public class Usuario {
	
	private String nombre;
	private String apellidos;
	private String user;
	private String pass;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String apellidos, String user, String pass) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.user = user;
		this.pass = pass;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
