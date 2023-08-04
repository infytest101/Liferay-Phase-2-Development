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
 * This class is a wrapper for {@link BookingDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingDetails
 * @generated
 */
public class BookingDetailsWrapper
	extends BaseModelWrapper<BookingDetails>
	implements BookingDetails, ModelWrapper<BookingDetails> {

	public BookingDetailsWrapper(BookingDetails bookingDetails) {
		super(bookingDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookingDetailsId", getBookingDetailsId());
		attributes.put("roomId", getRoomId());
		attributes.put("customerId", getCustomerId());
		attributes.put("createDate", getCreateDate());
		attributes.put("createBy", getCreateBy());
		attributes.put("updateDate", getUpdateDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("totalRoomsBooked", getTotalRoomsBooked());
		attributes.put("bookingStartDate", getBookingStartDate());
		attributes.put("bookingEndDate", getBookingEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookingDetailsId = (Long)attributes.get("bookingDetailsId");

		if (bookingDetailsId != null) {
			setBookingDetailsId(bookingDetailsId);
		}

		Integer roomId = (Integer)attributes.get("roomId");

		if (roomId != null) {
			setRoomId(roomId);
		}

		Integer customerId = (Integer)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
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

		Integer totalRoomsBooked = (Integer)attributes.get("totalRoomsBooked");

		if (totalRoomsBooked != null) {
			setTotalRoomsBooked(totalRoomsBooked);
		}

		Date bookingStartDate = (Date)attributes.get("bookingStartDate");

		if (bookingStartDate != null) {
			setBookingStartDate(bookingStartDate);
		}

		Date bookingEndDate = (Date)attributes.get("bookingEndDate");

		if (bookingEndDate != null) {
			setBookingEndDate(bookingEndDate);
		}
	}

	/**
	 * Returns the booking details ID of this booking details.
	 *
	 * @return the booking details ID of this booking details
	 */
	@Override
	public long getBookingDetailsId() {
		return model.getBookingDetailsId();
	}

	/**
	 * Returns the booking end date of this booking details.
	 *
	 * @return the booking end date of this booking details
	 */
	@Override
	public Date getBookingEndDate() {
		return model.getBookingEndDate();
	}

	/**
	 * Returns the booking start date of this booking details.
	 *
	 * @return the booking start date of this booking details
	 */
	@Override
	public Date getBookingStartDate() {
		return model.getBookingStartDate();
	}

	/**
	 * Returns the create by of this booking details.
	 *
	 * @return the create by of this booking details
	 */
	@Override
	public String getCreateBy() {
		return model.getCreateBy();
	}

	/**
	 * Returns the create date of this booking details.
	 *
	 * @return the create date of this booking details
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the customer ID of this booking details.
	 *
	 * @return the customer ID of this booking details
	 */
	@Override
	public int getCustomerId() {
		return model.getCustomerId();
	}

	/**
	 * Returns the primary key of this booking details.
	 *
	 * @return the primary key of this booking details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the room ID of this booking details.
	 *
	 * @return the room ID of this booking details
	 */
	@Override
	public int getRoomId() {
		return model.getRoomId();
	}

	/**
	 * Returns the total rooms booked of this booking details.
	 *
	 * @return the total rooms booked of this booking details
	 */
	@Override
	public int getTotalRoomsBooked() {
		return model.getTotalRoomsBooked();
	}

	/**
	 * Returns the update date of this booking details.
	 *
	 * @return the update date of this booking details
	 */
	@Override
	public Date getUpdateDate() {
		return model.getUpdateDate();
	}

	/**
	 * Returns the updated by of this booking details.
	 *
	 * @return the updated by of this booking details
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
	 * Sets the booking details ID of this booking details.
	 *
	 * @param bookingDetailsId the booking details ID of this booking details
	 */
	@Override
	public void setBookingDetailsId(long bookingDetailsId) {
		model.setBookingDetailsId(bookingDetailsId);
	}

	/**
	 * Sets the booking end date of this booking details.
	 *
	 * @param bookingEndDate the booking end date of this booking details
	 */
	@Override
	public void setBookingEndDate(Date bookingEndDate) {
		model.setBookingEndDate(bookingEndDate);
	}

	/**
	 * Sets the booking start date of this booking details.
	 *
	 * @param bookingStartDate the booking start date of this booking details
	 */
	@Override
	public void setBookingStartDate(Date bookingStartDate) {
		model.setBookingStartDate(bookingStartDate);
	}

	/**
	 * Sets the create by of this booking details.
	 *
	 * @param createBy the create by of this booking details
	 */
	@Override
	public void setCreateBy(String createBy) {
		model.setCreateBy(createBy);
	}

	/**
	 * Sets the create date of this booking details.
	 *
	 * @param createDate the create date of this booking details
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the customer ID of this booking details.
	 *
	 * @param customerId the customer ID of this booking details
	 */
	@Override
	public void setCustomerId(int customerId) {
		model.setCustomerId(customerId);
	}

	/**
	 * Sets the primary key of this booking details.
	 *
	 * @param primaryKey the primary key of this booking details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the room ID of this booking details.
	 *
	 * @param roomId the room ID of this booking details
	 */
	@Override
	public void setRoomId(int roomId) {
		model.setRoomId(roomId);
	}

	/**
	 * Sets the total rooms booked of this booking details.
	 *
	 * @param totalRoomsBooked the total rooms booked of this booking details
	 */
	@Override
	public void setTotalRoomsBooked(int totalRoomsBooked) {
		model.setTotalRoomsBooked(totalRoomsBooked);
	}

	/**
	 * Sets the update date of this booking details.
	 *
	 * @param updateDate the update date of this booking details
	 */
	@Override
	public void setUpdateDate(Date updateDate) {
		model.setUpdateDate(updateDate);
	}

	/**
	 * Sets the updated by of this booking details.
	 *
	 * @param updatedBy the updated by of this booking details
	 */
	@Override
	public void setUpdatedBy(String updatedBy) {
		model.setUpdatedBy(updatedBy);
	}

	@Override
	protected BookingDetailsWrapper wrap(BookingDetails bookingDetails) {
		return new BookingDetailsWrapper(bookingDetails);
	}

}