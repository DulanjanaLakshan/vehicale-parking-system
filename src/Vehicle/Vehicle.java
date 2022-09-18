package Vehicle;

import controller.AddVehicleFormController;

import java.sql.SQLOutput;

/**
 * @author : D.D.Sandaruwan <dulanjayasandaruwan1998@gmail.com>
 * @Since : 2021-07-18
 **/

public class Vehicle {

    public String vehicleType;
    public String vehicleNumber;
    public String vehicleSlot;
    public String parkingTime;
    public String deliveryShiftTime;

    String [] slotForVan = {"1", "2","3", "4", "12","13"};
    String [] slotForLorry = {"5", "6", "7", "8", "9", "10", "11"};
    String [] slotForBus = {"14"};

    public Vehicle() {

    }

    public Vehicle(String vehicleNumber, String vehicleType, String vehicleSlot, String parkingTime, String diliveryShiftTime, String[] slotForVan, String[] slotForLorry, String[] slotForBus) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleSlot = vehicleSlot;
        this.parkingTime = parkingTime;
        this.deliveryShiftTime = diliveryShiftTime;
        this.slotForVan = slotForVan;
        this.slotForLorry = slotForLorry;
        this.slotForBus = slotForBus;
    }


    String type = AddVehicleFormController.returnVehicleType();

    public void parkingVehicle(String value){
        vehicleNumber = value;
        if(vehicleNumber.equals("NA-3434")) {
            vehicleType = "Bus";

            for (int i = 0; i < slotForBus.length; i++) {
                if (slotForBus[i] != "") {
                    vehicleSlot = "14";
                    slotForBus[i] = "";
                    break;
                } else {
                    vehicleSlot = "Empty";
                }
            }
        }
        else if(vehicleNumber.equals("KA-4563")||vehicleNumber.equals("58-3567")||vehicleNumber.equals("GF-4358")||vehicleNumber.equals("CCB-3568")||vehicleNumber.equals("LM-6679")||vehicleNumber.equals("QA-3369")) {
            vehicleType = "Van";

            for (int i = 0; i < slotForVan.length; i++) {
                if (slotForVan[i] != "") {
                    vehicleSlot = slotForVan[i];
                    slotForVan[i] = "";
                    break;
                } else {
                    vehicleSlot = "Empty";
                }
            }
        }
        else if(vehicleNumber.equals("KB-3668")||vehicleNumber.equals("JJ-9878")||vehicleNumber.equals("GH-5772")||vehicleNumber.equals("XY-4456")||vehicleNumber.equals("YQ-3536")||vehicleNumber.equals("CBB-3566")||vehicleNumber.equals("QH-3444")){
            vehicleType = "Cargo Lorry";

            for (int i = 0; i < slotForLorry.length; i++) {
                if (slotForLorry[i] != "") {
                    vehicleSlot = slotForLorry[i];
                    slotForLorry[i] = "";
                    break;
                } else {
                    vehicleSlot = "Empty";
                }
            }
        }
    }
}

