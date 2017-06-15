package ce.ackermander.petlookup.hibernate.entities;

import java.util.Date;
import java.util.Set;

public class Pet {
	private int petId;
	
	private String petDescription;
	
	private Remember firstHelper;
	private Remember owner;
	private Date findDate;

	public static final int _PET_HAS_ADOPTED = 1;
	public static final int _PET_HAS_NOT_ADOPTED = 0;
	
	private int isAdopt;
	
	public int getIsAdopt() {
		return isAdopt;
	}

	public void setIsAdopt(int isAdopt) {
		this.isAdopt = isAdopt;
	}

	public Date getFindDate() {
		return findDate;
	}

	public void setFindDate(Date findDate) {
		this.findDate = findDate;
	}

	private Vaccine vaccine;
	private Set<PetPicture> pics;

	public Set<PetPicture> getPics() {
		return pics;
	}

	public void setPics(Set<PetPicture> pics) {
		this.pics = pics;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public Remember getFirstHelper() {
		return firstHelper;
	}

	public void setFirstHelper(Remember firstHelper) {
		this.firstHelper = firstHelper;
	}

	public Remember getOwner() {
		return owner;
	}

	public void setOwner(Remember owner) {
		this.owner = owner;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetDescription() {
		return petDescription;
	}

	public void setPetDescription(String petDescription) {
		this.petDescription = petDescription;
	}
	
	
}
