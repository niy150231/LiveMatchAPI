package livematch.api.league.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import livematch.api.biz.league.model.LeagueIO;
import livematch.api.biz.league.model.LeagueSO;
import livematch.api.biz.league.model.LeagueVO;
import livematch.api.biz.league.service.LeagueService;
import livematch.api.constants.ApiResultConst;
import livematch.api.constants.ApiSystemConst;
import livematch.api.exception.BizException;
import livematch.api.league.model.LeagueReq;
import livematch.api.model.ApiResVO;
import livematch.api.utils.APIVersionUtil;
import livematch.api.utils.CommonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Project: livematch.api
 * Package: livematch.api.league.controller
 * File: LeagueController.java
 * Date: 2025.01.8
 * Author: Bright
 * Desc: Fixture Controller
 */
@Slf4j
@RestController
public class LeagueController {
	String apiVersion= APIVersionUtil.getApiVersion();	
    
	@Autowired LeagueService service;
	@Autowired MessageSourceAccessor message;
	
	
	/**
	 * Date 2025.01.8
	 * Method: createLeagues
	 * Author: Bright
	 * @param req
	 * @param response
	 * @return
	 * Desc: Register Leagues
	 */
	@RequestMapping(value="/api/{apiVersion}/createleagues", method=RequestMethod.POST)
	public ApiResVO createLeagues(@RequestBody LeagueReq req, ApiResVO response) {
		
		
		/***************************
		 * Request Validation
		 ***************************/
		if(!req.getLeagueId().isEmpty()) {
		}
		
		/*
		 * Valid - Data Check
		 */
//		if(!req.getLeagueId().isEmpty()) {
//		}
		
		
		/***************************
		 * Request Process
		 ***************************/
		
		LeagueIO io = new LeagueIO();
		CommonUtil.copyBean(io, req);

		this.service.registerLeagues(io);
		
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
     * Date 2025.01.8
     * Method: getLeagues
     * @param response
     * @return
     * Desc: Get Leagues
     */
	
	@RequestMapping(value="/api/{apiVersion}/getleagues", method = RequestMethod.GET)
	public ApiResVO getLeagues(ApiResVO response) {
		LeagueSO so = new LeagueSO();
		List <LeagueVO> dataList =this.service.selectLeagues(so);
		
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
