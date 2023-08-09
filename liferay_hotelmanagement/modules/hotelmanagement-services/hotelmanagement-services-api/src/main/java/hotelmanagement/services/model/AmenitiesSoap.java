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

package hotelmanagement.services.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AmenitiesSoap implements Serializable {

	public static AmenitiesSoap toSoapModel(Amenities model) {
		AmenitiesSoap soapModel = new AmenitiesSoap();

		soapModel.setAmenitiesId(model.getAmenitiesId());
		soapModel.setIsACAvailable(model.getIsACAvailable());
		soapModel.setIsSmokingAvailable(model.getIsSmokingAvailable());
		soapModel.setIsWifiAvailable(model.getIsWifiAvailable());
		soapModel.setIsTVAvailable(model.getIsTVAvailable());
		soapModel.setIsGeyserAvailable(model.getIsGeyserAvailable());

		return soapModel;
	}

	public static AmenitiesSoap[] toSoapModels(Amenities[] models) {
		AmenitiesSoap[] soapModels = new AmenitiesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AmenitiesSoap[][] toSoapModels(Amenities[][] models) {
		AmenitiesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AmenitiesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AmenitiesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AmenitiesSoap[] toSoapModels(List<Amenities> models) {
		List<AmenitiesSoap> soapModels = new ArrayList<AmenitiesSoap>(
			models.size());

		for (Amenities model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AmenitiesSoap[soapModels.size()]);
	}

	public AmenitiesSoap() {
	}

	public int getPrimaryKey() {
		return _amenitiesId;
	}

	public void setPrimaryKey(int pk) {
		setAmenitiesId(pk);
	}

	public int getAmenitiesId() {
		return _amenitiesId;
	}

	public void setAmenitiesId(int amenitiesId) {
		_amenitiesId = amenitiesId;
	}

	public Boolean getIsACAvailable() {
		return _isACAvailable;
	}

	public void setIsACAvailable(Boolean isACAvailable) {
		_isACAvailable = isACAvailable;
	}

	public Boolean getIsSmokingAvailable() {
		return _isSmokingAvailable;
	}

	public void setIsSmokingAvailable(Boolean isSmokingAvailable) {
		_isSmokingAvailable = isSmokingAvailable;
	}

	public Boolean getIsWifiAvailable() {
		return _isWifiAvailable;
	}

	public void setIsWifiAvailable(Boolean isWifiAvailable) {
		_isWifiAvailable = isWifiAvailable;
	}

	public Boolean getIsTVAvailable() {
		return _isTVAvailable;
	}

	public void setIsTVAvailable(Boolean isTVAvailable) {
		_isTVAvailable = isTVAvailable;
	}

	public Boolean getIsGeyserAvailable() {
		return _isGeyserAvailable;
	}

	public void setIsGeyserAvailable(Boolean isGeyserAvailable) {
		_isGeyserAvailable = isGeyserAvailable;
	}

	private int _amenitiesId;
	private Boolean _isACAvailable;
	private Boolean _isSmokingAvailable;
	private Boolean _isWifiAvailable;
	private Boolean _isTVAvailable;
	private Boolean _isGeyserAvailable;

}