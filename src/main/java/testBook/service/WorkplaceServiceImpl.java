package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.WorkplaceDaoImpl;
import testBook.model.Workplace;

import java.util.List;

/**
 * Created by yasha on 14.03.2017.
 */
public class WorkplaceServiceImpl implements WorkplaceService {

    private WorkplaceDaoImpl workplaceDao;


    public void setWorkplaceDao(WorkplaceDaoImpl workplaceDao) {
        this.workplaceDao = workplaceDao;
    }

    public WorkplaceDaoImpl getWorkplaceDao() {
        return workplaceDao;
    }


    @Override
    @Transactional
    public void addWorkplace(Workplace workplace) {
        this.workplaceDao.addWorkplace(workplace);
    }

    @Override
    @Transactional
    public void updateWorkplace(Workplace workplace) {
        this.workplaceDao.updateWorkplace(workplace);
    }

    @Override
    @Transactional
    public void removeWorkplace(Long id) {
        this.workplaceDao.removeWorkplace(id);
    }

    @Override
    @Transactional
    public Workplace getWorkplaceById(Long id) {
        return this.workplaceDao.getWorkplaceById(id);
    }

    @Override
    @Transactional
    public List<Workplace> listWorkplace() {
        return this.workplaceDao.listWorkplace();
    }
}
