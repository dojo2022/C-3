<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>POME | マイプロフィール</title>

<link rel="icon" type="image/png" href="/app/img/favicon.ico" />
<!-- ↑ファビコン設定　タブ左やブックマーク時に表示されるアイコン -->
<link rel="apple-touch-icon" type="image/png"
	href="app/img/pome_favicon.png">
<!-- ↑アップルタッチアイコン　スマホのホーム画面に追加したときに表示されるアイコン -->



<link rel="stylesheet" type="text/css" href="css/profile.css">
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

		<form method="POST" id="profile_form" action="/app/ProfileServlet">



			<c:forEach var="e" items="${profile }">
				<div>
					<h2>ニックネーム</h2>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"
						id="nickname" name="nickname" value=${e.nickname }>
				</div>
				<div class="having_point">
					<h2>所持ポイント</h2>
					<p id="point">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${e.having_point }ポイント</p>
				</div>
				<div class="total_point">
					<h2>累計ポイント</h2>
					<p id="point">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${e.total_point }ポイント</p>
				</div>
			</c:forEach>

			<input type="radio" name="edit" value="yes">編集する&nbsp;&nbsp;&nbsp;
			<input type="radio" name="edit" value="no" checked>編集しない&nbsp;&nbsp;&nbsp;
			<input type="submit" class="update" name="update" value="更新"
				disabled="disabled"><br>

		</form>


		<h2>達成済みリスト</h2>
		<div id="table" class="list">
			<table id="list">


				<c:forEach var="a" items="${achievementList}">
					<tr>
						<td class="listname">${a.goal_name }</td>

					</tr>
				</c:forEach>
			</table>
		</div>
		<a href="/app/RankingServlet">ポイントランキングはこちら▶</a><br>
	</main>
	<!--  -->

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


	<script src="js/profile.js">

	</script>
</body>
</html>