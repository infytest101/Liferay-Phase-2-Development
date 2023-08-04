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

package ROOMSERVICES.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Rooms}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Rooms
 * @generated
 */
public class RoomsWrapper
	extends BaseModelWrapper<Rooms> implements ModelWrapper<Rooms>, Rooms {

	public RoomsWrapper(Rooms rooms) {
		super(rooms);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("roomId", getRoomId());
		attributes.put("roomTypeId", getRoomTypeId());
		attributes.put("amenitiesId", getAmenitiesId());
		attributes.put("roomName", getRoomName());
		attributes.put("totalRoomsAvailable", getTotalRoomsAvailable());
		attributes.put("createDate", getCreateDate());
		attributes.put("createBy", getCreateBy());
		attributes.put("updateDate", getUpdateDate());
		attributes.put("updatedBy", getUpdatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer roomId = (Integer)attributes.get("roomId");

		if (roomId != null) {
			setRoomId(roomId);
		}

		Integer roomTypeId = (Integer)attributes.get("roomTypeId");

		if (roomTypeId != null) {
			setRoomTypeId(roomTypeId);
		}

		Integer amenitiesId = (Integer)attributes.get("amenitiesId");

		if (amenitiesId != null) {
			setAmenitiesId(amenitiesId);
		}

		String roomName = (String)attributes.get("roomName");

		if (roomName != null) {
			setRoomName(roomName);
		}

		Integer totalRoomsAvailable = (Integer)attributes.get(
			"totalRoomsAvailable");

		if (totalRoomsAvailable != null) {
			setTotalRoomsAvailable(totalRoomsAvailable);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String createBy = (String)attributes.get("createBy");

		if (createBy != null) {
			setCreateBy(createBy);
		}

		Date updateDate = (Date)attributes.get("updateDate");

		if (updateDate != null) {
			setUpdateDate(updateDate);
		}

		String updatedBy = (String)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}
	}

	/**
	 * Returns the amenities ID of this rooms.
	 *
	 * @return the amenities ID of this rooms
	 */
	@Override
	public int getAmenitiesId() {
		return model.getAmenitiesId();
	}

	/**
	 * Returns the create by of this rooms.
	 *
	 * @return the create by of this rooms
	 */
	@Override
	public String getCreateBy() {
		return model.getCreateBy();
	}

	/**
	 * Returns the create date of this rooms.
	 *
	 * @return the create date of this rooms
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the primary key of this rooms.
	 *
	 * @return the primary key of this rooms
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the room ID of this rooms.
	 *
	 * @return the room ID of this rooms
	 */
	@Override
	public int getRoomId() {
		return model.getRoomId();
	}

	/**
	 * Returns the room name of this rooms.
	 *
	 * @return the room name of this rooms
	 */
	@Override
	public String getRoomName() {
		return model.getRoomName();
	}

	/**
	 * Returns the room type ID of this rooms.
	 *
	 * @return the room type ID of this rooms
	 */
	@Override
	public int getRoomTypeId() {
		return model.getRoomTypeId();
	}

	/**
	 * Returns the total rooms available of this rooms.
	 *
	 * @return the total rooms available of this rooms
	 */
	@Override
	public int getTotalRoomsAvailable() {
		return model.getTotalRoomsAvailable();
	}

	/**
	 * Returns the update date of this rooms.
	 *
	 * @return the update date of this rooms
	 */
	@Override
	public Date getUpdateDate() {
		return model.getUpdateDate();
	}

	/**
	 * Returns the updated by of this rooms.
	 *
	 * @return the updated by of this rooms
	 */
	@Override
	public String getUpdatedBy() {
		return model.getUpdatedBy();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the amenities ID of this rooms.
	 *
	 * @param amenitiesId the amenities ID of this rooms
	 */
	@Override
	public void setAmenitiesId(int amenitiesId) {
		model.setAmenitiesId(amenitiesId);
	}

	/**
	 * Sets the create by of this rooms.
	 *
	 * @param createBy the create by of this rooms
	 */
	@Override
	public void setCreateBy(String createBy) {
		model.setCreateBy(createBy);
	}

	/**
	 * Sets the create date of this rooms.
	 *
	 * @param createDate the create date of this rooms
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the primary key of this rooms.
	 *
	 * @param primaryKey the primary key of this rooms
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the room ID of this rooms.
	 *
	 * @param roomId the room ID of this rooms
	 */
	@Override
	public void setRoomId(int roomId) {
		model.setRoomId(roomId);
	}

	/**
	 * Sets the room name of this rooms.
	 *
	 * @param roomName the room name of this rooms
	 */
	@Override
	public void setRoomName(String roomName) {
		model.setRoomName(roomName);
	}

	/**
	 * Sets the room type ID of this rooms.
	 *
	 * @param roomTypeId the room type ID of this rooms
	 */
	@Override
	public void setRoomTypeId(int roomTypeId) {
		model.setRoomTypeId(roomTypeId);
	}

	/**
	 * Sets the total rooms available of this rooms.
	 *
	 * @param totalRoomsAvailable the total rooms available of this rooms
	 */
	@Override
	public void setTotalRoomsAvailable(int totalRoomsAvailable) {
		model.setTotalRoomsAvailable(totalRoomsAvailable);
	}

	/**
	 * Sets the update date of this rooms.
	 *
	 * @param updateDate the update date of this rooms
	 */
	@Override
	public void setUpdateDate(Date updateDate) {
		model.setUpdateDate(updateDate);
	}

	/**
	 * Sets the updated by of this rooms.
	 *
	 * @param updatedBy the updated by of this rooms
	 */
	@Override
	public void setUpdatedBy(String updatedBy) {
		model.setUpdatedBy(updatedBy);
	}

	@Override
	protected RoomsWrapper wrap(Rooms rooms) {
		return new RoomsWrapper(rooms);
	}

}