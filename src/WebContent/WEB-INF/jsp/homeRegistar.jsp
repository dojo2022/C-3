<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POME | 目標登録</title>

<link rel="icon" type="image/png" href="/app/img/favicon.ico" />
<!-- ↑ファビコン設定　タブ左やブックマーク時に表示されるアイコン -->
<link rel="apple-touch-icon" type="image/png"
	href="app/img/pome_favicon.png">
<!-- ↑アップルタッチアイコン　スマホのホーム画面に追加したときに表示されるアイコン -->
<link rel="stylesheet" type="text/css" href="/app/css/goalRegistar.css">
<link rel="stylesheet" type="text/css" href="/app/css/color.css">
</head>
<body>
	<header class="header">
		<div class="logo">
			<img src="/app/img/logo00.png" width="300" height="150">
		</div>
		<a id="logout" href="/app/LogoutServlet" class="logoutbtn"><div>ログアウト</div></a>
		<a href="/app/HintServlet" class="hint" target="_blank"><img
			src="/app/img/hint.png" width="60" height="60"></a>
	</header>

	<!-- ここからメイン -->
	<main>

		<form method="POST" action="/app/GoalRegistarServlet">
			<div class="home_title">
				<img src="/app/img/check.png" width="120" height="120"
					class="home_title_img">
				<h1 class="home_title_h1">目標登録</h1>
			</div>

			<div class="goal_info_wrapper">
				<table>
					<tr>
						<th class="th_left"><span>目標名</span></th>
						<td colspan="5"><input class="textwidth" type="text"
							name="goal_name" placeholder="" required></td>
					</tr>
					<tr>
						<th class="th_left"><span>詳細</span></th>
						<td colspan="5"><input class="textwidth" type="text"
							name="goal_detail" placeholder="1000文字まで"></td>
					</tr>
					<tr>
						<th class="th_left"><span>期間</span></th>
						<td><input id="終日" type="radio" name="term_id" value="1"
							required><label class="radio_label" for="終日">終日</label></td>
						<td><input id="繰り返し" type="radio" name="term_id" value="2"><label
							class="radio_label" for="繰り返し">繰り返し</label></td>
						<td><input id="長期" type="radio" name="term_id" value="3"><label
							class="radio_label" for="長期">長期</label></td>
					</tr>


					<tr>
						<th class="th_left"><span>日付</span></th>
						<td>
							<div id="app">
								<input type="date" min="<%=request.getAttribute("today")%>"
									name="starting_date" onchange="Registar_JSP()" required>
							</div>
						</td>

						<!-- 開始日はjavaScriptで今日の日付を生成し自動入力されていると便利かも。 -->
						<!-- 開始日が本日以前は入力できない形でもよさそう -->

						<td>～</td>
						<td><input type="date"
							min="<%=request.getAttribute("today")%>" name="ending_date"
							onchange="homeRegistar_JSP()" required></td>
					</tr>

					<tr>
						<th class="th_left"><span>達成難易度</span></th>
						<td><input type="radio" id="簡単" name="difficulty_id"
							value="1" required><label class="radio_label" for="簡単">簡単</label></td>
						<td><input type="radio" id="難しい" name="difficulty_id"
							value="2"><label class="radio_label" for="難しい">難しい</label></td>
					</tr>

					<tr>
						<th class="th_left"><span>タグ</span></th>
						<td><input type="radio" id="仕事" name="tag_id" value="1"
							required><label class="radio_label work" for="仕事">仕事</label></td>
						<td><input type="radio" id="家事" name="tag_id" value="2"><label
							class="radio_label housework" for="家事">家事</label></td>
						<td><input type="radio" id="趣味" name="tag_id" value="3"><label
							class="radio_label hobby" for="趣味">趣味</label></td>
						<td><input type="radio" id="勉強" name="tag_id" value="4"><label
							class="radio_label study" for="勉強">勉強</label></td>
						<td><input type="radio" id="その他" name="tag_id" value="5"><label
							class="radio_label etc" for="その他">その他</label></td>


					</tr>
					<tr>
						<td colspan="3"><input type="submit" name=""
							class="update_button" value="登録"></td>

					</tr>
				</table>
			</div>
		</form>
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

	<script src="js/goalRegistar.js"></script>
</body>
</html>