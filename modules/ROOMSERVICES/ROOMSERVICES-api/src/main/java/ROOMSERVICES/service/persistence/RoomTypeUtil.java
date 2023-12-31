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

import ROOMSERVICES.model.RoomType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the room type service. This utility wraps <code>ROOMSERVICES.service.persistence.impl.RoomTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomTypePersistence
 * @generated
 */
public class RoomTypeUtil {

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
	public static void clearCache(RoomType roomType) {
		getPersistence().clearCache(roomType);
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
	public static Map<Serializable, RoomType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RoomType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RoomType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RoomType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RoomType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RoomType update(RoomType roomType) {
		return getPersistence().update(roomType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RoomType update(
		RoomType roomType, ServiceContext serviceContext) {

		return getPersistence().update(roomType, serviceContext);
	}

	/**
	 * Returns all the room types where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @return the matching room types
	 */
	public static List<RoomType> findByRoomType_RoomType(String RoomType) {
		return getPersistence().findByRoomType_RoomType(RoomType);
	}

	/**
	 * Returns a range of all the room types where RoomType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomTypeModelImpl</code>.
	 * </p>
	 *
	 * @param RoomType the room type
	 * @param start the lower bound of the range of room types
	 * @param end the upper bound of the range of room types (not inclusive)
	 * @return the range of matching room types
	 */
	public static List<RoomType> findByRoomType_RoomType(
		String RoomType, int start, int end) {

		return getPersistence().findByRoomType_RoomType(RoomType, start, end);
	}

	/**
	 * Returns an ordered range of all the room types where RoomType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomTypeModelImpl</code>.
	 * </p>
	 *
	 * @param RoomType the room type
	 * @param start the lower bound of the range of room types
	 * @param end the upper bound of the range of room types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching room types
	 */
	public static List<RoomType> findByRoomType_RoomType(
		String RoomType, int start, int end,
		OrderByComparator<RoomType> orderByComparator) {

		return getPersistence().findByRoomType_RoomType(
			RoomType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the room types where RoomType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomTypeModelImpl</code>.
	 * </p>
	 *
	 * @param RoomType the room type
	 * @param start the lower bound of the range of room types
	 * @param end the upper bound of the range of room types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching room types
	 */
	public static List<RoomType> findByRoomType_RoomType(
		String RoomType, int start, int end,
		OrderByComparator<RoomType> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByRoomType_RoomType(
			RoomType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first room type in the ordered set where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room type
	 * @throws NoSuchRoomTypeException if a matching room type could not be found
	 */
	public static RoomType findByRoomType_RoomType_First(
			String RoomType, OrderByComparator<RoomType> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchRoomTypeException {

		return getPersistence().findByRoomType_RoomType_First(
			RoomType, orderByComparator);
	}

	/**
	 * Returns the first room type in the ordered set where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room type, or <code>null</code> if a matching room type could not be found
	 */
	public static RoomType fetchByRoomType_RoomType_First(
		String RoomType, OrderByComparator<RoomType> orderByComparator) {

		return getPersistence().fetchByRoomType_RoomType_First(
			RoomType, orderByComparator);
	}

	/**
	 * Returns the last room type in the ordered set where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room type
	 * @throws NoSuchRoomTypeException if a matching room type could not be found
	 */
	public static RoomType findByRoomType_RoomType_Last(
			String RoomType, OrderByComparator<RoomType> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchRoomTypeException {

		return getPersistence().findByRoomType_RoomType_Last(
			RoomType, orderByComparator);
	}

	/**
	 * Returns the last room type in the ordered set where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room type, or <code>null</code> if a matching room type could not be found
	 */
	public static RoomType fetchByRoomType_RoomType_Last(
		String RoomType, OrderByComparator<RoomType> orderByComparator) {

		return getPersistence().fetchByRoomType_RoomType_Last(
			RoomType, orderByComparator);
	}

	/**
	 * Returns the room types before and after the current room type in the ordered set where RoomType = &#63;.
	 *
	 * @param roomTypePK the primary key of the current room type
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room type
	 * @throws NoSuchRoomTypeException if a room type with the primary key could not be found
	 */
	public static RoomType[] findByRoomType_RoomType_PrevAndNext(
			ROOMSERVICES.service.persistence.RoomTypePK roomTypePK,
			String RoomType, OrderByComparator<RoomType> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchRoomTypeException {

		return getPersistence().findByRoomType_RoomType_PrevAndNext(
			roomTypePK, RoomType, orderByComparator);
	}

	/**
	 * Removes all the room types where RoomType = &#63; from the database.
	 *
	 * @param RoomType the room type
	 */
	public static void removeByRoomType_RoomType(String RoomType) {
		getPersistence().removeByRoomType_RoomType(RoomType);
	}

	/**
	 * Returns the number of room types where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @return the number of matching room types
	 */
	public static int countByRoomType_RoomType(String RoomType) {
		return getPersistence().countByRoomType_RoomType(RoomType);
	}

	/**
	 * Caches the room type in the entity cache if it is enabled.
	 *
	 * @param roomType the room type
	 */
	public static void cacheResult(RoomType roomType) {
		getPersistence().cacheResult(roomType);
	}

	/**
	 * Caches the room types in the entity cache if it is enabled.
	 *
	 * @param roomTypes the room types
	 */
	public static void cacheResult(List<RoomType> roomTypes) {
		getPersistence().cacheResult(roomTypes);
	}

	/**
	 * Creates a new room type with the primary key. Does not add the room type to the database.
	 *
	 * @param roomTypePK the primary key for the new room type
	 * @return the new room type
	 */
	public static RoomType create(
		ROOMSERVICES.service.persistence.RoomTypePK roomTypePK) {

		return getPersistence().create(roomTypePK);
	}

	/**
	 * Removes the room type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomTypePK the primary key of the room type
	 * @return the room type that was removed
	 * @throws NoSuchRoomTypeException if a room type with the primary key could not be found
	 */
	public static RoomType remove(
			ROOMSERVICES.service.persistence.RoomTypePK roomTypePK)
		throws ROOMSERVICES.exception.NoSuchRoomTypeException {

		return getPersistence().remove(roomTypePK);
	}

	public static RoomType updateImpl(RoomType roomType) {
		return getPersistence().updateImpl(roomType);
	}

	/**
	 * Returns the room type with the primary key or throws a <code>NoSuchRoomTypeException</code> if it could not be found.
	 *
	 * @param roomTypePK the primary key of the room type
	 * @return the room type
	 * @throws NoSuchRoomTypeException if a room type with the primary key could not be found
	 */
	public static RoomType findByPrimaryKey(
			ROOMSERVICES.service.persistence.RoomTypePK roomTypePK)
		throws ROOMSERVICES.exception.NoSuchRoomTypeException {

		return getPersistence().findByPrimaryKey(roomTypePK);
	}

	/**
	 * Returns the room type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roomTypePK the primary key of the room type
	 * @return the room type, or <code>null</code> if a room type with the primary key could not be found
	 */
	public static RoomType fetchByPrimaryKey(
		ROOMSERVICES.service.persistence.RoomTypePK roomTypePK) {

		return getPersistence().fetchByPrimaryKey(roomTypePK);
	}

	/**
	 * Returns all the room types.
	 *
	 * @return the room types
	 */
	public static List<RoomType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the room types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of room types
	 * @param end the upper bound of the range of room types (not inclusive)
	 * @return the range of room types
	 */
	public static List<RoomType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the room types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of room types
	 * @param end the upper bound of the range of room types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of room types
	 */
	public static List<RoomType> findAll(
		int start, int end, OrderByComparator<RoomType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the room types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of room types
	 * @param end the upper bound of the range of room types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of room types
	 */
	public static List<RoomType> findAll(
		int start, int end, OrderByComparator<RoomType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the room types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of room types.
	 *
	 * @return the number of room types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static RoomTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile RoomTypePersistence _persistence;

}