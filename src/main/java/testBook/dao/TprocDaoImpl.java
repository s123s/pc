package testBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.Producer;
import testBook.model.Tproc;

import java.util.List;

/**
 * Created by yasha on 24.02.2017.
 */
public class TprocDaoImpl implements TprocDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTproc(Tproc tproc) {
        Session session = this.sessionFactory.getCurrentSession();
        tproc.setProducer((Producer) session.load(Producer.class, tproc.getProducer().getId()));
        session.persist(tproc);
    }

    @Override
    public void updateTproc(Tproc tproc) {
        Session session = this.sessionFactory.getCurrentSession();
        tproc.setProducer((Producer) session.load(Producer.class, tproc.getProducer().getId()));
        session.update(tproc);
    }

    @Override
    public void removeTproc(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tproc tproc = (Tproc) session.load(Tproc.class, new Long(id));
        if(tproc != null)
            tproc.setProducer(null);
            session.delete(tproc);
    }

    @Override
    public Tproc getTprocById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tproc tproc = (Tproc) session.get(Tproc.class, new Long(id));
        return tproc;
    }

    @Override
    public List<Tproc> listTproc() {
        Session session = sessionFactory.getCurrentSession();
        List tprocList = session.createQuery("from Tproc").list();
        return tprocList;
    }
}
