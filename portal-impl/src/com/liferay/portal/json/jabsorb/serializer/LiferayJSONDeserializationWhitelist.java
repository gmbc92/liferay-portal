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

package com.liferay.portal.json.jabsorb.serializer;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.util.PropsUtil;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Tomas Polesovsky
 */
public class LiferayJSONDeserializationWhitelist {

	public LiferayJSONDeserializationWhitelist() {
		Collections.addAll(
			_registeredClassNames,
			PropsUtil.getArray(
				PropsKeys.JSON_DESERIALIZATION_WHITELIST_CLASS_NAMES));
	}

	public boolean isWhitelisted(String className) {
		if (_registeredClassNames.contains(className)) {
			return true;
		}

		if (_log.isWarnEnabled()) {
			_log.warn(
				StringBundler.concat(
					"Unable to deserialize ", className,
					" due to security restrictions."));
		}

		return false;
	}

	public void register(String... classeNames) {
		Collections.addAll(_registeredClassNames, classeNames);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		LiferayJSONDeserializationWhitelist.class);

	private final Set<String> _registeredClassNames =
		new CopyOnWriteArraySet<>();

}