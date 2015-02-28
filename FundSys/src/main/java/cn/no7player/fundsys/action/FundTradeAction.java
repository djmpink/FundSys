package cn.no7player.fundsys.action;

import cn.no7player.fundsys.po.FundTradeDate;
import cn.no7player.fundsys.service.FundTradeService;
import cn.no7player.fundsys.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by zl on 2/28/2015.
 */
public class FundTradeAction extends ActionSupport {
    //private String id;
    private FundTradeService fundTradeService;
    private Object result;
    private static final Logger logger = LoggerFactory.getLogger(RegisterAction.class);
    public FundTradeAction(){
        ApplicationContext context= InitApplicationContext.getApplicationContext();
        fundTradeService= (FundTradeService) context.getBean("fundTradeService");
    }
    @Override
    public String execute() throws Exception {

        System.out.println("========================================");

        List<FundTradeDate> fundTradeDates=new ArrayList<FundTradeDate>();
        FundTradeDate  fundTradeDate=new FundTradeDate();
        fundTradeDate.setFundCode("123");
        fundTradeDate.setFundName("申万正");

        fundTradeDate.setTradeCredit(100.0);
        fundTradeDate.setTradeShare(10.0);
        fundTradeDate.setNetWorth(1.0);
        fundTradeDates.add(fundTradeDate);
        JSONArray ja = JSONArray.fromObject(fundTradeDates);

        // 调用json对象的toString方法转换为字符串然后赋值给result
        this.result =ja;

        // 可以测试一下result
        logger.info(this.result.toString());
        logger.info("SUCCESS");
        return SUCCESS;
    }

    public FundTradeService getFundTradeService() {
        return fundTradeService;
    }

    public void setFundTradeService(FundTradeService fundTradeService) {
        this.fundTradeService = fundTradeService;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
