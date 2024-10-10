<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>集計画面</title>
</head>
<body>
<h1>一日通算 集計結果</h1>
---商品集計情報---<br>
スモール販売個数: ${totalorderlist[0]}　　（${totalorderlist[0] * productlist[0].getUnitPrice()}円）<br>
　トール販売個数: ${totalorderlist[1]}　　（${totalorderlist[1] * productlist[1].getUnitPrice()}円）<br>
　ビッグ販売個数: ${totalorderlist[2]}　　（${totalorderlist[2] * productlist[2].getUnitPrice()}円）<br>
<hr>
◆合計消費量:${totalorderlist[0] * productlist[0].getUnitAmount() + totalorderlist[1] * productlist[1].getUnitAmount() + totalorderlist[2] * productlist[2].getUnitAmount()}ml<br>
◆合計売上金額:${totalorderlist[0] * productlist[0].getUnitPrice() + totalorderlist[1] * productlist[1].getUnitPrice() + totalorderlist[2] * productlist[2].getUnitPrice()}円<br>
<br>
<br>
</body>
</html>