package livematch.api.biz.team.model;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 
 * @author Bright
 * - Desc: Team view Object
 * - File: TeamVO.java
 * - Date: 05.01.2025
 *
 */

@Data
public class TeamVO {
    
	

	@Length(max=2)
	@NotNull
	private String leagueId;
	private String name;
	private String logo;
	private String regDate;
}
