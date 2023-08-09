package Room_Master.ViewDto;
public class RoomPriceTypeDto {
	private int price;
	private long id;
	private  String  roomtypedata;
	private boolean isACAvailable;
	private boolean isSmokingAvailable;
	private String fromDate;
	private String toDate;
	private int totalRoomAvaliable;
	private int totalRoomBooked;
	private String roomName;
	private boolean isWifiAvailable;
	private boolean isTVAvailable;
	private boolean isGeyserAvailable;
	private String createdDate;
	private String createdBy;
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public boolean isWifiAvailable() {
		return isWifiAvailable;
	}
	public void setWifiAvailable(boolean isWifiAvailable) {
		this.isWifiAvailable = isWifiAvailable;
	}
	public boolean isTVAvailable() {
		return isTVAvailable;
	}
	public void setTVAvailable(boolean isTVAvailable) {
		this.isTVAvailable = isTVAvailable;
	}
	public boolean isGeyserAvailable() {
		return isGeyserAvailable;
	}
	public void setGeyserAvailable(boolean isGeyserAvailable) {
		this.isGeyserAvailable = isGeyserAvailable;
	}
	public void setACAvailable(boolean isACAvailable) {
		this.isACAvailable = isACAvailable;
	}
	public void setSmokingAvailable(boolean isSmokingAvailable) {
		this.isSmokingAvailable = isSmokingAvailable;
	}

	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getTotalRoomAvaliable() {
		return totalRoomAvaliable;
	}
	public void setTotalRoomAvaliable(int totalRoomAvaliable) {
		this.totalRoomAvaliable = totalRoomAvaliable;
	}
	public int getTotalRoomBooked() {
		return totalRoomBooked;
	}
	public void setTotalRoomBooked(int totalRoomBooked) {
		this.totalRoomBooked = totalRoomBooked;
	}
	
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public boolean getIsACAvailable() {
		return isACAvailable;
	}
	public void setIsACAvailable(boolean isACAvailable) {
		this.isACAvailable = isACAvailable;
	}
	public boolean getIsSmokingAvailable() {
		return isSmokingAvailable;
	}
	public void setIsSmokingAvailable(boolean isSmokingAvailable) {
		this.isSmokingAvailable = isSmokingAvailable;
	}
	public String getRoomtypedata() {
		return roomtypedata;
	}
	public void setRoomtypedata(String roomtypedata) {
		this.roomtypedata = roomtypedata;
	}
	@Override
	public String toString() {
		return "RoomPriceTypeDto [price=" + price + ", id=" + id + ", roomtypedata=" + roomtypedata + ", isACAvailable="
				+ isACAvailable + ", isSmokingAvailable=" + isSmokingAvailable + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", totalRoomAvaliable=" + totalRoomAvaliable + ", totalRoomBooked=" + totalRoomBooked
				+ ", roomName=" + roomName + ", isWifiAvailable=" + isWifiAvailable + ", isTVAvailable=" + isTVAvailable
				+ ", isGeyserAvailable=" + isGeyserAvailable + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + "]";
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
