<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function setCommand(value) {
			document.mainform.command.value = value;
		}
	</script>
</head>
<body>
	<%-- action 属性にサーブレットを指定 --%>
			<form name="mainform" action="./goodsClass1" method="post">
				<input type="submit" name="command" value=	"おすすめ画面へ">
				<br>
			</form>>
</body>
</html>