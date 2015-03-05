package cn.no7player.fundsys.service;

import cn.no7player.fundsys.po.User;

import java.util.List;

/**
 * Created by zl on 2/9/2015.
 */
public interface UserService {
    public String register(String receiveData);
    public String checkLogin(String receiveData);
//    public List<User> findUserByNickName(String name);
}
