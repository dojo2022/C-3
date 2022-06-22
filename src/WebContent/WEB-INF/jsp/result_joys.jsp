<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Joys交換リザルト</title>
<link rel="stylesheet" type="text/css" href="css/result.css">
<link rel="stylesheet" type="text/css" href="css/color.css">
</head>
<body>
<header class="header">
		<div class="logo">
			<img src="/app/img/logo00.png" width="300" height="150">
		</div>
		<!--  <a href="/app/LoginServlet" class="logoutbtn"><div>ログアウト</div></a>-->
		 <a href="/app/HintServlet" class="hint" target="_blank"><img src="/app/img/hint.png" width="60" height="60"></a>
	</header>

<!-- ここからメイン -->
<main>

<h1>交換成功！</h1>
<hr>

	<p>「${reward_name}」ができるようになりました！</p>
	<p>現在の保持ポイントは${minushaving_point}ポイントです</p>
	<img src="/app/img/1.png" >


<hr>


<a href="/app/JoysServlet">Joys一覧へ戻る</a>


</main>

		<footer class="footer">
           <!--   <ul class="footer-ul">
                <li class="footer-li"><a href="/app/HomeServlet"><img src="/app/img/home.png" width="60" height="60"><br><div>Home</div></a></li>
                <li class="footer-li"><a href="/app/GoalServlet"><img src="/app/img/check.png" width="60" height="60"><br><div class="footer-li-goal">目標一覧</div></a></li>
                <li class="footer-li"><a href="/app/JoysServlet"><img src="/app/img/joys.png" width="60" height="60"><br><div>Joys</div></a></li>
                <li class="footer-li"><a href="/app/ProfileServlet"><img src="/app/img/profile.png" width="60" height="60"><br><div>マイプロフィール</div></a></li>
            </ul>-->
        </footer>

<script src="js/result.js"></script>
</body>
</html>