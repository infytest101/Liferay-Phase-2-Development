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
import ROOMSERVICES.model.AmenitiesModel;

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
 * The base model implementation for the Amenities service. Represents a row in the &quot;Infy_Amenities&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AmenitiesModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AmenitiesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmenitiesImpl
 * @generated
 */
public class AmenitiesModelImpl
	extends BaseModelImpl<Amenities> implements AmenitiesModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a amenities model instance should use the <code>Amenities</code> interface instead.
	 */
	public static final String TABLE_NAME = "Infy_Amenities";

	public static final Object[][] TABLE_COLUMNS = {
		{"amenitiesId", Types.INTEGER}, {"isACAvailable", Types.BOOLEAN},
		{"isSmokingAvailable", Types.BOOLEAN},
		{"isWifiAvailable", Types.BOOLEAN}, {"isTVAvailable", Types.BOOLEAN},
		{"isGeyserAvailable", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("amenitiesId", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("isACAvailable", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("isSmokingAvailable", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("isWifiAvailable", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("isTVAvailable", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("isGeyserAvailable", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Infy_Amenities (amenitiesId INTEGER not null primary key,isACAvailable BOOLEAN,isSmokingAvailable BOOLEAN,isWifiAvailable BOOLEAN,isTVAvailable BOOLEAN,isGeyserAvailable BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table Infy_Amenities";

	public static final String ORDER_BY_JPQL =
		" ORDER BY amenities.amenitiesId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Infy_Amenities.amenitiesId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long AMENITIESID_COLUMN_BITMASK = 1L;

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

	public AmenitiesModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _amenitiesId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setAmenitiesId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _amenitiesId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Amenities.class;
	}

	@Override
	public String getModelClassName() {
		return Amenities.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Amenities, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Amenities, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Amenities, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Amenities)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Amenities, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Amenities, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Amenities)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Amenities, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Amenities, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Amenities>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Amenities.class.getClassLoader(), Amenities.class,
			ModelWrapper.class);

		try {
			Constructor<Amenities> constructor =
				(Constructor<Amenities>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Amenities, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Amenities, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Amenities, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Amenities, Object>>();
		Map<String, BiConsumer<Amenities, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Amenities, ?>>();

		attributeGetterFunctions.put("amenitiesId", Amenities::getAmenitiesId);
		attributeSetterBiConsumers.put(
			"amenitiesId",
			(BiConsumer<Amenities, Integer>)Amenities::setAmenitiesId);
		attributeGetterFunctions.put(
			"isACAvailable", Amenities::getIsACAvailable);
		attributeSetterBiConsumers.put(
			"isACAvailable",
			(BiConsumer<Amenities, Boolean>)Amenities::setIsACAvailable);
		attributeGetterFunctions.put(
			"isSmokingAvailable", Amenities::getIsSmokingAvailable);
		attributeSetterBiConsumers.put(
			"isSmokingAvailable",
			(BiConsumer<Amenities, Boolean>)Amenities::setIsSmokingAvailable);
		attributeGetterFunctions.put(
			"isWifiAvailable", Amenities::getIsWifiAvailable);
		attributeSetterBiConsumers.put(
			"isWifiAvailable",
			(BiConsumer<Amenities, Boolean>)Amenities::setIsWifiAvailable);
		attributeGetterFunctions.put(
			"isTVAvailable", Amenities::getIsTVAvailable);
		attributeSetterBiConsumers.put(
			"isTVAvailable",
			(BiConsumer<Amenities, Boolean>)Amenities::setIsTVAvailable);
		attributeGetterFunctions.put(
			"isGeyserAvailable", Amenities::getIsGeyserAvailable);
		attributeSetterBiConsumers.put(
			"isGeyserAvailable",
			(BiConsumer<Amenities, Boolean>)Amenities::setIsGeyserAvailable);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
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
	public Boolean getIsACAvailable() {
		return _isACAvailable;
	}

	@Override
	public void setIsACAvailable(Boolean isACAvailable) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isACAvailable = isACAvailable;
	}

	@Override
	public Boolean getIsSmokingAvailable() {
		return _isSmokingAvailable;
	}

	@Override
	public void setIsSmokingAvailable(Boolean isSmokingAvailable) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isSmokingAvailable = isSmokingAvailable;
	}

	@Override
	public Boolean getIsWifiAvailable() {
		return _isWifiAvailable;
	}

	@Override
	public void setIsWifiAvailable(Boolean isWifiAvailable) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isWifiAvailable = isWifiAvailable;
	}

	@Override
	public Boolean getIsTVAvailable() {
		return _isTVAvailable;
	}

	@Override
	public void setIsTVAvailable(Boolean isTVAvailable) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isTVAvailable = isTVAvailable;
	}

	@Override
	public Boolean getIsGeyserAvailable() {
		return _isGeyserAvailable;
	}

	@Override
	public void setIsGeyserAvailable(Boolean isGeyserAvailable) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isGeyserAvailable = isGeyserAvailable;
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
	public Amenities toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Amenities>
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
		AmenitiesImpl amenitiesImpl = new AmenitiesImpl();

		amenitiesImpl.setAmenitiesId(getAmenitiesId());
		amenitiesImpl.setIsACAvailable(getIsACAvailable());
		amenitiesImpl.setIsSmokingAvailable(getIsSmokingAvailable());
		amenitiesImpl.setIsWifiAvailable(getIsWifiAvailable());
		amenitiesImpl.setIsTVAvailable(getIsTVAvailable());
		amenitiesImpl.setIsGeyserAvailable(getIsGeyserAvailable());

		amenitiesImpl.resetOriginalValues();

		return amenitiesImpl;
	}

	@Override
	public int compareTo(Amenities amenities) {
		int primaryKey = amenities.getPrimaryKey();

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

		if (!(object instanceof Amenities)) {
			return false;
		}

		Amenities amenities = (Amenities)object;

		int primaryKey = amenities.getPrimaryKey();

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
	public CacheModel<Amenities> toCacheModel() {
		AmenitiesCacheModel amenitiesCacheModel = new AmenitiesCacheModel();

		amenitiesCacheModel.amenitiesId = getAmenitiesId();

		Boolean isACAvailable = getIsACAvailable();

		if (isACAvailable != null) {
			amenitiesCacheModel.isACAvailable = isACAvailable;
		}

		Boolean isSmokingAvailable = getIsSmokingAvailable();

		if (isSmokingAvailable != null) {
			amenitiesCacheModel.isSmokingAvailable = isSmokingAvailable;
		}

		Boolean isWifiAvailable = getIsWifiAvailable();

		if (isWifiAvailable != null) {
			amenitiesCacheModel.isWifiAvailable = isWifiAvailable;
		}

		Boolean isTVAvailable = getIsTVAvailable();

		if (isTVAvailable != null) {
			amenitiesCacheModel.isTVAvailable = isTVAvailable;
		}

		Boolean isGeyserAvailable = getIsGeyserAvailable();

		if (isGeyserAvailable != null) {
			amenitiesCacheModel.isGeyserAvailable = isGeyserAvailable;
		}

		return amenitiesCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Amenities, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Amenities, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Amenities, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Amenities)this);

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
		Map<String, Function<Amenities, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Amenities, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Amenities, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Amenities)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Amenities>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private int _amenitiesId;
	private Boolean _isACAvailable;
	private Boolean _isSmokingAvailable;
	private Boolean _isWifiAvailable;
	private Boolean _isTVAvailable;
	private Boolean _isGeyserAvailable;

	public <T> T getColumnValue(String columnName) {
		Function<Amenities, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Amenities)this);
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

		_columnOriginalValues.put("amenitiesId", _amenitiesId);
		_columnOriginalValues.put("isACAvailable", _isACAvailable);
		_columnOriginalValues.put("isSmokingAvailable", _isSmokingAvailable);
		_columnOriginalValues.put("isWifiAvailable", _isWifiAvailable);
		_columnOriginalValues.put("isTVAvailable", _isTVAvailable);
		_columnOriginalValues.put("isGeyserAvailable", _isGeyserAvailable);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("amenitiesId", 1L);

		columnBitmasks.put("isACAvailable", 2L);

		columnBitmasks.put("isSmokingAvailable", 4L);

		columnBitmasks.put("isWifiAvailable", 8L);

		columnBitmasks.put("isTVAvailable", 16L);

		columnBitmasks.put("isGeyserAvailable", 32L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Amenities _escapedModel;

}