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
<div><img src="/app/img/joys.png" width="80" height="80"><h1>joys更新・削除</h1></div>
<div><img src="/app/img/logo.png" width="80" height="80"></div>
<a href="/app/LoginServlet" class="LogoutBtn">ボタン</a>
<a href="/app/HintServlet" class="hint"><img src="hint"></a>
</header>
<footer>
<ul>
	<li><a href="/app/HomeServlet"><img src="/app/img/home"></a></li>
	<li><a href="/app/GoalServlet"><img src="/app/img/check"></a></li>
	<li><a href="/app/JoysServlet"><img src="/app/img/joys"></a></li>
	<li><a href="/app/ProfileServlet"><img src="/app/img/profile"></a></li>
</ul>
</footer>
<script src="js/home.js"></script>
</body>
</html>