package bd.com.letsride.user.models.responseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AvailableRouteResponse {

    @SerializedName("data")
    @Expose
    private List<AvailableRouteData> data = null;
    @SerializedName("errors")
    @Expose
    private List<ErrorData> errors = null;
    @SerializedName("failed")
    @Expose
    private Boolean failed;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("messageWithErrors")
    @Expose
    private String messageWithErrors;
    @SerializedName("succeeded")
    @Expose
    private Boolean succeeded;

    public List<AvailableRouteData> getAvailableRoutesData() {
        return data;
    }

    public List<ErrorData> getErrors() {
        return errors;
    }

    public Boolean getFailed() {
        return failed;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageWithErrors() {
        return messageWithErrors;
    }

    public Boolean getSucceeded() {
        return succeeded;
    }
}
