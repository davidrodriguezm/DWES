<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>inicio.jsp</title>
</head>
<body>
	<jsp:include page="logOut.jsp" />
	<%
	if (session.isNew() || session.getAttribute("usuario") == null || session.getAttribute("sesion") == null) {
	%>
	<h1>CENTRAL DE VIAJES</h1>
	<form method="post">
		<label for="usuario">Usuario:</label>
		<input type="text" name="usuario" id="usuario" required/> 
		<br>
		<label for="password">Password:</label>
		<input type="password" name="password" id="password" required/>
		<br>
		<label for="confirmar">Confirmar Password:</label>
		<input type="password" name="confirmar" id="confirmar" required/>
		<br>
		<label for="email">Email:</label>
		<input type="email" name="email" id="email" required/> 
		<br>
		<input name="REGISTRARSE" type="submit" value="REGISTRARSE" />
	</form>
	<%
	} else {
	%>
		 <img src="" alt="gris" style="background-color: grey;" width="500" height="600"> 
	<%
	}
	%>
</body>
</html>