<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setBundle basename="interface" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>adminInicio.jsp</title>
	<jsp:include page="../include/bootstrap.jsp"/>
</head>
<body>
	<jsp:include page="../include/menu.jsp"/>
	
	<div class="container mt-5">
		<div class="row justify-content-center mt-5">
			<div class="col-12">
				<table class="table table-striped table-hover">
					<thead>
						<th>Codigo</th>
						<th>Nombre</th>
						<th>Categoria</th>
						<th>Stock</th>
						<th>Precio</th>
						<th>Acciòn</th>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="product">
							<tr>
								<td>${product.productCode}</td>
								<td>${product.productName}</td>
								<td>${product.productLine}</td>
								<td>${product.quantityInStock}</td>
								<td>${product.buyPrice}</td>
								<td><a href="Admin/EditarProduct?productCode=${product.productCode}">editar</a></td>
							<tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>