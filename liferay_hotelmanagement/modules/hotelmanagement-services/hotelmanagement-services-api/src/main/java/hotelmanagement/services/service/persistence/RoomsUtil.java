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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import hotelmanagement.services.model.Rooms;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the rooms service. This utility wraps <code>hotelmanagement.services.service.persistence.impl.RoomsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomsPersistence
 * @generated
 */
public class RoomsUtil {

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
	public static void clearCache(Rooms rooms) {
		getPersistence().clearCache(rooms);
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
	public static Map<Serializable, Rooms> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Rooms> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Rooms> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Rooms> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Rooms> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Rooms update(Rooms rooms) {
		return getPersistence().update(rooms);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Rooms update(Rooms rooms, ServiceContext serviceContext) {
		return getPersistence().update(rooms, serviceContext);
	}

	/**
	 * Returns the rooms where roomName = &#63; or throws a <code>NoSuchRoomsException</code> if it could not be found.
	 *
	 * @param roomName the room name
	 * @return the matching rooms
	 * @throws NoSuchRoomsException if a matching rooms could not be found
	 */
	public static Rooms findByRoomName(String roomName)
		throws hotelmanagement.services.exception.NoSuchRoomsException {

		return getPersistence().findByRoomName(roomName);
	}

	/**
	 * Returns the rooms where roomName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param roomName the room name
	 * @return the matching rooms, or <code>null</code> if a matching rooms could not be found
	 */
	public static Rooms fetchByRoomName(String roomName) {
		return getPersistence().fetchByRoomName(roomName);
	}

	/**
	 * Returns the rooms where roomName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param roomName the room name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rooms, or <code>null</code> if a matching rooms could not be found
	 */
	public static Rooms fetchByRoomName(
		String roomName, boolean useFinderCache) {

		return getPersistence().fetchByRoomName(roomName, useFinderCache);
	}

	/**
	 * Removes the rooms where roomName = &#63; from the database.
	 *
	 * @param roomName the room name
	 * @return the rooms that was removed
	 */
	public static Rooms removeByRoomName(String roomName)
		throws hotelmanagement.services.exception.NoSuchRoomsException {

		return getPersistence().removeByRoomName(roomName);
	}

	/**
	 * Returns the number of roomses where roomName = &#63;.
	 *
	 * @param roomName the room name
	 * @return the number of matching roomses
	 */
	public static int countByRoomName(String roomName) {
		return getPersistence().countByRoomName(roomName);
	}

	/**
	 * Caches the rooms in the entity cache if it is enabled.
	 *
	 * @param rooms the rooms
	 */
	public static void cacheResult(Rooms rooms) {
		getPersistence().cacheResult(rooms);
	}

	/**
	 * Caches the roomses in the entity cache if it is enabled.
	 *
	 * @param roomses the roomses
	 */
	public static void cacheResult(List<Rooms> roomses) {
		getPersistence().cacheResult(roomses);
	}

	/**
	 * Creates a new rooms with the primary key. Does not add the rooms to the database.
	 *
	 * @param roomId the primary key for the new rooms
	 * @return the new rooms
	 */
	public static Rooms create(int roomId) {
		return getPersistence().create(roomId);
	}

	/**
	 * Removes the rooms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomId the primary key of the rooms
	 * @return the rooms that was removed
	 * @throws NoSuchRoomsException if a rooms with the primary key could not be found
	 */
	public static Rooms remove(int roomId)
		throws hotelmanagement.services.exception.NoSuchRoomsException {

		return getPersistence().remove(roomId);
	}

	public static Rooms updateImpl(Rooms rooms) {
		return getPersistence().updateImpl(rooms);
	}

	/**
	 * Returns the rooms with the primary key or throws a <code>NoSuchRoomsException</code> if it could not be found.
	 *
	 * @param roomId the primary key of the rooms
	 * @return the rooms
	 * @throws NoSuchRoomsException if a rooms with the primary key could not be found
	 */
	public static Rooms findByPrimaryKey(int roomId)
		throws hotelmanagement.services.exception.NoSuchRoomsException {

		return getPersistence().findByPrimaryKey(roomId);
	}

	/**
	 * Returns the rooms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roomId the primary key of the rooms
	 * @return the rooms, or <code>null</code> if a rooms with the primary key could not be found
	 */
	public static Rooms fetchByPrimaryKey(int roomId) {
		return getPersistence().fetchByPrimaryKey(roomId);
	}

	/**
	 * Returns all the roomses.
	 *
	 * @return the roomses
	 */
	public static List<Rooms> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the roomses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of roomses
	 * @param end the upper bound of the range of roomses (not inclusive)
	 * @return the range of roomses
	 */
	public static List<Rooms> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the roomses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of roomses
	 * @param end the upper bound of the range of roomses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of roomses
	 */
	public static List<Rooms> findAll(
		int start, int end, OrderByComparator<Rooms> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the roomses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of roomses
	 * @param end the upper bound of the range of roomses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of roomses
	 */
	public static List<Rooms> findAll(
		int start, int end, OrderByComparator<Rooms> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the roomses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of roomses.
	 *
	 * @return the number of roomses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RoomsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile RoomsPersistence _persistence;

}