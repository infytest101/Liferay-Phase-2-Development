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
 * Provides a wrapper for {@link RoomsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RoomsLocalService
 * @generated
 */
public class RoomsLocalServiceWrapper
	implements RoomsLocalService, ServiceWrapper<RoomsLocalService> {

	public RoomsLocalServiceWrapper(RoomsLocalService roomsLocalService) {
		_roomsLocalService = roomsLocalService;
	}

	@Override
	public String addRoomDetails(String amenitiesjsonData, String formData) {
		return _roomsLocalService.addRoomDetails(amenitiesjsonData, formData);
	}

	/**
	 * Adds the rooms to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoomsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rooms the rooms
	 * @return the rooms that was added
	 */
	@Override
	public ROOMSERVICES.model.Rooms addRooms(ROOMSERVICES.model.Rooms rooms) {
		return _roomsLocalService.addRooms(rooms);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roomsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new rooms with the primary key. Does not add the rooms to the database.
	 *
	 * @param roomId the primary key for the new rooms
	 * @return the new rooms
	 */
	@Override
	public ROOMSERVICES.model.Rooms createRooms(int roomId) {
		return _roomsLocalService.createRooms(roomId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roomsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the rooms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoomsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roomId the primary key of the rooms
	 * @return the rooms that was removed
	 * @throws PortalException if a rooms with the primary key could not be found
	 */
	@Override
	public ROOMSERVICES.model.Rooms deleteRooms(int roomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roomsLocalService.deleteRooms(roomId);
	}

	/**
	 * Deletes the rooms from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoomsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rooms the rooms
	 * @return the rooms that was removed
	 */
	@Override
	public ROOMSERVICES.model.Rooms deleteRooms(
		ROOMSERVICES.model.Rooms rooms) {

		return _roomsLocalService.deleteRooms(rooms);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _roomsLocalService.dynamicQuery();
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

		return _roomsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ROOMSERVICES.model.impl.RoomsModelImpl</code>.
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

		return _roomsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ROOMSERVICES.model.impl.RoomsModelImpl</code>.
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

		return _roomsLocalService.dynamicQuery(
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

		return _roomsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _roomsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ROOMSERVICES.model.Rooms fetchRooms(int roomId) {
		return _roomsLocalService.fetchRooms(roomId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _roomsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _roomsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _roomsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roomsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rooms with the primary key.
	 *
	 * @param roomId the primary key of the rooms
	 * @return the rooms
	 * @throws PortalException if a rooms with the primary key could not be found
	 */
	@Override
	public ROOMSERVICES.model.Rooms getRooms(int roomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _roomsLocalService.getRooms(roomId);
	}

	/**
	 * Returns a range of all the roomses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ROOMSERVICES.model.impl.RoomsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of roomses
	 * @param end the upper bound of the range of roomses (not inclusive)
	 * @return the range of roomses
	 */
	@Override
	public java.util.List<ROOMSERVICES.model.Rooms> getRoomses(
		int start, int end) {

		return _roomsLocalService.getRoomses(start, end);
	}

	/**
	 * Returns the number of roomses.
	 *
	 * @return the number of roomses
	 */
	@Override
	public int getRoomsesCount() {
		return _roomsLocalService.getRoomsesCount();
	}

	/**
	 * Updates the rooms in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RoomsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rooms the rooms
	 * @return the rooms that was updated
	 */
	@Override
	public ROOMSERVICES.model.Rooms updateRooms(
		ROOMSERVICES.model.Rooms rooms) {

		return _roomsLocalService.updateRooms(rooms);
	}

	@Override
	public RoomsLocalService getWrappedService() {
		return _roomsLocalService;
	}

	@Override
	public void setWrappedService(RoomsLocalService roomsLocalService) {
		_roomsLocalService = roomsLocalService;
	}

	private RoomsLocalService _roomsLocalService;

}