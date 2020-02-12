<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form action="login" method="get">
	<div><input type="text" name="user" placeholder="Usuario"></div>
	<div><input type="password" name="pass" placeholder="Contraseña"></div>
	<button type="submit">Entrar</button>
	<%if(request.getParameter("errorLogin")!=null){ %>
		<div>Usuario o Contraseña erroneos</div>
	<%} %>
</form>
</body>
</html>