package com.solvd.model;

import java.util.Objects;

public class Ticket {

    private int ticketID;
    private int ticketEventID;
    private int price;

    public Ticket(int ticketID, int ticketEventID, int price) {
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
        Ticket ticket = (Ticket) o;
        return ticketID == ticket.ticketID && ticketEventID == ticket.ticketEventID && price == ticket.price;
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
