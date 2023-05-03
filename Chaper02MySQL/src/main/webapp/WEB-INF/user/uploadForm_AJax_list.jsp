<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="uploadForm_Ajax_List" enctype="multipart/form-data" action="/chapter06_SpringWebMaven/user/upload">
	<table id="upImageList" border="1" frame="hsides" rules="rows" cellspacing="0" cellpadding="5">
		<tr>
			<th width="150">번호</th>
			<th width="150">이미지</th>
			<th width="150">상품명</th>
		</tr>
		<!-- 동적 처리 -->
		
	</table>

</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/upload.js">

</script>
</body>
</html>