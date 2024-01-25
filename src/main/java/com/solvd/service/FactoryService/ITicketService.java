package com.solvd.service.FactoryService;

import com.solvd.model.Ticket;

public interface ITicketService {
    Ticket createTicket(Ticket ticket);

    Ticket getTicketByID(int ticketID);
}
