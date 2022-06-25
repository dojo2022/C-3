<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POME | ランキング</title>

<link rel="icon" type="image/png" href="/app/img/favicon.ico"/>
<!-- ↑ファビコン設定　タブ左やブックマーク時に表示されるアイコン -->
<link rel="apple-touch-icon" type="image/png"
	href="app/img/pome_favicon.png">
<!-- ↑アップルタッチアイコン　スマホのホーム画面に追加したときに表示されるアイコン -->


<link rel="stylesheet" type="text/css" href="css/ranking.css">
<link rel="stylesheet" type="text/css" href="css/color.css">

</head>
<body>
	<header class="header">
		<div class="logo">
			<img src="/app/img/logo00.png" width="300" height="150">
		</div>

			<a id='logout' href="/app/LogoutServlet" class="logoutbtn"><div>ログアウト</div></a>

		<a href="/app/HintServlet" class="hint" target="_blank"><img
			src="/app/img/hint.png" width="60" height="60"></a>
	</header>


	<!-- ここからメイン -->
	<main>
		<h1>ランキング</h1>
		<!-- <c:forEach var="e" items="${rankingList}">

			頑張る

			<ul class="">
				<li>順位：${e.rank_result}</li>
				<li>ニックネーム：${e.nickname}</li>
				<li>累計ポイント：${e.total_point }ポイント</li>
			</ul>

			<hr>
		</c:forEach>-->

		<div id="table">
	<table class="list">
		<tr>
			<th>順位</th>
			<th>ニックネーム</th>
			<th>累計ポイント</th>


		</tr>

	<c:forEach var="e" items="${ rankingList}">
		<tr>
			<td>${e.rank_result}</td>
			<td>${e.nickname}さん</td>
			<td>${e.total_point }pts.</td>

		</tr>
		</c:forEach>
	</table>
	</div>

	</main>
	<!-- フッター被り解決 -->
<div class = "empty"></div>

	<footer class="footer">
		<ul class="footer-ul">
			<li class="footer-li"><a href="/app/HomeServlet"><img
					src="/app/img/home.png" width="60" height="60"><br>
					<div>Home</div></a></li>
			<li class="footer-li"><a href="/app/GoalServlet"><img
					src="/app/img/check.png" width="60" height="60"><br>
					<div class="footer-li-goal">目標一覧</div></a></li>
			<li class="footer-li"><a href="/app/JoysServlet"><img
					src="/app/img/joys.png" width="60" height="60"><br>
					<div>Joys</div></a></li>
			<li class="footer-li"><a href="/app/ProfileServlet"><img
					src="/app/img/profile.png" width="60" height="60"><br>
					<div>マイプロフィール</div></a></li>
		</ul>
	</footer>
	<script src="js/ranking.js"></script>
</body>
</html>