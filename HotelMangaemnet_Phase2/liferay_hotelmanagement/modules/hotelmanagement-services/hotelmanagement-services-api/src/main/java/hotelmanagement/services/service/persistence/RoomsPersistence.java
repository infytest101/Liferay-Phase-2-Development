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

import hotelmanagement.services.exception.NoSuchRoomsException;
import hotelmanagement.services.model.Rooms;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the rooms service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomsUtil
 * @generated
 */
@ProviderType
public interface RoomsPersistence extends BasePersistence<Rooms> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RoomsUtil} to access the rooms persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the rooms where roomName = &#63; or throws a <code>NoSuchRoomsException</code> if it could not be found.
	 *
	 * @param roomName the room name
	 * @return the matching rooms
	 * @throws NoSuchRoomsException if a matching rooms could not be found
	 */
	public Rooms findByRoomName(String roomName) throws NoSuchRoomsException;

	/**
	 * Returns the rooms where roomName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param roomName the room name
	 * @return the matching rooms, or <code>null</code> if a matching rooms could not be found
	 */
	public Rooms fetchByRoomName(String roomName);

	/**
	 * Returns the rooms where roomName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param roomName the room name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rooms, or <code>null</code> if a matching rooms could not be found
	 */
	public Rooms fetchByRoomName(String roomName, boolean useFinderCache);

	/**
	 * Removes the rooms where roomName = &#63; from the database.
	 *
	 * @param roomName the room name
	 * @return the rooms that was removed
	 */
	public Rooms removeByRoomName(String roomName) throws NoSuchRoomsException;

	/**
	 * Returns the number of roomses where roomName = &#63;.
	 *
	 * @param roomName the room name
	 * @return the number of matching roomses
	 */
	public int countByRoomName(String roomName);

	/**
	 * Caches the rooms in the entity cache if it is enabled.
	 *
	 * @param rooms the rooms
	 */
	public void cacheResult(Rooms rooms);

	/**
	 * Caches the roomses in the entity cache if it is enabled.
	 *
	 * @param roomses the roomses
	 */
	public void cacheResult(java.util.List<Rooms> roomses);

	/**
	 * Creates a new rooms with the primary key. Does not add the rooms to the database.
	 *
	 * @param roomId the primary key for the new rooms
	 * @return the new rooms
	 */
	public Rooms create(int roomId);

	/**
	 * Removes the rooms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomId the primary key of the rooms
	 * @return the rooms that was removed
	 * @throws NoSuchRoomsException if a rooms with the primary key could not be found
	 */
	public Rooms remove(int roomId) throws NoSuchRoomsException;

	public Rooms updateImpl(Rooms rooms);

	/**
	 * Returns the rooms with the primary key or throws a <code>NoSuchRoomsException</code> if it could not be found.
	 *
	 * @param roomId the primary key of the rooms
	 * @return the rooms
	 * @throws NoSuchRoomsException if a rooms with the primary key could not be found
	 */
	public Rooms findByPrimaryKey(int roomId) throws NoSuchRoomsException;

	/**
	 * Returns the rooms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roomId the primary key of the rooms
	 * @return the rooms, or <code>null</code> if a rooms with the primary key could not be found
	 */
	public Rooms fetchByPrimaryKey(int roomId);

	/**
	 * Returns all the roomses.
	 *
	 * @return the roomses
	 */
	public java.util.List<Rooms> findAll();

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
	public java.util.List<Rooms> findAll(int start, int end);

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
	public java.util.List<Rooms> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Rooms>
			orderByComparator);

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
	public java.util.List<Rooms> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Rooms>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the roomses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of roomses.
	 *
	 * @return the number of roomses
	 */
	public int countAll();

}