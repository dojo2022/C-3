<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/joys.css">
<link rel="stylesheet" type="text/css" href="css/color.css">
<title>joys一覧</title>
</head>
<body>
	<header class="header">
		<div class="logo">
			<img src="/app/img/logo00.png" width="300" height="150">
		</div>
		<a href="/app/LoginServlet" class="logoutbtn"><div>ログアウト</div></a> <a
			href="/app/HintServlet" class="hint" target="_blank"><img
			src="/app/img/hint.png" width="60" height="60"></a>
	</header>

	<!-- ここからメイン -->
	<main>
		<img src="/app/img/joys.png" width="60" height="60"> <a
			href="/app/JoysRegistarServlet"><img src="/app/img/regist.png"
			width="60" height="60"></a>
		<!-- ↑右下に固定したい登録ボタン -->
		<h1>joys一覧</h1>

		<c:forEach end= "0" var="a" items="${rewardList}">
		現在の${a.nickname}さんのポイントは${a.having_point}です
		</c:forEach>

		<hr>
		<c:forEach var="e" items="${rewardList}">


			<form action="/app/CheckjoysServlet" method="POST" id="exchange">
				<!-- 頑張る -->
								<input type="hidden" value="${e.user_id}">
								<input type="hidden" value="${e.nickname}">
								<input type="hidden" value="${e.having_point}">

				<table class="">


					<!-- ↓  /app/JoysUpdateServlet?reward_id=0001	こんな感じで数値が入る	 -->
					<tr >
					<td>
					<a href="/app/JoysUpdateServlet?reward_id=${e.reward_id}">
							<img src="/app/img/edit.png" width="60" height="60">
					</a></td>
					<td class="">JoysID ${e.reward_id}</td>
					<td class="">Joys名 ${e.reward_name}</td>
					<td class="">Joys詳細 ${e.reward_detail}</td>
					<td class="">必要ポイント数 ${e.required_point}</td>
					<td><a href="/app/CheckjoysServlet?required_point=${e.required_point}"><img
							src="/app/img/present.png" width="60" height="60"> </a></td>
					</tr>
				</table>
			</form>

	</c:forEach>

			<hr>




	</main>
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