<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
	<a href="/">
		<img src="../image/topicon.gif" width="80px" height="80px"/>
	</a>회원탈퇴
</h3>
<br>

<p>
	삭제할 아이디 입력 : <input type="text" id="searchId">
	<input type="button" id="deleteIdBtn" value="삭제">
</p>
<div id="resultDiv"></div>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/delete.js"></script>
</body>
</html>