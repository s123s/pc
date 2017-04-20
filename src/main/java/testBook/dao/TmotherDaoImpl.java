package testBook.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.Tmother;

import java.util.List;

/**
 * Created by yasha on 24.02.2017.
 */
public class TmotherDaoImpl implements TmotherDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTmother(Tmother tmother) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(tmother);
    }

    @Override
    public void updateTmother(Tmother tmother) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(tmother);
    }

    @Override
    public void removeTmother(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tmother tmother = (Tmother) session.load(Tmother.class, new Long(id));
        if (tmother != null)
            session.delete(tmother);
    }

    @Override
    public Tmother getTmotherById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tmother tmother = (Tmother) session.get(Tmother.class, new Long(id));
        return tmother;
    }

    @Override
    public List<Tmother> listTmother() {
        Session session = sessionFactory.getCurrentSession();
        List tmotherList = session.createQuery("from Tmother").list();
        return tmotherList;
    }


    /*public List<Tmother> listMotherNotComp() {
        Session session = sessionFactory.getCurrentSession();
        List motherNotComp = session.createQuery("FROM Tmother tm where tm.id not in (SELECT tm.id from Mother m)").list();
        return motherNotComp;*/
    public  List<Tmother> listMotherNotComp(){
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("SELECT * FROM type_mother where id_type_mother not in ( select id_mother from mother)");
        query.addEntity(Tmother.class);
        List results = query.list();
        return results;

    }
    }

