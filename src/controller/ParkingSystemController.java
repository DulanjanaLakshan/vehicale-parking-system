package controller;

import Vehicle.Vehicle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.awt.event.MouseEvent;

import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 2021-07-17
 **/

public class ParkingSystemController {

    public AnchorPane root;
    public Label lblDate;
    public Label lblTime;
    public JFXComboBox cmbVehicleLanguages;
    public JFXComboBox cmbDriverLanguages;
    public JFXTextField txtVehicleType;
    public TextField lblSlotNumber;
    public JFXButton btnParkVehicle;
    public JFXButton btnOnDeliveryShift;
    String vehicleNumber;

    Vehicle vehicle = new Vehicle();

    public void initialize(){
        dateAndTime();

        cmbVehicleLanguages.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

                vehicle.parkingVehicle((String) newValue);
                vehicleNumber = (String) newValue;
                txtVehicleType.setText(vehicle.vehicleType);
                lblSlotNumber.setText(vehicle.vehicleSlot);

        });

        cmbVehicleLanguages.setItems(vehicleList);

        cmbDriverLanguages.setItems(driverNamesList);

    }
    static ObservableList <String> vehicleList = FXCollections.observableArrayList("NA-3434",
            "KA-4563",
            "58-3567",
            "CBB-3566",
            "QH-3444");

    static  ObservableList <String> driverNamesList = FXCollections.observableArrayList("Sumith Kumara",
            "Amila Pathirana",
            "Jithmal Perera",
            "Sumith Dissanayaka",
            "Priyanga Perera");

    public void btnManagementLogInAction(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public void DateTimeOnAction(MouseEvent mouseEvent) {

    }

    private void dateAndTime() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy:MM:dd");
            lblDate.setText(LocalDateTime.now().format(formatter1));
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void btnParkVehicleOnAction(ActionEvent actionEvent) {
        String vehicleNumber = cmbVehicleLanguages.getSelectionModel().getSelectedItem().toString();
        String vehicleType = txtVehicleType.getText();
        String slotNumber = lblSlotNumber.getText();
        String time = lblTime.getText();

        InParkingFormController.parking(vehicleNumber, vehicleType, slotNumber, time);

        InParkingFormController.removeVehicleDetails(vehicleNumber, vehicleType, slotNumber, time);
    }

    public void btnOnDeliveryShiftOnAction(ActionEvent actionEvent) {
        String vehicleNumber = cmbVehicleLanguages.getSelectionModel().getSelectedItem().toString();
        String vehicleType = txtVehicleType.getText();
        String driverName = cmbDriverLanguages.getSelectionModel().getSelectedItem().toString();
        String time = lblTime.getText();

        InParkingFormController.onDeliveryShift(vehicleNumber, vehicleType, driverName, time);

        InParkingFormController.removeParking(vehicleNumber, vehicleType, driverName, time);
    }

    public void imgExitOnMouseClicked(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/WelcomePageForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}

