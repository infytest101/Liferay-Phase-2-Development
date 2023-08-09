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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class RoomsSoap implements Serializable {

	public static RoomsSoap toSoapModel(Rooms model) {
		RoomsSoap soapModel = new RoomsSoap();

		soapModel.setRoomId(model.getRoomId());
		soapModel.setRoomTypeId(model.getRoomTypeId());
		soapModel.setAmenitiesId(model.getAmenitiesId());
		soapModel.setRoomName(model.getRoomName());
		soapModel.setPrice(model.getPrice());
		soapModel.setTotalRoomsAvailable(model.getTotalRoomsAvailable());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreateBy(model.getCreateBy());
		soapModel.setUpdateDate(model.getUpdateDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());

		return soapModel;
	}

	public static RoomsSoap[] toSoapModels(Rooms[] models) {
		RoomsSoap[] soapModels = new RoomsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RoomsSoap[][] toSoapModels(Rooms[][] models) {
		RoomsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RoomsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RoomsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RoomsSoap[] toSoapModels(List<Rooms> models) {
		List<RoomsSoap> soapModels = new ArrayList<RoomsSoap>(models.size());

		for (Rooms model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RoomsSoap[soapModels.size()]);
	}

	public RoomsSoap() {
	}

	public long getPrimaryKey() {
		return _roomId;
	}

	public void setPrimaryKey(long pk) {
		setRoomId(pk);
	}

	public long getRoomId() {
		return _roomId;
	}

	public void setRoomId(long roomId) {
		_roomId = roomId;
	}

	public int getRoomTypeId() {
		return _roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		_roomTypeId = roomTypeId;
	}

	public int getAmenitiesId() {
		return _amenitiesId;
	}

	public void setAmenitiesId(int amenitiesId) {
		_amenitiesId = amenitiesId;
	}

	public String getRoomName() {
		return _roomName;
	}

	public void setRoomName(String roomName) {
		_roomName = roomName;
	}

	public int getPrice() {
		return _price;
	}

	public void setPrice(int price) {
		_price = price;
	}

	public int getTotalRoomsAvailable() {
		return _totalRoomsAvailable;
	}

	public void setTotalRoomsAvailable(int totalRoomsAvailable) {
		_totalRoomsAvailable = totalRoomsAvailable;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getCreateBy() {
		return _createBy;
	}

	public void setCreateBy(String createBy) {
		_createBy = createBy;
	}

	public Date getUpdateDate() {
		return _updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;
	}

	public String getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;
	}

	private long _roomId;
	private int _roomTypeId;
	private int _amenitiesId;
	private String _roomName;
	private int _price;
	private int _totalRoomsAvailable;
	private Date _createDate;
	private String _createBy;
	private Date _updateDate;
	private String _updatedBy;

}