package com.solvd.service.FactoryService;

import com.solvd.model.TicketsType;

public interface ITicketsTypeService {
    TicketsType createTicketsType(TicketsType ticketsType);

    TicketsType getTicketsTypeByID(int ticketsTypeID);
}
