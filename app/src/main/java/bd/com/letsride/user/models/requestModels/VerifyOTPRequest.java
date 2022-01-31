package bd.com.letsride.user.models.requestModels;

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


}
