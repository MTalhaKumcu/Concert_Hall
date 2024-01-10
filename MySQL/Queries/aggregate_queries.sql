-- Count the number of event for each venue
SELECT Venue.VenueID, VenueName, COUNT(Events.EventID) AS EventCount
FROM Venue
LEFT JOIN Events ON Venue.VenueID = Events.VenueID
GROUP BY Venue.VenueID ;

-- Total Revenue Grouping
SELECT ArtistID, SUM(TotalAmount) AS TotalRevenue
FROM Events
JOIN Orders ON Events.EventID = Orders.EventID
GROUP BY ArtistID;

-- Number of Customers Grouping:
SELECT VenueID, COUNT(DISTINCT CustomerID) AS TotalCustomers
FROM Events
JOIN Orders ON Events.EventID = Orders.EventID
GROUP BY VenueID;

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

-- Find the maximum capacity among venue
SELECT MAX(Capacity) AS MaxCapacity
FROM Venue;

-- Calculate the total number of ticket sold for each event
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

-- Total Revenue Grouping and Filtering
SELECT ArtistID, SUM(TotalAmount) AS TotalRevenue
FROM Events
JOIN Orders ON Events.EventID = Orders.EventID
GROUP BY ArtistID
HAVING TotalRevenue > 1000;

-- Event Number Grouping and Filtering:

SELECT VenueID, COUNT(EventID) AS TotalEvents
FROM Events
GROUP BY VenueID
HAVING TotalEvents >= 1;

-- Event Number Grouping and Filtering:

SELECT ArtistID, COUNT(DISTINCT CustomerID) AS UniqueCustomers
FROM Events
JOIN Orders ON Events.EventID = Orders.EventID
GROUP BY ArtistID
HAVING UniqueCustomers >= 50;

-- Average Ticket Price Grouping and Filtering:
SELECT VenueID, AVG(Price) AS AverageTicketPrice
FROM Tickets
GROUP BY VenueID
HAVING AverageTicketPrice < 50.00;
-- Average Spend per Customer Grouping and Filtering:
SELECT CustomerID, AVG(TotalAmount) AS AvgSpendingPerCustomer
FROM Orders
GROUP BY CustomerID
HAVING AvgSpendingPerCustomer > 75.00;

--  Grouping and Filtering Number of Sales per Event:

SELECT EventID, COUNT(OrderID) AS TotalSales
FROM Orders
GROUP BY EventID
HAVING TotalSales >= 5;

-- It shows which event each artist belongs to.
SELECT Artists.ArtistID, ArtistName, EventID, EventName
FROM Artists
INNER JOIN Events ON Artists.ArtistID = Events.ArtistID;

-- It shows where each event takes place.
SELECT Events.EventID, EventName, VenueName, Location
FROM Events
INNER JOIN Venue ON Events.VenueID = Venue.VenueID;

-- Shows the types of ticket sold for each event.
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

-- Artists and Events (Left Outer Join + Right Outer Join)
SELECT Artists.ArtistID, ArtistName, EventID, EventName
FROM Artists
LEFT JOIN Events ON Artists.ArtistID = Events.ArtistID
UNION
SELECT Artists.ArtistID, ArtistName, EventID, EventName
FROM Events
RIGHT JOIN Artists ON Artists.ArtistID = Events.ArtistID;

-- Venues and Events (Left Outer Join + Right Outer Join):
SELECT Events.EventID, EventName, VenueName, Location
FROM Events
LEFT JOIN Venue ON Events.VenueID = Venue.VenueID
UNION
SELECT Events.EventID, EventName, VenueName, Location
FROM Venue
RIGHT JOIN Events ON Events.VenueID = Venue.VenueID;


-- Customers and Orders (Left Outer Join + Right Outer Join)
SELECT Customers.CustomerID, FirstName, LastName, EventName, PurchaseDate, TotalAmount
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
LEFT JOIN Events ON Orders.EventID = Events.EventID
UNION
SELECT Customers.CustomerID, FirstName, LastName, EventName, PurchaseDate, TotalAmount
FROM Orders
RIGHT JOIN Customers ON Customers.CustomerID = Orders.CustomerID
RIGHT JOIN Events ON Orders.EventID = Events.EventID;

-- Staffs and Artists (Left Outer Join + Right Outer Join):
SELECT Staff.StaffID, FirstName, LastName, Position, ArtistName
FROM Staff
LEFT JOIN Artists ON Staff.ArtistID = Artists.ArtistID
UNION
SELECT Staff.StaffID, FirstName, LastName, Position, ArtistName
FROM Artists
RIGHT JOIN Staff ON Staff.ArtistID = Artists.ArtistID;


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