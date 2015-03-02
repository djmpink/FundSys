package cn.no7player.fundsys.dao.impl;

import cn.no7player.fundsys.dao.FundTradeDataDao;
import cn.no7player.fundsys.po.FundTradeData;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by zl on 3/2/2015.
 */
public class FundTradeDataDaoImpl extends HibernateDaoSupport implements FundTradeDataDao{
    @Override
    public List getFundTradeDateByUserId(int userId){
        System.out.println("FundTradeDataDaoImpl : getFundTradeDateByUserId");
        return getHibernateTemplate().find("from FundTradeData where userId = ?", userId);
    }
}
