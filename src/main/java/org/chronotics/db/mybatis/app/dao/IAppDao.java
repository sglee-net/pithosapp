package org.chronotics.db.mybatis.app.dao;

import org.json.JSONObject;

public interface IAppDao {
	JSONObject selectCustom(
			String _tableName,
			String _c1,
			String _c2,
			String _c3);
}
