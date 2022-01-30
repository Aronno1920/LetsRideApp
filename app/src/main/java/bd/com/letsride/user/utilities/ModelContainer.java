package bd.com.letsride.user.utilities;

import com.google.gson.GsonBuilder;

import bd.com.letsride.user.apiResponseModels.SendOTPData;

public class ModelContainer {
    SendOTPData sendOTPData;

    public SendOTPData getSendOTPResponse() {
        return sendOTPData;
    }

    public void setSendOTPResponse(SendOTPData sendOTPData) {
        this.sendOTPData = sendOTPData;
    }


    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
