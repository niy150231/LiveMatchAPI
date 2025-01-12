package livematch.api.biz.league.model;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @author Bright
 * Desc: League Insert Object
 */
@Data
public class LeagueIO implements Serializable{

	private static final long serialVersionUID = 8574716979936652850L;
	private String leagueId;
	private String name;
	private String country;
	private String regDate;

}
