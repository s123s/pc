package pc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pc.model.WpSummView;
import pc.dao.WpDao;

@Service
public class WpServiceImpl implements WpService {

	private WpDao wpDao;

	@Override
	public List<WpSummView> readAll() {
		return getWpDao().readAll();
	}

	public WpSummView read(Integer o) {
		return getWpDao().read(o);
	}


	public void update(WpSummView o) {
		getWpDao().update(o);
	}

	public int markDeleted(Integer k) {
		return getWpDao().markDeleted(k);
	}

	public WpDao getWpDao() {
		return wpDao;
	}

	public void setWpDao(WpDao wpDao) {
		this.wpDao = wpDao;
	}

}
