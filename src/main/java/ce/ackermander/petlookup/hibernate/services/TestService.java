package ce.ackermander.petlookup.hibernate.services;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import ce.ackermander.petlookup.hibernate.dao.Dao;
import ce.ackermander.petlookup.hibernate.dao.implementor.BaseDao;
import ce.ackermander.petlookup.hibernate.entities.Hospital;
import ce.ackermander.petlookup.hibernate.entities.Pet;
import ce.ackermander.petlookup.hibernate.entities.PetPicture;
import ce.ackermander.petlookup.hibernate.entities.Remember;
import ce.ackermander.petlookup.hibernate.entities.Vaccine;
import ce.ackermander.petlookup.hibernate.entities.VaccineCount;
import ce.ackermander.petlookup.kits.JsonArrayKit;

@Service
public class TestService {

	@Autowired
	private Dao dao;
	@Autowired
	private BaseDao ds;
	Gson g = new Gson();
	
	
	public void test() throws SQLException{
		List<Remember> rem = (List<Remember>) ds.select("FROM Remember r WHERE r.id = 1");
		Remember r = rem.get(0);
		Hospital hospital = r.getHospital();
		System.out.println(hospital.getName());
		
	}
	
}
