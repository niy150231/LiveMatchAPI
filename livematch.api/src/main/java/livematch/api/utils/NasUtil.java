package livematch.api.utils;

import java.util.Properties;

import livematch.api.constants.ApiSystemConst;


public class NasUtil {

	public static String getAttachFilePath(String attachKind, String filePath) {

		Properties liveMatchConfig = (Properties)ContextUtil.getBean(ApiSystemConst.BEAN_NAME_CONFIG_LIVEMATCH);
		String realPath = liveMatchConfig.getProperty("nas.base.path") + "/" + attachKind + "/" + filePath;

		return realPath;
	}
	
	
	public static String getUploadFilePath(String fileName) {

		Properties liveMatchConfig = (Properties)ContextUtil.getBean(ApiSystemConst.BEAN_NAME_CONFIG_LIVEMATCH);
		String realPath = liveMatchConfig.getProperty("livematch.logo.path") + "/" + fileName+".png";

		return realPath;
	}
}
