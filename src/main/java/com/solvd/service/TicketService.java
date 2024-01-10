package com.solvd.service;

import com.solvd.model.Ticket;
import com.solvd.persistence.dao.TicketDAO;

import java.util.List;

public class TicketService {
    private final TicketDAO ticketDAO;

    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public Ticket getTicketByID(int ticketID) {
        return ticketDAO.getTicketByID(ticketID);
    }

    public List<Ticket> getAllTickets() {
        return ticketDAO.getAllTickets();
    }

    public void addTicket(Ticket ticket) {
        ticketDAO.addTicket(ticket);
    }

    public void updateTicket(Ticket ticket) {
        ticketDAO.updateTicket(ticket);
    }

    public void deleteTicket(int ticketID) {
        ticketDAO.deleteTicket(ticketID);
    }
}
