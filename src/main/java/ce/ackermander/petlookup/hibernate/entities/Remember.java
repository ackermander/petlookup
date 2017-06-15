package ce.ackermander.petlookup.hibernate.entities;

import java.util.Date;
import java.util.Set;

public class Remember {
	private Integer id;
	
	public Remember() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Remember(int isAdopt, float blance, String rememberName, String phone, int accountKind, int statue,
			String remPicture, Set<Mission> missionJoined, Set<Mission> missionProposer, Set<Judgement> judgements,
			Set<Judgement> checked, Set<Pet> pets, Security secure) {
		super();
		this.isAdopt = isAdopt;
		this.blance = blance;
		this.rememberName = rememberName;
		this.phone = phone;
		this.accountKind = accountKind;
		this.statue = statue;
		this.remPicture = remPicture;
		this.missionJoined = missionJoined;
		this.missionProposer = missionProposer;
		this.judgements = judgements;
		this.checked = checked;
		this.pets = pets;
		this.secure = secure;
		this.doctor = null;
	}
	
	

	public Remember(Integer id, int isAdopt, float blance, String rememberName, String phone, int accountKind,
			int statue, String remPicture, Set<Mission> missionJoined, Set<Mission> missionProposer,
			Set<Judgement> judgements, Set<Judgement> checked, Set<Pet> pets, Security secure, Doctor doctor) {
		super();
		this.id = id;
		this.isAdopt = isAdopt;
		this.blance = blance;
		this.rememberName = rememberName;
		this.phone = phone;
		this.accountKind = accountKind;
		this.statue = statue;
		this.remPicture = remPicture;
		this.missionJoined = missionJoined;
		this.missionProposer = missionProposer;
		this.judgements = judgements;
		this.checked = checked;
		this.pets = pets;
		this.secure = secure;
		this.doctor = doctor;
	}

	public Remember(String name, String phone, String remPic, Security secure){
		this.rememberName = name;
		this.phone = phone;
		this.remPicture = remPic;
		this.secure = secure;
		this.registerDate = new Date();
	}

	//是否可以领养宠物
	private int isAdopt;
	private float blance;
	private String rememberName;
	private String phone;
	private int accountKind;
	private int statue;
	private String remPicture;
	private Date registerDate;
	private String verifyPic;
	
	public String getVerifyPic() {
		return verifyPic;
	}

	public void setVerifyPic(String verifyPic) {
		this.verifyPic = verifyPic;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}



	private Set<Mission> missionJoined;
	private Set<Mission> missionProposer;
	private Set<Judgement> judgements;
	private Set<Judgement> checked;
	private Set<Pet> pets;
	private Security secure;
	private Doctor doctor;
	private Hospital hospital;
	

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Set<Mission> getMissionJoined() {
		return missionJoined;
	}

	public void setMissionJoined(Set<Mission> missionJoined) {
		this.missionJoined = missionJoined;
	}

	public Set<Mission> getMissionProposer() {
		return missionProposer;
	}

	public void setMissionProposer(Set<Mission> missionProposer) {
		this.missionProposer = missionProposer;
	}

	public Set<Judgement> getJudgements() {
		return judgements;
	}

	public void setJudgements(Set<Judgement> judgements) {
		this.judgements = judgements;
	}

	public Set<Judgement> getChecked() {
		return checked;
	}

	@Override
	public String toString() {
		return "Remember [rememberName=" + rememberName + ", phone=" + phone + "]";
	}

	public void setChecked(Set<Judgement> checked) {
		this.checked = checked;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	public Security getSecure() {
		return secure;
	}

	public void setSecure(Security secure) {
		this.secure = secure;
	}

	public String getRemPicture() {
		return remPicture;
	}

	public void setRemPicture(String remPicture) {
		this.remPicture = remPicture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIsAdopt() {
		return isAdopt;
	}

	public void setIsAdopt(int isAdopt) {
		this.isAdopt = isAdopt;
	}

	public float getBlance() {
		return blance;
	}

	public void setBlance(float blance) {
		this.blance = blance;
	}

	public String getRememberName() {
		return rememberName;
	}

	public void setRememberName(String rememberName) {
		this.rememberName = rememberName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAccountKind() {
		return accountKind;
	}

	public void setAccountKind(int accountKind) {
		this.accountKind = accountKind;
	}

	public static final int ON_LINE = 1;
	public static final int OUT_LINE = 0;
	public static final int BUSY = 2;
	public int getStatue() {
		return statue;
	}

	public void setStatue(int statue) {
		this.statue = statue;
	}

}
