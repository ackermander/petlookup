package ce.ackermander.petlookup.struts2.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import ce.ackermander.petlookup.hibernate.services.DaoService;
import ce.ackermander.petlookup.hibernate.services.TestService;

public class ActionTest extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	public DaoService ts;
	
	public String test(){
		System.out.println("test action ...");
		return "success";
	}
}
