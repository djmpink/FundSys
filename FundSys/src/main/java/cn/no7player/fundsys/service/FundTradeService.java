package cn.no7player.fundsys.service;

import cn.no7player.fundsys.po.FundTradeData;

import java.util.List;

/**
 * Created by zl on 2/28/2015.
 */
public interface FundTradeService {
    public List getFundTradeDateByUserId(int userId);
    public int addFundTrade(String receiveData,int userId);
    public int saleFundTrade(String receiveData,int userId);

}
