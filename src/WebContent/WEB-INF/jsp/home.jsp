<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<!--
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet">-->
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-2.1.0.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>


<head>
<meta charset="UTF-8">
<title>POME｜HOME</title>

<link rel="icon" type="image/png" href="/app/img/favicon.ico"/>
<!-- ↑ファビコン設定　タブ左やブックマーク時に表示されるアイコン -->
<link rel="apple-touch-icon" type="image/png"
	href="app/img/pome_favicon.png">
<!-- ↑アップルタッチアイコン　スマホのホーム画面に追加したときに表示されるアイコン -->


<link rel="stylesheet" type="text/css" href="/app/css/home.css">
<link rel="stylesheet" type="text/css" href="css/color.css">

</head>
<body>



    <!--<c:if test="${first == '1'}"></c:if>-->
	<div class="top-op">
  		<img src="/app/img/logo00.png" width="600" height="300" class="op_logo">
  	</div>
  	<div class="top-op2">
  		<div class="login_body">
	  	<div class = "wrapper">
			<h3>
				ToDo管理アプリのように登録し<br>
				達成したときには褒めてもらえるアプリ
			</h3>
		</div>
		<img src="/app/img/logo00.png" width="260" height="140" alt="POME">
		<form id="login_form" method="POST" action="/app/LoginServlet">
			<table class="login">
				<tr>
					<td><input type="text" value=""  placeholder="ＯＫ！！"
						name="user_id" required class="login_data">
					</td>
				</tr>
				<tr>
					<td><input type="password"  id="textPassword"  placeholder="ＯＫ！！"name="password" required class="login_data"><br>
						<input type="checkbox" id="password-check" >
					</td>
				</tr>
			</table>
			<input type="submit" name="login" value="LOGIN" class="login_button">
		</form>
		<br>
		<a href="RegistarServlet">新規登録
		</a>
		<a href = "HintServlet">
		<img src="/app/img/hint.png" width="25" height="25" >POMEについて詳しく知りたい方はこちらへ
		</a >
		</div>
  	</div>




	<header class="header">
		<div class="logo">
			<img src="/app/img/logo00.png" width="300" height="150">
		</div>
		<a  id="logout" href="/app/LogoutServlet" class="logoutbtn"><div>ログアウト</div></a>
		 <a
			href="/app/HintServlet" class="hint" target="_blank"><img
			src="/app/img/hint.png" width="60" height="60"></a>
	</header>

	<!-- ここからメイン -->
	<main>



		<div class="home_title">
			<img src="/app/img/home.png" width="120" height="120" class="home_title_img">
			<h1 class="home_title_h1">HOME</h1>
		</div>



		<div class="tab_wrap">
			<input id="tab1" class="hide" type="radio" name="tab_btn"
				<c:if test="${tag == null or tag =='0'}">
            		checked
            	</c:if>>
			<input id="tab2" class="hide" type="radio" name="tab_btn"
				<c:if test="${tag == '1'}">
            		checked
            	</c:if>>
			<input id="tab3" class="hide" type="radio" name="tab_btn"
				<c:if test="${tag == '2'}">
            		checked
            	</c:if>>
			<input id="tab4" class="hide" type="radio" name="tab_btn"
				<c:if test="${tag == '3'}">
            		checked
            	</c:if>>
			<input id="tab5" class="hide" type="radio" name="tab_btn"
				<c:if test="${tag == '4'}">
            		checked
            	</c:if>>
			<input id="tab6" class="hide" type="radio" name="tab_btn"
				<c:if test="${tag == '5'}">
            		checked
            	</c:if>>
			<div class="tab_area">
				<form action="/app/HomeServlet" id="f0" method="POST">
					<input id="btn0" type="hidden" name="tag" value="0"> <label
						class="tab1_label" for="tab1" onclick="labelClick(this)">今日やること</label>
				</form>
				<form action="/app/HomeServlet" id="f1" method="POST">
					<input id="btn1" type="hidden" name="tag" value="1"> <label
						class="tab2_label" for="tab2" onclick="labelClick(this)">仕事</label>
				</form>
				<form action="/app/HomeServlet" id="f2" method="POST">
					<input id="btn2" type="hidden" name="tag" value="2"> <label
						class="tab3_label" for="tab3" onclick="labelClick(this)">家事</label>
				</form>
				<form action="/app/HomeServlet" id="f3" method="POST">
					<input id="btn3" type="hidden" name="tag" value="3"> <label
						class="tab4_label" for="tab4" onclick="labelClick(this)">趣味</label>
				</form>
				<form action="/app/HomeServlet" id="f4" method="POST">
					<input id="btn4" type="hidden" name="tag" value="4"> <label
						class="tab5_label" for="tab5" onclick="labelClick(this)">勉強</label>
				</form>
				<form action="/app/HomeServlet" id="f5" method="POST">
					<input id="btn5" type="hidden" name="tag" value="5"> <label
						class="tab6_label" for="tab6" onclick="labelClick(this)">その他</label>
				</form>
			</div>

			<form action="/app/CheckgoalServlet" method="POST" id="ach">
				<table>
					<tr>
						<td><input type="hidden" name="id" value=${e.id } readonly></td>
						<td>${e.goal_name}</td>
						<td>${e.goal_detail}</td>
						<td><label class="btn"> <input type="checkbox"
								style="display: none;" id="achievement" name="check" value="1"
								onchange="formSubmit(this.form)"> <i
								class="fa fa-square-o fa-2x"></i> <i
								class="fa fa-check-square-o fa-2x"></i>
						</label></td>
					</tr>
				</table>
			</form>

			<div class="panel_area">

				<div id="panel1" class="tab_panel">
					<c:forEach var="e" items="${goalTodayList}">
						<table class="in_table">
							<tr>
								<td>${e.starting_date}</td>
								<td>～</td>
								<td>${e.ending_date}</td>
								<td>${e.goal_name}</td>
								<td><a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}">
										<img src="/app/img/edit.png" width="40" height="40">
								</a></td>
							</tr>
						</table>
						<div class="out_table">${e.goal_detail}</div>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
					</c:forEach>
				</div>

				<div id="panel2" class="tab_panel">
					<c:forEach var="e" items="${goalTodayList}">
						<table class="in_table">
							<tr>
								<td>${e.starting_date}</td>
								<td>～</td>
								<td>${e.ending_date}</td>
								<td>${e.goal_name}</td>
								<td><a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}">
										<img src="/app/img/edit.png" width="40" height="40">
								</a></td>
							</tr>
						</table>
						<div class="out_table">${e.goal_detail}</div>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
					</c:forEach>
				</div>

				<div id="panel3" class="tab_panel">
					<c:forEach var="e" items="${goalTodayList}">
						<table class="in_table">
							<tr>
								<td>${e.starting_date}</td>
								<td>～</td>
								<td>${e.ending_date}</td>
								<td>${e.goal_name}</td>
								<td><a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}">
										<img src="/app/img/edit.png" width="40" height="40">
								</a></td>
							</tr>
						</table>
						<div class="out_table">${e.goal_detail}</div>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
					</c:forEach>
				</div>

				<div id="panel4" class="tab_panel">
					<c:forEach var="e" items="${goalTodayList}">
						<table class="in_table">
							<tr>
								<td>${e.starting_date}</td>
								<td>～</td>
								<td>${e.ending_date}</td>
								<td>${e.goal_name}</td>
								<td><a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}">
										<img src="/app/img/edit.png" width="40" height="40">
								</a></td>
							</tr>
						</table>
						<div class="out_table">${e.goal_detail}</div>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
					</c:forEach>
				</div>

				<div id="panel5" class="tab_panel">
					<c:forEach var="e" items="${goalTodayList}">
						<table class="in_table">
							<tr>
								<td>${e.starting_date}</td>
								<td>～</td>
								<td>${e.ending_date}</td>
								<td>${e.goal_name}</td>
								<td><a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}">
										<img src="/app/img/edit.png" width="40" height="40">
								</a></td>
							</tr>
						</table>
						<div class="out_table">${e.goal_detail}</div>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
					</c:forEach>
				</div>

				<div id="panel6" class="tab_panel">
					<c:forEach var="e" items="${goalTodayList}">
						<table class="in_table">
							<tr>
								<td>${e.starting_date}</td>
								<td>～</td>
								<td>${e.ending_date}</td>
								<td>${e.goal_name}</td>
								<td><a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}">
										<img src="/app/img/edit.png" width="40" height="40">
								</a></td>
							</tr>
						</table>
						<div class="out_table">${e.goal_detail}</div>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
						<br>
					</c:forEach>
				</div>

			</div>
		</div>



		<c:forEach var="e" items="${goalTodayList}">
			<form action="/app/CheckgoalServlet" method="POST" id="ach">
				<table>
					<tr>
						<td><input type="hidden" name="id" value=${e.id } readonly></td>
						<td>${e.goal_name}</td>
						<td>${e.goal_detail}</td>
						<td><label class="btn"> <input type="checkbox"
								style="display: none;" id="achievement" name="check" value="1"
								onchange="formSubmit(this.form)"> <i
								class="fa fa-square-o fa-2x"></i> <i
								class="fa fa-check-square-o fa-2x"></i>
						</label></td>
					</tr>
				</table>
			</form>
		</c:forEach>

		<div class="goal_plus">
			<a href="/app/GoalRegistarServlet"><img src="/app/img/regist.png"
				width="140" height="140"></a>
		</div>


	</main>
	<div class = "empty"></div>
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