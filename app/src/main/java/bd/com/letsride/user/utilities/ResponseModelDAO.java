package bd.com.letsride.user.utilities;

import org.json.JSONException;

import bd.com.letsride.user.models.responseModels.DepositConfigData;
import bd.com.letsride.user.models.responseModels.SendOTPData;
import bd.com.letsride.user.models.responseModels.UserProfileData;
import bd.com.letsride.user.models.responseModels.VerifyOTPData;

public class ResponseModelDAO {

    private ModelManager modelManager = ModelManager.getInstance();

    public void addSendOTPResponseToDAO(SendOTPData sendOTPData) {
        try {
            modelManager.addToJson(sendOTPData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public SendOTPData getSendOTPResponse() {
        return (SendOTPData) modelManager.getObject("SendOTPData");
    }


    public void addVerifyOTPResponseToDAO(VerifyOTPData verifyOTPData) {
        try {
            modelManager.addToJson(verifyOTPData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public VerifyOTPData getVerifyOTPResponse() {
        return (VerifyOTPData) modelManager.getObject("VerifyOTPData");
    }

    public void addUserProfileResponseToDAO(UserProfileData userProfileData) {
        try {
            modelManager.addToJson(userProfileData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public UserProfileData getUserProfileResponse() {
        return (UserProfileData) modelManager.getObject("UserProfileData");
    }



    public void addDepositConfigResponseToDAO(DepositConfigData depositConfigData) {
        try {
            modelManager.addToJson(depositConfigData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public DepositConfigData getDepositConfigResponse() {
        return (DepositConfigData) modelManager.getObject("DepositConfigData");
    }
}
