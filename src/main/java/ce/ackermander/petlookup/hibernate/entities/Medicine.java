package ce.ackermander.petlookup.hibernate.entities;

public class Medicine {
	private Integer medId;

	private String medicineName;
	private float medicinePrice;

	public Integer getMedId() {
		return medId;
	}

	public void setMedId(Integer medId) {
		this.medId = medId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public float getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(float medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

}
