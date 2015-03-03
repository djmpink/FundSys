package cn.no7player.fundsys.dao.impl;

import cn.no7player.fundsys.dao.FundTradeDataDao;
import cn.no7player.fundsys.po.FundTradeData;
import org.springframework.dao.DataAccessException;
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

    @Override
    public int addFundTrade(FundTradeData fundTradeData) {
        int flag = -1;
        try {
            getHibernateTemplate().save(fundTradeData);
            flag = 0;
        } catch (DataAccessException e) {
            logger.error("FundTradeDataDaoImpl : purchaseFund error");
        }
        return flag;
    }

    @Override
    public List getFundTradeDateByCode(String code,int userId) {
        System.out.println("FundTradeDataDaoImpl : getFundTradeDateByCode");
        return getHibernateTemplate().find("from FundTradeData where code = ? and userId=? ", code,userId);
    }

    @Override
    public int updateFundTrade(FundTradeData fundTradeData) {
        int flag = -1;
        try {
            getHibernateTemplate().update(fundTradeData);
            flag = 0;
        } catch (DataAccessException e) {
            logger.error("FundTradeDataDaoImpl : purchaseFund error");
        }
        return flag;
    }


}
