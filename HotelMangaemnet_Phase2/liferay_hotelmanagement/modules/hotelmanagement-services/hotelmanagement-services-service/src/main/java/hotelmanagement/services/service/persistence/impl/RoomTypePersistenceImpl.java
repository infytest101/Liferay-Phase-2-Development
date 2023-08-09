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

package hotelmanagement.services.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import hotelmanagement.services.exception.NoSuchRoomTypeException;
import hotelmanagement.services.model.RoomType;
import hotelmanagement.services.model.impl.RoomTypeImpl;
import hotelmanagement.services.model.impl.RoomTypeModelImpl;
import hotelmanagement.services.service.persistence.RoomTypePersistence;
import hotelmanagement.services.service.persistence.RoomTypeUtil;
import hotelmanagement.services.service.persistence.impl.constants.HotelPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the room type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RoomTypePersistence.class)
public class RoomTypePersistenceImpl
	extends BasePersistenceImpl<RoomType> implements RoomTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RoomTypeUtil</code> to access the room type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RoomTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByRoomType;
	private FinderPath _finderPathWithoutPaginationFindByRoomType;
	private FinderPath _finderPathCountByRoomType;

	/**
	 * Returns all the room types where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @return the matching room types
	 */
	@Override
	public List<RoomType> findByRoomType(String RoomType) {
		return findByRoomType(
			RoomType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the room types where RoomType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomTypeModelImpl</code>.
	 * </p>
	 *
	 * @param RoomType the room type
	 * @param start the lower bound of the range of room types
	 * @param end the upper bound of the range of room types (not inclusive)
	 * @return the range of matching room types
	 */
	@Override
	public List<RoomType> findByRoomType(String RoomType, int start, int end) {
		return findByRoomType(RoomType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the room types where RoomType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomTypeModelImpl</code>.
	 * </p>
	 *
	 * @param RoomType the room type
	 * @param start the lower bound of the range of room types
	 * @param end the upper bound of the range of room types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching room types
	 */
	@Override
	public List<RoomType> findByRoomType(
		String RoomType, int start, int end,
		OrderByComparator<RoomType> orderByComparator) {

		return findByRoomType(RoomType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the room types where RoomType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomTypeModelImpl</code>.
	 * </p>
	 *
	 * @param RoomType the room type
	 * @param start the lower bound of the range of room types
	 * @param end the upper bound of the range of room types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching room types
	 */
	@Override
	public List<RoomType> findByRoomType(
		String RoomType, int start, int end,
		OrderByComparator<RoomType> orderByComparator, boolean useFinderCache) {

		RoomType = Objects.toString(RoomType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRoomType;
				finderArgs = new Object[] {RoomType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRoomType;
			finderArgs = new Object[] {RoomType, start, end, orderByComparator};
		}

		List<RoomType> list = null;

		if (useFinderCache) {
			list = (List<RoomType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RoomType roomType : list) {
					if (!RoomType.equals(roomType.getRoomType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ROOMTYPE_WHERE);

			boolean bindRoomType = false;

			if (RoomType.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROOMTYPE_ROOMTYPE_3);
			}
			else {
				bindRoomType = true;

				sb.append(_FINDER_COLUMN_ROOMTYPE_ROOMTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RoomTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRoomType) {
					queryPos.add(RoomType);
				}

				list = (List<RoomType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first room type in the ordered set where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room type
	 * @throws NoSuchRoomTypeException if a matching room type could not be found
	 */
	@Override
	public RoomType findByRoomType_First(
			String RoomType, OrderByComparator<RoomType> orderByComparator)
		throws NoSuchRoomTypeException {

		RoomType roomType = fetchByRoomType_First(RoomType, orderByComparator);

		if (roomType != null) {
			return roomType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("RoomType=");
		sb.append(RoomType);

		sb.append("}");

		throw new NoSuchRoomTypeException(sb.toString());
	}

	/**
	 * Returns the first room type in the ordered set where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching room type, or <code>null</code> if a matching room type could not be found
	 */
	@Override
	public RoomType fetchByRoomType_First(
		String RoomType, OrderByComparator<RoomType> orderByComparator) {

		List<RoomType> list = findByRoomType(RoomType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last room type in the ordered set where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room type
	 * @throws NoSuchRoomTypeException if a matching room type could not be found
	 */
	@Override
	public RoomType findByRoomType_Last(
			String RoomType, OrderByComparator<RoomType> orderByComparator)
		throws NoSuchRoomTypeException {

		RoomType roomType = fetchByRoomType_Last(RoomType, orderByComparator);

		if (roomType != null) {
			return roomType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("RoomType=");
		sb.append(RoomType);

		sb.append("}");

		throw new NoSuchRoomTypeException(sb.toString());
	}

	/**
	 * Returns the last room type in the ordered set where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching room type, or <code>null</code> if a matching room type could not be found
	 */
	@Override
	public RoomType fetchByRoomType_Last(
		String RoomType, OrderByComparator<RoomType> orderByComparator) {

		int count = countByRoomType(RoomType);

		if (count == 0) {
			return null;
		}

		List<RoomType> list = findByRoomType(
			RoomType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the room types before and after the current room type in the ordered set where RoomType = &#63;.
	 *
	 * @param roomTypeId the primary key of the current room type
	 * @param RoomType the room type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next room type
	 * @throws NoSuchRoomTypeException if a room type with the primary key could not be found
	 */
	@Override
	public RoomType[] findByRoomType_PrevAndNext(
			int roomTypeId, String RoomType,
			OrderByComparator<RoomType> orderByComparator)
		throws NoSuchRoomTypeException {

		RoomType = Objects.toString(RoomType, "");

		RoomType roomType = findByPrimaryKey(roomTypeId);

		Session session = null;

		try {
			session = openSession();

			RoomType[] array = new RoomTypeImpl[3];

			array[0] = getByRoomType_PrevAndNext(
				session, roomType, RoomType, orderByComparator, true);

			array[1] = roomType;

			array[2] = getByRoomType_PrevAndNext(
				session, roomType, RoomType, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RoomType getByRoomType_PrevAndNext(
		Session session, RoomType roomType, String RoomType,
		OrderByComparator<RoomType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ROOMTYPE_WHERE);

		boolean bindRoomType = false;

		if (RoomType.isEmpty()) {
			sb.append(_FINDER_COLUMN_ROOMTYPE_ROOMTYPE_3);
		}
		else {
			bindRoomType = true;

			sb.append(_FINDER_COLUMN_ROOMTYPE_ROOMTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(RoomTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRoomType) {
			queryPos.add(RoomType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(roomType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RoomType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the room types where RoomType = &#63; from the database.
	 *
	 * @param RoomType the room type
	 */
	@Override
	public void removeByRoomType(String RoomType) {
		for (RoomType roomType :
				findByRoomType(
					RoomType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(roomType);
		}
	}

	/**
	 * Returns the number of room types where RoomType = &#63;.
	 *
	 * @param RoomType the room type
	 * @return the number of matching room types
	 */
	@Override
	public int countByRoomType(String RoomType) {
		RoomType = Objects.toString(RoomType, "");

		FinderPath finderPath = _finderPathCountByRoomType;

		Object[] finderArgs = new Object[] {RoomType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROOMTYPE_WHERE);

			boolean bindRoomType = false;

			if (RoomType.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROOMTYPE_ROOMTYPE_3);
			}
			else {
				bindRoomType = true;

				sb.append(_FINDER_COLUMN_ROOMTYPE_ROOMTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRoomType) {
					queryPos.add(RoomType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ROOMTYPE_ROOMTYPE_2 =
		"roomType.RoomType = ?";

	private static final String _FINDER_COLUMN_ROOMTYPE_ROOMTYPE_3 =
		"(roomType.RoomType IS NULL OR roomType.RoomType = '')";

	public RoomTypePersistenceImpl() {
		setModelClass(RoomType.class);

		setModelImplClass(RoomTypeImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the room type in the entity cache if it is enabled.
	 *
	 * @param roomType the room type
	 */
	@Override
	public void cacheResult(RoomType roomType) {
		entityCache.putResult(
			RoomTypeImpl.class, roomType.getPrimaryKey(), roomType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the room types in the entity cache if it is enabled.
	 *
	 * @param roomTypes the room types
	 */
	@Override
	public void cacheResult(List<RoomType> roomTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (roomTypes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RoomType roomType : roomTypes) {
			if (entityCache.getResult(
					RoomTypeImpl.class, roomType.getPrimaryKey()) == null) {

				cacheResult(roomType);
			}
		}
	}

	/**
	 * Clears the cache for all room types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RoomTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the room type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RoomType roomType) {
		entityCache.removeResult(RoomTypeImpl.class, roomType);
	}

	@Override
	public void clearCache(List<RoomType> roomTypes) {
		for (RoomType roomType : roomTypes) {
			entityCache.removeResult(RoomTypeImpl.class, roomType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RoomTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new room type with the primary key. Does not add the room type to the database.
	 *
	 * @param roomTypeId the primary key for the new room type
	 * @return the new room type
	 */
	@Override
	public RoomType create(int roomTypeId) {
		RoomType roomType = new RoomTypeImpl();

		roomType.setNew(true);
		roomType.setPrimaryKey(roomTypeId);

		return roomType;
	}

	/**
	 * Removes the room type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomTypeId the primary key of the room type
	 * @return the room type that was removed
	 * @throws NoSuchRoomTypeException if a room type with the primary key could not be found
	 */
	@Override
	public RoomType remove(int roomTypeId) throws NoSuchRoomTypeException {
		return remove((Serializable)roomTypeId);
	}

	/**
	 * Removes the room type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the room type
	 * @return the room type that was removed
	 * @throws NoSuchRoomTypeException if a room type with the primary key could not be found
	 */
	@Override
	public RoomType remove(Serializable primaryKey)
		throws NoSuchRoomTypeException {

		Session session = null;

		try {
			session = openSession();

			RoomType roomType = (RoomType)session.get(
				RoomTypeImpl.class, primaryKey);

			if (roomType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRoomTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(roomType);
		}
		catch (NoSuchRoomTypeException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected RoomType removeImpl(RoomType roomType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(roomType)) {
				roomType = (RoomType)session.get(
					RoomTypeImpl.class, roomType.getPrimaryKeyObj());
			}

			if (roomType != null) {
				session.delete(roomType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (roomType != null) {
			clearCache(roomType);
		}

		return roomType;
	}

	@Override
	public RoomType updateImpl(RoomType roomType) {
		boolean isNew = roomType.isNew();

		if (!(roomType instanceof RoomTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(roomType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(roomType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in roomType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RoomType implementation " +
					roomType.getClass());
		}

		RoomTypeModelImpl roomTypeModelImpl = (RoomTypeModelImpl)roomType;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(roomType);
			}
			else {
				roomType = (RoomType)session.merge(roomType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RoomTypeImpl.class, roomTypeModelImpl, false, true);

		if (isNew) {
			roomType.setNew(false);
		}

		roomType.resetOriginalValues();

		return roomType;
	}

	/**
	 * Returns the room type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the room type
	 * @return the room type
	 * @throws NoSuchRoomTypeException if a room type with the primary key could not be found
	 */
	@Override
	public RoomType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRoomTypeException {

		RoomType roomType = fetchByPrimaryKey(primaryKey);

		if (roomType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRoomTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return roomType;
	}

	/**
	 * Returns the room type with the primary key or throws a <code>NoSuchRoomTypeException</code> if it could not be found.
	 *
	 * @param roomTypeId the primary key of the room type
	 * @return the room type
	 * @throws NoSuchRoomTypeException if a room type with the primary key could not be found
	 */
	@Override
	public RoomType findByPrimaryKey(int roomTypeId)
		throws NoSuchRoomTypeException {

		return findByPrimaryKey((Serializable)roomTypeId);
	}

	/**
	 * Returns the room type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roomTypeId the primary key of the room type
	 * @return the room type, or <code>null</code> if a room type with the primary key could not be found
	 */
	@Override
	public RoomType fetchByPrimaryKey(int roomTypeId) {
		return fetchByPrimaryKey((Serializable)roomTypeId);
	}

	/**
	 * Returns all the room types.
	 *
	 * @return the room types
	 */
	@Override
	public List<RoomType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the room types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of room types
	 * @param end the upper bound of the range of room types (not inclusive)
	 * @return the range of room types
	 */
	@Override
	public List<RoomType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the room types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of room types
	 * @param end the upper bound of the range of room types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of room types
	 */
	@Override
	public List<RoomType> findAll(
		int start, int end, OrderByComparator<RoomType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the room types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of room types
	 * @param end the upper bound of the range of room types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of room types
	 */
	@Override
	public List<RoomType> findAll(
		int start, int end, OrderByComparator<RoomType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<RoomType> list = null;

		if (useFinderCache) {
			list = (List<RoomType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ROOMTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ROOMTYPE;

				sql = sql.concat(RoomTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RoomType>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the room types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RoomType roomType : findAll()) {
			remove(roomType);
		}
	}

	/**
	 * Returns the number of room types.
	 *
	 * @return the number of room types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ROOMTYPE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "roomTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ROOMTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RoomTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the room type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new RoomTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", RoomType.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByRoomType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoomType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"RoomType"}, true);

		_finderPathWithoutPaginationFindByRoomType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRoomType",
			new String[] {String.class.getName()}, new String[] {"RoomType"},
			true);

		_finderPathCountByRoomType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoomType",
			new String[] {String.class.getName()}, new String[] {"RoomType"},
			false);

		_setRoomTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setRoomTypeUtilPersistence(null);

		entityCache.removeCache(RoomTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setRoomTypeUtilPersistence(
		RoomTypePersistence roomTypePersistence) {

		try {
			Field field = RoomTypeUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, roomTypePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = HotelPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = HotelPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = HotelPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ROOMTYPE =
		"SELECT roomType FROM RoomType roomType";

	private static final String _SQL_SELECT_ROOMTYPE_WHERE =
		"SELECT roomType FROM RoomType roomType WHERE ";

	private static final String _SQL_COUNT_ROOMTYPE =
		"SELECT COUNT(roomType) FROM RoomType roomType";

	private static final String _SQL_COUNT_ROOMTYPE_WHERE =
		"SELECT COUNT(roomType) FROM RoomType roomType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "roomType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RoomType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RoomType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RoomTypePersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class RoomTypeModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			RoomTypeModelImpl roomTypeModelImpl = (RoomTypeModelImpl)baseModel;

			long columnBitmask = roomTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(roomTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						roomTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(roomTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			RoomTypeModelImpl roomTypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = roomTypeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = roomTypeModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}