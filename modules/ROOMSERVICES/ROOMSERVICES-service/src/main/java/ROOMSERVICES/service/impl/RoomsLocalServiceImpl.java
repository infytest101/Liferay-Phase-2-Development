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

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import ROOMSERVICES.exception.NoSuchRoomsException;
import ROOMSERVICES.model.Rooms;
import ROOMSERVICES.service.base.RoomsLocalServiceBaseImpl;
/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=ROOMSERVICES.model.Rooms", service = AopService.class)
public class RoomsLocalServiceImpl extends RoomsLocalServiceBaseImpl {
	
	private static final Log LOGGER = LogFactoryUtil.getLog(RoomsLocalServiceImpl.class);

		public Rooms findByRoomName(String roomName) throws NoSuchRoomsException{
			LOGGER.info("inside findByRoomName():::::" );
			return this.roomsPersistence.findByRoomName(roomName);
			
		}
}