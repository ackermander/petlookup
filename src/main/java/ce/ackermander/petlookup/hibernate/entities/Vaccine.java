package ce.ackermander.petlookup.hibernate.entities;

import java.util.Set;

public class Vaccine {
	private Integer id;
	private String vaccineName;

	private Hospital operateHospital;
	private Set<VaccineCount> counts;
	private Pet pet;

	private int finish;

	
	public Set<VaccineCount> getCounts() {
		return counts;
	}

	public void setCounts(Set<VaccineCount> counts) {
		this.counts = counts;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}

	public Hospital getOperateHospital() {
		return operateHospital;
	}

	public void setOperateHospital(Hospital operateHospital) {
		this.operateHospital = operateHospital;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
