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

import ROOMSERVICES.exception.NoSuchRoomTypeException;

import ROOMSERVICES.model.RoomType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the room type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomTypeUtil
 * @generated
 */
@ProviderType
public interface RoomTypePersistence extends BasePersistence<RoomType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RoomTypeUtil} to access the room type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the room types where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @return the matching room types
	 */
	public java.util.List<RoomType> findByRoomType_RoomType(String RoomType);

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
	public java.util.List<RoomType> findByRoomType_RoomType(
		String RoomType, int start, int end);

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
	public java.util.List<RoomType> findByRoomType_RoomType(
		String RoomType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoomType>
			orderByComparator);

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
	public java.util.List<RoomType> findByRoomType_RoomType(
		String RoomType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoomType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first room type in the ordered set where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room type
	 * @throws NoSuchRoomTypeException if a matching room type could not be found
	 */
	public RoomType findByRoomType_RoomType_First(
			String RoomType,
			com.liferay.portal.kernel.util.OrderByComparator<RoomType>
				orderByComparator)
		throws NoSuchRoomTypeException;

	/**
	 * Returns the first room type in the ordered set where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room type, or <code>null</code> if a matching room type could not be found
	 */
	public RoomType fetchByRoomType_RoomType_First(
		String RoomType,
		com.liferay.portal.kernel.util.OrderByComparator<RoomType>
			orderByComparator);

	/**
	 * Returns the last room type in the ordered set where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room type
	 * @throws NoSuchRoomTypeException if a matching room type could not be found
	 */
	public RoomType findByRoomType_RoomType_Last(
			String RoomType,
			com.liferay.portal.kernel.util.OrderByComparator<RoomType>
				orderByComparator)
		throws NoSuchRoomTypeException;

	/**
	 * Returns the last room type in the ordered set where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room type, or <code>null</code> if a matching room type could not be found
	 */
	public RoomType fetchByRoomType_RoomType_Last(
		String RoomType,
		com.liferay.portal.kernel.util.OrderByComparator<RoomType>
			orderByComparator);

	/**
	 * Returns the room types before and after the current room type in the ordered set where RoomType = &#63;.
	 *
	 * @param roomTypePK the primary key of the current room type
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room type
	 * @throws NoSuchRoomTypeException if a room type with the primary key could not be found
	 */
	public RoomType[] findByRoomType_RoomType_PrevAndNext(
			ROOMSERVICES.service.persistence.RoomTypePK roomTypePK,
			String RoomType,
			com.liferay.portal.kernel.util.OrderByComparator<RoomType>
				orderByComparator)
		throws NoSuchRoomTypeException;

	/**
	 * Removes all the room types where RoomType = &#63; from the database.
	 *
	 * @param RoomType the room type
	 */
	public void removeByRoomType_RoomType(String RoomType);

	/**
	 * Returns the number of room types where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @return the number of matching room types
	 */
	public int countByRoomType_RoomType(String RoomType);

	/**
	 * Caches the room type in the entity cache if it is enabled.
	 *
	 * @param roomType the room type
	 */
	public void cacheResult(RoomType roomType);

	/**
	 * Caches the room types in the entity cache if it is enabled.
	 *
	 * @param roomTypes the room types
	 */
	public void cacheResult(java.util.List<RoomType> roomTypes);

	/**
	 * Creates a new room type with the primary key. Does not add the room type to the database.
	 *
	 * @param roomTypePK the primary key for the new room type
	 * @return the new room type
	 */
	public RoomType create(
		ROOMSERVICES.service.persistence.RoomTypePK roomTypePK);

	/**
	 * Removes the room type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomTypePK the primary key of the room type
	 * @return the room type that was removed
	 * @throws NoSuchRoomTypeException if a room type with the primary key could not be found
	 */
	public RoomType remove(
			ROOMSERVICES.service.persistence.RoomTypePK roomTypePK)
		throws NoSuchRoomTypeException;

	public RoomType updateImpl(RoomType roomType);

	/**
	 * Returns the room type with the primary key or throws a <code>NoSuchRoomTypeException</code> if it could not be found.
	 *
	 * @param roomTypePK the primary key of the room type
	 * @return the room type
	 * @throws NoSuchRoomTypeException if a room type with the primary key could not be found
	 */
	public RoomType findByPrimaryKey(
			ROOMSERVICES.service.persistence.RoomTypePK roomTypePK)
		throws NoSuchRoomTypeException;

	/**
	 * Returns the room type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roomTypePK the primary key of the room type
	 * @return the room type, or <code>null</code> if a room type with the primary key could not be found
	 */
	public RoomType fetchByPrimaryKey(
		ROOMSERVICES.service.persistence.RoomTypePK roomTypePK);

	/**
	 * Returns all the room types.
	 *
	 * @return the room types
	 */
	public java.util.List<RoomType> findAll();

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
	public java.util.List<RoomType> findAll(int start, int end);

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
	public java.util.List<RoomType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoomType>
			orderByComparator);

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
	public java.util.List<RoomType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RoomType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the room types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of room types.
	 *
	 * @return the number of room types
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}