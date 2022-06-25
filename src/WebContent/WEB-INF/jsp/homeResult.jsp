<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POME｜達成リザルト</title>

<link rel="icon" type="image/png" href="/app/img/favicon.ico"/>
<!-- ↑ファビコン設定　タブ左やブックマーク時に表示されるアイコン -->
<link rel="apple-touch-icon" type="image/png"
	href="app/img/pome_favicon.png">
<!-- ↑アップルタッチアイコン　スマホのホーム画面に追加したときに表示されるアイコン -->

<link rel="stylesheet" type="text/css" href="css/result.css">
<link rel="stylesheet" type="text/css" href="css/color.css">
</head>
<body>
	<header class="header">
		<div class="logo">
			<img src="/app/img/logo00.png" width="300" height="150">
		</div>
		<!-- <a href="/app/LoginServlet" class="logoutbtn"><div>ログアウト</div></a>-->
		 <a href="/app/HintServlet" class="hint" target="_blank"><img
			src="/app/img/hint.png" width="60" height="60"></a>
	</header>

	<main>
		<h1>目標達成！！！！</h1>
		<hr>
		<h2><span style="color:#FF9933">${plusPoint}ポイント</span>を獲得しました！！！</h2>

		<img src="/app/img/omedetou.png"><br>
		<img src="/app/img/1.png" id='imageArea'>
		<hr>
		<a href="/app/HomeServlet">＜　ホームへ戻る</a>
	</main>
<!-- フッター被り解決 -->
<div class = "empty"></div>
	<!--<footer class="footer">
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
	</footer>-->
	<script>
		const imageArea = document.getElementById('imageArea');
		const images = ['/app/img/1.png', '/app/img/2.png', '/app/img/3.png', '/app/img/4.png','/app/img/5.png'];

		const imageNo = Math.floor( Math.random() * images.length)
		imageArea.src = images[imageNo];
	</script>
</body>
</html>