package bd.com.letsride.user.models.responseModels;

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

    public Integer getBonus() {
        return bonus;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public String getCurrency() {
        return currency;
    }
}
