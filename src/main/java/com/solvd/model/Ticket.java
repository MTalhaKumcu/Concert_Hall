package com.solvd.model;

import java.util.Objects;

public class Ticket {

    private int ticketID;
    private Event eventID;
    private double price;
    private TicketsType ticketTypeID;


    public Ticket(int ticketID, Event eventID, double price, TicketsType ticketTypeID) {
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


    public Event getEventID() {
        return eventID;
    }

    public TicketsType getTicketTypeID() {
        return ticketTypeID;
    }

    public void setTicketTypeID(TicketsType ticketTypeID) {
        this.ticketTypeID = ticketTypeID;
    }

    public void setEventID(Event eventID) {
        this.eventID = eventID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", eventID=" + eventID +
                ", price=" + price +
                ", ticketType=" + ticketTypeID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketID == ticket.ticketID && price == ticket.price && Objects.equals(eventID, ticket.eventID) && Objects.equals(ticketTypeID, ticket.ticketTypeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketID, eventID, price, ticketTypeID);
    }
}
