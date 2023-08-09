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

package hotelmanagement.services.service.impl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;

import hotelmanagement.services.model.Amenities;
import hotelmanagement.services.service.base.AmenitiesLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=hotelmanagement.services.model.Amenities",
	service = AopService.class
)
public class AmenitiesLocalServiceImpl extends AmenitiesLocalServiceBaseImpl {
	
	public List<Amenities> findByIsWifiAvailable(Boolean isWifiAvailable) {
		return this.amenitiesPersistence.findByIsWifiAvailable(isWifiAvailable);
	}

	public List<Amenities> findByIsWifiTvGeyserAvailable(Boolean isWifiAvailable, Boolean isTVAvailable,
			Boolean isGeyserAvailable) {
		return this.amenitiesPersistence.findByIsWifiTvGeyserAvailable(isWifiAvailable, isTVAvailable,
				isGeyserAvailable);
	}
}