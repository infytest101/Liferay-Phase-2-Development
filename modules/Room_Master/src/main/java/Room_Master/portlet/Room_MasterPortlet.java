package Room_Master.portlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import ROOMSERVICES.model.Amenities;
import ROOMSERVICES.model.RoomType;
import ROOMSERVICES.model.Rooms;
import ROOMSERVICES.service.AmenitiesLocalServiceUtil;
import ROOMSERVICES.service.RoomTypeLocalServiceUtil;
import ROOMSERVICES.service.RoomsLocalServiceUtil;
import Room_Master.RenderCommand.ViewRoomRecord;
import Room_Master.ViewDto.RoomPriceTypeDto;
import Room_Master.constants.Room_MasterPortletKeys;

/**
 * @author biswajit.nayak01
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Room_Master", "javax.portlet.init-param.template-path=/",
		/* "javax.portlet.init-param.view-template=/view.jsp", */
		"javax.portlet.name=" + Room_MasterPortletKeys.ROOM_MASTER, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class Room_MasterPortlet extends MVCPortlet {

	private static final Log LOGGER = LogFactoryUtil.getLog(Room_MasterPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		String page = renderRequest.getParameter("page");
		LOGGER.info("inside doView method..!!:");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String currentURL = themeDisplay.getURLCurrent();
		LOGGER.info("currentURL :: " + currentURL);

		String viewName = StringPool.BLANK;

		List<Rooms> rooms = RoomsLocalServiceUtil.getRoomses(-1, -1);
		if (Validator.isNotNull(rooms)) {
			LOGGER.info("rooms size :: " + rooms.size());
		} else {
			LOGGER.info("rooms size :: 0 or Empty.!");
		}

		if (Validator.isNotNull(currentURL)) {

			if (currentURL.contains("/add-update-room")) {

				// TODO :: Call or set attribute w.r.t. add/update room
				
				viewName = setAddUpdateRoomAttributes(renderRequest);

			} else if (currentURL.contains("/hotel-mngt-home")) {

				// TODO :: Call or set attribute w.r.t. listing page
				viewName = setHomeListingAttributes(renderRequest);

			}

		} else {

			// TODO :: Call or set attribute w.r.t. listing page
			viewName = setHomeListingAttributes(renderRequest);

		}

		include(viewName, renderRequest, renderResponse);

		super.doView(renderRequest, renderResponse);
	}

	private String setAddUpdateRoomAttributes(RenderRequest renderRequest) {

		LOGGER.info("inside setAddUpdateRoomAttributes method..!!:");
		renderRequest.setAttribute("roomid", "1");

		return "/META-INF/resources/rooms/addUpdateRoom.jsp";

	}

	private String setHomeListingAttributes(RenderRequest renderRequest) {
		ViewRoomRecord viewRecord= new ViewRoomRecord();
		List<RoomPriceTypeDto>rmdto=viewRecord.fetchAllRoom();
		LOGGER.info("RoomPriceTypeDto RoomPriceTypeDto::"+rmdto);
		renderRequest.setAttribute("RoomPriceTypeDto", rmdto);
		LOGGER.info("inside setHomeListingAttributes method..!!:");
		return "/META-INF/resources/rooms/roomListing.jsp";

	}

	/**
	 *
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortletException
	 * @throws IOException
	 * @throws PortalException
	 * 
	 */
	@ProcessAction(name = "addRoomData")
	public void addRoomData(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortalException {

		LOGGER.info("inside addRoomData method..!!:");
		
		final String roomName = ParamUtil.getString(actionRequest, "roomName");
		final String roomTypeData = ParamUtil.getString(actionRequest, "roomtypedata");
		final long roomid = ParamUtil.getLong(actionRequest, "roomid");
		final String roomType = ParamUtil.getString(actionRequest, "roomtype");
		String price = ParamUtil.getString(actionRequest, "price");
		final String totalRoomAvailable = ParamUtil.getString(actionRequest, "totalRoomAvaliable");
		final String totalRoomBooked = ParamUtil.getString(actionRequest, "totalRoomBooked");
		final boolean acNonAc = ParamUtil.getBoolean(actionRequest, "isACRoom");
		final boolean smokNonSmok = ParamUtil.getBoolean(actionRequest, "SmokingAvailable");
		String[] checkValues = ParamUtil.getParameterValues(actionRequest,"checkdata");
		
		LOGGER.info("roomName ::= " + roomName + "::roomType ::= " + roomTypeData + "::roomid :: " + roomid
				+ "::price :: " + price + ":: totalRoomAvailable :: " + totalRoomAvailable + ":: totalRoomBooked"
				+ totalRoomBooked + ":: acnonac :: " + acNonAc + ":: smoknonsmok :: " + smokNonSmok+" :: checkdata::= "+checkValues.length);
		
		boolean isWifiAvailable=false;
		boolean isTVAvailable=false;
		boolean isGeyserAvailable=false;
		
		if (Validator.isNotNull(checkValues)) {
	        for (String value : checkValues) {
	        	LOGGER.info("inside for loop for value ::::"+value);
	        	if(value.contains("WIFI")) {
	        		isWifiAvailable=true;
	        	}
	        	if(value.contains("TV")) {
	        		isTVAvailable=true;
	        	}
	        	if(value.contains("Geyser")) {
	        		isGeyserAvailable=true;
	        	}
	        }
	    }
		
		LOGGER.info("isGeyserAvailable="+isGeyserAvailable+"isTVAvailable:"+isTVAvailable+"isWifiAvailable"+isWifiAvailable);
		
		
		final Rooms room;
		final long roomId;
		final long amenitiesId;
		final Amenities amenities ;
		
		
		if(roomid>0) {
			 room = RoomsLocalServiceUtil.getRooms(roomid);
			 amenitiesId= room.getAmenitiesId();
			 amenities = AmenitiesLocalServiceUtil.getAmenities(amenitiesId);
		}
		else {
			 roomId = CounterLocalServiceUtil.increment(Rooms.class.getName());
			 amenitiesId = CounterLocalServiceUtil.increment(Amenities.class.getName());
			 room = RoomsLocalServiceUtil.createRooms(roomId);
			 amenities =  AmenitiesLocalServiceUtil.createAmenities(amenitiesId);
		}
		
		List<RoomType> roomTypeObj=RoomTypeLocalServiceUtil.findByroomType(roomType);
		
		room.setAmenitiesId((int) amenitiesId);
		room.setCreateBy("Biswajit");
		room.setCreateDate(new Date());
		room.setPrice(Integer.parseInt(price));
		room.setRoomName(roomName);
		room.setRoomTypeId((int)roomTypeObj.get(0).getRoomTypeId());
		room.setTotalRoomsAvailable(Integer.parseInt(totalRoomAvailable));
		room.setUpdateDate(null);
		room.setUpdatedBy(null);
		
		RoomsLocalServiceUtil.updateRooms(room);
		
		
		amenities.setIsACAvailable(acNonAc);
		amenities.setIsSmokingAvailable(smokNonSmok);
		amenities.setIsTVAvailable(isTVAvailable);
		amenities.setIsGeyserAvailable(isGeyserAvailable);
		amenities.setIsWifiAvailable(isWifiAvailable);
		
		AmenitiesLocalServiceUtil.updateAmenities(amenities);

	}

	public static Map<String, String> extractParameters(String input) {
		Map<String, String> paramMap = new HashMap<>();
		String[] params = input.split("&");

		try {
			for (String param : params) {
				String[] keyValue = param.split("=");
				String key = keyValue[0];
				String value = keyValue.length > 1 ? URLDecoder.decode(keyValue[1], "UTF-8") : "";
				paramMap.put(key, value);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return paramMap;
	}
}
