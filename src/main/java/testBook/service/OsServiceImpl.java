package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.OsDaoImpl;
import testBook.model.Os;

import java.util.List;

/**
 * Created by yasha on 23.02.2017.
 */
public class OsServiceImpl implements OsService {

    private OsDaoImpl osDao;


    public void setOsDao(OsDaoImpl osDao) {
        this.osDao = osDao;
    }

    public OsDaoImpl getOsDao() {
        return osDao;
    }

    @Override
    @Transactional
    public void addOs(Os os) {
        this.osDao.addOs(os);
    }

    @Override
    @Transactional
    public void updateOs(Os os) {
        this.osDao.updateOs(os);
    }

    @Override
    @Transactional
    public void removeOs(Long id) {
        this.osDao.removeOs(id);
    }

    @Override
    @Transactional
    public Os getOsById(Long id) {
        return this.osDao.getOsById(id);
    }

    @Override
    @Transactional
    public List<Os> listOs() {
        return this.osDao.listOs();
    }
}
