package livematch.api.biz.league.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import livematch.api.biz.league.dao.LeagueDao;
import livematch.api.biz.league.model.LeagueIO;
import livematch.api.biz.league.model.LeagueSO;
import livematch.api.biz.league.model.LeagueVO;


@Transactional
@Service("leagueService")
public class LeagueServiceImpl implements LeagueService{
    
	@Autowired private LeagueDao leaguedao;
	
	@Override
	public int registerLeagues(LeagueIO io) {
		// TODO Auto-generated method stub
		return this.leaguedao.insertLeague(io);
	}

	@Override
	public List<LeagueVO> selectLeagues(LeagueSO so) {
		// TODO Auto-generated method stub
		
		return this.leaguedao.selectLeagues(so);
	}



}
