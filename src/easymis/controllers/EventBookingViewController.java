/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymis.controllers;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import easymis.models.entity.EventDetails;
import easymis.models.entity.enumeration.BookingType;
import easymis.models.repository.EventRepository;
import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import org.eclipse.persistence.internal.helper.StringHelper;

/**
 * FXML Controller class
 *
 * @author RashidKP
 */
public class EventBookingViewController implements Initializable {

    @FXML
    private JFXTextField firstName;
    @FXML
    private JFXTextField lastName;
    @FXML
    private JFXTextField addressLine1;
    @FXML
    private JFXTextField addressLine2;
    @FXML
    private JFXTextField addressLine3;
    @FXML
    private JFXTextField district;
    @FXML
    private JFXTextField state;
    @FXML
    private JFXTextField pinCode;
    @FXML
    private CheckBox wedding;
    @FXML
    private CheckBox mehandi;
    @FXML
    private CheckBox reception;
    @FXML
    private CheckBox acRequired;
    @FXML
    private CheckBox ishaHall;
    @FXML
    private CheckBox niceHall;
    @FXML
    private CheckBox additionalAC;
    @FXML
    private JFXDatePicker eventDate;
    @FXML
    private Label totalAmount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onWeddingSelection(ActionEvent event) {
    }

    @FXML
    private void onMehandiSelection(ActionEvent event) {
    }

    @FXML
    private void onReceptionSelection(ActionEvent event) {
    }

    @FXML
    private void onAcRequiredSelection(ActionEvent event) {
    }

    @FXML
    private void onIshaHallSelection(ActionEvent event) {
    }

    @FXML
    private void onNicaHallSelection(ActionEvent event) {
    }

    @FXML
    private void onAdditionalAcSelection(ActionEvent event) {
    }

    @FXML
    private void blockEvent(ActionEvent event) {
    }

    @FXML
    private void bookEvent(ActionEvent event) {
        if (event != null) {
            if (validateEventDetails()) {
                EventDetails eventDetail = getEventDetails(BookingType.BOOKED);
            }

        }
    }

    private EventDetails getEventDetails(BookingType bookingType) {
        EventDetails eventDetails = new EventDetails();
        java.sql.Date eventDateValue = java.sql.Date.valueOf(eventDate.getValue());
        eventDetails.setEventDate(eventDateValue);
        eventDetails.setFirstName(firstName.getText());
        eventDetails.setLastName(lastName.getText());
        eventDetails.setAddressLine1(addressLine1.getText());
        eventDetails.setAddressLine2(addressLine2.getText());
        eventDetails.setAddressLine3(addressLine3.getText());
        eventDetails.setDistrict(district.getText());
        eventDetails.setState(state.getText());
        eventDetails.setPinCode(Integer.valueOf(pinCode.getText()));
        eventDetails.setWeddingSelected(wedding.isSelected());
        eventDetails.setMehandiSelected(mehandi.isSelected());
        eventDetails.setReceptionSelected(reception.isSelected());
        eventDetails.setIshaSelected(ishaHall.isSelected());
        eventDetails.setNicaSelected(niceHall.isSelected());
        eventDetails.setAcSelected(acRequired.isSelected());
        eventDetails.setAcAddSelected(additionalAC.isSelected());
        eventDetails.setBookingType(bookingType);
        eventDetails.setCreatedDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        return eventDetails;
    }

    private boolean validateEventDetails() {
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder();
        if (eventDate.getValue() == null) {
            errorMessage.append(" Event Date,");
            isValid = false;
        }
        if (firstName.getText() == null || "".equals(firstName.getText())) {
            errorMessage.append(" First Name,");
            isValid = false;
        }
        if (addressLine1.getText() == null || "".equals(addressLine1.getText())) {
            errorMessage.append(" Address Line 1,");
            isValid = false;
        }
        if (!wedding.isSelected() && !reception.isSelected() && !niceHall.isSelected() && !ishaHall.isSelected()) {
            errorMessage.append(" Any Event");
            isValid = false;
        }
        if (!isValid) {
            String stringMessage = errorMessage.toString();
            if(stringMessage.charAt(stringMessage.length()-1)== ','){
                
            }
            Alert alert = new Alert(AlertType.ERROR, "Mandatory Fields Missing: "+stringMessage, ButtonType.OK);
            alert.show();
        }
        return isValid;
    }

}
