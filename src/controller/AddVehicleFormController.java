package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AddVehicleFormController {
    public AnchorPane root;
    public JFXComboBox cmbVehicleType;
    public JFXTextField txtVehicleNumber;
    public JFXTextField txtMaximumWeight;
    public JFXTextField txtNoOfPassengers;
    static String vehicleType;
    public JFXButton btnAddVehicle;

    public void initialize(){

        cmbVehicleType.getItems().addAll("Van","Bus","Cargo Lorry");
    }

    public void btnAddVehicleOnAction(ActionEvent actionEvent) {
        ParkingSystemController.vehicleList.add(txtVehicleNumber.getText());
        vehicleType = cmbVehicleType.getSelectionModel().getSelectedItem().toString();

    }

    public static String returnVehicleType(){
        return vehicleType;
    }


    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/InParkingForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
