package com.hotelmanagement.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.hotelmanagement.constants.HotelmanagementPortletKeys;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

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
//		"javax.portlet.init-param.view-template=/view.jsp",
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
				
				getRoomData(roomTypeMap, roomDetails, room);
			}
		} else {
			_LOG.info("Rooms is blank or Empty.");
		}
		renderRequest.setAttribute("roomDetails", roomDetails);
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String currentURL = themeDisplay.getURLCurrent();
		_LOG.info("currentURL ::: " + currentURL);
		
		String navigate= StringPool.BLANK;
		
		if(currentURL.contains("/hotel-homepage")) {
			navigate = "/META-INF/resources/view.jsp";
			include(navigate, renderRequest, renderResponse);
		}
		
		if(currentURL.contains("/add-or-update-room?roomId")) {
//			Integer roomId= Integer.valueOf(currentURL.split("=")[1]);
//			_LOG.info("roomId ::: " + roomId);
			
			final HttpServletRequest httpServletRequest = PortalUtil
					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			final int roomId = GetterUtil.getInteger(httpServletRequest.getParameter("roomId"), -1);
			
			if(roomId!=-1) {
				
			Rooms room = RoomsLocalServiceUtil.fetchRooms(roomId);
			Amenities amenities = AmenitiesLocalServiceUtil.fetchAmenities(room.getAmenitiesId());
			RoomType roomType = RoomTypeLocalServiceUtil.fetchRoomType(room.getRoomTypeId());
			
			renderRequest.setAttribute("room", room);
			renderRequest.setAttribute("amenities", amenities);
			renderRequest.setAttribute("roomType", roomType);
			
			}
			navigate = "/META-INF/resources/editRoom.jsp";
			
			include(navigate, renderRequest, renderResponse);
		}
		
		
		_LOG.info("exiting doViewmethod getrooms.!");
		
		super.doView(renderRequest, renderResponse);
        
	}

	private void getRoomData(Map<Integer, String> roomTypeMap, List<String> roomDetails, Rooms room) {
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
	
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String action = ParamUtil.getString(actionRequest, "action");

		if ("submitForm".equals(action)) {
			String price = ParamUtil.getString(actionRequest, "price");
			String roomType = ParamUtil.getString(actionRequest, "roomType");
			Boolean isACAvailable = ParamUtil.getBoolean(actionRequest, "isACAvailable");
			Boolean isNonACAvailable = ParamUtil.getBoolean(actionRequest, "isNonACAvailable");
			String errorMessagePrice = StringPool.BLANK;
			String errorMessageRoomType = StringPool.BLANK;
			String errorMessageAC = StringPool.BLANK;
			
			if(price.isEmpty()) {
				errorMessagePrice = "Please enter the price.";
			}
            if(roomType.isEmpty()) {
				errorMessageRoomType = "Please enter the room type.";
			}
            if(!isACAvailable || !isNonACAvailable) {
            	errorMessageAC = "Please select atleast AC or Non AC";
            }
            actionRequest.setAttribute("errorMessagePrice", errorMessagePrice);
            actionRequest.setAttribute("errorMessageRoomType", errorMessageRoomType);
            actionRequest.setAttribute("errorMessageAC", errorMessageAC);
            
            final HttpServletRequest httpServletRequest = PortalUtil
					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
			final int roomId = GetterUtil.getInteger(httpServletRequest.getParameter("roomId"), -1);
			
			if(roomId!=-1) {
				
			Rooms room = RoomsLocalServiceUtil.fetchRooms(roomId);
			Amenities amenities = AmenitiesLocalServiceUtil.fetchAmenities(room.getAmenitiesId());
			RoomType roomTypes = RoomTypeLocalServiceUtil.fetchRoomType(room.getRoomTypeId());
			room.setPrice(Integer.valueOf(price));
			roomTypes.setRoomType(roomType);
			
			actionRequest.setAttribute("room", room);
			actionRequest.setAttribute("amenities", amenities);
			actionRequest.setAttribute("roomType", roomTypes);
			
			}
			include("/META-INF/resources/editRoom.jsp", actionRequest, actionResponse);
			return;
            
		}

		super.processAction(actionRequest, actionResponse);
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String action = ParamUtil.getString(renderRequest, "action");

		if ("submitForm".equals(action)) {
			String price = ParamUtil.getString(renderRequest, "price");
			String roomTypes = ParamUtil.getString(renderRequest, "roomType");
			Boolean isACAvailable = ParamUtil.getBoolean(renderRequest, "isACAvailable");
			Boolean isNonACAvailable = ParamUtil.getBoolean(renderRequest, "isNonACAvailable");

			renderRequest.setAttribute("price", price);
			renderRequest.setAttribute("roomType", roomTypes);
			final HttpServletRequest httpServletRequest = PortalUtil
					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			final int roomId = GetterUtil.getInteger(httpServletRequest.getParameter("roomId"), -1);
			
			if(roomId!=-1) {
				
			Rooms room = RoomsLocalServiceUtil.fetchRooms(roomId);
			Amenities amenities = AmenitiesLocalServiceUtil.fetchAmenities(room.getAmenitiesId());
			RoomType roomType = RoomTypeLocalServiceUtil.fetchRoomType(room.getRoomTypeId());
			room.setPrice(Integer.valueOf(price));
			roomType.setRoomType(roomTypes);
			
			renderRequest.setAttribute("room", room);
			renderRequest.setAttribute("amenities", amenities);
			renderRequest.setAttribute("roomType", roomType);
			
			}
			include("/META-INF/resources/editRoom.jsp", renderRequest, renderResponse);
			return;
		}

		super.render(renderRequest, renderResponse);
	}

}