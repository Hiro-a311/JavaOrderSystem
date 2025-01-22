<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>login_choice</title>
	<link rel="stylesheet" href="./css/skyblue.css">
	<link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
	<link rel="stylesheet" href="./css/helper.css">
</head>
<body>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>メニュー&nbsp;<span class="icon-coffee"></span></h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<form name="mainform" action="./orderlistdisplay" method="post">
				<table style="width: 400px" class="table">
					<tr>
					<td><input class="btn" type="submit" value="表示" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>