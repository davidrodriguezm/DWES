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
		<c:when test="${sessionScope.usuario eq null}">
			<form method="post">
    			<label for="usuario"><fmt:message key="inicio.usuario" /></label> 
    			<input type="text" name="usuario" id="usuario" required /><br>
    			<label for="password"><fmt:message key="inicio.password" /></label>
    			<input type="password" name="password" id="password" required /><br>
    			<input type="submit" value="Login" class="btn btn-primary"/>
			</form>
		</c:when>
		<c:otherwise>
			<img src="img/spiderman_rayo.gif" alt="imagen" />
		</c:otherwise>
	</c:choose>

</body>
</html>