package livematch.api.biz.league.model;

import lombok.Data;
import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
/**
 * 
 * @author Bright
 * - Desc: League Value Object
 * - File: LeagueVO.java
 * - Date: 05.01.2025
 *
 */
@Data
public class LeagueVO implements Serializable{
	
	private static final long serialVersionUID = -7329852279130821016L;

	@Length(max=2)
	@NotNull
	private String leagueId;
	
	private String name;
	private String country;
	private String regDate;
	

}
