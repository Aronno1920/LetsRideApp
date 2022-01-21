package bd.com.letsride.user.models;

public class CreditPurchaseModel {

    private String Amount;
    private String BonusAmount;

    public CreditPurchaseModel(String amount, String bonusAmount) {
        Amount = amount;
        BonusAmount = bonusAmount;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getBonusAmount() {
        return BonusAmount;
    }

    public void setBonusAmount(String bonusAmount) {
        BonusAmount = bonusAmount;
    }
}
