package livematch.api.fixture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import livematch.api.biz.fixture.model.FixtureIO;
import livematch.api.biz.fixture.model.FixtureSO;
import livematch.api.biz.fixture.model.FixtureVO;
import livematch.api.biz.fixture.service.FixtureService;
import livematch.api.constants.ApiResultConst;
import livematch.api.constants.ApiSystemConst;
import livematch.api.exception.BizException;
import livematch.api.fixture.model.FixtureReq;
import livematch.api.model.ApiResVO;
import livematch.api.utils.APIVersionUtil;
import livematch.api.utils.CommonUtil;
import livematch.api.utils.LogoDownloader;
import livematch.api.utils.NasUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Project: livematch.api
 * Package: livematch.api.fixture.controller
 * File: FixtureController.java
 * Date: 2025.01.7
 * Author: Bright
 * Desc: Fixture Controller
 */
@Slf4j
@RestController
public class FixtureController {

	
	String apiVersion= APIVersionUtil.getApiVersion();	
    
	@Autowired FixtureService service;
	@Autowired MessageSourceAccessor message;
	
	
	/**
	 * Date 2025.01.7
	 * Method: createLeagues
	 * Author: Bright
	 * @param req
	 * @param response
	 * @return
	 * Desc: Register Fixtures
	 */
	@RequestMapping(value="/api/{apiVersion}/registerfixtures", method=RequestMethod.POST)
	public ApiResVO registerfixtures(@RequestBody FixtureReq req, ApiResVO response) {
		

		
		/***************************
		 * Request Validation
		 ***************************/
//		if(!req.getLeagueId().isEmpty()) {
//		}
		
		/***************************
		 * Request Process
		 ***************************/
		
		FixtureIO io = new FixtureIO();
		CommonUtil.copyBean(io, req);


		this.service.registerFixtures(io);
		
		/***************************
		 * Response Process
		 ***************************/
		response.setResultCd(ApiResultConst.RESULT_DEFAULT_SUCCESS);
		response.setResultMsg(this.message.getMessage(ApiResultConst.RESULT_MESSAGE_BASE + ApiResultConst.RESULT_DEFAULT_SUCCESS));
		response.setResultDt(CommonUtil.getDate(ApiSystemConst.FORMAT_JAVA_DATETIME));

		return response;
	}
	
	
	/**
	 * Date 2025.01.7
	 * Method: getFixtures
	 * Author: Bright
	 * @param req
	 * @param response
	 * @return
	 * Desc: get Fixtures
	 */
	
	@RequestMapping(value="/api/{apiVersion}/getfixtures", method = RequestMethod.GET)
	public ApiResVO getFixtures(ApiResVO response) {
		FixtureSO so = new FixtureSO();
		List <FixtureVO> dataList =this.service.selectFixtures(so);
		
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
