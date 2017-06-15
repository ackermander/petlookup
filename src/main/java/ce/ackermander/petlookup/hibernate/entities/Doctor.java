package ce.ackermander.petlookup.hibernate.entities;

public class Doctor {
	private Integer doctorId;

	private String doctorName;
	private int doctorStatue;
	private String doctorPic;
	
	private Hospital hospital;
	
	

	public Doctor(String doctorName, int doctorStatue, String doctorPic, Hospital hospital) {
		super();
		this.doctorName = doctorName;
		this.doctorStatue = doctorStatue;
		this.doctorPic = doctorPic;
		this.hospital = hospital;
	}
	
	

	public Doctor(Integer doctorId, String doctorName, int doctorStatue, String doctorPic, Hospital hospital) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorStatue = doctorStatue;
		this.doctorPic = doctorPic;
		this.hospital = hospital;
	}



	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getDoctorPic() {
		return doctorPic;
	}

	public void setDoctorPic(String doctorPic) {
		this.doctorPic = doctorPic;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public static final int ON_LINE = 1;
	public static final int OUT_LINE = 0;
	public static final int BUSY = 2;

	public int getDoctorStatue() {
		return doctorStatue;
	}

	public void setDoctorStatue(int doctorStatue) {
		this.doctorStatue = doctorStatue;
	}

}
