package ce.ackermander.petlookup.hibernate.entities;

public class PetPicture {
	private Integer picId;
	
	private String picURL;

	public Integer getPicId() {
		return picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}

	public String getPicURL() {
		return picURL;
	}

	public void setPicURL(String picURL) {
		this.picURL = picURL;
	}

	public PetPicture(String picURL) {
		super();
		this.picURL = picURL;
	}

	public PetPicture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
