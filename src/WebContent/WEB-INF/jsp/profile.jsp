<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>プロフィール</title>
<link rel="stylesheet" type="text/css" href="css/profile.css">
</head>
<body>
<header class="header">
            <div class="logo"><img src="/app/img/logo00.png"  width="300" height="150"></div>
            <a href="/app/LoginServlet" class="logoutbtn"><div>ログアウト</div></a>
            <a href="/app/HintServlet" class="hint" target="_blank"><img src="/app/img/hint.png" width="60" height="60"></a>
        </header>

<!-- ここからメイン -->
<main>

<form method="POST" id="profile_form" action="/app/ResuultServlet">



<h1><img src="/app/img/profile.png" width="50" height="50">PROFILE</h1>
<input type="file" name="IMAGE" accept="image/*" onchange="previewImage(this);"><br>
		<canvas id="preview" style="max-width:200px;"></canvas><br>
<div>まことさん</div>
<div>所持ポイント<br>
	 0ポイント<br>
</div>
<div>累計ポイント<br>
	 0ポイント<a href="/app/RankingServlet">(ランキング)</a><br>
</div>
<select name = "color">
<option value = color1>デフォルトカラー</option>
<option value = color1>ダークカラー</option>
</select>

<input type="radio" name="edit" value="yes">編集する
<input type="radio" name="edit" value="no" checked>編集しない<br>

</form>

<input type="submit" name="SUBMIT" value="更新" ><br>
達成済みリスト
	<div id="table">
	<table id="list">


	<!-- <c:forEach var="e" items="${ 目標名のスコープのやつ}">
		<tr>
			<td>${e.目標名 }</td>

		</tr>
		</c:forEach>-->
	</table>
	</div>
	</form>
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


<script src="js/profile.js"></script>
</body>
</html>