<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login.jsp</title>
	<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
	<form method="post">
    	<label for="email"><fmt:message key="inicio.correo" /></label> 
    	<input type="text" name="email" id="email" required /><br>
    	<label for="password"><fmt:message key="inicio.password" /></label>
    	<input type="password" name="password" id="password" required /><br>
    	<input type="submit" value="Login" class="btn btn-primary"/>
	</form>
</body>
</html>