package org.chronotics.db.mybatis.app.service;

import javax.annotation.Resource;

import org.chronotics.db.mybatis.app.dao.AppDao;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("appService")
public class AppService {
	
	@Resource(name = "appDao")
	AppDao dao;
	
	public JSONObject selectCustom(
			String _tableName,
			String _c1,
			String _c2,
			String _c3) {
		return dao.selectCustom(_tableName, _c1, _c2, _c3);
	}
	
	public JSONObject selectAllRecords(String _tableName) {
		return dao.selectAllRecords(_tableName);
	}
	
	public int insertRecord(String _json) {
		return dao.insertRecord(_json);
	}
	
	public int insertRecords(String _json) {
		return dao.insertRecords(_json);
	}
	
	public int updateRecord(String _json) {
		return dao.updateRecord(_json);
	}
	
	public int deleteRecord(String _json) {
		return dao.deleteRecord(_json);
	}
	
}
