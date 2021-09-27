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

package com.liferay.portal.kernel.dao.db;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.lang.SafeCloseable;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.ThrowableCollector;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.util.LoggingTimer;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import javax.naming.NamingException;

/**
 * @author Hugo Huijser
 * @author Brian Wing Shun Chan
 */
public abstract class BaseDBProcess implements DBProcess {

	@Override
	public void runSQL(Connection connection, String template)
		throws IOException, SQLException {

		DB db = DBManagerUtil.getDB();

		db.runSQL(connection, template);
	}

	@Override
	public void runSQL(DBTypeToSQLMap dbTypeToSQLMap)
		throws IOException, SQLException {

		DB db = DBManagerUtil.getDB();

		if (connection == null) {
			db.runSQL(dbTypeToSQLMap);
		}
		else {
			db.runSQL(connection, dbTypeToSQLMap);
		}
	}

	@Override
	public void runSQL(String template) throws IOException, SQLException {
		DB db = DBManagerUtil.getDB();

		if (connection == null) {
			db.runSQL(template);
		}
		else {
			db.runSQL(connection, template);
		}
	}

	@Override
	public void runSQL(String[] templates) throws IOException, SQLException {
		DB db = DBManagerUtil.getDB();

		if (connection == null) {
			db.runSQL(templates);
		}
		else {
			db.runSQL(connection, templates);
		}
	}

	@Override
	public void runSQLTemplate(String path)
		throws IOException, NamingException, SQLException {

		runSQLTemplate(path, true);
	}

	@Override
	public void runSQLTemplate(String path, boolean failOnError)
		throws IOException, NamingException, SQLException {

		try (LoggingTimer loggingTimer = new LoggingTimer(path)) {
			ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();

			InputStream inputStream = classLoader.getResourceAsStream(
				"com/liferay/portal/tools/sql/dependencies/" + path);

			if (inputStream == null) {
				inputStream = classLoader.getResourceAsStream(path);
			}

			if (inputStream == null) {
				Thread currentThread = Thread.currentThread();

				classLoader = currentThread.getContextClassLoader();

				inputStream = classLoader.getResourceAsStream(path);
			}

			if (inputStream == null) {
				_log.error("Invalid path " + path);

				if (failOnError) {
					throw new IOException("Invalid path " + path);
				}

				return;
			}

			String template = StringUtil.read(inputStream);

			runSQLTemplateString(template, failOnError);
		}
	}

	@Override
	public void runSQLTemplateString(String template, boolean failOnError)
		throws IOException, NamingException, SQLException {

		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			DB db = DBManagerUtil.getDB();

			if (connection == null) {
				db.runSQLTemplateString(template, failOnError);
			}
			else {
				db.runSQLTemplateString(connection, template, failOnError);
			}
		}
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #runSQLTemplateString(String, boolean)}
	 */
	@Deprecated
	@Override
	public void runSQLTemplateString(
			String template, boolean evaluate, boolean failOnError)
		throws IOException, NamingException, SQLException {

		runSQLTemplateString(template, failOnError);
	}

	protected boolean doHasTable(String tableName) throws Exception {
		DBInspector dbInspector = new DBInspector(connection);

		return dbInspector.hasTable(tableName, true);
	}

	protected boolean hasColumn(String tableName, String columnName)
		throws Exception {

		DBInspector dbInspector = new DBInspector(connection);

		return dbInspector.hasColumn(tableName, columnName);
	}

	/**
	 * @deprecated As of Mueller (7.2.x), replaced by {@link
	 *             #hasColumnType(String, String, String)}
	 */
	@Deprecated
	protected boolean hasColumnType(
			Class<?> tableClass, String columnName, String columnType)
		throws Exception {

		DBInspector dbInspector = new DBInspector(connection);

		return dbInspector.hasColumnType(tableClass, columnName, columnType);
	}

	protected boolean hasColumnType(
			String tableName, String columnName, String columnType)
		throws Exception {

		DBInspector dbInspector = new DBInspector(connection);

		return dbInspector.hasColumnType(tableName, columnName, columnType);
	}

	protected boolean hasIndex(String tableName, String indexName)
		throws Exception {

		DBInspector dbInspector = new DBInspector(connection);

		return dbInspector.hasIndex(tableName, indexName);
	}

