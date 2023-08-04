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

import ROOMSERVICES.model.BookingDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BookingDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BookingDetailsCacheModel
	implements CacheModel<BookingDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BookingDetailsCacheModel)) {
			return false;
		}

		BookingDetailsCacheModel bookingDetailsCacheModel =
			(BookingDetailsCacheModel)object;

		if (bookingDetailsId == bookingDetailsCacheModel.bookingDetailsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookingDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{bookingDetailsId=");
		sb.append(bookingDetailsId);
		sb.append(", roomId=");
		sb.append(roomId);
		sb.append(", customerId=");
		sb.append(customerId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createBy=");
		sb.append(createBy);
		sb.append(", updateDate=");
		sb.append(updateDate);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", totalRoomsBooked=");
		sb.append(totalRoomsBooked);
		sb.append(", bookingStartDate=");
		sb.append(bookingStartDate);
		sb.append(", bookingEndDate=");
		sb.append(bookingEndDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BookingDetails toEntityModel() {
		BookingDetailsImpl bookingDetailsImpl = new BookingDetailsImpl();

		bookingDetailsImpl.setBookingDetailsId(bookingDetailsId);
		bookingDetailsImpl.setRoomId(roomId);
		bookingDetailsImpl.setCustomerId(customerId);

		if (createDate == Long.MIN_VALUE) {
			bookingDetailsImpl.setCreateDate(null);
		}
		else {
			bookingDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (createBy == null) {
			bookingDetailsImpl.setCreateBy("");
		}
		else {
			bookingDetailsImpl.setCreateBy(createBy);
		}

		if (updateDate == Long.MIN_VALUE) {
			bookingDetailsImpl.setUpdateDate(null);
		}
		else {
			bookingDetailsImpl.setUpdateDate(new Date(updateDate));
		}

		if (updatedBy == null) {
			bookingDetailsImpl.setUpdatedBy("");
		}
		else {
			bookingDetailsImpl.setUpdatedBy(updatedBy);
		}

		bookingDetailsImpl.setTotalRoomsBooked(totalRoomsBooked);

		if (bookingStartDate == Long.MIN_VALUE) {
			bookingDetailsImpl.setBookingStartDate(null);
		}
		else {
			bookingDetailsImpl.setBookingStartDate(new Date(bookingStartDate));
		}

		if (bookingEndDate == Long.MIN_VALUE) {
			bookingDetailsImpl.setBookingEndDate(null);
		}
		else {
			bookingDetailsImpl.setBookingEndDate(new Date(bookingEndDate));
		}

		bookingDetailsImpl.resetOriginalValues();

		return bookingDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bookingDetailsId = objectInput.readLong();

		roomId = objectInput.readInt();

		customerId = objectInput.readInt();
		createDate = objectInput.readLong();
		createBy = objectInput.readUTF();
		updateDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();

		totalRoomsBooked = objectInput.readInt();
		bookingStartDate = objectInput.readLong();
		bookingEndDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(bookingDetailsId);

		objectOutput.writeInt(roomId);

		objectOutput.writeInt(customerId);
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

		objectOutput.writeInt(totalRoomsBooked);
		objectOutput.writeLong(bookingStartDate);
		objectOutput.writeLong(bookingEndDate);
	}

	public long bookingDetailsId;
	public int roomId;
	public int customerId;
	public long createDate;
	public String createBy;
	public long updateDate;
	public String updatedBy;
	public int totalRoomsBooked;
	public long bookingStartDate;
	public long bookingEndDate;

}