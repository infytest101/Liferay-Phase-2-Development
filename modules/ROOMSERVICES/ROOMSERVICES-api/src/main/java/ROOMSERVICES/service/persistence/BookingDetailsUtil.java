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

import ROOMSERVICES.model.BookingDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the booking details service. This utility wraps <code>ROOMSERVICES.service.persistence.impl.BookingDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookingDetailsPersistence
 * @generated
 */
public class BookingDetailsUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(BookingDetails bookingDetails) {
		getPersistence().clearCache(bookingDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, BookingDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BookingDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BookingDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BookingDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BookingDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BookingDetails update(BookingDetails bookingDetails) {
		return getPersistence().update(bookingDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BookingDetails update(
		BookingDetails bookingDetails, ServiceContext serviceContext) {

		return getPersistence().update(bookingDetails, serviceContext);
	}

	/**
	 * Caches the booking details in the entity cache if it is enabled.
	 *
	 * @param bookingDetails the booking details
	 */
	public static void cacheResult(BookingDetails bookingDetails) {
		getPersistence().cacheResult(bookingDetails);
	}

	/**
	 * Caches the booking detailses in the entity cache if it is enabled.
	 *
	 * @param bookingDetailses the booking detailses
	 */
	public static void cacheResult(List<BookingDetails> bookingDetailses) {
		getPersistence().cacheResult(bookingDetailses);
	}

	/**
	 * Creates a new booking details with the primary key. Does not add the booking details to the database.
	 *
	 * @param bookingDetailsId the primary key for the new booking details
	 * @return the new booking details
	 */
	public static BookingDetails create(long bookingDetailsId) {
		return getPersistence().create(bookingDetailsId);
	}

	/**
	 * Removes the booking details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingDetailsId the primary key of the booking details
	 * @return the booking details that was removed
	 * @throws NoSuchBookingDetailsException if a booking details with the primary key could not be found
	 */
	public static BookingDetails remove(long bookingDetailsId)
		throws ROOMSERVICES.exception.NoSuchBookingDetailsException {

		return getPersistence().remove(bookingDetailsId);
	}

	public static BookingDetails updateImpl(BookingDetails bookingDetails) {
		return getPersistence().updateImpl(bookingDetails);
	}

	/**
	 * Returns the booking details with the primary key or throws a <code>NoSuchBookingDetailsException</code> if it could not be found.
	 *
	 * @param bookingDetailsId the primary key of the booking details
	 * @return the booking details
	 * @throws NoSuchBookingDetailsException if a booking details with the primary key could not be found
	 */
	public static BookingDetails findByPrimaryKey(long bookingDetailsId)
		throws ROOMSERVICES.exception.NoSuchBookingDetailsException {

		return getPersistence().findByPrimaryKey(bookingDetailsId);
	}

	/**
	 * Returns the booking details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookingDetailsId the primary key of the booking details
	 * @return the booking details, or <code>null</code> if a booking details with the primary key could not be found
	 */
	public static BookingDetails fetchByPrimaryKey(long bookingDetailsId) {
		return getPersistence().fetchByPrimaryKey(bookingDetailsId);
	}

	/**
	 * Returns all the booking detailses.
	 *
	 * @return the booking detailses
	 */
	public static List<BookingDetails> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<BookingDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<BookingDetails> findAll(
		int start, int end,
		OrderByComparator<BookingDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<BookingDetails> findAll(
		int start, int end, OrderByComparator<BookingDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the booking detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of booking detailses.
	 *
	 * @return the number of booking detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BookingDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BookingDetailsPersistence _persistence;

}