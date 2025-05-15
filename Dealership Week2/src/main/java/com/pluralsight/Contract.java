package com.pluralsight;

public abstract class Contract {
    protected String date_of_contract;
    protected String customer_name;
    protected String customer_email;
    protected Vehicle vehicle_sold;
    protected double total_price;
    protected double monthly_payment;

    public Contract(String date_of_contract, String customer_name, String customer_email, Vehicle vehicle_sold,
                    double total_price, double monthly_payment) {
        this.date_of_contract = date_of_contract;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.vehicle_sold = vehicle_sold;
        this.total_price = total_price;
        this.monthly_payment = monthly_payment;
    }

    public String getDate_of_contract() {
        return date_of_contract;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public Vehicle isVehicle_sold() {
        return vehicle_sold;
    }

    public void setDate_of_contract(String date_of_contract) {
        this.date_of_contract = date_of_contract;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public void setVehicle_sold(Vehicle vehicle_sold) {
        this.vehicle_sold = vehicle_sold;
    }

    public abstract double getTotal_price();
    public abstract double getMonthly_payment();
}
