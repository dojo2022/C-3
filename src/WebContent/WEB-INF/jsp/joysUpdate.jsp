<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>POME | ジョイス更新・削除</title>

<link rel="icon" type="image/png" href="/app/img/favicon.ico" />
<!-- ↑ファビコン設定　タブ左やブックマーク時に表示されるアイコン -->
<link rel="apple-touch-icon" type="image/png"
	href="app/img/pome_favicon.png">
<!-- ↑アップルタッチアイコン　スマホのホーム画面に追加したときに表示されるアイコン -->


<link rel="stylesheet" type="text/css" href="css/joysUpdate.css">
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
		<c:forEach var="e" items="${rewardList}">
			<form method="post" action="/app/JoysUpdateServlet">
				<div class="img">
					<img src="/app/img/joys.png" width="80" height="80">
					<h1>joys更新・削除</h1>
				</div>

				<table>

					<tr>
						<td><input type="hidden" name="reward_id"
							value="${e.reward_id}" required></input></td>
					</tr>
					<tr>
						<th class="th_left">joys名</th>

						<td colspan="2"><input type="text" name="reward_name"
							value="${e.reward_name}" required></input></td>
					</tr>
					<tr>
						<th class="th_left">詳細</th>

						<td colspan="2"><input type="text" name="reward_detail"
							value="${e.reward_detail}"></input></td>
					</tr>

					<tr>
						<th class="th_left">ささやかor豪華選択</th>

						<td><input id="ささやか" type="radio" name="reward_level_id"
							value="1"
							<c:if test="${e.reward_level_id == '1'}">
							checked
						</c:if>><label
							class="radio_label tiny" for="ささやか">ささやか(10pt)</label></td>
						<td><input id="豪華" type="radio" name="reward_level_id"
							value="2"
							<c:if test="${e.reward_level_id == '2'}">
							checked
						</c:if>><label
							class="radio_label gorgious" for="豪華">豪華(50pt)</label></td>
					</tr>
					<tr>
						<td><input type="submit" name="SUBMIT" value="更新"
							class="update_button"></td>
						<td><input type="submit" name="SUBMIT" value="削除"
							class="delete_button" onclick="return chkDelete(this)"></td>
					</tr>
				</table>
			</form>
		</c:forEach>
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
	<script src="js/joys.js"></script>
</body>
</html>