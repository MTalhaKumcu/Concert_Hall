-- Artists
INSERT INTO Artists (ArtistID, ArtistName, BirthDate, Country, GenreID ,ArtistSurname) VALUES (1, 'John', '1990-01-15', 'USA', 1);
INSERT INTO Artists (ArtistID, ArtistName, BirthDate, Country, GenreID, ArtistSurname) VALUES (2, 'Jane', '1985-05-20', 'UK', 2);
INSERT INTO Artists (ArtistID, ArtistName, BirthDate, Country, GenreID) VALUES (3, 'Kane', '1986-05-20', 'TR' ,3 );

-- Genres
INSERT INTO Genres (GenreID, GenreName) VALUES (1, 'Rock');
INSERT INTO Genres (GenreID, GenreName) VALUES (2, 'Pop');
INSERT INTO Genres (GenreID, GenreName) VALUES (3, 'Metal');

-- Venues
INSERT INTO Venues (VenueID, VenueName, Capacity, Location) VALUES (1, 'City Hall', 1000, 'Downtown');
INSERT INTO Venues (VenueID, VenueName, Capacity, Location) VALUES (2, 'Music Arena', 2000, 'Suburb');
INSERT INTO Venues (VenueID, VenueName, Capacity, Location) VALUES (3, 'Music Arena', 3000, 'Center');

-- Events
INSERT INTO Events (EventID, EventName, VenueID, Date, StartTime, EndTime) VALUES (1, 'RockFest', 1, '2023-07-15', '18:00:00', '23:00:00');
INSERT INTO Events (EventID, EventName, VenueID, Date, StartTime, EndTime) VALUES (2, 'PopConcert', 2, '2023-08-20', '19:30:00', '22:30:00');
INSERT INTO Events (EventID, EventName, VenueID, Date, StartTime, EndTime) VALUES (3, 'MetalFest', 3, '2023-08-20', '19:30:00', '22:30:00');

-- Tickets
INSERT INTO Tickets (TicketID, EventID, Price, TicketTypeID) VALUES (1, 1, 50.00, 1);
INSERT INTO Tickets (TicketID, EventID, Price, TicketTypeID) VALUES (2, 2, 75.00, 2);
INSERT INTO Tickets (TicketID, EventID, Price, TicketTypeID) VALUES (3, 3, 75.00, 3);

-- Customers
INSERT INTO Customers (CustomerID, FirstName, LastName, Email) VALUES (1, 'Alice', 'Johnson', 'alice@email.com');
INSERT INTO Customers (CustomerID, FirstName, LastName, Email) VALUES (2, 'Bob', 'Smith', 'bob@email.com');
INSERT INTO Customers (CustomerID, FirstName, LastName, Email) VALUES (3, 'Mehmet', 'Smith', 'Mehmet@email.com');

-- Orders
INSERT INTO Orders (OrderID, CustomerID, EventID, PurchaseDate, TotalAmount ,PaymentMethodID) VALUES (1, 1, 1, '2023-07-10', 50.00,1);
INSERT INTO Orders (OrderID, CustomerID, EventID, PurchaseDate, TotalAmount ,PaymentMethodID) VALUES (2, 2, 2, '2023-08-15', 75.00,2);
INSERT INTO Orders (OrderID, CustomerID, EventID, PurchaseDate, TotalAmount ,PaymentMethodID) VALUES (3, 3, 3, '2023-08-15', 75.00,3);

-- PaymentMethods
INSERT INTO PaymentMethods (PaymentMethodID, MethodName, Description) VALUES (1, 'Credit Card', 'Visa');
INSERT INTO PaymentMethods (PaymentMethodID, MethodName, Description) VALUES (2, 'PayPal', 'Online payment');
INSERT INTO PaymentMethods (PaymentMethodID, MethodName, Description) VALUES (3, 'Credit Card', 'Online payment');

-- OrderItems
INSERT INTO OrderItems (OrderItemID, OrderID, TicketID, Quantity, Subtotal) VALUES (1, 1, 1, 2, 100.00);
INSERT INTO OrderItems (OrderItemID, OrderID, TicketID, Quantity, Subtotal) VALUES (2, 2, 2, 1, 75.00);
INSERT INTO OrderItems (OrderItemID, OrderID, TicketID, Quantity, Subtotal) VALUES (3, 3, 3, 1, 75.00);

-- Staff 
INSERT INTO Staff (StaffID, FirstName, LastName, Position, ArtistID) VALUES (1, 'Alice', 'Manager', 'Manager', 1);
INSERT INTO Staff (StaffID, FirstName, LastName, Position, ArtistID) VALUES (2, 'Charlie', 'Assistant', 'Assistant', 2);
INSERT INTO Staff (StaffID, FirstName, LastName, Position, ArtistID) VALUES (3, 'Eve', 'Coordinator', 'Coordinator', 3);
INSERT INTO Staff (StaffID, FirstName, LastName, Position) VALUES (4, 'Ahmet' , 'Service ' ,'Runner ');

-- TicketType
INSERT INTO TicketTypes (TicketTypeID, TypeName, Description) VALUES (1, 'Regular', 'Standard admission ticket');
INSERT INTO TicketTypes (TicketTypeID, TypeName, Description) VALUES (2, 'VIP', 'VIP access with additional perks');
INSERT INTO TicketTypes (TicketTypeID, TypeName, Description) VALUES (3, 'Student', 'Discounted ticket for students');

