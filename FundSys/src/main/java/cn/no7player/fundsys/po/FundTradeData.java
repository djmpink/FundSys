package cn.no7player.fundsys.po;

/**
 * Created by zl on 2/28/2015.
 */
public class FundTradeData {
    //`id`, `fundCode`, `fundName`, `purchaseCredit`, `purchaseShare`, `purchaseNetWorth`, `miniNetWorth`,
    // `purchaseFee`, `purchaseDate`, `saleShare`, `saleNetWorth`, `profit`, `saleFee`, `saleDate`, `earnings`, `userId`
    private int id;
    private String fundCode;
    private String fundName;
    private double purchaseCredit;
    private double purchaseShare;
    private double purchaseNetWorth;
    private double miniNetWorth;
    private double purchaseFee;
    private String purchaseDate;
    private double saleShare;
    private double saleNetWorth;
    private double earnings;
    private double profit;
    private double saleFee;
    private String saleDate;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public double getPurchaseCredit() {
        return purchaseCredit;
    }

    public void setPurchaseCredit(double purchaseCredit) {
        this.purchaseCredit = purchaseCredit;
    }

    public double getPurchaseShare() {
        return purchaseShare;
    }

    public void setPurchaseShare(double purchaseShare) {
        this.purchaseShare = purchaseShare;
    }

    public double getPurchaseNetWorth() {
        return purchaseNetWorth;
    }

    public void setPurchaseNetWorth(double purchaseNetWorth) {
        this.purchaseNetWorth = purchaseNetWorth;
    }

    public double getMiniNetWorth() {
        return miniNetWorth;
    }

    public void setMiniNetWorth(double miniNetWorth) {
        this.miniNetWorth = miniNetWorth;
    }

    public double getPurchaseFee() {
        return purchaseFee;
    }

    public void setPurchaseFee(double purchaseFee) {
        this.purchaseFee = purchaseFee;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getSaleShare() {
        return saleShare;
    }

    public void setSaleShare(double saleShare) {
        this.saleShare = saleShare;
    }

    public double getSaleNetWorth() {
        return saleNetWorth;
    }

    public void setSaleNetWorth(double saleNetWorth) {
        this.saleNetWorth = saleNetWorth;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getSaleFee() {
        return saleFee;
    }

    public void setSaleFee(double saleFee) {
        this.saleFee = saleFee;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
