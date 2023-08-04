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

package ROOMSERVICES.model.impl;

import ROOMSERVICES.model.RoomType;

import ROOMSERVICES.service.persistence.RoomTypePK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RoomType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RoomTypeCacheModel
	implements CacheModel<RoomType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RoomTypeCacheModel)) {
			return false;
		}

		RoomTypeCacheModel roomTypeCacheModel = (RoomTypeCacheModel)object;

		if (roomTypePK.equals(roomTypeCacheModel.roomTypePK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, roomTypePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{roomTypeId=");
		sb.append(roomTypeId);
		sb.append(", RoomType=");
		sb.append(RoomType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RoomType toEntityModel() {
		RoomTypeImpl roomTypeImpl = new RoomTypeImpl();

		roomTypeImpl.setRoomTypeId(roomTypeId);

		if (RoomType == null) {
			roomTypeImpl.setRoomType("");
		}
		else {
			roomTypeImpl.setRoomType(RoomType);
		}

		roomTypeImpl.resetOriginalValues();

		return roomTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		roomTypeId = objectInput.readInt();
		RoomType = objectInput.readUTF();

		roomTypePK = new RoomTypePK(roomTypeId, RoomType);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(roomTypeId);

		if (RoomType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(RoomType);
		}
	}

	public int roomTypeId;
	public String RoomType;
	public transient RoomTypePK roomTypePK;

}