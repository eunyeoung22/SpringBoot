<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</style>
</head>
<body>
<h3>
	<a href="/">
		<img src="../image/topicon.gif" width="80px" height="80px"/>
	</a>회원정보수정
</h3>
<br>

<p>
	수정할 아이디 입력 : <input type="text" id="searchId">
	<input type="button" id="searchIdBtn" value="검색">
</p>
<div id="resultDiv"></div>

<div id="updateDiv">
	<form id="updateForm">
		<table>
			<tr>
				<td>이름 </td>
				<td><input type="text" name="name" id="name"/>
				<div id="nameDiv"></div>
				</td>
			</tr>
			<tr>
				<td>아이디 </td>
				<td><input type="text" name="id" id="id" readonly="readonly"/>
				<div id="idDiv"></div>
				</td>
			</tr>
			<tr>
				<td>비밀번호 </td>
				<td><input type="password" name="pwd" id="pwd"/>
				<div id="pwdDiv"></div>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="수정" id="updateBtn">
				<input type="reset" value="취소" id="resetBtn">
				</td>
			</tr>
		
		</table>
	</form>
</div>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/update.js"></script>
</body>
</html>
