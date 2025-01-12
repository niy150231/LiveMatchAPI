package livematch.api.biz.fixture.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Data
public class FixtureIO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3725191518758653186L;
	private String homeTeamId;
	private String awayTeamId;
	private String leagueId;
	private String matchDate;
	private String regDate;
}
