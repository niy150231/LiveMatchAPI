package livematch.api.biz.team.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import livematch.api.biz.team.model.TeamIO;
import livematch.api.biz.team.model.TeamSO;
import livematch.api.biz.team.model.TeamVO;
import livematch.api.common.dao.LiveMatchAbstractDao;

/**
 * Project: livematch.api
 * Package: livematch.api.biz.team.dao
 * File: TeamDao.java
 * Date: 2025.01.8
 * Author: Bright
 * Desc: Team Data Access
 */

@Repository("teamDao")
public class TeamDao extends LiveMatchAbstractDao{
	
	private static final String PACKAGE_NAME = "livematch.team.data";
	
	public int insertLeague(TeamIO io) {
		
		return insert(PACKAGE_NAME, "insertTeam", io);
	}
	
	public List <TeamVO> selectLeagues (TeamSO so){
		return selectList(PACKAGE_NAME, "selectTeams", so);
		
	}

}
