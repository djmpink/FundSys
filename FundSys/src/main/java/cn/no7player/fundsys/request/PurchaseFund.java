package cn.no7player.fundsys.request;

/**
 * Created by zl on 2/28/2015.
 */
public class PurchaseFund {

    private String code;
    private String name;
    private double purchaseCredit;
    private double purchaseShare;
    private double purchaseNetWorth;
    private double purchaseRate;
    private String purchaseDate;

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

    public double getPurchaseRate() {
        return purchaseRate;
    }

    public void setPurchaseRate(double purchaseRate) {
        this.purchaseRate = purchaseRate;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

}
