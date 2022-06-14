<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/app/css/goal.css">
</head>
<body>
	<header> </header>

	<!-- ここからメイン -->
	<main>
		POME goal


		<!-- 参考サイト：https://shu-sait.com/tab-kirikae-box/ -->
		<div>
			<div class="goal_wrap">

				<input id="tab0" type="radio" name="tag_id"> <label
					for="tab0" class="tab_lab0_all">目標一覧</label> <input id="tab1"
					type="radio" name="tag_id"> <label for="tab1"
					class="tab_lab1_work">仕事</label> <input id="tab2" type="radio"
					name="tag_id"> <label for="tab2" class="tab_lab2_housework">家事</label>

				<input id="tab3" type="radio" name="tag_id"> <label
					for="tab3" class="tab_lab3_hobby">趣味</label> <input id="tab4"
					type="radio" name="tag_id"> <label for="tab4"
					class="tab_lab4_study">勉強</label> <input id="tab5" type="radio"
					name="tag_id"> <label for="tab5" class="tab_lab5_etc">その他</label>



				<div id="tag_all" class="tag_table">
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

	<script src="js/goal.js"></script>
</body>
</html>




