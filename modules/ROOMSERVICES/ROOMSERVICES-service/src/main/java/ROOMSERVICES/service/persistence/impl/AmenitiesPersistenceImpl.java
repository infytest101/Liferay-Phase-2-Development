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

package ROOMSERVICES.service.persistence.impl;

import ROOMSERVICES.exception.NoSuchAmenitiesException;

import ROOMSERVICES.model.Amenities;
import ROOMSERVICES.model.impl.AmenitiesImpl;
import ROOMSERVICES.model.impl.AmenitiesModelImpl;

import ROOMSERVICES.service.persistence.AmenitiesPersistence;
import ROOMSERVICES.service.persistence.AmenitiesUtil;
import ROOMSERVICES.service.persistence.impl.constants.InfyPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

		entityCache.putResult(AmenitiesImpl.class, amenities, false, true);

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
		target = InfyPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = InfyPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = InfyPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_COUNT_AMENITIES =
		"SELECT COUNT(amenities) FROM Amenities amenities";

	private static final String _ORDER_BY_ENTITY_ALIAS = "amenities.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Amenities exists with the primary key ";

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