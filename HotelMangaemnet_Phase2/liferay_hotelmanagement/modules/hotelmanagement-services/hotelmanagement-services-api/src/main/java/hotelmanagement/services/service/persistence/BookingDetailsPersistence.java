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

package hotelmanagement.services.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import hotelmanagement.services.exception.NoSuchBookingDetailsException;
import hotelmanagement.services.model.BookingDetails;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the booking details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingDetailsUtil
 * @generated
 */
@ProviderType
public interface BookingDetailsPersistence
	extends BasePersistence<BookingDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookingDetailsUtil} to access the booking details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the booking details in the entity cache if it is enabled.
	 *
	 * @param bookingDetails the booking details
	 */
	public void cacheResult(BookingDetails bookingDetails);

	/**
	 * Caches the booking detailses in the entity cache if it is enabled.
	 *
	 * @param bookingDetailses the booking detailses
	 */
	public void cacheResult(java.util.List<BookingDetails> bookingDetailses);

	/**
	 * Creates a new booking details with the primary key. Does not add the booking details to the database.
	 *
	 * @param bookingDetailsId the primary key for the new booking details
	 * @return the new booking details
	 */
	public BookingDetails create(long bookingDetailsId);

	/**
	 * Removes the booking details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingDetailsId the primary key of the booking details
	 * @return the booking details that was removed
	 * @throws NoSuchBookingDetailsException if a booking details with the primary key could not be found
	 */
	public BookingDetails remove(long bookingDetailsId)
		throws NoSuchBookingDetailsException;

	public BookingDetails updateImpl(BookingDetails bookingDetails);

	/**
	 * Returns the booking details with the primary key or throws a <code>NoSuchBookingDetailsException</code> if it could not be found.
	 *
	 * @param bookingDetailsId the primary key of the booking details
	 * @return the booking details
	 * @throws NoSuchBookingDetailsException if a booking details with the primary key could not be found
	 */
	public BookingDetails findByPrimaryKey(long bookingDetailsId)
		throws NoSuchBookingDetailsException;

	/**
	 * Returns the booking details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookingDetailsId the primary key of the booking details
	 * @return the booking details, or <code>null</code> if a booking details with the primary key could not be found
	 */
	public BookingDetails fetchByPrimaryKey(long bookingDetailsId);

	/**
	 * Returns all the booking detailses.
	 *
	 * @return the booking detailses
	 */
	public java.util.List<BookingDetails> findAll();

	/**
	 * Returns a range of all the booking detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking detailses
	 * @param end the upper bound of the range of booking detailses (not inclusive)
	 * @return the range of booking detailses
	 */
	public java.util.List<BookingDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the booking detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking detailses
	 * @param end the upper bound of the range of booking detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of booking detailses
	 */
	public java.util.List<BookingDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookingDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the booking detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking detailses
	 * @param end the upper bound of the range of booking detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of booking detailses
	 */
	public java.util.List<BookingDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookingDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the booking detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of booking detailses.
	 *
	 * @return the number of booking detailses
	 */
	public int countAll();

}