package bd.com.letsride.user.models.responseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyOTPData {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("isProfileUpdated")
    @Expose
    private Boolean isProfileUpdated;
    @SerializedName("userId")
    @Expose
    private String userId;
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

    public String getToken() {
        return token;
    }

    public Boolean getProfileUpdated() {
        return isProfileUpdated;
    }

    public String getUserId() {
        return userId;
    }

    public Object getSource() {
        return source;
    }

    public Object getTacFor() {
        return tacFor;
    }

    public Object getCountryCode() {
        return countryCode;
    }

    public Object getMobileNumber() {
        return mobileNumber;
    }
}
