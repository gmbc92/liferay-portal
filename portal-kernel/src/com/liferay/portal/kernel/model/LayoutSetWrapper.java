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

package com.liferay.portal.kernel.model;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link LayoutSet}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSet
 * @generated
 */
public class LayoutSetWrapper implements LayoutSet, ModelWrapper<LayoutSet> {

	public LayoutSetWrapper(LayoutSet layoutSet) {
		_layoutSet = layoutSet;
	}

	@Override
	public Class<?> getModelClass() {
		return LayoutSet.class;
	}

	@Override
	public String getModelClassName() {
		return LayoutSet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("layoutSetId", getLayoutSetId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("privateLayout", isPrivateLayout());
		attributes.put("logoId", getLogoId());
		attributes.put("themeId", getThemeId());
		attributes.put("colorSchemeId", getColorSchemeId());
		attributes.put("css", getCss());
		attributes.put("pageCount", getPageCount());
		attributes.put("settings", getSettings());
		attributes.put("layoutSetPrototypeUuid", getLayoutSetPrototypeUuid());
		attributes.put(
			"layoutSetPrototypeLinkEnabled", isLayoutSetPrototypeLinkEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long layoutSetId = (Long)attributes.get("layoutSetId");

		if (layoutSetId != null) {
			setLayoutSetId(layoutSetId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean privateLayout = (Boolean)attributes.get("privateLayout");

		if (privateLayout != null) {
			setPrivateLayout(privateLayout);
		}

		Long logoId = (Long)attributes.get("logoId");

		if (logoId != null) {
			setLogoId(logoId);
		}

		String themeId = (String)attributes.get("themeId");

		if (themeId != null) {
			setThemeId(themeId);
		}

		String colorSchemeId = (String)attributes.get("colorSchemeId");

		if (colorSchemeId != null) {
			setColorSchemeId(colorSchemeId);
		}

		String css = (String)attributes.get("css");

		if (css != null) {
			setCss(css);
		}

		Integer pageCount = (Integer)attributes.get("pageCount");

		if (pageCount != null) {
			setPageCount(pageCount);
		}

		String settings = (String)attributes.get("settings");

		if (settings != null) {
			setSettings(settings);
		}

		String layoutSetPrototypeUuid = (String)attributes.get(
			"layoutSetPrototypeUuid");

		if (layoutSetPrototypeUuid != null) {
			setLayoutSetPrototypeUuid(layoutSetPrototypeUuid);
		}

		Boolean layoutSetPrototypeLinkEnabled = (Boolean)attributes.get(
			"layoutSetPrototypeLinkEnabled");

		if (layoutSetPrototypeLinkEnabled != null) {
			setLayoutSetPrototypeLinkEnabled(layoutSetPrototypeLinkEnabled);
		}
	}

	@Override
	public Object clone() {
		return new LayoutSetWrapper((LayoutSet)_layoutSet.clone());
	}

	@Override
	public int compareTo(LayoutSet layoutSet) {
		return _layoutSet.compareTo(layoutSet);
	}

	/**
	 * Returns the layout set's color scheme.
	 *
	 * <p>
	 * Just like themes, color schemes can be configured on the layout set
	 * level. The layout set's color scheme can be overridden on the layout
	 * level.
	 * </p>
	 *
	 * @return the layout set's color scheme
	 */
	@Override
	public ColorScheme getColorScheme() {
		return _layoutSet.getColorScheme();
	}

	/**
	 * Returns the color scheme ID of this layout set.
	 *
	 * @return the color scheme ID of this layout set
	 */
	@Override
	public String getColorSchemeId() {
		return _layoutSet.getColorSchemeId();
	}

	@Override
	public String getCompanyFallbackVirtualHostname() {
		return _layoutSet.getCompanyFallbackVirtualHostname();
	}

	/**
	 * Returns the company ID of this layout set.
	 *
	 * @return the company ID of this layout set
	 */
	@Override
	public long getCompanyId() {
		return _layoutSet.getCompanyId();
	}

	/**
	 * Returns the create date of this layout set.
	 *
	 * @return the create date of this layout set
	 */
	@Override
	public Date getCreateDate() {
		return _layoutSet.getCreateDate();
	}

	/**
	 * Returns the css of this layout set.
	 *
	 * @return the css of this layout set
	 */
	@Override
	public String getCss() {
		return _layoutSet.getCss();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _layoutSet.getExpandoBridge();
	}

	/**
	 * Returns the layout set's group.
	 *
	 * @return the layout set's group
	 */
	@Override
	public Group getGroup()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _layoutSet.getGroup();
	}

	/**
	 * Returns the group ID of this layout set.
	 *
	 * @return the group ID of this layout set
	 */
	@Override
	public long getGroupId() {
		return _layoutSet.getGroupId();
	}

	/**
	 * Returns the layout set ID of this layout set.
	 *
	 * @return the layout set ID of this layout set
	 */
	@Override
	public long getLayoutSetId() {
		return _layoutSet.getLayoutSetId();
	}

	/**
	 * Returns the layout set prototype's ID, or <code>0</code> if it has no
	 * layout set prototype.
	 *
	 * <p>
	 * Prototype is Liferay's technical name for a site template.
	 * </p>
	 *
	 * @return the layout set prototype's ID, or <code>0</code> if it has no
	 layout set prototype
	 */
	@Override
	public long getLayoutSetPrototypeId()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _layoutSet.getLayoutSetPrototypeId();
	}

	/**
	 * Returns the layout set prototype link enabled of this layout set.
	 *
	 * @return the layout set prototype link enabled of this layout set
	 */
	@Override
	public boolean getLayoutSetPrototypeLinkEnabled() {
		return _layoutSet.getLayoutSetPrototypeLinkEnabled();
	}

	/**
	 * Returns the layout set prototype uuid of this layout set.
	 *
	 * @return the layout set prototype uuid of this layout set
	 */
	@Override
	public String getLayoutSetPrototypeUuid() {
		return _layoutSet.getLayoutSetPrototypeUuid();
	}

	@Override
	public long getLiveLogoId() {
		return _layoutSet.getLiveLogoId();
	}

	@Override
	public boolean getLogo() {
		return _layoutSet.getLogo();
	}

	/**
	 * Returns the logo ID of this layout set.
	 *
	 * @return the logo ID of this layout set
	 */
	@Override
	public long getLogoId() {
		return _layoutSet.getLogoId();
	}

	/**
	 * Returns the modified date of this layout set.
	 *
	 * @return the modified date of this layout set
	 */
	@Override
	public Date getModifiedDate() {
		return _layoutSet.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this layout set.
	 *
	 * @return the mvcc version of this layout set
	 */
	@Override
	public long getMvccVersion() {
		return _layoutSet.getMvccVersion();
	}

	/**
	 * Returns the page count of this layout set.
	 *
	 * @return the page count of this layout set
	 */
	@Override
	public int getPageCount() {
		return _layoutSet.getPageCount();
	}

	/**
	 * Returns the primary key of this layout set.
	 *
	 * @return the primary key of this layout set
	 */
	@Override
	public long getPrimaryKey() {
		return _layoutSet.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _layoutSet.getPrimaryKeyObj();
	}

	/**
	 * Returns the private layout of this layout set.
	 *
	 * @return the private layout of this layout set
	 */
	@Override
	public boolean getPrivateLayout() {
		return _layoutSet.getPrivateLayout();
	}

	/**
	 * Returns the settings of this layout set.
	 *
	 * @return the settings of this layout set
	 */
	@Override
	public String getSettings() {
		return _layoutSet.getSettings();
	}

	@Override
	public com.liferay.portal.kernel.util.UnicodeProperties
		getSettingsProperties() {

		return _layoutSet.getSettingsProperties();
	}

	@Override
	public String getSettingsProperty(String key) {
		return _layoutSet.getSettingsProperty(key);
	}

	@Override
	public Theme getTheme() {
		return _layoutSet.getTheme();
	}

	/**
	 * Returns the theme ID of this layout set.
	 *
	 * @return the theme ID of this layout set
	 */
	@Override
	public String getThemeId() {
		return _layoutSet.getThemeId();
	}

	@Override
	public String getThemeSetting(String key, String device) {
		return _layoutSet.getThemeSetting(key, device);
	}

	/**
	 * Returns the name of the layout set's virtual host.
	 *
	 * <p>
	 * When accessing a layout set that has a the virtual host, the URL elements
	 * "/web/sitename" or "/group/sitename" can be omitted.
	 * </p>
	 *
	 * @return the layout set's virtual host name, or an empty string if the
	 layout set has no virtual host configured
	 */
	@Override
	public String getVirtualHostname() {
		return _layoutSet.getVirtualHostname();
	}

	@Override
	public int hashCode() {
		return _layoutSet.hashCode();
	}

	@Override
	public boolean hasSetModifiedDate() {
		return _layoutSet.hasSetModifiedDate();
	}

	@Override
	public boolean isCachedModel() {
		return _layoutSet.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _layoutSet.isEscapedModel();
	}

	@Override
	public boolean isLayoutSetPrototypeLinkActive() {
		return _layoutSet.isLayoutSetPrototypeLinkActive();
	}

	/**
	 * Returns <code>true</code> if this layout set is layout set prototype link enabled.
	 *
	 * @return <code>true</code> if this layout set is layout set prototype link enabled; <code>false</code> otherwise
	 */
	@Override
	public boolean isLayoutSetPrototypeLinkEnabled() {
		return _layoutSet.isLayoutSetPrototypeLinkEnabled();
	}

	@Override
	public boolean isLogo() {
		return _layoutSet.isLogo();
	}

	@Override
	public boolean isNew() {
		return _layoutSet.isNew();
	}

	/**
	 * Returns <code>true</code> if this layout set is private layout.
	 *
	 * @return <code>true</code> if this layout set is private layout; <code>false</code> otherwise
	 */
	@Override
	public boolean isPrivateLayout() {
		return _layoutSet.isPrivateLayout();
	}

	@Override
	public void persist() {
		_layoutSet.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_layoutSet.setCachedModel(cachedModel);
	}

	/**
	 * Sets the color scheme ID of this layout set.
	 *
	 * @param colorSchemeId the color scheme ID of this layout set
	 */
	@Override
	public void setColorSchemeId(String colorSchemeId) {
		_layoutSet.setColorSchemeId(colorSchemeId);
	}

	@Override
	public void setCompanyFallbackVirtualHostname(
		String companyFallbackVirtualHostname) {

		_layoutSet.setCompanyFallbackVirtualHostname(
			companyFallbackVirtualHostname);
	}

	/**
	 * Sets the company ID of this layout set.
	 *
	 * @param companyId the company ID of this layout set
	 */
	@Override
	public void setCompanyId(long companyId) {
		_layoutSet.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this layout set.
	 *
	 * @param createDate the create date of this layout set
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_layoutSet.setCreateDate(createDate);
	}

	/**
	 * Sets the css of this layout set.
	 *
	 * @param css the css of this layout set
	 */
	@Override
	public void setCss(String css) {
		_layoutSet.setCss(css);
	}

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel) {
		_layoutSet.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_layoutSet.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_layoutSet.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this layout set.
	 *
	 * @param groupId the group ID of this layout set
	 */
	@Override
	public void setGroupId(long groupId) {
		_layoutSet.setGroupId(groupId);
	}

	/**
	 * Sets the layout set ID of this layout set.
	 *
	 * @param layoutSetId the layout set ID of this layout set
	 */
	@Override
	public void setLayoutSetId(long layoutSetId) {
		_layoutSet.setLayoutSetId(layoutSetId);
	}

	/**
	 * Sets whether this layout set is layout set prototype link enabled.
	 *
	 * @param layoutSetPrototypeLinkEnabled the layout set prototype link enabled of this layout set
	 */
	@Override
	public void setLayoutSetPrototypeLinkEnabled(
		boolean layoutSetPrototypeLinkEnabled) {

		_layoutSet.setLayoutSetPrototypeLinkEnabled(
			layoutSetPrototypeLinkEnabled);
	}

	/**
	 * Sets the layout set prototype uuid of this layout set.
	 *
	 * @param layoutSetPrototypeUuid the layout set prototype uuid of this layout set
	 */
	@Override
	public void setLayoutSetPrototypeUuid(String layoutSetPrototypeUuid) {
		_layoutSet.setLayoutSetPrototypeUuid(layoutSetPrototypeUuid);
	}

	/**
	 * Sets the logo ID of this layout set.
	 *
	 * @param logoId the logo ID of this layout set
	 */
	@Override
	public void setLogoId(long logoId) {
		_layoutSet.setLogoId(logoId);
	}

	/**
	 * Sets the modified date of this layout set.
	 *
	 * @param modifiedDate the modified date of this layout set
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_layoutSet.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this layout set.
	 *
	 * @param mvccVersion the mvcc version of this layout set
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		_layoutSet.setMvccVersion(mvccVersion);
	}

	@Override
	public void setNew(boolean n) {
		_layoutSet.setNew(n);
	}

	/**
	 * Sets the page count of this layout set.
	 *
	 * @param pageCount the page count of this layout set
	 */
	@Override
	public void setPageCount(int pageCount) {
		_layoutSet.setPageCount(pageCount);
	}

	/**
	 * Sets the primary key of this layout set.
	 *
	 * @param primaryKey the primary key of this layout set
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_layoutSet.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_layoutSet.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets whether this layout set is private layout.
	 *
	 * @param privateLayout the private layout of this layout set
	 */
	@Override
	public void setPrivateLayout(boolean privateLayout) {
		_layoutSet.setPrivateLayout(privateLayout);
	}

	/**
	 * Sets the settings of this layout set.
	 *
	 * @param settings the settings of this layout set
	 */
	@Override
	public void setSettings(String settings) {
		_layoutSet.setSettings(settings);
	}

	@Override
	public void setSettingsProperties(
		com.liferay.portal.kernel.util.UnicodeProperties settingsProperties) {

		_layoutSet.setSettingsProperties(settingsProperties);
	}

	/**
	 * Sets the theme ID of this layout set.
	 *
	 * @param themeId the theme ID of this layout set
	 */
	@Override
	public void setThemeId(String themeId) {
		_layoutSet.setThemeId(themeId);
	}

	/**
	 * Sets the name of the layout set's virtual host.
	 *
	 * @param virtualHostname the name of the layout set's virtual host
	 * @see #getVirtualHostname()
	 */
	@Override
	public void setVirtualHostname(String virtualHostname) {
		_layoutSet.setVirtualHostname(virtualHostname);
	}

	@Override
	public CacheModel<LayoutSet> toCacheModel() {
		return _layoutSet.toCacheModel();
	}

	@Override
	public LayoutSet toEscapedModel() {
		return new LayoutSetWrapper(_layoutSet.toEscapedModel());
	}

	@Override
	public String toString() {
		return _layoutSet.toString();
	}

	@Override
	public LayoutSet toUnescapedModel() {
		return new LayoutSetWrapper(_layoutSet.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _layoutSet.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LayoutSetWrapper)) {
			return false;
		}

		LayoutSetWrapper layoutSetWrapper = (LayoutSetWrapper)obj;

		if (Objects.equals(_layoutSet, layoutSetWrapper._layoutSet)) {
			return true;
		}

		return false;
	}

	@Override
	public LayoutSet getWrappedModel() {
		return _layoutSet;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _layoutSet.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _layoutSet.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_layoutSet.resetOriginalValues();
	}

	private final LayoutSet _layoutSet;

}