package livematch.api.biz.league.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import livematch.api.biz.league.model.LeagueIO;
import livematch.api.biz.league.model.LeagueSO;
import livematch.api.biz.league.model.LeagueVO;
import livematch.api.common.dao.LiveMatchAbstractDao;
import livematch.api.model.PageSO;

/**
 * Project: livematch.api
 * Package: livematch.api.biz.league.dao
 * File: LeagueDao.java
 * Date: 2025.01.8
 * Author: Bright
 * Desc: League Data Access
 */
@Repository("leagueDao")
public class LeagueDao extends LiveMatchAbstractDao {
	
	private static final String PACKAGE_NAME = "livematch.league.data";
	
	public int insertLeague(LeagueIO io) {
		
		return insert(PACKAGE_NAME, "insertLeague", io);
	}
	
	public List <LeagueVO> selectLeagues (LeagueSO so){
		return selectList(PACKAGE_NAME, "selectLeagues", so);
		
	}

}
