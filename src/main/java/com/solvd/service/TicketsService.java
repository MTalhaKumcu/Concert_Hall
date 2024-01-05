package com.solvd.service;

import com.solvd.model.Tickets;
import com.solvd.persistence.dao.TicketsDAO;

import java.util.List;

public class TicketsService {
    private final TicketsDAO ticketsDAO;

    public TicketsService(TicketsDAO ticketsDAO) {
        this.ticketsDAO = ticketsDAO;
    }

    public Tickets getTicketByID(int ticketID) {
        return ticketsDAO.getTicketByID(ticketID);
    }

    public List<Tickets> getAllTickets() {
        return ticketsDAO.getAllTickets();
    }

    public void addTicket(Tickets tickets) {
        ticketsDAO.addTicket(tickets);
    }

    public void updateTicket(Tickets tickets) {
        ticketsDAO.updateTicket(tickets);
    }

    public void deleteTicket(int ticketID) {
        ticketsDAO.deleteTicket(ticketID);
    }
}
