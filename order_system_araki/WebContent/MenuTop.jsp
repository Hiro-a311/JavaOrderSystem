<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>おすすめ一覧</title>
	<link rel="stylesheet" href="./css/skyblue.css">
	<link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
	<link rel="stylesheet" href="./css/helper.css">
	<script type="text/javascript">
    	function setCommand(command) {
        	document.mainform.command.value = command;
    	}
	</script>
</head>
<body>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
    		<h1>おすすめ一覧</h1>
    	</div>
	</div>
    		<table style="width: 400px" class="table">
        	<tr>
            	<th>料理名</th>
            	<th>価格</th>
            	<th>画像</th>
        	</tr>
        		<c:forEach var="goods" items="${goodsList}">
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

			<!-- 仮注文テーブル -->
    		<table style="width: 400px" class="table">
        	<tr>
            	<th>料理名</th>
            	<th>価格</th>
        	</tr>
        		<c:forEach var="goods" items="${TempOrderList}">
            		<tr>
                		<td>${goods.goodsName}</td>
                		<td>${goods.goodsPrice}円</td>
                		<%-- 注文確定ボタンを押すと、注文確認画面へ遷移する --%>
           			</tr>
        		</c:forEach>
        		<form name="mainform" action="menuConfirm.jsp" method="post">
	 				<input type="submit" name="command" value="注文" class="btn">
	 			</form>
    		</table>

    <!--
   <%-- action 属性にサーブレットを指定 --%>
			<form name="mainform" action="./goodsClass2" method="get">
				<input type="hidden" name="command" value="">
				<br>
					<input class="btn"  type="button" value="アルコール" onClick="setCommand('alcohol'); this.form.submit();">
				<br>
			</form>
	 -->
	 		<form name="mainform" action="./goodsClass2" method="post">
	 			<input type="submit" name="command" value="アルコール" class="btn">
	 			<!-- command = アルコール をGoodsClass2Servletへ送る -->
	 		</form>

			<form name="mainform" action="./goodsClass3" method="post">
				<input type="submit" name="command" value="ソフトドリンク" class="btn">
				<!-- command = ソフトドリンク をGoodsClass3Servletへ送る -->
			</form>
	</body>
</html>
