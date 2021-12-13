<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.usuario ne null}">
	<nav>
		<a href=<%=request.getContextPath()+"/Home"%>>Inicio</a>
		<c:if test="${sessionScope.usuario.role eq 'admin'}">
			<a href=<%=request.getContextPath()+"/Admin/Empleados"%>>Mosotrar Empleados</a>
			<a href=<%=request.getContextPath()+"/Admin/AddEmpleado"%>>Añadir Empleado</a>
		</c:if>
		<c:choose>
			<c:when test="${sessionScope.usuario.role eq 'usuario'}">
				<span>ZONA DE USUARIO</span>
			</c:when>
			<c:otherwise>
				<span>ZONA DE ADMINISTRACION</span>
			</c:otherwise>
		</c:choose>
		<a href=<%=request.getContextPath()+"/LogOut"%> class="btn btn-primary">Salir</a>
	</nav>
</c:if>
