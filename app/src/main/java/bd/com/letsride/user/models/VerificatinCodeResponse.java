package bd.com.letsride.user.models;

import com.google.gson.annotations.SerializedName;

public class VerificatinCodeResponse {

    @SerializedName("source")
    private String source;

    @SerializedName("tacFor")
    private String tacFor;

    @SerializedName("countryCode")
    private String countryCode;

    @SerializedName("mobileNumber")
    private String mobileNumber;

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
