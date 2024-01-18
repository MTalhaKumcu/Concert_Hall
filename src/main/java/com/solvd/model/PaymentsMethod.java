package com.solvd.model;

public class PaymentsMethod {

    private int paymentMethodID;
    private String paymentMethodName;
    private String description;

    public PaymentsMethod(int paymentMethodID, String paymentMethodName, String description) {

        this.paymentMethodID = paymentMethodID;
        this.paymentMethodName = paymentMethodName;
        this.description = description;
        // it did not find non-static intance variable cuz of i made it

    }

    public PaymentsMethod() {

    }

    public int getPaymentMethodID() {
        return paymentMethodID;
    }

    public int setPaymentMethodID(int paymentMethodID) {
        return paymentMethodID = paymentMethodID;
    }
    // Warning

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void paymentMethodName(String paymentMethodName) {
        paymentMethodName = paymentMethodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
