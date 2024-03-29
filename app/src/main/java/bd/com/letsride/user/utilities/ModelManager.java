package bd.com.letsride.user.utilities;

import org.json.JSONException;

import bd.com.letsride.user.models.responseModels.BalanceData;
import bd.com.letsride.user.models.responseModels.DepositConfigData;
import bd.com.letsride.user.models.responseModels.SendOTPData;
import bd.com.letsride.user.models.responseModels.UserProfileData;
import bd.com.letsride.user.models.responseModels.VerifyOTPData;

public class ModelManager {

    private static ModelContainer modelContainer;
    private static ModelManager modelManager;

    //region Nothing to change
    private ModelManager() {
    }

    public static ModelManager getInstance() {
        if (modelManager == null) {
            synchronized (ModelManager.class) {
                modelManager = new ModelManager();
                modelContainer = new ModelContainer();
            }
        }
        return modelManager;
    }

    public static void removeModelsData() {
        modelContainer = null;
        modelManager = null;
    }
    //endregion

    public <T> void addToJson(T obj) throws JSONException {
        if (obj != null && obj instanceof SendOTPData) {
            modelContainer.setSendOTPResponse((SendOTPData) obj);
        }
        else if (obj != null && obj instanceof VerifyOTPData) {
            modelContainer.setVerifyOTPResponse((VerifyOTPData) obj);
        }
        else if (obj != null && obj instanceof UserProfileData) {
            modelContainer.setUserProfileResponse((UserProfileData) obj);
        }
        else if (obj != null && obj instanceof BalanceData) {
            modelContainer.setBalanceResponse((BalanceData) obj);
        }
        else if (obj != null && obj instanceof DepositConfigData) {
            modelContainer.setDepositConfigResponse((DepositConfigData) obj);
        } else {
            throw new JSONException("Object not found");
        }
    }

    public <T> T getObject(String className) {
        if (className.equalsIgnoreCase("SendOTPData")) {
            return (T) modelContainer.getSendOTPResponse();
        }
        else if (className.equalsIgnoreCase("VerifyOTPData")) {
            return (T) modelContainer.getVerifyOTPResponse();
        }
        else if (className.equalsIgnoreCase("UserProfileData")) {
            return (T) modelContainer.getUserProfileResponse();
        }
        else if (className.equalsIgnoreCase("BalanceData")) {
            return (T) modelContainer.getBalanceResponse();
        }
        else if (className.equalsIgnoreCase("DepositConfigData")) {
            return (T) modelContainer.getDepositConfigResponse();
        }
        return null;
    }
}
