USE `concert_hall` ;

-- -----------------------------------------------------
-- Table Artists
-- -----------------------------------------------------
CREATE TABLE Artists (
	ArtistID INT PRIMARY KEY,
    ArtistName VARCHAR(255) NOT NULL,
    BirthDate DATE,
    Country VARCHAR(255),
    GenreID INT,
    CONSTRAINT fk_Genre FOREIGN KEY (Genre_ID) REFERENCES Genres(GenreID)
);

-- -----------------------------------------------------
-- Table Genres
-- -----------------------------------------------------
CREATE TABLE Genres (
	GenreID INT PRIMARY KEY,
    GenreName VARCHAR(255) NOT NULL
);
-- -----------------------------------------------------
-- Table Events
-- -----------------------------------------------------
CREATE TABLE Events (
    EventID INT PRIMARY KEY,
    EventName VARCHAR(255) NOT NULL,
    VenueID INT, -- Foreign Key referencing Venues table
    Date DATE,
    StartTime TIME,
    EndTime TIME,
    CONSTRAINT fk_Venue FOREIGN KEY (VenueID) REFERENCES Venues(VenueID)
);
-- -----------------------------------------------------
-- Table Venue
-- -----------------------------------------------------
CREATE TABLE Venue (
	VenueID INT PRIMARY KEY NOT NULL ,
    VenueName VARCHAR(255) NOT NULL,
    Capacity INT,
    Location VARCHAR(255)
);

-- -----------------------------------------------------
-- Table Tickets
-- -----------------------------------------------------
CREATE TABLE Tickets (
	TicketID INT PRIMARY KEY,
    EventID INT,
    Price DECIMAL (10,2) NOT NULL,
    TicketType VARCHAR(50),
    CONSTRAINT fk_Event FOREIGN KEY (EventID) REFERENCES Events(EventID)
);

-- -----------------------------------------------------
-- Table Customers
-- -----------------------------------------------------
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    Email VARCHAR(255),
    PhoneNumber VARCHAR(15)
);
-- -----------------------------------------------------
-- Table Orders
-- -----------------------------------------------------

CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    CustomerID INT, 
    EventID INT, 
    PurchaseDate DATE,
    TotalAmount DECIMAL(10, 2),
    CONSTRAINT fk_CustomerOrder FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
    CONSTRAINT fk_EventOrder FOREIGN KEY (EventID) REFERENCES Events(EventID)
);
-- -----------------------------------------------------
-- Table PaymentMethods
-- -----------------------------------------------------
CREATE TABLE PaymentMethods (
    PaymentMethodID INT PRIMARY KEY,
    MethodName VARCHAR(50) NOT NULL,
    Description VARCHAR(255)
);
-- -----------------------------------------------------
-- Table OrderItems
-- -----------------------------------------------------
CREATE TABLE OrderItems (
    OrderItemID INT PRIMARY KEY,
    OrderID INT, 
    TicketID INT,
    Quantity INT,
    Subtotal DECIMAL(10, 2),
    CONSTRAINT fk_Order FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    CONSTRAINT fk_TicketOrderItem FOREIGN KEY (TicketID) REFERENCES Tickets(TicketID)
);
-- -----------------------------------------------------
-- Table Staff
-- -----------------------------------------------------
CREATE TABLE Staff (
    StaffID INT PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    Position VARCHAR(50)
);
-- -----------------------------------------------------
-- Table Roles
-- -----------------------------------------------------
CREATE TABLE Roles (
    RoleID INT PRIMARY KEY,
    RoleName VARCHAR(50) NOT NULL,
    Description VARCHAR(255)
);
-- -----------------------------------------------------
-- Table StaffRoles
-- -----------------------------------------------------
CREATE TABLE StaffRoles (
    StaffRoleID INT PRIMARY KEY,
    StaffID INT, 
    RoleID INT, 
    CONSTRAINT fk_StaffStaffRole FOREIGN KEY (StaffID) REFERENCES Staff(StaffID),
    CONSTRAINT fk_RoleStaffRole FOREIGN KEY (RoleID) REFERENCES Roles(RoleID)
);