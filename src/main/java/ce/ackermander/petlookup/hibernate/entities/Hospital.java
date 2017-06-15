package ce.ackermander.petlookup.hibernate.entities;

import java.util.Set;

public class Hospital {
	private Integer id;

	private String name;
	private String registerCode;
	private String addr;
	
	private Set<HospitalPicture> hospics;
	private Set<Doctor> doctors;

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Set<HospitalPicture> getHospics() {
		return hospics;
	}

	public void setHospics(Set<HospitalPicture> hospics) {
		this.hospics = hospics;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegisterCode() {
		return registerCode;
	}

	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
