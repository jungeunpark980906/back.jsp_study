package orm;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseBuilder {
	

	private static Logger log = LoggerFactory.getLogger(DatabaseBuilder.class);
	
	private static SqlSessionFactory factory;
	
	private static final String config = "orm/MybatisConfig.xml";
	
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsReader(config));
					
		} catch (IOException e) {
			
			log.info("mybatis 설정 오류입니다!"); 
			e.printStackTrace();
			
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}

	
	
}
