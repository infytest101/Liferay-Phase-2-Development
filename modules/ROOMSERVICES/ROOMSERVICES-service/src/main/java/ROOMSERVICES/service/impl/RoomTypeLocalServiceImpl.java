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

package ROOMSERVICES.service.impl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.SystemException;

import ROOMSERVICES.model.RoomType;
import ROOMSERVICES.service.base.RoomTypeLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=ROOMSERVICES.model.RoomType",
	service = AopService.class
)
public class RoomTypeLocalServiceImpl extends RoomTypeLocalServiceBaseImpl {
	
	public List<RoomType>findByroomType(String RoomType) throws SystemException {
		return this.roomTypePersistence.findByRoomType(RoomType);
	}
	
}