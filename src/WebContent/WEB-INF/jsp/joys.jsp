<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/joys.css">
<link rel="stylesheet" type="text/css" href="css/ranking.css">
<title>joys一覧</title>
</head>
<body>
	<header>
		<div>
			<img src="/app/img/logo00.png" class="logo">
		</div>
		<a href="/app/LoginServlet" class="LogoutBtn">ログアウト</a> <a
			href="/app/HintServlet" class="hint" target="_blank"><img
			src="/app/img/hint.png"></a>
	</header>

	<!-- ここからメイン -->
	<main>
		<h1>joys一覧</h1>

		<table>
			<tr>
				<th><a href="/app/joysUpdateServlet"><img
									src="/app/img/edit.png" ></a></th>
				<th>joys名</th>
				<th>必要ポイント数</th>
				<th><button type="button"> <img src="/app/img/present.png" ></button></th>
			</tr>


			<tr>

			</tr>


			<!-- 頑張る -->

		</table>



	</main>
	<!--  -->
	<footer>
		<ul>
			<li><a href="/app/HomeServlet"><img src="/app/img/home.png"
					class="menu"></a></li>
			<li><a href="/app/GoalServlet"><img src="/app/img/check.png"
					class="menu"></a></li>
			<li><a href="/app/JoysServlet"><img src="/app/img/joys.png"
					class="menu"></a></li>
			<li><a href="/app/ProfileServlet"><img
					src="/app/img/profile.png" class="menu"></a></li>
		</ul>
	</footer>
	<script src="js/joys.js"></script>
</body>
</html>