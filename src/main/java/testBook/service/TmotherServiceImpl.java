package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.TmotherDaoImpl;
import testBook.model.Tmother;

import java.util.List;

/**
 * Created by yasha on 24.02.2017.
 */
public class TmotherServiceImpl implements TmotherService {
    private TmotherDaoImpl tmotherDao;
    public void setTmotherDao(TmotherDaoImpl tmotherDao) {
        this.tmotherDao = tmotherDao;
    }

    @Override
    @Transactional
    public void addTmother(Tmother tmother) {
        this.tmotherDao.addTmother(tmother);
    }

    @Override
    @Transactional
    public void updateTmother(Tmother tmother) {
        this.tmotherDao.updateTmother(tmother);
    }

    @Override
    @Transactional
    public void removeTmother(Long id) {
        this.tmotherDao.removeTmother(id);
    }

    @Override
    @Transactional
    public Tmother getTmotherById(Long id) {
        return  this.tmotherDao.getTmotherById(id);
    }

    @Override
    @Transactional
    public List<Tmother> listTmother() {
        return  this.tmotherDao.listTmother();
    }
}
