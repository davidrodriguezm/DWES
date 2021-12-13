<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>employeesTabla.jsp</title>
	<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
    <jsp:include page="include/menu.jsp"/>
    <br><br>
    <div class="container mt-5">
		<h1>Empleados</h1><br>
		<div class="row justify-content-center mt-5">
			<div class="col-12">
				<table class="table table-striped table-hover">
					<thead>
						<th>Numero</th>
						<th>Apellidos</th>
						<th>Nombre</th>
						<th>Puesto</th>
						<th>Oficina</th>
						<th>Jefe</th>						
					</thead>
					<tbody>
						<c:forEach items="${employees}" var="emp">
							<tr>
								<td>${emp.employeeNumber}</td>
								<td>${emp.lastName}</td>
								<td>${emp.firstName}</td>
								<td>${emp.jobTitle}</td>
								<c:forEach items="${offices}" var="offi">
									<c:choose>
										<c:when test="${emp.officeCode eq offi.officeCode}">
											<td>${offi.city}</td>
									</c:when>
										<c:otherwise>
											<td>${emp.officeCode}</td>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:forEach items="${employees}" var="jefe">
									<c:choose>
										<c:when test="${emp.reportsTo eq jefe.employeeNumber}">
											<td>${jefe.employeeNumber}</td>
									</c:when>
										<c:otherwise>
											<td>${emp.reportsTo}</td>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>	
</body>
</html>