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

import ROOMSERVICES.exception.NoSuchRoomsException;

import ROOMSERVICES.model.Rooms;
import ROOMSERVICES.model.impl.RoomsImpl;
import ROOMSERVICES.model.impl.RoomsModelImpl;

import ROOMSERVICES.service.persistence.RoomsPersistence;
import ROOMSERVICES.service.persistence.RoomsUtil;
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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
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
 * The persistence implementation for the rooms service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RoomsPersistence.class)
public class RoomsPersistenceImpl
	extends BasePersistenceImpl<Rooms> implements RoomsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RoomsUtil</code> to access the rooms persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RoomsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public RoomsPersistenceImpl() {
		setModelClass(Rooms.class);

		setModelImplClass(RoomsImpl.class);
		setModelPKClass(int.class);
	}

	/**
	 * Caches the rooms in the entity cache if it is enabled.
	 *
	 * @param rooms the rooms
	 */
	@Override
	public void cacheResult(Rooms rooms) {
		entityCache.putResult(RoomsImpl.class, rooms.getPrimaryKey(), rooms);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the roomses in the entity cache if it is enabled.
	 *
	 * @param roomses the roomses
	 */
	@Override
	public void cacheResult(List<Rooms> roomses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (roomses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Rooms rooms : roomses) {
			if (entityCache.getResult(RoomsImpl.class, rooms.getPrimaryKey()) ==
					null) {

				cacheResult(rooms);
			}
		}
	}

	/**
	 * Clears the cache for all roomses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RoomsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rooms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Rooms rooms) {
		entityCache.removeResult(RoomsImpl.class, rooms);
	}

	@Override
	public void clearCache(List<Rooms> roomses) {
		for (Rooms rooms : roomses) {
			entityCache.removeResult(RoomsImpl.class, rooms);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RoomsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rooms with the primary key. Does not add the rooms to the database.
	 *
	 * @param roomId the primary key for the new rooms
	 * @return the new rooms
	 */
	@Override
	public Rooms create(int roomId) {
		Rooms rooms = new RoomsImpl();

		rooms.setNew(true);
		rooms.setPrimaryKey(roomId);

		return rooms;
	}

	/**
	 * Removes the rooms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomId the primary key of the rooms
	 * @return the rooms that was removed
	 * @throws NoSuchRoomsException if a rooms with the primary key could not be found
	 */
	@Override
	public Rooms remove(int roomId) throws NoSuchRoomsException {
		return remove((Serializable)roomId);
	}

	/**
	 * Removes the rooms with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rooms
	 * @return the rooms that was removed
	 * @throws NoSuchRoomsException if a rooms with the primary key could not be found
	 */
	@Override
	public Rooms remove(Serializable primaryKey) throws NoSuchRoomsException {
		Session session = null;

		try {
			session = openSession();

			Rooms rooms = (Rooms)session.get(RoomsImpl.class, primaryKey);

			if (rooms == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRoomsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rooms);
		}
		catch (NoSuchRoomsException noSuchEntityException) {
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
	protected Rooms removeImpl(Rooms rooms) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rooms)) {
				rooms = (Rooms)session.get(
					RoomsImpl.class, rooms.getPrimaryKeyObj());
			}

			if (rooms != null) {
				session.delete(rooms);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rooms != null) {
			clearCache(rooms);
		}

		return rooms;
	}

	@Override
	public Rooms updateImpl(Rooms rooms) {
		boolean isNew = rooms.isNew();

		if (!(rooms instanceof RoomsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rooms.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(rooms);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rooms proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Rooms implementation " +
					rooms.getClass());
		}

		RoomsModelImpl roomsModelImpl = (RoomsModelImpl)rooms;

		if (isNew && (rooms.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				rooms.setCreateDate(date);
			}
			else {
				rooms.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rooms);
			}
			else {
				rooms = (Rooms)session.merge(rooms);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(RoomsImpl.class, rooms, false, true);

		if (isNew) {
			rooms.setNew(false);
		}

		rooms.resetOriginalValues();

		return rooms;
	}

	/**
	 * Returns the rooms with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rooms
	 * @return the rooms
	 * @throws NoSuchRoomsException if a rooms with the primary key could not be found
	 */
	@Override
	public Rooms findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRoomsException {

		Rooms rooms = fetchByPrimaryKey(primaryKey);

		if (rooms == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRoomsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rooms;
	}

	/**
	 * Returns the rooms with the primary key or throws a <code>NoSuchRoomsException</code> if it could not be found.
	 *
	 * @param roomId the primary key of the rooms
	 * @return the rooms
	 * @throws NoSuchRoomsException if a rooms with the primary key could not be found
	 */
	@Override
	public Rooms findByPrimaryKey(int roomId) throws NoSuchRoomsException {
		return findByPrimaryKey((Serializable)roomId);
	}

	/**
	 * Returns the rooms with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roomId the primary key of the rooms
	 * @return the rooms, or <code>null</code> if a rooms with the primary key could not be found
	 */
	@Override
	public Rooms fetchByPrimaryKey(int roomId) {
		return fetchByPrimaryKey((Serializable)roomId);
	}

	/**
	 * Returns all the roomses.
	 *
	 * @return the roomses
	 */
	@Override
	public List<Rooms> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the roomses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of roomses
	 * @param end the upper bound of the range of roomses (not inclusive)
	 * @return the range of roomses
	 */
	@Override
	public List<Rooms> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the roomses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of roomses
	 * @param end the upper bound of the range of roomses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of roomses
	 */
	@Override
	public List<Rooms> findAll(
		int start, int end, OrderByComparator<Rooms> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the roomses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoomsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of roomses
	 * @param end the upper bound of the range of roomses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of roomses
	 */
	@Override
	public List<Rooms> findAll(
		int start, int end, OrderByComparator<Rooms> orderByComparator,
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

		List<Rooms> list = null;

		if (useFinderCache) {
			list = (List<Rooms>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ROOMS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ROOMS;

				sql = sql.concat(RoomsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Rooms>)QueryUtil.list(
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
	 * Removes all the roomses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Rooms rooms : findAll()) {
			remove(rooms);
		}
	}

	/**
	 * Returns the number of roomses.
	 *
	 * @return the number of roomses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ROOMS);

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
		return "roomId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ROOMS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RoomsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rooms persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new RoomsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Rooms.class.getName()));

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

		_setRoomsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setRoomsUtilPersistence(null);

		entityCache.removeCache(RoomsImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setRoomsUtilPersistence(RoomsPersistence roomsPersistence) {
		try {
			Field field = RoomsUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, roomsPersistence);
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

	private static final String _SQL_SELECT_ROOMS =
		"SELECT rooms FROM Rooms rooms";

	private static final String _SQL_COUNT_ROOMS =
		"SELECT COUNT(rooms) FROM Rooms rooms";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rooms.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Rooms exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		RoomsPersistenceImpl.class);

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

	private static class RoomsModelArgumentsResolver
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

			RoomsModelImpl roomsModelImpl = (RoomsModelImpl)baseModel;

			long columnBitmask = roomsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(roomsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= roomsModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(roomsModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			RoomsModelImpl roomsModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = roomsModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = roomsModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}