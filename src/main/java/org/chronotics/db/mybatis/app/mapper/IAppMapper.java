package org.chronotics.db.mybatis.app.mapper;

import java.util.List;
import java.util.Map;

public interface IAppMapper {

	public static String className = "org.chronotics.db.mybatis.app.mapper.IAppMapper.";

	public Map<String,Object> selectOne(Map<Object,Object> parameter);
	
	public List<Map<String,Object>> selectList(Map<Object,Object> parameter);
	
	public int insert(Map<Object,Object> parameter);
	
	public int update(Map<Object,Object> parameter);
	
	public int delete(Map<Object,Object> parameter);
}
