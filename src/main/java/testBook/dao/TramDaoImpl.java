package testBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.Producer;
import testBook.model.Tram;

import java.util.List;

/**
 * Created by yasha on 24.02.2017.
 */
public class TramDaoImpl implements TramDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTram(Tram tram) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(tram);
    }

    @Override
    public void updateTram(Tram tram) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(tram);
    }

    @Override
    public void removeTram(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tram tram = (Tram) session.load(Tram.class, new Long(id));
        if(tram != null)
            session.delete(tram);
    }

    @Override
    public Tram getTramById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tram tram = (Tram) session.get(Tram.class, new Long(id));
        return tram;
    }

    @Override
    public List<Tram> listTram() {
        Session session = sessionFactory.getCurrentSession();
        List tramList = session.createQuery("from Tram").list();
        return tramList;
    }
}
