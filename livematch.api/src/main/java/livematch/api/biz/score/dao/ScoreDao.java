package livematch.api.biz.score.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import livematch.api.biz.score.model.ScoreIO;
import livematch.api.biz.score.model.ScoreSO;
import livematch.api.biz.score.model.ScoreVO;
import livematch.api.common.dao.LiveMatchAbstractDao;

/**
 * Project: livematch.api
 * Package: livematch.api.biz.score.dao
 * File: ScoreDao.java
 * Date: 2025.01.7
 * Author: Bright
 * Desc: Score Data Access
 */
@Repository("scoreDao")
public class ScoreDao extends LiveMatchAbstractDao{

	
	private static final String PACKAGE_NAME = "livematch.score.data";
	
	public int insertScore(ScoreIO io) {
		
		return insert(PACKAGE_NAME, "insertScore", io);
	}
	
	public List <ScoreVO> selectScores (ScoreSO so){
		return selectList(PACKAGE_NAME, "selectScores", so);
		
	}
}
