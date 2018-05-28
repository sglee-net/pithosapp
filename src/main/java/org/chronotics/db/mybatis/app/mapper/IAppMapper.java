package org.chronotics.db.mybatis.app.mapper;

import java.util.List;
import java.util.Map;

public interface IAppMapper {

	public static String className = "org.chronotics.db.mybatis.app.mapper.IAppMapper.";

	public List<Map<String,Object>> selectCustom(Map<Object,Object> parameter);	
}
