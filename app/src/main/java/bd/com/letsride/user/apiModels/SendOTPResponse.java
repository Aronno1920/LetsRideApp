package bd.com.letsride.user.apiModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendOTPResponse {

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

    public SendOTPResponse(String prefix, String expiryDate, Boolean isActive, String source, String tacFor, String countryCode, String mobileNumber) {
        this.prefix = prefix;
        this.expiryDate = expiryDate;
        this.isActive = isActive;
        this.source = source;
        this.tacFor = tacFor;
        this.countryCode = countryCode;
        this.mobileNumber = mobileNumber;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTacFor() {
        return tacFor;
    }

    public void setTacFor(String tacFor) {
        this.tacFor = tacFor;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
