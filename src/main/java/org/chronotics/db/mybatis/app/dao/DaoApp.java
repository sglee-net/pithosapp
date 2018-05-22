package org.chronotics.db.mybatis.app.dao;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.chronotics.db.mybatis.MapperMySql;
import org.chronotics.db.mybatis.SqlStatement;
import org.chronotics.db.mybatis.app.mapper.IMapperApp;
import org.springframework.stereotype.Repository;

@Repository("daoApp")
public class DaoApp implements IDaoApp {

	@Resource(name = "sqlSessionSimpleMySql")
	private SqlSession sqlSession;
	
	@Resource(name = "mapperSimpleMySql")
	private MapperMySql mapper;
	
	public void setSqlSession(SqlSession _sqlSession) {
		sqlSession = _sqlSession;
	}
	
	@Override
	public float getNumber(String name) throws Exception {
		if(sqlSession == null) {
			return 888;
		}
		
		if(mapper == null) {
			return 889;
		}
		
//		SqlStatement sqlSatement = 
//				new SqlStatement.Builder()
//				.select("*")
//				.from("user")
//				.build();
//
//		Map<String, Object> result = 
//				mapper.selectOne(sqlSatement);
		
		Map<Object, Object> parameter = new LinkedHashMap<Object, Object>();
		parameter.put("table", "user");
		parameter.put("name", name);
		
		Map<String, Object> result =
				sqlSession.selectOne(IMapperApp.className+"selectOne",parameter);

		if(result.size() ==0) {
			return 999;
		} else {
			float number = (float)(result.get("name"));
			return number;
		}
//		return 0;
	}

}
