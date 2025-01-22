<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>アルコールメニュー</title>
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
    		<h1>アルコール一覧</h1>
    </div>
</div>
    <table style="width: 400px" class="table">
        <tr>
            <th>ドリンク名</th>
            <th>価格</th>
            <th>画像</th>
        </tr>
        <c:forEach var="goods" items="${alcoholList}">
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
	<form action="./goodsClass1" method="post">
	 	<input type="submit" name="command" value="おすすめ" class="btn">
	 	<!-- command = おすすめ をGoodsClass2Servletへ送る -->
	</form>
	<form name="mainform" action="./goodsClass3" method="post">
		<input type="submit" name="command" value="ソフトドリンク" class="btn">
	</form>
</body>
</html>
