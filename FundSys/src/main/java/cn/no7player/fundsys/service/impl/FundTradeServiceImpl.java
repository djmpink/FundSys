package cn.no7player.fundsys.service.impl;

import cn.no7player.fundsys.dao.FundTradeDataDao;
import cn.no7player.fundsys.po.FundTradeData;
import cn.no7player.fundsys.response.GetFundTradeData;
import cn.no7player.fundsys.service.FundTradeService;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zl on 2/28/2015.
 */
public class FundTradeServiceImpl extends BaseServiceImpl implements FundTradeService{
    //JSONObject data;
    private FundTradeDataDao fundTradeDataDao;

    public FundTradeDataDao getFundTradeDataDao() {
        return fundTradeDataDao;
    }

    public void setFundTradeDataDao(FundTradeDataDao fundTradeDataDao) {
        this.fundTradeDataDao = fundTradeDataDao;
    }

    /**
     * 获取实时持有估算基金信息
     * @param userId
     * @return
     */
    @Override
    public List getFundTradeDateByUserId(int userId) {
        System.out.println("FundTradeServiceImpl : getFundTradeDateByUserId");

        List<FundTradeData> fundTradeDatas=fundTradeDataDao.getFundTradeDateByUserId(userId);
        //处理数据
        List<GetFundTradeData> getFundTradeDatas=new ArrayList<GetFundTradeData>();
        GetFundTradeData getFundTradeData=null;
        for(FundTradeData fundTradeData:fundTradeDatas){
            getFundTradeData=new GetFundTradeData();
            getFundTradeData.setCode(fundTradeData.getCode());
            getFundTradeData.setName(fundTradeData.getName());
            getFundTradeData.setPurchase(fundTradeData.getPurchase());
            getFundTradeData.setShare(fundTradeData.getShare());
            getFundTradeData.setPurchaseFee(fundTradeData.getPurchaseFee());
            getFundTradeData.setPurchaseDate(fundTradeData.getPurchaseDate());
            getFundTradeData.setSaleRate(fundTradeData.getSaleRate());
            getFundTradeData.setPurchaseNetWorth(fundTradeData.getPurchaseNetWorth());
            // X=(F+P)/(S*(1+R))
            logger.info("P:"+fundTradeData.getPurchase());
            logger.info("F:" + fundTradeData.getPurchaseFee());
            logger.info("S:" + fundTradeData.getShare());
            logger.info("R:"+fundTradeData.getSaleRate());
            logger.info("N:"+fundTradeData.getPurchaseNetWorth());

            double minNetWorth=(fundTradeData.getPurchase()+fundTradeData.getPurchaseFee())/(fundTradeData.getShare()*(1-(fundTradeData.getSaleRate()/100)));
            getFundTradeData.setMinNetWorth(minNetWorth);
            getFundTradeData.setAvgPurchaseNetWorth(fundTradeData.getPurchase()/fundTradeData.getShare());
            getFundTradeDatas.add(getFundTradeData);
        }

        return getFundTradeDatas;
    }

    /**
     * 购买新基金交易
     * @param receiveData
     * @param userId
     * @return
     */
    @Override
    public int addFundTrade(String receiveData,int userId) {
        System.out.println("FundTradeServiceImpl : purchaseFund");
        //解析收到的数据
        JSONObject data=JSONObject.fromObject(receiveData);

        String code=data.getString("fundCode");
        //获取数据库基金数据
        List<FundTradeData> fundTradeDatas=  fundTradeDataDao.getFundTradeDateByCode(code,userId);

        if(fundTradeDatas==null||fundTradeDatas.isEmpty()){//历史数据为空，新增一条基金
            logger.info("历史数据为空，新增一条基金");
            FundTradeData newFundTradeData=new FundTradeData();
            newFundTradeData.setCode(code);
            newFundTradeData.setName(data.getString("fundName"));
            newFundTradeData.setPurchase(data.getDouble("purchaseCredit"));
            newFundTradeData.setShare(data.getDouble("purchaseShare"));
            double purchaseFee=data.getDouble("purchaseCredit") - data.getDouble("purchaseShare")*data.getDouble("purchaseNetWorth");
            newFundTradeData.setPurchaseFee(purchaseFee);
            newFundTradeData.setPurchaseDate(data.getString("purchaseDate"));
            newFundTradeData.setPurchaseNetWorth(data.getDouble("purchaseNetWorth"));
            newFundTradeData.setSaleRate(data.getDouble("saleRate"));
            newFundTradeData.setUserId(userId);
            return fundTradeDataDao.addFundTrade(newFundTradeData);
        }else{//已存在现持有基金，叠加
            logger.info("已存在现持有基金，叠加");
            FundTradeData fundTradeData=fundTradeDatas.get(0);
            fundTradeData.setPurchase(data.getDouble("purchaseCredit")+fundTradeData.getPurchase());
            fundTradeData.setShare(data.getDouble("purchaseShare")+fundTradeData.getShare());
            double purchaseFee=data.getDouble("purchaseCredit") - data.getDouble("purchaseShare")*data.getDouble("purchaseNetWorth");
            fundTradeData.setPurchaseFee(purchaseFee+fundTradeData.getPurchaseFee());
            fundTradeData.setSaleRate(data.getDouble("saleRate"));
            fundTradeData.setUserId(userId);
            return fundTradeDataDao.updateFundTrade(fundTradeData);
        }
    }

    @Override
    public int saleFundTrade(String receiveData, int userId) {
        System.out.println("FundTradeServiceImpl : saleFundTrade");
        //解析收到的数据
        JSONObject data=JSONObject.fromObject(receiveData);

        String code=data.getString("saleCode");
        //获取数据库基金数据
        return 0;
    }

}
