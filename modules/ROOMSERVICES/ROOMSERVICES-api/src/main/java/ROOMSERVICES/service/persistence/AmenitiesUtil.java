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
	public static Amenities create(int amenitiesId) {
		return getPersistence().create(amenitiesId);
	}

	/**
	 * Removes the amenities with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amenitiesId the primary key of the amenities
	 * @return the amenities that was removed
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	public static Amenities remove(int amenitiesId)
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
	public static Amenities findByPrimaryKey(int amenitiesId)
		throws ROOMSERVICES.exception.NoSuchAmenitiesException {

		return getPersistence().findByPrimaryKey(amenitiesId);
	}

	/**
	 * Returns the amenities with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amenitiesId the primary key of the amenities
	 * @return the amenities, or <code>null</code> if a amenities with the primary key could not be found
	 */
	public static Amenities fetchByPrimaryKey(int amenitiesId) {
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