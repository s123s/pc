package testBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.User;

import java.util.List;

/**
 * Created by yasha on 22.02.2017.
 */
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void removeUser(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Long(id));
        if(user != null)
            session.delete(user);
    }

    @Override
    public User getUserById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, new Long(id));
        return user;
    }

    @Override
    public List<User> listUser() {
        Session session = sessionFactory.getCurrentSession();
        List userList = session.createQuery("from User").list();
        return userList;
    }
}
