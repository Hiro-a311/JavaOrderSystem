<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>order_system - ログイン -</title>
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
				会員情報確認&nbsp;<span class="icon-coffee"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<strong class="color-main">以下の内容で登録しますか？</strong>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<%-- action 属性にサーブレットを指定 --%>
			<form name="mainform" action="./newMem" method="post">
				<table style="width: 400px" class="table">
					<tr>
						<td class="color-main text-left">名前 :
						<%= request.getAttribute("memberName") %></td>
					</tr>
					<tr>
						<td class="color-main text-left">メールアドレス :
						<%= request.getAttribute("memberMail") %></td>
					</tr>
					<tr>
						<td class="color-main text-left">パスワード :
						<%
							String memberPw = (String) request.getAttribute("memberPw");
							if (memberPw != null) {
								for (int i = 0; i < memberPw.length(); i++) {
									out.print("●");
								}
							}
						%></td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
						<input type="hidden" name="memberName" value="<%= request.getAttribute("memberName") %>">
						<input type="hidden" name="memberMail" value="<%= request.getAttribute("memberMail") %>">
						<input type="hidden" name="memberPw" value="<%= request.getAttribute("memberPw") %>">
						<input type="hidden" name="command" value="">
						<br>
						<input class="btn" type="button" value="登録する" onClick="setCommand('logNewCheck'); this.form.submit();">
						<br>
						<input class="btn" type="button" value="戻る" onClick="setCommand('return'); this.form.submit();">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
