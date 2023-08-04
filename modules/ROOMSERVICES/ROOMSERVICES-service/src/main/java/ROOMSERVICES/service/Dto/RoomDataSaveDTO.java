package ROOMSERVICES.service.Dto;
public class RoomDataSaveDTO {
	private int roomid;
	private String roomType;
	private int price;
	private boolean isACAvailable;
	private boolean isSmokingAvailable;
	private int totalRoomAvaliable;
	private int totalRoomBooked;
	
	public int getRoomid() {
		return roomid;
	}
	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}
	public RoomDataSaveDTO() {
		super();
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	@Override
	public String toString() {
		return "RoomDataSaveDTO [roomid=" + roomid + ", roomType=" + roomType + ", price=" + price + ", isACAvailable="
				+ isACAvailable + ", isSmokingAvailable=" + isSmokingAvailable + ", totalRoomAvaliable="
				+ totalRoomAvaliable + ", totalRoomBooked=" + totalRoomBooked + "]";
	}
}
