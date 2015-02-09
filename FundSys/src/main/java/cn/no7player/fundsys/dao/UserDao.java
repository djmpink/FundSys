package cn.no7player.fundsys.dao;

import cn.no7player.fundsys.po.User;

import java.util.List;

/**
 * Created by zl on 2/9/2015.
 */
public interface UserDao {
    public String addUser(User user);
    public List findUserByNickName(String nickName);
}
