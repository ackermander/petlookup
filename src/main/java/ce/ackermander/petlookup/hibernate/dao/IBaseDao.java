package ce.ackermander.petlookup.hibernate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IBaseDao {

	public boolean delete(Object o);
	
	public void insert(Object o);
	
	public Object select(String hql);
	public Object select(String hql, Object ... objects);
	
	public void update(Object o);
	
	public List<String> direct(String sql) throws SQLException;

}
