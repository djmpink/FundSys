/**
 * Created by zl on 2/10/2015.
 */
$(document).ready(function () {

    //使用 Ajax 的方式 判断登录
    $("#btn_login").click(function () {
        var url = 'login.action';
        //获取表单值，并以json的数据形式保存到params中
        var params = {
            nickname: $("#nickname").val(),
            password: $("#password").val()
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
                        location.href = "./fund_trade_datatables.html";
                }
            },
            'json'  //数据传递的类型  json
        );
    });
});