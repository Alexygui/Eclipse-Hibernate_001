

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//测试类
public class StudentTest {
	
	private SessionFactory aSessionFactory;
	private Session aSession;
	private Transaction aTransaction;
	@Before
	public void init(){
		//创建配置对象
		Configuration aConfiguration = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry aServiceRegistry = new ServiceRegistryBuilder().applySettings(aConfiguration.getProperties()).buildServiceRegistry();
		//创建会话工厂对象
		aSessionFactory = aConfiguration.buildSessionFactory(aServiceRegistry);
		//会话对象
		aSession = aSessionFactory.openSession();
		//开启事务
		aTransaction = aSession.beginTransaction();
	}
	
	@After
	public void destroy() {
		aTransaction.commit(); //提交事务
		aSession.close(); //关闭会话
		aSessionFactory.close(); //关闭会话工厂
	}
	
	@Test
	public void testSaveStudents() {
		//生成学生对象
		Students aStudent = new Students(1, "张三丰", "男", new Date(), "武当山");
		//保存对象进入数据库
		aSession.save(aStudent);
	}
}
