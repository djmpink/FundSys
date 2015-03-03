package cn.no7player.fundsys.dao;

import cn.no7player.fundsys.po.FundTradeData;

import java.util.List;

/**
 * Created by zl on 3/2/2015.
 */
public interface FundTradeDataDao {
    public List getFundTradeDateByUserId(int userId);
    public int addFundTrade(FundTradeData fundTradeData);
    public List getFundTradeDateByCode(String code,int userId);
    public int updateFundTrade(FundTradeData fundTradeData);
}
