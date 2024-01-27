package com.solvd.factory;


import com.solvd.persistence.dao.*;
import com.solvd.service.JdbcDaoService.*;

import java.lang.reflect.Constructor;

public class FactoryService {

    public static ArtistService artistService(ArtistDAO artistDAO){
        ArtistService artistService = new ArtistService(artistDAO);
        return artistService;

    }

    public static CustomerService customerService(CustomerDAO customerDAO) {
       CustomerService customerService = new CustomerService(customerDAO);
        return customerService;
    }

    public static EventService eventService(EventDAO eventDAO) {
        EventService eventService = new EventService(eventDAO);
        return eventService;
    }

    public static GenreService genreService(GenreDAO genreDAO) {
        GenreService genreService = new GenreService(genreDAO);
        return genreService;
    }

    public static OrderService orderService(OrderDAO orderDAO) {
        OrderService orderService =new OrderService(orderDAO);
        return orderService;
    }

    public static OrderItemService orderItemService(OrderItemDAO orderItemDAO) {
        OrderItemService orderItemService = new OrderItemService(orderItemDAO);
        return orderItemService;
    }

    public static PaymentMethodService paymentMethodService(PaymentMethodDAO paymentMethodDAO) {
        PaymentMethodService paymentMethodService = new PaymentMethodService(paymentMethodDAO);
        return paymentMethodService;
    }

    public static RolesService rolesService(RoleDAO roleDAO) {
        RolesService rolesService = new RolesService(roleDAO);
        return rolesService;
    }

    public static StaffRoleService staffRoleService(StaffRoleDAO staffRoleDAO) {
        StaffRoleService staffRoleService = new StaffRoleService(staffRoleDAO);
        return staffRoleService;
    }

    public static StaffService staffService(StaffDAO staffDAO) {
        StaffService staffService = new StaffService(staffDAO);
        return staffService;
    }

    public static TicketService ticketService(TicketDAO ticketDAO) {
        TicketService ticketService = new TicketService(ticketDAO);
        return ticketService;
    }

    public static TicketTypeService ticketTypeService(TicketTypeDAO ticketTypeDAO) {
        TicketTypeService ticketTypeService = new TicketTypeService(ticketTypeDAO);
        return ticketTypeService;
    }
    public static VenueService venueService(VenueDAO venueDAO){
        VenueService venueService = new VenueService(venueDAO);
        return venueService;
    }

    public static <T> T createService(Class<T> serviceClass) {
        try {
            Constructor<T> constructor = serviceClass.getConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
