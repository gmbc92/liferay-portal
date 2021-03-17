/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.portal.reports.engine.console.web.internal.admin.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.reports.engine.console.constants.ReportsEngineConsolePortletKeys;
import com.liferay.portal.reports.engine.console.model.Definition;
import com.liferay.portal.reports.engine.console.util.comparator.DefinitionCreateDateComparator;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Rafael Praxedes
 */
public class DefinitionSearch extends SearchContainer<Definition> {

	public static final String EMPTY_RESULTS_MESSAGE =
		"there-are-no-definitions";

	public static List<String> headerNames = new ArrayList<String>() {
		{
			add("definition-name");
			add("source-name");
			add("create-date");
		}
	};

	public DefinitionSearch(
		PortletRequest portletRequest, PortletURL iteratorURL) {

		super(
			portletRequest, new DefinitionDisplayTerms(portletRequest),
			new DefinitionSearchTerms(portletRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		DefinitionDisplayTerms definitionDisplayTerms =
			(DefinitionDisplayTerms)getDisplayTerms();

		iteratorURL.setParameter(
			DefinitionDisplayTerms.DEFINITION_NAME,
			definitionDisplayTerms.getDefinitionName());
		iteratorURL.setParameter(
			DefinitionDisplayTerms.DESCRIPTION,
			definitionDisplayTerms.getDescription());
		iteratorURL.setParameter(
			DefinitionDisplayTerms.REPORT_NAME,
			definitionDisplayTerms.getReportName());
		iteratorURL.setParameter(
			DefinitionDisplayTerms.SOURCE_ID,
			String.valueOf(definitionDisplayTerms.getSourceId()));

		PortalPreferences preferences =
			PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

		String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");

		if (Validator.isNotNull(orderByCol)) {
			preferences.setValue(
				ReportsEngineConsolePortletKeys.REPORTS_ADMIN, "order-by-col",
				orderByCol);
		}
		else {
			orderByCol = preferences.getValue(
				ReportsEngineConsolePortletKeys.REPORTS_ADMIN, "order-by-col",
				"create-date");
		}

		String orderByType = ParamUtil.getString(portletRequest, "orderByType");

		if (Validator.isNotNull(orderByType)) {
			preferences.setValue(
				ReportsEngineConsolePortletKeys.REPORTS_ADMIN, "order-by-type",
				orderByType);
		}
		else {
			orderByType = preferences.getValue(
				ReportsEngineConsolePortletKeys.REPORTS_ADMIN, "order-by-type",
				"asc");
		}

		setOrderByCol(orderByCol);

		setOrderByComparator(
			getDefinitionOrderByComparator(orderByCol, orderByType));

		setOrderByType(orderByType);
	}

	protected OrderByComparator<Definition> getDefinitionOrderByComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = false;

		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}

		return new DefinitionCreateDateComparator(orderByAsc);
	}

}