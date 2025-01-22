<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ソフトドリンクメニュー</title>
<link rel="stylesheet" href="./css/skyblue.css">
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="./css/helper.css">
	<script>
		function setCommand(value) {
			document.mainform.command.value = value;
		}
	</script>
</head>
<body>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>ソフトドリンク一覧</h1>
		</div>
	</div>
    			<table style="width: 400px" class="table">
        			<tr>
            			<th>ドリンク名</th>
           				<th>価格</th>
            			<th>画像</th>
        			</tr>
        			<c:forEach var="goods" items="${softdrinkList}">
        				<tr>
        					<td>${goods.goodsName}</td>
         					<td>${goods.goodsPrice}円</td>
         					<%-- Pictureフォルダの画像名とgoodsPicの名前が一致しているものを出す --%>
         					<td><img src="Picture/${goods.goodsPic}" alt="${goods.goodsName}"/></td>

         					<%-- 追加ボタンを押すと、仮注文テーブルにinsertされる --%>
          					<td><form name="mainform" action="./tempOrder" method="post">
	 						<input type="submit" name="command" value="追加" class="btn"></form></td>
         					</tr>
        			</c:forEach>
     			</table>
     			<form name="mainform" action="menuConfirm.jsp" method="post">
	 				<input type="submit" name="command" value="注文" class="btn">
	 			</form>
	<form name="mainform" action="./goodsClass1" method="post">
	 	<input type="submit" name="command" value="おすすめ"  class="btn">
	 	<!-- command = おすすめ をGoodsClass1Servletへ送る -->
	</form>
		<form name="mainform" action="./goodsClass2" method="post" >
		<input type="submit" name="command" value="アルコール" class="btn">
		<!-- command = アルコール をGoodsClass3Servletへ送る -->
	</form>
</body>
</html>