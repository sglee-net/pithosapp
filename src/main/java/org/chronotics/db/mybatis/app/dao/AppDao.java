package org.chronotics.db.mybatis.app.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.chronotics.db.mybatis.MapperMySql;
import org.chronotics.db.mybatis.SqlStatement;
import org.chronotics.db.mybatis.SqlStatement.KEYWORD;
import org.chronotics.db.mybatis.SqlStatement.OPERATOR;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("appDao")
public class AppDao implements IAppDao {

	private static final Logger logger = 
			LoggerFactory.getLogger(AppDao.class);
	
	@Resource(name = "sqlSessionSimpleMySql")
	private SqlSession sqlSession;
	
	@Resource(name = "mapperSimpleMySql")
	private MapperMySql mapper;

	public void setSqlSession(SqlSession _sqlSession) {
		sqlSession = _sqlSession;
	}
	
	public static String TABLENAME = "table1";
	public static String CID = "c0";
	public static String CSTR1 = "c1";
	public static String CSTR2 = "c2";
	public static String CNUMBER = "c3";
	public static String CVARBINARY = "c4";
	public static String CBLOB = "c5";
	public static String CCLOB = "c6";
	public static String CDATE = "c7";
	public static String CTIME = "c8";
	public static String CTIMESTAMP = "c9";
	
	public static List<Map<String,Object>> itemSet1 = 
			new ArrayList<Map<String,Object>>();
	public static int itemCount = 100;
	
	private boolean initialized = false;
	private boolean isInitialized() {		
		if(sqlSession == null) {
			throw new NullPointerException();
		}
		if(mapper == null) {
			throw new NullPointerException();
		}

		return initialized;
	}
	
	AppDao() {
		
	}
	
	@Override
	protected void finalize() throws Throwable {
		dropTables();
	}
	
