//jQuery time
var current_fs, next_fs, previous_fs; //fieldsets
var left, opacity, scale; //fieldset properties which we will animate
var animating; //flag to prevent quick multi-click glitches
//$(function(){
//
//})

$(".next").click(function(){
	if(animating) return false;
	animating = true;

	current_fs = $(this).parent();
	next_fs = $(this).parent().next();

	//activate next step on progressbar using the index of next_fs
	//$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

	//show the next fieldset
	next_fs.show();
	//hide the current fieldset with style
	current_fs.animate({opacity: 0}, {
		step: function(now, mx) {
			//as the opacity of current_fs reduces to 0 - stored in "now"
			//1. scale current_fs down to 80%
			scale = 1 - (1 - now) * 0.2;
			//2. bring next_fs from the right(50%)
			left = (now * 50)+"%";
			//3. increase opacity of next_fs to 1 as it moves in
			opacity = 1 - now;
			current_fs.css({'transform': 'scale('+scale+')'});
			next_fs.css({'left': left, 'opacity': opacity});
		},
		duration: 800,
		complete: function(){
			current_fs.hide();
			animating = false;
		},
		//this comes from the custom easing plugin
		easing: 'easeInOutBack'
	});
});

$(".previous").click(function(){
	if(animating) return false;
	animating = true;

	current_fs = $(this).parent();
	previous_fs = $(this).parent().prev();

	//de-activate current step on progressbar
	//$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");

	//show the previous fieldset
	previous_fs.show();
	//hide the current fieldset with style
	current_fs.animate({opacity: 0}, {
		step: function(now, mx) {
			//as the opacity of current_fs reduces to 0 - stored in "now"
			//1. scale previous_fs from 80% to 100%
			scale = 0.8 + (1 - now) * 0.2;
			//2. take current_fs to the right(50%) - from 0%
			left = ((1-now) * 50)+"%";
			//3. increase opacity of previous_fs to 1 as it moves in
			opacity = 1 - now;
			current_fs.css({'left': left});
			previous_fs.css({'transform': 'scale('+scale+')', 'opacity': opacity});
		},
		duration: 800,
		complete: function(){
			current_fs.hide();
			animating = false;
		},
		//this comes from the custom easing plugin
		easing: 'easeInOutBack'
	});
});

$(".submit").click(function () {
	var url = 'register.action';
	//获取表单值，并以json的数据形式保存到params中
	var params = {
		email: $("#email").val(),
		nickname: $("#nickname").val(),
		password: $("#password").val(),
		repassword: $("#repassword").val(),
		mobile: $("#mobile").val()
	};
	//使用$.post方式
	$.post(
		url,        //服务器要接受的url
		params,     //传递的参数
		function (json) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据
			var member = eval("(" + json + ")");    //包数据解析为json 格式
			switch (member.name) {
				case "error1" :
					$('#span1').html("用户" + params.nickname + "不存在！");
					break;
				case "error2" :
					$('#span1').html("用户" + params.nickname + "已注销！");
					break;
				case "error3" :
					$('#span1').html("用户" + params.nickname + "的密码不正确！");
					break;
//                            case "clerk" :
//                                location.href = "<%=path%>/clerkIndex.jsp";
//                            case "manager" :
//                                location.href = "<%=path%>/managerIndex.jsp";
				case "admin" :
					location.href = "../html/login.html";
			}
		},
		'json'  //数据传递的类型  json
	);
})