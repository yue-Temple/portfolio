<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
担当スタッフ：【ID_${staffid} 】
<hr>
<title>精算結果</title>
</head>
<body>
	<h1>金種表示</h1>
	<pre>
5000| ×  ${moneycount[0]}
1000| ×  ${moneycount[1]}
 500| ×  ${moneycount[2]}
 100| ×  ${moneycount[3]}
  50| ×  ${moneycount[4]}
  10| ×  ${moneycount[5]}
   5| ×  ${moneycount[6]}
   1| ×  ${moneycount[7]}
   </pre>

	<hr>

	<h1>注文明細</h1>
	<table border="0">
		<tr>
			<th>商品名</th>
			<th>単価</th>
			<th>個数</th>
			<th>金額</th>
		</tr>
		<c:if test="${buy_order[0] > 0}">
			<tr>
				<td>スモール</td>
				<td>${productlist[0].getUnitPrice()}円</td>
				<td>${buy_order[0]}個</td>
				<td>${pricelist[0]}円</td>
			</tr>
		</c:if>
		<c:if test="${buy_order[1] > 0}">
			<tr>
				<td>トール</td>
				<td>${productlist[1].getUnitPrice()}円</td>
				<td>${buy_order[1]}個</td>
				<td>${pricelist[1]}円</td>
			</tr>
		</c:if>
		<c:if test="${buy_order[2] > 0}">
			<tr>
				<td>ビッグ</td>
				<td>${productlist[2].getUnitPrice()}円</td>
				<td>${buy_order[2]}個</td>
				<td>${pricelist[2]}円</td>
			</tr>
		</c:if>
		<tr>
			<td><hr></td>
			<td><hr></td>
			<td><hr></td>
			<td><hr></td>
		</tr>
		<tr>
			<td>総合計額</td>
			<td></td>
			<td></td>
			<td>${money}円</td>
		</tr>
		<tr>
			<td>受け取り金額</td>
			<td></td>
			<td></td>
			<td>${money+change}円</td>
		</tr>
		<tr>
			<td>おつり</td>
			<td></td>
			<td></td>
			<td>${change}円</td>
		</tr>
	</table>


	<br>
	<hr>
	<p>
	<form method="post" action="NextInputServlet">
		<input type="submit" value="次を入力">
	</form></p>
	<p>
	<form method="post" action="AllResultServlet">
		<input type="submit" value="入力を終了する">
	</form></p>
	<br><br>


</body>
</html>