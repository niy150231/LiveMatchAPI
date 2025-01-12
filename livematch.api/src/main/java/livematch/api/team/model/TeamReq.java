package livematch.api.team.model;

import java.io.Serializable;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class TeamReq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3011771446214435927L;
	
	private String leagueId;
	private String name;
	private String logo;
	private Long regDate;
	
}
