package testBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.Computer;

import java.util.List;

/**
 * Created by yasha on 21.02.2017.
 */
public class ComputerDaoImpl implements ComputerDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addComputer(Computer computer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(computer);
    }

    @Override
    public void updateComputer(Computer computer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(computer);

    }

    @Override
    public void removeComputer(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Computer computer = (Computer) session.load(Computer.class, new Long(id));
        if(computer != null)
            session.delete(computer);
    }

    @Override
    public Computer getComputerById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Computer computer = (Computer) session.get(Computer.class, new Long(id));
        return computer;
    }

    @Override
    public List<Computer> listComputer() {
        Session session = sessionFactory.getCurrentSession();
        List computerList = session.createQuery("from Computer").list();
        return computerList;
    }
}
