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

package ROOMSERVICES.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BookingDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookingDetailsLocalService
 * @generated
 */
public class BookingDetailsLocalServiceWrapper
	implements BookingDetailsLocalService,
			   ServiceWrapper<BookingDetailsLocalService> {

	public BookingDetailsLocalServiceWrapper(
		BookingDetailsLocalService bookingDetailsLocalService) {

		_bookingDetailsLocalService = bookingDetailsLocalService;
	}

	/**
	 * Adds the booking details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookingDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookingDetails the booking details
	 * @return the booking details that was added
	 */
	@Override
	public ROOMSERVICES.model.BookingDetails addBookingDetails(
		ROOMSERVICES.model.BookingDetails bookingDetails) {

		return _bookingDetailsLocalService.addBookingDetails(bookingDetails);
	}

	/**
	 * Creates a new booking details with the primary key. Does not add the booking details to the database.
	 *
	 * @param bookingDetailsId the primary key for the new booking details
	 * @return the new booking details
	 */
	@Override
	public ROOMSERVICES.model.BookingDetails createBookingDetails(
		long bookingDetailsId) {

		return _bookingDetailsLocalService.createBookingDetails(
			bookingDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookingDetailsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the booking details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookingDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookingDetails the booking details
	 * @return the booking details that was removed
	 */
	@Override
	public ROOMSERVICES.model.BookingDetails deleteBookingDetails(
		ROOMSERVICES.model.BookingDetails bookingDetails) {

		return _bookingDetailsLocalService.deleteBookingDetails(bookingDetails);
	}

	/**
	 * Deletes the booking details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookingDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookingDetailsId the primary key of the booking details
	 * @return the booking details that was removed
	 * @throws PortalException if a booking details with the primary key could not be found
	 */
	@Override
	public ROOMSERVICES.model.BookingDetails deleteBookingDetails(
			long bookingDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookingDetailsLocalService.deleteBookingDetails(
			bookingDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookingDetailsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bookingDetailsLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _bookingDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ROOMSERVICES.model.impl.BookingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _bookingDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ROOMSERVICES.model.impl.BookingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _bookingDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _bookingDetailsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _bookingDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ROOMSERVICES.model.BookingDetails fetchBookingDetails(
		long bookingDetailsId) {

		return _bookingDetailsLocalService.fetchBookingDetails(
			bookingDetailsId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bookingDetailsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the booking details with the primary key.
	 *
	 * @param bookingDetailsId the primary key of the booking details
	 * @return the booking details
	 * @throws PortalException if a booking details with the primary key could not be found
	 */
	@Override
	public ROOMSERVICES.model.BookingDetails getBookingDetails(
			long bookingDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookingDetailsLocalService.getBookingDetails(bookingDetailsId);
	}

	/**
	 * Returns a range of all the booking detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ROOMSERVICES.model.impl.BookingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking detailses
	 * @param end the upper bound of the range of booking detailses (not inclusive)
	 * @return the range of booking detailses
	 */
	@Override
	public java.util.List<ROOMSERVICES.model.BookingDetails>
		getBookingDetailses(int start, int end) {

		return _bookingDetailsLocalService.getBookingDetailses(start, end);
	}

	/**
	 * Returns the number of booking detailses.
	 *
	 * @return the number of booking detailses
	 */
	@Override
	public int getBookingDetailsesCount() {
		return _bookingDetailsLocalService.getBookingDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bookingDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bookingDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookingDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the booking details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookingDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookingDetails the booking details
	 * @return the booking details that was updated
	 */
	@Override
	public ROOMSERVICES.model.BookingDetails updateBookingDetails(
		ROOMSERVICES.model.BookingDetails bookingDetails) {

		return _bookingDetailsLocalService.updateBookingDetails(bookingDetails);
	}

	@Override
	public BookingDetailsLocalService getWrappedService() {
		return _bookingDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		BookingDetailsLocalService bookingDetailsLocalService) {

		_bookingDetailsLocalService = bookingDetailsLocalService;
	}

	private BookingDetailsLocalService _bookingDetailsLocalService;

}