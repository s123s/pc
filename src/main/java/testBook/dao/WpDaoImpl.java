package testBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.Wp;

import java.util.List;

/**
 * Created by yasha on 11.02.2017.
 */
public class WpDaoImpl implements WpDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    public List<Wp> listWp(){
        Session session = sessionFactory.getCurrentSession();
        List wpList = session.createQuery("from Wp").list();
        /*ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("aa", "aa", 1));*/
        return wpList;
    }
}
