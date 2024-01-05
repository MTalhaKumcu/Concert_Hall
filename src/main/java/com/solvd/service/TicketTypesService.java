package com.solvd.service;

import com.solvd.model.TicketsType;
import com.solvd.persistence.dao.TicketTypesDAO;

import java.util.List;

public class TicketTypesService {

    private final TicketTypesDAO ticketTypesDAO;

    public TicketTypesService(TicketTypesDAO ticketTypesDAO) {
        this.ticketTypesDAO = ticketTypesDAO;
    }

    public TicketsType getTicketTypeByID(int ticketTypeID) {
        return ticketTypesDAO.getTicketTypeByID(ticketTypeID);
    }

    public List<TicketsType> getAllTicketType() {
        return ticketTypesDAO.getAllTicketType();
    }

    public void addTicketType(TicketsType ticketsType) {
        ticketTypesDAO.addTicketType(ticketsType);
    }

    public void updateTicketType(TicketsType ticketsType) {
        ticketTypesDAO.updateTicketType(ticketsType);
    }

    public void deleteTicketType(int TicketTypeID) {
        ticketTypesDAO.deleteTicketType(TicketTypeID);
    }
}
