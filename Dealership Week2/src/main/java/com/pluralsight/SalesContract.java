package com.pluralsight;

public class SalesContract extends Contract {
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
        double sales_tax = getSalesTaxAmount(), processing_fee = getProcessingFee(), recording_fee =
                getRecording_fee(), car_price = vehicle_sold.getPrice(), total_price = 0;

        total_price += car_price + sales_tax + recording_fee + processing_fee;

        return total_price;

    }

    public void isFinance(boolean answer) {
        if (answer == true) {
            this.finance_status = true;
        } else {
            this.finance_status = false;
        }

    }

    public double getSalesTaxAmount() {
        double car_price = vehicle_sold.getPrice();
        total_price = car_price * 0.05;
        return total_price;
    }

    public double getProcessingFee() {
        double car_price = vehicle_sold.getPrice();

        if (car_price < 10000) {
            processing_fee = 295;
        } else {
            processing_fee = 495;
        }
        return processing_fee;
    }


    @Override
    public double getMonthly_payment() {
        double monthly_pay;
        if (this.finance_status == false) {
            return 0;
        } else {

            double total = getTotal_price();
            double loan;


            if (getTotal_price() >= 10000) {
                loan = 0.0425 / 12;

            } else {
                loan = 0.0525 / 12;

            }
            monthly_pay = total / 12;
            double interest_gain = monthly_pay * loan;
            monthly_pay = interest_gain + monthly_pay;

        }
        return monthly_pay;
    }

    public double getSales_tax() {
        return sales_tax;
    }

    public double getRecording_fee() {
        return 100;
    }

    public boolean isFinance_status() {
        return finance_status;
    }

}
