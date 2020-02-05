package com.centrosanluis.practica1.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EntradaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String mensajeEntrada = "";
	FileWriter fw;

	public void init(ServletConfig config) throws ServletException {
		// Leer el fichero entrada
		try {
			BufferedReader bf = new BufferedReader(new FileReader("C://EntornoProgramac/eclipseluna/workspace/practica1/WebContent/ficheros/entrada.txt"));
			mensajeEntrada = bf.readLine();
			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Crear el FileOutputStream pintar la salida
		try {
			fw = new FileWriter(new File("C://EntornoProgramac/eclipseluna/workspace/practica1/WebContent/ficheros/salida.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void destroy() {
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje = request.getParameter("mensaje");
		
		registro(mensaje);
		
		PrintWriter pw = response.getWriter();
		pw.print(mensajeEntrada);
	}
	
	synchronized private void registro(String texto) throws IOException{
		fw.write(texto);
		fw.flush();
	}

}
