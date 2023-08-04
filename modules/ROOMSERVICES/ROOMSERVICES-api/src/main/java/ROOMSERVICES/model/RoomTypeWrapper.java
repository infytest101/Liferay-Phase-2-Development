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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RoomType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomType
 * @generated
 */
public class RoomTypeWrapper
	extends BaseModelWrapper<RoomType>
	implements ModelWrapper<RoomType>, RoomType {

	public RoomTypeWrapper(RoomType roomType) {
		super(roomType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("roomTypeId", getRoomTypeId());
		attributes.put("RoomType", getRoomType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer roomTypeId = (Integer)attributes.get("roomTypeId");

		if (roomTypeId != null) {
			setRoomTypeId(roomTypeId);
		}

		String RoomType = (String)attributes.get("RoomType");

		if (RoomType != null) {
			setRoomType(RoomType);
		}
	}

	/**
	 * Returns the primary key of this room type.
	 *
	 * @return the primary key of this room type
	 */
	@Override
	public ROOMSERVICES.service.persistence.RoomTypePK getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the room type of this room type.
	 *
	 * @return the room type of this room type
	 */
	@Override
	public String getRoomType() {
		return model.getRoomType();
	}

	/**
	 * Returns the room type ID of this room type.
	 *
	 * @return the room type ID of this room type
	 */
	@Override
	public int getRoomTypeId() {
		return model.getRoomTypeId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this room type.
	 *
	 * @param primaryKey the primary key of this room type
	 */
	@Override
	public void setPrimaryKey(
		ROOMSERVICES.service.persistence.RoomTypePK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the room type of this room type.
	 *
	 * @param RoomType the room type of this room type
	 */
	@Override
	public void setRoomType(String RoomType) {
		model.setRoomType(RoomType);
	}

	/**
	 * Sets the room type ID of this room type.
	 *
	 * @param roomTypeId the room type ID of this room type
	 */
	@Override
	public void setRoomTypeId(int roomTypeId) {
		model.setRoomTypeId(roomTypeId);
	}

	@Override
	protected RoomTypeWrapper wrap(RoomType roomType) {
		return new RoomTypeWrapper(roomType);
	}

}