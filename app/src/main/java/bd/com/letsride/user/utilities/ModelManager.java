package bd.com.letsride.user.utilities;

import org.json.JSONException;
import bd.com.letsride.user.apiResponseModels.SendOTPData;

public class ModelManager {

    private static ModelContainer modelContainer;
    private static ModelManager modelManager;

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

    public <T> void addToJson(T obj) throws JSONException {
        if (obj != null && obj instanceof SendOTPData) {
            modelContainer.setSendOTPResponse((SendOTPData) obj);
        } else {
            throw new JSONException("Object not found");
        }

    }

    public <T> T getObject(String className) {
        if (className.equalsIgnoreCase("SendOTPData")) {
            return (T) modelContainer.getSendOTPResponse();
        }
        return null;
    }

    public static void removeModelsData() {
        modelContainer = null;
        modelManager = null;
    }
}
