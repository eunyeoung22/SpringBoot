$(function(){
	$.ajax({
		type:'post',
		url:'/person/getPersonList',
		
		success:function(data){
			console.log(data);
			/*$.each(data,function(index,items){
				var contentHtml = 
				`<tr>`+
				`<td align="center"><img src="">`+items.photo+`</td>`+
				`<td align="center">`+items.name+`</td>`+
				`<td align="center">`+items.age+`</td>`+
				`</tr>`;
				$('#personList').append(contentHtml);
			})*/
			
			for(var i=0; i<data.length; i++){
				var html = `<tr>
							<td align="center">
							<img src="/storage/ ${data[i].photo}" width="100" height="100">
							</td>
							<td align="center">${data[i].name}</td>
							<td align="center">${data[i].age}</td>
							`
				$('#personList').append(html);
			}
		},
		error:function(err){
			console.log(err);
		}
		
	});
	
});