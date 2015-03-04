package cn.no7player.fundsys.response;

/**
 * Created by zl on 3/4/2015.
 */
public class GetFundTradeData {

    private String code;
    private String name;
    private double purchase;
    private double share;
    private double purchaseNetWorth;
    private double purchaseFee;
    private String purchaseDate;
    private double saleRate;

    private double avgPurchaseNetWorth;
    private double minNetWorth;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchase() {
        return purchase;
    }

    public void setPurchase(double purchase) {
        this.purchase = purchase;
    }

    public double getShare() {
        return share;
    }

    public void setShare(double share) {
        this.share = share;
    }

    public double getPurchaseNetWorth() {
        return purchaseNetWorth;
    }

    public void setPurchaseNetWorth(double purchaseNetWorth) {
        this.purchaseNetWorth = purchaseNetWorth;
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

    public double getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(double saleRate) {
        this.saleRate = saleRate;
    }

    public double getAvgPurchaseNetWorth() {
        return avgPurchaseNetWorth;
    }

    public void setAvgPurchaseNetWorth(double avgPurchaseNetWorth) {
        this.avgPurchaseNetWorth = avgPurchaseNetWorth;
    }

    public double getMinNetWorth() {
        return minNetWorth;
    }

    public void setMinNetWorth(double minNetWorth) {
        this.minNetWorth = minNetWorth;
    }
}
