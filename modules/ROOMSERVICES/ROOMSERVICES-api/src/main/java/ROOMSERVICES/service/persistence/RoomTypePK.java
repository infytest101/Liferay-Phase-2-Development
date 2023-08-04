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

package ROOMSERVICES.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RoomTypePK implements Comparable<RoomTypePK>, Serializable {

	public int roomTypeId;
	public String RoomType;

	public RoomTypePK() {
	}

	public RoomTypePK(int roomTypeId, String RoomType) {
		this.roomTypeId = roomTypeId;
		this.RoomType = RoomType;
	}

	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomType() {
		return RoomType;
	}

	public void setRoomType(String RoomType) {
		this.RoomType = RoomType;
	}

	@Override
	public int compareTo(RoomTypePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (roomTypeId < pk.roomTypeId) {
			value = -1;
		}
		else if (roomTypeId > pk.roomTypeId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = RoomType.compareTo(pk.RoomType);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RoomTypePK)) {
			return false;
		}

		RoomTypePK pk = (RoomTypePK)object;

		if ((roomTypeId == pk.roomTypeId) && RoomType.equals(pk.RoomType)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, roomTypeId);
		hashCode = HashUtil.hash(hashCode, RoomType);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("roomTypeId=");

		sb.append(roomTypeId);
		sb.append(", RoomType=");

		sb.append(RoomType);

		sb.append("}");

		return sb.toString();
	}

}