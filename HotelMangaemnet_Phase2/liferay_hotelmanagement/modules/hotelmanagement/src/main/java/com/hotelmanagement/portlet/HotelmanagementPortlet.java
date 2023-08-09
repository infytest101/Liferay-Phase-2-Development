package com.hotelmanagement.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.hotelmanagement.constants.HotelmanagementPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.Validator;

import hotelmanagement.services.model.Amenities;
import hotelmanagement.services.model.RoomType;
import hotelmanagement.services.model.Rooms;
import hotelmanagement.services.service.AmenitiesLocalServiceUtil;
import hotelmanagement.services.service.RoomTypeLocalServiceUtil;
import hotelmanagement.services.service.RoomsLocalServiceUtil;

/**
 * @author nayana.m05
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.Hotel",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Hotelmanagement",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + HotelmanagementPortletKeys.HOTELMANAGEMENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class HotelmanagementPortlet extends MVCPortlet {

	private static final Log _LOG = LogFactoryUtil.getLog(HotelmanagementPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		_LOG.info("inside doView method.!");

		List<RoomType> roomTypes = RoomTypeLocalServiceUtil.getRoomTypes(-1, -1);
		renderRequest.setAttribute("roomTypeNames", roomTypes);
		
		Map<Integer, String> roomTypeMap = new HashMap<Integer, String>();
		if (Validator.isNotNull(roomTypes) && roomTypes.size() > 0) {
			for (RoomType roomType : roomTypes) {
				roomTypeMap.put(roomType.getRoomTypeId(), roomType.getRoomType());
			}
		} else {
			_LOG.info("RoomTypes is blank or Empty.");
		}

		List<String> roomDetails = new ArrayList<String>();
		List<Rooms> rooms = RoomsLocalServiceUtil.getRoomses(-1, -1);
		if (Validator.isNotNull(rooms) && rooms.size() > 0) {
			
			for (Rooms room : rooms) {
				
				Map<String, Object> roomData = new HashMap<String, Object>();
				
				int roomTypeId = room.getRoomTypeId();
				int amenitiesId = room.getAmenitiesId();
				
				roomData.put("roomName", room.getRoomName());
				roomData.put("price", room.getPrice());
				roomData.put("roomId",  room.getRoomId());
				roomData.put("roomTypeId",  roomTypeId);
				roomData.put("amenitiesId", amenitiesId);
				roomData.put("totalRoomsAvailable", room.getTotalRoomsAvailable());
				roomData.put("createBy", room.getCreateBy());
				roomData.put("updatedBy", room.getUpdatedBy());
				roomData.put("createDate", room.getCreateDate());
				roomData.put("updateDate", room.getUpdateDate());
				
				if (roomTypeMap.containsKey(roomTypeId)) {
					roomData.put("roomType", roomTypeMap.get(roomTypeId));
				} else {
					_LOG.info("roomTypeMap doesn't contain Key: " + roomTypeMap);
					roomData.put("roomType", "Not Available");
				}
				Amenities amenities = AmenitiesLocalServiceUtil.fetchAmenities(amenitiesId);
				
				if (Validator.isNotNull(amenities)) {
					roomData.put("isACAvailable", amenities.getIsACAvailable());
					roomData.put("isSmokingAvailable", amenities.getIsSmokingAvailable());
					roomData.put("isWifiAvailable", amenities.getIsWifiAvailable());
					roomData.put("isTVAvailable", amenities.getIsTVAvailable());
					roomData.put("isGeyserAvailable", amenities.getIsGeyserAvailable());
				} else {
					_LOG.info("Unable to find Amenities with amenitiesId : " + amenitiesId);
					roomData.put("isACAvailable", Boolean.FALSE);
					roomData.put("isSmokingAvailable", Boolean.FALSE);
					roomData.put("isWifiAvailable", Boolean.FALSE);
					roomData.put("isTVAvailable", Boolean.FALSE);
					roomData.put("isGeyserAvailable", Boolean.FALSE);
				}
				
//				try {
//					Amenities amenities = AmenitiesLocalServiceUtil.getAmenities(amenitiesId);
//					
//					roomData.put("isACAvailable", amenities.getIsACAvailable());
//					roomData.put("isSmokingAvailable", amenities.getIsSmokingAvailable());
//					roomData.put("isWifiAvailable", amenities.getIsWifiAvailable());
//					roomData.put("isTVAvailable", amenities.getIsTVAvailable());
//					roomData.put("isGeyserAvailable", amenities.getIsGeyserAvailable());
//
//				} catch (PortalException e) {
//					_LOG.error("PortalException occurred while fetching Amenities: " + e.getMessage());
//				}
				
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
				jsonArray.put(roomData);
				String jsonString = jsonArray.toString();
				roomDetails.add(jsonString);
			}
		} else {
			_LOG.info("Rooms is blank or Empty.");
		}
		renderRequest.setAttribute("roomDetails", roomDetails);
		
		_LOG.info("exiting doViewmethod getrooms.!");
        
		super.doView(renderRequest, renderResponse);
        
	}
	
	
}