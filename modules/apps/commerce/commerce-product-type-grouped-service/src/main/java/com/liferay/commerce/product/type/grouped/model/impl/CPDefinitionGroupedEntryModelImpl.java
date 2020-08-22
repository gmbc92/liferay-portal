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

package com.liferay.commerce.product.type.grouped.model.impl;

import com.liferay.commerce.product.type.grouped.model.CPDefinitionGroupedEntry;
import com.liferay.commerce.product.type.grouped.model.CPDefinitionGroupedEntryModel;
import com.liferay.commerce.product.type.grouped.model.CPDefinitionGroupedEntrySoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CPDefinitionGroupedEntry service. Represents a row in the &quot;CPDefinitionGroupedEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CPDefinitionGroupedEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CPDefinitionGroupedEntryImpl}.
 * </p>
 *
 * @author Andrea Di Giorgi
 * @see CPDefinitionGroupedEntryImpl
 * @generated
 */
@JSON(strict = true)
public class CPDefinitionGroupedEntryModelImpl
	extends BaseModelImpl<CPDefinitionGroupedEntry>
	implements CPDefinitionGroupedEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cp definition grouped entry model instance should use the <code>CPDefinitionGroupedEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "CPDefinitionGroupedEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"CPDefinitionGroupedEntryId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"CPDefinitionId", Types.BIGINT}, {"entryCProductId", Types.BIGINT},
		{"priority", Types.DOUBLE}, {"quantity", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CPDefinitionGroupedEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("CPDefinitionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("entryCProductId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("priority", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("quantity", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CPDefinitionGroupedEntry (uuid_ VARCHAR(75) null,CPDefinitionGroupedEntryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,CPDefinitionId LONG,entryCProductId LONG,priority DOUBLE,quantity INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table CPDefinitionGroupedEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cpDefinitionGroupedEntry.priority ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CPDefinitionGroupedEntry.priority ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean ENTITY_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean FINDER_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean COLUMN_BITMASK_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CPDEFINITIONID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ENTRYCPRODUCTID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long PRIORITY_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CPDefinitionGroupedEntry toModel(
		CPDefinitionGroupedEntrySoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CPDefinitionGroupedEntry model = new CPDefinitionGroupedEntryImpl();

		model.setUuid(soapModel.getUuid());
		model.setCPDefinitionGroupedEntryId(
			soapModel.getCPDefinitionGroupedEntryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCPDefinitionId(soapModel.getCPDefinitionId());
		model.setEntryCProductId(soapModel.getEntryCProductId());
		model.setPriority(soapModel.getPriority());
		model.setQuantity(soapModel.getQuantity());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<CPDefinitionGroupedEntry> toModels(
		CPDefinitionGroupedEntrySoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CPDefinitionGroupedEntry> models =
			new ArrayList<CPDefinitionGroupedEntry>(soapModels.length);

		for (CPDefinitionGroupedEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.product.type.grouped.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.product.type.grouped.model.CPDefinitionGroupedEntry"));

	public CPDefinitionGroupedEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _CPDefinitionGroupedEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCPDefinitionGroupedEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CPDefinitionGroupedEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CPDefinitionGroupedEntry.class;
	}

	@Override
	public String getModelClassName() {
		return CPDefinitionGroupedEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CPDefinitionGroupedEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CPDefinitionGroupedEntry, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDefinitionGroupedEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CPDefinitionGroupedEntry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CPDefinitionGroupedEntry, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CPDefinitionGroupedEntry, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CPDefinitionGroupedEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CPDefinitionGroupedEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CPDefinitionGroupedEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CPDefinitionGroupedEntry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CPDefinitionGroupedEntry.class.getClassLoader(),
			CPDefinitionGroupedEntry.class, ModelWrapper.class);

		try {
			Constructor<CPDefinitionGroupedEntry> constructor =
				(Constructor<CPDefinitionGroupedEntry>)
					proxyClass.getConstructor(InvocationHandler.class);

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

	private static final Map<String, Function<CPDefinitionGroupedEntry, Object>>
		_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<CPDefinitionGroupedEntry, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<CPDefinitionGroupedEntry, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CPDefinitionGroupedEntry, Object>>();
		Map<String, BiConsumer<CPDefinitionGroupedEntry, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CPDefinitionGroupedEntry, ?>>();

		attributeGetterFunctions.put("uuid", CPDefinitionGroupedEntry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<CPDefinitionGroupedEntry, String>)
				CPDefinitionGroupedEntry::setUuid);
		attributeGetterFunctions.put(
			"CPDefinitionGroupedEntryId",
			CPDefinitionGroupedEntry::getCPDefinitionGroupedEntryId);
		attributeSetterBiConsumers.put(
			"CPDefinitionGroupedEntryId",
			(BiConsumer<CPDefinitionGroupedEntry, Long>)
				CPDefinitionGroupedEntry::setCPDefinitionGroupedEntryId);
		attributeGetterFunctions.put(
			"groupId", CPDefinitionGroupedEntry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<CPDefinitionGroupedEntry, Long>)
				CPDefinitionGroupedEntry::setGroupId);
		attributeGetterFunctions.put(
			"companyId", CPDefinitionGroupedEntry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CPDefinitionGroupedEntry, Long>)
				CPDefinitionGroupedEntry::setCompanyId);
		attributeGetterFunctions.put(
			"userId", CPDefinitionGroupedEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CPDefinitionGroupedEntry, Long>)
				CPDefinitionGroupedEntry::setUserId);
		attributeGetterFunctions.put(
			"userName", CPDefinitionGroupedEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CPDefinitionGroupedEntry, String>)
				CPDefinitionGroupedEntry::setUserName);
		attributeGetterFunctions.put(
			"createDate", CPDefinitionGroupedEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CPDefinitionGroupedEntry, Date>)
				CPDefinitionGroupedEntry::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CPDefinitionGroupedEntry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CPDefinitionGroupedEntry, Date>)
				CPDefinitionGroupedEntry::setModifiedDate);
		attributeGetterFunctions.put(
			"CPDefinitionId", CPDefinitionGroupedEntry::getCPDefinitionId);
		attributeSetterBiConsumers.put(
			"CPDefinitionId",
			(BiConsumer<CPDefinitionGroupedEntry, Long>)
				CPDefinitionGroupedEntry::setCPDefinitionId);
		attributeGetterFunctions.put(
			"entryCProductId", CPDefinitionGroupedEntry::getEntryCProductId);
		attributeSetterBiConsumers.put(
			"entryCProductId",
			(BiConsumer<CPDefinitionGroupedEntry, Long>)
				CPDefinitionGroupedEntry::setEntryCProductId);
		attributeGetterFunctions.put(
			"priority", CPDefinitionGroupedEntry::getPriority);
		attributeSetterBiConsumers.put(
			"priority",
			(BiConsumer<CPDefinitionGroupedEntry, Double>)
				CPDefinitionGroupedEntry::setPriority);
		attributeGetterFunctions.put(
			"quantity", CPDefinitionGroupedEntry::getQuantity);
		attributeSetterBiConsumers.put(
			"quantity",
			(BiConsumer<CPDefinitionGroupedEntry, Integer>)
				CPDefinitionGroupedEntry::setQuantity);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("uuid_");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getCPDefinitionGroupedEntryId() {
		return _CPDefinitionGroupedEntryId;
	}

	@Override
	public void setCPDefinitionGroupedEntryId(long CPDefinitionGroupedEntryId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("CPDefinitionGroupedEntryId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_CPDefinitionGroupedEntryId = CPDefinitionGroupedEntryId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("groupId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("companyId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("userId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("userName");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("createDate");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("modifiedDate");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCPDefinitionId() {
		return _CPDefinitionId;
	}

	@Override
	public void setCPDefinitionId(long CPDefinitionId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("CPDefinitionId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_CPDefinitionId = CPDefinitionId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCPDefinitionId() {
		return GetterUtil.getLong(getColumnOriginalValue("CPDefinitionId"));
	}

	@JSON
	@Override
	public long getEntryCProductId() {
		return _entryCProductId;
	}

	@Override
	public void setEntryCProductId(long entryCProductId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("entryCProductId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_entryCProductId = entryCProductId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalEntryCProductId() {
		return GetterUtil.getLong(getColumnOriginalValue("entryCProductId"));
	}

	@JSON
	@Override
	public double getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(double priority) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("priority");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_priority = priority;
	}

	@JSON
	@Override
	public int getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("quantity");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_quantity = quantity;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(
				CPDefinitionGroupedEntry.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CPDefinitionGroupedEntry.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CPDefinitionGroupedEntry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CPDefinitionGroupedEntry>
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
		CPDefinitionGroupedEntryImpl cpDefinitionGroupedEntryImpl =
			new CPDefinitionGroupedEntryImpl();

		cpDefinitionGroupedEntryImpl.setUuid(getUuid());
		cpDefinitionGroupedEntryImpl.setCPDefinitionGroupedEntryId(
			getCPDefinitionGroupedEntryId());
		cpDefinitionGroupedEntryImpl.setGroupId(getGroupId());
		cpDefinitionGroupedEntryImpl.setCompanyId(getCompanyId());
		cpDefinitionGroupedEntryImpl.setUserId(getUserId());
		cpDefinitionGroupedEntryImpl.setUserName(getUserName());
		cpDefinitionGroupedEntryImpl.setCreateDate(getCreateDate());
		cpDefinitionGroupedEntryImpl.setModifiedDate(getModifiedDate());
		cpDefinitionGroupedEntryImpl.setCPDefinitionId(getCPDefinitionId());
		cpDefinitionGroupedEntryImpl.setEntryCProductId(getEntryCProductId());
		cpDefinitionGroupedEntryImpl.setPriority(getPriority());
		cpDefinitionGroupedEntryImpl.setQuantity(getQuantity());

		cpDefinitionGroupedEntryImpl.resetOriginalValues();

		return cpDefinitionGroupedEntryImpl;
	}

	@Override
	public int compareTo(CPDefinitionGroupedEntry cpDefinitionGroupedEntry) {
		int value = 0;

		if (getPriority() < cpDefinitionGroupedEntry.getPriority()) {
			value = -1;
		}
		else if (getPriority() > cpDefinitionGroupedEntry.getPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CPDefinitionGroupedEntry)) {
			return false;
		}

		CPDefinitionGroupedEntry cpDefinitionGroupedEntry =
			(CPDefinitionGroupedEntry)object;

		long primaryKey = cpDefinitionGroupedEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CPDefinitionGroupedEntry> toCacheModel() {
		CPDefinitionGroupedEntryCacheModel cpDefinitionGroupedEntryCacheModel =
			new CPDefinitionGroupedEntryCacheModel();

		cpDefinitionGroupedEntryCacheModel.uuid = getUuid();

		String uuid = cpDefinitionGroupedEntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cpDefinitionGroupedEntryCacheModel.uuid = null;
		}

		cpDefinitionGroupedEntryCacheModel.CPDefinitionGroupedEntryId =
			getCPDefinitionGroupedEntryId();

		cpDefinitionGroupedEntryCacheModel.groupId = getGroupId();

		cpDefinitionGroupedEntryCacheModel.companyId = getCompanyId();

		cpDefinitionGroupedEntryCacheModel.userId = getUserId();

		cpDefinitionGroupedEntryCacheModel.userName = getUserName();

		String userName = cpDefinitionGroupedEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cpDefinitionGroupedEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cpDefinitionGroupedEntryCacheModel.createDate =
				createDate.getTime();
		}
		else {
			cpDefinitionGroupedEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cpDefinitionGroupedEntryCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			cpDefinitionGroupedEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cpDefinitionGroupedEntryCacheModel.CPDefinitionId = getCPDefinitionId();

		cpDefinitionGroupedEntryCacheModel.entryCProductId =
			getEntryCProductId();

		cpDefinitionGroupedEntryCacheModel.priority = getPriority();

		cpDefinitionGroupedEntryCacheModel.quantity = getQuantity();

		return cpDefinitionGroupedEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CPDefinitionGroupedEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CPDefinitionGroupedEntry, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDefinitionGroupedEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((CPDefinitionGroupedEntry)this));
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
		Map<String, Function<CPDefinitionGroupedEntry, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CPDefinitionGroupedEntry, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CPDefinitionGroupedEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((CPDefinitionGroupedEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, CPDefinitionGroupedEntry>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private String _uuid;
	private long _CPDefinitionGroupedEntryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _CPDefinitionId;
	private long _entryCProductId;
	private double _priority;
	private int _quantity;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
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

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put(
			"CPDefinitionGroupedEntryId", _CPDefinitionGroupedEntryId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("CPDefinitionId", _CPDefinitionId);
		_columnOriginalValues.put("entryCProductId", _entryCProductId);
		_columnOriginalValues.put("priority", _priority);
		_columnOriginalValues.put("quantity", _quantity);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new LinkedHashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("CPDefinitionGroupedEntryId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("CPDefinitionId", 256L);

		columnBitmasks.put("entryCProductId", 512L);

		columnBitmasks.put("priority", 1024L);

		columnBitmasks.put("quantity", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private transient Map<String, Object> _columnOriginalValues;
	private long _columnBitmask;
	private CPDefinitionGroupedEntry _escapedModel;

}