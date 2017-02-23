package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.UpsDaoImpl;
import testBook.model.Ups;

import java.util.List;

/**
 * Created by yasha on 23.02.2017.
 */
public class UpsServiceImpl implements UpsService {


    private UpsDaoImpl upsDao;


    public void setUpsDao(UpsDaoImpl upsDao) {
        this.upsDao = upsDao;
    }

    public UpsDaoImpl getUpsDao() {
        return upsDao;
    }

    @Override
    @Transactional
    public void addUps(Ups ups) {
        this.upsDao.addUps(ups);
    }

    @Override
    @Transactional
    public void updateUps(Ups ups) {
        this.upsDao.updateUps(ups);
    }

    @Override
    @Transactional
    public void removeUps(Long id) {
        this.upsDao.removeUps(id);
    }

    @Override
    @Transactional
    public Ups getUpsById(Long id) {
        return this.upsDao.getUpsById(id);
    }

    @Override
    @Transactional
    public List<Ups> listUps() {
        return this.upsDao.listUps();
    }
}
