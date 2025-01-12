package livematch.api.biz.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import livematch.api.biz.score.dao.ScoreDao;
import livematch.api.biz.score.model.ScoreIO;
import livematch.api.biz.score.model.ScoreSO;
import livematch.api.biz.score.model.ScoreVO;



@Transactional
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{
	
	@Autowired ScoreDao fixturedao;

	@Override
	public int registerScores(ScoreIO io) {
		// TODO Auto-generated method stub
		return this.fixturedao.insertScore(io);
	}

	@Override
	public List<ScoreVO> selectScores(ScoreSO so) {
		// TODO Auto-generated method stub
		return this.fixturedao.selectScores(so);
	}

}
