<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,
 			initial-scale=1.0,
 			minimum-scale=1.0,
 			user-scalable=yes">

<title>POME | ジョイス</title>

<link rel="icon" type="image/png" href="/app/img/favicon.ico" />
<!-- ↑ファビコン設定　タブ左やブックマーク時に表示されるアイコン -->
<link rel="apple-touch-icon" type="image/png"
	href="app/img/pome_favicon.png">
<!-- ↑アップルタッチアイコン　スマホのホーム画面に追加したときに表示されるアイコン -->


<link rel="stylesheet" type="text/css" href="css/joys.css">
<link rel="stylesheet" type="text/css" href="css/color.css">

</head>
<body>
	<!-- 全体を囲むクラス -->

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

		<div class="title">
			<img src="/app/img/joys.png" width="120" height="120" class="title_img">
			<h1 class="title_h1">joys一覧</h1>
		</div>

		<c:forEach end="0" var="a" items="${rewardList}">
		<p class="having">保持ポイント：${a.having_point}pts</p>
		</c:forEach>

		<div class="tab_wrap">
			<div class="panel_area">
				<div class="tab_panel">


					<div class="panel_upper">
						<div class="panel_upper_1">Joys</div>
						<div class="panel_upper_2">必要ポイント数</div>
					</div>
					<c:forEach var="e" items="${rewardList}">
						<form action="/app/CheckjoysServlet" method="POST" id="exchange">
							<table class="in_table">
								<tr>
									<td><a
										href="/app/JoysUpdateServlet?reward_id=${e.reward_id}"> <img
											src="/app/img/edit.png" width="60" height="60">
									</a></td>

									<td class="">${e.reward_name}</td>
									<td class="">${e.required_point}ポイント</td>

									<td><input type="image" src="/app/img/present.png"
										width="60" height="60" onclick="change(this.form)"></td>
									<td><input type="hidden" name="reward_id"
										value="${e.reward_id}" readonly></td>
									<td><input type="hidden" name="reward_name"
										value="${e.reward_name}" readonly></td>

								</tr>
							</table>

							<div class="out_table">${e.reward_detail}</div>
							<input type="hidden" name="having_point"
								value="${e.having_point}">
							<br><br><br><br><br><br><br><br>

						</form>
					</c:forEach>

				</div>
			</div>
		</div>





		<div class="goal_plus">
			<a href="/app/JoysRegistarServlet"><img src="/app/img/regist.png"
				width="140" height="140"></a>
		</div>




	</main>
	<div class="empty"></div>
	<!--  -->
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
	<script src="js/joys.js"></script>

</body>
</html>
