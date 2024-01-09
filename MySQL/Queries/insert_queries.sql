-- Artists
INSERT INTO Artists (ArtistID, ArtistName, BirthDate, Country, GenreID ,ArtistSurname) VALUES 
(1, 'John', '1990-01-15', 'USA', 1),
(2, 'Jane', '1985-05-20', 'UK', 2),
(3, 'Kane', '1986-05-20', 'TR' ,3 ),
(4, 'Alex', '1992-08-10', 'USA', 1, 'Johnson'),
(5, 'Emma', '1995-02-28', 'Canada', 2, 'Davis'),
(6, 'David', '1988-11-15', 'USA', 1, 'Miller'),
(7, 'Sophie', '1993-04-03', 'France', 2, 'Anderson'),
(8, 'Michael', '1987-09-22', 'Germany' ,3 , 'Schmidt'),
(9, 'Olivia', '1996-07-18', 'USA', 2, 'Thomas'),
(10, 'Daniel', '1984-03-25', 'UK' ,1 , 'Wilson');

-- Genres
INSERT INTO Genres (GenreID, GenreName) VALUES 
 (1, 'Rock'),
 (2, 'Pop'),
 (3, 'Metal'),
 (4, 'Jazz'),
(5, 'Electronic'),
(6, 'Country'),
(7, 'Hip Hop'),
(8, 'Blues'),
(9, 'Classical'),
(10, 'R&B');
-- Venue
INSERT INTO Venue (VenueID, VenueName, Capacity, Location) VALUES 
(1, 'City Hall', 1000, 'Downtown'),
(2, 'Music Arena', 2000, 'Suburb'),
 (3, 'Music Arena', 3000, 'Center'),
(4, 'Stadium', 50000, 'Outskirts'),
(5, 'Club XYZ', 300, 'Downtown'),
(6, 'Amphitheater', 5000, 'Park'),
(7, 'Event Center', 2500, 'City Center'),
(8, 'Theater Royal', 1200, 'Downtown'),
(9, 'Pavilion', 800, 'Suburb'),
(10, 'Exhibition Hall', 1800, 'City Center');

-- Events
INSERT INTO Events (EventID, EventName, VenueID, EventDate, StartTime, EndTime, ArtistID) VALUES 
 (1, 'RockFest', 1, '2023-07-15', '18:00:00', '23:00:00', '1'),
 (2, 'PopConcert', 2, '2023-08-20', '19:30:00', '22:30:00', '2'),
 (3, 'MetalFest', 3, '2023-08-20', '19:30:00', '22:30:00', '3'),
(4, 'JazzNight', 4, '2023-09-10', '20:00:00', '23:00:00', '4'),
(5, 'ElectroBeats', 5, '2023-09-25', '21:00:00', '02:00:00', '5'),
(6, 'CountryShow', 6, '2023-10-05', '18:30:00', '21:30:00', '6'),
(7, 'HipHopParty', 7, '2023-10-15', '22:00:00', '02:00:00', '7'),
(8, 'BluesFestival', 8, '2023-11-08', '19:00:00', '22:30:00', '8'),
(9, 'ClassicalNight', 9, '2023-11-20', '20:30:00', '23:30:00', '9'),
(10, 'R&BMagic', 10, '2023-12-01', '21:30:00', '01:00:00', '10');

select * from events;

-- Tickets
INSERT INTO Tickets (TicketID, EventID, Price, TicketTypeID) VALUES 
(1, 1, 50.00, 1),
(2, 2, 75.00, 2),
 (3, 3, 75.00, 3),
(4, 4, 60.00, 4),
(5, 5, 40.00, 5),
(6, 6, 55.00, 6),
(7, 7, 65.00, 7),
(8, 8, 70.00, 8),
(9, 9, 80.00, 9),
(10, 10, 90.00, 10);

