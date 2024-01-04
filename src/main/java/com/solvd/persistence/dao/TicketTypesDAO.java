package com.solvd.persistence.dao;


import com.solvd.model.TicketTypes;

import java.util.List;

public interface TicketTypesDAO {

    TicketTypes getTicketByID(int ticketTypeID);
    List<TicketTypes> getAllTickets();
    void addTicketType(TicketTypes ticketTypes);
    void updateTicketType(TicketTypes ticketTypes);
    void deleteTicketType(int TicketTypeID);
}