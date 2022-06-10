<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/registar.css">
</head>
<body>
	<header></header>
	<main>
		<h1>新規登録</h1>

		<table>
			<tr>
				<th>ユーザーID</th>
				<td><input type="text" placeholder="ユーザーID(1～12文字)"
					name="user_ID"></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="password" id="textPassword"
					placeholder="パスワード(8～12文字)" name="password"> <input
					type="button" id="buttonPassword" value="表示"
					onclick="return pushHideButton()"></td>
			</tr>
			<tr>
				<th>パスワード(確認用)</th>
				<td><input type="password" placeholder="パスワード(確認用)"
					name="password_confirm"></td>
			</tr>

			<tr>

				<td>
					<p>
					<span id="error_message"></span><br>
						<input type="submit" name="LOGIN" value="ログイン">
						<input type="reset" name="reset" value="リセット">
					</p>
					<span id="error_message"></span>

				</td>

			</tr>
		</table>
	</main>
	<footer></footer>

	<script src="js/registar.js"></script>
</body>
</html>