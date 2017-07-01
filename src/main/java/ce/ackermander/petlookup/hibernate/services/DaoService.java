package ce.ackermander.petlookup.hibernate.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ce.ackermander.petlookup.hibernate.dao.implementor.BaseDao;
import ce.ackermander.petlookup.hibernate.entities.Remember;

@Service
@Transactional
public class DaoService {
	
	@Autowired
	private BaseDao base;
	
	public List<String> direct(String sql) throws SQLException{
		return base.direct(sql);
	}
	
	public Object select(String hql){
		return base.select(hql);
	}
	
	public void save(Object o){
		base.insert(o);
	}
	
	public void update(Object o){
		base.update(o);
	}
	
	public Object select(String hql, Object ... objects){
		
		return base.select(hql, objects);
	}
	
	public Object getX(String name,Remember r){
		return base.getX(name, r);
	}

}
