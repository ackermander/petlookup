package ce.ackermander.petlookup.struts2.actions.android;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import ce.ackermander.petlookup.hibernate.entities.Remember;
import ce.ackermander.petlookup.hibernate.entities.Security;
import ce.ackermander.petlookup.hibernate.services.DaoService;

public class RegisterAction extends ActionSupport{

	@Autowired
	private DaoService ds;
	private File img;
	private String imgFileName;
	private String imgContentType;
	
	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}
	public Writer getOut(){
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.addHeader("content-type", "text/plain");
		Writer out = null;
		try {
			out = ServletActionContext.getResponse().getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	String dir = ServletActionContext.getServletContext().getRealPath("/imgs/");
	/**
	 * 注册用户需要的参数
	 * @return
	 * @throws IOException 
	 */
	public String register() throws IOException{
		HttpServletRequest req = ServletActionContext.getRequest();
		Remember newRem;
		String username = (String) req.getParameter("usrn");
		String password = (String) req.getParameter("pswd");
		String phone = (String) req.getParameter("phon");
		String picUrl = null;
		System.out.println( username + password + phone);
		
		if(password == null || !password.matches("^[a-z0-9_-]{6,18}$")){
			getOut().write("填写正确密码");
			return null;
		}else if(username == null || !username.matches("^[\u2E80-\u9FFFA-Za-z0-9_-]{3,8}$")){
			getOut().write("填写用户名");
			return null;
		}else if(phone == null){
			getOut().write("填写电话号码");
		}
		
		if(imgContentType != null){
			if(!imgContentType.contains("image")){
				getOut().write("文件类型错误");
				return null;
			}
			picUrl = picUpload("head", username);
			
		}
		
		if(usrDuplicate(username)){
			getOut().write("用户名已被注册");
			return null;
		}else{
			Security pswd = new Security(password);
			ds.save(pswd);
			Remember rem = new Remember(username, phone, picUrl, pswd);
			ds.save(rem);
			getOut().write("用户注册成功");
			return null;
		}
	}
	public String getFileExt(String contentType){
		return "." + contentType.split("/")[1];
	}
	public String picUpload(String type,String filename){
		String url = null;
		try {
			url = dir + type + "/" + filename + getFileExt(imgContentType);
			FileOutputStream fos = new FileOutputStream(dir + type + "/" + filename + getFileExt(imgContentType));
			FileInputStream fis = new FileInputStream(img);
			int c;
			while((c = fis.read()) != -1){
				fos.write(c);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
		
	}
	
	/**
	 * 
	 * @param usrn
	 * @return ture represent cannot register
	 * 			false represent can register
	 */
	public boolean usrDuplicate(String usrn){
		List<Remember> usr = (List<Remember>) ds.select("FROM Remember r WHERE r.rememberName = " + usrn);
		if(usr.size() > 0){
			return true;
		}else{
			return false;
		}
	}
}
