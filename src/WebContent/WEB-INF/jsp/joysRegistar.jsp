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
		joys登録 <br>

		<table>
		<tr>
			<th>joys名</th>
			<td><textarea name="joys名"></textarea></td>
		</tr>
		<tr>
			<th>詳細</th>
			<td><textarea name="詳細"></textarea></td>
	</tr>
	<tr>
			<th>ささやかor豪華選択</th>

				<td><input type="radio" name="ささやか" value="1" checked>ささやか</td>
				<td><input type="radio" name="豪華" value="2">豪華</td>
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