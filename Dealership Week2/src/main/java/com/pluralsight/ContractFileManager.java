package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    private static Contract contract;
    private static Dealership dealership;
    public void saveContract (Contract contract){
        try {
            FileWriter fileWriter = new FileWriter("Dealership Week2/src/main/resources/WorkshopFiles/contracts.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            if (contract instanceof SalesContract){
                bufferedWriter.write(String.format("Sale"+"|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%b|%.2f", contract.date_of_contract, contract.getCustomer_name(),
                        contract.getCustomer_email(),contract.vehicle_sold.getVin(), contract.vehicle_sold.getYear(),
                        contract.vehicle_sold.getMake(), contract.vehicle_sold.getModel(),
                        contract.vehicle_sold.getVehicleType(), contract.vehicle_sold. getColor(),
                        contract.vehicle_sold.getOdometer(),
                        contract.vehicle_sold.getPrice(), ((SalesContract) contract).getSales_tax(),
                        ((SalesContract) contract).getRecording_fee(), ((SalesContract) contract).getProcessing_fee(),
                        contract.getTotal_price(), ((SalesContract) contract).isFinance_status(), contract.getMonthly_payment()));

                dealership.removeVehicle(dealership.getVehicleByTheVin(contract.vehicle_sold.getVin()));
            } else if (contract instanceof LeaseContract) {
                bufferedWriter.write(String.format("Lease|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f", contract.date_of_contract, contract.getCustomer_name(),
                        contract.getCustomer_email(),contract.vehicle_sold.getVin(), contract.vehicle_sold.getYear(),
                        contract.vehicle_sold.getMake(), contract.vehicle_sold.getModel(),
                        contract.vehicle_sold.getVehicleType(), contract.vehicle_sold. getColor(),
                        contract.vehicle_sold.getOdometer(),
                        contract.vehicle_sold.getPrice(), ((LeaseContract) contract).getEnding_value(),
                        ((LeaseContract) contract).getLease_fee(), contract.getTotal_price(),
                        contract.getMonthly_payment()));

            }
            bufferedWriter.close();


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}



//public void saveDealership (Dealership dealership){
//    try{
//        FileWriter fileWriter = new FileWriter("src/main/resources/WorkshopFiles/inventory.csv", true);
//        BufferedWriter bufWriter = new BufferedWriter(fileWriter);
//
//        for (Vehicle v : dealership.getAllVehicles()) {
//            bufWriter.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f", v.getVin(),v.getYear(), v.getMake(),
//                    v.getModel(), v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice()));
//            bufWriter.newLine();
//        }
//        bufWriter.close();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }


