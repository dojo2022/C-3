<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/app/css/goal.css">
</head>
<body>
        <header class="header">
            <div class="logo"><img src="/app/img/logo00.png"  width="300" height="150"></div>
            <a href="/app/LoginServlet" class="logoutbtn"><div>ログアウト</div></a>
            <a href="/app/HintServlet" class="hint" target="_blank"><img src="/app/img/hint.png" width="60" height="60"></a>
        </header>

	<!-- ここからメイン -->
	<main>
		POME goal


		<!-- 参考サイト：https://shu-sait.com/tab-kirikae-box/ -->
				<!-- 目標名はSQLに接続してから -->
						<!-- 編集ボタンからの内部構造、SQLとのあれこれが必要そうです-->
								<!-- 詳細マウスオーバーのコード書いてないです…！-->
		<div>
			<div class="goal_wrap">

				<input id="tab0" type="radio" name="tag_id" value="0">
				<label for="tab0" class="tab_lab0_all">目標一覧</label>

				<input id="tab1" type="radio" name="tag_id" value="1">
				<label for="tab1" class="tab_lab1_work">仕事</label>

				<input id="tab2" type="radio" name="tag_id" value="2">
				<label for="tab2" class="tab_lab2_housework" >家事</label>

				<input id="tab3" type="radio" name="tag_id" value="3">
				<label for="tab3" class="tab_lab3_hobby">趣味</label>


				<input id="tab4" type="radio" name="tag_id" value="4">
				<label for="tab4" class="tab_lab4_study">勉強</label>

				<input id="tab5" type="radio" name="tag_id" value="5">
				<label for="tab5" class="tab_lab5_etc">その他</label>






				<div id="tag_work" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>
							<th><a href="/app/GoalUpdateServlet"><img
									src="/app/img/edit.png" class="menu"></a></th>
							<th></th>
							<td><input type="checkbox" id="achievement"></td>
						</tr>
					</table>
				</div>

				<div id="tag_all" class="tag_table">
					<table border="1">
						<c:forEach var="e" items="${goalList}">
							<tr class="title">
								<td><div>${e.starting_date}</div></td>
								<td>～</td>
								<td><div>${e.ending_date}</div></td>
								<td><div>${e.goal_name}</div></td>
								<td><div>
										<a href="/app/GoalUpdateServlet"><img
											src="/app/img/edit.png" class="menu"></a>
									</div></td>
								<td><div class="btn"></div></td>
							</tr>

							<tr class="content">
								<td>${e.goal_detail}</td>
							</tr>




							<!-- <ul id="links01"> -->

							<!-- <li>${e.goal_detail}</li> -->
							<!-- </ul> -->
							<!-- </div> -->


						</c:forEach>
					</table>
				</div>

				<div id="tag_housework" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>
							<th><a href="/app/GoalUpdateServlet"><img
									src="/app/img/edit.png" class="menu"></a></th>
							<th></th>
							<td><input type="checkbox" id="achievement"></td>
						</tr>
					</table>
				</div>




				<div id="tag_hobby" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>
							<th><a href="/app/GoalUpdateServlet"><img
									src="/app/img/edit.png" class="menu"></a></th>
							<th></th>
							<td><input type="checkbox" id="achievement"></td>
						</tr>
					</table>
				</div>




				<div id="tag_study" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>
							<th><a href="/app/GoalUpdateServlet"><img
									src="/app/img/edit.png" class="menu"></a></th>
							<th></th>
							<td><input type="checkbox" id="achievement"></td>
						</tr>
					</table>
				</div>


				<div id="tag_etc" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>
							<th><a href="/app/GoalUpdateServlet"><img
									src="/app/img/edit.png" class="menu"></a></th>
							<th></th>
							<td><input type="checkbox" id="achievement"></td>
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

	<script src="/app/js/goal.js"></script>
</body>
</html>




