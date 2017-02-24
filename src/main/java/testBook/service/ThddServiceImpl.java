package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.ThddDaoImpl;
import testBook.model.Thdd;

import java.util.List;

/**
 * Created by yasha on 24.02.2017.
 */
public class ThddServiceImpl implements ThddService {

    private ThddDaoImpl thddDao;


    public void setThddDao(ThddDaoImpl thddDao) {
        this.thddDao = thddDao;
    }

    @Override
    @Transactional
    public void addThdd(Thdd thdd) {
        this.thddDao.addThdd(thdd);
    }

    @Override
    @Transactional
    public void updateThdd(Thdd thdd) {
        this.thddDao.updateThdd(thdd);
    }

    @Override
    @Transactional
    public void removeThdd(Long id) {
        this.thddDao.removeThdd(id);
    }

    @Override
    @Transactional
    public Thdd getThddById(Long id) {
        return this.thddDao.getThddById(id);
    }

    @Override
    @Transactional
    public List<Thdd> listThdd() {
        return this.thddDao.listThdd();
    }
}
