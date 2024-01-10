package com.solvd.service;

import com.solvd.model.Tickets;
import com.solvd.persistence.dao.TicketDAO;

import java.util.List;

public class TicketService {
    private final TicketDAO ticketDAO;

    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public Tickets getTicketByID(int ticketID) {
        return ticketDAO.getTicketByID(ticketID);
    }

    public List<Tickets> getAllTickets() {
        return ticketDAO.getAllTickets();
    }

    public void addTicket(Tickets tickets) {
        ticketDAO.addTicket(tickets);
    }

    public void updateTicket(Tickets tickets) {
        ticketDAO.updateTicket(tickets);
    }

    public void deleteTicket(int ticketID) {
        ticketDAO.deleteTicket(ticketID);
    }
}
