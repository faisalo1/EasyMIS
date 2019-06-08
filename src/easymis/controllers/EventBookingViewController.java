package easymis.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import easymis.controllers.assembler.EventDetailsAssembler;
import easymis.models.entity.EventDetails;
import easymis.models.entity.EventTypeDetail;
import easymis.models.entity.TransactionStatus;
import easymis.models.entity.enumeration.BookingStatus;
import easymis.models.entity.enumeration.BookingType;
import easymis.models.entity.enumeration.EventCategory;
import easymis.models.entity.utils.EventCategoryUtils;
import easymis.models.repository.EventRepository;
import easymis.utils.AlertHelper;
import easymis.utils.DateHelper;
import easymis.views.viewobjects.EventDetailsViewObject;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    @FXML
    private Tab panelTabAddNew;
    @FXML
    private Tab panelTabList;
    @FXML
    private TableColumn<EventDetailsViewObject, String> col_EventDate;
    @FXML
    private TableColumn<EventDetailsViewObject, String> col_fullName;
    @FXML
    private TableColumn<EventDetailsViewObject, BookingStatus> col_BookingStatus;
    @FXML
    private TableColumn<EventDetailsViewObject, String> col_eventType;
    @FXML
    private TableColumn<EventDetailsViewObject, BookingType> col_bookingId;
    @FXML
    private TableColumn<EventDetailsViewObject, Date> col_BookingDate;
    @FXML
    private TableView<EventDetailsViewObject> eventTable;

    ObservableList<EventDetailsViewObject> observableList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<EventDetailsViewObject, EventCategory> col_EventCategory;
    @FXML
    private Label lblEventCategory;
    @FXML
    private JFXTextField primaryMobileNumber;
    @FXML
    private JFXTextField alternateMobileNumber;
    @FXML
    private JFXButton btnBlock;
    @FXML
    private JFXButton btnBook;
    @FXML
    private JFXButton btnReset;
    @FXML
    private Tab panelTabAddNew1;
    @FXML
    private JFXTextField updFirstName;
    @FXML
    private JFXTextField updLastName;
    @FXML
    private JFXTextField updAddressLine1;
    @FXML
    private JFXTextField updAddressLine2;
    @FXML
    private JFXTextField updAddressLine3;
    @FXML
    private JFXTextField updDistrict;
    @FXML
    private JFXTextField updState;
    @FXML
    private JFXTextField updPinCode;
    @FXML
    private JFXTextField updMobileNumber1;
    @FXML
    private JFXTextField updMobileNumber2;
    @FXML
    private CheckBox updWedding;
    @FXML
    private CheckBox updMehandi;
    @FXML
    private CheckBox updReception;
    @FXML
    private CheckBox updAcRequired;
    @FXML
    private CheckBox updIshaHall;
    @FXML
    private CheckBox updNiceHall;
    @FXML
    private CheckBox updAdditionalAC;
    @FXML
    private JFXDatePicker eventDate1;
    @FXML
    private JFXButton updBtnBook;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton updBtnReset;
    @FXML
    private Label totalAmount1;
    @FXML
    private Label lblEventCategory1;
    @FXML
    private JFXTextField updBookingId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        col_EventDate.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
        col_fullName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        col_BookingStatus.setCellValueFactory(new PropertyValueFactory<>("bookingStatus"));
        col_eventType.setCellValueFactory(new PropertyValueFactory<>("eventType"));
        col_bookingId.setCellValueFactory(new PropertyValueFactory<>("bookingId"));
        col_BookingDate.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
        col_EventCategory.setCellValueFactory(new PropertyValueFactory<>("eventCategory"));
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
            manageEvent(BookingStatus.BOOKED);
        }
    }

    public void manageEvent(BookingStatus bookingStatus) {
        if (validateMandatory()) {
            EventDetails eventDetail = getEventDetails(bookingStatus);
            TransactionStatus status = EventRepository.getUniqueInstance().create(eventDetail);
            AlertHelper.showMessage(status);
            lblEventCategory.setText(eventDetail.getEventCategory().toString());
            if (status.isSuccess()) {
                disableAllFields(true);
            }
        }
    }

    private EventDetails getEventDetails(BookingStatus bookingStatus) {
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
        if (pinCode.getText() != null && !"".equals(pinCode.getText())) {
            eventDetails.setPinCode(Integer.valueOf(pinCode.getText()));
        }
        eventDetails.setWeddingSelected(wedding.isSelected());
        eventDetails.setMehandiSelected(mehandi.isSelected());
        eventDetails.setReceptionSelected(reception.isSelected());
        eventDetails.setIshaSelected(ishaHall.isSelected());
        eventDetails.setNicaSelected(niceHall.isSelected());
        eventDetails.setAcSelected(acRequired.isSelected());
        eventDetails.setAdditionalACSelected(additionalAC.isSelected());
        eventDetails.setBookingStatus(bookingStatus);
        eventDetails.setEventCategory(EventCategoryUtils.getEventCategory(buildEventCategoryDetail()));
        eventDetails.setPrimaryMobile(primaryMobileNumber.getText());
        eventDetails.setAlternateMobile(alternateMobileNumber.getText());
        eventDetails.setCreatedDate(DateHelper.getToday());
        return eventDetails;
    }

    private boolean validateMandatory() {
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder("Following fileds missing: ");
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
        if (primaryMobileNumber.getText() == null || "".equals(addressLine1.getText())) {
            errorMessage.append(" Mobile Number,");
            isValid = false;
        }
        if (!wedding.isSelected() && !reception.isSelected() && !niceHall.isSelected() && !ishaHall.isSelected()) {
            errorMessage.append(" Any Event");
            isValid = false;
        }
        if (!isValid) {
            String stringMessage = errorMessage.toString();
            AlertHelper.showErrorMessage(stringMessage);
        }
        return isValid;
    }

    @FXML
    private void onAddNewTabSelection(Event event) {

    }

    @FXML
    private void onListTabSelection(Event event) {
        if (event != null) {
            List<EventDetails> eventDetails = EventRepository.getUniqueInstance().fetchAllEvents();
            EventDetailsAssembler assembler = new EventDetailsAssembler();
            observableList.clear();
            eventDetails.stream().forEach((eventDetail) -> {
                observableList.add(assembler.toEventDetailsViewObject(eventDetail));
            });
            eventTable.setItems(observableList);
        }
    }

    private EventTypeDetail buildEventCategoryDetail() {
        EventTypeDetail eventCategoryDetail = new EventTypeDetail();
        eventCategoryDetail.setAcSelected(acRequired.isSelected());
        eventCategoryDetail.setAdditionalACSelected(additionalAC.isSelected());
        eventCategoryDetail.setIshaSelected(ishaHall.isSelected());
        eventCategoryDetail.setMehandiSelected(mehandi.isSelected());
        eventCategoryDetail.setNicaSelected(niceHall.isSelected());
        eventCategoryDetail.setReceptionSelected(reception.isSelected());
        eventCategoryDetail.setWeddingSelected(wedding.isSelected());
        return eventCategoryDetail;
    }

    @FXML
    private void resetEventDetails(ActionEvent event) {
        disableAllFields(false);
        clearFields();
    }

    private void disableAllFields(boolean flag) {
        firstName.setDisable(flag);
        lastName.setDisable(flag);
        addressLine1.setDisable(flag);
        addressLine2.setDisable(flag);
        addressLine3.setDisable(flag);
        district.setDisable(flag);
        state.setDisable(flag);
        pinCode.setDisable(flag);
        wedding.setDisable(flag);
        mehandi.setDisable(flag);
        reception.setDisable(flag);
        acRequired.setDisable(flag);
        ishaHall.setDisable(flag);
        niceHall.setDisable(flag);
        additionalAC.setDisable(flag);
        eventDate.setDisable(flag);
        btnBlock.setDisable(flag);
        btnBook.setDisable(flag);
        primaryMobileNumber.setDisable(flag);
        alternateMobileNumber.setDisable(flag);        
    }
    
    private void clearFields(){
        firstName.clear();
        lastName.clear();
        addressLine1.clear();
        addressLine2.clear();
        addressLine3.clear();
        district.clear();
        state.clear();
        pinCode.clear();
        wedding.setSelected(false);
        mehandi.setSelected(false);
        reception.setSelected(false);
        acRequired.setSelected(false);
        ishaHall.setSelected(false);
        niceHall.setSelected(false);
        additionalAC.setSelected(false);
        eventDate.setValue(null);
        primaryMobileNumber.clear();
        alternateMobileNumber.clear(); 
    }

    @FXML
    private void bookEventInUpdate(ActionEvent event) {
    }

    @FXML
    private void updateEvent(ActionEvent event) {
    }

    @FXML
    private void resetEventDetailsInUpdate(ActionEvent event) {
    }

    @FXML
    private void onChangeBookingID(ActionEvent event) {
    }
}
