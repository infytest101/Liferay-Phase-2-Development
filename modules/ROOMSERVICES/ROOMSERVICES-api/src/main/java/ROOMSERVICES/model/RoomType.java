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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the RoomType service. Represents a row in the &quot;Infy_RoomType&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see RoomTypeModel
 * @generated
 */
@ImplementationClassName("ROOMSERVICES.model.impl.RoomTypeImpl")
@ProviderType
public interface RoomType extends PersistedModel, RoomTypeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>ROOMSERVICES.model.impl.RoomTypeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<RoomType, Integer> ROOM_TYPE_ID_ACCESSOR =
		new Accessor<RoomType, Integer>() {

			@Override
			public Integer get(RoomType roomType) {
				return roomType.getRoomTypeId();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<RoomType> getTypeClass() {
				return RoomType.class;
			}

		};
	public static final Accessor<RoomType, String> ROOM_TYPE_ACCESSOR =
		new Accessor<RoomType, String>() {

			@Override
			public String get(RoomType roomType) {
				return roomType.getRoomType();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<RoomType> getTypeClass() {
				return RoomType.class;
			}

		};

}