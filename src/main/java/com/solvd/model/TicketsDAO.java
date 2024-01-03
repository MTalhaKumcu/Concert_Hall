package com.solvd.model;

import java.util.Objects;

public class TicketsDAO {

    private int ticketID;
    private int eventID;
    private int price;
    private int ticketTypeID;

    public TicketsDAO(int ticketID, int eventID, int price, int ticketTypeID) {
        this.ticketID = ticketID;
        this.eventID = eventID;
        this.price = price;
        this.ticketTypeID = ticketTypeID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTicketTypeID() {
        return ticketTypeID;
    }

    public void setTicketTypeID(int ticketTypeID) {
        this.ticketTypeID = ticketTypeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketsDAO that = (TicketsDAO) o;
        return ticketID == that.ticketID && eventID == that.eventID && price == that.price && ticketTypeID == that.ticketTypeID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, eventID, price, ticketTypeID);
    }

    @Override
    public String toString() {
        return "TicketsDAO{" +
                "ticketID=" + ticketID +
                ", eventID=" + eventID +
                ", price=" + price +
                ", ticketTypeID=" + ticketTypeID +
                '}';
    }
}
