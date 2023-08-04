create table Infy_Amenities (
	amenitiesId INTEGER not null primary key,
	isACAvailable BOOLEAN,
	isSmokingAvailable BOOLEAN,
	isWifiAvailable BOOLEAN,
	isTVAvailable BOOLEAN,
	isGeyserAvailable BOOLEAN
);

create table Infy_BookingDetails (
	bookingDetailsId LONG not null primary key,
	roomId INTEGER,
	customerId INTEGER,
	createDate DATE null,
	createBy VARCHAR(75) null,
	updateDate DATE null,
	updatedBy VARCHAR(75) null,
	totalRoomsBooked INTEGER,
	bookingStartDate DATE null,
	bookingEndDate DATE null
);

create table Infy_Customer (
	customerId INTEGER not null primary key,
	firstName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	email VARCHAR(75) null,
	mobile VARCHAR(75) null,
	age INTEGER,
	description VARCHAR(75) null
);

create table Infy_RoomType (
	roomTypeId INTEGER not null,
	RoomType VARCHAR(75) not null,
	primary key (roomTypeId, RoomType)
);

create table Infy_Rooms (
	roomId INTEGER not null primary key,
	roomTypeId INTEGER,
	amenitiesId INTEGER,
	roomName VARCHAR(75) null,
	totalRoomsAvailable INTEGER,
	createDate DATE null,
	createBy VARCHAR(75) null,
	updateDate DATE null,
	updatedBy VARCHAR(75) null
);