$(function(){
	$.ajax({
		type : 'post',
		url : '/user/getUserList',
		data : 'pg=' + $('#pg').val(),
		dataType: 'json',
		success:function(data){
			console.log(JSON.stringify(data));
			console.log(data.list[0].name);
			
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align:'center',
					text : items.name
				})).append($('<td/>',{
					align:'center',
					text : items.id
				})).append($('<td/>',{
					align:'center',
					text : items.pwd
				})).appendTo($('#userListTable'));
			});//each
			
			//페이징 처리
			$('#boardPagingDiv').html(data.boardPaging.pagingHTML);
		},
		error: function(err){
			console.log(err)
		}
		
	});
	
});


