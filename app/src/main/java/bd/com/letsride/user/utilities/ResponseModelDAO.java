package bd.com.letsride.user.utilities;

import org.json.JSONException;

import bd.com.letsride.user.apiResponseModels.SendOTPData;

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

}
