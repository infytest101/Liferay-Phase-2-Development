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

package hotelmanagement.services.model;

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
public class BookingDetailsSoap implements Serializable {

	public static BookingDetailsSoap toSoapModel(BookingDetails model) {
		BookingDetailsSoap soapModel = new BookingDetailsSoap();

		soapModel.setBookingDetailsId(model.getBookingDetailsId());
		soapModel.setRoomId(model.getRoomId());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreateBy(model.getCreateBy());
		soapModel.setUpdateDate(model.getUpdateDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setTotalRoomsBooked(model.getTotalRoomsBooked());
		soapModel.setBookingStartDate(model.getBookingStartDate());
		soapModel.setBookingEndDate(model.getBookingEndDate());

		return soapModel;
	}

	public static BookingDetailsSoap[] toSoapModels(BookingDetails[] models) {
		BookingDetailsSoap[] soapModels = new BookingDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BookingDetailsSoap[][] toSoapModels(
		BookingDetails[][] models) {

		BookingDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new BookingDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BookingDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BookingDetailsSoap[] toSoapModels(
		List<BookingDetails> models) {

		List<BookingDetailsSoap> soapModels = new ArrayList<BookingDetailsSoap>(
			models.size());

		for (BookingDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BookingDetailsSoap[soapModels.size()]);
	}

	public BookingDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _bookingDetailsId;
	}

	public void setPrimaryKey(long pk) {
		setBookingDetailsId(pk);
	}

	public long getBookingDetailsId() {
		return _bookingDetailsId;
	}

	public void setBookingDetailsId(long bookingDetailsId) {
		_bookingDetailsId = bookingDetailsId;
	}

	public int getRoomId() {
		return _roomId;
	}

	public void setRoomId(int roomId) {
		_roomId = roomId;
	}

	public int getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(int customerId) {
		_customerId = customerId;
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

	public int getTotalRoomsBooked() {
		return _totalRoomsBooked;
	}

	public void setTotalRoomsBooked(int totalRoomsBooked) {
		_totalRoomsBooked = totalRoomsBooked;
	}

	public Date getBookingStartDate() {
		return _bookingStartDate;
	}

	public void setBookingStartDate(Date bookingStartDate) {
		_bookingStartDate = bookingStartDate;
	}

	public Date getBookingEndDate() {
		return _bookingEndDate;
	}

	public void setBookingEndDate(Date bookingEndDate) {
		_bookingEndDate = bookingEndDate;
	}

	private long _bookingDetailsId;
	private int _roomId;
	private int _customerId;
	private Date _createDate;
	private String _createBy;
	private Date _updateDate;
	private String _updatedBy;
	private int _totalRoomsBooked;
	private Date _bookingStartDate;
	private Date _bookingEndDate;

}