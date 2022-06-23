<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POME | 目標編集</title>
<link rel="icon" type="image/png" href="/app/img/favicon.ico"/>
<!-- ↑ファビコン設定　タブ左やブックマーク時に表示されるアイコン -->
<link rel="apple-touch-icon" type="image/png"
	href="app/img/pome_favicon.png">
<!-- ↑アップルタッチアイコン　スマホのホーム画面に追加したときに表示されるアイコン -->

<link rel="stylesheet" type="text/css" href="/app/css/goalUpdate.css">
</head>
<body>
        <header class="header">
            <div class="logo"><img src="/app/img/logo00.png"  width="300" height="150"></div>
            <a href="/app/LoginServlet" class="logoutbtn"><div>ログアウト</div></a>
            <a href="/app/HintServlet" class="hint" target="_blank"><img src="/app/img/hint.png" width="60" height="60"></a>
        </header>

	<!-- ここからメイン -->
	<main>
	<c:forEach var="e" items="${goalList}">


		<form method="post" action="">
			<div class="img">
				<img src="/app/img/joys.png" width="80" height="80">
				<h1>目標更新・削除</h1>
			</div>

			<table>
			<tr>
			<td><input type="text" name="goal_id" value= "${e.goal_id}" >
			</td>

			</tr>


				<tr>
					<th>目標名</th>
				</tr>
				<tr>
					<td><input type="text" name="goal_name" value="${e.goal_name}" required></input></td>
				</tr>
				<tr>
					<th>詳細</th>
				</tr>
				<tr>
					<td><input type="text" name="goal_detail"
						value = "${e.goal_detail}"></input></td>
				</tr>
				<tr>
					<th>期間</th>
				</tr>
				<tr>
					<td><input type="radio" name="term_id" value="1"
					<c:if test ="${e.term_id == '1' }">checked </c:if>required>終日</td>
					<td><input type="radio" name="term_id" value="2"
					<c:if test ="${e.term_id == '2' }">checked </c:if>>繰り返し</td>
					<td><input type="radio" name="term_id" value="3"
					<c:if test ="${e.term_id == '3' }">checked </c:if>>長期</td>
				</tr>
				<tr>
					<th>達成難易度</th>
				</tr>
				<tr>
					<td><input type="radio" name="difficulty_id" value="1"
					<c:if test ="${e.difficulty_id == '1' }">checked </c:if> required>簡単</td>
					<td><input type="radio" name="difficulty_id" value="2"
					<c:if test ="${e.difficulty_id == '2' }">checked </c:if>>難しい</td>
				</tr>

				<tr>
					<th>日付</th>
				</tr>
				<tr>
					<td><input type="date" name="starting_date" value = "${e.starting_date}" required></td>

<!-- 開始日はjavaScriptで今日の日付を生成し自動入力されていると便利かも。 -->
<!-- 開始日が本日以前は入力できない形でもよさそう -->

					<td>～</td>
					<td><input type="date" name="ending_date" value = "${e.ending_date}"></td>
				</tr>

				<tr>
					<th>タグ</th>
				</tr>
				<tr>
					<td><input type="radio" name="tag_id" value="1"
					<c:if test ="${e.tag_id == '1' }">checked </c:if>required>仕事</td>
					<td><input type="radio" name="tag_id" value="2"
					<c:if test ="${e.tag_id == '2' }">checked </c:if>>家事</td>
					<td><input type="radio" name="tag_id" value="3"
					<c:if test ="${e.tag_id == '3' }">checked </c:if>>趣味</td>
					<td><input type="radio" name="tag_id" value="4"
					<c:if test ="${e.tag_id == '4' }">checked </c:if>>勉強</td>
					<td><input type="radio" name="tag_id" value="5"
					<c:if test ="${e.tag_id == '5' }">checked </c:if>>その他</td>


				</tr>
				<tr>
					<td><input type="submit" name="SUBMIT" value="更新"></td>
					<td><input type="submit" name="SUBMIT" value="削除"></td>

				</tr>
			</table>
		</form>

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

	<script src="js/goalUpdate.js"></script>
</body>
</html>

