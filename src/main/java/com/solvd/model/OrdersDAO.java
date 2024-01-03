package com.solvd.model;

import javax.swing.*;
import java.util.Objects;

public class OrdersDAO {
    private int orderID;
    private int customerID;
    private int eventID;
    private String purchaseDate;
    private int totalAmount;
    private int paymentMethodID;

    public OrdersDAO(int orderID, int customerID, int eventID, String purchaseDate, int totalAmount, int paymentMethodID) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.eventID = eventID;
        this.purchaseDate = purchaseDate;
        this.totalAmount = totalAmount;
        this.paymentMethodID = paymentMethodID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getPaymentMethodID() {
        return paymentMethodID;
    }

    public void setPaymentMethodID(int paymentMethodID) {
        this.paymentMethodID = paymentMethodID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersDAO ordersDAO = (OrdersDAO) o;
        return orderID == ordersDAO.orderID && customerID == ordersDAO.customerID && eventID == ordersDAO.eventID && totalAmount == ordersDAO.totalAmount && paymentMethodID == ordersDAO.paymentMethodID && Objects.equals(purchaseDate, ordersDAO.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, customerID, eventID, purchaseDate, totalAmount, paymentMethodID);
    }

    @Override
    public String toString() {
        return "OrdersDAO{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", eventID=" + eventID +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", totalAmount=" + totalAmount +
                ", paymentMethodID=" + paymentMethodID +
                '}';
    }
}
