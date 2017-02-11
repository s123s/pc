package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.WpDaoImpl;
import testBook.model.Wp;

import java.util.List;

/**
 * Created by yasha on 11.02.2017.
 */
public class WpServiceImpl implements WpService {
    private WpDaoImpl wpDao;

    public void setWpDao(WpDaoImpl wpDao) {
        this.wpDao = wpDao;
    }

    @Override
    @Transactional
    public List<Wp> listWp() {
        return this.wpDao.listWp();
    }
}
