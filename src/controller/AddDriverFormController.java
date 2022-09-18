package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 2021-07-19
 **/
public class AddDriverFormController {
    public AnchorPane root;
    public JFXTextField txtDriverName;
    public JFXTextField txtNic;
    public JFXTextField txtLicenseNumber;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNumber;
    static String driverName;


    public void AddDriverOnAction(ActionEvent actionEvent) {
        ParkingSystemController.driverNamesList.add(txtDriverName.getText());

    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/InParkingForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
