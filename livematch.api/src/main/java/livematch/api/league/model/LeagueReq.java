package livematch.api.league.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
public class LeagueReq implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5201892639391323874L;

	@Length(max=2)
	@NotNull
	private String leagueId;
	
	private String name;
	private String country;
	private String regDate;
	
}
