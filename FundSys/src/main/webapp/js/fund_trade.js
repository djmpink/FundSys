/**
 * Created by zl on 2/28/2015.
 */


<!--js脚本-->

$(document).ready(function () {
    //获取表单值，并以json的数据形式保存到params中
    //var params = {
    //    id: $("#id").val()
    //};
    // Configuration for jqGrid Example 1
    $("#table_list_1").jqGrid({
        url: 'fundTrade.action',
        mtype:"POST",//提交方式
        //params:params,
        datatype: "json",
        height: auto,
        autowidth: true,
        shrinkToFit: true,
        rowNum: 14,
        rowList: [10, 20, 30],
        rownumbers:true,//添加左侧行号
        colNames: ['代码', '基金名称', '额度', '份额', '净值'],
        colModel: [
            {name: 'fundCode', index: 'fundCode', width: 60, sorttype: "string"},
            {name: 'fundName', index: 'fundName', width: 90, sorttype: "string"},
            {name: 'tradeCredit', index: 'tradeCredit', width: 100,sorttype:"float" },
            {name: 'tradeShare', index: 'tradeShare', width: 80, align: "right", sorttype: "float"},
            {name: 'netWorth', index: 'netWorth', width: 80, align: "right", sorttype: "float"},
        ],
        pager: "#pager_list_1",
        viewrecords: true,
        caption: "Example jqGrid 1",
        hidegrid: false
    });


    // Add responsive to jqGrid
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#table_list_1').setGridWidth(width);
    });
});

