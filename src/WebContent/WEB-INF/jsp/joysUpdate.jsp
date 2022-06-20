<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/joysUpdate.css">
<link rel="stylesheet" type="text/css" href="css/color.css">
<title>joys更新・削除</title>
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

		<form method="post" action="">
			<div class="img">
				<img src="/app/img/joys.png" width="80" height="80">
				<h1>joys更新・削除</h1>
			</div>

			<table>

				<tr>
					<td><input type="text" name="reward_id" placeholder=""
						required></input></td>
				</tr>
				<tr>
					<th>joys名</th>
				</tr>
				<tr>
					<td><input type="text" name="reward_name" placeholder=""
						required></input></td>
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
					<td><input type="radio" name="reward_level_id" value="1"
						required>ささやか(10pt)</td>
					<td><input type="radio" name="reward_level_id" value="2">豪華(50pt)</td>
				</tr>
				<tr>
					<td><input type="submit" name="SUBMIT" value="削除"></td>
					<td><input type="submit" name="SUBMIT" value="更新"></td>
				</tr>
			</table>
		</form>

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