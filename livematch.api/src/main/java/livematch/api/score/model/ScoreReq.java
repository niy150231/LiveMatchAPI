package livematch.api.score.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ScoreReq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5124847377746145597L;
	@NotNull
	private String goalTime;
	@NotNull
	private String goalScorerFirstName;
	@NotNull
	private String goalScorerLastName;
	@NotNull
	private int teamId;
	@NotNull
	private int fixtureId;
	private String regDate;
}
