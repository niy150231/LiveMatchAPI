package livematch.api.biz.league.service;

import java.util.List;

import livematch.api.biz.league.model.LeagueIO;
import livematch.api.biz.league.model.LeagueSO;
import livematch.api.biz.league.model.LeagueVO;

/**
 * Project: livematch.api
 * Package: livematch.api.league.service
 * File: LeagueService.java
 * Date: 2025.01.8
 * Author: Bright
 * Desc: League Service
 */
public interface LeagueService {
    
	/**
	 * Author: Bright
	 * Date 2025.01.8
	 * @param io
	 * @return
	 * Desc: Register Leagues
	 */
	int registerLeagues(LeagueIO io);
	/**
	 * Author: Bright
	 * Date 2025.01.8
	 * @param so
	 * @return
	 * Desc: Select List of leagues
	 */
	List <LeagueVO> selectLeagues (LeagueSO so);
	
}
