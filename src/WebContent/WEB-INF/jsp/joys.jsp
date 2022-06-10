<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/joys.css">
<title>joys一覧</title>
</head>
<body>
<header>

</header>

<main>
<h1>joys一覧</h1>

<table>
		<tr>
			<th></th>
			<th>joys名</th>
			<th>必要ポイント数</th>
			<th></th>
		</tr>

		<c:forEach var = "e" items="${}">
		<tr>

		</tr>

		</c:forEach>
//頑張る

</table>



</main>

<footer>
</footer>
<script src="js/joys.js"></script>
</body>
</html>