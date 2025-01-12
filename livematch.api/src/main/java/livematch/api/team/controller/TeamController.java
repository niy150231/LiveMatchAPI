package livematch.api.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import livematch.api.biz.team.model.TeamIO;
import livematch.api.biz.team.model.TeamSO;
import livematch.api.biz.team.model.TeamVO;
import livematch.api.biz.team.service.TeamService;
import livematch.api.constants.ApiResultConst;
import livematch.api.constants.ApiSystemConst;
import livematch.api.exception.BizException;
import livematch.api.model.ApiResVO;
import livematch.api.team.model.TeamReq;
import livematch.api.utils.APIVersionUtil;
import livematch.api.utils.CommonUtil;
import livematch.api.utils.LogoDownloader;
import livematch.api.utils.NasUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Project: livematch.api
 * Package: livematch.api.team.controller
 * File: TeamController.java
 * Date: 2025.01.8
 * Author: Bright
 * Desc: Team Controller
 */

@Slf4j
@RestController
public class TeamController {

	
	
	String apiVersion= APIVersionUtil.getApiVersion();	
    
	@Autowired TeamService service;
	@Autowired MessageSourceAccessor message;
	
	
	/**
	 * Author: Bright
	 * Date 2025.01.8
	 * Method: registerTeams
	 * @param req
	 * @param response
	 * @return
	 * Desc: Register Teams
	 */
	@RequestMapping(value="/api/{apiVersion}/registerteams", method=RequestMethod.POST)
	public ApiResVO registerTeams(@RequestBody TeamReq req, ApiResVO response) {
		

		
		/***************************
		 * Request Validation
		 ***************************/
		if(!req.getLeagueId().isEmpty()) {
		}
		
		String savePath = NasUtil.getUploadFilePath(req.getLeagueId()+"_"+req.getName());
		LogoDownloader.downloadAndSaveLogo(req.getLogo(),savePath);
		
		/***************************
		 * Request Process
		 ***************************/
		
		TeamIO io = new TeamIO();
		CommonUtil.copyBean(io, req);
		io.setLogo(savePath);

		this.service.registerTeams(io);
		
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
     * Method: getTeams
     * @param response
     * @return
     * Desc: get Teams
     */
	@RequestMapping(value="/api/{apiVersion}/getteams", method = RequestMethod.GET)
	public ApiResVO getTeams(ApiResVO response) {
		TeamSO so = new TeamSO();
		List <TeamVO> dataList =this.service.selectTeams(so);
		
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
