package cn.no7player.fundsys.action;

import cn.no7player.fundsys.po.User;
import cn.no7player.fundsys.service.UserService;
import cn.no7player.fundsys.util.ACKUtil;
import cn.no7player.fundsys.util.InitApplicationContext;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zl on 2/9/2015.
 */
public class RegisterAction extends BaseAction {
    private UserService userService;
    //private User user;


    private User user;

    public RegisterAction(){
        ApplicationContext context= InitApplicationContext.getApplicationContext();
        userService= (UserService) context.getBean("userService");
    }

    public String register(){
        String info=userService.register(getData());

        if(info.equals("SUCCESS")){
            logger.info("注册成功！");
            JSONObject jsonObject =new JSONObject();
            jsonObject.put("ACK", ACKUtil.SUCCESS);
            jsonObject.put("INFO",info);
            setResult(jsonObject);
        }else {
            logger.info("用户注册失败！");
            JSONObject jsonObject =new JSONObject();
            jsonObject.put("ACK", ACKUtil.ERROR);
            jsonObject.put("INFO",info);
            setResult(jsonObject);
        }
        return returnResult(SUCCESS);
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
