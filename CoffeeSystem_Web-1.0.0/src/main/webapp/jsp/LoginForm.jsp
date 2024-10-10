<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レジ担当者ログインフォーム</title>
</head>
<body>
	<h1>はるみコーヒーシステム</h1>
	<hr>
	<form method="post" action="LoginResultServlet">
		IDとパスワードを入力<br> ID ：<input type="text" name="id"><br>
		パスワード：<input type="password" name="pass"><br> <input
			type="submit" value="ログイン"> <input type="reset" value="リセット">

	</form>

</body>
</html>