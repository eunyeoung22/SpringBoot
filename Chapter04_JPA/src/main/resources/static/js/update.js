$(function(){
	$('#updateDiv').hide();
});


$('#searchIdBtn').click(function(){
	$('#resultDiv').empty();
	
	
	if($('#searchId').val()==='')
		$('#resultDiv').text('아이디를 입력하세요');
	else
		$.ajax({
			type:'post',
			url:'/user/getuser',
			data:'searchId=' + $('#searchId').val(),
			
			success:function(data){
				
				if(data=='null'){
					$('#updateDiv').hide();
					$('#resultDiv').text('찾고자하는 ID가 없습니다.')
					$('#resultDiv').css('color','red')
					$('#resultDiv').css('font-weight', '500')
					}
				else{
					$('#updateDiv').show();
					
					$('#id').val(data.id)
					$('#name').val(data.name)
			
				}
			},
			error:function(err){
				console.log(err);
			}
		});
		
	
});