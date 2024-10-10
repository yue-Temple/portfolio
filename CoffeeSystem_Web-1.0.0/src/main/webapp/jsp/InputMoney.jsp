<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認・金額入力</title>
</head>
<body>
	<h2>会計確認</h2>
	スモール：${buy_order[0]}個
	　トール：${buy_order[1]}個
	　ビッグ：${buy_order[2]}個<br>
	
	金額：${pricelist[0]+pricelist[1]+pricelist[2]} 円<br>
	<br>
	<h3>▼受け取り金額の入力</h3>
	<form method="post" action="ChangeResultServlet">
		<input type="text" name="pay"> <br>
		<font color="red">${errMSG}</font>
		<hr>
		<input type="submit" value="決定">
		<input type="reset" value="リセット">
	</form>
</body>
</html>