package cn.no7player.fundsys.service.impl;

import cn.no7player.fundsys.dao.UserDao;
import cn.no7player.fundsys.po.User;
import cn.no7player.fundsys.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zl on 2/9/2015.
 */
public class UserServiceImpl extends BaseServiceImpl implements UserService {
    private UserDao userDao;
    //private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String register(String receiveData) {
        //解析收到的数据
        JSONObject data=JSONObject.fromObject(receiveData);
        String email=data.getString("email");
        String nickname=data.getString("nickname");
        String password=data.getString("password");
        String mobile=data.getString("mobile");


        User user=new User();
        user.setNickname(nickname);
        user.setPassword(password);
        user.setEmail(email);
        user.setMobile(mobile);

        String info="SUCCESS";
        String msg=checkRegister(user);
        if(!msg.equals("SUCCESS")){
            info=msg;
            return info;
        }
        userDao.addUser(user);
        return info;

    }
    private String checkRegister(User user){
        String info="SUCCESS";
        if(user==null){
            logger.error("user is null");
            info="用户信息为空";
            return info;
        }
        if(user.getNickname()==null||user.getNickname().equals("")||user.getNickname().length()>255){
            logger.error("nickname is null");
            info="用户昵称信息为空";
            return info;
        }
        if(user.getPassword()==null||user.getPassword().equals("")||user.getPassword().length()>255){
            logger.error("password is null");
            info="用户密码信息为空";
            return info;
        }
        if(user.getEmail()==null||user.getEmail().equals("")||user.getEmail().length()>255){
            logger.error("email is null");
            info="用户Email信息为空";
            return info;
        }
        if(user.getMobile()==null||user.getMobile().equals("")||user.getMobile().length()>255){
            logger.error("mobile is null");
            info="用户电话信息为空";
            return info;
        }
        return info;
    }

    @Override
    public String checkLogin(String receiveData) {
        //解析收到的数据
        JSONObject data=JSONObject.fromObject(receiveData);

        String nickname=data.getString("nickname");
        String password=data.getString("password");
        String info="SUCCESS";
        if (!isValid(nickname)) {
            info="用户名为空";
            return info;
        }
        if (!isValid(password)) {
            info="密码为空";
            return info;
        }
        User user=new User();
        user.setNickname(nickname);
        user.setPassword(password);

        int userId=userCheck(user);
        if(userId<=0){
            logger.info("USER LOGIN　ERROR!");
            info="用户信息有误/不存在";
            return info;
        }
        logger.info("SUCCESS");
        ActionContext.getContext().getSession().put("userId" , userId);

        return info;
    }

    public int userCheck(User user) {
        List<User> userList = findUserByNickName(user.getNickname());
        if (userList == null || userList.size() < 1) {
            return -1;
        }
        User checkUser = userList.get(0);
        System.out.println(checkUser.getNickname());
        if (user.getNickname().equals(checkUser.getNickname()) && user.getPassword().equals(checkUser.getPassword())) {
            return checkUser.getId();
        }
        return -1;
    }

    public boolean isValid(String keyword) {
        return keyword != null && keyword != "";
    }

    public List<User> findUserByNickName(String name) {
        return userDao.findUserByNickName(name);
    }
}
