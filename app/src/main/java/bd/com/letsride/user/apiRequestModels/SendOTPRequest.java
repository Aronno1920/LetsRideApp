package bd.com.letsride.user.apiRequestModels;

public class SendOTPRequest {
    private String source;
    private String tacFor;
    private String countryCode;
    private String mobileNumber;

    public SendOTPRequest(String source, String tacFor, String countryCode, String mobileNumber) {
        this.source = source;
        this.tacFor = tacFor;
        this.countryCode = countryCode;
        this.mobileNumber = mobileNumber;
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
