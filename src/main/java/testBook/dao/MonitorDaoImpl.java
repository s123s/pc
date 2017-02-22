package testBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.Monitor;

import java.util.List;

/**
 * Created by yasha on 22.02.2017.
 */
public class MonitorDaoImpl implements MonitorDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addMonitor(Monitor monitor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(monitor);
    }

    @Override
    public void updateMonitor(Monitor monitor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(monitor);
    }

    @Override
    public void removeMonitor(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Monitor monitor = (Monitor) session.load(Monitor.class, new Long(id));
        if(monitor != null)
            session.delete(monitor);
    }

    @Override
    public Monitor getMonitorById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Monitor monitor  = (Monitor) session.get(Monitor .class, new Long(id));
        return monitor;
    }

    @Override
    public List<Monitor> listMonitor() {
        Session session = sessionFactory.getCurrentSession();
        List monitorList = session.createQuery("from Monitor").list();
        return monitorList;
    }
}
