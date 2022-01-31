package bd.com.letsride.user.utilities;

import org.json.JSONException;

import bd.com.letsride.user.models.responseModels.SendOTPData;
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
}
