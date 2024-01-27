package com.solvd.factory;


import com.solvd.service.JdbcDaoService.*;

import java.lang.reflect.Constructor;

public class FactoryService {

    public static ArtistService artistService(){
        return createService(ArtistService.class);
    }

    public static CustomerService customerService() {
        return createService(CustomerService.class);
    }

    public static EventService eventService() {
        return createService(EventService.class);
    }

    public static GenreService genreService() {
        return createService(GenreService.class);
    }

    public static OrderService orderService() {
        return createService(OrderService.class);
    }

    public static OrderItemService orderItemService() {
        return createService(OrderItemService.class);
    }

    public static PaymentMethodService paymentMethodService() {
        return createService(PaymentMethodService.class);
    }

    public static RolesService rolesService() {
        return createService(RolesService.class);
    }

    public static StaffRoleService staffRoleService() {
        return createService(StaffRoleService.class);
    }

    public static StaffService staffService() {
        return createService(StaffService.class);
    }

    public static TicketService ticketService() {
        return createService(TicketService.class);
    }

    public static TicketTypeService ticketTypeService() {
        return createService(TicketTypeService.class);
    }
    public static VenueService venueService(){
        return createService(VenueService.class);
    }

    public static <T> T createService(Class<T> serviceClass) {
        try {
            // Servis sınıfının parametresiz bir constructor'ı olmalı
            Constructor<T> constructor = serviceClass.getConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace(); // Hata durumunda ekrana yazdırabilirsiniz.
            return null;
        }
    }
}
