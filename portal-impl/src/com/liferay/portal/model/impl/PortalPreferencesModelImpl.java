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

package com.liferay.portal.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.PortalPreferences;
import com.liferay.portal.kernel.model.PortalPreferencesModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the PortalPreferences service. Represents a row in the &quot;PortalPreferences&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>PortalPreferencesModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PortalPreferencesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortalPreferencesImpl
 * @generated
 */
public class PortalPreferencesModelImpl
	extends BaseModelImpl<PortalPreferences> implements PortalPreferencesModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a portal preferences model instance should use the <code>PortalPreferences</code> interface instead.
	 */
	public static final String TABLE_NAME = "PortalPreferences";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"portalPreferencesId", Types.BIGINT},
		{"ownerId", Types.BIGINT}, {"ownerType", Types.INTEGER},
		{"preferences", Types.CLOB}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("portalPreferencesId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ownerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ownerType", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("preferences", Types.CLOB);
	}

	public static final String TABLE_SQL_CREATE =
		"create table PortalPreferences (mvccVersion LONG default 0 not null,portalPreferencesId LONG not null primary key,ownerId LONG,ownerType INTEGER,preferences TEXT null)";

	public static final String TABLE_SQL_DROP = "drop table PortalPreferences";

	public static final String ORDER_BY_JPQL =
		" ORDER BY portalPreferences.portalPreferencesId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY PortalPreferences.portalPreferencesId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.portal.kernel.model.PortalPreferences"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.portal.kernel.model.PortalPreferences"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.portal.kernel.model.PortalPreferences"),
		true);

	public static final long OWNERID_COLUMN_BITMASK = 1L;

	public static final long OWNERTYPE_COLUMN_BITMASK = 2L;

	public static final long PORTALPREFERENCESID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.portal.kernel.model.PortalPreferences"));

	public PortalPreferencesModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _portalPreferencesId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPortalPreferencesId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _portalPreferencesId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PortalPreferences.class;
	}

	@Override
	public String getModelClassName() {
		return PortalPreferences.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<PortalPreferences, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<PortalPreferences, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PortalPreferences, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((PortalPreferences)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<PortalPreferences, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<PortalPreferences, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(PortalPreferences)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<PortalPreferences, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<PortalPreferences, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, PortalPreferences>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			PortalPreferences.class.getClassLoader(), PortalPreferences.class,
			ModelWrapper.class);

		try {
			Constructor<PortalPreferences> constructor =
				(Constructor<PortalPreferences>)proxyClass.getConstructor(
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

	private static final Map<String, Function<PortalPreferences, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<PortalPreferences, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<PortalPreferences, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<PortalPreferences, Object>>();
		Map<String, BiConsumer<PortalPreferences, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<PortalPreferences, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion",
			new Function<PortalPreferences, Object>() {

				@Override
				public Object apply(PortalPreferences portalPreferences) {
					return portalPreferences.getMvccVersion();
				}

			});
		attributeSetterBiConsumers.put(
			"mvccVersion",
			new BiConsumer<PortalPreferences, Object>() {

				@Override
				public void accept(
					PortalPreferences portalPreferences, Object mvccVersion) {

					portalPreferences.setMvccVersion((Long)mvccVersion);
				}

			});
		attributeGetterFunctions.put(
			"portalPreferencesId",
			new Function<PortalPreferences, Object>() {

				@Override
				public Object apply(PortalPreferences portalPreferences) {
					return portalPreferences.getPortalPreferencesId();
				}

			});
		attributeSetterBiConsumers.put(
			"portalPreferencesId",
			new BiConsumer<PortalPreferences, Object>() {

				@Override
				public void accept(
					PortalPreferences portalPreferences,
					Object portalPreferencesId) {

					portalPreferences.setPortalPreferencesId(
						(Long)portalPreferencesId);
				}

			});
		attributeGetterFunctions.put(
			"ownerId",
			new Function<PortalPreferences, Object>() {

				@Override
				public Object apply(PortalPreferences portalPreferences) {
					return portalPreferences.getOwnerId();
				}

			});
		attributeSetterBiConsumers.put(
			"ownerId",
			new BiConsumer<PortalPreferences, Object>() {

				@Override
				public void accept(
					PortalPreferences portalPreferences, Object ownerId) {

					portalPreferences.setOwnerId((Long)ownerId);
				}

			});
		attributeGetterFunctions.put(
			"ownerType",
			new Function<PortalPreferences, Object>() {

				@Override
				public Object apply(PortalPreferences portalPreferences) {
					return portalPreferences.getOwnerType();
				}

			});
		attributeSetterBiConsumers.put(
			"ownerType",
			new BiConsumer<PortalPreferences, Object>() {

				@Override
				public void accept(
					PortalPreferences portalPreferences, Object ownerType) {

					portalPreferences.setOwnerType((Integer)ownerType);
				}

			});
		attributeGetterFunctions.put(
			"preferences",
			new Function<PortalPreferences, Object>() {

				@Override
				public Object apply(PortalPreferences portalPreferences) {
					return portalPreferences.getPreferences();
				}

			});
		attributeSetterBiConsumers.put(
			"preferences",
			new BiConsumer<PortalPreferences, Object>() {

				@Override
				public void accept(
					PortalPreferences portalPreferences, Object preferences) {

					portalPreferences.setPreferences((String)preferences);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public long getPortalPreferencesId() {
		return _portalPreferencesId;
	}

	@Override
	public void setPortalPreferencesId(long portalPreferencesId) {
		_portalPreferencesId = portalPreferencesId;
	}

	@Override
	public long getOwnerId() {
		return _ownerId;
	}

	@Override
	public void setOwnerId(long ownerId) {
		_columnBitmask |= OWNERID_COLUMN_BITMASK;

		if (!_setOriginalOwnerId) {
			_setOriginalOwnerId = true;

			_originalOwnerId = _ownerId;
		}

		_ownerId = ownerId;
	}

	public long getOriginalOwnerId() {
		return _originalOwnerId;
	}

	@Override
	public int getOwnerType() {
		return _ownerType;
	}

	@Override
	public void setOwnerType(int ownerType) {
		_columnBitmask |= OWNERTYPE_COLUMN_BITMASK;

		if (!_setOriginalOwnerType) {
			_setOriginalOwnerType = true;

			_originalOwnerType = _ownerType;
		}

		_ownerType = ownerType;
	}

	public int getOriginalOwnerType() {
		return _originalOwnerType;
	}

	@Override
	public String getPreferences() {
		if (_preferences == null) {
			return "";
		}
		else {
			return _preferences;
		}
	}

	@Override
	public void setPreferences(String preferences) {
		_preferences = preferences;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, PortalPreferences.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PortalPreferences toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, PortalPreferences>
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
		PortalPreferencesImpl portalPreferencesImpl =
			new PortalPreferencesImpl();

		portalPreferencesImpl.setMvccVersion(getMvccVersion());
		portalPreferencesImpl.setPortalPreferencesId(getPortalPreferencesId());
		portalPreferencesImpl.setOwnerId(getOwnerId());
		portalPreferencesImpl.setOwnerType(getOwnerType());
		portalPreferencesImpl.setPreferences(getPreferences());

		portalPreferencesImpl.resetOriginalValues();

		return portalPreferencesImpl;
	}

	@Override
	public int compareTo(PortalPreferences portalPreferences) {
		long primaryKey = portalPreferences.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PortalPreferences)) {
			return false;
		}

		PortalPreferences portalPreferences = (PortalPreferences)obj;

		long primaryKey = portalPreferences.getPrimaryKey();

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
		PortalPreferencesModelImpl portalPreferencesModelImpl = this;

		portalPreferencesModelImpl._originalOwnerId =
			portalPreferencesModelImpl._ownerId;

		portalPreferencesModelImpl._setOriginalOwnerId = false;

		portalPreferencesModelImpl._originalOwnerType =
			portalPreferencesModelImpl._ownerType;

		portalPreferencesModelImpl._setOriginalOwnerType = false;

		portalPreferencesModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PortalPreferences> toCacheModel() {
		PortalPreferencesCacheModel portalPreferencesCacheModel =
			new PortalPreferencesCacheModel();

		portalPreferencesCacheModel.mvccVersion = getMvccVersion();

		portalPreferencesCacheModel.portalPreferencesId =
			getPortalPreferencesId();

		portalPreferencesCacheModel.ownerId = getOwnerId();

		portalPreferencesCacheModel.ownerType = getOwnerType();

		portalPreferencesCacheModel.preferences = getPreferences();

		String preferences = portalPreferencesCacheModel.preferences;

		if ((preferences != null) && (preferences.length() == 0)) {
			portalPreferencesCacheModel.preferences = null;
		}

		return portalPreferencesCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<PortalPreferences, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<PortalPreferences, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PortalPreferences, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((PortalPreferences)this));
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
		Map<String, Function<PortalPreferences, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<PortalPreferences, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<PortalPreferences, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((PortalPreferences)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, PortalPreferences>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _portalPreferencesId;
	private long _ownerId;
	private long _originalOwnerId;
	private boolean _setOriginalOwnerId;
	private int _ownerType;
	private int _originalOwnerType;
	private boolean _setOriginalOwnerType;
	private String _preferences;
	private long _columnBitmask;
	private PortalPreferences _escapedModel;

}