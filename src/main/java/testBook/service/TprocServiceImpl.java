package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.TprocDaoImpl;
import testBook.model.Tproc;

import java.util.List;

/**
 * Created by yasha on 24.02.2017.
 */
public class TprocServiceImpl implements TprocService {
    private TprocDaoImpl tprocDao;
    public void setTprocDao(TprocDaoImpl tprocDao) {
        this.tprocDao = tprocDao;
    }

    @Override
    @Transactional
    public void addTproc(Tproc tproc) {
        this.tprocDao.addTproc(tproc);
    }

    @Override
    @Transactional
    public void updateTproc(Tproc tproc) {
        this.tprocDao.updateTproc(tproc);
    }

    @Override
    @Transactional
    public void removeTproc(Long id) {
        this.tprocDao.removeTproc(id);
    }

    @Override
    @Transactional
    public Tproc getTprocById(Long id) {
        return  this.tprocDao.getTprocById(id);
    }

    @Override
    @Transactional
    public List<Tproc> listTproc() {
        return this.tprocDao.listTproc();
    }
}

