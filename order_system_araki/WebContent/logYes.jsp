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
</head>
<body>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				ログイン&nbsp;<span class="icon-coffee"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<strong class="color-main">メールアドレスとパスワードを入力してください</strong>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<%-- action 属性にサーブレットを指定 --%>
			<form action="./judge" method="post">
				<table style="width: 400px" class="table">
					<tr>
						<%-- ログインID 入力欄の名前は loginId --%>
						<td class="color-main text-left">メールアドレス</td>
						<td class="text-left"><input class="form-control" type="text"
							name="memberMail" value="" size="20" /></td>
					</tr>
					<tr>
						<%-- パスワード入力欄の名前は password --%>
						<td class="color-main text-left">パスワード</td>
						<td class="text-left"><input class="form-control"
							type="password" name="memberPw" value="" size="6" maxlength="6" /></td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input class="btn" type="submit" value="ログイン" />
							<br>
							<input class="btn" type="button" value="戻る" onclick="window.location.href='login.jsp'" />
						</td>
					</tr>
					<%-- リクエストスコープに alert があれば --%>
					<c:if
						test="${requestScope.alert != null && requestScope.alert != ''}">
						<tr>
							<%-- リクエストスコープの alert の値を出力 --%>
							<td colspan="2" class="color-error text-left"><c:out
									value="${requestScope.alert}" /></td>
						</tr>
					</c:if>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
