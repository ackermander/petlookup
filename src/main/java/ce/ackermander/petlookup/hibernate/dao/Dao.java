package ce.ackermander.petlookup.hibernate.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.management.RuntimeErrorException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ce.ackermander.petlookup.hibernate.entities.Doctor;
import ce.ackermander.petlookup.hibernate.entities.Hospital;
import ce.ackermander.petlookup.hibernate.entities.Mission;
import ce.ackermander.petlookup.hibernate.entities.Pet;
import ce.ackermander.petlookup.hibernate.entities.Remember;
import ce.ackermander.petlookup.hibernate.entities.Security;
import ce.ackermander.petlookup.hibernate.entities.Vaccine;
import ce.ackermander.petlookup.hibernate.entities.VaccineCount;


@Repository
public class Dao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private Session getSession(){
		synchronized (sessionFactory) {
			
			return sessionFactory.getCurrentSession();
		}
	}
	public void test(){
		testVaccineCount();
	}
	public void testme() {
		System.out.println(sessionFactory);
		System.out.println(getSession());
		Session s = getSession();
		List<Mission> missions = s.createQuery("FROM Mission").getResultList();
		HashSet<Mission> mSet = new HashSet<Mission>(missions);
		
		
		Security security = new Security("11");
		Remember remember = new Remember(0, 0, "acmd", "177", 0, 0
				, "s", mSet
				, null, null, null, null, security);
		s.save(security);
		s.update(remember);
		List resultList = s.createQuery("FROM Remember").getResultList();
		System.out.println(resultList.size());
	}
	public void test2(){
		Session session = getSession();
		List<Remember> resultList = session.createQuery("FROM Remember").getResultList();
		System.out.println(resultList.get(0).getMissionJoined());
		List<Mission> missions = new ArrayList<>(resultList.get(0).getMissionJoined());
		System.out.println(missions.get(0).getCreateTime());
	}
	
	public void testremgetpets(){
		Session s = getSession();
		List<Remember> list = s.createQuery("FROM Remember").getResultList();
		Remember remember = list.get(0);
		Set<Pet> pets = remember.getPets();
		List<Pet> list2 = new ArrayList<>(pets);
		System.out.println(list2.size());
	}
	
	public void testgetdoc(){
		Session s = getSession();
		List<Remember> list = s.createQuery("FROM Remember").getResultList();
		Remember rem = list.get(1);
		List<Hospital> hList = s.createQuery("FROM Hospital").getResultList();
		Doctor doctor = new Doctor(4, "吴振昌", 1, "12", hList.get(0));
		Doctor d = rem.getDoctor();
		d.setDoctorName("吴振昌");
		s.update(d);
		s.update(rem);
		System.out.println(rem.getDoctor().getDoctorName());
		
	}
	
	public void testsetdoc(){
		Session s = getSession();
		List<Hospital> hList = s.createQuery("FROM Hospital").getResultList();
		Doctor doctor = new Doctor(6,"吴振昌", 1, "12", hList.get(0));
		System.out.println(doctor == null);
		s.save(doctor);
		
	}
	
	public void testVaccine(){
		Session s = getSession();
		List<Vaccine> list = s.createQuery("FROM Vaccine").getResultList();
		Vaccine vaccine = list.get(0);
		System.out.println(vaccine.getPet().getOwner().getRememberName());
	}
	public void testPetGetVaccine(){
		Session s = getSession();
		List<Pet> list = s.createQuery("FROM Pet").getResultList();
		Pet pet = list.get(0);
		System.out.println(pet.getVaccine().getFinish());
	}
	public void testVaccineCount(){
		Session s = getSession();
		List<Vaccine> list = s.createQuery("FROM Vaccine").getResultList();
		Vaccine vaccine = list.get(0);
		List<VaccineCount> vaccineCounts = new ArrayList<>(vaccine.getCounts());
		VaccineCount vaccineCount = vaccineCounts.get(0);
		System.out.println(vaccineCount.getOperator().getDoctorName());
		
		
	}
	public void testpetgetrem(){
		Session s = getSession();
		List<Pet> list = s.createQuery("FROM Pet").getResultList();
		Pet pet = list.get(0);
		pet.getOwner();
		System.out.println(pet.getOwner().getPhone());

	}
}
