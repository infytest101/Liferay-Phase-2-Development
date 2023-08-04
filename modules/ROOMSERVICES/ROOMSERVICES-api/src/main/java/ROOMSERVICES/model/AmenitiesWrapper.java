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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Amenities}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Amenities
 * @generated
 */
public class AmenitiesWrapper
	extends BaseModelWrapper<Amenities>
	implements Amenities, ModelWrapper<Amenities> {

	public AmenitiesWrapper(Amenities amenities) {
		super(amenities);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("amenitiesId", getAmenitiesId());
		attributes.put("isACAvailable", getIsACAvailable());
		attributes.put("isSmokingAvailable", getIsSmokingAvailable());
		attributes.put("isWifiAvailable", getIsWifiAvailable());
		attributes.put("isTVAvailable", getIsTVAvailable());
		attributes.put("isGeyserAvailable", getIsGeyserAvailable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer amenitiesId = (Integer)attributes.get("amenitiesId");

		if (amenitiesId != null) {
			setAmenitiesId(amenitiesId);
		}

		Boolean isACAvailable = (Boolean)attributes.get("isACAvailable");

		if (isACAvailable != null) {
			setIsACAvailable(isACAvailable);
		}

		Boolean isSmokingAvailable = (Boolean)attributes.get(
			"isSmokingAvailable");

		if (isSmokingAvailable != null) {
			setIsSmokingAvailable(isSmokingAvailable);
		}

		Boolean isWifiAvailable = (Boolean)attributes.get("isWifiAvailable");

		if (isWifiAvailable != null) {
			setIsWifiAvailable(isWifiAvailable);
		}

		Boolean isTVAvailable = (Boolean)attributes.get("isTVAvailable");

		if (isTVAvailable != null) {
			setIsTVAvailable(isTVAvailable);
		}

		Boolean isGeyserAvailable = (Boolean)attributes.get(
			"isGeyserAvailable");

		if (isGeyserAvailable != null) {
			setIsGeyserAvailable(isGeyserAvailable);
		}
	}

	/**
	 * Returns the amenities ID of this amenities.
	 *
	 * @return the amenities ID of this amenities
	 */
	@Override
	public int getAmenitiesId() {
		return model.getAmenitiesId();
	}

	/**
	 * Returns the is ac available of this amenities.
	 *
	 * @return the is ac available of this amenities
	 */
	@Override
	public Boolean getIsACAvailable() {
		return model.getIsACAvailable();
	}

	/**
	 * Returns the is geyser available of this amenities.
	 *
	 * @return the is geyser available of this amenities
	 */
	@Override
	public Boolean getIsGeyserAvailable() {
		return model.getIsGeyserAvailable();
	}

	/**
	 * Returns the is smoking available of this amenities.
	 *
	 * @return the is smoking available of this amenities
	 */
	@Override
	public Boolean getIsSmokingAvailable() {
		return model.getIsSmokingAvailable();
	}

	/**
	 * Returns the is tv available of this amenities.
	 *
	 * @return the is tv available of this amenities
	 */
	@Override
	public Boolean getIsTVAvailable() {
		return model.getIsTVAvailable();
	}

	/**
	 * Returns the is wifi available of this amenities.
	 *
	 * @return the is wifi available of this amenities
	 */
	@Override
	public Boolean getIsWifiAvailable() {
		return model.getIsWifiAvailable();
	}

	/**
	 * Returns the primary key of this amenities.
	 *
	 * @return the primary key of this amenities
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the amenities ID of this amenities.
	 *
	 * @param amenitiesId the amenities ID of this amenities
	 */
	@Override
	public void setAmenitiesId(int amenitiesId) {
		model.setAmenitiesId(amenitiesId);
	}

	/**
	 * Sets the is ac available of this amenities.
	 *
	 * @param isACAvailable the is ac available of this amenities
	 */
	@Override
	public void setIsACAvailable(Boolean isACAvailable) {
		model.setIsACAvailable(isACAvailable);
	}

	/**
	 * Sets the is geyser available of this amenities.
	 *
	 * @param isGeyserAvailable the is geyser available of this amenities
	 */
	@Override
	public void setIsGeyserAvailable(Boolean isGeyserAvailable) {
		model.setIsGeyserAvailable(isGeyserAvailable);
	}

	/**
	 * Sets the is smoking available of this amenities.
	 *
	 * @param isSmokingAvailable the is smoking available of this amenities
	 */
	@Override
	public void setIsSmokingAvailable(Boolean isSmokingAvailable) {
		model.setIsSmokingAvailable(isSmokingAvailable);
	}

	/**
	 * Sets the is tv available of this amenities.
	 *
	 * @param isTVAvailable the is tv available of this amenities
	 */
	@Override
	public void setIsTVAvailable(Boolean isTVAvailable) {
		model.setIsTVAvailable(isTVAvailable);
	}

	/**
	 * Sets the is wifi available of this amenities.
	 *
	 * @param isWifiAvailable the is wifi available of this amenities
	 */
	@Override
	public void setIsWifiAvailable(Boolean isWifiAvailable) {
		model.setIsWifiAvailable(isWifiAvailable);
	}

	/**
	 * Sets the primary key of this amenities.
	 *
	 * @param primaryKey the primary key of this amenities
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected AmenitiesWrapper wrap(Amenities amenities) {
		return new AmenitiesWrapper(amenities);
	}

}