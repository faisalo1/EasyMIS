package easymis.utils;

import easymis.models.entity.TransactionStatus;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author RashidKP
 */
public class AlertHelper {
    public static void showErrorMessage(String errorMessage){
        Alert alert = new Alert(Alert.AlertType.ERROR, errorMessage, ButtonType.OK);
            alert.show();
    }
    
    public static void showSuccessMessage(String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
            alert.show();
    }
    
    public static void showMessage(TransactionStatus status){
        
    }
}
