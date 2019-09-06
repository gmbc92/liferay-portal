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

package com.liferay.portlet.asset.model.impl;

import com.liferay.asset.kernel.model.AssetTagStats;
import com.liferay.asset.kernel.model.AssetTagStatsModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;

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
 * The base model implementation for the AssetTagStats service. Represents a row in the &quot;AssetTagStats&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>AssetTagStatsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AssetTagStatsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetTagStatsImpl
 * @generated
 */
public class AssetTagStatsModelImpl
	extends BaseModelImpl<AssetTagStats> implements AssetTagStatsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a asset tag stats model instance should use the <code>AssetTagStats</code> interface instead.
	 */
	public static final String TABLE_NAME = "AssetTagStats";

	public static final Object[][] TABLE_COLUMNS = {
		{"tagStatsId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"tagId", Types.BIGINT}, {"classNameId", Types.BIGINT},
		{"assetCount", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("tagStatsId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("tagId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("assetCount", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AssetTagStats (tagStatsId LONG not null primary key,companyId LONG,tagId LONG,classNameId LONG,assetCount INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table AssetTagStats";

	public static final String ORDER_BY_JPQL =
		" ORDER BY assetTagStats.assetCount DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY AssetTagStats.assetCount DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.asset.kernel.model.AssetTagStats"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.asset.kernel.model.AssetTagStats"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.asset.kernel.model.AssetTagStats"),
		true);

	public static final long CLASSNAMEID_COLUMN_BITMASK = 1L;

	public static final long TAGID_COLUMN_BITMASK = 2L;

	public static final long ASSETCOUNT_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.asset.kernel.model.AssetTagStats"));

	public AssetTagStatsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _tagStatsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTagStatsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tagStatsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AssetTagStats.class;
	}

	@Override
	public String getModelClassName() {
		return AssetTagStats.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AssetTagStats, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AssetTagStats, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AssetTagStats, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((AssetTagStats)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AssetTagStats, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AssetTagStats, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AssetTagStats)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AssetTagStats, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AssetTagStats, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, AssetTagStats>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			AssetTagStats.class.getClassLoader(), AssetTagStats.class,
			ModelWrapper.class);

		try {
			Constructor<AssetTagStats> constructor =
				(Constructor<AssetTagStats>)proxyClass.getConstructor(
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

	private static final Map<String, Function<AssetTagStats, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AssetTagStats, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AssetTagStats, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<AssetTagStats, Object>>();
		Map<String, BiConsumer<AssetTagStats, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<AssetTagStats, ?>>();

		attributeGetterFunctions.put(
			"tagStatsId",
			new Function<AssetTagStats, Object>() {

				@Override
				public Object apply(AssetTagStats assetTagStats) {
					return assetTagStats.getTagStatsId();
				}

			});
		attributeSetterBiConsumers.put(
			"tagStatsId",
			new BiConsumer<AssetTagStats, Object>() {

				@Override
				public void accept(
					AssetTagStats assetTagStats, Object tagStatsId) {

					assetTagStats.setTagStatsId((Long)tagStatsId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<AssetTagStats, Object>() {

				@Override
				public Object apply(AssetTagStats assetTagStats) {
					return assetTagStats.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<AssetTagStats, Object>() {

				@Override
				public void accept(
					AssetTagStats assetTagStats, Object companyId) {

					assetTagStats.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"tagId",
			new Function<AssetTagStats, Object>() {

				@Override
				public Object apply(AssetTagStats assetTagStats) {
					return assetTagStats.getTagId();
				}

			});
		attributeSetterBiConsumers.put(
			"tagId",
			new BiConsumer<AssetTagStats, Object>() {

				@Override
				public void accept(AssetTagStats assetTagStats, Object tagId) {
					assetTagStats.setTagId((Long)tagId);
				}

			});
		attributeGetterFunctions.put(
			"classNameId",
			new Function<AssetTagStats, Object>() {

				@Override
				public Object apply(AssetTagStats assetTagStats) {
					return assetTagStats.getClassNameId();
				}

			});
		attributeSetterBiConsumers.put(
			"classNameId",
			new BiConsumer<AssetTagStats, Object>() {

				@Override
				public void accept(
					AssetTagStats assetTagStats, Object classNameId) {

					assetTagStats.setClassNameId((Long)classNameId);
				}

			});
		attributeGetterFunctions.put(
			"assetCount",
			new Function<AssetTagStats, Object>() {

				@Override
				public Object apply(AssetTagStats assetTagStats) {
					return assetTagStats.getAssetCount();
				}

			});
		attributeSetterBiConsumers.put(
			"assetCount",
			new BiConsumer<AssetTagStats, Object>() {

				@Override
				public void accept(
					AssetTagStats assetTagStats, Object assetCount) {

					assetTagStats.setAssetCount((Integer)assetCount);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getTagStatsId() {
		return _tagStatsId;
	}

	@Override
	public void setTagStatsId(long tagStatsId) {
		_tagStatsId = tagStatsId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getTagId() {
		return _tagId;
	}

	@Override
	public void setTagId(long tagId) {
		_columnBitmask |= TAGID_COLUMN_BITMASK;

		if (!_setOriginalTagId) {
			_setOriginalTagId = true;

			_originalTagId = _tagId;
		}

		_tagId = tagId;
	}

	public long getOriginalTagId() {
		return _originalTagId;
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

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@Override
	public int getAssetCount() {
		return _assetCount;
	}

	@Override
	public void setAssetCount(int assetCount) {
		_columnBitmask = -1L;

		_assetCount = assetCount;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), AssetTagStats.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AssetTagStats toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AssetTagStats>
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
		AssetTagStatsImpl assetTagStatsImpl = new AssetTagStatsImpl();

		assetTagStatsImpl.setTagStatsId(getTagStatsId());
		assetTagStatsImpl.setCompanyId(getCompanyId());
		assetTagStatsImpl.setTagId(getTagId());
		assetTagStatsImpl.setClassNameId(getClassNameId());
		assetTagStatsImpl.setAssetCount(getAssetCount());

		assetTagStatsImpl.resetOriginalValues();

		return assetTagStatsImpl;
	}

	@Override
	public int compareTo(AssetTagStats assetTagStats) {
		int value = 0;

		if (getAssetCount() < assetTagStats.getAssetCount()) {
			value = -1;
		}
		else if (getAssetCount() > assetTagStats.getAssetCount()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		if (!(obj instanceof AssetTagStats)) {
			return false;
		}

		AssetTagStats assetTagStats = (AssetTagStats)obj;

		long primaryKey = assetTagStats.getPrimaryKey();

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
		AssetTagStatsModelImpl assetTagStatsModelImpl = this;

		assetTagStatsModelImpl._originalTagId = assetTagStatsModelImpl._tagId;

		assetTagStatsModelImpl._setOriginalTagId = false;

		assetTagStatsModelImpl._originalClassNameId =
			assetTagStatsModelImpl._classNameId;

		assetTagStatsModelImpl._setOriginalClassNameId = false;

		assetTagStatsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AssetTagStats> toCacheModel() {
		AssetTagStatsCacheModel assetTagStatsCacheModel =
			new AssetTagStatsCacheModel();

		assetTagStatsCacheModel.tagStatsId = getTagStatsId();

		assetTagStatsCacheModel.companyId = getCompanyId();

		assetTagStatsCacheModel.tagId = getTagId();

		assetTagStatsCacheModel.classNameId = getClassNameId();

		assetTagStatsCacheModel.assetCount = getAssetCount();

		return assetTagStatsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AssetTagStats, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AssetTagStats, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AssetTagStats, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((AssetTagStats)this));
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
		Map<String, Function<AssetTagStats, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AssetTagStats, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AssetTagStats, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AssetTagStats)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, AssetTagStats>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _tagStatsId;
	private long _companyId;
	private long _tagId;
	private long _originalTagId;
	private boolean _setOriginalTagId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private int _assetCount;
	private long _columnBitmask;
	private AssetTagStats _escapedModel;

}