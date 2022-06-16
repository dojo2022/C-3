<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			href="/app/HintServlet" class="hint" target="_blank"><img src="/app/img/hint.png" width="60" height="60"></a>
	</header>

	<!-- ここからメイン -->
	<main>
		<img src="/app/img/joys.png" width="60" height="60">
		<a href="/app/JoysUpdateServlet"><img src="/app/img/edit.png" width="60" height="60"></a>
		<h1>joys一覧</h1>
		<hr>
		<c:forEach var="e" items="${rewardList}" >

			<!-- 頑張る -->

						<c:forEach var="e" items="${goalList}">
							<div class="menu">
								<label for="menu_bar01">
									<tr>
										<th>${e.starting_date}</th>
										<th>${e.ending_date}</th>
										<th>${e.goal_name}</th>
										<th><a href="/app/GoalUpdateServlet"><img
												src="/app/img/edit.png" class="menu"></a></th>
										<td><input type="checkbox" id="achievement"></td>
									</tr>
								</label> <input type="checkbox" id="menu_bar01" />
								<ul id="links01">
									<li>${e.goal_detail}</li>
								</ul>
							</div>
						</c:forEach>

		<ul class="">
			<li class="">
				<label class="">joys番号 <br> ${e.reward_id}</label>
			</li>

			<li class="">
				<label class="">ユーザーID</label>
				<input type="text" name="user_id" value="${e.user_id}">
			</li>

			<li class="">
				<label class="">Joys名</label>
				<input type="text" name="reward_name" value="${e.reward_name}">
			</li>
			<!--
			<li class="">
				<label class="">Joys詳細</label>
				<input type="text" name="reward_detail" value="${e.reward_detail}">
			</li>
			-->
			<!--
			<li class="">
				<label class="">必要ポイント数</label>
				<input type="text" name="required_point" value="${e.required_point}">
			</li>
			-->
				<button type="button" >	<!-- モーダルウィンドウ？？ 別画面？？ -->
					<img src="/app/img/present.png" width="60" height="60">
				</button>

		</ul>

		<hr>
		</c:forEach>

	</main>
	<!--  -->
<footer class="footer">
            <ul class="footer-ul">
                <li class="footer-li"><a href="/app/HomeServlet"><img src="/app/img/home.png" width="60" height="60"><br><div>Home</div></a></li>
                <li class="footer-li"><a href="/app/GoalServlet"><img src="/app/img/check.png" width="60" height="60"><br><div class="footer-li-goal">目標一覧</div></a></li>
                <li class="footer-li"><a href="/app/JoysServlet"><img src="/app/img/joys.png" width="60" height="60"><br><div>Joys</div></a></li>
                <li class="footer-li"><a href="/app/ProfileServlet"><img src="/app/img/profile.png" width="60" height="60"><br><div>マイプロフィール</div></a></li>
            </ul>
        </footer>
	</footer>
	<script src="js/joys.js"></script>
</body>
</html>