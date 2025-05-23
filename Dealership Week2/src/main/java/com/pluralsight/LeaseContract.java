package com.pluralsight;

public class LeaseContract extends Contract{

    private double ending_value;
    private double lease_fee;

    public LeaseContract(String date_of_contract, String customer_name, String customer_email, Vehicle vehicle_sold, double total_price, double monthly_payment, double ending_value, double lease_fee) {
        super(date_of_contract, customer_name, customer_email, vehicle_sold, total_price, monthly_payment);
        this.ending_value = ending_value;
        this.lease_fee = lease_fee;
    }

    @Override
    public double getTotal_price() {
        return getExpectedEndingValue()+getLeaseFee();
    }

    public double getExpectedEndingValue(){
        double ending_value = vehicle_sold.getPrice();
        ending_value *=0.5;
        return ending_value;
    }

    public  double getLeaseFee(){
        double fee = vehicle_sold.getPrice() * 0.07;

        return fee;
    }

    @Override
    public double getMonthly_payment() {
        double reduced_price = getTotal_price();

        double interest_over_year = (reduced_price)*(0.04 / 12);
        reduced_price = reduced_price/12;


        return reduced_price + interest_over_year ;
    }

    public double getEnding_value() {
        return ending_value;
    }

    public double getLease_fee() {
        return lease_fee;
    }
}
