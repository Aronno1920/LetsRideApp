package bd.com.letsride.user.models.responseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BalanceData {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("currentBalance")
    @Expose
    private Integer currentBalance;
    @SerializedName("balanceExpiryDate")
    @Expose
    private String balanceExpiryDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("currency")
    @Expose
    private String currency;

    public String getType() {
        return type;
    }

    public Integer getCurrentBalance() {
        return currentBalance;
    }

    public String getBalanceExpiryDate() {
        return balanceExpiryDate;
    }

    public String getStatus() {
        return status;
    }

    public String getCurrency() {
        return currency;
    }
}
