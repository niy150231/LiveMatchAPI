package livematch.api.biz.fixture.model;
import lombok.Data;
import java.io.Serializable;
import lombok.Data;
/**
 * 
 * @author Bright
 * - Desc: Fixture Value Object
 * - File: FixtureVO.java
 * - Date: 05.01.2025
 *
 */


@Data
public class FixtureVO implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 7485230263326950094L;
	
	private String homeTeamId;
	private String awayTeamId;
	private String leagueId;
	private String matchDate;
	private String regDate;
	

}
