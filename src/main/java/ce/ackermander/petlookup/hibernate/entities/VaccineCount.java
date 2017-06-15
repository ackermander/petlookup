package ce.ackermander.petlookup.hibernate.entities;

import java.util.Date;
import java.util.Set;

public class VaccineCount {
	private Integer countId;

	private int count;
	private String countName;
	private Date vacDate;
	private float docFee;
	
	private Doctor operator;
	private Set<Medicine> medicines;

	public Doctor getOperator() {
		return operator;
	}

	public void setOperator(Doctor operator) {
		this.operator = operator;
	}

	public Set<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(Set<Medicine> medicines) {
		this.medicines = medicines;
	}

	public Integer getCountId() {
		return countId;
	}

	public void setCountId(Integer countId) {
		this.countId = countId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCountName() {
		return countName;
	}

	public void setCountName(String countName) {
		this.countName = countName;
	}

	public Date getVacDate() {
		return vacDate;
	}

	public void setVacDate(Date vacDate) {
		this.vacDate = vacDate;
	}

	public float getDocFee() {
		return docFee;
	}

	public void setDocFee(float docFee) {
		this.docFee = docFee;
	}

}
