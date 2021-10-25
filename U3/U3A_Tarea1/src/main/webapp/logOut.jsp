<%
if (!session.isNew() && session.getAttribute("usuario") != null && session.getAttribute("sesion") != null) {
%>
	<h1><a href=<%=request.getContextPath()+"/LogOut"%>>Volver Salir</a></h1>
	<p>Usuario: <%=session.getAttribute("usuario")%>  Sesion: <%=session.getAttribute("sesion")%></p>
	<br>
<%
}
%>