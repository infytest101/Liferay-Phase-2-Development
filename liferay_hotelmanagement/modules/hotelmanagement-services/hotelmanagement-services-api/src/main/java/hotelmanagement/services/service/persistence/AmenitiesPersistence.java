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

import hotelmanagement.services.exception.NoSuchAmenitiesException;
import hotelmanagement.services.model.Amenities;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the amenities service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmenitiesUtil
 * @generated
 */
@ProviderType
public interface AmenitiesPersistence extends BasePersistence<Amenities> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AmenitiesUtil} to access the amenities persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the amenitieses where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @return the matching amenitieses
	 */
	public java.util.List<Amenities> findByIsWifiTvGeyserAvailable(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable);

	/**
	 * Returns a range of all the amenitieses where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsWifiTvGeyserAvailable(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable, int start, int end);

	/**
	 * Returns an ordered range of all the amenitieses where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsWifiTvGeyserAvailable(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amenitieses where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsWifiTvGeyserAvailable(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amenities in the ordered set where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public Amenities findByIsWifiTvGeyserAvailable_First(
			Boolean isWifiAvailable, Boolean isTVAvailable,
			Boolean isGeyserAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Returns the first amenities in the ordered set where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public Amenities fetchByIsWifiTvGeyserAvailable_First(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns the last amenities in the ordered set where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public Amenities findByIsWifiTvGeyserAvailable_Last(
			Boolean isWifiAvailable, Boolean isTVAvailable,
			Boolean isGeyserAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Returns the last amenities in the ordered set where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public Amenities fetchByIsWifiTvGeyserAvailable_Last(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public Amenities[] findByIsWifiTvGeyserAvailable_PrevAndNext(
			int amenitiesId, Boolean isWifiAvailable, Boolean isTVAvailable,
			Boolean isGeyserAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Removes all the amenitieses where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63; from the database.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 */
	public void removeByIsWifiTvGeyserAvailable(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable);

	/**
	 * Returns the number of amenitieses where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @return the number of matching amenitieses
	 */
	public int countByIsWifiTvGeyserAvailable(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable);

	/**
	 * Returns all the amenitieses where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @return the matching amenitieses
	 */
	public java.util.List<Amenities> findByIsACAvailable(Boolean isACAvailable);

	/**
	 * Returns a range of all the amenitieses where isACAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isACAvailable the is ac available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsACAvailable(
		Boolean isACAvailable, int start, int end);

	/**
	 * Returns an ordered range of all the amenitieses where isACAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isACAvailable the is ac available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsACAvailable(
		Boolean isACAvailable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amenitieses where isACAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isACAvailable the is ac available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsACAvailable(
		Boolean isACAvailable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public Amenities findByIsACAvailable_First(
			Boolean isACAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Returns the first amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public Amenities fetchByIsACAvailable_First(
		Boolean isACAvailable,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns the last amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public Amenities findByIsACAvailable_Last(
			Boolean isACAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Returns the last amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public Amenities fetchByIsACAvailable_Last(
		Boolean isACAvailable,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public Amenities[] findByIsACAvailable_PrevAndNext(
			int amenitiesId, Boolean isACAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Removes all the amenitieses where isACAvailable = &#63; from the database.
	 *
	 * @param isACAvailable the is ac available
	 */
	public void removeByIsACAvailable(Boolean isACAvailable);

	/**
	 * Returns the number of amenitieses where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @return the number of matching amenitieses
	 */
	public int countByIsACAvailable(Boolean isACAvailable);

	/**
	 * Returns all the amenitieses where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @return the matching amenitieses
	 */
	public java.util.List<Amenities> findByIsSmokingAvailable(
		Boolean isSmokingAvailable);

	/**
	 * Returns a range of all the amenitieses where isSmokingAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsSmokingAvailable(
		Boolean isSmokingAvailable, int start, int end);

	/**
	 * Returns an ordered range of all the amenitieses where isSmokingAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsSmokingAvailable(
		Boolean isSmokingAvailable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amenitieses where isSmokingAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsSmokingAvailable(
		Boolean isSmokingAvailable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public Amenities findByIsSmokingAvailable_First(
			Boolean isSmokingAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Returns the first amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public Amenities fetchByIsSmokingAvailable_First(
		Boolean isSmokingAvailable,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns the last amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public Amenities findByIsSmokingAvailable_Last(
			Boolean isSmokingAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Returns the last amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public Amenities fetchByIsSmokingAvailable_Last(
		Boolean isSmokingAvailable,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public Amenities[] findByIsSmokingAvailable_PrevAndNext(
			int amenitiesId, Boolean isSmokingAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Removes all the amenitieses where isSmokingAvailable = &#63; from the database.
	 *
	 * @param isSmokingAvailable the is smoking available
	 */
	public void removeByIsSmokingAvailable(Boolean isSmokingAvailable);

	/**
	 * Returns the number of amenitieses where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @return the number of matching amenitieses
	 */
	public int countByIsSmokingAvailable(Boolean isSmokingAvailable);

	/**
	 * Returns all the amenitieses where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @return the matching amenitieses
	 */
	public java.util.List<Amenities> findByIsWifiAvailable(
		Boolean isWifiAvailable);

	/**
	 * Returns a range of all the amenitieses where isWifiAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsWifiAvailable(
		Boolean isWifiAvailable, int start, int end);

	/**
	 * Returns an ordered range of all the amenitieses where isWifiAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsWifiAvailable(
		Boolean isWifiAvailable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amenitieses where isWifiAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsWifiAvailable(
		Boolean isWifiAvailable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public Amenities findByIsWifiAvailable_First(
			Boolean isWifiAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Returns the first amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public Amenities fetchByIsWifiAvailable_First(
		Boolean isWifiAvailable,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns the last amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public Amenities findByIsWifiAvailable_Last(
			Boolean isWifiAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Returns the last amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public Amenities fetchByIsWifiAvailable_Last(
		Boolean isWifiAvailable,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public Amenities[] findByIsWifiAvailable_PrevAndNext(
			int amenitiesId, Boolean isWifiAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Removes all the amenitieses where isWifiAvailable = &#63; from the database.
	 *
	 * @param isWifiAvailable the is wifi available
	 */
	public void removeByIsWifiAvailable(Boolean isWifiAvailable);

	/**
	 * Returns the number of amenitieses where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @return the number of matching amenitieses
	 */
	public int countByIsWifiAvailable(Boolean isWifiAvailable);

	/**
	 * Returns all the amenitieses where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @return the matching amenitieses
	 */
	public java.util.List<Amenities> findByIsTVAvailable(Boolean isTVAvailable);

	/**
	 * Returns a range of all the amenitieses where isTVAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isTVAvailable the is tv available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsTVAvailable(
		Boolean isTVAvailable, int start, int end);

	/**
	 * Returns an ordered range of all the amenitieses where isTVAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isTVAvailable the is tv available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsTVAvailable(
		Boolean isTVAvailable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amenitieses where isTVAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isTVAvailable the is tv available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsTVAvailable(
		Boolean isTVAvailable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public Amenities findByIsTVAvailable_First(
			Boolean isTVAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Returns the first amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public Amenities fetchByIsTVAvailable_First(
		Boolean isTVAvailable,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns the last amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public Amenities findByIsTVAvailable_Last(
			Boolean isTVAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Returns the last amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public Amenities fetchByIsTVAvailable_Last(
		Boolean isTVAvailable,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public Amenities[] findByIsTVAvailable_PrevAndNext(
			int amenitiesId, Boolean isTVAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Removes all the amenitieses where isTVAvailable = &#63; from the database.
	 *
	 * @param isTVAvailable the is tv available
	 */
	public void removeByIsTVAvailable(Boolean isTVAvailable);

	/**
	 * Returns the number of amenitieses where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @return the number of matching amenitieses
	 */
	public int countByIsTVAvailable(Boolean isTVAvailable);

	/**
	 * Returns all the amenitieses where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @return the matching amenitieses
	 */
	public java.util.List<Amenities> findByIsGeyserAvailable(
		Boolean isGeyserAvailable);

	/**
	 * Returns a range of all the amenitieses where isGeyserAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsGeyserAvailable(
		Boolean isGeyserAvailable, int start, int end);

	/**
	 * Returns an ordered range of all the amenitieses where isGeyserAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsGeyserAvailable(
		Boolean isGeyserAvailable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amenitieses where isGeyserAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amenitieses
	 */
	public java.util.List<Amenities> findByIsGeyserAvailable(
		Boolean isGeyserAvailable, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public Amenities findByIsGeyserAvailable_First(
			Boolean isGeyserAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Returns the first amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public Amenities fetchByIsGeyserAvailable_First(
		Boolean isGeyserAvailable,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns the last amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public Amenities findByIsGeyserAvailable_Last(
			Boolean isGeyserAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Returns the last amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public Amenities fetchByIsGeyserAvailable_Last(
		Boolean isGeyserAvailable,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public Amenities[] findByIsGeyserAvailable_PrevAndNext(
			int amenitiesId, Boolean isGeyserAvailable,
			com.liferay.portal.kernel.util.OrderByComparator<Amenities>
				orderByComparator)
		throws NoSuchAmenitiesException;

	/**
	 * Removes all the amenitieses where isGeyserAvailable = &#63; from the database.
	 *
	 * @param isGeyserAvailable the is geyser available
	 */
	public void removeByIsGeyserAvailable(Boolean isGeyserAvailable);

	/**
	 * Returns the number of amenitieses where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @return the number of matching amenitieses
	 */
	public int countByIsGeyserAvailable(Boolean isGeyserAvailable);

	/**
	 * Caches the amenities in the entity cache if it is enabled.
	 *
	 * @param amenities the amenities
	 */
	public void cacheResult(Amenities amenities);

	/**
	 * Caches the amenitieses in the entity cache if it is enabled.
	 *
	 * @param amenitieses the amenitieses
	 */
	public void cacheResult(java.util.List<Amenities> amenitieses);

	/**
	 * Creates a new amenities with the primary key. Does not add the amenities to the database.
	 *
	 * @param amenitiesId the primary key for the new amenities
	 * @return the new amenities
	 */
	public Amenities create(int amenitiesId);

	/**
	 * Removes the amenities with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amenitiesId the primary key of the amenities
	 * @return the amenities that was removed
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public Amenities remove(int amenitiesId) throws NoSuchAmenitiesException;

	public Amenities updateImpl(Amenities amenities);

	/**
	 * Returns the amenities with the primary key or throws a <code>NoSuchAmenitiesException</code> if it could not be found.
	 *
	 * @param amenitiesId the primary key of the amenities
	 * @return the amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public Amenities findByPrimaryKey(int amenitiesId)
		throws NoSuchAmenitiesException;

	/**
	 * Returns the amenities with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amenitiesId the primary key of the amenities
	 * @return the amenities, or <code>null</code> if a amenities with the primary key could not be found
	 */
	public Amenities fetchByPrimaryKey(int amenitiesId);

	/**
	 * Returns all the amenitieses.
	 *
	 * @return the amenitieses
	 */
	public java.util.List<Amenities> findAll();

	/**
	 * Returns a range of all the amenitieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of amenitieses
	 */
	public java.util.List<Amenities> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the amenitieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amenitieses
	 */
	public java.util.List<Amenities> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amenitieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amenitieses
	 */
	public java.util.List<Amenities> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Amenities>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the amenitieses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of amenitieses.
	 *
	 * @return the number of amenitieses
	 */
	public int countAll();

}