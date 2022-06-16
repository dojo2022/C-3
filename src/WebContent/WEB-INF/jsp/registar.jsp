<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<link rel="stylesheet" type="text/css" href="css/registar.css">
</head>
<body>
	<header> </header>
	<!-- ここからメイン -->
	<main>
		<h1>新規登録</h1>
<form id="registar_form" method="POST" action="/app/RegistarServlet">
		<table>
			<tr>

				<td><input type="text" placeholder="ユーザーID(1～12文字)"name="user_id" required></td>
			</tr>
			<tr>

				<td><input type="password" id="textPassword"placeholder="パスワード(8～12文字)" name="password" required>
				<input type="button" id="buttonPassword" value="表示"onclick="return pushHideButton()"></td>
			</tr>
			<tr>

				<td><input type="password" placeholder="パスワード(確認用)"name="password_confirm" ></td>
			</tr>

			<tr>

				<td>
					<p>
						<span id="error_message"></span><br>
						<input id="touroku" type="submit"name="registar" value="登録">
						<input type="reset"name="reset" value="リセット">
					</p>

				</td>
			</tr>
			<tr>
				<td>
					<a href="/app/LoginServlet">
					戻る
					</a>
				</td>
			</tr>

		</table>
		</form>
	</main>
	<!--  -->

	<footer>
		<a href="/app/HintServlet">
			<img src="/app/img/hint.png" width="25" height="25"  >POMEについて詳しく知りたい方はこちらへ
			<!-- ヒントマークの余白の関係で、文字の上に引っ付いているように見える、上と左の余白を盛る、文字とか大きさ調整 -->
		</a>
	</footer>

	<script src="js/registar.js"></script>
</body>
</html>