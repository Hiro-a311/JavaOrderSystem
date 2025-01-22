<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>order_system - 人数確認 -</title>
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
			<h1>
				人数確認&nbsp;<span class="icon-coffee"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-left">
			<strong class="color-main">以下の内容で登録しますか？</strong>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<%-- action 属性にサーブレットを指定 --%>
			<form name="mainform" action="./seat" method="post">
				<table style="width: 400px" class="table">
					<tr>
						<td class="color-main text-left">座席番号 :
						<%= request.getAttribute("seatId") %></td>
					</tr>
					<tr>
						<td class="color-main text-left">お酒を飲む人 :
						<%= request.getAttribute("alcohoNum") %></td>
					</tr>
					<tr>
						<td class="color-main text-left">お酒を飲まない人 :
						<%= request.getAttribute("nonAlcohoNum") %></td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
						<input type="hidden" name="alcohoNum" value="<%= request.getAttribute("alcohoNum") %>">
						<input type="hidden" name="nonAlcohoNum" value="<%= request.getAttribute("nonAlcohoNum") %>">
						<input type="hidden" name="seatId" value="<%= request.getAttribute("seatId") %>">
						<input type="hidden" name="command" value="">
						<br>
						<input class="btn" type="button" value="登録する" onClick="setCommand('numberCheck'); this.form.submit();">
						<br>
						<input class="btn" type="button" value="戻る" onClick="setCommand('numberCheckReturn'); this.form.submit();">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
