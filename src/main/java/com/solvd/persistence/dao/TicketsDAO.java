package com.solvd.persistence.dao;

import com.solvd.model.Tickets;

import java.util.List;

public interface TicketsDAO {
    Tickets getTicketByID(int ticketID);

    List<Tickets> getAllTickets();

    void addTicket(Tickets tickets);

    void updateTicket(Tickets tickets);

    void deleteTicket(int ticketID);

}
