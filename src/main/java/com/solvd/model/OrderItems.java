package com.solvd.model;

import java.util.Objects;

public class OrderItems {

    private int orderItemID ;
    private int orderID;
    private int ticketID;
    private int quantity;
    private int subTotal;

    public OrderItems(int orderItemID, int orderID, int ticketID, int quantity, int subTotal) {
        this.orderItemID = orderItemID;
        this.orderID = orderID;
        this.ticketID = ticketID;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public int getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(int orderItemID) {
        this.orderItemID = orderItemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItems that = (OrderItems) o;
        return orderItemID == that.orderItemID && orderID == that.orderID && ticketID == that.ticketID && quantity == that.quantity && subTotal == that.subTotal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemID, orderID, ticketID, quantity, subTotal);
    }

    @Override
    public String toString() {
        return "OrderItemsDAO{" +
                "orderItemID=" + orderItemID +
                ", orderID=" + orderID +
                ", ticketID=" + ticketID +
                ", quantity=" + quantity +
                ", subTotal=" + subTotal +
                '}';
    }
}
