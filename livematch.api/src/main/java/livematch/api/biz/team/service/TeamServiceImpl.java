package livematch.api.biz.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import livematch.api.biz.team.dao.TeamDao;
import livematch.api.biz.team.model.TeamIO;
import livematch.api.biz.team.model.TeamSO;
import livematch.api.biz.team.model.TeamVO;


/**
 * Project: livematch.api
 * Package: livematch.api.biz.team.service
 * File: TeamServiceImpl.java
 * Date: 2025.01.8
 * Author: Bright
 * Desc: Team Service Implementation
 */

@Transactional
@Service("teamService")
public class TeamServiceImpl implements TeamService{

	@Autowired TeamDao teamdao;
	
	@Override
	public int registerTeams(TeamIO io) {
		// TODO Auto-generated method stub
		return this.teamdao.insertLeague(io);
	}

	@Override
	public List<TeamVO> selectTeams(TeamSO so) {
		// TODO Auto-generated method stub
		return this.teamdao.selectLeagues(so);
	}

}
