<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.usuario ne null}">
	<nav>
		<a href=<%=request.getContextPath()+"/"%>>Inicio</a>
		<span>Está usted logueado como: ${usuario.nombre} ${usuario.firstName} ${usuario.lastName}</span>
		<c:if test="${sessionScope.usuario.rol eq 'usuario'}">
			<a href=<%=request.getContextPath()+"/Oficinas"%>>Buscar oficinas</a>
		</c:if>
		<a href=<%=request.getContextPath()+"/LogOut"%> class="btn btn-primary">Salir</a>
	</nav>
</c:if>
