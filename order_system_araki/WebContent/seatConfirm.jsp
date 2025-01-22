<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>席確認</title>
</head>
<body>
	<p></p>
	<h4>注文確認</h4>
	<p></p>
	<form action="orderlistdisplay" method="post">
	<p>テーブル番号</p>
		<select name="seatId">
			<option value="3">3番テーブル
			<option value="2">2番テーブル
			<option value="1">1番テーブル
		</select>
	<br>
	<input type="submit" name="command" value="はい">
	<input type="submit" name="command" value="いいえ"><br>

	</form>
</body>
</html>