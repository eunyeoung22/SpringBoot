$(function(){
	$('#updateDiv').hide();


});
	$('#searchIdBtn').click(function(){
		$('#resultDiv').empty();
		
		$.ajax({
			type : 'post',
			url : '/user/getUser',
			data : 'id='+ $('#searchId').val(),
			//dataType: 'json' ==>아이디 값이 없을 경우에는 json으로 받지 못해 error발생하므로 dataType을 아에 생략하면 알아서 받아준다.
			success:function(data){
				console.log(JSON.stringify(data));
				
				if(data == ''){
					$('#updateDiv').hide();
					$('#resultDiv').text('찾고자하는 아이디가 없습니다');
					$('#resultDiv').css('color','red').css('font-weight', 'bold').css('font-size', '8pt');
					
					}
				else{
					$('#updateDiv').show();
					
					$('#name').val(data.name);
					$('#id').val(data.id);
					$('#pwd').val(data.pwd);
					
					}
				},
				error:function(err){
					console.log(err);
				}
			});
		});
		
	$('#updateBtn').click(function(){
			$('#nameDiv').empty();
			$('#pwdDiv').empty();
			
		if($('#name').val() ==''){
			$('#nameDiv').text("이름을 입력하세요");
			$('#name').focus();
			
		}else if($('#pwd').val() ==''){
			$('#pwdDiv').text("비밀번호를 입력하세요");
			$('#pwd').focus();
			
		}else{
			
			$.ajax({
				type:'post',
				url:'/user/update',
				data : $('#updateForm').serialize(),
				success : function(){
					alert("수정완료하였습니다.");
					location.href="/user/list"
				},
				error:function(err){
					console.log(err);
				}
			});
		}
	});

//취소 버튼	
	$('#resetBtn').click(function(){
		//강제 이벤트 발생
		$('#searchIdBtn').trigger('click');
		
	});
