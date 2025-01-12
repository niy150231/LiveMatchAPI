package livematch.api.resolver;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import livematch.api.constants.ApiResultConst;
import livematch.api.constants.ApiSystemConst;
import livematch.api.exception.BizException;
import livematch.api.model.ApiResVO;
import livematch.api.utils.CommonUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApiExceptionResolver {
	@Autowired MessageSourceAccessor message;
	
	@ExceptionHandler(value=Exception.class)
	public @ResponseBody ApiResVO exception (Exception ex) {
		
		ApiResVO result = new ApiResVO();

		String exCode = null;
		String exCodeMsg = null;
		String exMsg = null;
		/*****************************
		 * Exception Type Process
		 *****************************/
		if(ex instanceof BizException){
			log.debug("======================================");
			log.debug("= {}", "BizException");
			log.debug("======================================");

			BizException bizEx = (BizException)ex;
			exCode = bizEx.getExCode();
			exMsg = bizEx.getExMsg();

		} else if(ex instanceof HttpRequestMethodNotSupportedException) {
			log.debug("======================================");
			log.debug("= {}", "HttpRequestMethodNotSupportedException");
			log.debug("======================================");
			ex.printStackTrace();

			exCode = ApiResultConst.RESULT_REQUEST_METHOD_ERROR;

		} else if(ex instanceof HttpMessageNotReadableException) {
			log.debug("======================================");
			log.debug("= {}", "HttpMessageNotReadableException");
			log.debug("======================================");
			ex.printStackTrace();

			exCode = ApiResultConst.RESULT_REQUEST_BODY_ERROR;

		}else{
			log.debug("======================================");
			log.debug("= {}", "Etc Exception");
			log.debug("======================================");
			ex.printStackTrace();

			exCode = ApiResultConst.RESULT_DEFAULT_ERROR;
		}

		/*****************************
		 * Exception Response Process
		 *****************************/
		log.debug(">>>>>>>>>>>>> Code="+exCode);

		result.setResultCd(exCode);

		try {
			exCodeMsg = this.message.getMessage(ApiResultConst.RESULT_MESSAGE_BASE + exCode);
		}catch (Exception e) {
			log.debug("Message Error");
		}

		if(StringUtils.isNotBlank(exMsg)){
			exCodeMsg += exMsg;
		}

		result.setResultMsg(exCodeMsg);
		result.setResultDt(CommonUtil.getDate(ApiSystemConst.FORMAT_JAVA_DATETIME));

		
		return result;
	}
}
