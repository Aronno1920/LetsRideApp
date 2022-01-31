package bd.com.letsride.user.apiResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DepositConfigResponse {

    @SerializedName("data")
    @Expose
    private List<DepositConfigData> data = null;
    @SerializedName("errors")
    @Expose
    private List<Object> errors = null;
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

    public List<DepositConfigData> getDepositConfig() {
        return data;
    }

    public void setDepositConfig(List<DepositConfigData> data) {
        this.data = data;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
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
