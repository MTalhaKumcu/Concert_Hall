package com.solvd.model;

public class PaymentsMethodsDAO {

    private int paymentMethodID;
    private String methodName;
    private String description;

    public PaymentsMethodsDAO(int paymentMethodID, String methodName, String description) {

        this.paymentMethodID = paymentMethodID;
        this.methodName = methodName;
        this.description = description;

    }

    public int getPaymentMethodID() {
        return paymentMethodID;
    }

    public void setPaymentMethodID() {
        this.paymentMethodID = paymentMethodID;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName() {
        this.methodName = methodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }
}
