package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.MonitorDaoImpl;
import testBook.model.Monitor;

import java.util.List;

/**
 * Created by yasha on 22.02.2017.
 */
public class MonitorServiceImpl implements MonitorService {


    private MonitorDaoImpl monitorDao;


    public void setMonitorDao(MonitorDaoImpl monitorDao) {
        this.monitorDao = monitorDao;
    }

    public MonitorDaoImpl getMonitorDao() {
        return monitorDao;
    }

    @Override
    @Transactional
    public void addMonitor(Monitor monitor) {
        this.monitorDao.addMonitor(monitor);
    }

    @Override
    @Transactional
    public void updateMonitor(Monitor monitor) {
        this.monitorDao.updateMonitor(monitor);
    }

    @Override
    @Transactional
    public void removeMonitor(Long id) {
        this.monitorDao.removeMonitor(id);
    }

    @Override
    @Transactional
    public Monitor getMonitorById(Long id) {
            return this.monitorDao.getMonitorById(id);
    }

    @Override
    @Transactional
    public List<Monitor> listMonitor() {
        return this.monitorDao.listMonitor();
    }
}
