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

import ROOMSERVICES.model.Amenities;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the amenities service. This utility wraps <code>ROOMSERVICES.service.persistence.impl.AmenitiesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmenitiesPersistence
 * @generated
 */
public class AmenitiesUtil {

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
	public static void clearCache(Amenities amenities) {
		getPersistence().clearCache(amenities);
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
	public static Map<Serializable, Amenities> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Amenities> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Amenities> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Amenities> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Amenities update(Amenities amenities) {
		return getPersistence().update(amenities);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Amenities update(
		Amenities amenities, ServiceContext serviceContext) {

		return getPersistence().update(amenities, serviceContext);
	}

	/**
	 * Returns all the amenitieses where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @return the matching amenitieses
	 */
	public static List<Amenities> findByIsACAvailable(Boolean isACAvailable) {
		return getPersistence().findByIsACAvailable(isACAvailable);
	}

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
	public static List<Amenities> findByIsACAvailable(
		Boolean isACAvailable, int start, int end) {

		return getPersistence().findByIsACAvailable(isACAvailable, start, end);
	}

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
	public static List<Amenities> findByIsACAvailable(
		Boolean isACAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().findByIsACAvailable(
			isACAvailable, start, end, orderByComparator);
	}

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
	public static List<Amenities> findByIsACAvailable(
		Boolean isACAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsACAvailable(
			isACAvailable, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public static Amenities findByIsACAvailable_First(
			Boolean isACAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsACAvailable_First(
			isACAvailable, orderByComparator);
	}

	/**
	 * Returns the first amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public static Amenities fetchByIsACAvailable_First(
		Boolean isACAvailable, OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().fetchByIsACAvailable_First(
			isACAvailable, orderByComparator);
	}

	/**
	 * Returns the last amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public static Amenities findByIsACAvailable_Last(
			Boolean isACAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsACAvailable_Last(
			isACAvailable, orderByComparator);
	}

	/**
	 * Returns the last amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public static Amenities fetchByIsACAvailable_Last(
		Boolean isACAvailable, OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().fetchByIsACAvailable_Last(
			isACAvailable, orderByComparator);
	}

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public static Amenities[] findByIsACAvailable_PrevAndNext(
			long amenitiesId, Boolean isACAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsACAvailable_PrevAndNext(
			amenitiesId, isACAvailable, orderByComparator);
	}

	/**
	 * Removes all the amenitieses where isACAvailable = &#63; from the database.
	 *
	 * @param isACAvailable the is ac available
	 */
	public static void removeByIsACAvailable(Boolean isACAvailable) {
		getPersistence().removeByIsACAvailable(isACAvailable);
	}

	/**
	 * Returns the number of amenitieses where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @return the number of matching amenitieses
	 */
	public static int countByIsACAvailable(Boolean isACAvailable) {
		return getPersistence().countByIsACAvailable(isACAvailable);
	}

	/**
	 * Returns all the amenitieses where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @return the matching amenitieses
	 */
	public static List<Amenities> findByIsSmokingAvailable(
		Boolean isSmokingAvailable) {

		return getPersistence().findByIsSmokingAvailable(isSmokingAvailable);
	}

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
	public static List<Amenities> findByIsSmokingAvailable(
		Boolean isSmokingAvailable, int start, int end) {

		return getPersistence().findByIsSmokingAvailable(
			isSmokingAvailable, start, end);
	}

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
	public static List<Amenities> findByIsSmokingAvailable(
		Boolean isSmokingAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().findByIsSmokingAvailable(
			isSmokingAvailable, start, end, orderByComparator);
	}

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
	public static List<Amenities> findByIsSmokingAvailable(
		Boolean isSmokingAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsSmokingAvailable(
			isSmokingAvailable, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public static Amenities findByIsSmokingAvailable_First(
			Boolean isSmokingAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsSmokingAvailable_First(
			isSmokingAvailable, orderByComparator);
	}

	/**
	 * Returns the first amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public static Amenities fetchByIsSmokingAvailable_First(
		Boolean isSmokingAvailable,
		OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().fetchByIsSmokingAvailable_First(
			isSmokingAvailable, orderByComparator);
	}

	/**
	 * Returns the last amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public static Amenities findByIsSmokingAvailable_Last(
			Boolean isSmokingAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsSmokingAvailable_Last(
			isSmokingAvailable, orderByComparator);
	}

	/**
	 * Returns the last amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public static Amenities fetchByIsSmokingAvailable_Last(
		Boolean isSmokingAvailable,
		OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().fetchByIsSmokingAvailable_Last(
			isSmokingAvailable, orderByComparator);
	}

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public static Amenities[] findByIsSmokingAvailable_PrevAndNext(
			long amenitiesId, Boolean isSmokingAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsSmokingAvailable_PrevAndNext(
			amenitiesId, isSmokingAvailable, orderByComparator);
	}

	/**
	 * Removes all the amenitieses where isSmokingAvailable = &#63; from the database.
	 *
	 * @param isSmokingAvailable the is smoking available
	 */
	public static void removeByIsSmokingAvailable(Boolean isSmokingAvailable) {
		getPersistence().removeByIsSmokingAvailable(isSmokingAvailable);
	}

	/**
	 * Returns the number of amenitieses where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @return the number of matching amenitieses
	 */
	public static int countByIsSmokingAvailable(Boolean isSmokingAvailable) {
		return getPersistence().countByIsSmokingAvailable(isSmokingAvailable);
	}

	/**
	 * Returns all the amenitieses where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @return the matching amenitieses
	 */
	public static List<Amenities> findByIsWifiAvailable(
		Boolean isWifiAvailable) {

		return getPersistence().findByIsWifiAvailable(isWifiAvailable);
	}

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
	public static List<Amenities> findByIsWifiAvailable(
		Boolean isWifiAvailable, int start, int end) {

		return getPersistence().findByIsWifiAvailable(
			isWifiAvailable, start, end);
	}

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
	public static List<Amenities> findByIsWifiAvailable(
		Boolean isWifiAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().findByIsWifiAvailable(
			isWifiAvailable, start, end, orderByComparator);
	}

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
	public static List<Amenities> findByIsWifiAvailable(
		Boolean isWifiAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsWifiAvailable(
			isWifiAvailable, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public static Amenities findByIsWifiAvailable_First(
			Boolean isWifiAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsWifiAvailable_First(
			isWifiAvailable, orderByComparator);
	}

	/**
	 * Returns the first amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public static Amenities fetchByIsWifiAvailable_First(
		Boolean isWifiAvailable,
		OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().fetchByIsWifiAvailable_First(
			isWifiAvailable, orderByComparator);
	}

	/**
	 * Returns the last amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public static Amenities findByIsWifiAvailable_Last(
			Boolean isWifiAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsWifiAvailable_Last(
			isWifiAvailable, orderByComparator);
	}

	/**
	 * Returns the last amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public static Amenities fetchByIsWifiAvailable_Last(
		Boolean isWifiAvailable,
		OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().fetchByIsWifiAvailable_Last(
			isWifiAvailable, orderByComparator);
	}

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public static Amenities[] findByIsWifiAvailable_PrevAndNext(
			long amenitiesId, Boolean isWifiAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsWifiAvailable_PrevAndNext(
			amenitiesId, isWifiAvailable, orderByComparator);
	}

	/**
	 * Removes all the amenitieses where isWifiAvailable = &#63; from the database.
	 *
	 * @param isWifiAvailable the is wifi available
	 */
	public static void removeByIsWifiAvailable(Boolean isWifiAvailable) {
		getPersistence().removeByIsWifiAvailable(isWifiAvailable);
	}

	/**
	 * Returns the number of amenitieses where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @return the number of matching amenitieses
	 */
	public static int countByIsWifiAvailable(Boolean isWifiAvailable) {
		return getPersistence().countByIsWifiAvailable(isWifiAvailable);
	}

	/**
	 * Returns all the amenitieses where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @return the matching amenitieses
	 */
	public static List<Amenities> findByIsTVAvailable(Boolean isTVAvailable) {
		return getPersistence().findByIsTVAvailable(isTVAvailable);
	}

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
	public static List<Amenities> findByIsTVAvailable(
		Boolean isTVAvailable, int start, int end) {

		return getPersistence().findByIsTVAvailable(isTVAvailable, start, end);
	}

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
	public static List<Amenities> findByIsTVAvailable(
		Boolean isTVAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().findByIsTVAvailable(
			isTVAvailable, start, end, orderByComparator);
	}

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
	public static List<Amenities> findByIsTVAvailable(
		Boolean isTVAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsTVAvailable(
			isTVAvailable, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public static Amenities findByIsTVAvailable_First(
			Boolean isTVAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsTVAvailable_First(
			isTVAvailable, orderByComparator);
	}

	/**
	 * Returns the first amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public static Amenities fetchByIsTVAvailable_First(
		Boolean isTVAvailable, OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().fetchByIsTVAvailable_First(
			isTVAvailable, orderByComparator);
	}

	/**
	 * Returns the last amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public static Amenities findByIsTVAvailable_Last(
			Boolean isTVAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsTVAvailable_Last(
			isTVAvailable, orderByComparator);
	}

	/**
	 * Returns the last amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public static Amenities fetchByIsTVAvailable_Last(
		Boolean isTVAvailable, OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().fetchByIsTVAvailable_Last(
			isTVAvailable, orderByComparator);
	}

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public static Amenities[] findByIsTVAvailable_PrevAndNext(
			long amenitiesId, Boolean isTVAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsTVAvailable_PrevAndNext(
			amenitiesId, isTVAvailable, orderByComparator);
	}

	/**
	 * Removes all the amenitieses where isTVAvailable = &#63; from the database.
	 *
	 * @param isTVAvailable the is tv available
	 */
	public static void removeByIsTVAvailable(Boolean isTVAvailable) {
		getPersistence().removeByIsTVAvailable(isTVAvailable);
	}

	/**
	 * Returns the number of amenitieses where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @return the number of matching amenitieses
	 */
	public static int countByIsTVAvailable(Boolean isTVAvailable) {
		return getPersistence().countByIsTVAvailable(isTVAvailable);
	}

	/**
	 * Returns all the amenitieses where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @return the matching amenitieses
	 */
	public static List<Amenities> findByIsGeyserAvailable(
		Boolean isGeyserAvailable) {

		return getPersistence().findByIsGeyserAvailable(isGeyserAvailable);
	}

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
	public static List<Amenities> findByIsGeyserAvailable(
		Boolean isGeyserAvailable, int start, int end) {

		return getPersistence().findByIsGeyserAvailable(
			isGeyserAvailable, start, end);
	}

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
	public static List<Amenities> findByIsGeyserAvailable(
		Boolean isGeyserAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().findByIsGeyserAvailable(
			isGeyserAvailable, start, end, orderByComparator);
	}

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
	public static List<Amenities> findByIsGeyserAvailable(
		Boolean isGeyserAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsGeyserAvailable(
			isGeyserAvailable, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public static Amenities findByIsGeyserAvailable_First(
			Boolean isGeyserAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsGeyserAvailable_First(
			isGeyserAvailable, orderByComparator);
	}

	/**
	 * Returns the first amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public static Amenities fetchByIsGeyserAvailable_First(
		Boolean isGeyserAvailable,
		OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().fetchByIsGeyserAvailable_First(
			isGeyserAvailable, orderByComparator);
	}

	/**
	 * Returns the last amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	public static Amenities findByIsGeyserAvailable_Last(
			Boolean isGeyserAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsGeyserAvailable_Last(
			isGeyserAvailable, orderByComparator);
	}

	/**
	 * Returns the last amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	public static Amenities fetchByIsGeyserAvailable_Last(
		Boolean isGeyserAvailable,
		OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().fetchByIsGeyserAvailable_Last(
			isGeyserAvailable, orderByComparator);
	}

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public static Amenities[] findByIsGeyserAvailable_PrevAndNext(
			long amenitiesId, Boolean isGeyserAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByIsGeyserAvailable_PrevAndNext(
			amenitiesId, isGeyserAvailable, orderByComparator);
	}

	/**
	 * Removes all the amenitieses where isGeyserAvailable = &#63; from the database.
	 *
	 * @param isGeyserAvailable the is geyser available
	 */
	public static void removeByIsGeyserAvailable(Boolean isGeyserAvailable) {
		getPersistence().removeByIsGeyserAvailable(isGeyserAvailable);
	}

	/**
	 * Returns the number of amenitieses where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @return the number of matching amenitieses
	 */
	public static int countByIsGeyserAvailable(Boolean isGeyserAvailable) {
		return getPersistence().countByIsGeyserAvailable(isGeyserAvailable);
	}

	/**
	 * Caches the amenities in the entity cache if it is enabled.
	 *
	 * @param amenities the amenities
	 */
	public static void cacheResult(Amenities amenities) {
		getPersistence().cacheResult(amenities);
	}

	/**
	 * Caches the amenitieses in the entity cache if it is enabled.
	 *
	 * @param amenitieses the amenitieses
	 */
	public static void cacheResult(List<Amenities> amenitieses) {
		getPersistence().cacheResult(amenitieses);
	}

	/**
	 * Creates a new amenities with the primary key. Does not add the amenities to the database.
	 *
	 * @param amenitiesId the primary key for the new amenities
	 * @return the new amenities
	 */
	public static Amenities create(long amenitiesId) {
		return getPersistence().create(amenitiesId);
	}

	/**
	 * Removes the amenities with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amenitiesId the primary key of the amenities
	 * @return the amenities that was removed
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public static Amenities remove(long amenitiesId)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().remove(amenitiesId);
	}

	public static Amenities updateImpl(Amenities amenities) {
		return getPersistence().updateImpl(amenities);
	}

	/**
	 * Returns the amenities with the primary key or throws a <code>NoSuchAmenitiesException</code> if it could not be found.
	 *
	 * @param amenitiesId the primary key of the amenities
	 * @return the amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public static Amenities findByPrimaryKey(long amenitiesId)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByPrimaryKey(amenitiesId);
	}

	/**
	 * Returns the amenities with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amenitiesId the primary key of the amenities
	 * @return the amenities, or <code>null</code> if a amenities with the primary key could not be found
	 */
	public static Amenities fetchByPrimaryKey(long amenitiesId) {
		return getPersistence().fetchByPrimaryKey(amenitiesId);
	}

	/**
	 * Returns all the amenitieses.
	 *
	 * @return the amenitieses
	 */
	public static List<Amenities> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Amenities> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Amenities> findAll(
		int start, int end, OrderByComparator<Amenities> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Amenities> findAll(
		int start, int end, OrderByComparator<Amenities> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the amenitieses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of amenitieses.
	 *
	 * @return the number of amenitieses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AmenitiesPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AmenitiesPersistence _persistence;

}