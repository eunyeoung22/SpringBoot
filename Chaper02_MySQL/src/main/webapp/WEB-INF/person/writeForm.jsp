<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="writeForm">
<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<th>이름 </th>
		<td><input type="text"  name="name" id="name" /></td>
		<div class="nameDiv"></div>
	</tr>
	<tr>
		<th>나이 </th>
		<td><input type="text" name="age" id="age" /></td>
		<div class="ageDiv"></div>
	</tr>
	<tr>
		<td colspan="2" >
			<img id="showImg" width="50" height="50">
			<img id="camera" src="/image/camera.png" width="30" height="30" alt="카메라">
			<input type="file" name="img" id="img" multiple="multiple" style="visibility:hidden;">
			<!-- 업로드 버튼을 누르기 전에 카메라 아이콘을 통해서 서낵한 이미지가 맞는지 확인하기 위해서 이미지를 보이게 한다. -->
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="button" id="writeBtn" value="이미지 등록">
		</td>
	</tr>
</table>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="/js/write.js"></script>
<script type="text/javascript">
$('#camera').click(function(){
	//강제 이벤트 발생
	$('#img').trigger('click');
	
});
$('#img').change(function(){
	readURL(this);
});
function readURL(input){
	var reader = new FileReader();
	
	reader.onload = function(e){
		$('#showImg').attr('src',e.target.result);//target-이벤트가 발생하는 요소를 반환해준다.
	}
	reader.readAsDataURL(input.files[0]);
}
</script>

</body>
</html>