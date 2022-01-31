package bd.com.letsride.user.models.responseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ErrorResponse {

    @SerializedName("data")
    @Expose
    private ErrorData data;
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
    @SerializedName("exception")
    @Expose
    private Object exception;

    public ErrorData getData() {
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

    public Object getException() {
        return exception;
    }
}
