package livematch.api.constants;

public class ApiSystemConst {

	/*****************************
	 * Session Attribute
	 *****************************/
	public static final String LOG_METHOD_REQUEST = "Request";
	public static final String LOG_METHOD_REQUEST_HEADER = "Header";
	public static final String LOG_METHOD_RESPONSE = "Response";
	public static final String LOG_METHOD_BODY = "Body";
	
	
	/*****************************
	 * System
	 *****************************/
	public static final String SYSTEM_API = "LIVEMATCH_API";
	
	/*****************************
	 * Format
	 *****************************/
	public static final String FORMAT_JAVA_DATETIME = "yyyyMMddHHmmss";
	public static final String FORMAT_JAVA_MONTH = "yyyyMM";
	public static final String FORMAT_JAVA_DATE = "yyyyMMdd";
	public static final String FORMAT_JAVA_TIME = "HHmmss";

	public static final String FORMAT_ORACLE_DATETIME = "YYYYMMDDHH24MISS";
	public static final String FORMAT_ORACLE_DATE = "YYYYMMDD";
	public static final String FORMAT_ORACLE_TIME = "HH24MISS";

	public static final String FORMAT_VIEW_MONTH = "MM/yyyy";
	public static final String FORMAT_VIEW_DATE = "dd/MM/yyyy";
	public static final String FORMAT_VIEW_TIME = "HH24:MI:SS";
	public static final String FORMAT_VIEW_DATETIME = "dd/MM/yyyy HH24:MI:SS";

	/*********************************/
	
	/*********************************
	 * Bean Name
	 *********************************/
	/** EBM Config Bean Name */
	public static final String BEAN_NAME_CONFIG_LIVEMATCH = "livematchConfig";

	/***********************
	 * System Exception Code
	 ***********************/
	/** Defalut Error */
	public static final int SYSTEM_EXCEPTION_DEFAULT_ERROR = 500;
}
