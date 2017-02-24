package testBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.Thdd;

import java.util.List;

/**
 * Created by yasha on 24.02.2017.
 */
public class ThddDaoImpl implements ThddDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addThdd(Thdd thdd) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(thdd);
    }

    @Override
    public void updateThdd(Thdd thdd) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(thdd);
    }

    @Override
    public void removeThdd(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Thdd thdd = (Thdd) session.load(Thdd.class, new Long(id));
        if(thdd != null)
            session.delete(thdd);
    }

    @Override
    public Thdd getThddById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Thdd thdd = (Thdd) session.get(Thdd.class, new Long(id));
        return thdd;
    }

    @Override
    public List<Thdd> listThdd() {
        Session session = sessionFactory.getCurrentSession();
        List thddList = session.createQuery("from Tram").list();
        return thddList;
    }
}
