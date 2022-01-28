package bd.com.letsride.user.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerificationRequestResponse {

    @SerializedName("prefix")
    @Expose
    private String prefix;
    @SerializedName("expiryDate")
    @Expose
    private String expiryDate;
    @SerializedName("isActive")
    @Expose
    private Object isActive;
    @SerializedName("source")
    @Expose
    private Object source;
    @SerializedName("tacFor")
    @Expose
    private Object tacFor;
    @SerializedName("countryCode")
    @Expose
    private Object countryCode;
    @SerializedName("mobileNumber")
    @Expose
    private Object mobileNumber;


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

    public Object getIsActive() {
        return isActive;
    }

    public void setIsActive(Object isActive) {
        this.isActive = isActive;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTacFor() {
        return tacFor;
    }

    public void setTacFor(Object tacFor) {
        this.tacFor = tacFor;
    }

    public Object getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Object countryCode) {
        this.countryCode = countryCode;
    }

    public Object getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Object mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}