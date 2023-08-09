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

package hotelmanagement.services.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import hotelmanagement.services.model.Rooms;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Rooms in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RoomsCacheModel implements CacheModel<Rooms>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RoomsCacheModel)) {
			return false;
		}

		RoomsCacheModel roomsCacheModel = (RoomsCacheModel)object;

		if (roomId == roomsCacheModel.roomId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, roomId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{roomId=");
		sb.append(roomId);
		sb.append(", roomTypeId=");
		sb.append(roomTypeId);
		sb.append(", amenitiesId=");
		sb.append(amenitiesId);
		sb.append(", roomName=");
		sb.append(roomName);
		sb.append(", totalRoomsAvailable=");
		sb.append(totalRoomsAvailable);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createBy=");
		sb.append(createBy);
		sb.append(", updateDate=");
		sb.append(updateDate);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", price=");
		sb.append(price);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Rooms toEntityModel() {
		RoomsImpl roomsImpl = new RoomsImpl();

		roomsImpl.setRoomId(roomId);
		roomsImpl.setRoomTypeId(roomTypeId);
		roomsImpl.setAmenitiesId(amenitiesId);

		if (roomName == null) {
			roomsImpl.setRoomName("");
		}
		else {
			roomsImpl.setRoomName(roomName);
		}

		roomsImpl.setTotalRoomsAvailable(totalRoomsAvailable);

		if (createDate == Long.MIN_VALUE) {
			roomsImpl.setCreateDate(null);
		}
		else {
			roomsImpl.setCreateDate(new Date(createDate));
		}

		if (createBy == null) {
			roomsImpl.setCreateBy("");
		}
		else {
			roomsImpl.setCreateBy(createBy);
		}

		if (updateDate == Long.MIN_VALUE) {
			roomsImpl.setUpdateDate(null);
		}
		else {
			roomsImpl.setUpdateDate(new Date(updateDate));
		}

		if (updatedBy == null) {
			roomsImpl.setUpdatedBy("");
		}
		else {
			roomsImpl.setUpdatedBy(updatedBy);
		}

		roomsImpl.setPrice(price);

		roomsImpl.resetOriginalValues();

		return roomsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		roomId = objectInput.readInt();

		roomTypeId = objectInput.readInt();

		amenitiesId = objectInput.readInt();
		roomName = objectInput.readUTF();

		totalRoomsAvailable = objectInput.readInt();
		createDate = objectInput.readLong();
		createBy = objectInput.readUTF();
		updateDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();

		price = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(roomId);

		objectOutput.writeInt(roomTypeId);

		objectOutput.writeInt(amenitiesId);

		if (roomName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(roomName);
		}

		objectOutput.writeInt(totalRoomsAvailable);
		objectOutput.writeLong(createDate);

		if (createBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createBy);
		}

		objectOutput.writeLong(updateDate);

		if (updatedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(updatedBy);
		}

		objectOutput.writeInt(price);
	}

	public int roomId;
	public int roomTypeId;
	public int amenitiesId;
	public String roomName;
	public int totalRoomsAvailable;
	public long createDate;
	public String createBy;
	public long updateDate;
	public String updatedBy;
	public int price;

}