package com.solvd.service;

import com.solvd.model.TicketsType;
import com.solvd.persistence.dao.TicketTypeDAO;

import java.util.List;

public class TicketTypeService {

    private final TicketTypeDAO ticketTypeDAO;

    public TicketTypeService(TicketTypeDAO ticketTypeDAO) {
        this.ticketTypeDAO = ticketTypeDAO;
    }

    public TicketsType getTicketTypeByID(int ticketTypeID) {
        return ticketTypeDAO.getTicketTypeByID(ticketTypeID);
    }

    public List<TicketsType> getAllTicketType() {
        return ticketTypeDAO.getAllTicketType();
    }

    public void addTicketType(TicketsType ticketsType) {
        ticketTypeDAO.addTicketType(ticketsType);
    }

    public void updateTicketType(TicketsType ticketsType) {
        ticketTypeDAO.updateTicketType(ticketsType);
    }

    public void deleteTicketType(int TicketTypeID) {
        ticketTypeDAO.deleteTicketType(TicketTypeID);
    }
}
