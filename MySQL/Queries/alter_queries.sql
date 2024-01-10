-- Add a new column to Artists table
ALTER TABLE Artists ADD COLUMN Website VARCHAR(255);
ALTER TABLE Artists ADD COLUMN ArtistSurname VARCHAR(255);
select * from artist;

-- Rename a column in Events table
ALTER TABLE Events ADD COLUMN EventDate DATE;
ALTER TABLE Events ADD COLUMN ArtistID INT ;
ALTER TABLE Events add CONSTRAINT fk_eventtArtistID FOREIGN KEY (ArtistID) REFERENCES artist(ArtistID) ;

SELECT * FROM event;

-- Increase the capacity in Venues table
ALTER TABLE Venues MODIFY COLUMN Capacity INT UNSIGNED;

-- Add a foreign key to OrderItems table
ALTER TABLE OrderItems ADD CONSTRAINT fk_OrderItemTicket FOREIGN KEY (TicketID) REFERENCES Tickets(TicketID);

select * from OrderItems;

-- Drop a column from Customers table
ALTER TABLE Customers DROP COLUMN PhoneNumber;

-- Add a column to Staff table and foreign key
ALTER TABLE Staff ADD COLUMN  ArtistID INT; 
ALTER TABLE Staff ADD CONSTRAINT fk_ArtistStaff FOREIGN KEY (ArtistID) REFERENCES Artists(ArtistID);

-- Add a column to order table and foreign key
ALTER TABLE order ADD COLUMN  PaymentMethodID INT;
ALTER TABLE order ADD CONSTRAINT fk_paymentMethod FOREIGN KEY (PaymentMethodID) REFERENCES PaymentMethods(PaymentMethodID);

-- Drop a column to Ticket in TickeTypes 
ALTER TABLE Tickets DROP COLUMN TicketType;

-- Add a column to Ticket table and foreign key
ALTER TABLE Tickets ADD COLUMN  TicketTypeID INT;
ALTER TABLE Tickets ADD CONSTRAINT fk_TicketTypeID FOREIGN KEY (TicketTypeID) REFERENCES TicketTypes(TicketTypeID);


select * from orderitems;