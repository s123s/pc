package testBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.Autor;

import java.util.List;

/**
 * Created by yasha on 10.12.2016.
 */
// TODO replace old fashioned hibernate with Spring Data JPA
public class AutorDaoImpl implements AutorDao {

private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAutor(Autor autor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(autor);
    }

    @Override
    public void updateAutor(Autor autor) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(autor);

    }

    @Override
    public void removeAutor(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Autor autor = (Autor) session.load(Autor.class, new Long(id));
        if(autor != null)
            session.delete(autor);
    }

    @Override
    public Autor getAutorById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Autor autor = (Autor) session.get(Autor.class, new Long(id));
        return autor;
    }

    @Override
    public List<Autor> listAutor() {
        Session session = sessionFactory.getCurrentSession();
        List autorList = session.createQuery("from Autor").list();
        return autorList;
    }
}
