<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>productsTabla.jsp</title>
	<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
    <jsp:include page="include/menu.jsp"/>
    <br><br>
    <c:choose>
		<c:when test="${mensage ne null}">
			<h3>${mensage}</h3>
			<a href=<%=request.getContextPath()+"/Home"%>>Inicio</a>
		</c:when>
		<c:otherwise>
			<div class="container mt-5">
				<h1>Productos categoria ${productLine}</h1><br>
				<div class="row justify-content-center mt-5">
					<div class="col-12">
						<table class="table table-striped table-hover">
							<thead>
								<th>Nombre</th>
								<th>Descripcion</th>
								<th>Fabricante</th>
								<th>Precio Compra</th>
								<th>Stock</th>
							</thead>
							<tbody>
								<c:forEach items="${products}" var="product">
									<tr>
										<td>${product.productName}</td>
										<td>${product.productDescription}</td>
										<td>${product.productVendor}</td>
										<td>${product.buyPrice}</td>
										<td>${product.quantityInStock}</td>
									<tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>		
		</c:otherwise>
	</c:choose>	
</body>
</html>