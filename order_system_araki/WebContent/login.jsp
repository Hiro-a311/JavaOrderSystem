<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>login_choice</title>
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
				利用方法選択&nbsp;<span class="icon-coffee"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<strong class="color-main">利用方法を選んでください</strong>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<%-- action 属性にサーブレットを指定 --%>
			<form name="mainform" action="./login" method="post">
				<input type="hidden" name="command" value="">
				<br>
				<input class="btn"  type="button" value="ログイン" onClick="setCommand('logyes'); this.form.submit();">
				<br>
				<br>
				<input class="btn" type="button" value="新規登録" onClick="setCommand('lognew'); this.form.submit();">
				<br>
				<br>
				<input class="btn" type="button" value="ログインせずに使用" onClick="setCommand('number'); this.form.submit();">
			</form>
		</div>
	</div>
</body>
</html>
