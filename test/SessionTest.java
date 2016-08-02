import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

public class SessionTest {
	@Test
	public void testOpenSession() {
		// 获得配置对象
		Configuration aConfiguration = new Configuration().configure();
		// 获得服务注册对象
		ServiceRegistry aServiceRegistry = new ServiceRegistryBuilder().applySettings(aConfiguration.getProperties())
				.buildServiceRegistry();
		// 获得sessionFactory对象
		SessionFactory aSessionFactory = aConfiguration.buildSessionFactory(aServiceRegistry);
		// 获得session对象
		Session aSession = aSessionFactory.openSession();
		if (aSession != null) {
			System.out.println("session创建成功");
		} else {
			System.out.println("session创建失败");
		}
	}

	@Test
	public void testGetCurrentSession() {
		// 获得配置对象
		Configuration aConfiguration = new Configuration().configure();
		// 获得服务注册对象
		ServiceRegistry aServiceRegistry = new ServiceRegistryBuilder().applySettings(aConfiguration.getProperties())
				.buildServiceRegistry();
		// 获得sessionFactory对象
		SessionFactory aSessionFactory = aConfiguration.buildSessionFactory(aServiceRegistry);
		// 获得session对象
		Session aSession = aSessionFactory.getCurrentSession();
		if (aSession != null) {
			System.out.println("session创建成功");
		} else {
			System.out.println("session创建失败");
		}
	}

	@Test
	public void testSaveStudentsWithOpenSession() {
		// 获得配置对象
		Configuration aConfiguration = new Configuration().configure();
		// 获得服务注册对象
		ServiceRegistry aServiceRegistry = new ServiceRegistryBuilder().applySettings(aConfiguration.getProperties())
				.buildServiceRegistry();
		// 获得sessionFactory对象
		SessionFactory aSessionFactory = aConfiguration.buildSessionFactory(aServiceRegistry);
		// 创建session对象
		Session session1 = aSessionFactory.openSession();
		// 开启事务
		Transaction aTransaction = session1.beginTransaction();
		// 生成学生对象
		Students aStudent = new Students(1, "张三", "男", new Date(), "北京");
		session1.doWork(new Work() {

			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println("connection hashCode:" + connection.hashCode());
			}
		});
		session1.save(aStudent);
		// session1.close();
		// 提交事务
		aTransaction.commit();

		Session session2 = aSessionFactory.openSession();
		aTransaction = session2.beginTransaction();
		aStudent = new Students(2, "李四", "男", new Date(), "上海");
		session2.doWork(new Work() {

			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println("connection hashCode:" + connection.hashCode());
			}
		});
		session2.save(aStudent);
		aTransaction.commit();
	}

	@Test
	public void testSaveStudentsWithGetCurrentSession() {
		// 获得配置对象
		Configuration aConfiguration = new Configuration().configure();
		// 获得服务注册对象
		ServiceRegistry aServiceRegistry = new ServiceRegistryBuilder().applySettings(aConfiguration.getProperties())
				.buildServiceRegistry();
		// 获得sessionFactory对象
		SessionFactory aSessionFactory = aConfiguration.buildSessionFactory(aServiceRegistry);
		// 创建session对象
		Session session1 = aSessionFactory.getCurrentSession();
		// 开启事务
		Transaction aTransaction = session1.beginTransaction();
		// 生成学生对象
		Students aStudent = new Students(1, "张三", "男", new Date(), "北京");
		session1.doWork(new Work() {

			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println("connection hashCode:" + connection.hashCode());
			}
		});
		session1.save(aStudent);
		// session1.close();
		// 提交事务
		aTransaction.commit();

		Session session2 = aSessionFactory.getCurrentSession();
		aTransaction = session2.beginTransaction();
		aStudent = new Students(2, "李四", "男", new Date(), "上海");
		session2.doWork(new Work() {

			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println("connection hashCode:" + connection.hashCode());
			}
		});
		session2.save(aStudent);
		aTransaction.commit();
	}
}
