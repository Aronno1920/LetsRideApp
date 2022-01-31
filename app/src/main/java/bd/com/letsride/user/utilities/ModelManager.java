package bd.com.letsride.user.utilities;

import org.json.JSONException;
import bd.com.letsride.user.models.responseModels.SendOTPData;
import bd.com.letsride.user.models.responseModels.VerifyOTPData;

public class ModelManager {

    private static ModelContainer modelContainer;
    private static ModelManager modelManager;

    //region All methods to manage Model Manager
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
        } else if (obj != null && obj instanceof VerifyOTPData) {
            modelContainer.setVerifyOTPResponse((VerifyOTPData) obj);
        } else {
            throw new JSONException("Object not found");
        }

    }

    public <T> T getObject(String className) {
        if (className.equalsIgnoreCase("SendOTPData")) {
            return (T) modelContainer.getSendOTPResponse();
        } else if (className.equalsIgnoreCase("VerifyOTPData")) {
            return (T) modelContainer.getVerifyOTPResponse();
        }
        return null;
    }
}
