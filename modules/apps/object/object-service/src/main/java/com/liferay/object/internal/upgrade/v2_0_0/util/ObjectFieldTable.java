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

package com.liferay.object.internal.upgrade.v2_0_0.util;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class ObjectFieldTable {

	public static final String TABLE_NAME = "ObjectField";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"objectFieldId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"listTypeDefinitionId", Types.BIGINT},
		{"objectDefinitionId", Types.BIGINT}, {"businessType", Types.VARCHAR},
		{"dbColumnName", Types.VARCHAR}, {"dbTableName", Types.VARCHAR},
		{"dbType", Types.VARCHAR}, {"indexed", Types.BOOLEAN},
		{"indexedAsKeyword", Types.BOOLEAN},
		{"indexedLanguageId", Types.VARCHAR}, {"label", Types.VARCHAR},
		{"name", Types.VARCHAR}, {"relationshipType", Types.VARCHAR},
		{"required", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
new HashMap<String, Integer>();

static {
TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);

TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("objectFieldId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);

TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);

TABLE_COLUMNS_MAP.put("listTypeDefinitionId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("objectDefinitionId", Types.BIGINT);

TABLE_COLUMNS_MAP.put("businessType", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("dbColumnName", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("dbTableName", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("dbType", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("indexed", Types.BOOLEAN);

TABLE_COLUMNS_MAP.put("indexedAsKeyword", Types.BOOLEAN);

TABLE_COLUMNS_MAP.put("indexedLanguageId", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("label", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("relationshipType", Types.VARCHAR);

TABLE_COLUMNS_MAP.put("required", Types.BOOLEAN);

}
	public static final String TABLE_SQL_CREATE =
"create table ObjectField (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,objectFieldId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,listTypeDefinitionId LONG,objectDefinitionId LONG,businessType VARCHAR(75) null,dbColumnName VARCHAR(75) null,dbTableName VARCHAR(75) null,dbType VARCHAR(75) null,indexed BOOLEAN,indexedAsKeyword BOOLEAN,indexedLanguageId VARCHAR(75) null,label STRING null,name VARCHAR(75) null,relationshipType VARCHAR(75) null,required BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table ObjectField";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_736807B on ObjectField (listTypeDefinitionId)",
		"create index IX_5DDCF209 on ObjectField (objectDefinitionId, dbTableName[$COLUMN_LENGTH:75$])",
		"create index IX_A59C5981 on ObjectField (objectDefinitionId, name[$COLUMN_LENGTH:75$])",
		"create index IX_594B4995 on ObjectField (uuid_[$COLUMN_LENGTH:75$], companyId)"
	};

}