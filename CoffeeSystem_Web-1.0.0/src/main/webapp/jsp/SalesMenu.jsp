<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー表</title>
</head>
<body>
${outMsg}<br>
ID:【${staffid}】
<hr>
	<h1>メニュー一覧</h1>
	

	<form method="post" action="CalcItemServlet">
		<p>
			◆スモール 120円（120ml）: <select name=s_order>
				<option value="0" selected>0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
		</p>
		<p>
			</select><br> ◆トール　 190円（220ml）: <select name=t_order>
				<option value="0" selected>0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
		</p>
		<p>
			</select><br> ◆ビッグ　 250円（300ml）: <select name=b_order>
				<option value="0" selected>0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
		</p>
		</select><br>
		<hr>
		<input type="submit" value="決定">
		<input type="reset"	value="リセット">
 
	</form>
 
</body>
</html>