package com.pluralsight;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Contract contract;
    private Vehicle vehicle;

    public UserInterface() {

    }

    public void display (){
        Scanner scanner = new Scanner(System.in);
        init();

        boolean run = true;
        while (run){
            displayMenuOptions();

            System.out.print("Enter your choice: ");
            int choice1 = scanner.nextInt();
            scanner.nextLine();

            switch (choice1){
                case 1:
                    processGetByPriceRequest(scanner);
                    break;
                case 2:
                    processGetByMakeModelRequest(scanner);
                    break;
                case 3:
                    processGetByYearRequest(scanner);
                    break;
                case 4:
                    processGetByColorRequest(scanner);
                    break;
                case 5:
                    processGetByMileageRequest(scanner);
                    break;
                case 6:
                    processGetByVehicleTypeRequest(scanner);
                    break;
                case 7:
                    processGetAllVehicleRequest();
                    break;
                case 8:
                    processAddVehicleRequest(scanner);
                    break;
                case 9:
                    processRemoveVehicleRequest(scanner);
                    break;
                case 10:
                    processContractRequest(scanner);
                    break;
                case 0:
                    run=false;
                    System.exit(0);
                    break;

            }


        }

    }
    private void init(){
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership=fileManager.getDealership();
    }
    public void displayMenuOptions(){
        System.out.println("*****Welcome to the Dealership!!!*****");
        System.out.println(" ");
        System.out.println("***Our Options***");
        System.out.println("1 - Find vehicles within a price range");
        System.out.println("2 - Find vehicles by make / model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
        System.out.println("7 - List ALL vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("10 - Sell/Lease a vehicle");
        System.out.println("0 - Quit");
    }

    public void displayVehicles(ArrayList<Vehicle> vehicles){
        for (Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }
    public void processGetByPriceRequest(Scanner scanner){
        System.out.print("Enter minimum value: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum value: ");
        double maxPrice = scanner.nextDouble();
        displayVehicles(dealership.getVehiclesByPrice(minPrice, maxPrice));



    }
    public void processGetByMakeModelRequest(Scanner scanner){
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    public void processGetByYearRequest(Scanner scanner){
        System.out.print("Enter minimum year: ");
        int minYear = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int maxYear = scanner.nextInt();
        displayVehicles(dealership.getVehiclesByYear(minYear, maxYear));
    }
    public void processGetByColorRequest(Scanner scanner){
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByColor(color));
    }
    public void processGetByMileageRequest(Scanner scanner){
        System.out.print("Enter minimum mileage: ");
        int minMil = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int maxMil = scanner.nextInt();
        displayVehicles(dealership.getVehiclesByMileage(minMil, maxMil));
    }

    public void processGetByVehicleTypeRequest(Scanner scanner){
        System.out.print("Enter type: ");
        String type = scanner.nextLine();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    public void processGetAllVehicleRequest(){

        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(Scanner scanner){
        System.out.print("Enter vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter type: ");
        String type = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter mileage: ");
        int mileage = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        Vehicle v = new Vehicle(vin, year, make, model, type,color, mileage,price);
        dealership.addVehicle(v);

        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);



    }
    public void processRemoveVehicleRequest(Scanner scanner){
        displayVehicles(dealership.getAllVehicles());

        System.out.print("Enter vin that you want to remove: ");
        int removedVin = scanner.nextInt();

        dealership.removeVehicle(dealership.getVehicleByTheVin(removedVin));

        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);


    }

    public void processContractRequest(Scanner scanner){
        System.out.println("Choose from next option:");
        System.out.println("1. Sale Contract");
        System.out.println("2. Lease Contract");
        System.out.println(" ");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter you email: ");
        String email = scanner.nextLine();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-mm-dd");
        String date_time = dateTimeFormatter.toString();

        ContractFileManager fileManager = new ContractFileManager();


        switch (choice){

            case 1:
                System.out.print("Enter VIN of the vehicle: ");
                int vin_veh = scanner.nextInt();

                scanner.nextLine();


                System.out.println("Would you like to have finance? (yes/no)");
                System.out.print("Your answer: ");
                String yes_no = scanner.nextLine();
                boolean answer = true;

                if (yes_no.equalsIgnoreCase("yes")){
                   answer = true;

                }else {
                   answer = false;

                }

                SalesContract salesContract = new SalesContract(date_time, name, email,
                        dealership.getVehicleByTheVin(vin_veh), 0.0, 0.0, 0.05, 100, 0.0,answer);
                fileManager.saveContract(salesContract);
                break;
            case 2:
                System.out.print("Enter VIN of the vehicle: ");
                int vin_veh2 = scanner.nextInt();
                contract.setVehicle_sold(dealership.getVehicleByTheVin(vin_veh2));
                scanner.nextLine();

                LeaseContract leaseContract = new LeaseContract(date_time, name, email,
                        dealership.getVehicleByTheVin(vin_veh2),0.0, 0.0, 0.0, 0.0);

                fileManager.saveContract(leaseContract);


                break;
            default:
                System.out.println("Invalid input. Try again!");
                break;
        }

    }




}