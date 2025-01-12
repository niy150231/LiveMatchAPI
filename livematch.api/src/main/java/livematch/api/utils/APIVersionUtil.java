package livematch.api.utils;

import java.util.Properties;

import livematch.api.constants.ApiSystemConst;


public class APIVersionUtil {

	
	
	public static String getApiVersion() {

		Properties liveMatchConfig = (Properties)ContextUtil.getBean(ApiSystemConst.BEAN_NAME_CONFIG_LIVEMATCH);
		String version= liveMatchConfig.getProperty("livematch.api.version");

		return version;
	}

}
