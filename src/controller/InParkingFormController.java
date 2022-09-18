package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tableModel.VehicleOnDeliveryShiftTM;
import tableModel.VehicleParkingTM;

import java.io.IOException;
import java.net.URL;



public class InParkingFormController {

    public AnchorPane root;
    public TableView <VehicleParkingTM> tblInParking;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;
    public JFXComboBox cmbInParkingAndOnDelivery;
    public TableView <VehicleOnDeliveryShiftTM> tblOnDelivery;
    public TableColumn colVehicleNumber1;
    public TableColumn colVehicleType1;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;
    public JFXButton btnAddVehicle;
    public JFXButton btnAddDriver;
    public JFXButton btnLogOut;

    static ObservableList <VehicleParkingTM> parkingList = FXCollections.observableArrayList();

    static  ObservableList <VehicleOnDeliveryShiftTM> onDeliveryShiftList = FXCollections.observableArrayList();

    public void initialize(){
        cmbInParkingAndOnDelivery.getItems().addAll("In Parking", "On Delivery");
        cmbInParkingAndOnDelivery.setValue("In Parking");

        tblInParking.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        tblInParking.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        tblInParking.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("parkingSlot"));
        tblInParking.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("parkedTime"));

        tblInParking.setItems(parkingList);

        tblOnDelivery.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        tblOnDelivery.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        tblOnDelivery.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("driverName"));
        tblOnDelivery.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("leftTime"));

        tblOnDelivery.setItems(onDeliveryShiftList);

    }

    public void btnAddVehicle(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public void btnAddDriver(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/AddDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void btnLogOut(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/ParkingSystemForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) root.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void cmbOnAction(ActionEvent actionEvent) {
        if(cmbInParkingAndOnDelivery.getValue().equals("On Delivery")){
            btnLogOut.setVisible(false);
            tblInParking.setVisible(false);
            tblOnDelivery.setVisible(true);
        }
        else{
            btnLogOut.setVisible(true);
            tblOnDelivery.setVisible(false);
            tblInParking.setVisible(true);
        }
    }

    public static void parking(String vehicleNumber, String vehicleType, String parkingSlot, String parkedTime){
        VehicleParkingTM vehicleParkingTM = new VehicleParkingTM(vehicleNumber, vehicleType, parkingSlot, parkedTime);
        parkingList.add(vehicleParkingTM);

    }

    public static void onDeliveryShift(String vehicleNumber, String vehicleType, String driverName, String time){
        VehicleOnDeliveryShiftTM vehicleOnDeliveryShiftTM = new VehicleOnDeliveryShiftTM(vehicleNumber, vehicleType, driverName, time);
        onDeliveryShiftList.add(vehicleOnDeliveryShiftTM);

    }

    public static void removeVehicleDetails(String vehicleNumber, String vehicleType, String driverName, String time){

        
        for (int i=0; i < onDeliveryShiftList.size(); i++){

            if(vehicleNumber.equals(onDeliveryShiftList.get(i).getVehicleNumber())){
                String num = onDeliveryShiftList.get(i).getVehicleNumber();
                onDeliveryShiftList.removeIf(vehicleOnDeliveryShiftTM -> (vehicleOnDeliveryShiftTM.getVehicleNumber().equals(num)));
            }
        }
    }

    public static void removeParking(String vehicleNumber, String vehicleType, String driverName, String time){

        for (int i=0; i < parkingList.size(); i++){

            if(vehicleNumber.equals(parkingList.get(i).getVehicleNumber())){
                String num = parkingList.get(i).getVehicleNumber();
                parkingList.removeIf(vehicleOnDeliveryShiftTM -> (vehicleOnDeliveryShiftTM.getVehicleNumber().equals(num)));
            }
        }
    }

}
