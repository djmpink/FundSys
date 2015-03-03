package cn.no7player.fundsys.service.impl;

import cn.no7player.fundsys.dao.FundTradeDataDao;
import cn.no7player.fundsys.po.FundTradeData;
import cn.no7player.fundsys.request.PurchaseFund;
import cn.no7player.fundsys.service.FundTradeService;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * Created by zl on 2/28/2015.
 */
public class FundTradeServiceImpl implements FundTradeService{
    JSONObject data;
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

    @Override
    public int addFundTrade(String receiveData,int userId) {
        System.out.println("FundTradeServiceImpl : purchaseFund");
        data=JSONObject.fromObject(receiveData);
        String code=data.getString("fundCode");
        List<FundTradeData> fundTradeDatas=  fundTradeDataDao.getFundTradeDateByCode(code, userId);

        if(fundTradeDatas==null||fundTradeDatas.isEmpty()){
            System.out.println("1111111111");
            FundTradeData newFundTradeData1=new FundTradeData();
            newFundTradeData1.setCode(code);
            newFundTradeData1.setName(data.getString("fundCode"));
            newFundTradeData1.setPurchase(data.getDouble("purchaseCredit"));
            newFundTradeData1.setShare(data.getDouble("purchaseShare"));
            newFundTradeData1.setPurchaseFee(data.getDouble("purchaseRate") * data.getDouble("purchaseCredit"));
            newFundTradeData1.setPurchaseDate(data.getString("purchaseDate"));
            newFundTradeData1.setUserId(userId);
            return fundTradeDataDao.addFundTrade(newFundTradeData1);
        }else{
            System.out.println("222222222222");
            FundTradeData fundTradeData=fundTradeDatas.get(0);
            fundTradeData.setPurchase(data.getDouble("purchaseCredit")+fundTradeData.getPurchase());
            fundTradeData.setShare(data.getDouble("purchaseShare")+fundTradeData.getShare());
            fundTradeData.setPurchaseFee(data.getDouble("purchaseRate") * data.getDouble("purchaseCredit")+fundTradeData.getPurchaseFee());
            fundTradeData.setUserId(userId);
            return fundTradeDataDao.updateFundTrade(fundTradeData);
        }




    }

}
