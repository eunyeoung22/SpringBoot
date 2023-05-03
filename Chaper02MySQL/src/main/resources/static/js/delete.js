$(function(){
	$('#deleteIdBtn').click(function(){
		$('#resultDiv').empty();
		
		
		$.ajax({
			type : 'post',
			url : '/user/getUser',
			data : 'id='+ $('#searchId').val(),
			//dataType: 'json' ==>아이디 값이 없을 경우에는 json으로 받지 못해 error발생하므로 dataType을 아에 생략하면 알아서 받아준다.
			success:function(data){
				console.log(JSON.stringify(data));
				
				if(data == ''){		
					$('#resultDiv').text('삭제할 아이디를 입력하세요');
					$('#resultDiv').css('color','red').css('font-weight', 'bold').css('font-size', '8pt');
					
					}
				else{
					//삭제
					if(confirm('삭제하시겠습니까?')){
							$.ajax({
								type : 'post',
								url : '/user/delete',
								data : 'id='+ $('#searchId').val(),
								success : function(){
									alert("회원정보를 삭제하였습니다.");
									location.href='/user/list';
									},
								error:function(err){
									console.log(err);
									}
						});
					
					}//if
				}
			},
				error:function(err){
					console.log(err);
				}
			});
		});
	});