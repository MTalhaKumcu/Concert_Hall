package com.solvd.persistence.dao;


import com.solvd.model.TicketsType;

import java.util.List;

public interface TicketTypesDAO {

    TicketsType getTicketTypeByID(int ticketTypeID);
    List<TicketsType> getAllTicketType();
    void addTicketType(TicketsType ticketsType);
    void updateTicketType(TicketsType ticketsType);
    void deleteTicketType(int TicketTypeID);
}