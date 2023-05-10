<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>
<img src="http://localhost:8080/image/topicon.gif" width="80px" height="80px"
		  onclick="location.href='/'" style="cusor:pointer"/>
	목록
</h2>

<table id="userList" border="1" frame="hsides" rules="rows">
	<tr id="titlelist">
		<th width="150">아이디</th>
		<th width="150">이름</th>
	</tr> 
	<!-- 동적 처리 -->
	
</table>
<br><br>
<div style="width:450px; text-align:center;">
	<form id="searchForm">
		<select id="searchOption" name="searchOption">
			<option value="name">이름</option>
			<option value="id">아이디</option>
		</select>
		<input type="text" id="keyword" name="keyword">
		<input type="button" id="searchBtn" value="검색">
	</form>
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/list.js"></script>
</body>
</html>