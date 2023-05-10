$(function(){
	$.ajax({
		type: 'post',
		url : '/user/getuserList',
		
		success:function(data){
			console.log(data);
			for(var i=0; i<data.length; i++){
				var html = `<tr>
							<td align="center">${data[i].id}</td>
							<td align="cneter">${data[i].name}</td>
							</tr>`
				$('#userList').append(html);			
			}
			
		},
		error:function(err){
			console.log(err);
		}
	});
});

//검색
$('#searchBtn').click(function(){
	if($('#keyword').val()==='')
		alert('검색어를 입력하세요')
	else
		$.ajax({
			type:'post',
			url:'/user/search',
			data:$('#searchForm').serialize(),
			dataType:'json',
			success:function(data){
				$('#userList tr:gt(0)').remove;
				console.log(JSON.stringify(data));
				for(var i=0; i<data.length; i++){
				var html = `<tr>
							<td align="center">${data[i].id}</td>
							<td align="cneter">${data[i].name}</td>
							</tr>`
				$('#userList').append(html);
				}
			},
			error:function(err){
				console.log(err)
			}
		});
	
});