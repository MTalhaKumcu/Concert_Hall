package com.solvd.persistence.dao;

import com.solvd.model.Ticket;

import java.util.List;

public interface TicketDAO {
    Ticket getTicketByID(int ticketID);

    List<Ticket> getAllTicket();

    void addTicket(Ticket ticket);

    void updateTicket(Ticket ticket);

    void deleteTicket(int ticketID);

}
