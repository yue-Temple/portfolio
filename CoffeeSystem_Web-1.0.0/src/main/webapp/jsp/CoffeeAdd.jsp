<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コーヒー在庫入力画面</title>
</head>
<body>
	<h2>コーヒーが足りません</h2>
	<h3>追加するコーヒーの量を入力してください</h3>
	<form method="post" action="TankServlet">
		<input type="text" name="coffee"> <br>
		<hr>
		<input type="submit" value="決定">
		<input type="reset" value="リセット">
	</form>

</body>
</html>