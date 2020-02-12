<%@page import="com.centrosanluis.proyectoPCSclase.bean.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	 <div>Hola <%=((Usuario) request.getAttribute("usuario")).getNombre() %> <%=((Usuario) request.getAttribute("usuario")).getApellidos() %></div>
</body>
</html>