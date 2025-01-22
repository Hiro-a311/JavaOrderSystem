<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>人数入力</title>
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
				人数入力&nbsp;<span class="icon-coffee"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
	<form name="mainform" action="./seat" method="post">
		<table style="width: 400px" class="table">
			<tr>
				<td class="color-main text-left">座席番号</td>
				<td class="text-left">
					<select class="form-control" name="seatId">
						<% for (int i = 1; i <= 10; i++) { %>
						<option value="<%= i %>"><%= i %></option>
						<% } %>
					</select>
				</td>
			</tr>
			<tr>
				<td class="color-main text-left">お酒を飲む人数</td>
				<td class="text-left">
					<select class="form-control" name="alcohoNum">
						<% for (int i = 0; i <= 20; i++) { %>
						<option value="<%= i %>"><%= i %></option>
						<% } %>
					</select>
				</td>
			</tr>
			<tr>
				<td class="color-main text-left">お酒を飲まない人数</td>
				<td class="text-left">
					<select class="form-control" name="nonAlcohoNum">
						<% for (int i = 0; i <= 20; i++) { %>
						<option value="<%= i %>"><%= i %></option>
						<% } %>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="text-center">
					<input type="hidden" name="command" value="">
					<br>
					<input class="btn" type="button" value="登録" onClick="setCommand('number'); this.form.submit();">
					<br>
				</td>
			</tr>
					<%-- リクエストスコープに alert があれば --%>
					<c:if
						test="${requestScope.alert != null && requestScope.alert != ''}">
						<tr>
							<%-- リクエストスコープの alert の値を出力 --%>
							<td colspan="2" class="color-error text-center"><c:out
									value="${requestScope.alert}" /></td>
						</tr>
					</c:if>
			</table>
		</form>
		</div>
		</div>
</body>
</html>
