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

package com.liferay.twitter.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Feed. This utility wraps
 * <code>com.liferay.twitter.service.impl.FeedLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FeedLocalService
 * @generated
 */
public class FeedLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.twitter.service.impl.FeedLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the feed to the database. Also notifies the appropriate model listeners.
	 *
	 * @param feed the feed
	 * @return the feed that was added
	 */
	public static com.liferay.twitter.model.Feed addFeed(
		com.liferay.twitter.model.Feed feed) {

		return getService().addFeed(feed);
	}

	/**
	 * Creates a new feed with the primary key. Does not add the feed to the database.
	 *
	 * @param feedId the primary key for the new feed
	 * @return the new feed
	 */
	public static com.liferay.twitter.model.Feed createFeed(long feedId) {
		return getService().createFeed(feedId);
	}

	/**
	 * Deletes the feed from the database. Also notifies the appropriate model listeners.
	 *
	 * @param feed the feed
	 * @return the feed that was removed
	 */
	public static com.liferay.twitter.model.Feed deleteFeed(
		com.liferay.twitter.model.Feed feed) {

		return getService().deleteFeed(feed);
	}

	/**
	 * Deletes the feed with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedId the primary key of the feed
	 * @return the feed that was removed
	 * @throws PortalException if a feed with the primary key could not be found
	 */
	public static com.liferay.twitter.model.Feed deleteFeed(long feedId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteFeed(feedId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.twitter.model.impl.FeedModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.twitter.model.impl.FeedModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.twitter.model.Feed fetchFeed(long feedId) {
		return getService().fetchFeed(feedId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the feed with the primary key.
	 *
	 * @param feedId the primary key of the feed
	 * @return the feed
	 * @throws PortalException if a feed with the primary key could not be found
	 */
	public static com.liferay.twitter.model.Feed getFeed(long feedId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFeed(feedId);
	}

	/**
	 * Returns a range of all the feeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.twitter.model.impl.FeedModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feeds
	 * @param end the upper bound of the range of feeds (not inclusive)
	 * @return the range of feeds
	 */
	public static java.util.List<com.liferay.twitter.model.Feed> getFeeds(
		int start, int end) {

		return getService().getFeeds(start, end);
	}

	/**
	 * Returns the number of feeds.
	 *
	 * @return the number of feeds
	 */
	public static int getFeedsCount() {
		return getService().getFeedsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the feed in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param feed the feed
	 * @return the feed that was updated
	 */
	public static com.liferay.twitter.model.Feed updateFeed(
		com.liferay.twitter.model.Feed feed) {

		return getService().updateFeed(feed);
	}

	public static void updateFeed(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateFeed(userId);
	}

	public static void updateFeeds() {
		getService().updateFeeds();
	}

	public static void updateFeeds(long companyId) {
		getService().updateFeeds(companyId);
	}

	public static FeedLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FeedLocalService, FeedLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FeedLocalService.class);

		ServiceTracker<FeedLocalService, FeedLocalService> serviceTracker =
			new ServiceTracker<FeedLocalService, FeedLocalService>(
				bundle.getBundleContext(), FeedLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}