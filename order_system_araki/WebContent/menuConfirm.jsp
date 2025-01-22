<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.TempOrderDTO2"%>

<%
Object tempListObj = session.getAttribute("templist");
ArrayList<TempOrderDTO2> list = null;
if (tempListObj instanceof ArrayList<?>) {
    list = (ArrayList<TempOrderDTO2>) tempListObj;
} else {
    // エラーハンドリング
    out.println("templistが見つかりませんでした。");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>login_choice</title>
	<script>
		function setCommand(value) {
			document.mainform.command.value = value;
		}
	</script>
	<link rel="stylesheet" href="./css/skyblue.css">
	<link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
	<link rel="stylesheet" href="./css/helper.css">
</head>
<body>
<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
<%
if (list != null) {
%>
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>数量</th>
		</tr>
<%
 	for(int i = 0; i < list.size(); i++){
    TempOrderDTO2 tem = list.get(i);
 %>
 		<tr>
 			<td><%=tem.getGoodsName() %></td>
 			<td><%=tem.getGoodsPrice() %></td>
 			<td><%=tem.getTempNum() %></td>
 		</tr>
<%
 	}
%>
	</table>
<%
}
%>
</div>
</div>
<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
<strong class="color-main">表示している内容で注文を行います。よろしいでしょうか？</strong>
</div>
</div>
<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
<form name="mainform" action="./orderchoice" method="post">
	<input type="hidden" name="command" value="">
	<br>
	<input class="btn"  type="button" value="訂正する" onClick="setCommand('menu'); this.form.submit();">
	<br>
	<br>
	<input class="btn" type="button" value="注文する" onClick="setCommand('order'); this.form.submit();">
</form>
</div>
</div>
</body>
</html>
