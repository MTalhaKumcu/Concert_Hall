package com.solvd.model;

import java.util.Objects;

public class OrderItem {

    private int orderItemID;
    private Order orderID;
    private Ticket ticketID;
    private int quantity;
    private int subTotal;

    public OrderItem(int orderItemID, Order orderID, Ticket ticketID, int quantity, int subTotal) {
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

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public Ticket getTicketID() {
        return ticketID;
    }

    public void setTicketID(Ticket ticketID) {
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
        OrderItem orderItem = (OrderItem) o;
        return orderItemID == orderItem.orderItemID && quantity == orderItem.quantity && subTotal == orderItem.subTotal && Objects.equals(orderID, orderItem.orderID) && Objects.equals(ticketID, orderItem.ticketID);
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
