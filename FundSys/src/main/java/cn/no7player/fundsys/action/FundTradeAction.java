package cn.no7player.fundsys.action;

import cn.no7player.fundsys.po.FundTradeData;
import cn.no7player.fundsys.service.FundTradeService;
import cn.no7player.fundsys.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by zl on 2/28/2015.
 */
public class FundTradeAction extends BaseAction {

    private FundTradeService fundTradeService;

    public FundTradeAction(){
        ApplicationContext context= InitApplicationContext.getApplicationContext();
        fundTradeService= (FundTradeService) context.getBean("fundTradeService");
    }

    public String purchaseFund(){
        //验证登陆信息
        Integer userId=(Integer)ActionContext.getContext().getSession().get("userId");
        if(userId==null||userId<0){
            return INPUT;
        }

        //验证成功，已登陆
        logger.info("验证成功，已登陆");
        int flag=fundTradeService.addFundTrade(getData(),userId);

        logger.info("fundTradeDates");
        if(flag!=0){
            return INPUT;
        }

        // 调用json对象的toString方法转换为字符串然后赋值给result

        JSONObject jsonObject =new JSONObject();
        jsonObject.put("ACK",1);
        setResult(jsonObject);

        return returnResult(SUCCESS);
    }

    public String getFundTradeData(){
//验证登陆信息
        Integer userId=(Integer)ActionContext.getContext().getSession().get("userId");
        if(userId==null||userId<0){
            return INPUT;
        }
        logger.info("验证成功，已登陆");
        //验证成功，已登陆
        logger.info("userId: "+userId);
        List<FundTradeData> fundTradeDates=fundTradeService.getFundTradeDateByUserId(userId);
        logger.info("fundTradeDates");
        JSONArray jsonArray = JSONArray.fromObject(fundTradeDates);

        // 调用json对象的toString方法转换为字符串然后赋值给result

        JSONObject jsonObject =new JSONObject();
        jsonObject.put("data",jsonArray);

        setResult(jsonObject);

        return returnResult(SUCCESS);
    }


    public FundTradeService getFundTradeService() {
        return fundTradeService;
    }

    public void setFundTradeService(FundTradeService fundTradeService) {
        this.fundTradeService = fundTradeService;
    }

}
