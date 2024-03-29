package com.solvd.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

@XmlRootElement(name = "TicketsType")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketsType {
    @XmlElement
    @JsonProperty("ticketTypeID")
    private int ticketTypeID;

    @XmlElement
    @JsonProperty("ticketTypeName")
    private String ticketTypeName;

    @XmlElement
    @JsonProperty("description")
    private String description;

    public TicketsType(int ticketTypeID, String ticketTypeName, String description) {
        this.ticketTypeID = ticketTypeID;
        this.ticketTypeName = ticketTypeName;
        this.description = description;
    }

    public TicketsType(int ticketTypeID) {
        this.ticketTypeID = ticketTypeID;

    }

    public TicketsType() {

    }

    public int getTicketTypeID() {
        return ticketTypeID;
    }

    public void setTicketTypeID(int ticketTypeID) {
        this.ticketTypeID = ticketTypeID;
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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
                ", description='" + description;
    }
}
