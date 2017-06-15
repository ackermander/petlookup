package ce.ackermander.petlookup.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import ce.ackermander.petlookup.hibernate.dao.Dao;
import ce.ackermander.petlookup.hibernate.dao.implementor.BaseDao;
import ce.ackermander.petlookup.hibernate.services.TestService;

public class TestCase {

	private ApplicationContext ctx = null;
	private BaseDao bd;
	private TestService ts;
	{
		ctx = new ClassPathXmlApplicationContext("hibernate-settings-ctx.xml");
		ts =ctx.getBean(TestService.class);
		bd = ctx.getBean(BaseDao.class);
	}

	
	@Test
	public void test1() throws SQLException{
		ts.test();
	}
	
	@Test
	public void test3(){
		// 创建一个SessionFactory
				SessionFactory sessionFactory = null;
				// 创建Configuration对象:对应hibernate的基本配置信息和对象关系映射
				Configuration configuration = new Configuration().configure();
				// 创建一个ServiceRegistry对象:hibernate 4.x后新添加的对象
				// hibernate 的任何配置和服务都需要在该对象中注册后才能有效
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.configure().build();

				sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
				// 创建一个Session对象
				Session session = sessionFactory.openSession();
				// 开启事务
				Transaction transaction = session.beginTransaction();
				
				String sql = "FROM Remember WHERE remremberName = ?";
				org.hibernate.query.Query query = session.createQuery(sql);
				Object[] limits = new Object[]{"123"};
//				query.setParameter("usrnm", 1);
				for(int i = 0; i < limits.length; i++){
					query.setParameter(i, limits[i]);
				}
				
				List<Object> resultList = query.getResultList();
				System.out.println(resultList.size());
				transaction.commit();
				// 关闭Session
				session.close();
				// 关闭SessionFactory对象
				sessionFactory.close();
	}
	
	@Test
	public void test2(){
		System.out.println("177653".matches("^[a-z0-9_-]{6,18}$"));
		boolean matches = Pattern.matches("^[\u2E80-\u9FFFA-Za-z0-9_-]{2,11}$", "AC吴1an");
		System.out.println(matches);
	}
}
