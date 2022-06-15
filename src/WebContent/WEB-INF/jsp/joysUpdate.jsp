<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/joysUpdate.css">
<link rel="stylesheet" type="text/css" href="css/ranking.css">
<title>joys更新・削除</title>
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

		<form method="post" action="">
			<div class="img">
				<img src="/app/img/joys.png" width="80" height="80">
				<h1>joys更新・削除</h1>
			</div>

			<table>
				<tr>
					<th>joys名</th>
				</tr>
				<tr>
					<td><input type="text" name="reward_name" placeholder="" required></input></td>
				</tr>
				<tr>
					<th>詳細</th>
				</tr>
				<tr>
					<td><input type="text" name="reward_detail" placeholder=""></input></td>
				</tr>
				<tr>
					<th>ささやかor豪華選択</th>
				</tr>
				<tr>
					<td><input type="radio" name="reward_level_id" value="1" required>ささやか(10pt)</td>
					<td><input type="radio" name="reward_level_id" value="2">豪華(50pt)</td>
				</tr>
				<tr>
					<td><input type="submit" name="" value="削除"></td>
					<td><input type="submit" name="" value="更新"></td>
				</tr>
			</table>
		</form>

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