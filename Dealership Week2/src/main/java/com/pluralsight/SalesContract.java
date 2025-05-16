package com.pluralsight;

public class SalesContract extends Contract{
 private double sales_tax;
 private double recording_fee;
 private double processing_fee;
 private boolean finance_status;


    public SalesContract(String date_of_contract, String customer_name, String customer_email, Vehicle vehicle_sold, double total_price, double monthly_payment, double sales_tax, double recording_fee, double processing_fee, boolean finance_status) {
        super(date_of_contract, customer_name, customer_email, vehicle_sold, total_price, monthly_payment);
        this.sales_tax = sales_tax;
        this.recording_fee = recording_fee;
        this.processing_fee = processing_fee;
        this.finance_status = finance_status;
    }

    @Override
    public double getTotal_price() {
        double car_price = vehicle_sold.getPrice(), total_price = 0;
        total_price = car_price* 0.05;
        total_price += 100;
        if (car_price < 10000){
            total_price += 295;
        } else {
            total_price += 495;
        }
        return total_price;
    }

    public void isFinance (boolean answer) {
        if (answer == true){
            this.finance_status = true;
        } else {
            this.finance_status = false;
        }

    }

    @Override
    public double getMonthly_payment() {
        if (this.finance_status == false){
            return 0;
        } else {

            double total = getTotal_price();
            double loan;
            int month;

            if (getTotal_price() >= 10000){
                loan = 0.0425/12;
                month = 48;
            } else {
                loan = 0.0525 / 12;
                month = 24;
            }

            double monthly_pay = (total * loan * Math.pow(1 + loan, month)) / (Math.pow(1+loan,month) - 1);
        }
        return monthly_payment;
    }

    public double getSales_tax() {
        return sales_tax;
    }

    public double getRecording_fee() {
        return recording_fee;
    }

    public double getProcessing_fee() {
        return processing_fee;
    }

    public boolean isFinance_status() {
        return finance_status;
    }

}
