<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
Текущее время: <%= new java.util.Date() %>
Имя вашего хоста: <%= request.getRemoteHost() %>
</body>
</html>