package ce.ackermander.petlookup.hibernate.entities;

public class Judgement {
	private Integer judgeId;

	private String opinion;
	private int viewpoint;
	
	private Remember checkRem;//待审核人员
	private Remember judgeRem;//审核人员

	

	public Remember getCheckRem() {
		return checkRem;
	}

	public void setCheckRem(Remember checkRem) {
		this.checkRem = checkRem;
	}

	public Remember getJudgeRem() {
		return judgeRem;
	}

	public void setJudgeRem(Remember judgeRem) {
		this.judgeRem = judgeRem;
	}

	public Integer getJudgeId() {
		return judgeId;
	}

	public void setJudgeId(Integer judgeId) {
		this.judgeId = judgeId;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public int getViewpoint() {
		return viewpoint;
	}

	public void setViewpoint(int viewpoint) {
		this.viewpoint = viewpoint;
	}

}
