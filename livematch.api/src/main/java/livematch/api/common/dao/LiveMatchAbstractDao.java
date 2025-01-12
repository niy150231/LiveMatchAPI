package livematch.api.common.dao;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import livematch.api.constants.ApiSystemConst;
import livematch.api.exception.SystemException;
import livematch.api.model.PageSO;
import livematch.api.utils.CommonUtil;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class LiveMatchAbstractDao {


	@Autowired private SqlSessionTemplate SqlSessionTemplate;

	@Autowired private Properties livematchConfig;


	/**
	 * <pre>
	 * - Method	: selectList
	 * - Date	: 2025. 01. 7.
	 * - Author	: Bright
	 * - Desc	: List Data Query
	 * </pre>
	 * @param packageName
	 * @param queryId
	 * @param so
	 * @return
	 */
	protected <E> List<E> selectList(String packageName, String queryId, PageSO<?> so) {
		log.info("======================================");
		log.info("= {}", packageName + "." + queryId);
		log.info("======================================");

		if(so != null){

			/*
			 * Search Object Trim
			 */
			if(so != null) {
				try {
					Class<?> cls = so.getClass();
					Field[] fields = cls.getDeclaredFields();
					String fieldValue = "";
					for(Field field : fields) {
						field.setAccessible(true);
						if(field.getType() == String.class) {
							fieldValue = (String)field.get(so);
							if(StringUtils.isNotBlank(fieldValue)) {

								field.set(so, fieldValue.trim());
							}
						}
					}
				} catch (Exception e) {
					throw new SystemException(ApiSystemConst.SYSTEM_EXCEPTION_DEFAULT_ERROR);
				}
			}

			if(StringUtils.isNotBlank(so.getSidx())){
				so.setSidx(CommonUtil.toUnCemelCase(so.getSidx()).toUpperCase());
			}

			if(StringUtils.isNotBlank(so.getSord())){
				so.setSord(so.getSord().toUpperCase());
			}
		}

		return this.SqlSessionTemplate.selectList(packageName + "." + queryId, so);
	}

	/**
	 * <pre>
	 * - Method	: selectList
	 * - Date	: 2025. 01. 7.
	 * - Author	: Bright
	 * - Desc	: List Data Query
	 * </pre>
	 * @param packageName
	 * @param queryId
	 * @param so
	 * @return
	 */
	protected <E> List<E> selectList(String packageName, String queryId, Object so) {
		log.info("======================================");
		log.info("= {}", packageName + "." + queryId);
		log.info("======================================");

		/*
		 * Search Object Trim
		 */
		if(so != null) {
			try {
				Class<?> cls = so.getClass();
				Field[] fields = cls.getDeclaredFields();
				String fieldValue = "";
				for(Field field : fields) {
					field.setAccessible(true);
					if(field.getType() == String.class) {
						fieldValue = (String)field.get(so);
						if(StringUtils.isNotBlank(fieldValue)) {

							field.set(so, fieldValue.trim());
						}
					}
				}
			} catch (Exception e) {
				throw new SystemException(ApiSystemConst.SYSTEM_EXCEPTION_DEFAULT_ERROR);
			}
		}

		return this.SqlSessionTemplate.selectList(packageName + "." + queryId, so);
	}

	/**
	 * <pre>
	 * - Method	: selectOne
	 * - Date	: 2025. 01. 7.
	 * - Author	: Bright
	 * - Desc	: One Data Query
	 * </pre>
	 * @param packageName
	 * @param queryId
	 * @param parameter
	 * @return
	 */
	protected <T> T selectOne(String packageName, String queryId, Object parameter) {
		log.info("======================================");
		log.info("= {}", packageName + "." + queryId);
		log.info("======================================");
		return this.SqlSessionTemplate.selectOne(packageName + "." + queryId, parameter);
	}

	/**
	 * <pre>
	 * - Method	: insert
	 * - Date	: 2025. 1. 07.
	 * - Author	: Bright
	 * - Desc	: Insert Query
	 * </pre>
	 * @param packageName
	 * @param queryId
	 * @param parameter
	 * @return
	 */
	protected int insert(String packageName, String queryId, Object parameter) {

		log.info("======================================");
		log.info("= {}", packageName + "." + queryId);
		log.info("======================================");

		/*
		 * Parameter Object Trim
		 */
		try {
			Class<?> cls = parameter.getClass();
			Field[] fields = cls.getDeclaredFields();
			String fieldValue = "";
			for(Field field : fields) {
				field.setAccessible(true);
				if(field.getType() == String.class) {
					fieldValue = (String)field.get(parameter);
					if(StringUtils.isNotBlank(fieldValue)) {

						field.set(parameter, fieldValue.trim());
					}
				}
			}
		} catch (Exception e) {
			throw new SystemException(ApiSystemConst.SYSTEM_EXCEPTION_DEFAULT_ERROR);
		}



		return this.SqlSessionTemplate.insert(packageName + "." + queryId, parameter);
	}

	/**
	 * <pre>
	 * - Method	: delete
	 * - Date	: 2025. 01. 7.
	 * - Author	: Bright
	 * - Desc	: Delete Query
	 * </pre>
	 * @param packageName
	 * @param queryId
	 * @param parameter
	 * @return
	 */
	protected int delete(String packageName, String queryId, Object parameter) {

		log.info("======================================");
		log.info("= {}", packageName + "." + queryId);
		log.info("======================================");
		return this.SqlSessionTemplate.delete(packageName + "." + queryId, parameter);
	}

}
