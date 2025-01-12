package livematch.api.biz.score.model;

import lombok.Data;
import java.io.Serializable;

import javax.validation.constraints.NotNull;
/**
 * 
 * @author Bright
 * - Desc: Score Value Object
 * - File: ScoreVO.java
 * - Date: 05.01.2025
 *
 */

@Data
public class ScoreVO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 4585171866209874391L;
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
