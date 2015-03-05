package cn.no7player.fundsys.action;

import cn.no7player.fundsys.service.UserService;
import cn.no7player.fundsys.util.ACKUtil;
import cn.no7player.fundsys.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;

/**
 * Created by zl on 2/9/2015.
 */
public class UserLoginAction extends BaseAction {
    private UserService userService;
    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    // 用户Ajax返回数据

    public UserLoginAction(){
        ApplicationContext context= InitApplicationContext.getApplicationContext();
        userService= (UserService) context.getBean("userService");
    }

    public String checkLogin(){
        //验证登陆信息
        String info="SUCCESS";
        logger.info("checkLogin");
        Integer userId=(Integer)ActionContext.getContext().getSession().get("userId");
        JSONObject jsonObject =new JSONObject();
        if(userId==null||userId<0){
            logger.info("LOGIN");
            info="Login";

            jsonObject.put("ACK", ACKUtil.ERROR);
            jsonObject.put("INFO",info);
            setResult(jsonObject);
            //return returnResult(LOGIN);
        }else {
            logger.info("SUCCESS");

            jsonObject.put("ACK", ACKUtil.SUCCESS);
            jsonObject.put("INFO",info);

        }
        setResult(jsonObject);
        return returnResult(SUCCESS);

    }

    public String login(){
        String info="SUCCESS";

        info=userService.checkLogin(getData());
        if(info.equals("SUCCESS")){
            JSONObject jsonObject =new JSONObject();
            jsonObject.put("ACK", ACKUtil.SUCCESS);
            jsonObject.put("INFO",info);
            setResult(jsonObject);
        }else{
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

}
