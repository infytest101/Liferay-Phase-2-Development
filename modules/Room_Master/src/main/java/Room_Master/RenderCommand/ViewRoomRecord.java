package Room_Master.RenderCommand;

import java.util.List;
import java.util.stream.Collectors;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import ROOMSERVICES.model.Amenities;
import ROOMSERVICES.model.RoomType;
import ROOMSERVICES.model.Rooms;
import ROOMSERVICES.service.AmenitiesLocalServiceUtil;
import ROOMSERVICES.service.RoomTypeLocalServiceUtil;
import ROOMSERVICES.service.RoomsLocalServiceUtil;
import Room_Master.ViewDto.RoomPriceTypeDto;
import Room_Master.portlet.Room_MasterPortlet;

public class ViewRoomRecord {
	private static final Log LOGGER = LogFactoryUtil.getLog(ViewRoomRecord.class);
	public List<RoomPriceTypeDto> fetchAllRoom() {
		try {

			List<Rooms> roomData = RoomsLocalServiceUtil.getRoomses(-1, -1);
			List<RoomPriceTypeDto> dataValue = roomData.stream().map(data -> {
				Amenities amenities=AmenitiesLocalServiceUtil.fetchAmenities(data.getAmenitiesId());
				RoomType roomtype = null;
				try {
					roomtype = RoomTypeLocalServiceUtil.getRoomType(data.getRoomTypeId());
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
				RoomPriceTypeDto rpto = new RoomPriceTypeDto();
				/* String rooname1="\"" + rpto.getRoomName() + "\""; */
				rpto.setId(data.getRoomId());
				rpto.setTotalRoomAvaliable(data.getTotalRoomsAvailable());
				rpto.setRoomName("\"" + data.getRoomName() + "\"");
				rpto.setIsACAvailable(amenities.getIsACAvailable());
				rpto.setIsSmokingAvailable(amenities.getIsSmokingAvailable());
				rpto.setGeyserAvailable(amenities.getIsGeyserAvailable());
				rpto.setWifiAvailable(amenities.getIsWifiAvailable());
				rpto.setTVAvailable(amenities.getIsTVAvailable());
				rpto.setPrice(data.getPrice()); // BookingDetails
				rpto.setRoomtypedata(roomtype.getRoomType());
				//rpto.setTotalRoomBooked(data.getBookingDetails().getTotalRoomsBooked());
				return rpto;
			}).collect(Collectors.toList());
			LOGGER.info(" RoomsServiceImpl :fetchAllRoomData:  Rooms Table PRICE  ID  RoomType Data::"
					+ dataValue.toString());
			return dataValue;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
