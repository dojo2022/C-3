<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果</title>
<link rel="stylesheet" type="text/css" href="css/result.css">
<link rel="stylesheet" type="text/css" href="css/color.css">
</head>
<body>
<header class="header">
		<div class="logo">
			<img src="/app/img/logo00.png" width="300" height="150">
		</div>
		<!-- <a href="/app/LoginServlet" class="logoutbtn"><div>ログアウト</div></a> -->
		<a href="/app/HintServlet" class="hint" target="_blank"><img src="/app/img/hint.png" width="60" height="60"></a>
	</header>

<!-- ここからメイン -->
<main>
<h1><c:out value="${result.title}" /></h1>

<hr>
<p><c:out value="${result.message}" /></p>



<hr>
<a href="${result.backTo}">${result.backToMessage}</a>


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