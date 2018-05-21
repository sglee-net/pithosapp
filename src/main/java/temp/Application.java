//package temp;
//
//import org.apache.ibatis.exceptions.PersistenceException;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.chronotics.db.mybatis.app.service.ServiceUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
//
//@ComponentScan(basePackages = {
//		"org.chronotics.db",
//		"org.chronotics.db.mybatis",
//		"org.chronotics.db.mybatis.app.controller",
//		"org.chronotics.db.mybatis.app.mapper",
//		"org.chronotics.db.mybatis.app.service"})
//@SpringBootApplication
//public class Application { //extends RepositoryRestMvcConfiguration {
//	
//	public static void main(String[] args) {
//
//		ApplicationContext context = SpringApplication.run(Application.class,args);
//
//		//		MapperService service = new MapperService();
////		String name = service.select(0);
////		System.out.println(name);
//////		DataSource ds = (DataSource)context.getBean("dataSource");
//		
////		String resource = "mybatis/config/mybatis-config.xml";
////		InputStream inputStream = null;
////		try {
////			inputStream = Resources.getResourceAsStream(resource);
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		SqlSessionFactory sqlSessionFactory =
////		  new SqlSessionFactoryBuilder().build(inputStream);
////		
////		SqlSession session = sqlSessionFactory.openSession();
//
//		//		try{
//////			String result = session.selectOne("org.chronotics.db.mybatis.IMapper.select", "1");
////			Map<String,Object> parameterObject = new HashMap<String,Object>();
////			parameterObject.put("name","testUser");
////			
//////			IMapper mapper = session.getMapper(IMapper.class);
//////			List<Map<String,Object>> result = mapper.selectList(parameterObject);
////			
////			String[] allBeanNames = context.getBeanDefinitionNames();
////			for(String beanName : allBeanNames) {
////				System.out.println(beanName);
////			}
////			
//////			DaoUser daouser = new DaoUser();
////			//DaoUser daouser = (DaoUser) context.getBean("daoUser");
//////			DaoUser dauUser = (DaoUser)ApplicationContextProvider.getApplicationContext().getBean("daoUser");
////			
////			List<Map<String,Object>> result = dauUser.selectListByUserName(parameterObject);
////			
////			for(Map<String,Object> map : result) {
////				for(Map.Entry<String, Object> entry : map.entrySet()) {
////					System.out.println(entry.getKey() + ", " + entry.getValue());
////				}
////			}
////		} catch (PersistenceException e) {
////			e.printStackTrace();
////		} finally {
//////			session.close();
////		}
//		
//		ServiceUser service = (ServiceUser)context.getBean("serviceUser");
//		service.selectListByName("testUser");
//	}
//
//}
