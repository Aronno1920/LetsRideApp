package bd.com.letsride.user.apiRequestModels;

public class VerifyOTPRequest {

    private String source;
    private String tacFor;
    private String countryCode;
    private String mobileNumber;
    private String prefix;
    private String tac;

    public VerifyOTPRequest(String source, String tacFor, String countryCode, String mobileNumber, String prefix, String tac) {
        this.source = source;
        this.tacFor = tacFor;
        this.countryCode = countryCode;
        this.mobileNumber = mobileNumber;
        this.prefix = prefix;
        this.tac = tac;
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getTac() {
        return tac;
    }

    public void setTac(String tac) {
        this.tac = tac;
    }
}
