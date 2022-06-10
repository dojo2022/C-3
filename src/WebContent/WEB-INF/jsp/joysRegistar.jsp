<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/joysRegistar.css">
<title>joys登録</title>

</head>
<body>
<head>

</head>
<main>

	<form method="post" action="">
		<h1>joys登録</h1>


		<table>
			<tr>
				<th>joys名</th>
			</tr>
			<tr>
				<td><input type="text" name="reward_name" placeholder="アイス"></input></td>
			</tr>
			<tr>
				<th>詳細</th>
			</tr>
			<tr>
				<td><input type="text" name="reward_detail"
					placeholder="チョコモナカジャンボを大人買い"></input></td>
			</tr>
			<tr>
				<th>ささやかor豪華選択</th>
			</tr>
			<tr>
				<td><input type="radio" name="reward_level_id" value="1">ささやか</td>
				<td><input type="radio" name="reward_level_id" value="2">豪華</td>
			</tr>
			<tr>
				<td><input type="submit" value="登録"></td>
			</tr>
		</table>
	</form>

</main>

<footer> </footer>

<script src="js/joysRegistar.js"></script>
</body>
</html>