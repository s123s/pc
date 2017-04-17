package testBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.Workplace;

import java.util.List;

/**
 * Created by yasha on 14.03.2017.
 */
public class WorkplaceDaoImpl implements WorkplaceDao {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addWorkplace(Workplace workplace) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(workplace);
    }

    @Override
    public void updateWorkplace(Workplace workplace) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(workplace);
    }

    @Override
    public void removeWorkplace(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Workplace workplace = (Workplace) session.load(Workplace.class, new Long(id));
        if(workplace != null)
            session.delete(workplace);
    }

    @Override
    public Workplace getWorkplaceById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Workplace workplace = (Workplace) session.get(Workplace.class, new Long(id));
        return workplace;
    }

    @Override
    public List<Workplace> listWorkplace() {
        Session session = sessionFactory.getCurrentSession();
        List workplaceList = session.createQuery("from Workplace").list();
        return workplaceList;
    }
}
