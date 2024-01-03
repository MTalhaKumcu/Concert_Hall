package com.solvd.model;

import java.util.Objects;

public class TicketTypesDAO {

    private int ticketTypeID;
    private String typeName;
    private String description;

    public TicketTypesDAO(int ticketTypeID, String typeName, String description) {
        this.typeName = typeName;
        this.ticketTypeID = ticketTypeID;
        this.description = description;
    }

    public int getTicketTypeID() {
        return ticketTypeID;
    }

    public void setTicketTypeID() {
        this.ticketTypeID = ticketTypeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName() {
        this.typeName = typeName;
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
        TicketTypesDAO that = (TicketTypesDAO) o;
        return ticketTypeID == that.ticketTypeID && Objects.equals(typeName, that.typeName) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketTypeID, typeName, description);
    }

    @Override
    public String toString() {
        return "TicketTypesDAO{" +
                "ticketTypeID=" + ticketTypeID +
                ", typeName='" + typeName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
