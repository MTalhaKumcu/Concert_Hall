package com.solvd;


import com.solvd.model.*;
import com.solvd.persistence.connection.ConnectionPool;
import com.solvd.persistence.dao.*;
import com.solvd.persistence.daoImpl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
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


            Artist newArtist = new Artist();
            newArtist.setArtistName("Mehmet");
            newArtist.setArtistSurame("Kumcu");
            newArtist.setBirthDate(new Date(1997,3,31)); // Set birth date accordingly
            newArtist.setCountry("TURKEY");
            artistDAO.addArtist(newArtist);
            LOGGER.info("New artist added: ", newArtist);


            // Example operations with ArtistDAO
            LOGGER.info("Fetching all artists:");
            List<Artist> artists = artistDAO.getAllArtists();
            artists.forEach(artist -> LOGGER.info(artist));

            Genre newGenre = new Genre();
            newGenre.setGenreID(15);
            newGenre.setGenreName("country music");
            LOGGER.info("New genre added:", newGenre);


            // Example operations with GenreDAO
            LOGGER.info("Fetching all genres:");
            List<Genre> genres = genreDAO.getAllGenres();
            genres.forEach(genre -> LOGGER.info(genre));

            // Example operations with EventDAO
            LOGGER.info("Fetching all events:");
            List<Event> events = eventDAO.getAllEvents();
            events.forEach(event -> LOGGER.info(event));

            Venue newVenue = new Venue();
            newVenue.setVenueID(20);
            newVenue.setVenueName("Solvd Main Saloon");
            newVenue.setCapacity(200);
            newVenue.setLocation("Aleja Jerozolimskie 98");

            LOGGER.info("New venue added:", newVenue);


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

            // Example operations with StaffDAO
            LOGGER.info("Fetching all staff:");
            List<Staff> staffList = staffDAO.getAllStaffs();
            staffList.forEach(staff -> LOGGER.info(staff));

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


