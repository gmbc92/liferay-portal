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

package com.liferay.commerce.model.impl;

import com.liferay.commerce.model.CommerceAddressRestriction;
import com.liferay.commerce.model.CommerceAddressRestrictionModel;
import com.liferay.commerce.model.CommerceAddressRestrictionSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;

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
 * The base model implementation for the CommerceAddressRestriction service. Represents a row in the &quot;CommerceAddressRestriction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CommerceAddressRestrictionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceAddressRestrictionImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceAddressRestrictionImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceAddressRestrictionModelImpl
	extends BaseModelImpl<CommerceAddressRestriction>
	implements CommerceAddressRestrictionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce address restriction model instance should use the <code>CommerceAddressRestriction</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommerceAddressRestriction";

	public static final Object[][] TABLE_COLUMNS = {
		{"commerceAddressRestrictionId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"classNameId", Types.BIGINT}, {"classPK", Types.BIGINT},
		{"commerceCountryId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("commerceAddressRestrictionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commerceCountryId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommerceAddressRestriction (commerceAddressRestrictionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,commerceCountryId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table CommerceAddressRestriction";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceAddressRestriction.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommerceAddressRestriction.createDate DESC";

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
	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CLASSPK_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long COMMERCECOUNTRYID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long CREATEDATE_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static CommerceAddressRestriction toModel(
		CommerceAddressRestrictionSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommerceAddressRestriction model = new CommerceAddressRestrictionImpl();

		model.setCommerceAddressRestrictionId(
			soapModel.getCommerceAddressRestrictionId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setCommerceCountryId(soapModel.getCommerceCountryId());

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
	public static List<CommerceAddressRestriction> toModels(
		CommerceAddressRestrictionSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceAddressRestriction> models =
			new ArrayList<CommerceAddressRestriction>(soapModels.length);

		for (CommerceAddressRestrictionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.model.CommerceAddressRestriction"));

	public CommerceAddressRestrictionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceAddressRestrictionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceAddressRestrictionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceAddressRestrictionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceAddressRestriction.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceAddressRestriction.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceAddressRestriction, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceAddressRestriction, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceAddressRestriction, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(CommerceAddressRestriction)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceAddressRestriction, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceAddressRestriction, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceAddressRestriction)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceAddressRestriction, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceAddressRestriction, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceAddressRestriction>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceAddressRestriction.class.getClassLoader(),
			CommerceAddressRestriction.class, ModelWrapper.class);

		try {
			Constructor<CommerceAddressRestriction> constructor =
				(Constructor<CommerceAddressRestriction>)
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

	private static final Map
		<String, Function<CommerceAddressRestriction, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<CommerceAddressRestriction, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceAddressRestriction, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CommerceAddressRestriction, Object>>();
		Map<String, BiConsumer<CommerceAddressRestriction, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CommerceAddressRestriction, ?>>();

		attributeGetterFunctions.put(
			"commerceAddressRestrictionId",
			CommerceAddressRestriction::getCommerceAddressRestrictionId);
		attributeSetterBiConsumers.put(
			"commerceAddressRestrictionId",
			(BiConsumer<CommerceAddressRestriction, Long>)
				CommerceAddressRestriction::setCommerceAddressRestrictionId);
		attributeGetterFunctions.put(
			"groupId", CommerceAddressRestriction::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<CommerceAddressRestriction, Long>)
				CommerceAddressRestriction::setGroupId);
		attributeGetterFunctions.put(
			"companyId", CommerceAddressRestriction::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<CommerceAddressRestriction, Long>)
				CommerceAddressRestriction::setCompanyId);
		attributeGetterFunctions.put(
			"userId", CommerceAddressRestriction::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CommerceAddressRestriction, Long>)
				CommerceAddressRestriction::setUserId);
		attributeGetterFunctions.put(
			"userName", CommerceAddressRestriction::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CommerceAddressRestriction, String>)
				CommerceAddressRestriction::setUserName);
		attributeGetterFunctions.put(
			"createDate", CommerceAddressRestriction::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CommerceAddressRestriction, Date>)
				CommerceAddressRestriction::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CommerceAddressRestriction::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CommerceAddressRestriction, Date>)
				CommerceAddressRestriction::setModifiedDate);
		attributeGetterFunctions.put(
			"classNameId", CommerceAddressRestriction::getClassNameId);
		attributeSetterBiConsumers.put(
			"classNameId",
			(BiConsumer<CommerceAddressRestriction, Long>)
				CommerceAddressRestriction::setClassNameId);
		attributeGetterFunctions.put(
			"classPK", CommerceAddressRestriction::getClassPK);
		attributeSetterBiConsumers.put(
			"classPK",
			(BiConsumer<CommerceAddressRestriction, Long>)
				CommerceAddressRestriction::setClassPK);
		attributeGetterFunctions.put(
			"commerceCountryId",
			CommerceAddressRestriction::getCommerceCountryId);
		attributeSetterBiConsumers.put(
			"commerceCountryId",
			(BiConsumer<CommerceAddressRestriction, Long>)
				CommerceAddressRestriction::setCommerceCountryId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCommerceAddressRestrictionId() {
		return _commerceAddressRestrictionId;
	}

	@Override
	public void setCommerceAddressRestrictionId(
		long commerceAddressRestrictionId) {

		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get(
				"commerceAddressRestrictionId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_commerceAddressRestrictionId = commerceAddressRestrictionId;
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

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return "";
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@JSON
	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("classNameId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_classNameId = classNameId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalClassNameId() {
		return GetterUtil.getLong(getColumnOriginalValue("classNameId"));
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("classPK");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_classPK = classPK;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalClassPK() {
		return GetterUtil.getLong(getColumnOriginalValue("classPK"));
	}

	@JSON
	@Override
	public long getCommerceCountryId() {
		return _commerceCountryId;
	}

	@Override
	public void setCommerceCountryId(long commerceCountryId) {
		if (_columnOriginalValues != null) {
			_columnBitmask |= _columnBitmasks.get("commerceCountryId");

			if (_columnOriginalValues == Collections.EMPTY_MAP) {
				_setColumnOriginalValues();
			}
		}

		_commerceCountryId = commerceCountryId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCommerceCountryId() {
		return GetterUtil.getLong(getColumnOriginalValue("commerceCountryId"));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommerceAddressRestriction.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceAddressRestriction toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceAddressRestriction>
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
		CommerceAddressRestrictionImpl commerceAddressRestrictionImpl =
			new CommerceAddressRestrictionImpl();

		commerceAddressRestrictionImpl.setCommerceAddressRestrictionId(
			getCommerceAddressRestrictionId());
		commerceAddressRestrictionImpl.setGroupId(getGroupId());
		commerceAddressRestrictionImpl.setCompanyId(getCompanyId());
		commerceAddressRestrictionImpl.setUserId(getUserId());
		commerceAddressRestrictionImpl.setUserName(getUserName());
		commerceAddressRestrictionImpl.setCreateDate(getCreateDate());
		commerceAddressRestrictionImpl.setModifiedDate(getModifiedDate());
		commerceAddressRestrictionImpl.setClassNameId(getClassNameId());
		commerceAddressRestrictionImpl.setClassPK(getClassPK());
		commerceAddressRestrictionImpl.setCommerceCountryId(
			getCommerceCountryId());

		commerceAddressRestrictionImpl.resetOriginalValues();

		return commerceAddressRestrictionImpl;
	}

	@Override
	public int compareTo(
		CommerceAddressRestriction commerceAddressRestriction) {

		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), commerceAddressRestriction.getCreateDate());

		value = value * -1;

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

		if (!(object instanceof CommerceAddressRestriction)) {
			return false;
		}

		CommerceAddressRestriction commerceAddressRestriction =
			(CommerceAddressRestriction)object;

		long primaryKey = commerceAddressRestriction.getPrimaryKey();

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
	public CacheModel<CommerceAddressRestriction> toCacheModel() {
		CommerceAddressRestrictionCacheModel
			commerceAddressRestrictionCacheModel =
				new CommerceAddressRestrictionCacheModel();

		commerceAddressRestrictionCacheModel.commerceAddressRestrictionId =
			getCommerceAddressRestrictionId();

		commerceAddressRestrictionCacheModel.groupId = getGroupId();

		commerceAddressRestrictionCacheModel.companyId = getCompanyId();

		commerceAddressRestrictionCacheModel.userId = getUserId();

		commerceAddressRestrictionCacheModel.userName = getUserName();

		String userName = commerceAddressRestrictionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceAddressRestrictionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceAddressRestrictionCacheModel.createDate =
				createDate.getTime();
		}
		else {
			commerceAddressRestrictionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceAddressRestrictionCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commerceAddressRestrictionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceAddressRestrictionCacheModel.classNameId = getClassNameId();

		commerceAddressRestrictionCacheModel.classPK = getClassPK();

		commerceAddressRestrictionCacheModel.commerceCountryId =
			getCommerceCountryId();

		return commerceAddressRestrictionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceAddressRestriction, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceAddressRestriction, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceAddressRestriction, Object>
				attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply(
					(CommerceAddressRestriction)this));
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
		Map<String, Function<CommerceAddressRestriction, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceAddressRestriction, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceAddressRestriction, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(CommerceAddressRestriction)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, CommerceAddressRestriction>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private long _commerceAddressRestrictionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _classNameId;
	private long _classPK;
	private long _commerceCountryId;

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

		_columnOriginalValues.put(
			"commerceAddressRestrictionId", _commerceAddressRestrictionId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("classNameId", _classNameId);
		_columnOriginalValues.put("classPK", _classPK);
		_columnOriginalValues.put("commerceCountryId", _commerceCountryId);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new LinkedHashMap<>();

		columnBitmasks.put("commerceAddressRestrictionId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("classNameId", 128L);

		columnBitmasks.put("classPK", 256L);

		columnBitmasks.put("commerceCountryId", 512L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private transient Map<String, Object> _columnOriginalValues;
	private long _columnBitmask;
	private CommerceAddressRestriction _escapedModel;

}