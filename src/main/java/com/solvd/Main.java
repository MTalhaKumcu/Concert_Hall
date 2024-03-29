package com.solvd;


import com.solvd.factory.FactoryService;
import com.solvd.model.*;
import com.solvd.persistence.connection.ConnectionPool;
import com.solvd.persistence.dao.*;
import com.solvd.persistence.daoImpl.*;
import com.solvd.service.JdbcDaoService.ArtistService;
import com.solvd.service.JdbcDaoService.CustomerService;
import com.solvd.service.JdbcDaoService.GenreService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.List;


public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        ConnectionPool connectionPool = new ConnectionPool();

            try {

                // Create DAO instances
                ArtistDAO artistDAO = new JdbcArtistDAO(connectionPool);
                GenreDAO genreDAO = new JdbcGenreDAO(connectionPool);
                EventDAO eventDAO = new JdbcEventDAO(connectionPool);
                VenueDAO venueDAO = new JdbcVenueDAO(connectionPool);
                TicketDAO ticketDAO = new JdbcTicketDAO(connectionPool);
                TicketTypeDAO ticketTypeDAO = new JdbcTicketTypeDAO(connectionPool);
                CustomerDAO customerDAO = new JdbcCustomerDAO(connectionPool);
                OrderDAO orderDAO = new JdbcOrderDAO(connectionPool);
                PaymentMethodDAO paymentMethodDAO = new JdbcPaymentMethodDAO(connectionPool);
                OrderItemDAO orderItemDAO = new JdbcOrderItemDAO(connectionPool);
                StaffDAO staffDAO = new JdbcStaffDAO(connectionPool);
                RoleDAO roleDAO = new JdbcRoleDAO(connectionPool);
                StaffRoleDAO staffRoleDAO = new JdbcStaffRoleDAO(connectionPool);

                ArtistService artistService = FactoryService.artistService(artistDAO);
                artistService.getAllArtists();
                LOGGER.info(artistService);
    
                CustomerService customerService = FactoryService.customerService(customerDAO);
                customerService.addCustomer(new Customer(1234));
                LOGGER.info("customer added from factory", customerService);
    
                GenreService genreService = FactoryService.genreService(genreDAO);
                genreService.updateGenre(new Genre(30, "new genre type from factory!!!"));
                LOGGER.info("genre updated from factory", genreService);

                Staff staff = new Staff.StaffBuilder(25,"builder Mehmet","kumcu" ,"devops tester").build();
                LOGGER.info("staff added from builder", staff);
    

                Artist newArtist = new Artist();
                newArtist.setArtistName("Mehmet");
                newArtist.setArtistSurame("Kumcu");
                newArtist.setBirthDate(new Date(1997, 3, 31)); // Set birth date accordingly
                newArtist.setCountry("TURKEY");
                artistDAO.addArtist(newArtist);
                LOGGER.info("New artist added: ", newArtist);
    
                Genre newGenre = new Genre();
                newGenre.setGenreID(15);
                newGenre.setGenreName("country music");
                LOGGER.info("New genre added:", newGenre);
    
                Venue newVenue = new Venue();
                newVenue.setVenueID(20);
                newVenue.setVenueName("Solvd Main Saloon");
                newVenue.setCapacity(200);
                newVenue.setLocation("Aleja Jerozolimskie 98");
                LOGGER.info("New venue added:", newVenue);
    
    
                TicketsType newTicketsType = new TicketsType();
                newTicketsType.setTicketTypeID(20);
                newTicketsType.setTicketTypeName("new disable status");
                newTicketsType.setDescription("Autism person");
                LOGGER.info("new ticket type added", newTicketsType);
    
                PaymentsMethod newPaymentsMethod = new PaymentsMethod();
                newPaymentsMethod.setPaymentMethodID(6);
                newPaymentsMethod.setPaymentMethodName("exchange method");
                newPaymentsMethod.setDescription("exchange method is new payments way to pay");
                LOGGER.info("new payment method added", newPaymentsMethod);
    
                Customer newCustomer = new Customer();
                newCustomer.setCustomerID(123);
                newCustomer.setFirstName("deniz");
                newCustomer.setLastName("gunduz");
                newCustomer.setEmail("deniz@solvd.com");
                LOGGER.info("new customer added", newCustomer);
    
    
                // Example operations with ArtistDAO
                LOGGER.info("Fetching all artists:");
                List<Artist> artists = artistDAO.getAllArtists();
                artists.forEach(artist -> LOGGER.info(artist));
    
                // Example operations with GenreDAO
                LOGGER.info("Fetching all genres:");
                List<Genre> genres = genreDAO.getAllGenres();
                genres.forEach(genre -> LOGGER.info(genre));
    
                // Example operations with EventDAO
                LOGGER.info("Fetching all events:");
                List<Event> events = eventDAO.getAllEvents();
                events.forEach(event -> LOGGER.info(event));
    
                // Example operations with VenueDAO
                LOGGER.info("Fetching all venues:");
                List<Venue> venues = venueDAO.getAllVenues();
                venues.forEach(venue -> LOGGER.info(venue));
    
                // Example operations with TicketDAO
                LOGGER.info("Fetching all tickets:");
                List<Ticket> tickets = ticketDAO.getAllTicket();
                tickets.forEach(ticket -> LOGGER.info(ticket));
    
                // Example operations with TicketTypeDAO
                LOGGER.info("Fetching all ticket types:");
                List<TicketsType> ticketTypes = ticketTypeDAO.getAllTicketType();
                ticketTypes.forEach(ticketType -> LOGGER.info(ticketType));
    
                // Example operations with CustomerDAO
                LOGGER.info("Fetching all customers:");
                List<Customer> customers = customerDAO.getAllCustomers();
                customers.forEach(customer -> LOGGER.info(customer));
    
                // Example operations with OrderDAO
                LOGGER.info("Fetching all orders:");
                List<Order> orders = orderDAO.getAllOrders();
                orders.forEach(order -> LOGGER.info(order));
    
                // Example operations with PaymentMethodDAO
                LOGGER.info("Fetching all payment methods:");
                List<PaymentsMethod> paymentMethods = paymentMethodDAO.getAllPaymentMethods();
                paymentMethods.forEach(paymentMethod -> LOGGER.info(paymentMethod));
    
                // Example operations with OrderItemDAO
                LOGGER.info("Fetching all order items:");
                List<OrderItem> orderItems = orderItemDAO.getAllOrderItems();
                orderItems.forEach(orderItem -> LOGGER.info(orderItem));
    
                // Example operations with RoleDAO
                LOGGER.info("Fetching all roles:");
                List<Role> roles = roleDAO.getAllRoles();
                roles.forEach(role -> LOGGER.info(role));
    
                // Example operations with StaffRoleDAO
                LOGGER.info("Fetching all staff roles:");
                List<StaffRole> staffRoles = staffRoleDAO.getAllStaffRoles();
                staffRoles.forEach(staffRole -> LOGGER.info(staffRole));
    
            } catch (Exception e) {
            LOGGER.error("An error occurred: ", e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the connection pool
            ConnectionPool.closeConnectionPool();
        }


    }

}


