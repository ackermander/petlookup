package ce.ackermander.petlookup.hibernate.entities;

import java.util.Date;
import java.util.Set;

public class Mission {
	private Integer missionId;
	//过期时间
	private Date expiredTime;
	private Date createTime;
	private String missionDescription;
	private int award;

	private Set<Remember> proposers;
	private Set<Remember> participators;
	

	public Mission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Remember> getParticipators() {
		return participators;
	}

	public void setParticipators(Set<Remember> participators) {
		this.participators = participators;
	}

	public Set<MissionPicture> getMispics() {
		return mispics;
	}

	public void setMispics(Set<MissionPicture> mispics) {
		this.mispics = mispics;
	}

	private Set<MissionPicture> mispics;

	public Set<Remember> getProposers() {
		return proposers;
	}

	public void setProposers(Set<Remember> proposers) {
		this.proposers = proposers;
	}

	public Date getExpiredTime() {
		return expiredTime;
	}

	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}

	public Integer getMissionId() {
		return missionId;
	}

	public void setMissionId(Integer missionId) {
		this.missionId = missionId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMissionDescription() {
		return missionDescription;
	}

	public void setMissionDescription(String missionDescription) {
		this.missionDescription = missionDescription;
	}

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}

}
