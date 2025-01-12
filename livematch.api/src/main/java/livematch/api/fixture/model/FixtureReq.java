package livematch.api.fixture.model;


import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class FixtureReq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1045129124472123613L;
	private String homeTeamId;
	private String awayTeamId;
	private String leagueId;
	private String matchDate;
	private String regDate;
}
