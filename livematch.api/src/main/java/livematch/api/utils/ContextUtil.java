package livematch.api.utils;

import org.springframework.context.ApplicationContext;

import livematch.api.context.ApplicationContextProvider;


public class ContextUtil {
	
	/**
	 * <pre>
	 * - Method	: getBean
	 * - Date	: 2025. 01. 7.
	 * - Author	: Bright
	 * - Desc	: Context Bean With Bean Id
	 * </pre>
	 * @param beanId
	 * @return
	 */
	public static Object getBean(String beanId){
		ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();

		return applicationContext.getBean(beanId);
	}


	/**
	 * <pre>
	 * - Method	: getBean
	 * - Date	: 2019. 6. 14.
	 * - Author	: Bright
	 * - Desc	: Context Bean With Class
	 * </pre>
	 * @param cls
	 * @return
	 */
	public static <T> T getBean(Class<T> cls) {
		ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();

		return applicationContext.getBean(cls);
	}


}
