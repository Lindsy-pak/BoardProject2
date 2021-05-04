<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=DM+Serif+Text:ital@1&display=swap');
	*{margin:0; padding:0; background-color: #F3EAE1;}
	
	#wrap {
	margin-top: 50px;
	display: flex;
	flex-direction: column;
	justify-contents:center;
	align-contents:center;
	text-align: center;
	}
	#wrap h1 {
	font-size:100px;
	font-family: 'DM Serif Text', serif;
	color: #951515;
	}
</style>
</head>
<body>
	<div id="wrap">
		<form action="/write" method="post">
			<div><h1>Fucking JSP World</h1></div>
			<div><input type="button" value="List" onclick="goToBack()"></div>
			<div>제목<br><input type="text" name="title"></div>
			<div>내용<br><textarea name="ctnt" rows="10" cols="30"></textarea></div>
			<span><input type="submit" value="글등록">  <input type="reset" value="초기화"></span>
		</form>
	</div>
	<script>
		function goToBack() {
			history.back();
		}
	</script>
</body>
</html>