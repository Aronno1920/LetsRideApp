package bd.com.letsride.user.models.responseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfileData {

    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("profilePhoto")
    @Expose
    private String profilePhoto;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("isProfileUpdated")
    @Expose
    private Boolean isProfileUpdated;
    @SerializedName("referralCode")
    @Expose
    private String referralCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Boolean getIsProfileUpdated() {
        return isProfileUpdated;
    }

    public void setIsProfileUpdated(Boolean isProfileUpdated) {
        this.isProfileUpdated = isProfileUpdated;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

}
