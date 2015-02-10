package cn.no7player.fundsys.action;

import cn.no7player.fundsys.po.User;
import cn.no7player.fundsys.service.UserService;
import cn.no7player.fundsys.util.InitApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zl on 2/9/2015.
 */
public class RegisterAction extends ActionSupport {
    private UserService userService;
    //private User user;
    private String email;
    private String nickname;
    private String password;
    private String repassword;
    private String mobile;
    // 用户Ajax返回数据
    private String result;
    private User user;


    private static final Logger logger = LoggerFactory.getLogger(RegisterAction.class);

    public RegisterAction(){
        ApplicationContext context= InitApplicationContext.getApplicationContext();
        userService= (UserService) context.getBean("userService");
    }
    @Override
    public String execute() throws Exception {
//        user=new User();
//        user.setNickname(nickname);
//        user.setPassword(password);
//        System.out.println("========================================");
//        logger.info("User",user.getNickname());
//        if (!isValid(user.getNickname())) {
//            return INPUT;
//        }
//        if (!isValid(user.getPassword())) {
//            return INPUT;
//        }
//        if(!userCheck(user)){
//            System.out.println("INPUT");
//            return INPUT;
//        }
        logger.info("SUCCESS");
       // ActionContext.getContext().getSession().put("user" , user);

        // 用一个Map做例子
        Map<String, String> map = new HashMap<String, String>();

        // 为map添加一条数据，记录一下页面传过来loginName
        map.put("name", this.nickname);

        // 将要返回的map对象进行json处理
        JSONObject jo = JSONObject.fromObject(map);

        // 调用json对象的toString方法转换为字符串然后赋值给result
        this.result = jo.toString();

        // 可以测试一下result
        System.out.println(this.result);

        return SUCCESS;
    }
//    public boolean isValid(String keyword) {
//        return keyword != null && keyword != "";
//    }
//    public boolean userCheck(User user) {
//        List<User> userList = userService.findUserByNickName(user.getNickname());
//        if (userList == null || userList.size() < 1) {
//            return false;
//        }
//        User checkUser = userList.get(0);
//        System.out.println(checkUser.getNickname());
//        if (user.getNickname().equals(checkUser.getNickname()) && user.getPassword().equals(checkUser.getPassword())) {
//            return true;
//        }
//        addActionError("Username or password is wrong, please check!");
//        return false;
//    }
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
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
