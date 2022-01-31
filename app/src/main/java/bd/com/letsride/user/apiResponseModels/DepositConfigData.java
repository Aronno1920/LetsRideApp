package bd.com.letsride.user.apiResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DepositConfigData {

    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("bonus")
    @Expose
    private Integer bonus;
    @SerializedName("isDefault")
    @Expose
    private Boolean isDefault;
    @SerializedName("sortOrder")
    @Expose
    private Integer sortOrder;
    @SerializedName("currency")
    @Expose
    private String currency;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
