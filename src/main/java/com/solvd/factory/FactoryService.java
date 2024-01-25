package com.solvd.factory;


import com.solvd.service.FactoryService.IArtistService;

public class FactoryService {

    public static IArtistService createServiceInterface() {
        return createService(IArtistService.class);
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
