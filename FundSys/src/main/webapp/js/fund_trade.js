/**
 * Created by zl on 3/2/2015.
 */
//TODO
var check_login=0;
window.onload = checkLogin();
function checkLogin() {

    var url = 'checkLogin.action';
    //使用$.post方式
    $.post(
        url,        //服务器要接受的url
        function (json) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据
            if(!(typeof json == 'object')){
                alert(0);
            }
            switch (json.ACK) {
                case 1 :
                    check_login=1;
                    break;
                case -1 :
                    alert("尚未登录，去登录");
                    location.href = "../login.html";
                    //$('#span1').html("用户" + params.nickname + "已注销！");
                    break;
            }


        },
        'json'  //数据传递的类型  json
    );

}


$(document).ready(function() {
    //if(check_login==0){
    //    return
    //}

    $('#table_fund_trade').dataTable( {
        "ajax": {
            "url": "getFundTradeData.action",
            "type": "POST",
            "data":{
                "title":$("title").eq(0).text()
            }
        },

        "columns": [
            { "data": "code" },
            { "data": "name" },
            { "data": "purchase" },
            { "data": "share" },
            { "data": "purchaseNetWorth" },
            { "data": "purchaseFee" },
            { "data": "purchaseDate" },
            { "data": "saleRate" },
            { "data": "avgPurchaseNetWorth" },
            { "data": "minNetWorth" }
        ]
    } );
} );



//使用 Ajax 的方式 发送新增
$("#btn_confirm_purchase").click(function () {
    var url = 'purchaseFund.action';
    //获取表单值，并以json的数据形式保存到params中

    var params = {

        fundCode: $("#code").val(),
        fundName: $("#name").val(),
        purchaseCredit: $("#purchaseCredit").val(),
        purchaseShare: $("#purchaseShare").val(),
        purchaseNetWorth: $("#purchaseNetWorth").val(),
        purchaseDate: $("#purchaseDate").val(),
        saleRate:$("#saleRate").val()

    };
    var jsData = JSON.stringify(params);
    //使用$.post方式
    $.post(
        url,        //服务器要接受的url
        {"data":jsData},     //传递的参数
        function (json) { //服务器返回后执行的函数 参数 data保存的就是服务器发送到客户端的数据
            if(!(typeof json == 'object')){
                alert(0);
            }
            switch (json.ACK) {
//                case "error1" :
//                    $('#span1').html("用户" + params.nickname + "不存在！");
//                    break;
//                case "error2" :
//                    $('#span1').html("用户" + params.nickname + "已注销！");
//                    break;
//                case "error3" :
//                    $('#span1').html("用户" + params.nickname + "的密码不正确！");
//                    break;
////                            case "clerk" :
////                                location.href = "<%=path%>/clerkIndex.jsp";
////                            case "manager" :
////                                location.href = "<%=path%>/managerIndex.jsp";
                case 1 :
                    window.location.reload();
            }


        },
        'json'  //数据传递的类型  json
    );
});
