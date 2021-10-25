<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reservar.jsp</title>
</head>
<body>
	<jsp:include page="logOut.jsp" />
	<form method="post">
		<label for="inicio">Fecha de inicio:</label>
		<input type="date" name="inicio" id="inicio" required/> 
		<br>
		<label for="fin">Fecha de fin:</label>
		<input type="date" name="fin" id="fin" required/> 
		<br>
		<label for="personas">Numero de personas:</label>
		<input type="number" name="personas" id="personas" required/> 
		<br>
		<h3>SERVICIOS:</h3>
		<input type="checkbox" id="Wifi" name="servicio" value="Wifi" >
  		<label for="primero">Wifi</label><br>
  		<input type="checkbox" id="Limpieza" name="servicio" value="Limpieza" >
  		<label for="segundo">Limpieza</label><br>
  		<input type="checkbox" id="Toallas" name="servicio" value="Toallas" >
  		<label for="primero">Toallas</label><br>
  		<input type="checkbox" id="Ruta guiada" name="servicio" value="Ruta guiada" >
  		<label for="segundo">Ruta guiada</label><br>
  		<input type="checkbox" id="Desayuno" name="servicio" value="Desayuno" >
  		<label for="primero">Desayuno</label><br>
  		<input type="checkbox" id="Sauna" name="servicio" value="Sauna" >
  		<label for="segundo">Sauna</label><br>
  		<br>
		<input name="RESERVAR" type="submit" value="RESERVAR" />
	</form>
</body>
</html>