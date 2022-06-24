<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
 content="width=device-width,
 			initial-scale=1.0,
 			minimum-scale=1.0,
 			user-scalable=yes">


<title>POME | 目標一覧</title>
<link rel="stylesheet" type="text/css" href="/app/css/goal.css">
<link rel="stylesheet" type="text/css" href="/app/css/color.css">
</head>
<body>
	<header class="header">
		<div class="logo">
			<img src="/app/img/logo00.png" width="300" height="150">
		</div>
		<div class="logoutbtn"><a href="/app/LogoutServlet">ログアウト</a> </div>
		<a
			href="/app/HintServlet" class="hint" target="_blank"><img
			src="/app/img/hint.png" width="60" height="60"></a>
	</header>

	<!-- ここからメイン -->
	<main>


	<!--
	更新機能等が確認し終わったら目標IDをユーザー目線から消すために
		<div>目標ID ${e.goal_id}</div>
		をCTRL＋Fで検索、以下のこれ↓に全て置換してください
		<div><input type="hidden" value="${e.goal_id}"></div>
	-->
	<!--
		108-116行目みたいなテーブル（画面で目標テーブルの真上にある鉛筆たち）を機能が特になかったら消したいです
	-->




		<div class="goal_title">
			<img src="/app/img/check.png" width="120" height="120" class="goal_title_img">
			<h1 class="goal_title_h1">目標一覧</h1>
		</div>



		<div class="tab_wrap">
            <input id="tab1" class="hide" type="radio" name="tab_btn"
            	<c:if test="${tag == null or tag =='0'}">
            		checked
            	</c:if>
            >
            <input id="tab2" class="hide" type="radio" name="tab_btn"
            	<c:if test="${tag == '1'}">
            		checked
            	</c:if>
            >
            <input id="tab3" class="hide" type="radio" name="tab_btn"
            	<c:if test="${tag == '2'}">
            		checked
            	</c:if>
            >
            <input id="tab4" class="hide" type="radio" name="tab_btn"
            	<c:if test="${tag == '3'}">
            		checked
            	</c:if>
            >
            <input id="tab5" class="hide" type="radio" name="tab_btn"
            	<c:if test="${tag == '4'}">
            		checked
            	</c:if>
            >
            <input id="tab6" class="hide" type="radio" name="tab_btn"
            	<c:if test="${tag == '5'}">
            		checked
            	</c:if>
            >
            <div class="tab_area">
                <form action="/app/GoalServlet" id="f0" method="POST">
                    <input id="btn0" type="hidden" name="tag" value="0">
                    <label class="tab1_label" for="tab1" onclick="labelClick(this)">目標一覧</label>
                </form>
                <form action="/app/GoalServlet" id="f1" method="POST">
                    <input id="btn1" type="hidden" name="tag" value="1">
                    <label class="tab2_label" for="tab2" onclick="labelClick(this)">仕事</label>
                </form>
                <form action="/app/GoalServlet" id="f2" method="POST">
                    <input id="btn2" type="hidden" name="tag" value="2">
                    <label class="tab3_label" for="tab3" onclick="labelClick(this)">家事</label>
                </form>
                <form action="/app/GoalServlet" id="f3" method="POST">
                    <input id="btn3" type="hidden" name="tag" value="3">
                    <label class="tab4_label" for="tab4" onclick="labelClick(this)">趣味</label>
                </form>
                <form action="/app/GoalServlet" id="f4" method="POST">
                    <input id="btn4" type="hidden" name="tag" value="4">
                    <label class="tab5_label" for="tab5" onclick="labelClick(this)">勉強</label>
                </form>
                <form action="/app/GoalServlet" id="f5" method="POST">
                    <input id="btn5" type="hidden" name="tag" value="5">
                    <label class="tab6_label" for="tab6" onclick="labelClick(this)">その他</label>
                </form>
            </div>

            <div class="panel_area">

                <div id="panel1" class="tab_panel">
					<!--<table> 日付　目標名チェック　鉛筆　下線下に目標詳細
						<tr>
							<th>目標名</th>
								  <td><a href="/app/GoalUpdateServlet"> <img
									src="/app/img/edit.png" width="60" height="60"></a></td>
							<td><input type="checkbox" id="achievement"></td>
						</tr>
					</table>-->
					<c:forEach var="e" items="${goalList}">
					<table class="in_table">
							<tr>
								<!--  <td><div>目標ID <br>${e.goal_id}</div></td> -->
									<td><!--  開始日 --> ${e.starting_date}</td>
									<td>～</td>
									<td><!--終了日--> ${e.ending_date}</td>
									<td><!--目標名--> ${e.goal_name}</td>
									<td>
											<a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}"> <img
												src="/app/img/edit.png" width="40" height="40"></a>
									</td>
							</tr>
					</table>
					<div class="out_table">${e.goal_detail}</div>
					<br><br><br><br><br><br><br>
					</c:forEach>
              </div>


                <div id="panel2" class="tab_panel">
                    <!--  <div id="tag_work" class="tag_table">
                        <table>
						<tr>
							<th>目標名</th>
							<td><a href="/app/GoalUpdateServlet"> <img
									src="/app/img/edit.png" width="60" height="60"></a></td>
							<th></th>
							<td><input type="checkbox" id="achievement"></td>
						</tr>
					</table>
				</div>
				<div id="tag_all" class="tag_table">
					<table border="1">
						<c:forEach var="e" items="${goalList}">
							<tr class="title">
								<td><div>目標ID ${e.goal_id}</div></td>
								<td><div>開始日 ${e.starting_date}</div></td>
								<td>～</td>
								<td><div>終了日 ${e.ending_date}</div></td>
								<td><div>目標名 ${e.goal_name}</div></td>
								<td><div>

										<a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}"> <img
											src="/app/img/edit.png" width="60" height="60"></a>
									</div></td>
								<td><div class="btn"></div></td>
							</tr>

							<tr class="content">
								<td>${e.goal_detail}</td>
							</tr>
						</c:forEach>
					</table>
                    </div>
                    -->
					<c:forEach var="e" items="${goalList}">
					<table class="in_table">
							<tr>
								<!--  <td><div>目標ID <br>${e.goal_id}</div></td> -->
									<td><!--  開始日 --> ${e.starting_date}</td>
									<td>～</td>
									<td><!--終了日--> ${e.ending_date}</td>
									<td><!--目標名--> ${e.goal_name}</td>
									<td>
											<a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}"> <img
												src="/app/img/edit.png" width="40" height="40"></a>
									</td>
							</tr>
					</table>
					<div class="out_table">${e.goal_detail}</div>
					</c:forEach>
                </div>


                <div id="panel3" class="tab_panel">
                    <!-- <div id="tag_work" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>
							<td><a href="/app/GoalUpdateServlet"> <img
									src="/app/img/edit.png" width="60" height="60"></a></td>
							<th></th>
							<td><input type="checkbox" id="achievement"></td>
						</tr>
					</table>
				</div>

				<div id="tag_all" class="tag_table">
					<table border="1">
						<c:forEach var="e" items="${goalList}">
							<tr class="title">
								<td><div>目標ID ${e.goal_id}</div></td>
								<td><div>開始日 ${e.starting_date}</div></td>
								<td>～</td>
								<td><div>終了日 ${e.ending_date}</div></td>
								<td><div>目標名 ${e.goal_name}</div></td>
								<td><div>
										<a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}"> <img
											src="/app/img/edit.png" width="60" height="60"></a>
									</div></td>
								<td><div class="btn"></div></td>
							</tr>
							<tr class="content">
								<td>${e.goal_detail}</td>
							</tr>
						</c:forEach>
					</table>
                    </div>
					-->
					<c:forEach var="e" items="${goalList}">
					<table class="in_table">
							<tr>
								<!--  <td><div>目標ID <br>${e.goal_id}</div></td> -->
									<td><!--  開始日 --> ${e.starting_date}</td>
									<td>～</td>
									<td><!--終了日--> ${e.ending_date}</td>
									<td><!--目標名--> ${e.goal_name}</td>
									<td>
											<a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}"> <img
												src="/app/img/edit.png" width="40" height="40"></a>
									</td>
							</tr>
					</table>
					<div class="out_table">${e.goal_detail}</div>
					</c:forEach>
                </div>




                <div id="panel4" class="tab_panel">
                    <!-- <div id="tag_work" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>
							<td><a href="/app/GoalUpdateServlet"> <img
									src="/app/img/edit.png" width="60" height="60"></a></td>
							<th></th>
							<td><input type="checkbox" id="achievement"></td>
						</tr>
					</table>
				</div>

				<div id="tag_all" class="tag_table">
					<table border="1">
						<c:forEach var="e" items="${goalList}">
							<tr class="title">
								<td><div>目標ID ${e.goal_id}</div></td>
								<td><div>開始日 ${e.starting_date}</div></td>
								<td>～</td>
								<td><div>終了日 ${e.ending_date}</div></td>
								<td><div>目標名 ${e.goal_name}</div></td>
								<td><div>
										<a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}"> <img
											src="/app/img/edit.png" width="60" height="60"></a>
									</div></td>
								<td><div class="btn"></div></td>
							</tr>
							<tr class="content">
								<td>${e.goal_detail}</td>
							</tr>
						</c:forEach>
					</table>
                    </div>
                    -->
                    <c:forEach var="e" items="${goalList}">
					<table class="in_table">
							<tr>
								<!--  <td><div>目標ID <br>${e.goal_id}</div></td> -->
									<td><!--  開始日 --> ${e.starting_date}</td>
									<td>～</td>
									<td><!--終了日--> ${e.ending_date}</td>
									<td><!--目標名--> ${e.goal_name}</td>
									<td>
											<a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}"> <img
												src="/app/img/edit.png" width="40" height="40"></a>
									</td>
							</tr>
					</table>
					<div class="out_table">${e.goal_detail}</div>
					</c:forEach>
                </div>




                <div id="panel5" class="tab_panel">
                    <!-- <div id="tag_work" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>
							<td><a href="/app/GoalUpdateServlet"> <img
									src="/app/img/edit.png" width="60" height="60"></a></td>
							<th></th>
							<td><input type="checkbox" id="achievement"></td>
						</tr>
					</table>
				</div>

				<div id="tag_all" class="tag_table">
					<table border="1">
						<c:forEach var="e" items="${goalList}">
							<tr class="title">
								<td><div>目標ID ${e.goal_id}</div></td>
								<td><div>開始日 ${e.starting_date}</div></td>
								<td>～</td>
								<td><div>終了日 ${e.ending_date}</div></td>
								<td><div>目標名 ${e.goal_name}</div></td>
								<td><div>
										<a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}"> <img
											src="/app/img/edit.png" width="60" height="60"></a>
									</div></td>
								<td><div class="btn"></div></td>
							</tr>
							<tr class="content">
								<td>${e.goal_detail}</td>
							</tr>
						</c:forEach>
					</table>
                    </div>
                    -->
                    <c:forEach var="e" items="${goalList}">
					<table class="in_table">
							<tr>
								<!--  <td><div>目標ID <br>${e.goal_id}</div></td> -->
									<td><!--  開始日 --> ${e.starting_date}</td>
									<td>～</td>
									<td><!--終了日--> ${e.ending_date}</td>
									<td><!--目標名--> ${e.goal_name}</td>
									<td>
											<a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}"> <img
												src="/app/img/edit.png" width="40" height="40"></a>
									</td>
							</tr>
					</table>
					<div class="out_table">${e.goal_detail}</div>
					</c:forEach>
                </div>



                <div id="panel6" class="tab_panel">
                    <!--  <div id="tag_work" class="tag_table">
					<table>
						<tr class="table_upper">
							<th>目標名</th>
							<td><a href="/app/GoalUpdateServlet"> <img
									src="/app/img/edit.png" width="60" height="60"></a></td>
							<th></th>
							<td><input type="checkbox" id="achievement"></td>
						</tr>
					</table>
				</div>

				<div id="tag_all" class="tag_table">
					<table>
						<c:forEach var="e" items="${goalList}">
							<tr class="title">
								<td><div>目標ID ${e.goal_id}</div></td>
								<td><div>開始日 ${e.starting_date}</div></td>
								<td>～</td>
								<td><div>終了日 ${e.ending_date}</div></td>
								<td><div>目標名 ${e.goal_name}</div></td>
								<td><div>
										<a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}"> <img
											src="/app/img/edit.png" width="60" height="60"></a>
									</div></td>
								<td><div class="btn"></div></td>
							</tr>
							<tr class="content">
								<td>${e.goal_detail}</td>
							</tr>
						</c:forEach>
					</table>
                    </div>
                    -->
                    <c:forEach var="e" items="${goalList}">
					<table class="in_table">
							<tr>
								<!--  <td><div>目標ID <br>${e.goal_id}</div></td> -->
									<td><!--  開始日 --> ${e.starting_date}</td>
									<td>～</td>
									<td><!--終了日--> ${e.ending_date}</td>
									<td><!--目標名--> ${e.goal_name}</td>
									<td>
											<a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}"> <img
												src="/app/img/edit.png" width="40" height="40"></a>
									</td>
							</tr>
					</table>
					<div class="out_table">${e.goal_detail}</div>
					</c:forEach>
                </div>

            </div>
        </div>







		<!-- 参考サイト：https://shu-sait.com/tab-kirikae-box/ -->
		<!-- 目標名はSQLに接続してから -->
		<!-- 編集ボタンからの内部構造、SQLとのあれこれが必要そうです-->
		<!-- 詳細マウスオーバーのコード書いてないです…！-->

