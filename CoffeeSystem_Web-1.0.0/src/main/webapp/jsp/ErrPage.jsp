<%@ page language="java" contentType="text/html; charset=UTF-8" isErrorPage="true"
	pageEncoding="UTF-8"%>
<% session.invalidate(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エラー画面</title>
</head>
<body>
	<h1>エラー画面</h1>
	<h2>${outMsg}</h2>
	<a href="LoginFormServlet">ログインフォーム</a>
</body>
</html>