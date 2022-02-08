package bd.com.letsride.user.utilities;

import com.google.gson.GsonBuilder;

import bd.com.letsride.user.models.responseModels.DepositConfigData;
import bd.com.letsride.user.models.responseModels.SendOTPData;
import bd.com.letsride.user.models.responseModels.UserProfileData;
import bd.com.letsride.user.models.responseModels.VerifyOTPData;

public class ModelContainer {
    SendOTPData sendOTPData;
    VerifyOTPData verifyOTPData;
    UserProfileData userProfileData;
    DepositConfigData depositConfigData;


    public SendOTPData getSendOTPResponse() {
        return sendOTPData;
    }
    public void setSendOTPResponse(SendOTPData sendOTPData) {
        this.sendOTPData = sendOTPData;
    }


    public VerifyOTPData getVerifyOTPResponse() {
        return verifyOTPData;
    }
    public void setVerifyOTPResponse(VerifyOTPData verifyOTPData) {
        this.verifyOTPData = verifyOTPData;
    }


    public UserProfileData getUserProfileResponse() {
        return userProfileData;
    }
    public void setUserProfileResponse(UserProfileData userProfileData) {
        this.userProfileData = userProfileData;
    }


    public DepositConfigData getDepositConfigResponse() {
        return depositConfigData;
    }
    public void setDepositConfigResponse(DepositConfigData depositConfigData) {
        this.depositConfigData = depositConfigData;
    }


    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
