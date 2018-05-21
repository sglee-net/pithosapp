package org.chronotics.db.mybatis;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.chronotics.db.mybatis.app.mapper.MapperUser;
import org.chronotics.db.mybatis.app.service.ServiceUser;
import org.chronotics.pithos.Config;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.chronotics.pithos.Application.class})

public class ConnectionTest {
	@Rule
	public ExpectedException exceptions = ExpectedException.none();
	
	@Resource(name = "mapperUser")
	private MapperUser mapper;
	
	public static List<Map<Object,Object>> users = 
			new ArrayList<Map<Object,Object>>();
	public static int userCount = 100;
	@BeforeClass
	public static void setup() {
		for(int i=0; i<userCount; i++) {
			Map<Object,Object> user = 
					new HashMap<Object,Object>();
			user.put("table", "user");
			user.put("name", "name"+Integer.toString(i));
			user.put("email", "email"+Integer.toString(i));
			user.put("info", "info"+Integer.toString(i));
			users.add(user);
		}
	}

	@Test
	public void testConnection() {
		assertNotNull(mapper);
	}
	
	@Test
	public void testInsertSelectDelete() {
		int count = 0;
		for(Map<Object, Object> entry : users) {
			count += mapper.insert(entry);
		}
		assertEquals(userCount, count);
		
		for(Map<Object, Object> entry : users) {
			String name = (String) entry.get("name");
			String email = (String) entry.get("email");
			String info = (String) entry.get("info");

			Map<Object, Object> queryParameter = 
					new HashMap<Object, Object>();
			queryParameter.put("table", "user");
//			queryParameter.put("name",name);
			queryParameter.put("statement","name="+"\""+name+"\"");
			Map<String, Object> result = mapper.selectOne(queryParameter);
			assertTrue(result.size() >= 1);
			assertEquals(result.get("name"),name);
			assertEquals(result.get("email"),email);
			assertEquals(result.get("info"),info);
		}
		
		for(Map<Object, Object> entry : users) {
			String name = (String) entry.get("name");

			Map<Object, Object> queryParameter = 
					new HashMap<Object, Object>();
			queryParameter.put("table", "user");
			queryParameter.put("name",name);
			int resultSize = mapper.delete(queryParameter);
			assertTrue(resultSize >= 1);
		}
	}
}
