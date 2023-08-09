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

package hotelmanagement.services.model.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import hotelmanagement.services.model.RoomType;
import hotelmanagement.services.model.RoomTypeModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the RoomType service. Represents a row in the &quot;Hotel_RoomType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>RoomTypeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RoomTypeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomTypeImpl
 * @generated
 */
public class RoomTypeModelImpl
	extends BaseModelImpl<RoomType> implements RoomTypeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a room type model instance should use the <code>RoomType</code> interface instead.
	 */
	public static final String TABLE_NAME = "Hotel_RoomType";

	public static final Object[][] TABLE_COLUMNS = {
		{"roomTypeId", Types.INTEGER}, {"RoomType", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("roomTypeId", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("RoomType", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Hotel_RoomType (roomTypeId INTEGER not null primary key,RoomType VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table Hotel_RoomType";

	public static final String ORDER_BY_JPQL =
		" ORDER BY roomType.roomTypeId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Hotel_RoomType.roomTypeId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ROOMTYPE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ROOMTYPEID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public RoomTypeModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _roomTypeId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setRoomTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _roomTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RoomType.class;
	}

	@Override
	public String getModelClassName() {
		return RoomType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<RoomType, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<RoomType, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RoomType, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((RoomType)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<RoomType, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<RoomType, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(RoomType)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<RoomType, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<RoomType, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, RoomType>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			RoomType.class.getClassLoader(), RoomType.class,
			ModelWrapper.class);

		try {
			Constructor<RoomType> constructor =
				(Constructor<RoomType>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<RoomType, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<RoomType, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<RoomType, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<RoomType, Object>>();
		Map<String, BiConsumer<RoomType, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<RoomType, ?>>();

		attributeGetterFunctions.put("roomTypeId", RoomType::getRoomTypeId);
		attributeSetterBiConsumers.put(
			"roomTypeId",
			(BiConsumer<RoomType, Integer>)RoomType::setRoomTypeId);
		attributeGetterFunctions.put("RoomType", RoomType::getRoomType);
		attributeSetterBiConsumers.put(
			"RoomType", (BiConsumer<RoomType, String>)RoomType::setRoomType);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public int getRoomTypeId() {
		return _roomTypeId;
	}

	@Override
	public void setRoomTypeId(int roomTypeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_roomTypeId = roomTypeId;
	}

	@Override
	public String getRoomType() {
		if (_RoomType == null) {
			return "";
		}
		else {
			return _RoomType;
		}
	}

	@Override
	public void setRoomType(String RoomType) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_RoomType = RoomType;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalRoomType() {
		return getColumnOriginalValue("RoomType");
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public RoomType toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, RoomType>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RoomTypeImpl roomTypeImpl = new RoomTypeImpl();

		roomTypeImpl.setRoomTypeId(getRoomTypeId());
		roomTypeImpl.setRoomType(getRoomType());

		roomTypeImpl.resetOriginalValues();

		return roomTypeImpl;
	}

	@Override
	public int compareTo(RoomType roomType) {
		int primaryKey = roomType.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RoomType)) {
			return false;
		}

		RoomType roomType = (RoomType)object;

		int primaryKey = roomType.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<RoomType> toCacheModel() {
		RoomTypeCacheModel roomTypeCacheModel = new RoomTypeCacheModel();

		roomTypeCacheModel.roomTypeId = getRoomTypeId();

		roomTypeCacheModel.RoomType = getRoomType();

		String RoomType = roomTypeCacheModel.RoomType;

		if ((RoomType != null) && (RoomType.length() == 0)) {
			roomTypeCacheModel.RoomType = null;
		}

		return roomTypeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<RoomType, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<RoomType, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RoomType, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((RoomType)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<RoomType, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<RoomType, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RoomType, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((RoomType)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, RoomType>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private int _roomTypeId;
	private String _RoomType;

	public <T> T getColumnValue(String columnName) {
		Function<RoomType, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((RoomType)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("roomTypeId", _roomTypeId);
		_columnOriginalValues.put("RoomType", _RoomType);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("roomTypeId", 1L);

		columnBitmasks.put("RoomType", 2L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private RoomType _escapedModel;

}