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

package com.liferay.portal.workflow.kaleo.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.workflow.kaleo.model.KaleoNotification;
import com.liferay.portal.workflow.kaleo.model.KaleoNotificationModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the KaleoNotification service. Represents a row in the &quot;KaleoNotification&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>KaleoNotificationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link KaleoNotificationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoNotificationImpl
 * @generated
 */
public class KaleoNotificationModelImpl
	extends BaseModelImpl<KaleoNotification> implements KaleoNotificationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a kaleo notification model instance should use the <code>KaleoNotification</code> interface instead.
	 */
	public static final String TABLE_NAME = "KaleoNotification";

	public static final Object[][] TABLE_COLUMNS = {
		{"kaleoNotificationId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"kaleoClassName", Types.VARCHAR},
		{"kaleoClassPK", Types.BIGINT}, {"kaleoDefinitionId", Types.BIGINT},
		{"kaleoNodeName", Types.VARCHAR}, {"name", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"executionType", Types.VARCHAR},
		{"template", Types.CLOB}, {"templateLanguage", Types.VARCHAR},
		{"notificationTypes", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("kaleoNotificationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("kaleoClassName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("kaleoClassPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("kaleoDefinitionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("kaleoNodeName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("executionType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("template", Types.CLOB);
		TABLE_COLUMNS_MAP.put("templateLanguage", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("notificationTypes", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table KaleoNotification (kaleoNotificationId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(200) null,createDate DATE null,modifiedDate DATE null,kaleoClassName VARCHAR(200) null,kaleoClassPK LONG,kaleoDefinitionId LONG,kaleoNodeName VARCHAR(200) null,name VARCHAR(200) null,description STRING null,executionType VARCHAR(20) null,template TEXT null,templateLanguage VARCHAR(75) null,notificationTypes VARCHAR(25) null)";

	public static final String TABLE_SQL_DROP = "drop table KaleoNotification";

	public static final String ORDER_BY_JPQL =
		" ORDER BY kaleoNotification.kaleoNotificationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY KaleoNotification.kaleoNotificationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoNotification"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.portal.workflow.kaleo.model.KaleoNotification"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.portal.workflow.kaleo.model.KaleoNotification"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long EXECUTIONTYPE_COLUMN_BITMASK = 2L;

	public static final long KALEOCLASSNAME_COLUMN_BITMASK = 4L;

	public static final long KALEOCLASSPK_COLUMN_BITMASK = 8L;

	public static final long KALEODEFINITIONID_COLUMN_BITMASK = 16L;

	public static final long KALEONOTIFICATIONID_COLUMN_BITMASK = 32L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.workflow.kaleo.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.portal.workflow.kaleo.model.KaleoNotification"));

	public KaleoNotificationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _kaleoNotificationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setKaleoNotificationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kaleoNotificationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return KaleoNotification.class;
	}

	@Override
	public String getModelClassName() {
		return KaleoNotification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<KaleoNotification, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<KaleoNotification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KaleoNotification, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((KaleoNotification)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<KaleoNotification, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<KaleoNotification, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(KaleoNotification)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<KaleoNotification, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<KaleoNotification, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, KaleoNotification>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			KaleoNotification.class.getClassLoader(), KaleoNotification.class,
			ModelWrapper.class);

		try {
			Constructor<KaleoNotification> constructor =
				(Constructor<KaleoNotification>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<KaleoNotification, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<KaleoNotification, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<KaleoNotification, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<KaleoNotification, Object>>();
		Map<String, BiConsumer<KaleoNotification, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<KaleoNotification, ?>>();

		attributeGetterFunctions.put(
			"kaleoNotificationId",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getKaleoNotificationId();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoNotificationId",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification,
					Object kaleoNotificationId) {

					kaleoNotification.setKaleoNotificationId(
						(Long)kaleoNotificationId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification, Object groupId) {

					kaleoNotification.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification, Object companyId) {

					kaleoNotification.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification, Object userId) {

					kaleoNotification.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification, Object userName) {

					kaleoNotification.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification, Object createDate) {

					kaleoNotification.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification, Object modifiedDate) {

					kaleoNotification.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"kaleoClassName",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getKaleoClassName();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoClassName",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification,
					Object kaleoClassName) {

					kaleoNotification.setKaleoClassName((String)kaleoClassName);
				}

			});
		attributeGetterFunctions.put(
			"kaleoClassPK",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getKaleoClassPK();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoClassPK",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification, Object kaleoClassPK) {

					kaleoNotification.setKaleoClassPK((Long)kaleoClassPK);
				}

			});
		attributeGetterFunctions.put(
			"kaleoDefinitionId",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getKaleoDefinitionId();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoDefinitionId",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification,
					Object kaleoDefinitionId) {

					kaleoNotification.setKaleoDefinitionId(
						(Long)kaleoDefinitionId);
				}

			});
		attributeGetterFunctions.put(
			"kaleoNodeName",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getKaleoNodeName();
				}

			});
		attributeSetterBiConsumers.put(
			"kaleoNodeName",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification, Object kaleoNodeName) {

					kaleoNotification.setKaleoNodeName((String)kaleoNodeName);
				}

			});
		attributeGetterFunctions.put(
			"name",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification, Object name) {

					kaleoNotification.setName((String)name);
				}

			});
		attributeGetterFunctions.put(
			"description",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getDescription();
				}

			});
		attributeSetterBiConsumers.put(
			"description",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification, Object description) {

					kaleoNotification.setDescription((String)description);
				}

			});
		attributeGetterFunctions.put(
			"executionType",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getExecutionType();
				}

			});
		attributeSetterBiConsumers.put(
			"executionType",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification, Object executionType) {

					kaleoNotification.setExecutionType((String)executionType);
				}

			});
		attributeGetterFunctions.put(
			"template",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getTemplate();
				}

			});
		attributeSetterBiConsumers.put(
			"template",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification, Object template) {

					kaleoNotification.setTemplate((String)template);
				}

			});
		attributeGetterFunctions.put(
			"templateLanguage",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getTemplateLanguage();
				}

			});
		attributeSetterBiConsumers.put(
			"templateLanguage",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification,
					Object templateLanguage) {

					kaleoNotification.setTemplateLanguage(
						(String)templateLanguage);
				}

			});
		attributeGetterFunctions.put(
			"notificationTypes",
			new Function<KaleoNotification, Object>() {

				@Override
				public Object apply(KaleoNotification kaleoNotification) {
					return kaleoNotification.getNotificationTypes();
				}

			});
		attributeSetterBiConsumers.put(
			"notificationTypes",
			new BiConsumer<KaleoNotification, Object>() {

				@Override
				public void accept(
					KaleoNotification kaleoNotification,
					Object notificationTypes) {

					kaleoNotification.setNotificationTypes(
						(String)notificationTypes);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getKaleoNotificationId() {
		return _kaleoNotificationId;
	}

	@Override
	public void setKaleoNotificationId(long kaleoNotificationId) {
		_columnBitmask = -1L;

		_kaleoNotificationId = kaleoNotificationId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

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
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

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

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getKaleoClassName() {
		if (_kaleoClassName == null) {
			return "";
		}
		else {
			return _kaleoClassName;
		}
	}

	@Override
	public void setKaleoClassName(String kaleoClassName) {
		_columnBitmask |= KALEOCLASSNAME_COLUMN_BITMASK;

		if (_originalKaleoClassName == null) {
			_originalKaleoClassName = _kaleoClassName;
		}

		_kaleoClassName = kaleoClassName;
	}

	public String getOriginalKaleoClassName() {
		return GetterUtil.getString(_originalKaleoClassName);
	}

	@Override
	public long getKaleoClassPK() {
		return _kaleoClassPK;
	}

	@Override
	public void setKaleoClassPK(long kaleoClassPK) {
		_columnBitmask |= KALEOCLASSPK_COLUMN_BITMASK;

		if (!_setOriginalKaleoClassPK) {
			_setOriginalKaleoClassPK = true;

			_originalKaleoClassPK = _kaleoClassPK;
		}

		_kaleoClassPK = kaleoClassPK;
	}

	public long getOriginalKaleoClassPK() {
		return _originalKaleoClassPK;
	}

	@Override
	public long getKaleoDefinitionId() {
		return _kaleoDefinitionId;
	}

	@Override
	public void setKaleoDefinitionId(long kaleoDefinitionId) {
		_columnBitmask |= KALEODEFINITIONID_COLUMN_BITMASK;

		if (!_setOriginalKaleoDefinitionId) {
			_setOriginalKaleoDefinitionId = true;

			_originalKaleoDefinitionId = _kaleoDefinitionId;
		}

		_kaleoDefinitionId = kaleoDefinitionId;
	}

	public long getOriginalKaleoDefinitionId() {
		return _originalKaleoDefinitionId;
	}

	@Override
	public String getKaleoNodeName() {
		if (_kaleoNodeName == null) {
			return "";
		}
		else {
			return _kaleoNodeName;
		}
	}

	@Override
	public void setKaleoNodeName(String kaleoNodeName) {
		_kaleoNodeName = kaleoNodeName;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public String getExecutionType() {
		if (_executionType == null) {
			return "";
		}
		else {
			return _executionType;
		}
	}

	@Override
	public void setExecutionType(String executionType) {
		_columnBitmask |= EXECUTIONTYPE_COLUMN_BITMASK;

		if (_originalExecutionType == null) {
			_originalExecutionType = _executionType;
		}

		_executionType = executionType;
	}

	public String getOriginalExecutionType() {
		return GetterUtil.getString(_originalExecutionType);
	}

	@Override
	public String getTemplate() {
		if (_template == null) {
			return "";
		}
		else {
			return _template;
		}
	}

	@Override
	public void setTemplate(String template) {
		_template = template;
	}

	@Override
	public String getTemplateLanguage() {
		if (_templateLanguage == null) {
			return "";
		}
		else {
			return _templateLanguage;
		}
	}

	@Override
	public void setTemplateLanguage(String templateLanguage) {
		_templateLanguage = templateLanguage;
	}

	@Override
	public String getNotificationTypes() {
		if (_notificationTypes == null) {
			return "";
		}
		else {
			return _notificationTypes;
		}
	}

	@Override
	public void setNotificationTypes(String notificationTypes) {
		_notificationTypes = notificationTypes;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), KaleoNotification.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public KaleoNotification toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, KaleoNotification>
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
		KaleoNotificationImpl kaleoNotificationImpl =
			new KaleoNotificationImpl();

		kaleoNotificationImpl.setKaleoNotificationId(getKaleoNotificationId());
		kaleoNotificationImpl.setGroupId(getGroupId());
		kaleoNotificationImpl.setCompanyId(getCompanyId());
		kaleoNotificationImpl.setUserId(getUserId());
		kaleoNotificationImpl.setUserName(getUserName());
		kaleoNotificationImpl.setCreateDate(getCreateDate());
		kaleoNotificationImpl.setModifiedDate(getModifiedDate());
		kaleoNotificationImpl.setKaleoClassName(getKaleoClassName());
		kaleoNotificationImpl.setKaleoClassPK(getKaleoClassPK());
		kaleoNotificationImpl.setKaleoDefinitionId(getKaleoDefinitionId());
		kaleoNotificationImpl.setKaleoNodeName(getKaleoNodeName());
		kaleoNotificationImpl.setName(getName());
		kaleoNotificationImpl.setDescription(getDescription());
		kaleoNotificationImpl.setExecutionType(getExecutionType());
		kaleoNotificationImpl.setTemplate(getTemplate());
		kaleoNotificationImpl.setTemplateLanguage(getTemplateLanguage());
		kaleoNotificationImpl.setNotificationTypes(getNotificationTypes());

		kaleoNotificationImpl.resetOriginalValues();

		return kaleoNotificationImpl;
	}

	@Override
	public int compareTo(KaleoNotification kaleoNotification) {
		int value = 0;

		if (getKaleoNotificationId() <
				kaleoNotification.getKaleoNotificationId()) {

			value = -1;
		}
		else if (getKaleoNotificationId() >
					kaleoNotification.getKaleoNotificationId()) {

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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KaleoNotification)) {
			return false;
		}

		KaleoNotification kaleoNotification = (KaleoNotification)obj;

		long primaryKey = kaleoNotification.getPrimaryKey();

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

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		KaleoNotificationModelImpl kaleoNotificationModelImpl = this;

		kaleoNotificationModelImpl._originalCompanyId =
			kaleoNotificationModelImpl._companyId;

		kaleoNotificationModelImpl._setOriginalCompanyId = false;

		kaleoNotificationModelImpl._setModifiedDate = false;

		kaleoNotificationModelImpl._originalKaleoClassName =
			kaleoNotificationModelImpl._kaleoClassName;

		kaleoNotificationModelImpl._originalKaleoClassPK =
			kaleoNotificationModelImpl._kaleoClassPK;

		kaleoNotificationModelImpl._setOriginalKaleoClassPK = false;

		kaleoNotificationModelImpl._originalKaleoDefinitionId =
			kaleoNotificationModelImpl._kaleoDefinitionId;

		kaleoNotificationModelImpl._setOriginalKaleoDefinitionId = false;

		kaleoNotificationModelImpl._originalExecutionType =
			kaleoNotificationModelImpl._executionType;

		kaleoNotificationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<KaleoNotification> toCacheModel() {
		KaleoNotificationCacheModel kaleoNotificationCacheModel =
			new KaleoNotificationCacheModel();

		kaleoNotificationCacheModel.kaleoNotificationId =
			getKaleoNotificationId();

		kaleoNotificationCacheModel.groupId = getGroupId();

		kaleoNotificationCacheModel.companyId = getCompanyId();

		kaleoNotificationCacheModel.userId = getUserId();

		kaleoNotificationCacheModel.userName = getUserName();

		String userName = kaleoNotificationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			kaleoNotificationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			kaleoNotificationCacheModel.createDate = createDate.getTime();
		}
		else {
			kaleoNotificationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			kaleoNotificationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			kaleoNotificationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		kaleoNotificationCacheModel.kaleoClassName = getKaleoClassName();

		String kaleoClassName = kaleoNotificationCacheModel.kaleoClassName;

		if ((kaleoClassName != null) && (kaleoClassName.length() == 0)) {
			kaleoNotificationCacheModel.kaleoClassName = null;
		}

		kaleoNotificationCacheModel.kaleoClassPK = getKaleoClassPK();

		kaleoNotificationCacheModel.kaleoDefinitionId = getKaleoDefinitionId();

		kaleoNotificationCacheModel.kaleoNodeName = getKaleoNodeName();

		String kaleoNodeName = kaleoNotificationCacheModel.kaleoNodeName;

		if ((kaleoNodeName != null) && (kaleoNodeName.length() == 0)) {
			kaleoNotificationCacheModel.kaleoNodeName = null;
		}

		kaleoNotificationCacheModel.name = getName();

		String name = kaleoNotificationCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			kaleoNotificationCacheModel.name = null;
		}

		kaleoNotificationCacheModel.description = getDescription();

		String description = kaleoNotificationCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			kaleoNotificationCacheModel.description = null;
		}

		kaleoNotificationCacheModel.executionType = getExecutionType();

		String executionType = kaleoNotificationCacheModel.executionType;

		if ((executionType != null) && (executionType.length() == 0)) {
			kaleoNotificationCacheModel.executionType = null;
		}

		kaleoNotificationCacheModel.template = getTemplate();

		String template = kaleoNotificationCacheModel.template;

		if ((template != null) && (template.length() == 0)) {
			kaleoNotificationCacheModel.template = null;
		}

		kaleoNotificationCacheModel.templateLanguage = getTemplateLanguage();

		String templateLanguage = kaleoNotificationCacheModel.templateLanguage;

		if ((templateLanguage != null) && (templateLanguage.length() == 0)) {
			kaleoNotificationCacheModel.templateLanguage = null;
		}

		kaleoNotificationCacheModel.notificationTypes = getNotificationTypes();

		String notificationTypes =
			kaleoNotificationCacheModel.notificationTypes;

		if ((notificationTypes != null) && (notificationTypes.length() == 0)) {
			kaleoNotificationCacheModel.notificationTypes = null;
		}

		return kaleoNotificationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<KaleoNotification, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<KaleoNotification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KaleoNotification, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((KaleoNotification)this));
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
		Map<String, Function<KaleoNotification, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<KaleoNotification, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<KaleoNotification, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((KaleoNotification)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, KaleoNotification>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _kaleoNotificationId;
	private long _groupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _kaleoClassName;
	private String _originalKaleoClassName;
	private long _kaleoClassPK;
	private long _originalKaleoClassPK;
	private boolean _setOriginalKaleoClassPK;
	private long _kaleoDefinitionId;
	private long _originalKaleoDefinitionId;
	private boolean _setOriginalKaleoDefinitionId;
	private String _kaleoNodeName;
	private String _name;
	private String _description;
	private String _executionType;
	private String _originalExecutionType;
	private String _template;
	private String _templateLanguage;
	private String _notificationTypes;
	private long _columnBitmask;
	private KaleoNotification _escapedModel;

}