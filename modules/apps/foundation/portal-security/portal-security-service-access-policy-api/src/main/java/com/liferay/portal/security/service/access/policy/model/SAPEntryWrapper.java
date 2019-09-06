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

package com.liferay.portal.security.service.access.policy.model;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link SAPEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SAPEntry
 * @generated
 */
public class SAPEntryWrapper implements SAPEntry, ModelWrapper<SAPEntry> {

	public SAPEntryWrapper(SAPEntry sapEntry) {
		_sapEntry = sapEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return SAPEntry.class;
	}

	@Override
	public String getModelClassName() {
		return SAPEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("sapEntryId", getSapEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put(
			"allowedServiceSignatures", getAllowedServiceSignatures());
		attributes.put("defaultSAPEntry", isDefaultSAPEntry());
		attributes.put("enabled", isEnabled());
		attributes.put("name", getName());
		attributes.put("title", getTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long sapEntryId = (Long)attributes.get("sapEntryId");

		if (sapEntryId != null) {
			setSapEntryId(sapEntryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String allowedServiceSignatures = (String)attributes.get(
			"allowedServiceSignatures");

		if (allowedServiceSignatures != null) {
			setAllowedServiceSignatures(allowedServiceSignatures);
		}

		Boolean defaultSAPEntry = (Boolean)attributes.get("defaultSAPEntry");

		if (defaultSAPEntry != null) {
			setDefaultSAPEntry(defaultSAPEntry);
		}

		Boolean enabled = (Boolean)attributes.get("enabled");

		if (enabled != null) {
			setEnabled(enabled);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}
	}

	@Override
	public Object clone() {
		return new SAPEntryWrapper((SAPEntry)_sapEntry.clone());
	}

	@Override
	public int compareTo(SAPEntry sapEntry) {
		return _sapEntry.compareTo(sapEntry);
	}

	/**
	 * Returns the allowed service signatures of this sap entry.
	 *
	 * @return the allowed service signatures of this sap entry
	 */
	@Override
	public String getAllowedServiceSignatures() {
		return _sapEntry.getAllowedServiceSignatures();
	}

	@Override
	public java.util.List<String> getAllowedServiceSignaturesList() {
		return _sapEntry.getAllowedServiceSignaturesList();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return _sapEntry.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this sap entry.
	 *
	 * @return the company ID of this sap entry
	 */
	@Override
	public long getCompanyId() {
		return _sapEntry.getCompanyId();
	}

	/**
	 * Returns the create date of this sap entry.
	 *
	 * @return the create date of this sap entry
	 */
	@Override
	public Date getCreateDate() {
		return _sapEntry.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return _sapEntry.getDefaultLanguageId();
	}

	/**
	 * Returns the default sap entry of this sap entry.
	 *
	 * @return the default sap entry of this sap entry
	 */
	@Override
	public boolean getDefaultSAPEntry() {
		return _sapEntry.getDefaultSAPEntry();
	}

	/**
	 * Returns the enabled of this sap entry.
	 *
	 * @return the enabled of this sap entry
	 */
	@Override
	public boolean getEnabled() {
		return _sapEntry.getEnabled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _sapEntry.getExpandoBridge();
	}

	/**
	 * Returns the modified date of this sap entry.
	 *
	 * @return the modified date of this sap entry
	 */
	@Override
	public Date getModifiedDate() {
		return _sapEntry.getModifiedDate();
	}

	/**
	 * Returns the name of this sap entry.
	 *
	 * @return the name of this sap entry
	 */
	@Override
	public String getName() {
		return _sapEntry.getName();
	}

	/**
	 * Returns the primary key of this sap entry.
	 *
	 * @return the primary key of this sap entry
	 */
	@Override
	public long getPrimaryKey() {
		return _sapEntry.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sapEntry.getPrimaryKeyObj();
	}

	/**
	 * Returns the sap entry ID of this sap entry.
	 *
	 * @return the sap entry ID of this sap entry
	 */
	@Override
	public long getSapEntryId() {
		return _sapEntry.getSapEntryId();
	}

	/**
	 * Returns the title of this sap entry.
	 *
	 * @return the title of this sap entry
	 */
	@Override
	public String getTitle() {
		return _sapEntry.getTitle();
	}

	/**
	 * Returns the localized title of this sap entry in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this sap entry
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return _sapEntry.getTitle(locale);
	}

	/**
	 * Returns the localized title of this sap entry in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this sap entry. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return _sapEntry.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this sap entry in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this sap entry
	 */
	@Override
	public String getTitle(String languageId) {
		return _sapEntry.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this sap entry in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this sap entry
	 */
	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return _sapEntry.getTitle(languageId, useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return _sapEntry.getTitleCurrentLanguageId();
	}

	@Override
	public String getTitleCurrentValue() {
		return _sapEntry.getTitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized titles of this sap entry.
	 *
	 * @return the locales and localized titles of this sap entry
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return _sapEntry.getTitleMap();
	}

	/**
	 * Returns the user ID of this sap entry.
	 *
	 * @return the user ID of this sap entry
	 */
	@Override
	public long getUserId() {
		return _sapEntry.getUserId();
	}

	/**
	 * Returns the user name of this sap entry.
	 *
	 * @return the user name of this sap entry
	 */
	@Override
	public String getUserName() {
		return _sapEntry.getUserName();
	}

	/**
	 * Returns the user uuid of this sap entry.
	 *
	 * @return the user uuid of this sap entry
	 */
	@Override
	public String getUserUuid() {
		return _sapEntry.getUserUuid();
	}

	/**
	 * Returns the uuid of this sap entry.
	 *
	 * @return the uuid of this sap entry
	 */
	@Override
	public String getUuid() {
		return _sapEntry.getUuid();
	}

	@Override
	public int hashCode() {
		return _sapEntry.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _sapEntry.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this sap entry is default sap entry.
	 *
	 * @return <code>true</code> if this sap entry is default sap entry; <code>false</code> otherwise
	 */
	@Override
	public boolean isDefaultSAPEntry() {
		return _sapEntry.isDefaultSAPEntry();
	}

	/**
	 * Returns <code>true</code> if this sap entry is enabled.
	 *
	 * @return <code>true</code> if this sap entry is enabled; <code>false</code> otherwise
	 */
	@Override
	public boolean isEnabled() {
		return _sapEntry.isEnabled();
	}

	@Override
	public boolean isEscapedModel() {
		return _sapEntry.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _sapEntry.isNew();
	}

	@Override
	public boolean isSystem()
		throws com.liferay.portal.kernel.module.configuration.
			ConfigurationException {

		return _sapEntry.isSystem();
	}

	@Override
	public void persist() {
		_sapEntry.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		_sapEntry.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		_sapEntry.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the allowed service signatures of this sap entry.
	 *
	 * @param allowedServiceSignatures the allowed service signatures of this sap entry
	 */
	@Override
	public void setAllowedServiceSignatures(String allowedServiceSignatures) {
		_sapEntry.setAllowedServiceSignatures(allowedServiceSignatures);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sapEntry.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this sap entry.
	 *
	 * @param companyId the company ID of this sap entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		_sapEntry.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this sap entry.
	 *
	 * @param createDate the create date of this sap entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_sapEntry.setCreateDate(createDate);
	}

	/**
	 * Sets whether this sap entry is default sap entry.
	 *
	 * @param defaultSAPEntry the default sap entry of this sap entry
	 */
	@Override
	public void setDefaultSAPEntry(boolean defaultSAPEntry) {
		_sapEntry.setDefaultSAPEntry(defaultSAPEntry);
	}

	/**
	 * Sets whether this sap entry is enabled.
	 *
	 * @param enabled the enabled of this sap entry
	 */
	@Override
	public void setEnabled(boolean enabled) {
		_sapEntry.setEnabled(enabled);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_sapEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_sapEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_sapEntry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the modified date of this sap entry.
	 *
	 * @param modifiedDate the modified date of this sap entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_sapEntry.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this sap entry.
	 *
	 * @param name the name of this sap entry
	 */
	@Override
	public void setName(String name) {
		_sapEntry.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_sapEntry.setNew(n);
	}

	/**
	 * Sets the primary key of this sap entry.
	 *
	 * @param primaryKey the primary key of this sap entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sapEntry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_sapEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the sap entry ID of this sap entry.
	 *
	 * @param sapEntryId the sap entry ID of this sap entry
	 */
	@Override
	public void setSapEntryId(long sapEntryId) {
		_sapEntry.setSapEntryId(sapEntryId);
	}

	/**
	 * Sets the title of this sap entry.
	 *
	 * @param title the title of this sap entry
	 */
	@Override
	public void setTitle(String title) {
		_sapEntry.setTitle(title);
	}

	/**
	 * Sets the localized title of this sap entry in the language.
	 *
	 * @param title the localized title of this sap entry
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		_sapEntry.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this sap entry in the language, and sets the default locale.
	 *
	 * @param title the localized title of this sap entry
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitle(
		String title, java.util.Locale locale, java.util.Locale defaultLocale) {

		_sapEntry.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		_sapEntry.setTitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized titles of this sap entry from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this sap entry
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		_sapEntry.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this sap entry from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this sap entry
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		_sapEntry.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this sap entry.
	 *
	 * @param userId the user ID of this sap entry
	 */
	@Override
	public void setUserId(long userId) {
		_sapEntry.setUserId(userId);
	}

	/**
	 * Sets the user name of this sap entry.
	 *
	 * @param userName the user name of this sap entry
	 */
	@Override
	public void setUserName(String userName) {
		_sapEntry.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this sap entry.
	 *
	 * @param userUuid the user uuid of this sap entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_sapEntry.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this sap entry.
	 *
	 * @param uuid the uuid of this sap entry
	 */
	@Override
	public void setUuid(String uuid) {
		_sapEntry.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SAPEntry> toCacheModel() {
		return _sapEntry.toCacheModel();
	}

	@Override
	public SAPEntry toEscapedModel() {
		return new SAPEntryWrapper(_sapEntry.toEscapedModel());
	}

	@Override
	public String toString() {
		return _sapEntry.toString();
	}

	@Override
	public SAPEntry toUnescapedModel() {
		return new SAPEntryWrapper(_sapEntry.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _sapEntry.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SAPEntryWrapper)) {
			return false;
		}

		SAPEntryWrapper sapEntryWrapper = (SAPEntryWrapper)obj;

		if (Objects.equals(_sapEntry, sapEntryWrapper._sapEntry)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _sapEntry.getStagedModelType();
	}

	@Override
	public SAPEntry getWrappedModel() {
		return _sapEntry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _sapEntry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _sapEntry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_sapEntry.resetOriginalValues();
	}

	private final SAPEntry _sapEntry;

}