<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>POME | ジョイス登録</title>

<link rel="icon" type="image/png" href="/app/img/favicon.ico" />
<!-- ↑ファビコン設定　タブ左やブックマーク時に表示されるアイコン -->
<link rel="apple-touch-icon" type="image/png"
	href="app/img/pome_favicon.png">
<!-- ↑アップルタッチアイコン　スマホのホーム画面に追加したときに表示されるアイコン -->


<link rel="stylesheet" type="text/css" href="css/joysRegistar.css">
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

	<main>

		<form method="post" action="/app/JoysRegistarServlet">
			<div class="joys_title">
				<img src="/app/img/joys.png" width="120" height="120"
					class="joys_title_img">
				<h1 class="joys_title_h1">Joys登録</h1>
			</div>


			<table>
				<tr>
					<th class="th_left">joys名</th>

					<td colspan="2"><input type="text" name="reward_name"
						placeholder="アイス" class="jr" required></input></td>
				</tr>
				<tr>
					<th class="th_left">詳細</th>

					<td colspan="2"><input type="text" name="reward_detail"
						placeholder="チョコモナカジャンボを大人買い" class="jr"></input></td>
				</tr>
				<tr>
					<th class="th_left">ささやかor豪華選択</th>

					<td><input id="ささやか" type="radio" name="reward_level_id"
						value="1" checked> <label class="radio_label tiny"
						for="ささやか">ささやか(10pt)</label></td>
					<td><input id="豪華" type="radio" name="reward_level_id"
						value="2"><label class="radio_label gorgious" for="豪華">豪華(50pt)</label></td>
				</tr>
				<tr>
					<td><input type="submit" name="SUBMIT" value="登録"
						class="registar_button"></td>
				</tr>
			</table>
		</form>

	</main>
	<!-- フッター被り解決 -->
	<div class="empty"></div>
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

	<script src="js/joysRegistar.js"></script>
</body>
</html>