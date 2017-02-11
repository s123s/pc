package testBook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import testBook.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yasha on 04.12.2016.
 */
public class BookDaoImpl implements BookDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    public void addBook(Book book){
        Session session= this.sessionFactory.getCurrentSession();
        session.persist(book);
    }

    @Override
    public void updateBook(Book book){
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
    }

    @Override
    public void removeBook(Long id){
        Session session=this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Long(id));
        if(book != null)
            session.delete(book);
    }

    @Override
    public Book getBookById(Long id){
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.get(Book.class, new Long(id));
        return book;
    }
    @Override
    public List<Book> listBook(){
        Session session = sessionFactory.getCurrentSession();
        List bookList = session.createQuery("from Book").list();
        /*ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("aa", "aa", 1));*/
        return bookList;
    }
}
