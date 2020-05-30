function tishi() {
	swal({
		title: "暂未开放",
		text: "该功能暂未开放,敬请期待！"
	});
}

//首页点赞
function dianzan() {
	$.ajax({
		type:'POST',       /* 请求类型 GET / POST */
		url:'/boke/clickDianzan',  /* 服务URI ，用相对地址 */
		dataType: 'json', /* 期望服务器返回的数据类型 */
		success: function(resp){  /* 已经将服务器返回的数据转成 JS对象 */
			document.getElementById('dianzan').innerHTML=resp.number+'点赞';
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert("其他错误:" + jqXHR.status);
		}
	});
}