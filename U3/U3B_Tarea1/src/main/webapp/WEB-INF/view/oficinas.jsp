<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>oficinas.jsp</title>
	<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
	<jsp:include page="include/menu.jsp"/>
	<form method="post">
		<label for="office" class="office">office city</label>
		<select class="form-select" id="office" name="office">
			<c:forEach  items="${offices}" var="o">
				<option value="${o.city}">${o.city}</option>
			</c:forEach>			
		</select>
    	<input type="submit" class="btn btn-primary m-3" value="BUSCAR" />					
	</form>
	
	<c:if test="${offices ne null}">
		<c:forEach items="${officesResul}" var="offi">
			<h3>DATOS DE LA OFICINA DE ${offi.city}</h3>
			<ul>
				<li><b>officeCode: </b>${offi.officeCode}</li>
				<li><b>city: </b>${offi.city}</li>
				<li><b>phone: </b>${offi.phone}</li>
				<li><b>addressLine1: </b>${offi.addressLine1}</li>
				<li><b>addressLine2: </b>${offi.addressLine2}</li>
				<li><b>state: </b>${offi.state}</li>
				<li><b>country: </b>${offi.country}</li>
				<li><b>postalCode: </b>${offi.postalCode}</li>
				<li><b>territory: </b>${offi.territory}</li>
			</ul>
		</c:forEach>
	</c:if>
	
</body>
</html>