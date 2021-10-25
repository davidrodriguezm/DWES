<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>confirmar.jsp</title>
</head>
<body>
	<jsp:useBean id="reserva" scope="request" class="org.iesalixar.drodriguezm.model.Reserva"/>
	<% 
	if(reserva != null) { %>
		<h3>Fecha de inicio: <%= reserva.getInicio() %></h3> 
		<h3>Fecha de fin: <%= reserva.getFin() %></h3>
		<h3>Numero de personas: <%= reserva.getPersonas() %></h3>
		<h3>Servicios reservados:</h3>
		<ul>
		<%
		for (String servicio : reserva.getServicio()) { %>
				<li>Curso: <%=servicio%></li> <%
		}
	}
	%>
		</ul>
</body>
</html>