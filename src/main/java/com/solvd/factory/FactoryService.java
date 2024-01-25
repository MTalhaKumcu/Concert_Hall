package com.solvd.factory;


import com.solvd.service.FactoryService.*;

public class FactoryService {

    public static IArtistService createArtistService() {
        return createService(IArtistService.class);
    }

    public static ICustomerService createCustomerService() {
        return createService(ICustomerService.class);
    }

    public static IEventService createEventService() {
        return createService(IEventService.class);
    }

    public static IGenreService createGenreService() {
        return createService(IGenreService.class);
    }

    public static IOrderItemService createOrderItemService() {
        return createService(IOrderItemService.class);
    }

    public static IOrderService createOrderService() {
        return createService(IOrderService.class);
    }

    public static IPaymentsMethodService createPaymentsMethodService() {
        return createService(IPaymentsMethodService.class);
    }

    public static IRoleService createRoleService() {
        return createService(IRoleService.class);
    }

    public static IStaffRoleService createStaffRoleService() {
        return createService(IStaffRoleService.class);
    }

    public static IStaffService createStaffService() {
        return createService(IStaffService.class);
    }

    public static ITicketService createTicketService() {
        return createService(ITicketService.class);

    }

    public static ITicketsTypeService createTicketsTypeService() {
        return createService(ITicketsTypeService.class);

    }

    public static IVenueService createVenueService() {
        return createService(IVenueService.class);
    }

    private static <T> T createService(Class<T> serviceInterface) {
        try {
            String type = System.getProperty("implementation");
            if (type == null) {
                throw new RuntimeException("System property 'implementation' not set.");
            }
            String className = "com.solvd.service." + type + "." + serviceInterface.getSimpleName() + "Impl";
            Class<?> serviceClass = Class.forName(className);
            return serviceInterface.cast(serviceClass.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            throw new RuntimeException("Unable to create object", e);
        }
    }
}
