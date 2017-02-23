package testBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.Ups;

import java.util.List;

/**
 * Created by yasha on 23.02.2017.
 */
public class UpsDaoImpl implements UpsDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addUps(Ups ups) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(ups);
    }

    @Override
    public void updateUps(Ups ups) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(ups);
    }

    @Override
    public void removeUps(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Ups ups = (Ups) session.load(Ups.class, new Long(id));
        if(ups != null)
            session.delete(ups);
    }

    @Override
    public Ups getUpsById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Ups ups = (Ups) session.get(Ups.class, new Long(id));
        return ups;
    }

    @Override
    public List<Ups> listUps() {
        Session session = sessionFactory.getCurrentSession();
        List upsList = session.createQuery("from Ups").list();
        return upsList;
    }
}