	private void initialize() {

		for(int i=0; i<itemCount; i++) {
			Map<String,Object> item = 
					new LinkedHashMap<String,Object>();
			item.put(CSTR1, Integer.toString(i));
			item.put(CSTR2, Integer.toString(i));
			item.put(CNUMBER, (double)i);
			// BINARY
			// BLOB
			// CLOB
			item.put(CDATE, new java.sql.Date(new java.util.Date().getTime()));
			item.put(CTIME, new java.sql.Time(new java.util.Date().getTime()));
			item.put(CTIMESTAMP, new java.sql.Timestamp(new java.util.Date().getTime()));
			itemSet1.add(item);
		}
		
		createTables();
		
		int resultCount = 0;
		try {
			resultCount = insertMultipleItems();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("{} items are inserted",resultCount);

		initialized = true;
	}
	
	private void createTables() {
		
		{
			String statement=
			"DROP TABLE IF EXISTS " + TABLENAME;
			Map<Object,Object> sqlStatement = new LinkedHashMap<Object,Object>();
			sqlStatement.put(KEYWORD.STATEMENT,statement);
			mapper.doStatement(sqlStatement);
		}
		
		{
			String statement=
			"CREATE TABLE "+ TABLENAME +" (" + 
			"	c0 BIGINT(20) unsigned NOT NULL AUTO_INCREMENT," + 
			"	c1 VARCHAR(255) NULL," + 
			"	c2 VARCHAR(255) NULL," + 
			"	c3 FLOAT NULL default '0'," + 
			"	c4 VARBINARY(255) NULL," + 
			"	c5 BLOB NULL," + 
			"	c6 TEXT NULL," + 
			"	c7 DATE NULL," + 
			"	c8 TIME NULL," + 
			"	c9 TIMESTAMP(6) NULL," + 
			"	PRIMARY KEY (c0)" + 
			");";
			Map<Object,Object> sqlStatement = new LinkedHashMap<Object,Object>();
			sqlStatement.put(KEYWORD.STATEMENT,statement);
			mapper.doStatement(sqlStatement);
		}
	}
	
	public void dropTables() {
		if(isInitialized()) {
			String statement=
			"DROP TABLE IF EXISTS " + TABLENAME;
			Map<Object,Object> sqlStatement = new LinkedHashMap<Object,Object>();
			sqlStatement.put(KEYWORD.STATEMENT,statement);
			mapper.doStatement(sqlStatement);
		}
	}
	
	private int insertMultipleItems() {
		List<Object> colNames = new ArrayList<Object>();
		colNames.add(CSTR1);
		colNames.add(CSTR2);
		colNames.add(CNUMBER);
		// binary
		// blob
		// clob
		colNames.add(CDATE);
		colNames.add(CTIME);
		colNames.add(CTIMESTAMP);
		
		List<List<Object>> records = new ArrayList<List<Object>>();
		for(Map<String,Object> entry : itemSet1) {
			List<Object> record = new ArrayList<Object>();
			
			String str1 = (String) entry.get(CSTR1);
			String str2 = (String) entry.get(CSTR2);
			Object number = entry.get(CNUMBER);
			// binary
			// blob
			// clob
			Object date = entry.get(CDATE);
			Object time = entry.get(CTIME);
			Object timestamp = entry.get(CTIMESTAMP);
						
			record.add(str1);
			record.add(str2);
			record.add(number);
			// binary
			// blob
			// clob
			record.add(date);
			record.add(time);
			record.add(timestamp);
			
			records.add(record);
		}
		
		SqlStatement sqlStatement = 
				new SqlStatement.Builder()
				.insert(TABLENAME)
				.records(colNames, records)
				.build();
		
		assert(sqlStatement != null);
		if(sqlStatement == null) {
			return -1;
		}
		
		int count = -1;
		try {
			count = mapper.insertMultipleItems(sqlStatement);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
	@Override
	public List<Float> getNumbers(String name) {
		if(!isInitialized()) {
			initialize();
		}
		
		List<Float> rt = new ArrayList<Float>();
		
		SqlStatement sqlStatement = 
				new SqlStatement.Builder()
				.select("*")
				.from("user")
				.build();

		List<Map<String, Object>> result = null;
		try {
			result = mapper.selectList(sqlStatement);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Map<Object, Object> parameter = new LinkedHashMap<Object, Object>();
//		parameter.put("table", "user");
//		parameter.put("name", name);
//		
//		List<Map<String, Object>> result =
//				sqlSession.selectOne(IAppMapper.className+"selectOne",parameter);
//
		if(result==null || result.size()==0) {
			return rt;
		}
		for(Map<String,Object> entry : result) {
			Object obj = entry.get("number");
			if(obj != null) {
				rt.add((float)obj);
			}
		}
		return rt;
	}
	
	public JSONObject selectAllRecords(String _tableName) {
		if(!isInitialized()) {
			initialize();
		}
		
		SqlStatement sqlStatement = null;
		sqlStatement = new SqlStatement.Builder()
				.select("*")
				.from(_tableName)
				.build();

		assert(sqlStatement != null);
		if(sqlStatement == null) {
			return null;
		}

		List<Map<String, Object>> resultSet = null;
		try {
			resultSet = mapper.selectList(sqlStatement);
			logger.info("{} items are selected",resultSet.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject jsonObject = null;
		if(resultSet != null) {
			jsonObject = SqlStatement.getJSonObject(resultSet, 0, resultSet.size());
		}
		return jsonObject;
	}
	
	public int insertRecord(String _json) {
		if(!isInitialized()) {
			initialize();
		}
		
		String tableName = null;
		try {
			tableName = SqlStatement.getTableName(_json);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(tableName == null) {
			return -1;
		}
		
		List<Object> colNames = null;
		List<Object> colValues = null;
		
		try {
			colNames = SqlStatement.getColNames(_json);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		try {
			colValues = SqlStatement.getColValues(_json);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if(colNames == null || colValues == null) {
			return -1;
		}
		
		SqlStatement sqlStatement = null;
		sqlStatement = new SqlStatement.Builder()
				.insert(tableName)
				.colValues(colNames, colValues)
				.build();

		assert(sqlStatement != null);
		if(sqlStatement == null) {
			return -1;
		}
		
		int resultCount = 0;
		try {
			resultCount = mapper.insert(sqlStatement);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("{} items are inserted",resultCount);
		return resultCount;
	}
	
	public int insertRecords(String _json) {
		if(!isInitialized()) {
			initialize();
		}
		
		String tableName = null;
		try {
			tableName = SqlStatement.getTableName(_json);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(tableName == null) {
			return -1;
		}
		
		List<Object> colNames = null;
		List<List<Object>> records = null;
		
		try {
			colNames = SqlStatement.getColNames(_json);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		try {
			records = SqlStatement.getRecords(_json);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if(colNames == null || records == null) {
			return -1;
		}
		
		SqlStatement sqlStatement = null;
		sqlStatement = new SqlStatement.Builder()
				.insert(tableName)
				.records(colNames, records)
				.build();

		assert(sqlStatement != null);
		if(sqlStatement == null) {
			return -1;
		}
		
		int resultCount = 0;
		try {
			resultCount = mapper.insertMultipleItems(sqlStatement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("{} items are inserted",resultCount);
		return resultCount;
	}
	
	public int updateRecord(String _jsonSetObject) {
		if(!isInitialized()) {
			initialize();
		}
		
		String tableName = null;;
		try {
			tableName = SqlStatement.getTableName(_jsonSetObject);
		} catch (JSONException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if(tableName == null) {
			return -1;
		}
		
		Map<String,Object> colVariables = null;
		try {
			colVariables =
				SqlStatement.getColVariables(_jsonSetObject);
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(colVariables == null) {
			return -1;
		}
		
		SqlStatement sqlStatement = null;
		sqlStatement = new SqlStatement.Builder()
			.update(tableName)
//			.set(CSTR1, "xxx")
			.set(colVariables)
			.where(CNUMBER, OPERATOR.GT, 0)
			.build();

		assert(sqlStatement != null);
		if(sqlStatement == null) {
			return -1;
		}
		
		int resultCount = 0;
		try {
			resultCount = mapper.update(sqlStatement);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("{} items are updated",resultCount);
		return resultCount;
	}
	
	public int deleteRecord() {
		if(!isInitialized()) {
			initialize();
		}
		
		SqlStatement sqlStatement = null;
		sqlStatement = new SqlStatement.Builder()
			.delete(TABLENAME)
			.where(CNUMBER, SqlStatement.OPERATOR.GE, 0)
			.build();

		assert(sqlStatement != null);
		if(sqlStatement == null) {
			return -1;
		}
		
		int resultCount = 0;
		try {
			return resultCount = mapper.delete(sqlStatement);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("{} items are deleted",resultCount);
		return resultCount;
	}
}
