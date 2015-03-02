/**
 * Created by zl on 3/2/2015.
 */
$(document).ready(function() {

    $('#table_fund_trade').dataTable( {
        "ajax": {
            "url": "fundTrade.action",
            "type": "POST",
            "data":{
                "title":$("title").eq(0).text()
            }
        },
    //<th>代码</th>
    //<th>名称</th>
    //<th>买入额度</th>
    //<th>买入份额</th>
    //<th>买入净值</th>
    //<th>最低期望净值</th>
    //<th>买入手续费</th>
    //<th>买入日期</th>
    //<th>卖出份额</th>
    //<th>卖出净值</th>
    //<th>纯收益（总）</th>
    //<th>利润</th>
    //<th>卖出手续费</th>
    //<th>卖出日期</th>
        "columns": [
            { "data": "fundCode" },
            { "data": "fundName" },
            { "data": "purchaseCredit" },
            { "data": "purchaseShare" },
            { "data": "purchaseNetWorth" },
            { "data": "miniNetWorth" },
            { "data": "purchaseFee" },
            { "data": "purchaseDate" },
            { "data": "saleShare" },
            { "data": "saleNetWorth" },
            { "data": "earnings" },
            { "data": "profit" },
            { "data": "saleFee" },
            { "data": "saleDate" }

        ]
    } );
} );