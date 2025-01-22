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
				新規会員登録&nbsp;<span class="icon-coffee"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-left">
			<strong class="color-main">メールアドレスとパスワードを入力してください</strong>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<%-- action 属性にサーブレットを指定 --%>
			<form name="mainform" action="./newMem" method="post">
				<table style="width: 400px" class="table">
				<tr>
						<td class="color-main text-left">名前</td>
						<td class="text-left"><input class="form-control" type="text"
							name="memberName" value="" size="20" /></td>
					</tr>
					<tr>
						<td class="color-main text-left">メールアドレス</td>
						<td class="text-left"><input class="form-control" type="text"
							name="memberMail" value="" size="20" /></td>
					</tr>
					<tr>
						<td class="color-main text-left">パスワード(英数6文字以内)</td>
						<td class="text-left"><input class="form-control"
							type="password" name="memberPw" value="" size="6" maxlength="6" /></td>
					</tr>
					<tr>
						<td class="color-main text-left">パスワード(確認用)</td>
						<td class="text-left"><input class="form-control"
							type="password" name="memberPwCheck" value="" size="6" maxlength="6" /></td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
						<input type="hidden" name="command" value="">
						<br>
						<input class="btn" type="button" value="新規登録" onClick="setCommand('logNew'); this.form.submit();">
						<br>
						<input class="btn" type="button" value="戻る" onClick="setCommand('logNewReturn'); this.form.submit();">
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
