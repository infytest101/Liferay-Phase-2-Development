create index IX_981DB9F7 on Infy_Amenities (isACAvailable);
create index IX_6924D7F4 on Infy_Amenities (isGeyserAvailable);
create index IX_6B6468D1 on Infy_Amenities (isSmokingAvailable);
create index IX_DE067B97 on Infy_Amenities (isTVAvailable);
create index IX_5B38D84 on Infy_Amenities (isWifiAvailable);

create index IX_B46591CF on Infy_RoomType (RoomType[$COLUMN_LENGTH:75$], roomTypeId);

create index IX_8AB722F1 on Infy_Rooms (roomName[$COLUMN_LENGTH:75$]);