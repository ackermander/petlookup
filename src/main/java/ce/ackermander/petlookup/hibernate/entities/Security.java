package ce.ackermander.petlookup.hibernate.entities;

public class Security {

	private Integer secureId;
	
	private String password;
	

	public Security() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getSecureId() {
		return secureId;
	}

	public void setSecureId(Integer secureId) {
		this.secureId = secureId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Security(String password) {
		super();
		this.password = password;
	}
	
}