-- Customers
INSERT INTO Customers (CustomerID, FirstName, LastName, Email) VALUES 
(1, 'Alice', 'Johnson', 'alice@email.com'),
(2, 'Bob', 'Smith', 'bob@email.com'),
(3, 'Mehmet', 'Smith', 'Mehmet@email.com'),
(4, 'Eva', 'White', 'eva@email.com'),
(5, 'Chris', 'Martin', 'chris@email.com'),
(6, 'Sophia', 'Brown', 'sophia@email.com'),
(7, 'David', 'Taylor', 'david@email.com'),
(8, 'Emma', 'Clark', 'emma@email.com'),
(9, 'Daniel', 'Anderson', 'daniel@email.com'),
(10, 'Olivia', 'Moore', 'olivia@email.com');


-- Orders
INSERT INTO Orders (OrderID, CustomerID, EventID, PurchaseDate, TotalAmount ,PaymentMethodID) VALUES 
(1, 1, 1, '2023-07-10', 50.00, 1),
 (2, 2, 2, '2023-08-15', 75.00, 2),
 (3, 3, 3, '2023-08-15', 75.00, 3),
(4, 4, 4, '2023-09-20', 60.00, 1),
(5, 5, 5, '2023-09-30', 40.00, 2),
(6, 6, 6, '2023-10-10', 55.00, 3),
(7, 7, 7, '2023-10-18', 65.00, 1),
(8, 8, 8, '2023-11-12', 70.00, 2),
(9, 9, 9, '2023-11-25', 80.00, 3),
(10, 10, 10, '2023-12-05', 90.00, 1);

-- PaymentMethods
INSERT INTO PaymentMethods (PaymentMethodID, MethodName, Description) VALUES
(1, 'Credit Card', 'Visa'),
(2, 'PayPal', 'Online payment'),
(3, 'Credit Card', 'Online payment'),
(4, 'Cash', 'Payment in cash'),
(5, 'Bitcoin', 'Cryptocurrency payment'),
(6, 'Stripe', 'Online payment service'),
(7, 'Apple Pay', 'Digital wallet'),
(8, 'Google Pay', 'Digital wallet'),
(9, 'MasterCard', 'MasterCard payment'),
(10, 'American Express', 'Amex card payment');

-- OrderItems
INSERT INTO OrderItems (OrderItemID, OrderID, TicketID, Quantity, Subtotal) VALUES 
(1, 1, 1, 2, 100.00),
(2, 2, 2, 1, 75.00),
(3, 3, 3, 1, 75.00),
(4, 4, 4, 1, 60.00),
(5, 5, 5, 1, 40.00),
(6, 6, 6, 1, 55.00),
(7, 7, 7, 1, 65.00),
(8, 8, 8, 1, 70.00),
(9, 9, 9, 1, 80.00),
(10, 10, 10, 1, 90.00);


-- Staff 
INSERT INTO Staff (StaffID, FirstName, LastName, Position, ArtistID) VALUES 
(1, 'Alice', 'Manager', 'Manager', 1),
(2, 'Charlie', 'Assistant', 'Assistant', 2),
(3, 'Eve', 'Coordinator', 'Coordinator', 3),
(4, 'Ahmet' , 'Service ' ,'Runner ',4),
(5, 'Sophie' , 'Service ' ,'Runner ', 5),
(6, 'David' , 'Service ' ,'Runner ', 6),
(7, 'Michael' , 'Service ' ,'Runner ', 7),
(8, 'Emma' , 'Service ' ,'Runner ', 8),
(9, 'Daniel' , 'Service ' ,'Runner ', 9),
(10, 'Olivia' , 'Service ' ,'Runner ', 10);

-- TicketType
INSERT INTO TicketTypes (TicketTypeID, TypeName, Description) VALUES
(1, 'Regular', 'Standard admission ticket'),
(2, 'VIP', 'VIP access with additional perks'),
(3, 'Student', 'Discounted ticket for students'),
(4, 'Senior', 'Discounted ticket for seniors'),
(5, 'Family Pack', 'Admission for a family at a discounted rate'),
(6, 'Group Discount', 'Discounted rate for group bookings'),
(7, 'Early Bird', 'Special discount for early bookings'),
(8, 'Backstage Pass', 'Access to backstage areas'),
(9, 'Golden Circle', 'Premium viewing area access'),
(10, 'Front Row', 'Front row seating');

