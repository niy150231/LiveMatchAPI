package livematch.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;

import livematch.api.biz.league.model.LeagueIO;
import livematch.api.constants.ApiResultConst;
import livematch.api.constants.ApiSystemConst;
import livematch.api.utils.CommonUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Bright
 * Desc		: API Result Object
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ApiResVO implements Serializable {
	

	/** Result Code */
	private String	resultCd;

	/** Result message */
	private String	resultMsg;

	/** Result Date */
	private String 	resultDt;

	/** Result Data */
	private Object	data = null;

}
