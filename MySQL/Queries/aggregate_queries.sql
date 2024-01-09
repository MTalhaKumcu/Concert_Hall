-- Count the number of events for each venue
SELECT Venue.VenueID, VenueName, COUNT(Events.EventID) AS EventCount
FROM Venue
LEFT JOIN Events ON Venue.VenueID = Events.VenueID
GROUP BY Venue.VenueID;

-- Calculate the total revenue for each event
SELECT Events.EventID, EventName, SUM(OrderItems.Subtotal) AS TotalRevenue
FROM Events
LEFT JOIN Orders ON Events.EventID = Orders.EventID
LEFT JOIN OrderItems ON Orders.OrderID = OrderItems.OrderID
GROUP BY Events.EventID;

-- Find the average ticket price for each genre
SELECT Genres.GenreID, GenreName, AVG(Tickets.Price) AS AvgTicketPrice
FROM Genres
LEFT JOIN Artists ON Genres.GenreID = Artists.GenreID
LEFT JOIN Events ON Artists.ArtistID = Events.ArtistID
LEFT JOIN Tickets ON Events.EventID = Tickets.EventID
GROUP BY Genres.GenreID;

-- Find the maximum capacity among venues
SELECT MAX(Capacity) AS MaxCapacity
FROM Venue;

-- Calculate the total number of tickets sold for each event
SELECT Events.EventID, EventName, SUM(OrderItems.Quantity) AS TotalTicketsSold
FROM Events
LEFT JOIN Orders ON Events.EventID = Orders.EventID
LEFT JOIN OrderItems ON Orders.OrderID = OrderItems.OrderID
GROUP BY Events.EventID;

-- Find the artist with the highest total revenue
SELECT Artists.ArtistID, ArtistName, SUM(OrderItems.Subtotal) AS TotalRevenue
FROM Artists
LEFT JOIN Events ON Artists.ArtistID = Events.ArtistID
LEFT JOIN Tickets ON Events.EventID = Tickets.EventID
LEFT JOIN OrderItems ON Tickets.TicketID = OrderItems.TicketID
GROUP BY Artists.ArtistID
ORDER BY TotalRevenue DESC
LIMIT 1;

-- It shows which events each artist belongs to.
SELECT Artists.ArtistID, ArtistName, EventID, EventName
FROM Artists
INNER JOIN Events ON Artists.ArtistID = Events.ArtistID;

-- It shows where each event takes place.
SELECT Events.EventID, EventName, VenueName, Location
FROM Events
INNER JOIN Venue ON Events.VenueID = Venue.VenueID;

-- Shows the types of tickets sold for each event.
SELECT Events.EventID, EventName, TypeName, Description
FROM Events
INNER JOIN Tickets ON Events.EventID = Tickets.EventID
INNER JOIN TicketTypes ON Tickets.TicketTypeID = TicketTypes.TicketTypeID;

-- It shows each customer placed an order for which event and on which date.

SELECT Customers.CustomerID, FirstName, LastName, EventName, PurchaseDate, TotalAmount
FROM Customers
INNER JOIN Orders ON Customers.CustomerID = Orders.CustomerID
INNER JOIN Events ON Orders.EventID = Events.EventID;

-- Shows which artist each staff member manages.
SELECT Staff.StaffID, FirstName, LastName, Position, ArtistName
FROM Staff
INNER JOIN Artists ON Staff.ArtistID = Artists.ArtistID;

-- Artists and Events (Left Outer Join)
SELECT Artists.ArtistID, ArtistName, EventID, EventName
FROM Artists
LEFT JOIN Events ON Artists.ArtistID = Events.ArtistID ;

-- Venues and Events (Left Outer Join):
SELECT Events.EventID, EventName, VenueName, Location
FROM Events
RIGHT JOIN Venue ON Events.VenueID = Venue.VenueID;

-- Customers and Orders (Left Outer Join)
SELECT Customers.CustomerID, FirstName, LastName, EventName, PurchaseDate, TotalAmount
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
LEFT JOIN Events ON Orders.EventID = Events.EventID;

-- Staffs and Artists (Right Outer Join):
SELECT Staff.StaffID, FirstName, LastName, Position, ArtistName
FROM Staff
RIGHT JOIN Artists ON Staff.ArtistID = Artists.ArtistID;

-- Tickets and Events (right and left outter joins)
SELECT Events.EventID, EventName, TypeName, Description
FROM Events
LEFT JOIN Tickets ON Events.EventID = Tickets.EventID
LEFT JOIN TicketTypes ON Tickets.TicketTypeID = TicketTypes.TicketTypeID
UNION
SELECT Events.EventID, EventName, TypeName, Description
FROM Tickets
RIGHT JOIN Events ON Events.EventID = Tickets.EventID
RIGHT JOIN TicketTypes ON Tickets.TicketTypeID = TicketTypes.TicketTypeID;