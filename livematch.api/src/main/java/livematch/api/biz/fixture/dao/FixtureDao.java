package livematch.api.biz.fixture.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import livematch.api.biz.fixture.model.FixtureIO;
import livematch.api.biz.fixture.model.FixtureSO;
import livematch.api.biz.fixture.model.FixtureVO;
import livematch.api.common.dao.LiveMatchAbstractDao;

/**
 * Project: livematch.api
 * Package: livematch.api.biz.fixture.dao
 * File: FixtureDao.java
 * Date: 2025.01.7
 * Author: Bright
 * Desc: Fixture Data Access
 */
@Repository
public class FixtureDao extends LiveMatchAbstractDao{

	
	private static final String PACKAGE_NAME = "livematch.fixture.data";
	
	public int insertLeague(FixtureIO io) {
		
		return insert(PACKAGE_NAME, "insertFixture", io);
	}
	
	public List <FixtureVO> selectLeagues (FixtureSO so){
		return selectList(PACKAGE_NAME, "selectFixtures", so);
		
	}
}
