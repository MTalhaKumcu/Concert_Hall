package com.solvd.model;

import java.util.Date;
import java.util.Objects;

public class Order {
    private int orderID;
    private String customerName;
    private String eventName;
    private Date purchaseDate;
    private int totalAmount;
    private PaymentsMethod paymentMethodID;

    public Order(int orderID, String customerName, String eventName, Date purchaseDate, int totalAmount) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.eventName = eventName;
        this.purchaseDate = purchaseDate;
        this.totalAmount = totalAmount;
    }

    public Order(int orderID, String customerName, String eventName, java.sql.Date purchaseDate, int totalAmount) {
    }


    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }


    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PaymentsMethod getPaymentMethodID() {
        return paymentMethodID;
    }

    public void setPaymentMethodID(PaymentsMethod paymentMethodID) {
        this.paymentMethodID = paymentMethodID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && totalAmount == order.totalAmount && Objects.equals(customerName, order.customerName) && Objects.equals(eventName, order.eventName) && Objects.equals(purchaseDate, order.purchaseDate) && Objects.equals(paymentMethodID, order.paymentMethodID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, customerName, eventName, purchaseDate, totalAmount, paymentMethodID);
    }

    @Override
    public String toString() {
        return "OrdersDAO{" +
                "orderID=" + orderID +
                ", customerID=" + customerName +
                ", eventID=" + eventName +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", totalAmount=" + totalAmount +
                ", paymentMethodID=" + paymentMethodID +
                '}';
    }


}
