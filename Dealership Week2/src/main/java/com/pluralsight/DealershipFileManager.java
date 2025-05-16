package com.pluralsight;

import java.io.*;
import java.util.regex.Pattern;

public class DealershipFileManager {
    private static Dealership dealership;
    public Dealership getDealership () {
        try{
            FileReader fileReader = new FileReader("Dealership Week2/src/main/resources/WorkshopFiles/inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String line = bufReader.readLine();
            String[] parts = line.split(Pattern.quote("|"));
            String name = parts [0];
            String address = parts[1];
            String phone = parts[2];
            dealership = new Dealership(name, address, phone);

            while((line = bufReader.readLine())!=null){
                if (line.startsWith("D")){
                    continue;
                }

                String[] parts2 = line.split(Pattern.quote("|"));
                int vin = Integer.parseInt(parts2[0]);
                int year = Integer.parseInt(parts2[1]);
                String make = parts2[2];
                String model = parts2 [3];
                String type = parts2 [4];
                String color = parts2 [5];
                int odometer = Integer.parseInt(parts2[6]);
                double price = Double.parseDouble(parts2[7]);

                dealership.addVehicle(new Vehicle(vin,year, make, model, type, color, odometer, price));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return dealership;
    }

    public void saveDealership (Dealership dealership){
        try{
            FileWriter fileWriter = new FileWriter("Dealership Week2/src/main/resources/WorkshopFiles/inventory.csv", true);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            for (Vehicle v : dealership.getAllVehicles()) {
                bufWriter.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f", v.getVin(),v.getYear(), v.getMake(),
                        v.getModel(), v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice()));
                bufWriter.newLine();
            }
            bufWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}