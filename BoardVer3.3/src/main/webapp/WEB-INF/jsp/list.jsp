<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=DM+Serif+Text:ital@1&display=swap');
	*{margin:0; padding:0; background-color: #F3EAE1;}
	a {text-decoration: none;}
	.record:hover {
		background-color: #bbb;
	}
	table, tr, td, th {
	border: 1px solid #000;
	border-collapse: collapse;
	width: 300px;
	margin-left: 35%;
	}
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
		<h1>Fucking JSP World</h1>
		<br>
		<div>
			<table>
				<tr>
					<th>No.</th>
					<th>Title</th>
					<th>DateTime</th>
				</tr>
	 			<c:forEach var="result" items="${data}">
		 			<tr class="record" onclick="Todetail(${result.iboard})">
						<td>${result.iboard}</td>
						<td>${result.title}</td>
						<td>${result.regidate}</td>
					</tr>	
				</c:forEach> 
			</table>
		</div>
		<br>
		<div><a href="/write"><input type="button" value="Write"></a></div>
	</div>
	<script>
		function Todetail(iboard) {
			location.href='/detail?iboard=' + iboard;
		}
	</script>
</body>
</html>