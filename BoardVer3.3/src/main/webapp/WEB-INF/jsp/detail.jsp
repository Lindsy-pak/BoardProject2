<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
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
		<div><h1>Fucking JSP World</h1></div>
		<div><input type="button" value="list" onclick="goToBack()"></div>
		
		<div>제목<br>${data.title}</div>
		<div>내용<br>${data.ctnt}</div>
		<br>
		<span>
			<a href="/mod?iboard=${param.iboard}"><input type="submit" value="수정"></a>
			<a href="/del?iboard=${param.iboard}"><input type="button" value="삭제"></a>
			<input type="reset" value="초기화">
		</span> 
	</div>
	<script>
		function goToBack() {
			history.back();
		}
	</script>
</body>
</html>