package livematch.api.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import livematch.api.constants.ApiResultConst;
import livematch.api.exception.BizException;


public class CommonUtil {
	
	
	/**
	 * <pre>
	 * - Method	: toUnCemelCase
	 * - Date	: 2025. 01. 7.
	 * - Author	: kdriv
	 * - Desc	: Camel To Original String
	 * </pre>
	 * @param str
	 * @return
	 */
	public static String toUnCemelCase(String str) {
		String regex = "([a-z])([A-Z])";
		String replacement = "$1_$2";
		String value = "";
		value = str.replaceAll(regex, replacement).toLowerCase();
		return value;
	}

	public static String getDate(String dateFormat) {

		DateFormat df = new SimpleDateFormat(dateFormat);

		Calendar calendar = Calendar.getInstance();

		return df.format(calendar.getTime());
	}
	
	
	public static Timestamp getTimestamp() {
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = formatter.format(cal.getTime());
		return Timestamp.valueOf(today);
	}

	
	public static void copyBean(Object dest, Object orig) {
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (Exception e) {
			throw new BizException(ApiResultConst.RESULT_DEFAULT_ERROR);
		}
	}
	
	public static String objectToJson(Object reqObj) throws Exception{
		ObjectMapper mapper = new ObjectMapper();

		String jsonStr = null;

		jsonStr = mapper.writeValueAsString(reqObj);

		return jsonStr;
	}
	

}
