package bd.com.letsride.user.models.responseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SendOTPData {

    @SerializedName("prefix")
    @Expose
    private String prefix;
    @SerializedName("expiryDate")
    @Expose
    private String expiryDate;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("tacFor")
    @Expose
    private String tacFor;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;

    public String getPrefix() {
        return prefix;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public String getSource() {
        return source;
    }

    public String getTacFor() {
        return tacFor;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
