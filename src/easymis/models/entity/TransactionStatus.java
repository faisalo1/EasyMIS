package easymis.models.entity;

import easymis.utils.ValidationError;
import java.util.List;

/**
 *
 * @author RashidKP
 */
public class TransactionStatus {
    private boolean success;
    
    private String errorCode;
    
    private String message;
    
    private List<ValidationError> validationErrors;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }
    
    
}
