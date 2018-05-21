package temp;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

//public class MapperFactory implements FactoryBean<MapperSimple> {
//	private SqlSessionTemplate sqlSessionTemplateSimple;
//	
//	@Override
//	public MapperSimple getObject() throws Exception {
//		return new MapperSimple(sqlSessionTemplateSimple);
//	}
//
//	@Override
//	public Class<?> getObjectType() {
//		return MapperSimple.class;
//	}
//
//	@Override
//	public boolean isSingleton() {
//		return false;
//	}
//
//}
