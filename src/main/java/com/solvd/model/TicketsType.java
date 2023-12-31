package com.solvd.model;

import java.util.Objects;

public class TicketsType {

    private int ticketTypeID;
    private String ticketTypeName;
    private String description;

    public TicketsType(int ticketTypeID, String ticketTypeName, String description) {
        this.ticketTypeName = ticketTypeName;
        this.ticketTypeID = ticketTypeID;
        this.description = description;
    }

    public int getTicketTypeID() {
        return ticketTypeID;
    }

    public void setTicketTypeID(int ticketsTypeID) {
        this.ticketTypeID = ticketTypeID;
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName() {
        this.ticketTypeName = ticketTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketsType that = (TicketsType) o;
        return ticketTypeID == that.ticketTypeID
                && Objects.equals(ticketTypeName, that.ticketTypeName)
                && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketTypeID, ticketTypeName, description);
    }

    @Override
    public String toString() {
        return "TicketTypesDAO" +
                "ticketTypeID=" + ticketTypeID +
                ", ticketTypeName='" + ticketTypeName +
                ", description='" + description ;
    }
}
