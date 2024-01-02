-- Update Artist's Country
UPDATE Artists SET Country = 'Canada' WHERE ArtistID = 1;
UPDATE Artists SET GenreID = 1 WHERE ArtistID = 1;
UPDATE Artists SET GenreID = 2 WHERE ArtistID = 2;
UPDATE Artists SET GenreID = 3 WHERE ArtistID = 3;

UPDATE Artists SET ArtistSurname = 'doe' WHERE ArtistID = 1;
UPDATE Artists SET ArtistSurname = 'doe' WHERE ArtistID = 2;

-- Update Event's Start Time
UPDATE Events SET StartTime = '19:00:00' WHERE EventID = 1;

-- Update Venue's Location
UPDATE Venues SET Location = 'City Center' WHERE VenueID = 1;

-- Update Ticket's Price
UPDATE Tickets SET Price = 60.00 WHERE TicketID = 1;

-- Update Customer's Email
UPDATE Customers SET Email = 'newemail@email.com' WHERE CustomerID = 1;

-- Update Order's Purchase Date
UPDATE Orders SET PurchaseDate = '2023-07-12' WHERE OrderID = 1;

-- Update Payment Method's Description
UPDATE PaymentMethods SET Description = 'MasterCard' WHERE PaymentMethodID = 1;

-- Update Order Item's Quantity
UPDATE OrderItems SET Quantity = 3 WHERE OrderItemID = 1;

-- Update Staff's Position
UPDATE Staff SET Position = 'Manager' WHERE StaffID = 1;
UPDATE Staff SET StaffID = 1 WHERE ArtistID = 1;

-- Update Role's Description
UPDATE Roles SET Description = 'Senior Manager' WHERE RoleID = 1;
