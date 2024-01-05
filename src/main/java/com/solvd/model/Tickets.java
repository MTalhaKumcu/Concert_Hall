package com.solvd.model;

import java.util.Objects;

public class Tickets {

    private int ticketID;
    private int ticketEventID;
    private int price;

    public Tickets(int ticketID, int ticketEventID, int price) {
        this.ticketID = ticketID;
        this.ticketEventID = ticketEventID;
        this.price = price;

    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getTicketEventID() {
        return ticketEventID;
    }

    public void setTicketEventID(int ticketEventID) {
        this.ticketEventID = ticketEventID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tickets tickets = (Tickets) o;
        return ticketID == tickets.ticketID && ticketEventID == tickets.ticketEventID && price == tickets.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, ticketEventID, price);
    }

    @Override
    public String toString() {
        return "TicketsDAO " +
                "ticketID=" + ticketID +
                ", eventID=" + ticketEventID +
                ", price=" + price ;
    }
}
