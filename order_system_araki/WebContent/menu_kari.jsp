<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="dto.MemberDTO" %>
<%@ page import="dto.SeatDTO" %>
<%
	MemberDTO member = (MemberDTO) session.getAttribute("member");
	SeatDTO seat = (SeatDTO) session.getAttribute("seat");
%>
<%
String memberId;
String memberPw;
String memberName;
String memberMail;

	if(member==null){
		memberId="なし";
		memberPw="なし";
		memberName="なし";
		memberMail="なし";
	} else{
		memberId=member.getMemberId();
		memberPw=member.getMemberPw();
		memberName=member.getMemberName();
		memberMail=member.getMemberMail();
	}
%>
<%
int seatId;
String seatMemberId;
int totalNum;
int alcoholNum;

	if(seat==null){
		seatId=0;
		seatMemberId="なし";
		totalNum=0;
		alcoholNum=0;
	}else{
		seatId=seat.getSeatId();
		seatMemberId=seat.getMemberId();
		totalNum=seat.getTotalNum();
		alcoholNum=seat.getAlcoholNum();
	}
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>メニュー</title>
<link rel="stylesheet" href="./css/skyblue.css">
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="./css/helper.css">
</head>
<body>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				メニュー（仮）＋ログアウト処理&nbsp;<span class="icon-coffee"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<%-- action 属性にサーブレットを指定 --%>
			<form name="mainform" action="./logout" method="post">
				<table style="width: 400px" class="table">
					<tr>
						<td class="color-main text-left">名前 :
						<%= memberName %></td>
					</tr>
					<tr>
						<td class="color-main text-left">メールアドレス :
						<%= memberMail %></td>
					</tr>
					<tr>
						<td class="color-main text-left">パスワード :
						<%= memberPw %></td>
					</tr>
					<tr>
						<td class="color-main text-left">ID :
						<%= memberId %></td>
					</tr>
					<tr>
						<td class="color-main text-left">座席番号 :
						<%= seatId %></td>
					</tr>
					<tr>
						<td class="color-main text-left">ID :
						<%= seatMemberId %></td>
					</tr>
					<tr>
						<td class="color-main text-left">合計人数 :
						<%= totalNum %></td>
					</tr>
					<tr>
						<td class="color-main text-left">酒を飲む人数 :
						<%= alcoholNum %></td>
					</tr>
					<tr>
						<td colspan="2" class="text-cener"><input class="btn"
							type="submit" value="リセット" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
