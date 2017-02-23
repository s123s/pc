package testBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.Os;

import java.util.List;

/**
 * Created by yasha on 23.02.2017.
 */
public class OsDaoImpl implements OsDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addOs(Os os) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(os);
    }

    @Override
    public void updateOs(Os os) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(os);
    }

    @Override
    public void removeOs(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Os os = (Os) session.load(Os.class, new Long(id));
        if(os != null)
            session.delete(os);
    }

    @Override
    public Os getOsById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Os os = (Os) session.get(Os.class, new Long(id));
        return os;
    }

    @Override
    public List<Os> listOs() {
        Session session = sessionFactory.getCurrentSession();
        List osList = session.createQuery("from Os").list();
        return osList;
    }
}
