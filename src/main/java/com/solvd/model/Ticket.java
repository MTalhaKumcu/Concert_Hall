package com.solvd.model;

import java.util.Objects;

public class Ticket {

    private int ticketID;
    private Event eventID;
    private int price;

    public Ticket(int ticketID, Event eventID, int price) {
        this.ticketID = ticketID;
        this.eventID = eventID;
        this.price = price;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public Event getEventID() {
        return eventID;
    }

    public void setEventID(Event eventID) {
        this.eventID = eventID;
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
        return ticketID == ticket.ticketID && price == ticket.price && Objects.equals(eventID, ticket.eventID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, eventID, price);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", eventID=" + eventID +
                ", price=" + price +
                '}';
    }
}
