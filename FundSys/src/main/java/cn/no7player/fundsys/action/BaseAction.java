package cn.no7player.fundsys.action;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zl on 3/3/2015.
 */
public class BaseAction extends ActionSupport {
    private String data;
    private Object result;

    public static final Logger logger = LoggerFactory.getLogger(FundTradeAction.class);

    public String getData() {
        return data;
    }

    public void setData(String data) {
        logger.info("======================================");
        this.data = data;
        logger.info("ReceiveData : " + data.toString());
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String returnResult(String flag){
        logger.info("ReturnData : "+this.result.toString());
        return flag;
    }

    @Override
    public String execute() throws Exception {
        return returnResult(SUCCESS);
    }
}
