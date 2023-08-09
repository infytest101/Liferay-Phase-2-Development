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

import hotelmanagement.services.exception.NoSuchBookingDetailsException;
import hotelmanagement.services.model.BookingDetails;
import hotelmanagement.services.model.impl.BookingDetailsImpl;
import hotelmanagement.services.model.impl.BookingDetailsModelImpl;
import hotelmanagement.services.service.persistence.BookingDetailsPersistence;
import hotelmanagement.services.service.persistence.BookingDetailsUtil;
import hotelmanagement.services.service.persistence.impl.constants.HotelPersistenceConstants;

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
 * The persistence implementation for the booking details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BookingDetailsPersistence.class)
public class BookingDetailsPersistenceImpl
	extends BasePersistenceImpl<BookingDetails>
	implements BookingDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BookingDetailsUtil</code> to access the booking details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BookingDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public BookingDetailsPersistenceImpl() {
		setModelClass(BookingDetails.class);

		setModelImplClass(BookingDetailsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the booking details in the entity cache if it is enabled.
	 *
	 * @param bookingDetails the booking details
	 */
	@Override
	public void cacheResult(BookingDetails bookingDetails) {
		entityCache.putResult(
			BookingDetailsImpl.class, bookingDetails.getPrimaryKey(),
			bookingDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the booking detailses in the entity cache if it is enabled.
	 *
	 * @param bookingDetailses the booking detailses
	 */
	@Override
	public void cacheResult(List<BookingDetails> bookingDetailses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bookingDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BookingDetails bookingDetails : bookingDetailses) {
			if (entityCache.getResult(
					BookingDetailsImpl.class, bookingDetails.getPrimaryKey()) ==
						null) {

				cacheResult(bookingDetails);
			}
		}
	}

	/**
	 * Clears the cache for all booking detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BookingDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the booking details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BookingDetails bookingDetails) {
		entityCache.removeResult(BookingDetailsImpl.class, bookingDetails);
	}

	@Override
	public void clearCache(List<BookingDetails> bookingDetailses) {
		for (BookingDetails bookingDetails : bookingDetailses) {
			entityCache.removeResult(BookingDetailsImpl.class, bookingDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BookingDetailsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new booking details with the primary key. Does not add the booking details to the database.
	 *
	 * @param bookingDetailsId the primary key for the new booking details
	 * @return the new booking details
	 */
	@Override
	public BookingDetails create(long bookingDetailsId) {
		BookingDetails bookingDetails = new BookingDetailsImpl();

		bookingDetails.setNew(true);
		bookingDetails.setPrimaryKey(bookingDetailsId);

		return bookingDetails;
	}

	/**
	 * Removes the booking details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingDetailsId the primary key of the booking details
	 * @return the booking details that was removed
	 * @throws NoSuchBookingDetailsException if a booking details with the primary key could not be found
	 */
	@Override
	public BookingDetails remove(long bookingDetailsId)
		throws NoSuchBookingDetailsException {

		return remove((Serializable)bookingDetailsId);
	}

	/**
	 * Removes the booking details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the booking details
	 * @return the booking details that was removed
	 * @throws NoSuchBookingDetailsException if a booking details with the primary key could not be found
	 */
	@Override
	public BookingDetails remove(Serializable primaryKey)
		throws NoSuchBookingDetailsException {

		Session session = null;

		try {
			session = openSession();

			BookingDetails bookingDetails = (BookingDetails)session.get(
				BookingDetailsImpl.class, primaryKey);

			if (bookingDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookingDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bookingDetails);
		}
		catch (NoSuchBookingDetailsException noSuchEntityException) {
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
	protected BookingDetails removeImpl(BookingDetails bookingDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bookingDetails)) {
				bookingDetails = (BookingDetails)session.get(
					BookingDetailsImpl.class,
					bookingDetails.getPrimaryKeyObj());
			}

			if (bookingDetails != null) {
				session.delete(bookingDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bookingDetails != null) {
			clearCache(bookingDetails);
		}

		return bookingDetails;
	}

	@Override
	public BookingDetails updateImpl(BookingDetails bookingDetails) {
		boolean isNew = bookingDetails.isNew();

		if (!(bookingDetails instanceof BookingDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bookingDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					bookingDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bookingDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BookingDetails implementation " +
					bookingDetails.getClass());
		}

		BookingDetailsModelImpl bookingDetailsModelImpl =
			(BookingDetailsModelImpl)bookingDetails;

		if (isNew && (bookingDetails.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				bookingDetails.setCreateDate(date);
			}
			else {
				bookingDetails.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bookingDetails);
			}
			else {
				bookingDetails = (BookingDetails)session.merge(bookingDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BookingDetailsImpl.class, bookingDetails, false, true);

		if (isNew) {
			bookingDetails.setNew(false);
		}

		bookingDetails.resetOriginalValues();

		return bookingDetails;
	}

	/**
	 * Returns the booking details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the booking details
	 * @return the booking details
	 * @throws NoSuchBookingDetailsException if a booking details with the primary key could not be found
	 */
	@Override
	public BookingDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBookingDetailsException {

		BookingDetails bookingDetails = fetchByPrimaryKey(primaryKey);

		if (bookingDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBookingDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bookingDetails;
	}

	/**
	 * Returns the booking details with the primary key or throws a <code>NoSuchBookingDetailsException</code> if it could not be found.
	 *
	 * @param bookingDetailsId the primary key of the booking details
	 * @return the booking details
	 * @throws NoSuchBookingDetailsException if a booking details with the primary key could not be found
	 */
	@Override
	public BookingDetails findByPrimaryKey(long bookingDetailsId)
		throws NoSuchBookingDetailsException {

		return findByPrimaryKey((Serializable)bookingDetailsId);
	}

	/**
	 * Returns the booking details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookingDetailsId the primary key of the booking details
	 * @return the booking details, or <code>null</code> if a booking details with the primary key could not be found
	 */
	@Override
	public BookingDetails fetchByPrimaryKey(long bookingDetailsId) {
		return fetchByPrimaryKey((Serializable)bookingDetailsId);
	}

	/**
	 * Returns all the booking detailses.
	 *
	 * @return the booking detailses
	 */
	@Override
	public List<BookingDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the booking detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking detailses
	 * @param end the upper bound of the range of booking detailses (not inclusive)
	 * @return the range of booking detailses
	 */
	@Override
	public List<BookingDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the booking detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking detailses
	 * @param end the upper bound of the range of booking detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of booking detailses
	 */
	@Override
	public List<BookingDetails> findAll(
		int start, int end,
		OrderByComparator<BookingDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the booking detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookingDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of booking detailses
	 * @param end the upper bound of the range of booking detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of booking detailses
	 */
	@Override
	public List<BookingDetails> findAll(
		int start, int end, OrderByComparator<BookingDetails> orderByComparator,
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

		List<BookingDetails> list = null;

		if (useFinderCache) {
			list = (List<BookingDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOOKINGDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKINGDETAILS;

				sql = sql.concat(BookingDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BookingDetails>)QueryUtil.list(
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
	 * Removes all the booking detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BookingDetails bookingDetails : findAll()) {
			remove(bookingDetails);
		}
	}

	/**
	 * Returns the number of booking detailses.
	 *
	 * @return the number of booking detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BOOKINGDETAILS);

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
		return "bookingDetailsId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BOOKINGDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BookingDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the booking details persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new BookingDetailsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", BookingDetails.class.getName()));

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

		_setBookingDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBookingDetailsUtilPersistence(null);

		entityCache.removeCache(BookingDetailsImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setBookingDetailsUtilPersistence(
		BookingDetailsPersistence bookingDetailsPersistence) {

		try {
			Field field = BookingDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, bookingDetailsPersistence);
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

	private static final String _SQL_SELECT_BOOKINGDETAILS =
		"SELECT bookingDetails FROM BookingDetails bookingDetails";

	private static final String _SQL_COUNT_BOOKINGDETAILS =
		"SELECT COUNT(bookingDetails) FROM BookingDetails bookingDetails";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bookingDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BookingDetails exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		BookingDetailsPersistenceImpl.class);

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

	private static class BookingDetailsModelArgumentsResolver
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

			BookingDetailsModelImpl bookingDetailsModelImpl =
				(BookingDetailsModelImpl)baseModel;

			long columnBitmask = bookingDetailsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					bookingDetailsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						bookingDetailsModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					bookingDetailsModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			BookingDetailsModelImpl bookingDetailsModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						bookingDetailsModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = bookingDetailsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}