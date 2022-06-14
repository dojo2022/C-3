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
	<header>
	</header>

	<!-- ここからメイン -->
	<main>

		<h3>
			ToDo管理アプリのように登録し<br> 達成したときには褒めてもらえるアプリ
		</h3>
		<img src="/app/img/logo00.png" width="260" height="140" alt="POME">

		<form id="login_form" method="POST" action="/app/LoginServlet">
		<table>
			<tr>
				<td><input type="text" value="" placeholder="ユーザーID"
					name="user_ID"></td>
			</tr>


			<tr>
		<td><input type="password" value="" placeholder="パスワード"
				name="password"></td>
			</tr></table>

		<input type="submit" name="login" value="ログイン">
		</form>
		<a href="RegistarServlet">新規登録</a>
	</main>
	<!--  -->

	<footer>
<a href = "HintServlet">
<img src="/app/img/hint.png" width="25" height="25" >POMEについて詳しく知りたい方はこちらへ
</a >

	</footer>

	<script src="js/login.js"></script>
</body>
</html>