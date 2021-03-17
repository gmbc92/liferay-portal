<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

CalendarResource calendarResource = (CalendarResource)request.getAttribute(CalendarWebKeys.CALENDAR_RESOURCE);

long calendarResourceId = 0;

List<Calendar> calendars = null;

if (calendarResource != null) {
	calendarResourceId = calendarResource.getCalendarResourceId();

	calendars = CalendarServiceUtil.getCalendarResourceCalendars(themeDisplay.getScopeGroupId(), calendarResourceId);
}
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	localizeTitle="<%= false %>"
	title='<%= (calendarResource == null) ? LanguageUtil.get(request, "new-calendar-resource") : calendarResource.getName(locale) %>'
/>

<liferay-portlet:actionURL name="updateCalendarResource" var="updateCalendarResourceURL" />

<aui:form action="<%= updateCalendarResourceURL %>" cssClass="container-fluid-1280" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + liferayPortletResponse.getNamespace() + "updateCalendarResource();" %>'>
	<aui:input name="mvcPath" type="hidden" value="/edit_calendar_resource.jsp" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="calendarResourceId" type="hidden" value="<%= String.valueOf(calendarResourceId) %>" />

	<liferay-ui:error exception="<%= CalendarResourceCodeException.class %>" message="please-enter-a-valid-code" />
	<liferay-ui:error exception="<%= CalendarResourceNameException.class %>" message="please-enter-a-valid-name" />
	<liferay-ui:error exception="<%= DuplicateCalendarResourceException.class %>" message="please-enter-a-unique-resource-code" />

	<liferay-asset:asset-categories-error />

	<liferay-asset:asset-tags-error />

	<aui:model-context bean="<%= calendarResource %>" model="<%= CalendarResource.class %>" />

	<aui:fieldset>
		<aui:input name="name" />

		<liferay-ui:panel-container
			extended="<%= true %>"
			id="calendarResourceDetailsPanelContainer"
			persistState="<%= true %>"
		>
			<liferay-ui:panel
				collapsible="<%= true %>"
				defaultState="closed"
				extended="<%= false %>"
				id="calendarResourceDetailsPanel"
				markupView="lexicon"
				persistState="<%= true %>"
				title="details"
			>
				<c:choose>
					<c:when test="<%= calendarResource == null %>">
						<c:if test="<%= !CalendarServiceConfigurationValues.CALENDAR_RESOURCE_FORCE_AUTOGENERATE_CODE %>">
							<aui:input name="code" />
						</c:if>
					</c:when>
					<c:otherwise>
						<aui:input name="code" type="resource" value='<%= BeanParamUtil.getString(calendarResource, request, "code") %>' />
					</c:otherwise>
				</c:choose>

				<aui:input name="description" />

				<c:if test="<%= calendars != null %>">
					<aui:select label="default-calendar" name="defaultCalendarId" value="<%= calendarResource.getDefaultCalendarId() %>">

						<%
						for (Calendar calendar : calendars) {
						%>

							<aui:option label="<%= HtmlUtil.escapeAttribute(calendar.getName(locale)) %>" value="<%= calendar.getCalendarId() %>" />

						<%
						}
						%>

					</aui:select>
				</c:if>

				<aui:input inlineLabel="left" name="active" type="checkbox" value="<%= (calendarResource == null) ? true : calendarResource.isActive() %>" />
			</liferay-ui:panel>

			<liferay-ui:panel
				collapsible="<%= true %>"
				defaultState="closed"
				extended="<%= false %>"
				id="calendarResourceCategorizationPanel"
				markupView="lexicon"
				persistState="<%= true %>"
				title="categorization"
			>
				<liferay-asset:asset-categories-selector
					className="<%= CalendarResource.class.getName() %>"
					classPK="<%= calendarResourceId %>"
					visibilityTypes="<%= AssetVocabularyConstants.VISIBILITY_TYPES %>"
				/>

				<liferay-asset:asset-tags-selector
					className="<%= CalendarResource.class.getName() %>"
					classPK="<%= calendarResourceId %>"
				/>
			</liferay-ui:panel>

			<c:if test="<%= calendarResource == null %>">
				<liferay-ui:panel
					collapsible="<%= true %>"
					defaultState="closed"
					extended="<%= false %>"
					id="calendarResourcePermissionsPanel"
					markupView="lexicon"
					persistState="<%= true %>"
					title="permissions"
				>
					<liferay-ui:input-permissions
						modelName="<%= CalendarResource.class.getName() %>"
					/>
				</liferay-ui:panel>
			</c:if>
		</liferay-ui:panel-container>

		<aui:button-row>
			<aui:button type="submit" />

			<aui:button href="<%= redirect %>" type="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>

<aui:script>
	function <portlet:namespace />updateCalendarResource() {
		submitForm(document.<portlet:namespace />fm);
	}

	<c:choose>
		<c:when test="<%= CalendarServiceConfigurationValues.CALENDAR_RESOURCE_FORCE_AUTOGENERATE_CODE %>">
			Liferay.Util.focusFormField(
				document.<portlet:namespace />fm.<portlet:namespace />name
			);
		</c:when>
		<c:otherwise>
			Liferay.Util.focusFormField(
				document.<portlet:namespace />fm
					.<portlet:namespace /><%= (calendarResource == null) ? "code" : "name" %>
			);
		</c:otherwise>
	</c:choose>
</aui:script>