package eu.supersede.integration.api.replan.optimizer.types;

public class Priority {

	private Integer level;
	private Integer score;

	public void setLevel(Integer level) {
		this.level = level;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getLevel() {
		return level;
	}

	public Integer getScore() {
		return score;
	}

}
