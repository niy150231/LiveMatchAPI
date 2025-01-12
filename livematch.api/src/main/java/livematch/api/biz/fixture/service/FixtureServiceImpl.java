package livematch.api.biz.fixture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import livematch.api.biz.fixture.model.FixtureIO;
import livematch.api.biz.fixture.model.FixtureSO;
import livematch.api.biz.fixture.model.FixtureVO;
import livematch.api.biz.fixture.dao.FixtureDao;

@Transactional
@Service("fixtureService")
public class FixtureServiceImpl implements FixtureService{
	
	@Autowired FixtureDao fixturedao;

	@Override
	public int registerFixtures(FixtureIO io) {
		// TODO Auto-generated method stub
		return this.fixturedao.insertLeague(io);
	}

	@Override
	public List<FixtureVO> selectFixtures(FixtureSO so) {
		// TODO Auto-generated method stub
		return this.fixturedao.selectLeagues(so);
	}

}
