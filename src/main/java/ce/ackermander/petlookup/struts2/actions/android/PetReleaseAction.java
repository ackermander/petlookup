package ce.ackermander.petlookup.struts2.actions.android;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ce.ackermander.petlookup.hibernate.entities.Hospital;
import ce.ackermander.petlookup.hibernate.entities.Pet;
import ce.ackermander.petlookup.hibernate.entities.PetPicture;
import ce.ackermander.petlookup.hibernate.entities.Remember;
import ce.ackermander.petlookup.hibernate.services.DaoService;

public class PetReleaseAction extends ActionSupport implements ModelDriven<Pet>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private DaoService ds;
	private List<File> img;
	private List<String> imgFileName;
	private List<String> imgContentType;
	
	public List<File> getImg() {
		return img;
	}

	public void setImg(List<File> img) {
		this.img = img;
	}

	public List<String> getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(List<String> imgFileName) {
		this.imgFileName = imgFileName;
	}

	public List<String> getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(List<String> imgContentType) {
		this.imgContentType = imgContentType;
	}

	private Pet pet;
	
	public String releaseByRemember() throws IOException{
		Remember rem = (Remember) getSession().getAttribute("remb");
		Hospital hos = (Hospital) getSession().getAttribute("hos");
		if(hos != null){
			getOut().write("请正确请求");
			return null;
		}
		if(rem == null){
			getOut().write("请登录");
			return null;
		}
		savePet(rem);
		getOut().write("宠物录入成功");
		
		return null;
	}
	
	
	
	public String petReleaseByHospital() throws IOException{
		Remember rem = (Remember) getSession().getAttribute("remb");
		Hospital hos = (Hospital) getSession().getAttribute("hos");
		if(rem != null){
			getOut().write("请正确请求");
			return null;
		}
		if(hos == null){
			getOut().write("请登录");
			return null;
		}
		List<Remember> list = (List<Remember>) ds.select("FROM Remember r WHERE r.id = " + hos.getId());
		rem = list.get(0);
		savePet(rem);
		getOut().write("宠物录入成功");

		
		return null;
	}
	
	String url;
	String dir;
	{
		dir = ServletActionContext.getServletContext().getRealPath("/imgs/");
	}
	public void uploads() throws IOException{
		int i = 0;
		for(File file : img){
			FileInputStream fis = new FileInputStream(file);
			url = dir + "ppics/" + imgFileName.get(i ++);
			FileOutputStream fos = new FileOutputStream(url);
			int c;
			while( (c = fis.read()) != -1){
				fos.write(c);
			}
			fos.flush();
			fos.close();
		}
	}
	
	private void savePet(Remember rem) throws IOException{
		pet.setOwner(rem);
		pet.setFirstHelper(rem);
		pet.setFindDate(new Date());
		pet.setIsAdopt(Pet._PET_HAS_NOT_ADOPTED);
		if(img != null){
			if(img.size() > 0)
				uploads();			
			Set<PetPicture> pics = new HashSet<>();
			for(String name : imgFileName){
				PetPicture pic = new PetPicture(dir + "ppics/" + name);
				pics.add(pic);
				ds.save(pic);
			}
			pet.setPics(pics);
		}
		
		ds.save(pet);
	}
	private Writer getOut() throws IOException{
		return ServletActionContext.getResponse().getWriter();
	}
	
	private HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}

	@Override
	public Pet getModel() {
		// TODO Auto-generated method stub
		pet = new Pet();
		return pet;
	}
}
