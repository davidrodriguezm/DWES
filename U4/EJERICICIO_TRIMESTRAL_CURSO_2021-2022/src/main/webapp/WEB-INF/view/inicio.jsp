<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>inicio.jsp</title>
	<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
	<jsp:include page="include/menu.jsp"/>
	<c:choose>
		<c:when test="${sessionScope.usuario ne null and sessionScope.usuario.role eq 'usuario'}">
			<c:if test="${productLines ne null}">
				<h3>Categorias disponibles</h3>
				<ul>
					<c:forEach items="${productLines}" var="lines">
						<li><a href=<%=request.getContextPath()+"/MostrarProductos?productLine="%>${lines.productLine}>${lines.productLine}</a></li>
					</c:forEach>
				</ul>	
			</c:if>
		</c:when>
		<c:when test="${sessionScope.usuario ne null and sessionScope.usuario.role eq 'admin'}">
			<ul>
				<li><a href=<%= request.getContextPath()+"/Admin/Empleados"%> >Mosotrar Empleados</a></li>
				<li><a href=<%= request.getContextPath()+"/Admin/AddEmpleado"%> >Añadir Empleado</a></li>
			</ul>
		</c:when>
	</c:choose>
</body>
</html>