package bd.com.letsride.user.models.requestModels;

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
}
