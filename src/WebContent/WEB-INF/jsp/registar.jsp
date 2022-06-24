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
<form id="registar_form"  form name ="form"   method="POST" action="/app/RegistarServlet">
		<table>
			<tr >

				<td><input type="text"  class="user_id"  pattern="^[0-9a-zA-Z]{1,12}"    placeholder="ユーザーID" name="user_id" required></td>
			</tr>
			<tr >

				<td><input type="password"   class ="password"    pattern="^[0-9a-zA-Z]{8,12}" id="textPassword"placeholder="パスワード半角英数字(8～12文字)" name="password" required><br>
				<input type="checkbox" id="password-check">パスワードを表示する</td>
			</tr>
			<tr>

				<td ><input type="password"  class="password_confirm" pattern="^[0-9a-zA-Z]{8,12}"  placeholder="パスワード(確認用)"name="password_confirm" ></td>
			</tr>

			<tr>

				<td>
					<p>
						<span id="error_message"></span><br>
						<input type="reset"name="reset" value="リセット">
						<input id="touroku" type="submit"name="registar" value="登録">
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
	<!-- フッター被り解決 -->
	<div class = "empty"></div>

	<footer>
		<a href="/app/HintServlet">
			<img src="/app/img/hint.png" width="25" height="25"  >POMEについて詳しく知りたい方はこちらへ
			<!-- ヒントマークの余白の関係で、文字の上に引っ付いているように見える、上と左の余白を盛る、文字とか大きさ調整 -->
		</a>
	</footer>

	<script src="js/registar.js"></script>
</body>
</html>