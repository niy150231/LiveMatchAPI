package livematch.api.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import livematch.api.biz.score.model.ScoreIO;
import livematch.api.biz.score.model.ScoreSO;
import livematch.api.biz.score.model.ScoreVO;
import livematch.api.biz.score.service.ScoreService;
import livematch.api.constants.ApiResultConst;
import livematch.api.constants.ApiSystemConst;
import livematch.api.exception.BizException;
import livematch.api.model.ApiResVO;
import livematch.api.score.model.ScoreReq;
import livematch.api.utils.APIVersionUtil;
import livematch.api.utils.CommonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Project: livematch.api
 * Package: livematch.api.score.controller
 * File: ScoreController.java
 * Date: 2025.01.7
 * Author: Bright
 * Desc: Score Controller
 */

@Slf4j
@RestController
public class ScoreController {

	

	String apiVersion= APIVersionUtil.getApiVersion();	
    
	@Autowired ScoreService service;
	@Autowired MessageSourceAccessor message;
	
	
	/**
	 * Date 2025.01.7
	 * Method: registerScores
	 * Author: Bright
	 * @param req
	 * @param response
	 * @return
	 * Desc: registerScores
	 */
	@RequestMapping(value="/api/{apiVersion}/registerscores", method=RequestMethod.POST)
	public ApiResVO registerScores(@RequestBody ScoreReq req, ApiResVO response) {
		

		
		/***************************
		 * Request Validation
		 ***************************/


		
		/***************************
		 * Request Process
		 ***************************/
		
		ScoreIO io = new ScoreIO();
		CommonUtil.copyBean(io, req);


		this.service.registerScores(io);
		
		/***************************
		 * Response Process
		 ***************************/

		response.setResultCd(ApiResultConst.RESULT_DEFAULT_SUCCESS);
		response.setResultMsg(this.message.getMessage(ApiResultConst.RESULT_MESSAGE_BASE + ApiResultConst.RESULT_DEFAULT_SUCCESS));
		response.setResultDt(CommonUtil.getDate(ApiSystemConst.FORMAT_JAVA_DATETIME));

		return response;
	}
	
	
    /**
     * Author: Bright
     * Date 2025.01.7
     * Method: getTeams
     * @param response
     * @return
     * Desc: get Scores
     */
	@RequestMapping(value="/api/{apiVersion}/getscores", method = RequestMethod.GET)
	public ApiResVO getScores(ApiResVO response) {
		ScoreSO so = new ScoreSO();
		List <ScoreVO> dataList =this.service.selectScores(so);
		
		if(dataList.isEmpty()) {
			throw new BizException(ApiResultConst.RESULT_DEFAULT_SUCCESS_NO_SEARCH_RESULT);
		}
		response.setResultCd(ApiResultConst.RESULT_DEFAULT_SUCCESS);
		response.setResultMsg(this.message.getMessage(ApiResultConst.RESULT_MESSAGE_BASE + ApiResultConst.RESULT_DEFAULT_SUCCESS));
		response.setResultDt(CommonUtil.getDate(ApiSystemConst.FORMAT_JAVA_DATETIME));
		response.setData(dataList);
		
		return response;
	}
}
