<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500</title>
<style>
	h2{
		color:red; font-weight: bold
	}
	h4{
		background-color: black;
		color:yellow;
	}
	li::before{
		content:'치명적인 오류 - '
	}
</style>
</head>
<body>
	<h2>500 Error</h2>
	<h4>${e.getMessage()}</h4>
	<a href="#">백신 프로그램 다운받기</a>
	<ul>
		<c:forEach var="stack" items="${e.getStackTrace()}">
			<!-- StackTrace : 그동안 발생했던 진행 상황들이 쌓여있는것 -->
			<li>${stack}</li>
		</c:forEach>
	</ul>
</body>
</html>