package livematch.api.biz.score.service;

import java.util.List;

import livematch.api.biz.score.model.ScoreIO;
import livematch.api.biz.score.model.ScoreSO;
import livematch.api.biz.score.model.ScoreVO;


/**
 * Project: livematch.api
 * Package: livematch.api.biz.score.service
 * File: ScoreService.java
 * Date: 2025.01.7
 * Author: Bright
 * Desc: Score Service
 */

public interface ScoreService {
	/**
	 * Author: Bright
	 * Date 2025.01.7
	 * @param io
	 * @return
	 * Desc: Register Scores
	 */
	int registerScores(ScoreIO io);
	/**
	 * Author: Bright
	 * Date 2025.01.7
	 * @param so
	 * @return
	 * Desc: Select List of Scores
	 */
	List <ScoreVO> selectScores (ScoreSO so);
}
