package bd.com.letsride.user.apiResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ErrorResponse {

    @SerializedName("data")
    @Expose
    private Object data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<ErrorData> getErrorDataList() {
        return errors;
    }

    public void setErrorDataList(List<ErrorData> errors) {
        this.errors = errors;
    }

    public Boolean getFailed() {
        return failed;
    }

    public void setFailed(Boolean failed) {
        this.failed = failed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageWithErrors() {
        return messageWithErrors;
    }

    public void setMessageWithErrors(String messageWithErrors) {
        this.messageWithErrors = messageWithErrors;
    }

    public Boolean getSucceeded() {
        return succeeded;
    }

    public void setSucceeded(Boolean succeeded) {
        this.succeeded = succeeded;
    }

    public Object getException() {
        return exception;
    }

    public void setException(Object exception) {
        this.exception = exception;
    }

}
