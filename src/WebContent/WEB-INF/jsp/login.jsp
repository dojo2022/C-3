<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<header> </header>
	<main>

		<h3>
			ToDo管理アプリのように登録し<br> 達成したときには褒めてもらえるアプリ
		</h3>
		<img src="/app/img/logo.PNG" width="260" height="140" alt="POME">

		<table>
			<tr>
				<td><input type="text" value="" placeholder="ユーザーID"
					name="user_ID"></td>
			</tr>


			<tr>
		<td><input type="password" value="" placeholder="ユーザーID"
				name="user_ID"></td>
			</tr></table>

		<input type="submit" name="login" value="ログイン">
		<a href="registar.jsp">新規登録</a>
	</main>
	<footer></footer>
	<p>POME</p>
	<script src="js/login.js"></script>
</body>
</html>