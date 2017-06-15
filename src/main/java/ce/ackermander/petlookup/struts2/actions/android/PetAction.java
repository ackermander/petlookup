package ce.ackermander.petlookup.struts2.actions.android;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

import ce.ackermander.petlookup.hibernate.entities.Pet;
import ce.ackermander.petlookup.hibernate.entities.PetPicture;
import ce.ackermander.petlookup.hibernate.entities.Vaccine;
import ce.ackermander.petlookup.hibernate.entities.VaccineCount;
import ce.ackermander.petlookup.hibernate.services.DaoService;
import ce.ackermander.petlookup.kits.JsonArrayKit;

public class PetAction extends ActionSupport{

	@Autowired
	DaoService ds;
	Gson g = new Gson();

	public String getPets() throws IOException {
		
		List<Pet> pets = (List<Pet>) ds.select("FROM Pet p WHERE p.isAdopt = 0");
		JsonArrayKit kit = new JsonArrayKit("pets");
		for (Pet pet : pets) {
			List<Vaccine> vacs = (List<Vaccine>) ds.select("FROM Vaccine v WHERE v.pet.petId = ?", pet.getPetId());
			JsonArray vacJA = new JsonArray();
			for(Vaccine vac : vacs){
				JsonObject jo = new JsonObject();
				LinkedHashMap<String, Object> vmap = new LinkedHashMap<>();
				vmap.put("vacId", vac.getId());
				vmap.put("vaccName", vac.getVaccineName());
				vmap.put("operateHos", vac.getOperateHospital().getName());
				vmap.put("isFinish", vac.getFinish());
				JsonArray countArray = new JsonArray();
				for(VaccineCount vc : vac.getCounts()){
					JsonObject jovc = new JsonObject();
					jovc.addProperty("countId", vc.getCountId());
					jovc.addProperty("countName", vc.getCountName());
					jovc.addProperty("date", vc.getVacDate().getTime());
					jovc.addProperty("operateDoc", vc.getOperator().getDoctorName());
					countArray.add(jovc);
				}
				vmap.put("hasCount", countArray);
				jo.addProperty("hasCount", countArray.toString());
				vacJA.add(g.toJsonTree(vmap));

			}
			
			
			
			//pet's pictures
			Set<PetPicture> pics = pet.getPics();
			int i = 0;
			JsonArray p_p_ja = new JsonArray();
			
			for(PetPicture pic : pics){
				JsonObject jo = new JsonObject();
				jo.addProperty(i++ + "", pic.getPicURL());
				p_p_ja.add(jo);
			}
			
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put("petId",(int) pet.getPetId());
			map.put("petPics", p_p_ja);
			map.put("petDesc", pet.getPetDescription());
			map.put("petFirstHelper", pet.getFirstHelper().getRememberName());
			map.put("petVacc", vacJA);
			String j = g.toJson(map);
			kit.addJsonObject(j);
		}
		System.out.println(kit.getJsonArray());
		getOut().write(kit.getJsonArray());
		return null;
	}
	
	public String getPetsHaveOwner(){
		
		
		return null;
	}
	
	private Writer getOut() throws IOException{
		return ServletActionContext.getResponse().getWriter();
	}

}
