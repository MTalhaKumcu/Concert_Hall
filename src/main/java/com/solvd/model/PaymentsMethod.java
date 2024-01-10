package com.solvd.model;

public class PaymentsMethod {

    private static int paymentMethodID;
    private static String paymentMethodName;
    private static String description;

    public PaymentsMethod(int paymentMethodID, String paymentMethodName, String description) {

        PaymentsMethod.paymentMethodID = paymentMethodID;
        PaymentsMethod.paymentMethodName = paymentMethodName;
        PaymentsMethod.description = description;
        // it did not find non-static intance variable cuz of i made it

    }

    public static int getPaymentMethodID() {
        return paymentMethodID;
    }

    public static int setPaymentMethodID(int paymentSetMethodID) {
        return paymentMethodID = paymentMethodID;
    }
    // Warning

    public static String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void paymentMethodName() {
        paymentMethodName = paymentMethodName;
    }

    public static String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }
}
