package org.chronotics.db.mybatis.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.chronotics.db.mybatis.app.dao.DaoApp;
import org.chronotics.db.mybatis.app.mapper.IMapperApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("serviceApp")
public class ServiceApp {
	
	@Resource(name = "daoApp")
	DaoApp dao;
	
//	@Resource(name = "mapperApp")
//	private IMapperApp mapper;
//	
//	public void setMapperUser(IMapperApp _mapper) {
//		mapper = _mapper;
//	}
	
	public float selectNumberByName(String _name) {
//		Map<Object,Object> parameterObject = new HashMap<Object,Object>();
//		parameterObject.put("name",_name);		
//		List<Map<String,Object>> result = mapper.selectList(parameterObject);
//		
//		for(Map<String,Object> map : result) {
//			for(Map.Entry<String, Object> entry : map.entrySet()) {
//				System.out.println(entry.getKey() + ", " + entry.getValue());
//			}
//		}
//		System.out.println(result.get(0).get("number"));

		float number = 0.0f;
		try {
			number = dao.getNumber(_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
}
