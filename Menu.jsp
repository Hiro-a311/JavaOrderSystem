<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="keywords" content="鳥貴族,鳥貴族メニュー,居酒屋,福岡,博多,おすすめ,食べ放題,飲み放題"> <!-- SEO -->
<title>メニューTOP画面</title>
	<link rel="stylesheet" href="./CSS/Menu.css">
</head>
<body>
	<header>
		<div id="header-name">
			<h3>(仮)居酒屋注文システム</h3>
		</div>
		<nav>
			<ul>
				<li><a href="MenuBest.jsp">おすすめ</a></li>
				<li><a href="MenuMeat.jsp">肉</a></li>
				<li><a href="MenuFish.jsp">魚</a></li>
				<li><a href="Menu.Alcoholjsp">アルコール</a></li>
				<li><a href="Menu.SoftDrinkjsp">ソフトドリンク</a></li>
			</ul>
		</nav>
	</header>
	<main1>
	<!-- 料理一覧  -->
		<%--  <% 
		//文字化け対策
			request.setCharacterEncoding("UTF-8"); 
		
		//送信データの取得
			String 商品番号 = request.getParameter("foodID");
			Stirng 商品名	= request,getParameter("foodName");
			Int 価格 = request.getParameter("foodPrice");
			String 分類 = request.getParameter("foodCategory")
		%> --%>
	</main1>
	<main2>
<!--	注文テーブル  -->
		<form action="注文確認画面のJSP" method="get">
			<table border="2">
				<tr>
					<th label for="foodName">料理名</th><td><input type=>〇個</th><th>↑</th><th>↓</th><th>消</th>
				</tr>
			</table>
		</form>>		
	</main2>
</body>
<footer>
	<div id="return-btn">
		<button onclick="location.href='遷移したいページ等のURL'">前へ</button>
	</div>
	<div id="next-btn">
		<button onclick="location.href='遷移したいページ等のURL'">次へ</button>
	</div>
	<div id="taxi-btn">
		<button onclick="location.href='遷移したいページ等のURL'">タクシー</button>
	</div>
	<div id="toilet-btn">
		<button onclick="location.href='遷移したいページ等のURL'">トイレ</button>
	</div>
	<div id="call-btn">
		<button onclick="location.href='遷移したいページ等のURL'">店員呼び出し</button>
	</div>
	<div id="oaiso-btn">
		<button onclick="location.href='遷移したいページ等のURL'">お会計</button>
	</div>
</footer>
</html>
