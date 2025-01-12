package livematch.api.biz.fixture.service;

import java.util.List;

import livematch.api.biz.fixture.model.FixtureIO;
import livematch.api.biz.fixture.model.FixtureSO;
import livematch.api.biz.fixture.model.FixtureVO;


/**
 * Project: livematch.api
 * Package: livematch.api.fixture.service
 * File: FixtureService.java
 * Date: 2025.01.7
 * Author: Bright
 * Desc: Fixture Service
 */
public interface FixtureService {
    
	/**
	 * Author: Bright
	 * Date 2025.01.7
	 * @param io
	 * @return
	 * Desc: Register Fixtures
	 */
	int registerFixtures(FixtureIO io);
	/**
	 * Author: Bright
	 * Date 2025.01.7
	 * @param so
	 * @return
	 * Desc: Select List of Fixtures
	 */
	List <FixtureVO> selectFixtures (FixtureSO so);
	
}
