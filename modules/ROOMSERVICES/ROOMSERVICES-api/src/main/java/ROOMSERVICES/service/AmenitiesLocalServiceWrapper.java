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
 * Provides a wrapper for {@link AmenitiesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmenitiesLocalService
 * @generated
 */
public class AmenitiesLocalServiceWrapper
	implements AmenitiesLocalService, ServiceWrapper<AmenitiesLocalService> {

	public AmenitiesLocalServiceWrapper(
		AmenitiesLocalService amenitiesLocalService) {

		_amenitiesLocalService = amenitiesLocalService;
	}

	/**
	 * Adds the amenities to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmenitiesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amenities the amenities
	 * @return the amenities that was added
	 */
	@Override
	public ROOMSERVICES.model.Amenities addAmenities(
		ROOMSERVICES.model.Amenities amenities) {

		return _amenitiesLocalService.addAmenities(amenities);
	}

	/**
	 * Creates a new amenities with the primary key. Does not add the amenities to the database.
	 *
	 * @param amenitiesId the primary key for the new amenities
	 * @return the new amenities
	 */
	@Override
	public ROOMSERVICES.model.Amenities createAmenities(long amenitiesId) {
		return _amenitiesLocalService.createAmenities(amenitiesId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amenitiesLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the amenities from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmenitiesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amenities the amenities
	 * @return the amenities that was removed
	 */
	@Override
	public ROOMSERVICES.model.Amenities deleteAmenities(
		ROOMSERVICES.model.Amenities amenities) {

		return _amenitiesLocalService.deleteAmenities(amenities);
	}

	/**
	 * Deletes the amenities with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmenitiesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amenitiesId the primary key of the amenities
	 * @return the amenities that was removed
	 * @throws PortalException if a amenities with the primary key could not be found
	 */
	@Override
	public ROOMSERVICES.model.Amenities deleteAmenities(long amenitiesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amenitiesLocalService.deleteAmenities(amenitiesId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amenitiesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _amenitiesLocalService.dynamicQuery();
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

		return _amenitiesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ROOMSERVICES.model.impl.AmenitiesModelImpl</code>.
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

		return _amenitiesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ROOMSERVICES.model.impl.AmenitiesModelImpl</code>.
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

		return _amenitiesLocalService.dynamicQuery(
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

		return _amenitiesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _amenitiesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public ROOMSERVICES.model.Amenities fetchAmenities(long amenitiesId) {
		return _amenitiesLocalService.fetchAmenities(amenitiesId);
	}

	@Override
	public java.util.List<ROOMSERVICES.model.Amenities> findByIsACAvailable(
		boolean isACAvailable) {

		return _amenitiesLocalService.findByIsACAvailable(isACAvailable);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _amenitiesLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the amenities with the primary key.
	 *
	 * @param amenitiesId the primary key of the amenities
	 * @return the amenities
	 * @throws PortalException if a amenities with the primary key could not be found
	 */
	@Override
	public ROOMSERVICES.model.Amenities getAmenities(long amenitiesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amenitiesLocalService.getAmenities(amenitiesId);
	}

	/**
	 * Returns a range of all the amenitieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ROOMSERVICES.model.impl.AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of amenitieses
	 */
	@Override
	public java.util.List<ROOMSERVICES.model.Amenities> getAmenitieses(
		int start, int end) {

		return _amenitiesLocalService.getAmenitieses(start, end);
	}

	/**
	 * Returns the number of amenitieses.
	 *
	 * @return the number of amenitieses
	 */
	@Override
	public int getAmenitiesesCount() {
		return _amenitiesLocalService.getAmenitiesesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _amenitiesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amenitiesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amenitiesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the amenities in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmenitiesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amenities the amenities
	 * @return the amenities that was updated
	 */
	@Override
	public ROOMSERVICES.model.Amenities updateAmenities(
		ROOMSERVICES.model.Amenities amenities) {

		return _amenitiesLocalService.updateAmenities(amenities);
	}

	@Override
	public AmenitiesLocalService getWrappedService() {
		return _amenitiesLocalService;
	}

	@Override
	public void setWrappedService(AmenitiesLocalService amenitiesLocalService) {
		_amenitiesLocalService = amenitiesLocalService;
	}

	private AmenitiesLocalService _amenitiesLocalService;

}