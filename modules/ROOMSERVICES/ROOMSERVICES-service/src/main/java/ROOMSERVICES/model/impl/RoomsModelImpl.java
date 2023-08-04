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

import ROOMSERVICES.model.Rooms;
import ROOMSERVICES.model.RoomsModel;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

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
 * The base model implementation for the Rooms service. Represents a row in the &quot;Infy_Rooms&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>RoomsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RoomsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoomsImpl
 * @generated
 */
public class RoomsModelImpl extends BaseModelImpl<Rooms> implements RoomsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a rooms model instance should use the <code>Rooms</code> interface instead.
	 */
	public static final String TABLE_NAME = "Infy_Rooms";

	public static final Object[][] TABLE_COLUMNS = {
		{"roomId", Types.INTEGER}, {"roomTypeId", Types.INTEGER},
		{"amenitiesId", Types.INTEGER}, {"roomName", Types.VARCHAR},
		{"totalRoomsAvailable", Types.INTEGER}, {"createDate", Types.TIMESTAMP},
		{"createBy", Types.VARCHAR}, {"updateDate", Types.TIMESTAMP},
		{"updatedBy", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("roomId", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("roomTypeId", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("amenitiesId", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("roomName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("totalRoomsAvailable", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("createBy", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("updateDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("updatedBy", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Infy_Rooms (roomId INTEGER not null primary key,roomTypeId INTEGER,amenitiesId INTEGER,roomName VARCHAR(75) null,totalRoomsAvailable INTEGER,createDate DATE null,createBy VARCHAR(75) null,updateDate DATE null,updatedBy VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table Infy_Rooms";

	public static final String ORDER_BY_JPQL = " ORDER BY rooms.roomId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY Infy_Rooms.roomId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ROOMID_COLUMN_BITMASK = 1L;

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

	public RoomsModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _roomId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setRoomId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _roomId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Rooms.class;
	}

	@Override
	public String getModelClassName() {
		return Rooms.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Rooms, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Rooms, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Rooms, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Rooms)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Rooms, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Rooms, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Rooms)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Rooms, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Rooms, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Rooms>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Rooms.class.getClassLoader(), Rooms.class, ModelWrapper.class);

		try {
			Constructor<Rooms> constructor =
				(Constructor<Rooms>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Rooms, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Rooms, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Rooms, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Rooms, Object>>();
		Map<String, BiConsumer<Rooms, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Rooms, ?>>();

		attributeGetterFunctions.put("roomId", Rooms::getRoomId);
		attributeSetterBiConsumers.put(
			"roomId", (BiConsumer<Rooms, Integer>)Rooms::setRoomId);
		attributeGetterFunctions.put("roomTypeId", Rooms::getRoomTypeId);
		attributeSetterBiConsumers.put(
			"roomTypeId", (BiConsumer<Rooms, Integer>)Rooms::setRoomTypeId);
		attributeGetterFunctions.put("amenitiesId", Rooms::getAmenitiesId);
		attributeSetterBiConsumers.put(
			"amenitiesId", (BiConsumer<Rooms, Integer>)Rooms::setAmenitiesId);
		attributeGetterFunctions.put("roomName", Rooms::getRoomName);
		attributeSetterBiConsumers.put(
			"roomName", (BiConsumer<Rooms, String>)Rooms::setRoomName);
		attributeGetterFunctions.put(
			"totalRoomsAvailable", Rooms::getTotalRoomsAvailable);
		attributeSetterBiConsumers.put(
			"totalRoomsAvailable",
			(BiConsumer<Rooms, Integer>)Rooms::setTotalRoomsAvailable);
		attributeGetterFunctions.put("createDate", Rooms::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Rooms, Date>)Rooms::setCreateDate);
		attributeGetterFunctions.put("createBy", Rooms::getCreateBy);
		attributeSetterBiConsumers.put(
			"createBy", (BiConsumer<Rooms, String>)Rooms::setCreateBy);
		attributeGetterFunctions.put("updateDate", Rooms::getUpdateDate);
		attributeSetterBiConsumers.put(
			"updateDate", (BiConsumer<Rooms, Date>)Rooms::setUpdateDate);
		attributeGetterFunctions.put("updatedBy", Rooms::getUpdatedBy);
		attributeSetterBiConsumers.put(
			"updatedBy", (BiConsumer<Rooms, String>)Rooms::setUpdatedBy);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public int getRoomId() {
		return _roomId;
	}

	@Override
	public void setRoomId(int roomId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_roomId = roomId;
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
	public int getAmenitiesId() {
		return _amenitiesId;
	}

	@Override
	public void setAmenitiesId(int amenitiesId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_amenitiesId = amenitiesId;
	}

	@Override
	public String getRoomName() {
		if (_roomName == null) {
			return "";
		}
		else {
			return _roomName;
		}
	}

	@Override
	public void setRoomName(String roomName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_roomName = roomName;
	}

	@Override
	public int getTotalRoomsAvailable() {
		return _totalRoomsAvailable;
	}

	@Override
	public void setTotalRoomsAvailable(int totalRoomsAvailable) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_totalRoomsAvailable = totalRoomsAvailable;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public String getCreateBy() {
		if (_createBy == null) {
			return "";
		}
		else {
			return _createBy;
		}
	}

	@Override
	public void setCreateBy(String createBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createBy = createBy;
	}

	@Override
	public Date getUpdateDate() {
		return _updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_updateDate = updateDate;
	}

	@Override
	public String getUpdatedBy() {
		if (_updatedBy == null) {
			return "";
		}
		else {
			return _updatedBy;
		}
	}

	@Override
	public void setUpdatedBy(String updatedBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_updatedBy = updatedBy;
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
	public Rooms toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Rooms>
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
		RoomsImpl roomsImpl = new RoomsImpl();

		roomsImpl.setRoomId(getRoomId());
		roomsImpl.setRoomTypeId(getRoomTypeId());
		roomsImpl.setAmenitiesId(getAmenitiesId());
		roomsImpl.setRoomName(getRoomName());
		roomsImpl.setTotalRoomsAvailable(getTotalRoomsAvailable());
		roomsImpl.setCreateDate(getCreateDate());
		roomsImpl.setCreateBy(getCreateBy());
		roomsImpl.setUpdateDate(getUpdateDate());
		roomsImpl.setUpdatedBy(getUpdatedBy());

		roomsImpl.resetOriginalValues();

		return roomsImpl;
	}

	@Override
	public int compareTo(Rooms rooms) {
		int primaryKey = rooms.getPrimaryKey();

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

		if (!(object instanceof Rooms)) {
			return false;
		}

		Rooms rooms = (Rooms)object;

		int primaryKey = rooms.getPrimaryKey();

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
	public CacheModel<Rooms> toCacheModel() {
		RoomsCacheModel roomsCacheModel = new RoomsCacheModel();

		roomsCacheModel.roomId = getRoomId();

		roomsCacheModel.roomTypeId = getRoomTypeId();

		roomsCacheModel.amenitiesId = getAmenitiesId();

		roomsCacheModel.roomName = getRoomName();

		String roomName = roomsCacheModel.roomName;

		if ((roomName != null) && (roomName.length() == 0)) {
			roomsCacheModel.roomName = null;
		}

		roomsCacheModel.totalRoomsAvailable = getTotalRoomsAvailable();

		Date createDate = getCreateDate();

		if (createDate != null) {
			roomsCacheModel.createDate = createDate.getTime();
		}
		else {
			roomsCacheModel.createDate = Long.MIN_VALUE;
		}

		roomsCacheModel.createBy = getCreateBy();

		String createBy = roomsCacheModel.createBy;

		if ((createBy != null) && (createBy.length() == 0)) {
			roomsCacheModel.createBy = null;
		}

		Date updateDate = getUpdateDate();

		if (updateDate != null) {
			roomsCacheModel.updateDate = updateDate.getTime();
		}
		else {
			roomsCacheModel.updateDate = Long.MIN_VALUE;
		}

		roomsCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = roomsCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			roomsCacheModel.updatedBy = null;
		}

		return roomsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Rooms, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Rooms, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Rooms, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Rooms)this);

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
		Map<String, Function<Rooms, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Rooms, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Rooms, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Rooms)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Rooms>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private int _roomId;
	private int _roomTypeId;
	private int _amenitiesId;
	private String _roomName;
	private int _totalRoomsAvailable;
	private Date _createDate;
	private String _createBy;
	private Date _updateDate;
	private String _updatedBy;

	public <T> T getColumnValue(String columnName) {
		Function<Rooms, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Rooms)this);
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

		_columnOriginalValues.put("roomId", _roomId);
		_columnOriginalValues.put("roomTypeId", _roomTypeId);
		_columnOriginalValues.put("amenitiesId", _amenitiesId);
		_columnOriginalValues.put("roomName", _roomName);
		_columnOriginalValues.put("totalRoomsAvailable", _totalRoomsAvailable);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("createBy", _createBy);
		_columnOriginalValues.put("updateDate", _updateDate);
		_columnOriginalValues.put("updatedBy", _updatedBy);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("roomId", 1L);

		columnBitmasks.put("roomTypeId", 2L);

		columnBitmasks.put("amenitiesId", 4L);

		columnBitmasks.put("roomName", 8L);

		columnBitmasks.put("totalRoomsAvailable", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("createBy", 64L);

		columnBitmasks.put("updateDate", 128L);

		columnBitmasks.put("updatedBy", 256L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Rooms _escapedModel;

}