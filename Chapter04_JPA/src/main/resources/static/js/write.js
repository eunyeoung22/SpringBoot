//등록
$('#writeBtn').click(function(){
	$.ajax({
		type : 'post',
		url : '/user/write',
		data: $('#writeForm').serialize(),//문자열 형식으로 가져감
		success:function(){
			alert('등록완료');
			location.href='/user/list';
		},
		error:function(err){
			console.log(err);
		}
		
	});
});

//아이디 중복체크
$('#id').focusout(function(){
	$('#idDiv').empty();
	
	if($('#id')==null){
		$('#idDiv').text('먼저 아이디를 입력');
		$('#id').focus();
	}else{
		$.ajax({
			type: 'post',
			url : '/user/isExistId',
			data: 'id=' + $('#id').val(),
			dataType:'text',
			success:function(data){
				if(data=='exist'){
					$('#idDiv').text('사용 불가능');
					$('#idDiv').css('color','red');
				}else if(data =='non_exist'){
					$('#idDiv').text('사용 가능');
					$('#idDiv').css('color','blue');
				}
			},
			error:function(err){
				console.log(err)
			}
		});
	}
});