	protected boolean hasRows(Connection connection, String tableName) {
		DBInspector dbInspector = new DBInspector(connection);

		return dbInspector.hasRows(tableName);
	}

	protected boolean hasRows(String tableName) throws Exception {
		return hasRows(connection, tableName);
	}

	protected boolean hasTable(String tableName) throws Exception {
		DBInspector dbInspector = new DBInspector(connection);

		return dbInspector.hasTable(tableName);
	}

	protected void process(UnsafeConsumer<Long, Exception> unsafeConsumer)
		throws Exception {

		DB db = DBManagerUtil.getDB();

		db.process(unsafeConsumer);
	}

	protected void processConcurrently(
			PreparedStatement preparedStatement,
			UnsafeConsumer<ResultRow, Exception> unsafeConsumer,
			String exceptionMessage)
		throws Exception {

		try (ResultSet resultSet = preparedStatement.executeQuery()) {
			_processConcurrently(
				() -> {
					if (resultSet.next()) {
						return new ResultRow(resultSet);
					}

					return null;
				},
				unsafeConsumer, exceptionMessage);
		}
	}

	protected void processConcurrently(
			String sqlQuery,
			UnsafeConsumer<ResultRow, Exception> unsafeConsumer,
			String exceptionMessage)
		throws Exception {

		try (Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlQuery)) {

			_processConcurrently(
				() -> {
					if (resultSet.next()) {
						return new ResultRow(resultSet);
					}

					return null;
				},
				unsafeConsumer, exceptionMessage);
		}
	}

	protected <T> void processConcurrently(
			T[] array, UnsafeConsumer<T, Exception> unsafeConsumer,
			String exceptionMessage)
		throws Exception {

		AtomicInteger atomicInteger = new AtomicInteger();

		_processConcurrently(
			() -> {
				int index = atomicInteger.getAndIncrement();

				if (index < array.length) {
					return array[index];
				}

				return null;
			},
			unsafeConsumer, exceptionMessage);
	}

	protected Connection connection;

	protected static class ResultRow {

		public ResultRow(ResultSet resultSet) throws SQLException {
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

			int columnCount = resultSetMetaData.getColumnCount();

			_columns = new LinkedHashMap<>(columnCount);

			for (int i = 1; i <= columnCount; i++) {
				_columns.put(
					StringUtil.toLowerCase(resultSetMetaData.getColumnLabel(i)),
					resultSet.getObject(i));
			}
		}

		public <T> T get(int columnIndex) throws SQLException {
			int i = 1;

			for (Map.Entry<Object, Object> entry : _columns.entrySet()) {
				if (i++ == columnIndex) {
					return (T)entry.getValue();
				}
			}

			throw new SQLException("Invalid column index");
		}

		public <T> T get(String columnLabel) throws SQLException {
			T value = (T)_columns.get(StringUtil.toLowerCase(columnLabel));

			if (value == null) {
				throw new SQLException("Invalid column name");
			}

			return value;
		}

		private final Map<Object, Object> _columns;

	}

	private <T> void _processConcurrently(
			UnsafeSupplier<T, Exception> unsafeSupplier,
			UnsafeConsumer<T, Exception> unsafeConsumer,
			String exceptionMessage)
		throws Exception {

		Objects.requireNonNull(unsafeSupplier);
		Objects.requireNonNull(unsafeConsumer);

		ExecutorService executorService = Executors.newWorkStealingPool();

		ThrowableCollector throwableCollector = new ThrowableCollector();

		List<Future<Void>> futures = new ArrayList<>();

		try {
			long companyId = CompanyThreadLocal.getCompanyId();

			T next = null;

			while ((next = unsafeSupplier.get()) != null) {
				T current = next;

				Future<Void> future = executorService.submit(
					() -> {
						try (SafeCloseable safeCloseable =
								CompanyThreadLocal.lock(companyId)) {

							unsafeConsumer.accept(current);
						}
						catch (Exception exception) {
							throwableCollector.collect(exception);
						}

						return null;
					});

				futures.add(future);
			}
		}
		finally {
			executorService.shutdown();

			for (Future<Void> future : futures) {
				future.get();
			}
		}

		Throwable throwable = throwableCollector.getThrowable();

		if (throwable != null) {
			if (exceptionMessage != null) {
				throw new Exception(exceptionMessage, throwable);
			}

			ReflectionUtil.throwException(throwable);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(BaseDBProcess.class);

}