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

import ROOMSERVICES.service.persistence.RoomTypePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class RoomTypeSoap implements Serializable {

	public static RoomTypeSoap toSoapModel(RoomType model) {
		RoomTypeSoap soapModel = new RoomTypeSoap();

		soapModel.setRoomTypeId(model.getRoomTypeId());
		soapModel.setRoomType(model.getRoomType());

		return soapModel;
	}

	public static RoomTypeSoap[] toSoapModels(RoomType[] models) {
		RoomTypeSoap[] soapModels = new RoomTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RoomTypeSoap[][] toSoapModels(RoomType[][] models) {
		RoomTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RoomTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RoomTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RoomTypeSoap[] toSoapModels(List<RoomType> models) {
		List<RoomTypeSoap> soapModels = new ArrayList<RoomTypeSoap>(
			models.size());

		for (RoomType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RoomTypeSoap[soapModels.size()]);
	}

	public RoomTypeSoap() {
	}

	public RoomTypePK getPrimaryKey() {
		return new RoomTypePK(_roomTypeId, _RoomType);
	}

	public void setPrimaryKey(RoomTypePK pk) {
		setRoomTypeId(pk.roomTypeId);
		setRoomType(pk.RoomType);
	}

	public int getRoomTypeId() {
		return _roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		_roomTypeId = roomTypeId;
	}

	public String getRoomType() {
		return _RoomType;
	}

	public void setRoomType(String RoomType) {
		_RoomType = RoomType;
	}

	private int _roomTypeId;
	private String _RoomType;

}