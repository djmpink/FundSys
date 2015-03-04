package cn.no7player.fundsys.service.impl;

import cn.no7player.fundsys.dao.UserDao;
import cn.no7player.fundsys.po.User;
import cn.no7player.fundsys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zl on 2/9/2015.
 */
public class UserServiceImpl extends BaseServiceImpl implements UserService {
    private UserDao userDao;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> findUserByNickName(String name) {
        return userDao.findUserByNickName(name);
    }
}
