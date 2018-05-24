package org.chronotics.db.mybatis.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.chronotics.db.mybatis.app.dao.AppDao;
import org.chronotics.db.mybatis.app.dao.IAppDao;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("appService")
public class AppService {
	
	@Resource(name = "appDao")
	AppDao dao;
	
	public List<Float> selectNumberByName(String _name) {

		List<Float> numberList = null;
		try {
			numberList = dao.getNumbers(_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numberList;
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
		
		return 0;
	}
	
	public int deleteRecord() {
//			String _tablename) {//, 
//			String _leftOperand,
//			String _operator,
//			String _rightOperand) {
		return dao.deleteRecord(); //_tablename);//, _leftOperand, _operator, _rightOperand);
	}
	
}
