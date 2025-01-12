package livematch.api.biz.team.model;

import java.io.Serializable;

import lombok.Data;


@Data
public class TeamIO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6372630569279209581L;
	private String leagueId;
	private String name;
	private String logo;
	private Long regDate;
}
