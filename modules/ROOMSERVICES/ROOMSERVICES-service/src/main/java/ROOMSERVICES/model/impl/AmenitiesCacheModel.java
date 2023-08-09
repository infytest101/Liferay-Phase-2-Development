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

package ROOMSERVICES.model.impl;

import ROOMSERVICES.model.Amenities;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Amenities in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AmenitiesCacheModel
	implements CacheModel<Amenities>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AmenitiesCacheModel)) {
			return false;
		}

		AmenitiesCacheModel amenitiesCacheModel = (AmenitiesCacheModel)object;

		if (amenitiesId == amenitiesCacheModel.amenitiesId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, amenitiesId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{amenitiesId=");
		sb.append(amenitiesId);
		sb.append(", isACAvailable=");
		sb.append(isACAvailable);
		sb.append(", isSmokingAvailable=");
		sb.append(isSmokingAvailable);
		sb.append(", isWifiAvailable=");
		sb.append(isWifiAvailable);
		sb.append(", isTVAvailable=");
		sb.append(isTVAvailable);
		sb.append(", isGeyserAvailable=");
		sb.append(isGeyserAvailable);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Amenities toEntityModel() {
		AmenitiesImpl amenitiesImpl = new AmenitiesImpl();

		amenitiesImpl.setAmenitiesId(amenitiesId);
		amenitiesImpl.setIsACAvailable(isACAvailable);
		amenitiesImpl.setIsSmokingAvailable(isSmokingAvailable);
		amenitiesImpl.setIsWifiAvailable(isWifiAvailable);
		amenitiesImpl.setIsTVAvailable(isTVAvailable);
		amenitiesImpl.setIsGeyserAvailable(isGeyserAvailable);

		amenitiesImpl.resetOriginalValues();

		return amenitiesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		amenitiesId = objectInput.readLong();

		isACAvailable = objectInput.readBoolean();

		isSmokingAvailable = objectInput.readBoolean();

		isWifiAvailable = objectInput.readBoolean();

		isTVAvailable = objectInput.readBoolean();

		isGeyserAvailable = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(amenitiesId);

		objectOutput.writeBoolean(isACAvailable);

		objectOutput.writeBoolean(isSmokingAvailable);

		objectOutput.writeBoolean(isWifiAvailable);

		objectOutput.writeBoolean(isTVAvailable);

		objectOutput.writeBoolean(isGeyserAvailable);
	}

	public long amenitiesId;
	public boolean isACAvailable;
	public boolean isSmokingAvailable;
	public boolean isWifiAvailable;
	public boolean isTVAvailable;
	public boolean isGeyserAvailable;

}