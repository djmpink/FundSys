package cn.no7player.fundsys.service.impl;

import cn.no7player.fundsys.dao.FundTradeDataDao;
import cn.no7player.fundsys.service.FundTradeService;

import java.util.List;

/**
 * Created by zl on 2/28/2015.
 */
public class FundTradeServiceImpl implements FundTradeService{
    private FundTradeDataDao fundTradeDataDao;

    public FundTradeDataDao getFundTradeDataDao() {
        return fundTradeDataDao;
    }

    public void setFundTradeDataDao(FundTradeDataDao fundTradeDataDao) {
        this.fundTradeDataDao = fundTradeDataDao;
    }

    @Override
    public List getFundTradeDateByUserId(int userId) {
        System.out.println("FundTradeServiceImpl : getFundTradeDateByUserId");
        return fundTradeDataDao.getFundTradeDateByUserId(userId);
    }
}
