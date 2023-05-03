<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="uploadForm" enctype="multipart/form-data" action="/user/upload">
	<table border ="1">
		<tr>
			<td>상품명</td>
			<td><input type="text" name="imageName" size="35"></td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea  name="imageContent" rows="15" cols="50"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" >
				<img id="camera" src="../image/camera.png" width="30" height="30" alt="카메라">
				<input type="file" name="img[]" id="img" multiple="multiple" style="visibility:hidden;">
				<!-- 업로드 버튼을 누르기 전에 카메라 아이콘을 통해서 서낵한 이미지가 맞는지 확인하기 위해서 이미지를 보이게 한다. -->
				<img id="showImg" width="50" height="50">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" id="updateBtn" value="이미지 등록">
			</td>
		</tr>

	</table>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/upload.js"></script>
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