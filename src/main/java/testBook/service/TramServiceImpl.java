package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.TramDaoImpl;
import testBook.model.Tram;

import java.util.List;

/**
 * Created by yasha on 24.02.2017.
 */
public class TramServiceImpl implements TramService {
    private TramDaoImpl tramDao;
    public void setTramDao(TramDaoImpl tramDao) {
        this.tramDao = tramDao;
    }

    @Override
    @Transactional
    public void addTram(Tram tram) {
        this.tramDao.addTram(tram);
    }

    @Override
    @Transactional
    public void updateTram(Tram tram) {
        this.tramDao.updateTram(tram);
    }

    @Override
    @Transactional
    public void removeTram(Long id) {
        this.tramDao.removeTram(id);
    }

    @Override
    @Transactional
    public Tram getTramById(Long id) {
        return  this.tramDao.getTramById(id);
    }

    @Override
    @Transactional
    public List<Tram> listTram() {
        return this.tramDao.listTram();
    }
}
