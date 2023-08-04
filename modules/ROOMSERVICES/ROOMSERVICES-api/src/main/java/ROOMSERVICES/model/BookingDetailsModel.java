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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the BookingDetails service. Represents a row in the &quot;Infy_BookingDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>ROOMSERVICES.model.impl.BookingDetailsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>ROOMSERVICES.model.impl.BookingDetailsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingDetails
 * @generated
 */
@ProviderType
public interface BookingDetailsModel extends BaseModel<BookingDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a booking details model instance should use the {@link BookingDetails} interface instead.
	 */

	/**
	 * Returns the primary key of this booking details.
	 *
	 * @return the primary key of this booking details
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this booking details.
	 *
	 * @param primaryKey the primary key of this booking details
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the booking details ID of this booking details.
	 *
	 * @return the booking details ID of this booking details
	 */
	public long getBookingDetailsId();

	/**
	 * Sets the booking details ID of this booking details.
	 *
	 * @param bookingDetailsId the booking details ID of this booking details
	 */
	public void setBookingDetailsId(long bookingDetailsId);

	/**
	 * Returns the room ID of this booking details.
	 *
	 * @return the room ID of this booking details
	 */
	public int getRoomId();

	/**
	 * Sets the room ID of this booking details.
	 *
	 * @param roomId the room ID of this booking details
	 */
	public void setRoomId(int roomId);

	/**
	 * Returns the customer ID of this booking details.
	 *
	 * @return the customer ID of this booking details
	 */
	public int getCustomerId();

	/**
	 * Sets the customer ID of this booking details.
	 *
	 * @param customerId the customer ID of this booking details
	 */
	public void setCustomerId(int customerId);

	/**
	 * Returns the create date of this booking details.
	 *
	 * @return the create date of this booking details
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this booking details.
	 *
	 * @param createDate the create date of this booking details
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the create by of this booking details.
	 *
	 * @return the create by of this booking details
	 */
	@AutoEscape
	public String getCreateBy();

	/**
	 * Sets the create by of this booking details.
	 *
	 * @param createBy the create by of this booking details
	 */
	public void setCreateBy(String createBy);

	/**
	 * Returns the update date of this booking details.
	 *
	 * @return the update date of this booking details
	 */
	public Date getUpdateDate();

	/**
	 * Sets the update date of this booking details.
	 *
	 * @param updateDate the update date of this booking details
	 */
	public void setUpdateDate(Date updateDate);

	/**
	 * Returns the updated by of this booking details.
	 *
	 * @return the updated by of this booking details
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this booking details.
	 *
	 * @param updatedBy the updated by of this booking details
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the total rooms booked of this booking details.
	 *
	 * @return the total rooms booked of this booking details
	 */
	public int getTotalRoomsBooked();

	/**
	 * Sets the total rooms booked of this booking details.
	 *
	 * @param totalRoomsBooked the total rooms booked of this booking details
	 */
	public void setTotalRoomsBooked(int totalRoomsBooked);

	/**
	 * Returns the booking start date of this booking details.
	 *
	 * @return the booking start date of this booking details
	 */
	public Date getBookingStartDate();

	/**
	 * Sets the booking start date of this booking details.
	 *
	 * @param bookingStartDate the booking start date of this booking details
	 */
	public void setBookingStartDate(Date bookingStartDate);

	/**
	 * Returns the booking end date of this booking details.
	 *
	 * @return the booking end date of this booking details
	 */
	public Date getBookingEndDate();

	/**
	 * Sets the booking end date of this booking details.
	 *
	 * @param bookingEndDate the booking end date of this booking details
	 */
	public void setBookingEndDate(Date bookingEndDate);

}