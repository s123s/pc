package testBook.service;

import org.springframework.transaction.annotation.Transactional;
import testBook.dao.BookDaoImpl;
import testBook.model.Book;

import java.util.List;

/**
 * Created by yasha on 04.12.2016.
 */
public class BookServiceImpl implements BookService {

    private BookDaoImpl bookDao;


    public void setBookDao(BookDaoImpl bookDao) {
        this.bookDao = bookDao;
    }

    public BookDaoImpl getBookDao() {
        return bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDao.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        this.bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(Long id) {
        this.bookDao.removeBook(id);

    }

    @Override
    @Transactional
    public Book getBookById(long id) {
        return this.bookDao.getBookById(id);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        return this.bookDao.listBook();
    }

}


