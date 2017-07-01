package ce.ackermander.petlookup.struts2.actions.android;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ce.ackermander.petlookup.hibernate.entities.Doctor;
import ce.ackermander.petlookup.hibernate.entities.Hospital;
import ce.ackermander.petlookup.hibernate.entities.Remember;
import ce.ackermander.petlookup.hibernate.entities.Security;
import ce.ackermander.petlookup.hibernate.services.DaoService;

public class SignInAction extends ActionSupport implements ModelDriven<Remember>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Remember rem;
	private String pswd;
	@Autowired
	private DaoService ds;
	
	public String signin() throws IOException{
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		Remember remS = (Remember) session.getAttribute("remb");
		if(remS == null){
			System.out.println(rem);
			System.out.println(pswd);
			List<Remember> list = (List<Remember>) ds
					.select("FROM Remember r WHERE r.rememberName = ? or r.phone = ?"
							,rem.getRememberName(), rem.getPhone());
//			System.out.println(list.get(0));
			if(list.size() > 0){
				String se = list.get(0).getSecure().getPassword();
				if(se.equals(pswd)){
					session.setAttribute("remb", null);
					System.out.println("1");
					getOut().write("登录失败");
					return null;
				}
				session.setAttribute("remb", list.get(0));
				if(list.get(0).getAccountKind() == Remember.KIND_HOSPITAL){
					List<Hospital> hos = (List<Hospital>) ds.select("FROM Hospital h WHERE h.id = ?", list.get(0).getId());
					session.setAttribute("hos", hos);
					getOut().write("医院账号登录");
					return null;
				}else if(list.get(0).getAccountKind() == Remember.KIND_DOCTOR){
					List<Doctor> doc = (List<Doctor>) ds.select("FROM Doctor d WHERE d.doctorId = ?", list.get(0).getId());
					session.setAttribute("doc", doc);
					getOut().write("医生登录成功");
				}
				getOut().write("登录成功");
				return null;
			}else{
				session.setAttribute("remb", null);
				System.out.println("2");
				getOut().write("登录失败");
			}
		}else{
			getOut().write("已登录");
		}
		
		return null;
	}
	
	public Writer getOut() throws IOException{
		return ServletActionContext.getResponse().getWriter();

	}

	@Override
	public Remember getModel() {
		// TODO Auto-generated method stub
		rem = new Remember();
		return rem;
	}
}
