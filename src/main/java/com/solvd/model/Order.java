package com.solvd.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private int orderID;
    private Customer customerID;
    private Event eventID;
    private LocalDateTime purchaseDate;
    private int totalAmount;
    private PaymentsMethod paymentMethodID;

    public Order(int orderID, Customer customerID, Event eventID, LocalDateTime purchaseDate, int totalAmount) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.eventID = eventID;
        this.purchaseDate = purchaseDate;
        this.totalAmount = totalAmount;
    }

    public Order(int orderID) {
        this.orderID = orderID;
    }


    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }


    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
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

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }

    public Event getEventID() {
        return eventID;
    }

    public void setEventID(Event eventID) {
        this.eventID = eventID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && totalAmount == order.totalAmount && Objects.equals(customerID, order.customerID) && Objects.equals(eventID, order.eventID) && Objects.equals(purchaseDate, order.purchaseDate) && Objects.equals(paymentMethodID, order.paymentMethodID);
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
