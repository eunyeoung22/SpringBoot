<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#currentPaging{
	color : red;
	text-decoration: underline;
	cursor:pointer;
}	
#paging{
	color:black;
	text-decoration: underline;
	cursor:pointer;
}

</style>
</head>
<body>
<h1 >
	<a href="/">
		<img src="../image/topicon.gif" width="80px" height="80px"/>
	</a>목록
</h1>
<input type="text" id="pg" value="${pg }">
<table id="userListTable" border="1" frame="hsides" rules="rows">
	<tr>
		<th width="150">이름</th>
		<th width="150">아이디</th>
		<th width="150">비밀번호</th>
	</tr>
	<!-- 동적 처리 -->
	
</table>

<div id="boardPagingDiv" style= "margin-top:15px; width: 450px; text-align:center;" >
<!--${boardPaging.getPagingHTML() }  -->
</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
function boardPaging(pg){
	location.href = "/user/list?pg="+pg;
	
}
</script>
<script type="text/javascript" src="../js/list.js">

</script>
</body>
</html>