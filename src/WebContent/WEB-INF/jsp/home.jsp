<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POME HOME</title>
<link rel="stylesheet" type="text/css" href="/app/css/home.css">
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

		<div>
			<div class="goal_wrap">
				<form action="/app/HomeServlet" id="f0" method="POST">
					<input id="btn0" type="radio" name="tag" value="0"> <label
						for="tab0" class="tab_lab0_all">今日やること一覧</label>
				</form>

				<form action="/app/HomeServlet" id="f1" method="POST">
					<input id="btn1" type="radio" name="tag" value="1"> <label
						for="tab1" class="tab_lab1_work">仕事</label>
				</form>

				<form action="/app/HomeServlet" id="f2" method="POST">
					<input id="btn2" type="radio" name="tag" value="2"> <label
						for="tab2" class="tab_lab2_housework">家事</label>
				</form>

				<form action="/app/HomeServlet" id="f3" method="POST">
					<input id="btn3" type="radio" name="tag" value="3"> <label
						for="tab3" class="tab_lab3_hobby">趣味</label>
				</form>

				<form action="/app/HomeServlet" id="f4" method="POST">
					<input id="btn4" type="radio" name="tag" value="4"> <label
						for="tab4" class="tab_lab4_study">勉強</label>
				</form>

				<form action="/app/HomeServlet" id="f5" method="POST">
					<input id="btn5" type="radio" name="tag" value="5"> <label
						for="tab5" class="tab_lab5_etc">その他</label>
				</form>
			</div>
		</div>

				<div id="tag_all" class="tag_table">

					<table>
						<c:forEach var="e" items="${goalTodayList}">
							<tr>
								<td><div>${e.goal_name}</div></td>
								<td><div>${e.goal_detail}</div></td>
								<td><a href="/app/GoalUpdateServlet"><img
										src="/app/img/edit.png" class="menu"></a></td>
								<th></th>

								<td>
									<form action="/app/CheckgoalServlet" method="POST" id="ach">
										<input type="checkbox" id="achievement" name="check" value="1">
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>

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
	<script src="/app/js/home.js"></script>
</body>
</html>