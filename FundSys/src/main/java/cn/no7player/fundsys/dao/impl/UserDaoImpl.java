package cn.no7player.fundsys.dao.impl;

import cn.no7player.fundsys.dao.UserDao;
import cn.no7player.fundsys.po.User;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by zl on 2/9/2015.
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
    @Override
    public int addUser(User user) {
        int flag = -1;
        String nickName = user.getNickname();
        if(findUserByNickName(nickName).size() == 0){
            try {
                getHibernateTemplate().save(user);
                flag = 0;
            } catch (DataAccessException e) {
                flag = -1;
            }
        } else {
            flag = 1;
        }
        return flag;
    }

    @Override
    public List findUserByNickName(String nickName) {
        return getHibernateTemplate().find("from User where nickName = ?",nickName);
    }
}
