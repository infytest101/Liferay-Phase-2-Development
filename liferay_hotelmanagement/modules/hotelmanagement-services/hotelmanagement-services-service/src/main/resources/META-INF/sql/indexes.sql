create index IX_A05C2BBB on Hotel_Amenities (isACAvailable);
create index IX_658CC7B8 on Hotel_Amenities (isGeyserAvailable);
create index IX_FBFA718D on Hotel_Amenities (isSmokingAvailable);
create index IX_E644ED5B on Hotel_Amenities (isTVAvailable);
create index IX_EED8D485 on Hotel_Amenities (isWifiAvailable, isTVAvailable, isGeyserAvailable);

create index IX_FD1D79EF on Hotel_RoomType (RoomType[$COLUMN_LENGTH:75$]);

create index IX_52D0E4AD on Hotel_Rooms (roomName[$COLUMN_LENGTH:75$]);