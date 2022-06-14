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
		<div class="logo"><img src="/app/img/logo00.png"  width="300" height="150"></div>
		<a href="/app/LoginServlet" class="logoutbtn"><div>ログアウト</div></a>
		<a href="/app/HintServlet" class="hint" target="_blank"><img src="/app/img/hint.png" width="60" height="60"></a>
	</header>

<!-- ここからメイン -->
<main>

		<div>
			<div class="goal_wrap">

				<input id="tab0" type="radio" name="tag_id">
				<label for="tab0" class="tab_lab0_all">今日やること</label>

				<input id="tab1" type="radio" name="tag_id">
				<label for="tab1" class="tab_lab1_work">仕事</label>

				<input id="tab2" type="radio" name="tag_id">
				<label for="tab2" class="tab_lab2_housework">家事</label>

				<input id="tab3" type="radio" name="tag_id">
				<label for="tab3" class="tab_lab3_hobby">趣味</label>

				<input id="tab4" type="radio" name="tag_id">
				<label for="tab4" class="tab_lab4_study">勉強</label>

				<input id="tab5" type="radio" name="tag_id">
				<label for="tab5" class="tab_lab5_etc">その他</label>



				<div id="tag_all" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>
							<th>編集ボタン</th>

									<a href="/app/GoalRegistarServlet.java"><img src="/app/img/regist.png" class="regist"></a>

									<a href="/app/GoalRegistarServlet.java"><img src="/app/img/regist.png" class="regist"></a>


							<th>チェックボタン</th>
							<th></th>
						</tr>
					</table>
				</div>



				<div id="tag_work" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>

							<th>編集ボタン</th>
							<td>

							</td>

							<th>チェックボタン</th>
							<td></td>

							<th></th>
						</tr>
					</table>
				</div>




				<div id="tag_housework" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>
							<th>編集ボタン</th>
							<th>チェックボタン</th>
							<th></th>
						</tr>
					</table>
				</div>




				<div id="tag_hobby" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>
							<th>編集ボタン</th>
							<th>チェックボタン</th>
							<th></th>
						</tr>
					</table>
				</div>




				<div id="tag_study" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>
							<th>編集ボタン</th>
							<th>チェックボタン</th>
							<th></th>
						</tr>
					</table>
				</div>




				<div id="tag_etc" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>
							<th>編集ボタン</th>
							<th>チェックボタン</th>
							<th></th>
						</tr>
					</table>
				</div>


			</div>
		</div>


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
<script src="js/home.js"></script>
</body>
</html>