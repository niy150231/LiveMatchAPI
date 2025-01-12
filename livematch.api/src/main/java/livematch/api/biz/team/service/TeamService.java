package livematch.api.biz.team.service;

import java.util.List;

import livematch.api.biz.team.model.TeamIO;
import livematch.api.biz.team.model.TeamSO;
import livematch.api.biz.team.model.TeamVO;

/**
 * Project: livematch.api
 * Package: livematch.api.biz.team.service
 * File: TeamService.java
 * Date: 2025.01.8
 * Author: Bright
 * Desc: Team Service
 */
public interface TeamService {
	
	/**
	 * Author: Bright
	 * Date 2025.01.8
	 * @param io
	 * @return
	 * Desc: Register Teams
	 */
	int registerTeams(TeamIO io);
	/**
	 * Author: Bright
	 * Date 2025.01.8
	 * @param so
	 * @return
	 * Desc: Select List of Teams
	 */
	List <TeamVO> selectTeams(TeamSO so);

}
