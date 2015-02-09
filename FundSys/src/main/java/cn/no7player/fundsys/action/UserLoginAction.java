package cn.no7player.fundsys.action;

import cn.no7player.fundsys.po.User;
import cn.no7player.fundsys.service.UserService;
import cn.no7player.fundsys.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by zl on 2/9/2015.
 */
public class UserLoginAction extends ActionSupport {
    private UserService userService;
    private User user;
    private static final Logger logger = LoggerFactory.getLogger(UserLoginAction.class);

    public UserLoginAction(){
        ApplicationContext context= InitApplicationContext.getApplicationContext();
        userService= (UserService) context.getBean("userService");
    }
    @Override
    public String execute() throws Exception {
        logger.info(user.getNickName());
        if (!isValid(user.getNickName())) {
            return INPUT;
        }
        if (!isValid(user.getPassword())) {
            return INPUT;
        }
        if(!userCheck(user)){
            System.out.println("INPUT");
            return INPUT;
        }
        logger.info("SUCCESS");
        ActionContext.getContext().getSession().put("user" , user);
        return SUCCESS;
    }
    public boolean isValid(String keyword) {
        return keyword != null && keyword != "";
    }
    public boolean userCheck(User user) {
        List<User> userList = userService.findUserByNickName(user.getNickName());
        if (userList == null || userList.size() < 1) {
            return false;
        }
        User checkUser = userList.get(0);
        System.out.println(checkUser.getNickName());
        if (user.getNickName().equals(checkUser.getNickName()) && user.getPassword().equals(checkUser.getPassword())) {
            return true;
        }
        addActionError("Username or password is wrong, please check!");
        return false;
    }
    public UserService getUserService() {
        return userService;
    }
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
