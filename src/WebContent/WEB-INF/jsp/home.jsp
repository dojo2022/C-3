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
<header>
<div><img src="/app/img/logo00.png" class="logo"></div>
<a href="/app/LoginServlet" class="LogoutBtn">ログアウト</a>
<a href="/app/HintServlet" class="hint" target="_blank"><img src="/app/img/hint.png"></a>
</header>

<!-- ここからメイン -->
<main>
</main>
<!--  -->
<footer>
<ul>
	<li><a href="/app/HomeServlet"><img src="/app/img/home.png" class="menu"></a></li>
	<li><a href="/app/GoalServlet"><img src="/app/img/check.png" class="menu"></a></li>
	<li><a href="/app/JoysServlet"><img src="/app/img/joys.png" class="menu"></a></li>
	<li><a href="/app/ProfileServlet"><img src="/app/img/profile.png" class="menu"></a></li>
</ul>
</footer>
<script src="js/home.js"></script>
</body>
</html>