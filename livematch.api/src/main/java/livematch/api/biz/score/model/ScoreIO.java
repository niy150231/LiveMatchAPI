package livematch.api.biz.score.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ScoreIO implements Serializable {

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
