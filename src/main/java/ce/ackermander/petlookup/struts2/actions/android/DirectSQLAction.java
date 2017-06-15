package ce.ackermander.petlookup.struts2.actions.android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import ce.ackermander.petlookup.hibernate.services.DaoService;

public class DirectSQLAction extends ActionSupport{

	@Autowired
	public DaoService ds;
	public String directAction(){
		PrintWriter writer = null;
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.addHeader("content-type", "text/plain;");
//		resp.addHeader("charset", "utf-8");

//		resp.setContentType("text/plain;charset=utf-8");
//		resp.setCharacterEncoding("utf-8");
		HttpServletRequest req = ServletActionContext.getRequest();
		String sql = req.getParameter("sql");
		List<String> set;
		try {
			writer = resp.getWriter();
			
			set = ds.direct(sql);
			for(String one : set){
				System.out.println(one);
				writer.println(new String(one.getBytes(),"UTF-8"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			writer.println("Error SQL Syntax");
			return null;
		}
		return null;
	}
}
