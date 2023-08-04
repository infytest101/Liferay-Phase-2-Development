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

package ROOMSERVICES.model;

import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Amenities service. Represents a row in the &quot;Infy_Amenities&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>ROOMSERVICES.model.impl.AmenitiesModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>ROOMSERVICES.model.impl.AmenitiesImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Amenities
 * @generated
 */
@ProviderType
public interface AmenitiesModel extends BaseModel<Amenities> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a amenities model instance should use the {@link Amenities} interface instead.
	 */

	/**
	 * Returns the primary key of this amenities.
	 *
	 * @return the primary key of this amenities
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this amenities.
	 *
	 * @param primaryKey the primary key of this amenities
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the amenities ID of this amenities.
	 *
	 * @return the amenities ID of this amenities
	 */
	public int getAmenitiesId();

	/**
	 * Sets the amenities ID of this amenities.
	 *
	 * @param amenitiesId the amenities ID of this amenities
	 */
	public void setAmenitiesId(int amenitiesId);

	/**
	 * Returns the is ac available of this amenities.
	 *
	 * @return the is ac available of this amenities
	 */
	public Boolean getIsACAvailable();

	/**
	 * Sets the is ac available of this amenities.
	 *
	 * @param isACAvailable the is ac available of this amenities
	 */
	public void setIsACAvailable(Boolean isACAvailable);

	/**
	 * Returns the is smoking available of this amenities.
	 *
	 * @return the is smoking available of this amenities
	 */
	public Boolean getIsSmokingAvailable();

	/**
	 * Sets the is smoking available of this amenities.
	 *
	 * @param isSmokingAvailable the is smoking available of this amenities
	 */
	public void setIsSmokingAvailable(Boolean isSmokingAvailable);

	/**
	 * Returns the is wifi available of this amenities.
	 *
	 * @return the is wifi available of this amenities
	 */
	public Boolean getIsWifiAvailable();

	/**
	 * Sets the is wifi available of this amenities.
	 *
	 * @param isWifiAvailable the is wifi available of this amenities
	 */
	public void setIsWifiAvailable(Boolean isWifiAvailable);

	/**
	 * Returns the is tv available of this amenities.
	 *
	 * @return the is tv available of this amenities
	 */
	public Boolean getIsTVAvailable();

	/**
	 * Sets the is tv available of this amenities.
	 *
	 * @param isTVAvailable the is tv available of this amenities
	 */
	public void setIsTVAvailable(Boolean isTVAvailable);

	/**
	 * Returns the is geyser available of this amenities.
	 *
	 * @return the is geyser available of this amenities
	 */
	public Boolean getIsGeyserAvailable();

	/**
	 * Sets the is geyser available of this amenities.
	 *
	 * @param isGeyserAvailable the is geyser available of this amenities
	 */
	public void setIsGeyserAvailable(Boolean isGeyserAvailable);

}