<!--

			<div class="goal_wrap">
				<form action="/app/GoalServlet" id="f0" method="POST">
					<input id="btn0" type="radio" name="tag" value="0"> <label
						for="tab0" class="tab_lab0_all">目標一覧</label>
				</form>

				<form action="/app/GoalServlet" id="f1" method="POST">
					<input id="btn1" type="radio" name="tag" value="1"> <label
						for="tab1" class="tab_lab1_work">仕事</label>
				</form>

				<form action="/app/GoalServlet" id="f2" method="POST">
					<input id="btn2" type="radio" name="tag" value="2"> <label
						for="tab2" class="tab_lab2_housework">家事</label>
				</form>

				<form action="/app/GoalServlet" id="f3" method="POST">
					<input id="btn3" type="radio" name="tag" value="3"> <label
						for="tab3" class="tab_lab3_hobby">趣味</label>
				</form>

				<form action="/app/GoalServlet" id="f4" method="POST">
					<input id="btn4" type="radio" name="tag" value="4"> <label
						for="tab4" class="tab_lab4_study">勉強</label>
				</form>

				<form action="/app/GoalServlet" id="f5" method="POST">
					<input id="btn5" type="radio" name="tag" value="5"> <label
						for="tab5" class="tab_lab5_etc">その他</label>
				</form>


				<div id="tag_work" class="tag_table">
					<table>
						<tr>
							<th>目標名</th>
  							<td><a href="/app/GoalUpdateServlet"> <img
									src="/app/img/edit.png" width="60" height="60"></a></td>
							<th></th>
							<td><input type="checkbox" id="achievement"></td>
						</tr>
					</table>
				</div>


				<div id="tag_all" class="tag_table">
					<table border="1">
						<c:forEach var="e" items="${goalList}">
							<tr class="title">
								<td><div>目標ID ${e.goal_id}</div></td>
								<td><div>開始日 ${e.starting_date}</div></td>
								<td>～</td>
								<td><div>終了日 ${e.ending_date}</div></td>
								<td><div>目標名 ${e.goal_name}</div></td>
								<td><div>

										<a href="/app/GoalUpdateServlet?goal_id=${e.goal_id}"> <img
											src="/app/img/edit.png" width="60" height="60"></a>
									</div></td>
								<td><div class="btn"></div></td>
							</tr>

							<tr class="content">
								<td>${e.goal_detail}</td>
							</tr>







						</c:forEach>
					</table>
				</div>
			</div>
-->

							<!--375にあったもの <ul id="links01"> -->
							<!-- <li>${e.goal_detail}</li> -->
							<!-- </ul> -->
							<!-- </div> -->
		<div class="goal_plus">
			<a href="/app/GoalRegistarServlet"><img
						src="/app/img/regist.png" width="140" height="140"></a>
		</div>

	</main>
	<!--  -->
	<div class="empty">
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
	</div>
		<script src="/app/js/goal.js"></script>
</body>
</html>




