package ce.ackermander.petlookup.hibernate.dao.implementor;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ce.ackermander.petlookup.hibernate.dao.IBaseDao;
import ce.ackermander.petlookup.hibernate.entities.Remember;

@Repository
public class BaseDao implements IBaseDao{
	@Autowired
	public SessionFactory factory;
	
	public Session getSession(){
		return factory.getCurrentSession();
	}

	@Override
	public boolean delete(Object o) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public void insert(Object o) {
		// TODO Auto-generated method stub
		Session s = getSession();
		s.save(o);
		
	}
	@Override
	public Object select(String hql) {
		Session s = getSession();
		List results = s.createQuery(hql).getResultList();
		return results;
	}
	
	public Object select(String hql, Object ... objects){
		Session s = getSession();
		Query q = s.createQuery(hql);
		int i = 0;
		for(Object o : objects){
			q.setParameter(i, o);
			i ++;
		}
		return q.getResultList();
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		Session s = getSession();
		s.saveOrUpdate(o);
		
	}

	ResultSet executeQuery = null;
	@Override
	public List<String> direct(String sql) throws SQLException {
		// TODO Auto-generated method stub
		Session s = getSession();
		s.doWork(new Work() {
			@Override
			public void execute(Connection connection){
				// TODO Auto-generated method stub
				PreparedStatement stat;
				try {
					stat = connection.prepareStatement(sql);
					executeQuery = stat.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					executeQuery = null;
				}
			}
		});

		
		return toList(executeQuery);
	}
	
	public List<String> toList(ResultSet set) throws SQLException{
		List<String> all = new ArrayList<>();
		if(set == null){
			all.add("ERROR SQL SYNTAX");
			return all;
		}
		
		while(set.next()){
			int i = 1;
			String one = "";
			try{
				do{
					one += set.getObject(i).toString() + "-";
					i++;
				}while(set.getObject(i) != null);
			}catch(SQLException e){
				all.add(one);
			}
		}

		return all;
	}
	
	public Object getX(String name,Remember r){
		return r.getSecure().getPassword();
	}


	
	
}
