package bd.com.letsride.user.models;

public class CreditPurchaseModel {

    private Integer Amount;
    private Integer BonusAmount;

    public CreditPurchaseModel(Integer amount, Integer bonusAmount) {
        Amount = amount;
        BonusAmount = bonusAmount;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public Integer getBonusAmount() {
        return BonusAmount;
    }

    public void setBonusAmount(Integer bonusAmount) {
        BonusAmount = bonusAmount;
    }
}
