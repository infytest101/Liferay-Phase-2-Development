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

import hotelmanagement.services.exception.NoSuchAmenitiesException;
import hotelmanagement.services.model.Amenities;
import hotelmanagement.services.model.impl.AmenitiesImpl;
import hotelmanagement.services.model.impl.AmenitiesModelImpl;
import hotelmanagement.services.service.persistence.AmenitiesPersistence;
import hotelmanagement.services.service.persistence.AmenitiesUtil;
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
 * The persistence implementation for the amenities service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AmenitiesPersistence.class)
public class AmenitiesPersistenceImpl
	extends BasePersistenceImpl<Amenities> implements AmenitiesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AmenitiesUtil</code> to access the amenities persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AmenitiesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByIsWifiTvGeyserAvailable;
	private FinderPath
		_finderPathWithoutPaginationFindByIsWifiTvGeyserAvailable;
	private FinderPath _finderPathCountByIsWifiTvGeyserAvailable;

	/**
	 * Returns all the amenitieses where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @return the matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsWifiTvGeyserAvailable(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable) {

		return findByIsWifiTvGeyserAvailable(
			isWifiAvailable, isTVAvailable, isGeyserAvailable,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amenitieses where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsWifiTvGeyserAvailable(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable, int start, int end) {

		return findByIsWifiTvGeyserAvailable(
			isWifiAvailable, isTVAvailable, isGeyserAvailable, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the amenitieses where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsWifiTvGeyserAvailable(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator) {

		return findByIsWifiTvGeyserAvailable(
			isWifiAvailable, isTVAvailable, isGeyserAvailable, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amenitieses where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsWifiTvGeyserAvailable(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByIsWifiTvGeyserAvailable;
				finderArgs = new Object[] {
					isWifiAvailable, isTVAvailable, isGeyserAvailable
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsWifiTvGeyserAvailable;
			finderArgs = new Object[] {
				isWifiAvailable, isTVAvailable, isGeyserAvailable, start, end,
				orderByComparator
			};
		}

		List<Amenities> list = null;

		if (useFinderCache) {
			list = (List<Amenities>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Amenities amenities : list) {
					if (!Objects.equals(
							isWifiAvailable, amenities.getIsWifiAvailable()) ||
						!Objects.equals(
							isTVAvailable, amenities.getIsTVAvailable()) ||
						!Objects.equals(
							isGeyserAvailable,
							amenities.getIsGeyserAvailable())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_AMENITIES_WHERE);

			sb.append(_FINDER_COLUMN_ISWIFITVGEYSERAVAILABLE_ISWIFIAVAILABLE_2);

			sb.append(_FINDER_COLUMN_ISWIFITVGEYSERAVAILABLE_ISTVAVAILABLE_2);

			sb.append(
				_FINDER_COLUMN_ISWIFITVGEYSERAVAILABLE_ISGEYSERAVAILABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AmenitiesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isWifiAvailable.booleanValue());

				queryPos.add(isTVAvailable.booleanValue());

				queryPos.add(isGeyserAvailable.booleanValue());

				list = (List<Amenities>)QueryUtil.list(
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
	 * Returns the first amenities in the ordered set where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	@Override
	public Amenities findByIsWifiTvGeyserAvailable_First(
			Boolean isWifiAvailable, Boolean isTVAvailable,
			Boolean isGeyserAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = fetchByIsWifiTvGeyserAvailable_First(
			isWifiAvailable, isTVAvailable, isGeyserAvailable,
			orderByComparator);

		if (amenities != null) {
			return amenities;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isWifiAvailable=");
		sb.append(isWifiAvailable);

		sb.append(", isTVAvailable=");
		sb.append(isTVAvailable);

		sb.append(", isGeyserAvailable=");
		sb.append(isGeyserAvailable);

		sb.append("}");

		throw new NoSuchAmenitiesException(sb.toString());
	}

	/**
	 * Returns the first amenities in the ordered set where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	@Override
	public Amenities fetchByIsWifiTvGeyserAvailable_First(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable,
		OrderByComparator<Amenities> orderByComparator) {

		List<Amenities> list = findByIsWifiTvGeyserAvailable(
			isWifiAvailable, isTVAvailable, isGeyserAvailable, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amenities in the ordered set where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	@Override
	public Amenities findByIsWifiTvGeyserAvailable_Last(
			Boolean isWifiAvailable, Boolean isTVAvailable,
			Boolean isGeyserAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = fetchByIsWifiTvGeyserAvailable_Last(
			isWifiAvailable, isTVAvailable, isGeyserAvailable,
			orderByComparator);

		if (amenities != null) {
			return amenities;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isWifiAvailable=");
		sb.append(isWifiAvailable);

		sb.append(", isTVAvailable=");
		sb.append(isTVAvailable);

		sb.append(", isGeyserAvailable=");
		sb.append(isGeyserAvailable);

		sb.append("}");

		throw new NoSuchAmenitiesException(sb.toString());
	}

	/**
	 * Returns the last amenities in the ordered set where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	@Override
	public Amenities fetchByIsWifiTvGeyserAvailable_Last(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable,
		OrderByComparator<Amenities> orderByComparator) {

		int count = countByIsWifiTvGeyserAvailable(
			isWifiAvailable, isTVAvailable, isGeyserAvailable);

		if (count == 0) {
			return null;
		}

		List<Amenities> list = findByIsWifiTvGeyserAvailable(
			isWifiAvailable, isTVAvailable, isGeyserAvailable, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	@Override
	public Amenities[] findByIsWifiTvGeyserAvailable_PrevAndNext(
			int amenitiesId, Boolean isWifiAvailable, Boolean isTVAvailable,
			Boolean isGeyserAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = findByPrimaryKey(amenitiesId);

		Session session = null;

		try {
			session = openSession();

			Amenities[] array = new AmenitiesImpl[3];

			array[0] = getByIsWifiTvGeyserAvailable_PrevAndNext(
				session, amenities, isWifiAvailable, isTVAvailable,
				isGeyserAvailable, orderByComparator, true);

			array[1] = amenities;

			array[2] = getByIsWifiTvGeyserAvailable_PrevAndNext(
				session, amenities, isWifiAvailable, isTVAvailable,
				isGeyserAvailable, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Amenities getByIsWifiTvGeyserAvailable_PrevAndNext(
		Session session, Amenities amenities, Boolean isWifiAvailable,
		Boolean isTVAvailable, Boolean isGeyserAvailable,
		OrderByComparator<Amenities> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_AMENITIES_WHERE);

		sb.append(_FINDER_COLUMN_ISWIFITVGEYSERAVAILABLE_ISWIFIAVAILABLE_2);

		sb.append(_FINDER_COLUMN_ISWIFITVGEYSERAVAILABLE_ISTVAVAILABLE_2);

		sb.append(_FINDER_COLUMN_ISWIFITVGEYSERAVAILABLE_ISGEYSERAVAILABLE_2);

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
			sb.append(AmenitiesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isWifiAvailable.booleanValue());

		queryPos.add(isTVAvailable.booleanValue());

		queryPos.add(isGeyserAvailable.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(amenities)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Amenities> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amenitieses where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63; from the database.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 */
	@Override
	public void removeByIsWifiTvGeyserAvailable(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable) {

		for (Amenities amenities :
				findByIsWifiTvGeyserAvailable(
					isWifiAvailable, isTVAvailable, isGeyserAvailable,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(amenities);
		}
	}

	/**
	 * Returns the number of amenitieses where isWifiAvailable = &#63; and isTVAvailable = &#63; and isGeyserAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param isTVAvailable the is tv available
	 * @param isGeyserAvailable the is geyser available
	 * @return the number of matching amenitieses
	 */
	@Override
	public int countByIsWifiTvGeyserAvailable(
		Boolean isWifiAvailable, Boolean isTVAvailable,
		Boolean isGeyserAvailable) {

		FinderPath finderPath = _finderPathCountByIsWifiTvGeyserAvailable;

		Object[] finderArgs = new Object[] {
			isWifiAvailable, isTVAvailable, isGeyserAvailable
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_AMENITIES_WHERE);

			sb.append(_FINDER_COLUMN_ISWIFITVGEYSERAVAILABLE_ISWIFIAVAILABLE_2);

			sb.append(_FINDER_COLUMN_ISWIFITVGEYSERAVAILABLE_ISTVAVAILABLE_2);

			sb.append(
				_FINDER_COLUMN_ISWIFITVGEYSERAVAILABLE_ISGEYSERAVAILABLE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isWifiAvailable.booleanValue());

				queryPos.add(isTVAvailable.booleanValue());

				queryPos.add(isGeyserAvailable.booleanValue());

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

	private static final String
		_FINDER_COLUMN_ISWIFITVGEYSERAVAILABLE_ISWIFIAVAILABLE_2 =
			"amenities.isWifiAvailable = ? AND ";

	private static final String
		_FINDER_COLUMN_ISWIFITVGEYSERAVAILABLE_ISTVAVAILABLE_2 =
			"amenities.isTVAvailable = ? AND ";

	private static final String
		_FINDER_COLUMN_ISWIFITVGEYSERAVAILABLE_ISGEYSERAVAILABLE_2 =
			"amenities.isGeyserAvailable = ?";

	private FinderPath _finderPathWithPaginationFindByIsACAvailable;
	private FinderPath _finderPathWithoutPaginationFindByIsACAvailable;
	private FinderPath _finderPathCountByIsACAvailable;

	/**
	 * Returns all the amenitieses where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @return the matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsACAvailable(Boolean isACAvailable) {
		return findByIsACAvailable(
			isACAvailable, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amenitieses where isACAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isACAvailable the is ac available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsACAvailable(
		Boolean isACAvailable, int start, int end) {

		return findByIsACAvailable(isACAvailable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amenitieses where isACAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isACAvailable the is ac available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsACAvailable(
		Boolean isACAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator) {

		return findByIsACAvailable(
			isACAvailable, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amenitieses where isACAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isACAvailable the is ac available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsACAvailable(
		Boolean isACAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIsACAvailable;
				finderArgs = new Object[] {isACAvailable};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsACAvailable;
			finderArgs = new Object[] {
				isACAvailable, start, end, orderByComparator
			};
		}

		List<Amenities> list = null;

		if (useFinderCache) {
			list = (List<Amenities>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Amenities amenities : list) {
					if (!Objects.equals(
							isACAvailable, amenities.getIsACAvailable())) {

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

			sb.append(_SQL_SELECT_AMENITIES_WHERE);

			sb.append(_FINDER_COLUMN_ISACAVAILABLE_ISACAVAILABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AmenitiesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isACAvailable.booleanValue());

				list = (List<Amenities>)QueryUtil.list(
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
	 * Returns the first amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	@Override
	public Amenities findByIsACAvailable_First(
			Boolean isACAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = fetchByIsACAvailable_First(
			isACAvailable, orderByComparator);

		if (amenities != null) {
			return amenities;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isACAvailable=");
		sb.append(isACAvailable);

		sb.append("}");

		throw new NoSuchAmenitiesException(sb.toString());
	}

	/**
	 * Returns the first amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	@Override
	public Amenities fetchByIsACAvailable_First(
		Boolean isACAvailable, OrderByComparator<Amenities> orderByComparator) {

		List<Amenities> list = findByIsACAvailable(
			isACAvailable, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	@Override
	public Amenities findByIsACAvailable_Last(
			Boolean isACAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = fetchByIsACAvailable_Last(
			isACAvailable, orderByComparator);

		if (amenities != null) {
			return amenities;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isACAvailable=");
		sb.append(isACAvailable);

		sb.append("}");

		throw new NoSuchAmenitiesException(sb.toString());
	}

	/**
	 * Returns the last amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	@Override
	public Amenities fetchByIsACAvailable_Last(
		Boolean isACAvailable, OrderByComparator<Amenities> orderByComparator) {

		int count = countByIsACAvailable(isACAvailable);

		if (count == 0) {
			return null;
		}

		List<Amenities> list = findByIsACAvailable(
			isACAvailable, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isACAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isACAvailable the is ac available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	@Override
	public Amenities[] findByIsACAvailable_PrevAndNext(
			int amenitiesId, Boolean isACAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = findByPrimaryKey(amenitiesId);

		Session session = null;

		try {
			session = openSession();

			Amenities[] array = new AmenitiesImpl[3];

			array[0] = getByIsACAvailable_PrevAndNext(
				session, amenities, isACAvailable, orderByComparator, true);

			array[1] = amenities;

			array[2] = getByIsACAvailable_PrevAndNext(
				session, amenities, isACAvailable, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Amenities getByIsACAvailable_PrevAndNext(
		Session session, Amenities amenities, Boolean isACAvailable,
		OrderByComparator<Amenities> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AMENITIES_WHERE);

		sb.append(_FINDER_COLUMN_ISACAVAILABLE_ISACAVAILABLE_2);

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
			sb.append(AmenitiesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isACAvailable.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(amenities)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Amenities> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amenitieses where isACAvailable = &#63; from the database.
	 *
	 * @param isACAvailable the is ac available
	 */
	@Override
	public void removeByIsACAvailable(Boolean isACAvailable) {
		for (Amenities amenities :
				findByIsACAvailable(
					isACAvailable, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(amenities);
		}
	}

	/**
	 * Returns the number of amenitieses where isACAvailable = &#63;.
	 *
	 * @param isACAvailable the is ac available
	 * @return the number of matching amenitieses
	 */
	@Override
	public int countByIsACAvailable(Boolean isACAvailable) {
		FinderPath finderPath = _finderPathCountByIsACAvailable;

		Object[] finderArgs = new Object[] {isACAvailable};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMENITIES_WHERE);

			sb.append(_FINDER_COLUMN_ISACAVAILABLE_ISACAVAILABLE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isACAvailable.booleanValue());

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

	private static final String _FINDER_COLUMN_ISACAVAILABLE_ISACAVAILABLE_2 =
		"amenities.isACAvailable = ?";

	private FinderPath _finderPathWithPaginationFindByIsSmokingAvailable;
	private FinderPath _finderPathWithoutPaginationFindByIsSmokingAvailable;
	private FinderPath _finderPathCountByIsSmokingAvailable;

	/**
	 * Returns all the amenitieses where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @return the matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsSmokingAvailable(
		Boolean isSmokingAvailable) {

		return findByIsSmokingAvailable(
			isSmokingAvailable, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amenitieses where isSmokingAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsSmokingAvailable(
		Boolean isSmokingAvailable, int start, int end) {

		return findByIsSmokingAvailable(isSmokingAvailable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amenitieses where isSmokingAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsSmokingAvailable(
		Boolean isSmokingAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator) {

		return findByIsSmokingAvailable(
			isSmokingAvailable, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amenitieses where isSmokingAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsSmokingAvailable(
		Boolean isSmokingAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByIsSmokingAvailable;
				finderArgs = new Object[] {isSmokingAvailable};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsSmokingAvailable;
			finderArgs = new Object[] {
				isSmokingAvailable, start, end, orderByComparator
			};
		}

		List<Amenities> list = null;

		if (useFinderCache) {
			list = (List<Amenities>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Amenities amenities : list) {
					if (!Objects.equals(
							isSmokingAvailable,
							amenities.getIsSmokingAvailable())) {

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

			sb.append(_SQL_SELECT_AMENITIES_WHERE);

			sb.append(_FINDER_COLUMN_ISSMOKINGAVAILABLE_ISSMOKINGAVAILABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AmenitiesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isSmokingAvailable.booleanValue());

				list = (List<Amenities>)QueryUtil.list(
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
	 * Returns the first amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	@Override
	public Amenities findByIsSmokingAvailable_First(
			Boolean isSmokingAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = fetchByIsSmokingAvailable_First(
			isSmokingAvailable, orderByComparator);

		if (amenities != null) {
			return amenities;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isSmokingAvailable=");
		sb.append(isSmokingAvailable);

		sb.append("}");

		throw new NoSuchAmenitiesException(sb.toString());
	}

	/**
	 * Returns the first amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	@Override
	public Amenities fetchByIsSmokingAvailable_First(
		Boolean isSmokingAvailable,
		OrderByComparator<Amenities> orderByComparator) {

		List<Amenities> list = findByIsSmokingAvailable(
			isSmokingAvailable, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	@Override
	public Amenities findByIsSmokingAvailable_Last(
			Boolean isSmokingAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = fetchByIsSmokingAvailable_Last(
			isSmokingAvailable, orderByComparator);

		if (amenities != null) {
			return amenities;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isSmokingAvailable=");
		sb.append(isSmokingAvailable);

		sb.append("}");

		throw new NoSuchAmenitiesException(sb.toString());
	}

	/**
	 * Returns the last amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	@Override
	public Amenities fetchByIsSmokingAvailable_Last(
		Boolean isSmokingAvailable,
		OrderByComparator<Amenities> orderByComparator) {

		int count = countByIsSmokingAvailable(isSmokingAvailable);

		if (count == 0) {
			return null;
		}

		List<Amenities> list = findByIsSmokingAvailable(
			isSmokingAvailable, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isSmokingAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isSmokingAvailable the is smoking available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	@Override
	public Amenities[] findByIsSmokingAvailable_PrevAndNext(
			int amenitiesId, Boolean isSmokingAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = findByPrimaryKey(amenitiesId);

		Session session = null;

		try {
			session = openSession();

			Amenities[] array = new AmenitiesImpl[3];

			array[0] = getByIsSmokingAvailable_PrevAndNext(
				session, amenities, isSmokingAvailable, orderByComparator,
				true);

			array[1] = amenities;

			array[2] = getByIsSmokingAvailable_PrevAndNext(
				session, amenities, isSmokingAvailable, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Amenities getByIsSmokingAvailable_PrevAndNext(
		Session session, Amenities amenities, Boolean isSmokingAvailable,
		OrderByComparator<Amenities> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AMENITIES_WHERE);

		sb.append(_FINDER_COLUMN_ISSMOKINGAVAILABLE_ISSMOKINGAVAILABLE_2);

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
			sb.append(AmenitiesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isSmokingAvailable.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(amenities)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Amenities> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amenitieses where isSmokingAvailable = &#63; from the database.
	 *
	 * @param isSmokingAvailable the is smoking available
	 */
	@Override
	public void removeByIsSmokingAvailable(Boolean isSmokingAvailable) {
		for (Amenities amenities :
				findByIsSmokingAvailable(
					isSmokingAvailable, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(amenities);
		}
	}

	/**
	 * Returns the number of amenitieses where isSmokingAvailable = &#63;.
	 *
	 * @param isSmokingAvailable the is smoking available
	 * @return the number of matching amenitieses
	 */
	@Override
	public int countByIsSmokingAvailable(Boolean isSmokingAvailable) {
		FinderPath finderPath = _finderPathCountByIsSmokingAvailable;

		Object[] finderArgs = new Object[] {isSmokingAvailable};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMENITIES_WHERE);

			sb.append(_FINDER_COLUMN_ISSMOKINGAVAILABLE_ISSMOKINGAVAILABLE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isSmokingAvailable.booleanValue());

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

	private static final String
		_FINDER_COLUMN_ISSMOKINGAVAILABLE_ISSMOKINGAVAILABLE_2 =
			"amenities.isSmokingAvailable = ?";

	private FinderPath _finderPathWithPaginationFindByIsWifiAvailable;
	private FinderPath _finderPathWithoutPaginationFindByIsWifiAvailable;
	private FinderPath _finderPathCountByIsWifiAvailable;

	/**
	 * Returns all the amenitieses where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @return the matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsWifiAvailable(Boolean isWifiAvailable) {
		return findByIsWifiAvailable(
			isWifiAvailable, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amenitieses where isWifiAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsWifiAvailable(
		Boolean isWifiAvailable, int start, int end) {

		return findByIsWifiAvailable(isWifiAvailable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amenitieses where isWifiAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsWifiAvailable(
		Boolean isWifiAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator) {

		return findByIsWifiAvailable(
			isWifiAvailable, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amenitieses where isWifiAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsWifiAvailable(
		Boolean isWifiAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIsWifiAvailable;
				finderArgs = new Object[] {isWifiAvailable};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsWifiAvailable;
			finderArgs = new Object[] {
				isWifiAvailable, start, end, orderByComparator
			};
		}

		List<Amenities> list = null;

		if (useFinderCache) {
			list = (List<Amenities>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Amenities amenities : list) {
					if (!Objects.equals(
							isWifiAvailable, amenities.getIsWifiAvailable())) {

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

			sb.append(_SQL_SELECT_AMENITIES_WHERE);

			sb.append(_FINDER_COLUMN_ISWIFIAVAILABLE_ISWIFIAVAILABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AmenitiesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isWifiAvailable.booleanValue());

				list = (List<Amenities>)QueryUtil.list(
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
	 * Returns the first amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	@Override
	public Amenities findByIsWifiAvailable_First(
			Boolean isWifiAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = fetchByIsWifiAvailable_First(
			isWifiAvailable, orderByComparator);

		if (amenities != null) {
			return amenities;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isWifiAvailable=");
		sb.append(isWifiAvailable);

		sb.append("}");

		throw new NoSuchAmenitiesException(sb.toString());
	}

	/**
	 * Returns the first amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	@Override
	public Amenities fetchByIsWifiAvailable_First(
		Boolean isWifiAvailable,
		OrderByComparator<Amenities> orderByComparator) {

		List<Amenities> list = findByIsWifiAvailable(
			isWifiAvailable, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	@Override
	public Amenities findByIsWifiAvailable_Last(
			Boolean isWifiAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = fetchByIsWifiAvailable_Last(
			isWifiAvailable, orderByComparator);

		if (amenities != null) {
			return amenities;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isWifiAvailable=");
		sb.append(isWifiAvailable);

		sb.append("}");

		throw new NoSuchAmenitiesException(sb.toString());
	}

	/**
	 * Returns the last amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	@Override
	public Amenities fetchByIsWifiAvailable_Last(
		Boolean isWifiAvailable,
		OrderByComparator<Amenities> orderByComparator) {

		int count = countByIsWifiAvailable(isWifiAvailable);

		if (count == 0) {
			return null;
		}

		List<Amenities> list = findByIsWifiAvailable(
			isWifiAvailable, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isWifiAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isWifiAvailable the is wifi available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	@Override
	public Amenities[] findByIsWifiAvailable_PrevAndNext(
			int amenitiesId, Boolean isWifiAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = findByPrimaryKey(amenitiesId);

		Session session = null;

		try {
			session = openSession();

			Amenities[] array = new AmenitiesImpl[3];

			array[0] = getByIsWifiAvailable_PrevAndNext(
				session, amenities, isWifiAvailable, orderByComparator, true);

			array[1] = amenities;

			array[2] = getByIsWifiAvailable_PrevAndNext(
				session, amenities, isWifiAvailable, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Amenities getByIsWifiAvailable_PrevAndNext(
		Session session, Amenities amenities, Boolean isWifiAvailable,
		OrderByComparator<Amenities> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AMENITIES_WHERE);

		sb.append(_FINDER_COLUMN_ISWIFIAVAILABLE_ISWIFIAVAILABLE_2);

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
			sb.append(AmenitiesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isWifiAvailable.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(amenities)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Amenities> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amenitieses where isWifiAvailable = &#63; from the database.
	 *
	 * @param isWifiAvailable the is wifi available
	 */
	@Override
	public void removeByIsWifiAvailable(Boolean isWifiAvailable) {
		for (Amenities amenities :
				findByIsWifiAvailable(
					isWifiAvailable, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(amenities);
		}
	}

	/**
	 * Returns the number of amenitieses where isWifiAvailable = &#63;.
	 *
	 * @param isWifiAvailable the is wifi available
	 * @return the number of matching amenitieses
	 */
	@Override
	public int countByIsWifiAvailable(Boolean isWifiAvailable) {
		FinderPath finderPath = _finderPathCountByIsWifiAvailable;

		Object[] finderArgs = new Object[] {isWifiAvailable};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMENITIES_WHERE);

			sb.append(_FINDER_COLUMN_ISWIFIAVAILABLE_ISWIFIAVAILABLE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isWifiAvailable.booleanValue());

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

	private static final String
		_FINDER_COLUMN_ISWIFIAVAILABLE_ISWIFIAVAILABLE_2 =
			"amenities.isWifiAvailable = ?";

	private FinderPath _finderPathWithPaginationFindByIsTVAvailable;
	private FinderPath _finderPathWithoutPaginationFindByIsTVAvailable;
	private FinderPath _finderPathCountByIsTVAvailable;

	/**
	 * Returns all the amenitieses where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @return the matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsTVAvailable(Boolean isTVAvailable) {
		return findByIsTVAvailable(
			isTVAvailable, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amenitieses where isTVAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isTVAvailable the is tv available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsTVAvailable(
		Boolean isTVAvailable, int start, int end) {

		return findByIsTVAvailable(isTVAvailable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amenitieses where isTVAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isTVAvailable the is tv available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsTVAvailable(
		Boolean isTVAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator) {

		return findByIsTVAvailable(
			isTVAvailable, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amenitieses where isTVAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isTVAvailable the is tv available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsTVAvailable(
		Boolean isTVAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIsTVAvailable;
				finderArgs = new Object[] {isTVAvailable};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsTVAvailable;
			finderArgs = new Object[] {
				isTVAvailable, start, end, orderByComparator
			};
		}

		List<Amenities> list = null;

		if (useFinderCache) {
			list = (List<Amenities>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Amenities amenities : list) {
					if (!Objects.equals(
							isTVAvailable, amenities.getIsTVAvailable())) {

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

			sb.append(_SQL_SELECT_AMENITIES_WHERE);

			sb.append(_FINDER_COLUMN_ISTVAVAILABLE_ISTVAVAILABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AmenitiesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isTVAvailable.booleanValue());

				list = (List<Amenities>)QueryUtil.list(
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
	 * Returns the first amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	@Override
	public Amenities findByIsTVAvailable_First(
			Boolean isTVAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = fetchByIsTVAvailable_First(
			isTVAvailable, orderByComparator);

		if (amenities != null) {
			return amenities;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isTVAvailable=");
		sb.append(isTVAvailable);

		sb.append("}");

		throw new NoSuchAmenitiesException(sb.toString());
	}

	/**
	 * Returns the first amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	@Override
	public Amenities fetchByIsTVAvailable_First(
		Boolean isTVAvailable, OrderByComparator<Amenities> orderByComparator) {

		List<Amenities> list = findByIsTVAvailable(
			isTVAvailable, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	@Override
	public Amenities findByIsTVAvailable_Last(
			Boolean isTVAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = fetchByIsTVAvailable_Last(
			isTVAvailable, orderByComparator);

		if (amenities != null) {
			return amenities;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isTVAvailable=");
		sb.append(isTVAvailable);

		sb.append("}");

		throw new NoSuchAmenitiesException(sb.toString());
	}

	/**
	 * Returns the last amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	@Override
	public Amenities fetchByIsTVAvailable_Last(
		Boolean isTVAvailable, OrderByComparator<Amenities> orderByComparator) {

		int count = countByIsTVAvailable(isTVAvailable);

		if (count == 0) {
			return null;
		}

		List<Amenities> list = findByIsTVAvailable(
			isTVAvailable, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isTVAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isTVAvailable the is tv available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	@Override
	public Amenities[] findByIsTVAvailable_PrevAndNext(
			int amenitiesId, Boolean isTVAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = findByPrimaryKey(amenitiesId);

		Session session = null;

		try {
			session = openSession();

			Amenities[] array = new AmenitiesImpl[3];

			array[0] = getByIsTVAvailable_PrevAndNext(
				session, amenities, isTVAvailable, orderByComparator, true);

			array[1] = amenities;

			array[2] = getByIsTVAvailable_PrevAndNext(
				session, amenities, isTVAvailable, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Amenities getByIsTVAvailable_PrevAndNext(
		Session session, Amenities amenities, Boolean isTVAvailable,
		OrderByComparator<Amenities> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AMENITIES_WHERE);

		sb.append(_FINDER_COLUMN_ISTVAVAILABLE_ISTVAVAILABLE_2);

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
			sb.append(AmenitiesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isTVAvailable.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(amenities)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Amenities> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amenitieses where isTVAvailable = &#63; from the database.
	 *
	 * @param isTVAvailable the is tv available
	 */
	@Override
	public void removeByIsTVAvailable(Boolean isTVAvailable) {
		for (Amenities amenities :
				findByIsTVAvailable(
					isTVAvailable, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(amenities);
		}
	}

	/**
	 * Returns the number of amenitieses where isTVAvailable = &#63;.
	 *
	 * @param isTVAvailable the is tv available
	 * @return the number of matching amenitieses
	 */
	@Override
	public int countByIsTVAvailable(Boolean isTVAvailable) {
		FinderPath finderPath = _finderPathCountByIsTVAvailable;

		Object[] finderArgs = new Object[] {isTVAvailable};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMENITIES_WHERE);

			sb.append(_FINDER_COLUMN_ISTVAVAILABLE_ISTVAVAILABLE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isTVAvailable.booleanValue());

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

	private static final String _FINDER_COLUMN_ISTVAVAILABLE_ISTVAVAILABLE_2 =
		"amenities.isTVAvailable = ?";

	private FinderPath _finderPathWithPaginationFindByIsGeyserAvailable;
	private FinderPath _finderPathWithoutPaginationFindByIsGeyserAvailable;
	private FinderPath _finderPathCountByIsGeyserAvailable;

	/**
	 * Returns all the amenitieses where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @return the matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsGeyserAvailable(Boolean isGeyserAvailable) {
		return findByIsGeyserAvailable(
			isGeyserAvailable, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amenitieses where isGeyserAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsGeyserAvailable(
		Boolean isGeyserAvailable, int start, int end) {

		return findByIsGeyserAvailable(isGeyserAvailable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amenitieses where isGeyserAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsGeyserAvailable(
		Boolean isGeyserAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator) {

		return findByIsGeyserAvailable(
			isGeyserAvailable, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amenitieses where isGeyserAvailable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amenitieses
	 */
	@Override
	public List<Amenities> findByIsGeyserAvailable(
		Boolean isGeyserAvailable, int start, int end,
		OrderByComparator<Amenities> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByIsGeyserAvailable;
				finderArgs = new Object[] {isGeyserAvailable};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIsGeyserAvailable;
			finderArgs = new Object[] {
				isGeyserAvailable, start, end, orderByComparator
			};
		}

		List<Amenities> list = null;

		if (useFinderCache) {
			list = (List<Amenities>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Amenities amenities : list) {
					if (!Objects.equals(
							isGeyserAvailable,
							amenities.getIsGeyserAvailable())) {

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

			sb.append(_SQL_SELECT_AMENITIES_WHERE);

			sb.append(_FINDER_COLUMN_ISGEYSERAVAILABLE_ISGEYSERAVAILABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AmenitiesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isGeyserAvailable.booleanValue());

				list = (List<Amenities>)QueryUtil.list(
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
	 * Returns the first amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	@Override
	public Amenities findByIsGeyserAvailable_First(
			Boolean isGeyserAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = fetchByIsGeyserAvailable_First(
			isGeyserAvailable, orderByComparator);

		if (amenities != null) {
			return amenities;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isGeyserAvailable=");
		sb.append(isGeyserAvailable);

		sb.append("}");

		throw new NoSuchAmenitiesException(sb.toString());
	}

	/**
	 * Returns the first amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	@Override
	public Amenities fetchByIsGeyserAvailable_First(
		Boolean isGeyserAvailable,
		OrderByComparator<Amenities> orderByComparator) {

		List<Amenities> list = findByIsGeyserAvailable(
			isGeyserAvailable, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities
	 * @throws NoSuchAmenitiesException if a matching amenities could not be found
	 */
	@Override
	public Amenities findByIsGeyserAvailable_Last(
			Boolean isGeyserAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = fetchByIsGeyserAvailable_Last(
			isGeyserAvailable, orderByComparator);

		if (amenities != null) {
			return amenities;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isGeyserAvailable=");
		sb.append(isGeyserAvailable);

		sb.append("}");

		throw new NoSuchAmenitiesException(sb.toString());
	}

	/**
	 * Returns the last amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amenities, or <code>null</code> if a matching amenities could not be found
	 */
	@Override
	public Amenities fetchByIsGeyserAvailable_Last(
		Boolean isGeyserAvailable,
		OrderByComparator<Amenities> orderByComparator) {

		int count = countByIsGeyserAvailable(isGeyserAvailable);

		if (count == 0) {
			return null;
		}

		List<Amenities> list = findByIsGeyserAvailable(
			isGeyserAvailable, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amenitieses before and after the current amenities in the ordered set where isGeyserAvailable = &#63;.
	 *
	 * @param amenitiesId the primary key of the current amenities
	 * @param isGeyserAvailable the is geyser available
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	@Override
	public Amenities[] findByIsGeyserAvailable_PrevAndNext(
			int amenitiesId, Boolean isGeyserAvailable,
			OrderByComparator<Amenities> orderByComparator)
		throws NoSuchAmenitiesException {

		Amenities amenities = findByPrimaryKey(amenitiesId);

		Session session = null;

		try {
			session = openSession();

			Amenities[] array = new AmenitiesImpl[3];

			array[0] = getByIsGeyserAvailable_PrevAndNext(
				session, amenities, isGeyserAvailable, orderByComparator, true);

			array[1] = amenities;

			array[2] = getByIsGeyserAvailable_PrevAndNext(
				session, amenities, isGeyserAvailable, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Amenities getByIsGeyserAvailable_PrevAndNext(
		Session session, Amenities amenities, Boolean isGeyserAvailable,
		OrderByComparator<Amenities> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AMENITIES_WHERE);

		sb.append(_FINDER_COLUMN_ISGEYSERAVAILABLE_ISGEYSERAVAILABLE_2);

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
			sb.append(AmenitiesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isGeyserAvailable.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(amenities)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Amenities> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amenitieses where isGeyserAvailable = &#63; from the database.
	 *
	 * @param isGeyserAvailable the is geyser available
	 */
	@Override
	public void removeByIsGeyserAvailable(Boolean isGeyserAvailable) {
		for (Amenities amenities :
				findByIsGeyserAvailable(
					isGeyserAvailable, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(amenities);
		}
	}

	/**
	 * Returns the number of amenitieses where isGeyserAvailable = &#63;.
	 *
	 * @param isGeyserAvailable the is geyser available
	 * @return the number of matching amenitieses
	 */
	@Override
	public int countByIsGeyserAvailable(Boolean isGeyserAvailable) {
		FinderPath finderPath = _finderPathCountByIsGeyserAvailable;

		Object[] finderArgs = new Object[] {isGeyserAvailable};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMENITIES_WHERE);

			sb.append(_FINDER_COLUMN_ISGEYSERAVAILABLE_ISGEYSERAVAILABLE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isGeyserAvailable.booleanValue());

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

	private static final String
		_FINDER_COLUMN_ISGEYSERAVAILABLE_ISGEYSERAVAILABLE_2 =
			"amenities.isGeyserAvailable = ?";

	public AmenitiesPersistenceImpl() {
		setModelClass(Amenities.class);

		setModelImplClass(AmenitiesImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the amenities in the entity cache if it is enabled.
	 *
	 * @param amenities the amenities
	 */
	@Override
	public void cacheResult(Amenities amenities) {
		entityCache.putResult(
			AmenitiesImpl.class, amenities.getPrimaryKey(), amenities);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the amenitieses in the entity cache if it is enabled.
	 *
	 * @param amenitieses the amenitieses
	 */
	@Override
	public void cacheResult(List<Amenities> amenitieses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (amenitieses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Amenities amenities : amenitieses) {
			if (entityCache.getResult(
					AmenitiesImpl.class, amenities.getPrimaryKey()) == null) {

				cacheResult(amenities);
			}
		}
	}

	/**
	 * Clears the cache for all amenitieses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AmenitiesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the amenities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Amenities amenities) {
		entityCache.removeResult(AmenitiesImpl.class, amenities);
	}

	@Override
	public void clearCache(List<Amenities> amenitieses) {
		for (Amenities amenities : amenitieses) {
			entityCache.removeResult(AmenitiesImpl.class, amenities);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AmenitiesImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new amenities with the primary key. Does not add the amenities to the database.
	 *
	 * @param amenitiesId the primary key for the new amenities
	 * @return the new amenities
	 */
	@Override
	public Amenities create(int amenitiesId) {
		Amenities amenities = new AmenitiesImpl();

		amenities.setNew(true);
		amenities.setPrimaryKey(amenitiesId);

		return amenities;
	}

	/**
	 * Removes the amenities with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amenitiesId the primary key of the amenities
	 * @return the amenities that was removed
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	@Override
	public Amenities remove(int amenitiesId) throws NoSuchAmenitiesException {
		return remove((Serializable)amenitiesId);
	}

	/**
	 * Removes the amenities with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the amenities
	 * @return the amenities that was removed
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	@Override
	public Amenities remove(Serializable primaryKey)
		throws NoSuchAmenitiesException {

		Session session = null;

		try {
			session = openSession();

			Amenities amenities = (Amenities)session.get(
				AmenitiesImpl.class, primaryKey);

			if (amenities == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAmenitiesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(amenities);
		}
		catch (NoSuchAmenitiesException noSuchEntityException) {
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
	protected Amenities removeImpl(Amenities amenities) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amenities)) {
				amenities = (Amenities)session.get(
					AmenitiesImpl.class, amenities.getPrimaryKeyObj());
			}

			if (amenities != null) {
				session.delete(amenities);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (amenities != null) {
			clearCache(amenities);
		}

		return amenities;
	}

	@Override
	public Amenities updateImpl(Amenities amenities) {
		boolean isNew = amenities.isNew();

		if (!(amenities instanceof AmenitiesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(amenities.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(amenities);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in amenities proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Amenities implementation " +
					amenities.getClass());
		}

		AmenitiesModelImpl amenitiesModelImpl = (AmenitiesModelImpl)amenities;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(amenities);
			}
			else {
				amenities = (Amenities)session.merge(amenities);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AmenitiesImpl.class, amenitiesModelImpl, false, true);

		if (isNew) {
			amenities.setNew(false);
		}

		amenities.resetOriginalValues();

		return amenities;
	}

	/**
	 * Returns the amenities with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the amenities
	 * @return the amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	@Override
	public Amenities findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAmenitiesException {

		Amenities amenities = fetchByPrimaryKey(primaryKey);

		if (amenities == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAmenitiesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return amenities;
	}

	/**
	 * Returns the amenities with the primary key or throws a <code>NoSuchAmenitiesException</code> if it could not be found.
	 *
	 * @param amenitiesId the primary key of the amenities
	 * @return the amenities
	 * @throws NoSuchAmenitiesException if a amenities with the primary key could not be found
	 */
	@Override
	public Amenities findByPrimaryKey(int amenitiesId)
		throws NoSuchAmenitiesException {

		return findByPrimaryKey((Serializable)amenitiesId);
	}

	/**
	 * Returns the amenities with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amenitiesId the primary key of the amenities
	 * @return the amenities, or <code>null</code> if a amenities with the primary key could not be found
	 */
	@Override
	public Amenities fetchByPrimaryKey(int amenitiesId) {
		return fetchByPrimaryKey((Serializable)amenitiesId);
	}

	/**
	 * Returns all the amenitieses.
	 *
	 * @return the amenitieses
	 */
	@Override
	public List<Amenities> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amenitieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @return the range of amenitieses
	 */
	@Override
	public List<Amenities> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the amenitieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amenitieses
	 */
	@Override
	public List<Amenities> findAll(
		int start, int end, OrderByComparator<Amenities> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amenitieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmenitiesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amenitieses
	 * @param end the upper bound of the range of amenitieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amenitieses
	 */
	@Override
	public List<Amenities> findAll(
		int start, int end, OrderByComparator<Amenities> orderByComparator,
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

		List<Amenities> list = null;

		if (useFinderCache) {
			list = (List<Amenities>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AMENITIES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AMENITIES;

				sql = sql.concat(AmenitiesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Amenities>)QueryUtil.list(
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
	 * Removes all the amenitieses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Amenities amenities : findAll()) {
			remove(amenities);
		}
	}

	/**
	 * Returns the number of amenitieses.
	 *
	 * @return the number of amenitieses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AMENITIES);

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
		return "amenitiesId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AMENITIES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AmenitiesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the amenities persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new AmenitiesModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Amenities.class.getName()));

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

		_finderPathWithPaginationFindByIsWifiTvGeyserAvailable =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByIsWifiTvGeyserAvailable",
				new String[] {
					Boolean.class.getName(), Boolean.class.getName(),
					Boolean.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {
					"isWifiAvailable", "isTVAvailable", "isGeyserAvailable"
				},
				true);

		_finderPathWithoutPaginationFindByIsWifiTvGeyserAvailable =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByIsWifiTvGeyserAvailable",
				new String[] {
					Boolean.class.getName(), Boolean.class.getName(),
					Boolean.class.getName()
				},
				new String[] {
					"isWifiAvailable", "isTVAvailable", "isGeyserAvailable"
				},
				true);

		_finderPathCountByIsWifiTvGeyserAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIsWifiTvGeyserAvailable",
			new String[] {
				Boolean.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			new String[] {
				"isWifiAvailable", "isTVAvailable", "isGeyserAvailable"
			},
			false);

		_finderPathWithPaginationFindByIsACAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsACAvailable",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isACAvailable"}, true);

		_finderPathWithoutPaginationFindByIsACAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsACAvailable",
			new String[] {Boolean.class.getName()},
			new String[] {"isACAvailable"}, true);

		_finderPathCountByIsACAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsACAvailable",
			new String[] {Boolean.class.getName()},
			new String[] {"isACAvailable"}, false);

		_finderPathWithPaginationFindByIsSmokingAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsSmokingAvailable",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isSmokingAvailable"}, true);

		_finderPathWithoutPaginationFindByIsSmokingAvailable =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByIsSmokingAvailable",
				new String[] {Boolean.class.getName()},
				new String[] {"isSmokingAvailable"}, true);

		_finderPathCountByIsSmokingAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIsSmokingAvailable", new String[] {Boolean.class.getName()},
			new String[] {"isSmokingAvailable"}, false);

		_finderPathWithPaginationFindByIsWifiAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsWifiAvailable",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isWifiAvailable"}, true);

		_finderPathWithoutPaginationFindByIsWifiAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsWifiAvailable",
			new String[] {Boolean.class.getName()},
			new String[] {"isWifiAvailable"}, true);

		_finderPathCountByIsWifiAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsWifiAvailable",
			new String[] {Boolean.class.getName()},
			new String[] {"isWifiAvailable"}, false);

		_finderPathWithPaginationFindByIsTVAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsTVAvailable",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isTVAvailable"}, true);

		_finderPathWithoutPaginationFindByIsTVAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsTVAvailable",
			new String[] {Boolean.class.getName()},
			new String[] {"isTVAvailable"}, true);

		_finderPathCountByIsTVAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsTVAvailable",
			new String[] {Boolean.class.getName()},
			new String[] {"isTVAvailable"}, false);

		_finderPathWithPaginationFindByIsGeyserAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsGeyserAvailable",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isGeyserAvailable"}, true);

		_finderPathWithoutPaginationFindByIsGeyserAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByIsGeyserAvailable", new String[] {Boolean.class.getName()},
			new String[] {"isGeyserAvailable"}, true);

		_finderPathCountByIsGeyserAvailable = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIsGeyserAvailable", new String[] {Boolean.class.getName()},
			new String[] {"isGeyserAvailable"}, false);

		_setAmenitiesUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAmenitiesUtilPersistence(null);

		entityCache.removeCache(AmenitiesImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setAmenitiesUtilPersistence(
		AmenitiesPersistence amenitiesPersistence) {

		try {
			Field field = AmenitiesUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, amenitiesPersistence);
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

	private static final String _SQL_SELECT_AMENITIES =
		"SELECT amenities FROM Amenities amenities";

	private static final String _SQL_SELECT_AMENITIES_WHERE =
		"SELECT amenities FROM Amenities amenities WHERE ";

	private static final String _SQL_COUNT_AMENITIES =
		"SELECT COUNT(amenities) FROM Amenities amenities";

	private static final String _SQL_COUNT_AMENITIES_WHERE =
		"SELECT COUNT(amenities) FROM Amenities amenities WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "amenities.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Amenities exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Amenities exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AmenitiesPersistenceImpl.class);

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

	private static class AmenitiesModelArgumentsResolver
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

			AmenitiesModelImpl amenitiesModelImpl =
				(AmenitiesModelImpl)baseModel;

			long columnBitmask = amenitiesModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(amenitiesModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						amenitiesModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(amenitiesModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			AmenitiesModelImpl amenitiesModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = amenitiesModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = amenitiesModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}