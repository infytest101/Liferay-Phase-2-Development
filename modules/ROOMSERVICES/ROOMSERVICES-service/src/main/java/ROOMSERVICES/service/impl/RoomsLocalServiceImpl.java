/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package ROOMSERVICES.service.impl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import ROOMSERVICES.model.Amenities;
import ROOMSERVICES.model.RoomType;
import ROOMSERVICES.model.Rooms;
import ROOMSERVICES.service.AmenitiesLocalServiceUtil;
import ROOMSERVICES.service.RoomTypeLocalServiceUtil;
import ROOMSERVICES.service.RoomsLocalServiceUtil;
import ROOMSERVICES.service.Dto.RoomDataSaveDTO;
import ROOMSERVICES.service.base.RoomsLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=ROOMSERVICES.model.Rooms", service = AopService.class)
public class RoomsLocalServiceImpl extends RoomsLocalServiceBaseImpl {
	private static final Log logger = LogFactoryUtil.getLog(RoomsLocalServiceImpl.class);
	
	boolean wifi = false;
	boolean TV = false;
	boolean gyser = false;
	boolean isWIFIAvailable = false;
	boolean isTVAvailable = false;
	boolean isGeyserAvailable = false;
	public String addRoomDetails(String amenitiesjsonData, String formData) {
logger.info("RoomsLocalServiceImpl::addRoomDetails::Started::");
		  ObjectMapper mapper = new ObjectMapper();
		  
		try {
			int amenitiesId=(int) CounterLocalServiceUtil.increment();
			int roomId=(int) CounterLocalServiceUtil.increment();
			RoomDataSaveDTO rm = mapper.readValue(formData, RoomDataSaveDTO.class);
			List<RoomType> roomtype=RoomTypeLocalServiceUtil.findByroomType(rm.getRoomType());
			int roomTypeId=roomtype.get(0).getRoomTypeId();
			logger.info("amenitiesjsonData::::" + amenitiesjsonData);
			try {
				JSONObject josnobj = JSONFactoryUtil.createJSONObject(amenitiesjsonData);
				logger.info("amenitiesjsonData json object value:::"+josnobj);
				//String ac1 = rm.getIsACAvailable();
				//String smok1 = rm.getIsSmokingAvailable();

				/*
				 * if (josnobj.has("WIFI")) { wifi = true; } if (josnobj.has("TV")) { TV = true;
				 * } if (josnobj.has("Geyser")) { gyser = true; }
				 */
				  if (josnobj.has("isWIFIAvailable")) {
		                 isWIFIAvailable = josnobj.getBoolean("isWIFIAvailable");	               
		            }

		            if (josnobj.has("isTVAvailable")) {
		                 isTVAvailable = josnobj.getBoolean("isTVAvailable");
		            }

		            if (josnobj.has("isGeyserAvailable")) {
		                 isGeyserAvailable = josnobj.getBoolean("isGeyserAvailable");
		            }
				logger.info("wifi: " + wifi + "TV: " + TV + "GYSER: " + gyser );
				Amenities amenities=AmenitiesLocalServiceUtil.createAmenities(amenitiesId);
				amenities.setAmenitiesId(amenitiesId);
				amenities.setIsACAvailable(rm.getIsACAvailable());
				amenities.setIsSmokingAvailable(rm.getIsSmokingAvailable());
				amenities.setIsGeyserAvailable(isGeyserAvailable);
				amenities.setIsWifiAvailable(isWIFIAvailable);
				amenities.setIsTVAvailable(isTVAvailable);
				logger.info("before data updating:::: ");
				AmenitiesLocalServiceUtil.updateAmenities(amenities);
				logger.info("after record data updating:::: ");
			} catch (JSONException e) {
				e.printStackTrace();
			}	
 Rooms room=RoomsLocalServiceUtil.createRooms(roomId);
room.setAmenitiesId(amenitiesId);
room.setCreateDate(new Date());
room.setTotalRoomsAvailable(rm.getTotalRoomAvaliable());
room.setCreateBy("Biswajit Nayak");
room.setRoomId(roomId);
room.setRoomTypeId(roomTypeId);
room.setRoomName("Superior AC");
Rooms room1=RoomsLocalServiceUtil.updateRooms(room);
logger.info("room1 room1 room1 room1 room1:::"+room1);

		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}	  
		return "ADDROOM";
	}

}