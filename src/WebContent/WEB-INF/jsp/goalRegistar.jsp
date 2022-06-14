<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/app/css/goalRegistar.css">
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
		<p>POME GOALREGISTAR</p>

		<form method="post" action="/app/GoalRegistarServlet">
			<div class="img">
				<img src="/app/img/joys.png" width="80" height="80">
				<h1>目標更新・削除</h1>
			</div>

			<table>
				<tr>
					<th>目標名</th>
				</tr>
				<tr>
					<td><input type="text" name="goal_name" placeholder=""></input></td>
				</tr>
				<tr>
					<th>詳細</th>
				</tr>
				<tr>
					<td><input type="text" name="goal_detail"
						placeholder="1000文字まで"></input></td>
				</tr>
				<tr>
					<th>期間</th>
				</tr>
				<tr>
					<td><input type="radio" name="term_id" value="1">終日</td>
					<td><input type="radio" name="term_id" value="2">繰り返し</td>
					<td><input type="radio" name="term_id" value="3">長期</td>
				</tr>
				<tr>
					<th>達成難易度</th>
				</tr>
				<tr>
					<td><input type="radio" name="difficulty_id" value="1">簡単</td>
					<td><input type="radio" name="difficulty_id" value="2">難しい</td>
				</tr>

				<tr>
					<th>日付</th>
				</tr>
				<tr>
					<td><input type="date" name="difficulty_id" value="1"></td>

<!-- 開始日はjavaScriptで今日の日付を生成し自動入力されていると便利かも。 -->
<!-- 開始日が本日以前は入力できない形でもよさそう -->

					<td>～</td>
					<td><input type="date" name="difficulty_id" value="2"></td>
				</tr>

				<tr>
					<th>タグ</th>
				</tr>
				<tr>
					<td><input type="radio" name="tag_id" value="1">仕事</td>
					<td><input type="radio" name="tag_id" value="2">家事</td>
					<td><input type="radio" name="tag_id" value="3">趣味</td>
					<td><input type="radio" name="tag_id" value="4">勉強</td>
					<td><input type="radio" name="tag_id" value="5">その他</td>


				</tr>
				<tr>
					<td><input type="submit" name="" value="登録"></td>

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
	<script src="js/goalRegistar.js"></script>
</body>
</html>